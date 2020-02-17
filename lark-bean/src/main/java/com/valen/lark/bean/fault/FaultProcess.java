package com.valen.lark.bean.fault;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * <p>Title: FaultProcess</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2019年7月16日
 */

public class FaultProcess implements Serializable {
	private static final long serialVersionUID = 300002019071601L;
	
	private long        serNbr;
	private long 	    faultId ;
	private Timestamp   processTime;
	private String      processInfo;
	private int         processUser;
	private byte        state;               
	private int         opId;  	
	private Timestamp   createDate;         
	private Timestamp   modifyDate;                      
	private String      remark; 

	public void setSerNbr(long serNbr)	
	{
		this.serNbr =  serNbr;
	}
	public long getSerNbr()
	{
		return this.serNbr;
	}	
	
	public void setFaultId(long faultId)	
	{
		this.faultId =  faultId;
	}
	public long getFaultId()
	{
		return this.faultId;
	}
	
	public void setProcessTime(Timestamp processTime)	
	{
		this.processTime =  processTime;
	}
	public Timestamp getProcessTime()
	{
		return this.processTime;
	}		
	
	public void setProcessInfo(String processInfo)	
	{
		this.processInfo =  processInfo;
	}
	public String getProcessInfo()
	{
		return this.processInfo;
	}	

	public void setProcessUser(int processUser)	
	{
		this.processUser =  processUser;
	}
	public int getProcessUser()
	{
		return this.processUser;
	}		
	
	
	public void setState(byte state)	
	{
		this.state =  state;
	}
	public byte getState()
	{
		return this.state;
	}		
	
	
	public void setOpId(int opId)	
	{
		this.opId =  opId;
	}
	public int getOpId()
	{
		return this.opId;
	}	
	
	//
	public void setCreateDate(Timestamp createDate)	
	{
		this.createDate =  createDate;
	}
	public Timestamp getCreateDate()
	{
		return this.createDate;
	}	

	//
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
