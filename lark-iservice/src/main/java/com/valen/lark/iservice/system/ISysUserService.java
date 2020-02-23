package com.valen.lark.iservice.system;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.valen.lark.bean.system.SysRole;
import com.valen.lark.bean.system.SysUser;


/**
 * @author fengling
 * @create 2017-11-23
 * @Description User表service层访问接口
 */

public interface ISysUserService {
		
	//新用户注册
	public boolean regUser(SysUser user) throws NoSuchAlgorithmException, UnsupportedEncodingException	;
	
    //用户登录
	public SysUser loginSystem(String opName, String passWord) throws NoSuchAlgorithmException, UnsupportedEncodingException	;
	
	//获取操作员信息
	public  SysUser getSysUserByLoginName(String opName);
	
	//检查操作员名称是否存在
	public int isExistSysUserByOpName(String opName);
	
	//根据用户名模糊查询用户
	public  List<SysUser> getUserMatchUserName(String opName);	
	
	//获取所有用户信息
	public  List<SysUser> getUsersAll();
	
	//获取操作员拥有的角色
	public  List<SysRole> getSysUserRoleByOpName(String opName);	
	
}
