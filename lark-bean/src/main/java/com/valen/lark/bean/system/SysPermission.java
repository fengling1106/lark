package com.valen.lark.bean.system;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author fengling
 * @create 2019-5-2
 * @Description 系统权限
 */
public class SysPermission implements Serializable {
	private static final long serialVersionUID = 300002019050204L;
	private int privId;
	private Byte privType;	
	private String privName;
	private byte state;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private String remark;

	public void setPrivId(int privId)	
	{
		this.privId =  privId;
	}
	public int getPrivId()
	{
		return this.privId;
	}	
	
	public void setPrivType(Byte privType)	
	{
		this.privType =  privType;
	}
	public int getPrivType()
	{
		return this.privType;
	}		
	
	public String getPrivName()
	{	
		return this.privName;
	}
	public void setPrivName(String privName)
	{
		this.privName =privName;
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
