package com.valen.lark.admin.auth;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Reference;
import com.valen.lark.bean.system.SysPermission;
import com.valen.lark.bean.system.SysRole;
import com.valen.lark.bean.system.SysUser;
import com.valen.lark.bean.system.SysUserRole;
import com.valen.lark.iservice.system.ISysRoleService;
import com.valen.lark.iservice.system.ISysUserRoleService;
import com.valen.lark.iservice.system.ISysUserService;
import com.valen.lark.utils.CommonTool;

/**
 * @author fengling
 * @create 2019-5-3
 * @Description 自定义的AuthRealm实现认证。
 */
public class AuthRealm extends AuthorizingRealm{
    
	@Reference(version = "1.0.0")
    private ISysUserService userSV;

	@Reference(version = "1.0.0")
    private ISysRoleService RoleSV;	

		
	
    //用户信息的认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //创建用户token
    	UsernamePasswordToken utoken=(UsernamePasswordToken) authenticationToken;
        String opName = utoken.getUsername();
        
        //查找用户对象
        //opName=CommonTool.decoderBase64(opName);
        SysUser user = userSV.getSysUserByLoginName(opName);
       
        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());
    }
    
    //用户的授权方法处理
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
    	//获取登录用户名
       // String OpName= (String) principal.getPrimaryPrincipal();
   
        
    	SysUser user=(SysUser)principal.fromRealm(this.getClass().getName()).iterator().next();
     	String OpName = user.getOpName();
    	//角色名称集合
    	Set<Integer> roleIds = new HashSet<Integer>();
    	//权限对象集合
    	List<SysPermission> permiss = new ArrayList<SysPermission>();
    	List<String> permissions=new ArrayList<String>();    
    	
    	//根据操作员名查询当前用户拥有的角色
    	List<SysRole> roles = userSV.getSysUserRoleByOpName(OpName);
        if(roles.size()>0) {
            for(SysRole role : roles) {
            	roleIds.add(role.getRoleId()); 
            	
				try {
					permiss = RoleSV.qrySysPermissionbyRoleId(role.getRoleId());
				} catch (NoSuchAlgorithmException e) {
					
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				}
				
                if(permiss.size()>0) {
                    for(SysPermission permi : permiss) {
                        permissions.add(String.valueOf(permi.getPrivId()));
                    }
                }
            }
        }
        //将权限集合提供给单个授权对象
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
      //将权限放入shiro中
        info.addStringPermissions(permissions);
        return info;
    }
}