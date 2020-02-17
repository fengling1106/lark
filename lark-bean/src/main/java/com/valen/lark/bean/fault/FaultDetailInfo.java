package com.valen.lark.bean.fault;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * <p>Title: FaultDetailInfo</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2019年7月16日
 */
public class FaultDetailInfo implements Serializable {
	private static final long serialVersionUID = 300002019071701L;
	private String 	    faultId ;
	private String      faultDate;
	private String      faultReporter;
	private String      faultReporterPhone;	
	private String      faultSystem;	
	private String      faultModule;		
	private String      faultTitle;
	private String      faultDesc;           
	private String        faultGrade;         
	private String        faultType;          
	private Timestamp   faultGenTime;      
	private Timestamp   faultRecoverTime;  
	private String     isFault;            
	private String        procesSts;          
	private String      dealDept;
	private String      dealMan;	
	private String      genSite;  
	private String 	    eventId; 	
	private String      reason;   
	private String      recoder; 	
	private byte        state;               
	private int         opId;  	
	private Timestamp   createDate;         
	private Timestamp   modifyDate;                      
	private String      remark;              
	
	public void setFaultId(String faultId)	
	{
		this.faultId =  faultId;
	}
	public String getFaultId()
	{
		return this.faultId;
	}	

    //
	public void setfaultDate(String faultDate)	
	{
		this.faultDate =  faultDate;
	}
	public String getfaultDate()
	{
		return this.faultDate;
	}	
    //
	public void setFaultReporter(String faultReporter)	
	{
		this.faultReporter =  faultReporter;
	}
	public String getFaultReporter()
	{
		return this.faultReporter;
	}	
    //
	public void setFaultReporterPhone(String faultReporterPhone)	
	{
		this.faultReporterPhone =  faultReporterPhone;
	}
	public String getFaultReporterPhone()
	{
		return this.faultReporterPhone;
	}	
    //
	public void setFaultSystem(String faultSystem)	
	{
		this.faultSystem =  faultSystem;
	}
	public String getFaultSystem()
	{
		return this.faultSystem;
	}	
    //
	public void setFaultModule(String faultModule)	
	{
		this.faultModule =  faultModule;
	}
	public String getFaultModule()
	{
		return this.faultModule;
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
	public void setFaultGrade(String faultGrade)	
	{
		this.faultGrade =  faultGrade;
	}
	public String getFaultGrade()
	{
		return this.faultGrade;
	}		

	//
	public void setFaultType(String faultType)	
	{
		this.faultType =  faultType;
	}
	public String getFaultType()
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
	public void setIsFault(String isFault)	
	{
		this.isFault =  isFault;
	}
	public String getIsFault()
	{
		return this.isFault;
	}	
	
	//
	public void setProcessSts(String procesSts)	
	{
		this.procesSts =  procesSts;
	}
	public String getProcessSts()
	{
		return this.procesSts;
	}	
	
	//
	public void setDealDept(String dealDept)	
	{
		this.dealDept =  dealDept;
	}
	public String getDealDept()
	{
		return this.dealDept;
	}	
	
	//
	public void setDealMan(String dealMan)	
	{
		this.dealMan =  dealMan;
	}
	public String getDealMan()
	{
		return this.dealMan;
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
	public void setEventId(String eventId)	
	{
		this.eventId =  eventId;
	}
	public String getEventId()
	{
		return this.eventId;
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
	public void setRecoder(String recoder)	
	{
		this.recoder =  recoder;
	}
	public String getRecoder()
	{
		return this.recoder;
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
                            
