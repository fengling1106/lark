package com.valen.lark.bean.system;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author fengling
 * @create 2019-5-2
 * @Description 系统角色授权
 */
public class SysRoleGrant implements Serializable {
	private static final long serialVersionUID = 300002019050202L;
	private int  roleId;
	private byte privType;
	private int  privId;
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
	
	public void setPrivType(byte privType)	
	{
		this.privType =  privType;
	}
	public int getPrivType()
	{
		return this.privType;
	}
	
	public void setPrivId(int privId)	
	{
		this.privId =  privId;
	}
	public int getPrivId()
	{
		return this.privId;
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
