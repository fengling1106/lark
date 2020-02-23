/**  
* <p>Title: BusinessInfo.java</p>  
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
 * <p>Title: BusinessInfo</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2020年2月21日
 */
public class RequestMsgBody implements Serializable {
	private static final long serialVersionUID = 300002020022102L;
	//消息体
	private int     mainBusiId;   //主业务类型，长度8位
	private int     subBusiId;    //子业务类型，长度8位
	private int     operateType;  //业务操作类型，长度8位
	private Object  busiObj;      //业务对象 	

	public void setMainBusiId(int mainBusiId)	
	{
		this.mainBusiId = mainBusiId;
	}
	public int getMainBusiId()
	{
		return this.mainBusiId;
	}	

    //
	public void setSubBusiId(int subBusiId)	
	{
		this.subBusiId = subBusiId;
	}
	public int getSubBusiType()
	{
		return this.subBusiId;
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
	public void setBusiObj(Object busiObj)	
	{
		this.busiObj = busiObj;
	}
	public Object getBusiObj()
	{
		return this.busiObj;
	}		
}
