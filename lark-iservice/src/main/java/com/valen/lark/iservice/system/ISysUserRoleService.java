package com.valen.lark.iservice.system;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.valen.lark.bean.system.SysRole;
import com.valen.lark.bean.system.SysUserRole;




/**
 * @author fengling
 * @create 2019-5-2
 * @Description 系统用户的角色接口定义
 */

public interface ISysUserRoleService {
	
	//创建新角色
	public boolean createSysUserRole(SysUserRole userRole) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
    //查询用户的角色
	public SysUserRole qrySysUserRolebyOpName(String OpName) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
    //查询用户的角色
	public List<SysUserRole> qrySysUserRolebyUserID(String userId) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
