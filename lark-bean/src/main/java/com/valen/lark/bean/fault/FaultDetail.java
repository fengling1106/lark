package com.valen.lark.bean.fault;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * <p>Title: FaultDetailInfo</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2019年7月16日
 */
public class FaultDetail implements Serializable {
	private static final long serialVersionUID = 300002019071701L;
	private String 	    faultId ;
	private String      faultDate;
	private String      faultReporter;
	private String      reporterPhone;	
	private String      systemName;	
	private String      systemModule;		
	private String      faultTitle;
	private String      faultDesc;           
	private String      faultGrade;         
	private String      faultType;          
	private Timestamp   startTime;      
	private Timestamp   endTime;  
	private boolean     isFault;            
	private byte        procesSts;          
	private String      dealDept;
	private String      dealMan;	
	private String      genSite;  
	private String 	    eventId; 	
	private String      reason;   
	private String      recorder; 	
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
	public void setReporterPhone(String reporterPhone)	
	{
		this.reporterPhone =  reporterPhone;
	}
	public String getReporterPhone()
	{
		return this.reporterPhone;
	}	
    //
	public void setSystemName(String systemName)	
	{
		this.systemName =  systemName;
	}
	public String getFaultSystem()
	{
		return this.systemName;
	}	
    //
	public void setSystemModule(String systemModule)	
	{
		this.systemModule =  systemModule;
	}
	public String getFaultModule()
	{
		return this.systemModule;
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
	public void setStartTime(Timestamp startTime)	
	{
		this.startTime =  startTime;
	}
	public Timestamp getStartTime()
	{
		return this.startTime;
	}	
	
	//
	public void setEndTime(Timestamp endTime)	
	{
		this.endTime =  endTime;
	}
	public Timestamp getEndTime()
	{
		return this.endTime;
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
	public void setRecorder(String recorder)	
	{
		this.recorder =  recorder;
	}
	public String getRecorder()
	{
		return this.recorder;
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
                            
