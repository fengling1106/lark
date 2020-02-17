package com.valen.lark.bean.system;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author fengling
 * @create 2019-5-2
 * @Description 系统用户的角色
 */
public class SysUserRole implements Serializable {
	private static final long serialVersionUID = 300002019050203L;
	private int userId;  //即opId
	private int roleId;
	private byte state;
	private int opId;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private String remark;

	public void setUserId(int userId)	
	{
		this.userId =  userId;
	}
	public int getUserId()
	{
		return this.userId;
	}	
	
	public void setOpId(int opId)	
	{
		this.opId =  opId;
	}
	public int getOpId()
	{
		return this.opId;
	}		
	
	public void setRoleId(int roleId)	
	{
		this.roleId =  roleId;
	}
	public int getRoleId()
	{
		return this.roleId;
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
