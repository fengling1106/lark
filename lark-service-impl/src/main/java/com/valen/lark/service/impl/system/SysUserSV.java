package com.valen.lark.service.impl.system;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valen.lark.bean.system.SysRole;
import com.valen.lark.bean.system.SysUser;
//import com.valen.lark.bean.work.WorkRecord;
import com.valen.lark.dao.system.ISysUserDAO;
import com.valen.lark.iservice.system.ISysUserService;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
//@Transactional
public class SysUserSV implements ISysUserService {
   	
	//private static Log log = LogFactory.getLog(WorkRecord.class);
		
	@Autowired
	ISysUserDAO userDao ; 
	
	public boolean regUser(SysUser user) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		//检查用户名是否唯一
		
		//检查邮箱是否唯一
		
		//注册新用户
		user.setState((byte)1);//设置用户为待邮件确认状态
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		user.setModifyDate(user.getCreateDate());
		userDao.create(user);
		return true;
    }
	
	public SysUser loginSystem(String userName, String userPasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException	
	{
		try{
	    	Map<String, Object> map=new HashMap<String, Object>();
			map.put("opName", "\'"+userName+"\'");
			map.put("passWord", "\'"+userPasswd+"\'");	
			
			SysUser user=userDao.checkSysUserByNameAndPwd(map);
			
			if(null != user && 1==user.getState())
			{
				return user;
			}
			else{
				return null;
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
			
		}
			
	}

	public SysUser getSysUserByLoginName(String userName) {
    	Map<String, Object> map=new HashMap<String, Object>();
		map.put("opName", "\'"+userName+"\'");
		
		SysUser temp = userDao.getSysUserByOpName(map);
		System.out.println("resutl="+temp.getOpId()+":"+temp.getOpName());
        return temp;
		//return null;
	}
	
	public List<SysUser> getUserMatchUserName(String userName) {
    	Map<String, Object> map=new HashMap<String, Object>();
		map.put("opName", "\'"+userName+"\'");
		
		List<SysUser> users=userDao.getSysUserMatchOpName(map);
		
		return users;
	}	
	
	
	public int isExistSysUserByOpName(String opName)
	{
    	Map<String, Object> map=new HashMap<String, Object>();
		map.put("opName", "\'"+opName+"\'");
		return userDao.checkSysUserIsExistByOpName(opName);
	}
	
	public List<SysUser> getUsersAll() {
    	
		List<SysUser> users=userDao.getSysUserAll();

		return users;
	}

	public List<SysRole> getSysUserRoleByOpName(String opName) {
    	Map<String, Object> map=new HashMap<String, Object>();
		map.put("opName", "\'"+opName+"\'");
		List<SysRole> roles=userDao.getSysUserRoleByOpName(map);
		return roles;
	}	
}
