package com.valen.lark.admin.fault;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.valen.lark.bean.fault.FaultDetailInfo;
import com.valen.lark.bean.fault.FaultInfo;
import com.valen.lark.iservice.fault.IFaultManageService;


@RestController
@RequestMapping("/fault")
public class faultController {
	
	@Reference(version = "1.0.0")
	private IFaultManageService faultManageSV;
	

    @RequestMapping(path="/queryAll",method=RequestMethod.GET)
    public List<FaultInfo> QueryFaultAll(HttpServletResponse rsp ){
       List<FaultInfo> faultInfos = faultManageSV.QueryAllFaultRecord();
       System.out.println(faultInfos.toString());
       rsp.setHeader("Access-Control-Allow-Origin", "*");
       rsp.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
       rsp.setHeader("Access-Control-Allow-Credentials", "true");
       rsp.setHeader("Access-Control-Max-Age", "3600");
       rsp.setHeader("Access-Control-Allow-Headers", "x-requested-with");       
       return faultInfos;
    }
    
    @RequestMapping(path="/queryAll",method=RequestMethod.POST)
    public @ResponseBody List<FaultInfo> QueryFaultAll2(HttpServletResponse rsp ){
       
       //List<FaultInfo> Rsp2 = new ArrayList<FaultInfo>();
       
       List<FaultInfo> faultInfos = faultManageSV.QueryAllFaultRecord();
       System.out.println(faultInfos.toString());
       rsp.setHeader("Access-Control-Allow-Origin", "*");
       rsp.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
       rsp.setHeader("Access-Control-Allow-Credentials", "true");
       rsp.setHeader("Access-Control-Max-Age", "3600");
       rsp.setHeader("Access-Control-Allow-Headers", "x-requested-with"); 
       
       //Rsp2 = faultInfos;
       
       return faultInfos;
    }   
    
    @RequestMapping(path="/queryDetailAll",method=RequestMethod.GET)
    public List<FaultDetailInfo> QueryFaulDetailtAllByGet(HttpServletResponse rsp ){
       List<FaultDetailInfo> faultDetailInfos = faultManageSV.QueryAllFaultDetailInfo();
       System.out.println(faultDetailInfos.toString());
       rsp.setHeader("Access-Control-Allow-Origin", "*");
       rsp.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
       rsp.setHeader("Access-Control-Allow-Credentials", "true");
       rsp.setHeader("Access-Control-Max-Age", "3600");
       rsp.setHeader("Access-Control-Allow-Headers", "x-requested-with");       
       return faultDetailInfos;
    }
    
    @RequestMapping(path="/queryDetailAll",method=RequestMethod.POST)
    public @ResponseBody List<FaultDetailInfo> QueryFaulDetailtAllByPost(HttpServletResponse rsp ){
       
       //List<FaultInfo> Rsp2 = new ArrayList<FaultInfo>();
       
       List<FaultDetailInfo> faultDetailInfos = faultManageSV.QueryAllFaultDetailInfo();
       System.out.println(faultDetailInfos.toString());
       rsp.setHeader("Access-Control-Allow-Origin", "*");
       rsp.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
       rsp.setHeader("Access-Control-Allow-Credentials", "true");
       rsp.setHeader("Access-Control-Max-Age", "3600");
       rsp.setHeader("Access-Control-Allow-Headers", "x-requested-with"); 
       
       //Rsp2 = faultInfos;
       
       return faultDetailInfos;
    }        
}
