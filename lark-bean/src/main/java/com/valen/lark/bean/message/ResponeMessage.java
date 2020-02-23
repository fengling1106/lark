/**  
* <p>Title: ResponeMessage.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: valen.com</p>  
* @author fengling  
* @date 2020年2月20日  
* @version 1.0  
*/  
package com.valen.lark.bean.message;

import java.io.Serializable;

/**
 * <p>Title: ResponeMessage</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2020年2月20日
 */
public class ResponeMessage implements Serializable {
	private static final long serialVersionUID = 300002020022104L;
	//消息头
	private int     srcSystemId; //长度8位，前4位是主系统，后4位是子系统
	private int     destSystemId;
	private int     serviceCode; //服务代码，请求：1000， 应答,2000
	private String  reqSequence; //请求消息序列号
	private String	rspSequence; //应带消息序列号
	private String  rspCode;     //系统消息应答码，共12位，左边6位主码，右边6位子码
	private String  rspDesc;     //应答描述
	
	//消息体
	private int     mainBusiType; //主业务类型，长度8位
	private int     subBusiType;  //子业务类型，长度8位
	private int     operateType;  //业务操作类型，长度8位
	private String  busiSequence; //业务操作流水号
	
	private Object  obj;          //业务对象核心
	private String  busiRspCode;  //业务应答码
	private String  busiRspDesc;  //业务应答描述
	

    //
	public void setSrcSystemId(int srcSystemId)	
	{
		this.srcSystemId =  srcSystemId;
	}
	public int getSrcSystemId()
	{
		return this.srcSystemId;
	}	
	
    //
	public void setDestSystemId(int destSystemId)	
	{
		this.destSystemId =  destSystemId;
	}
	public int getDestSystemId()
	{
		return this.destSystemId;
	}	
	
    //
	public void setServiceCode(int serviceCode)	
	{
		this.serviceCode =  serviceCode;
	}
	public int getServiceCode()
	{
		return this.serviceCode;
	}	
	
    //
	public void setReqSequence(String reqSequence)	
	{
		this.reqSequence =  reqSequence;
	}
	public String getReqSequence()
	{
		return this.reqSequence;
	}	
	
    //
	public void setRspSequence(String rspSequence)	
	{
		this.rspSequence = rspSequence;
	}
	public String getRspSequence()
	{
		return this.rspSequence;
	}	

    //
	public void setRspCode(String rspCode)	
	{
		this.rspCode = rspCode;
	}
	public String getRspCode()
	{
		return this.rspCode;
	}	
	
    //
	public void setrspDesc(String rspDesc)	
	{
		this.rspDesc = rspDesc;
	}
	public String getRspDesc()
	{
		return this.rspDesc;
	}		
	
    //
	public void setMainBusiType(int mainBusiType)	
	{
		this.mainBusiType = mainBusiType;
	}
	public int getMainBusiType()
	{
		return this.mainBusiType;
	}	

    //
	public void setSubBusiType(int subBusiType)	
	{
		this.subBusiType = subBusiType;
	}
	public int getSubBusiType()
	{
		return this.subBusiType;
	}		

    //
	public void setOperateType(int operateType)	
	{
		this.operateType = operateType;
	}
	public int getOperateType()
	{
		return this.operateType;
	}	
	
    //
	public void setObj(Object obj)	
	{
		this.obj = obj;
	}
	public Object getObj()
	{
		return this.obj;
	}
	
    //
	public void setBusiSequence(String busiSequence)	
	{
		this.busiSequence = busiSequence;
	}
	public String getBusiSequence()
	{
		return this.busiSequence;
	}
	
    //
	public void setBusiRspCode(String busiRspCode)	
	{
		this.busiRspCode = busiRspCode;
	}
	public String getBusiRspCode()
	{
		return this.busiRspCode;
	}	
	
    //
	public void setBusiRspDesc(String busiRspDesc)	
	{
		this.busiRspDesc = busiRspDesc;
	}
	public String getBusiRspDesc()
	{
		return this.busiRspDesc;
	}			
}
