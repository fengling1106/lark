/**  
* <p>Title: IManageService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: valen.com</p>  
* @author fengling  
* @date 2020年2月21日  
* @version 1.0  
*/  
package com.valen.lark.iservice.core;

import java.security.NoSuchAlgorithmException;

import com.valen.lark.bean.message.RequestMessage;
import com.valen.lark.iservice.fault.IFaultManageService;

/**
 * <p>Title: IManageService</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2020年2月21日
 */
public interface IManageService {

	//
	public void processFault(RequestMessage reqMsg) throws Exception;
}
