package com.valen.lark.iservice.fault;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

import com.valen.lark.bean.fault.FaultDetail;
import com.valen.lark.bean.fault.FaultInfo;
import com.valen.lark.bean.fault.FaultProcess;
import com.valen.lark.bean.message.RequestMessage;


/**
 * @author fengling
 * @create 2019-7-15
 * @Description 值班故障管理服务
 */

public interface IFaultManageService {
		
	//处理请求消息报
	public void paraRequestMsg(RequestMessage reqMsg) throws Exception;
	
	//新增值班管理记录
	public boolean AddFaultRecord(FaultInfo faultInfo) throws NoSuchAlgorithmException;
	
	public boolean AddFaultDetailRecord(FaultDetail faultDetailInfo) throws NoSuchAlgorithmException;
	
    //查询所有值班故障记录
	public List<FaultInfo> QueryAllFaultRecord();	
	
    //根据故障标题值班故障记录
	public FaultInfo QueryFaultRecordByFaultTitle(FaultInfo faultInfo);
	
	/**  
	 * <p>Title: QueryFaultProcessByFaultId</p>  
	 * <p>Description: query a fault process detail info </p>  
	 * @param faultInfo
	 * @return List<FaultProcess>
	 */  
	public List<FaultProcess> QueryFaultProcessByFaultId(FaultProcess faultProcess);

	
    
	/**  
	 * <p>Title: QueryAllFaultDetailInfo</p>  
	 * <p>Description: 查询故障详细记录表</p>  
	 * @return  
	 */  
	public List<FaultDetail> QueryAllFaultDetailInfo();
	
}
