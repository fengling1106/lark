/**  
* <p>Title: RequestMessage.java</p>  
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
 * <p>Title: RequestMessage</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2020年2月20日
 */
public class RequestMessage implements Serializable {
	private static final long serialVersionUID = 300002020022103L;
	//消息头
	private RequestMsgHead  reqMsgHead;
	
	private RequestMsgBody  reqMsgBody;
	
    //
	public void setReqMsgHead(RequestMsgHead reqMsgHead)	
	{
		this.reqMsgHead = reqMsgHead;
	}
	public RequestMsgHead getReqMsgHead()
	{
		return this.reqMsgHead;
	}	
	
    //
	public void setReqMsgBody(RequestMsgBody reqMsgBody)	
	{
		this.reqMsgBody = reqMsgBody;
	}
	public RequestMsgBody getReqMsgBody()
	{
		return this.reqMsgBody;
	}
}
