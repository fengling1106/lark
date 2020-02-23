package com.valen.lark.iservice.system;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.valen.lark.bean.system.SysPermission;
import com.valen.lark.bean.system.SysRole;




/**
 * @author fengling
 * @create 2019-5-2
 * @Description 系统角色接口定义
 */

public interface ISysRoleService {
	
	//创建新角色
	public boolean createRole(SysRole role) throws NoSuchAlgorithmException, UnsupportedEncodingException	;
	
    //查询角色
	public SysRole qrySysRolebyName(String roleName) throws NoSuchAlgorithmException, UnsupportedEncodingException	;
	
    //查询角色
	public SysRole qrySysRolebyId(String roleId) throws NoSuchAlgorithmException, UnsupportedEncodingException	;

    //查询角色拥有的权限
	public List<SysPermission> qrySysPermissionbyRoleId(int roleId) throws NoSuchAlgorithmException, UnsupportedEncodingException	;
		
}
