package com.valen.lark.bean.system;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author fengling
 * @create 2019-3-17
 * @Description 系统用户模型
 */
public class SysUser implements Serializable {
	private static final long serialVersionUID = 300002017060101L;
	private int opId;
	private String opName;
	private String password;
	private int orgId;	
	private byte state;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private String remark;

	public void setOpId(int opId)	
	{
		this.opId =  opId;
	}
	public int getOpId()
	{
		return this.opId;
	}	
	

	public void setOpName(String opName)
	{
		this.opName=opName;
	}	
	
	public String getOpName()
	{	
		return this.opName;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	public void setPasswd(String password)
	{
		this.password=password ;
	}	
	
	
	public void setState(byte state)	
	{
		this.state =  state;
	}
	public int getState()
	{
		return this.state;
	}
	
	public void setOrgId(int orgId)	
	{
		this.orgId =  orgId;
	}
	public int getOrgId()
	{
		return this.orgId;
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
