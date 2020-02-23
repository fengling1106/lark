/**  
* <p>Title: RequestMsgHead.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: valen.com</p>  
* @author fengling  
* @date 2020年2月21日  
* @version 1.0  
*/  
package com.valen.lark.bean.message;

import java.io.Serializable;

/**
 * <p>Title: RequestMsgHead</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2020年2月21日
 */
public class RequestMsgHead implements Serializable {
	private static final long serialVersionUID = 300002020022101L;
	private int     srcSystemId; //长度8位，前4位是主系统，后4位是子系统
	private int     destSystemId;
	private int     serviceCode; //服务代码，请求：1000， 应答,2000
	private String  reqSequence; //请求消息序列号
	private String	rspSequence; //应带消息序列号
	

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
}
