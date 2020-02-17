package com.valen.lark.bean.system;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author fengling
 * @create 2019-5-2
 * @Description 系统角色
 */
public class SysRole implements Serializable {
	private static final long serialVersionUID = 300002019050201L;
	private int roleId;
	private String roleName;
	private byte state;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private String remark;

	public void setRoleId(int roleId)	
	{
		this.roleId =  roleId;
	}
	public int getRoleId()
	{
		return this.roleId;
	}	
	
	public String getRoleName()
	{	
		return this.roleName;
	}
	public void setRoleName(String roleName)
	{
		this.roleName =roleName;
	}	
	
	public void setState(byte state)	
	{
		this.state =  state;
	}
	public int getState()
	{
		return this.state;
	}
	
	public void setCreateDate(Timestamp createDate)
	{
		this.createDate =  createDate;
	}
	public Timestamp getCreateDate()
	{
		return this.createDate;
	}

	public void setModifyDate(Timestamp modifyDate)
	{
		this.modifyDate =  modifyDate;
	}
	public Timestamp getModifyDate()
	{
		return this.modifyDate;
	}
	
	public void setRemark(String remark)	
	{
		this.remark =  remark;
	}
	public String getRemark()
	{
		return this.remark;
	}		
	
}
