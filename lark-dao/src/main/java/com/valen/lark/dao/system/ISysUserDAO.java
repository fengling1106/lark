package com.valen.lark.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.valen.lark.bean.system.SysRole;
import com.valen.lark.bean.system.SysUser;
import com.valen.lark.dao.BaseDAO;

/**
 * @author fengling
 * @create 2017-11-23
 * @Description User表dao访问接口
 */
@Mapper
@Repository
public interface ISysUserDAO extends BaseDAO<SysUser> {
	
	//根据登录名获取用户信息
	public SysUser getSysUserByOpName(Map<String, Object> hashMap);	

	//根据用户名模糊匹配查询
	public List<SysUser> getSysUserMatchOpName(Map<String, Object> hashMap);	
	
	//查询所有的用户信息
	public List<SysUser> getSysUserAll();
	
	//检查用户名是否存在
	public int checkSysUserIsExistByOpName(String opName);	
	
	//根据用户名和密码检查
	public SysUser checkSysUserByNameAndPwd(Map<String, Object> hashMap);	
	
	//获取操作员拥有的角色
	public List<SysRole> getSysUserRoleByOpName(Map<String, Object> hashMap);
	
}
