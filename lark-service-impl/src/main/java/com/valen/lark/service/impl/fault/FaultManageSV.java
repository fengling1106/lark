package com.valen.lark.service.impl.fault;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.valen.lark.bean.fault.FaultDetail;
import com.valen.lark.bean.fault.FaultInfo;
import com.valen.lark.bean.fault.FaultProcess;
import com.valen.lark.bean.message.RequestMessage;
import com.valen.lark.bean.message.RequestMsgBody;

import com.valen.lark.dao.fault.IFaultDetailDAO;
import com.valen.lark.dao.fault.IFaultInfoDAO;
import com.valen.lark.dao.fault.IFaultProcessDAO;
import com.valen.lark.iservice.fault.IFaultManageService;
import com.valen.lark.utils.CommonTool;
import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
//@Transactional
public class FaultManageSV implements IFaultManageService {
   	
	//private static Log log = LogFactory.getLog(WorkRecord.class);
		
	@Autowired
	IFaultInfoDAO faultInfoDao ; 

	@Autowired
	IFaultProcessDAO faultProcessDao ; 
	
	@Autowired
	IFaultDetailDAO faultDetailDao ; 	

	/* (non-Javadoc)
	 * @see com.valen.lark.iservice.fault.IFaultManageService#paraRequestMsg(com.valen.lark.bean.message.RequestMessage)
	 */
	@Override
	public void paraRequestMsg(RequestMessage reqMsg) throws Exception {
		
		RequestMsgBody reqMsgBody= reqMsg.getReqMsgBody();
		HashMap map = (HashMap)reqMsgBody.getBusiObj();
		
		//解析请求消息，构造业务类对象参数
		FaultDetail faultDetailInfo= new FaultDetail();
		Timestamp ts = new Timestamp(System.currentTimeMillis()); 
		
		faultDetailInfo.setFaultId(CommonTool.getSequence());
			
		faultDetailInfo.setFaultTitle((String)map.get("faultTitle"));		
		faultDetailInfo.setFaultDesc((String)map.get("faultDesc"));
		
		faultDetailInfo.setSystemName((String)map.get("systemName"));
		faultDetailInfo.setSystemModule((String)map.get("systemModule"));
		faultDetailInfo.setFaultType((String)map.get("faultType"));
		faultDetailInfo.setFaultGrade((String)map.get("faultGrade"));
		

		
		String strn = new SimpleDateFormat("yyyy-MM-dd").format(ts);
		faultDetailInfo.setfaultDate(strn);
		
		faultDetailInfo.setStartTime(ts.valueOf((String)map.get("startTime")));	
		
		faultDetailInfo.setFaultReporter((String)map.get("faultReporter"));
		faultDetailInfo.setReporterPhone((String)map.get("reporterPhone"));
		faultDetailInfo.setEventId((String)map.get("linkEventId"));
		
		faultDetailInfo.setCreateDate(ts);
		
		faultDetailInfo.setIsFault(true);
		faultDetailInfo.setProcessSts((byte)1);
		faultDetailInfo.setState((byte)1);
		
		
		AddFaultDetailRecord(faultDetailInfo);

		
	}		
	
	
	public boolean AddFaultRecord(FaultInfo faultInfo) throws NoSuchAlgorithmException
	{
		try{
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
		
		return true;
	}
	
	public List<FaultInfo>  QueryAllFaultRecord()
	{
		List<FaultInfo> faultInfos = null;
		try{
			
			faultInfos=faultInfoDao.getFaultInfoAll();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		
		return faultInfos;
	}
	
	public FaultInfo  QueryFaultRecordByFaultTitle(FaultInfo faultInfo) 
	{
		try{
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		
		return null;
	}
	
	
	@Override
	public List<FaultProcess> QueryFaultProcessByFaultId(FaultProcess faultProcess)
	{
		List<FaultProcess> FaultProcesss = null;
		try{
			
			FaultProcesss=faultProcessDao.getFaultProcessByFaultId(faultProcess);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		
		return FaultProcesss;
		
	}
	
	
	public List<FaultDetail>  QueryAllFaultDetailInfo()
	{
		List<FaultDetail> faultDetailInfos = null;
		try{
			
			faultDetailInfos=faultDetailDao.getFaultDetailInfoAll();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		
		return faultDetailInfos;
	}	
	
	public boolean AddFaultDetailRecord(FaultDetail faultDetailInfo)
	{

		boolean bResult = false;
		if(null !=faultDetailInfo) {
			try{
				
				bResult=faultDetailDao.insertSingle(faultDetailInfo);				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		return bResult;
	}
	
}
