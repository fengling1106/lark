package com.valen.lark.service.impl.fault;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.valen.lark.bean.fault.FaultDetailInfo;
import com.valen.lark.bean.fault.FaultInfo;
import com.valen.lark.bean.fault.FaultProcess;
import com.valen.lark.bean.system.SysUser;
import com.valen.lark.dao.fault.IFaultDetailInfoDAO;
import com.valen.lark.dao.fault.IFaultInfoDAO;
import com.valen.lark.dao.fault.IFaultProcessDAO;
import com.valen.lark.iservice.fault.IFaultManageService;


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
	IFaultDetailInfoDAO faultDetailDao ; 	

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
	
	
	public List<FaultDetailInfo>  QueryAllFaultDetailInfo()
	{
		List<FaultDetailInfo> faultDetailInfos = null;
		try{
			
			faultDetailInfos=faultDetailDao.getFaultDetailInfoAll();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		
		return faultDetailInfos;
	}	
}
