/**  
* <p>Title: ManageSV.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: valen.com</p>  
* @author fengling  
* @date 2020年2月21日  
* @version 1.0  
*/  
package com.valen.lark.service.impl.core;


import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.valen.lark.bean.message.RequestMessage;
import com.valen.lark.iservice.core.IManageService;
import com.valen.lark.iservice.fault.IFaultManageService;

/**
 * <p>Title: ManageSV</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2020年2月21日
 */
@Service(version = "1.0.0")
public class ManageSV implements IManageService {

	
	@Autowired
	IFaultManageService faultManageSV; 
	
	/* (non-Javadoc)
	 * @see com.valen.lark.iservice.core.IManageService#processFault(com.valen.lark.iservice.fault.IFaultManageService)
	 */
	@Override
	public void processFault(RequestMessage reqMsg) throws Exception {
	
		
		//根据主业务ID，分发到各个子模块解析请求消息
		int mainBusiId = reqMsg.getReqMsgBody().getMainBusiId();
				
		if(mainBusiId>=20000 && mainBusiId <29999) {
			faultManageSV.paraRequestMsg(reqMsg);
			//faultManageSV.AddFaultDetailRecord(map);
		}
	}

}
