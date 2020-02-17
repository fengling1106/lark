package com.valen.lark.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.valen.lark.bean.system.SysPermission;
import com.valen.lark.bean.system.SysRole;
import com.valen.lark.dao.BaseDAO;

/**
 * @author fengling
 * @create 2019-5-2
 * @Description SYS_ROLE表dao访问接口
 */
@Mapper
@Repository
public interface ISysRoleDAO extends BaseDAO<SysRole> {
	
	//根据登录名获取用户信息
	public SysRole getSysRoleById(Map<String, Object> hashMap);	

	//根据用户名模糊匹配查询
	public List<SysRole> getSysRoleMatchName(Map<String, Object> hashMap);	
	
    //查询所有的用户信息
	public List<SysRole> getSysUserAll();
	
	//通过角色ID，获取角色拥有的权限
	public List<SysPermission> getPermissionByRoleId(int roleId);	
	
}
