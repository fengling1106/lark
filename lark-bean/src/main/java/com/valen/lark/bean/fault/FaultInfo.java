package com.valen.lark.bean.fault;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * <p>Title: FaultInfo</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2019年7月16日
 */
public class FaultInfo implements Serializable {
	private static final long serialVersionUID = 300002019071001L;
	private long 	    faultId ;
	private int  	    faultUserId;
	private String      faultTitle;
	private String      faultDesc;           
	private byte        faultGrade;         
	private byte        faultType;          
	private Timestamp   faultGenTime;      
	private Timestamp   faultRecoverTime;  
	private boolean     isFault;            
	private byte        procesSts;          
	private String      dept;                
	private String      genSite;            
	private String      reason;    
	private byte        state;               
	private int         opId;  	
	private Timestamp   createDate;         
	private Timestamp   modifyDate;                      
	private String      remark;              
	
	public void setFaultId(long faultId)	
	{
		this.faultId =  faultId;
	}
	public long getFaultId()
	{
		return this.faultId;
	}	

    //
	public void setFaultUserId(int faultUserId)	
	{
		this.faultUserId =  faultUserId;
	}
	public int getFaultUserId()
	{
		return this.faultUserId;
	}
	
	//
	public void setFaultTitle(String faultTitle)	
	{
		this.faultTitle =  faultTitle;
	}
	public String getFaultTitle()
	{
		return this.faultTitle;
	}	

	//
	public void setFaultDesc(String faultDesc)	
	{
		this.faultDesc =  faultDesc;
	}
	public String getFaultDesc()
	{
		return this.faultDesc;
	}	
	
	//
	public void setFaultGrade(byte faultGrade)	
	{
		this.faultGrade =  faultGrade;
	}
	public byte getFaultGrade()
	{
		return this.faultGrade;
	}		

	//
	public void setFaultType(byte faultType)	
	{
		this.faultType =  faultType;
	}
	public byte getFaultType()
	{
		return this.faultType;
	}	
	//
	public void setFaultGenTime(Timestamp faultGenTime)	
	{
		this.faultGenTime =  faultGenTime;
	}
	public Timestamp getFaultGenTime()
	{
		return this.faultGenTime;
	}	
	
	//
	public void setFaultRecoverTime(Timestamp faultRecoverTime)	
	{
		this.faultRecoverTime =  faultRecoverTime;
	}
	public Timestamp getFaultRecoverTime()
	{
		return this.faultRecoverTime;
	}	
	
	//
	public void setIsFault(boolean isFault)	
	{
		this.isFault =  isFault;
	}
	public boolean getIsFault()
	{
		return this.isFault;
	}	
	
	//
	public void setProcessSts(byte procesSts)	
	{
		this.procesSts =  procesSts;
	}
	public byte getProcessSts()
	{
		return this.procesSts;
	}	
	
	//
	public void setDept(String dept)	
	{
		this.dept =  dept;
	}
	public String getDept()
	{
		return this.dept;
	}		
	//
	public void setGenSite(String genSite)	
	{
		this.genSite =  genSite;
	}
	public String getGenSite()
	{
		return this.genSite;
	}		
	
	//
	public void setReason(String reason)	
	{
		this.reason =  reason;
	}
	public String getReason()
	{
		return this.reason;
	}	

	//
	public void setState(byte state)	
	{
		this.state =  state;
	}
	public byte getState()
	{
		return this.state;
	}		
	
	//
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
                            
