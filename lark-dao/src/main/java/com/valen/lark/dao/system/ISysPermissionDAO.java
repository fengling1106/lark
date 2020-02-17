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
 * @Description SYS_Permisson表dao访问接口
 */
@Mapper
@Repository
public interface ISysPermissionDAO extends BaseDAO<SysRole> {
	
	//根据权限ID获取权限
	public SysPermission getSysPermissionById(Map<String, Object> hashMap);	

	//根据权限名称获取权限
	public List<SysPermission> getSysPermissionMatchName(Map<String, Object> hashMap);	
	
	//查询所有的权限
	public List<SysPermission> getSysPermissionAll();
	
}
