package com.valen.lark.service.impl.system;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.valen.lark.bean.system.SysRole;
import com.valen.lark.bean.system.SysUserRole;
import com.valen.lark.dao.system.ISysUserRoleDAO;
import com.valen.lark.iservice.system.ISysUserRoleService;

@Service(version = "1.0.0")
public class SysUserRoleSV implements ISysUserRoleService {

	@Autowired
	ISysUserRoleDAO userRoleDao ;
	
	public boolean createSysUserRole(SysUserRole userRole)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return false;
	}

	public SysUserRole qrySysUserRolebyName(String userName)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SysUserRole> qrySysUserRolebyUserID(String userId) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		List<SysUserRole> userRoles = null;
		try{
	    	Map<String, Object> map=new HashMap<String, Object>();
			map.put("userId", "\'"+userId+"\'");
			userRoles = userRoleDao.getSysUserRoleByUserId(map);
		}
		catch (Exception e){
			return null;
		}

		return userRoles;
	}

	public List<SysRole> qrySysRolesbyOpName(String OpName) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		List<SysRole> roles = null;
		try{
	    	Map<String, Object> map=new HashMap<String, Object>();
			map.put("loginName", "\'"+OpName+"\'");
			roles = userRoleDao.getSysRolesByLoginName(map);
		}
		catch (Exception e){
			return null;
		}

		return roles;
	}

	public SysUserRole qrySysUserRolebyOpName(String OpName)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
