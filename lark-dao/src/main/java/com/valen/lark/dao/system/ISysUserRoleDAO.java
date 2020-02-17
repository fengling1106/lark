package com.valen.lark.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.valen.lark.bean.system.SysRole;
import com.valen.lark.bean.system.SysUserRole;
import com.valen.lark.dao.BaseDAO;

/**
 * @author fengling
 * @create 2019-5-2
 * @Description SYS_USER_ROLE表dao访问接口
 */
@Mapper
@Repository
public interface ISysUserRoleDAO extends BaseDAO<SysUserRole> {
	
	//根据用户名模糊匹配查询角色关系
	public List<SysUserRole> getSysUserRoleByUserId(Map<String, Object> hashMap);	

	//根据用户名模糊匹配查询用户的角色
	public List<SysRole> getSysRolesByLoginName(Map<String, Object> hashMap);		
	
}
