package com.valen.lark.service.impl.system;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.valen.lark.bean.system.SysPermission;
import com.valen.lark.bean.system.SysRole;
import com.valen.lark.dao.system.ISysRoleDAO;
import com.valen.lark.iservice.system.ISysRoleService;

@Service(version = "1.0.0")
public class SysRoleSV  implements ISysRoleService {

	@Autowired
	ISysRoleDAO roleDao ; 
	
	public boolean createRole(SysRole role) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return false;
	}

	public SysRole qrySysRolebyName(String roleName) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}

	public SysRole qrySysRolebyId(String roleId) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SysPermission> qrySysPermissionbyRoleId(int roleId)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		return roleDao.getPermissionByRoleId(roleId);
	}
	

}
