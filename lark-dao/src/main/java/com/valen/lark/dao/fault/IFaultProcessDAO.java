/**  
* <p>Title: IFaultProcess.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: valen.com</p>  
* @author fengling  
* @date 2019年7月16日  
* @version 1.0  
*/  
package com.valen.lark.dao.fault;

import java.util.List;

import com.valen.lark.bean.fault.FaultProcess;
import com.valen.lark.dao.BaseDAO;

/**
 * <p>Title: IFaultProcess</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2019年7月16日
 */
public interface IFaultProcessDAO extends BaseDAO<FaultProcess> {

	//根据故障标题查询故障订单
	public List<FaultProcess> getFaultProcessByFaultId(FaultProcess faultProcess);	
}
