package com.valen.lark.admin.system;

import java.util.List;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.valen.lark.bean.system.SysUser;
//import com.valen.lark.bean.work.WorkRecord;
import com.valen.lark.iservice.system.ISysUserService;
import com.valen.lark.utils.CommonTool;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/user")
public class UserController<HttpServletRespone> {

	//private static Log log = LogFactory.getLog(WorkRecord.class);
	
	/*@RequestMapping("/users")
	public String register() 
	{
		return "user/register"; 
	}*/
	
	//@Autowired
	@Reference(version = "1.0.0")
	private ISysUserService userService;
	
	@Reference(version = "1.0.0")
	private ISysUserService userService2;
	
	@RequestMapping(path="/users",method=RequestMethod.POST)
	public String AddNewUser(@RequestBody SysUser user) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		//ModelAndView mav = new ModelAndView();
		String strMsg="";
		if(user.getOpName().equals(""))
		{
			return "注册失败";	
		}
		if(userService.regUser(user))
		{	
			strMsg ="注册成功";
		}
		else
		{
			strMsg ="注册失败";	
		};
		return strMsg;	
	}
	
	
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public ModelAndView loginUser(String opName,String passWord,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		//解密操作员和密码
		opName=CommonTool.decoderBase64(opName);
		passWord=CommonTool.decoderBase64(passWord);       
		
		UsernamePasswordToken token=new UsernamePasswordToken(opName,passWord);
        Subject subject = SecurityUtils.getSubject();		
		
        ModelAndView mav = new ModelAndView();
		try{

			SysUser user = userService.loginSystem(opName, passWord);
			System.out.println("opName="+opName+";"+"passWord="+passWord);
			//int iuser = userService.isExistSysUserByOpName(opName);
			//SysUser user = userService.getSysUserByLoginName(opName);
			if(user !=null){
				
				subject.login(token);
				SysUser user2=(SysUser) subject.getPrincipal();
				session.setAttribute("opName", opName);
				mav.setViewName("index");
				mav.addObject("user",user2);	
			}
			else
			{
				mav.setViewName("index3");
				mav.addObject("user",opName);	
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
 		
	  return mav;
	}
	
	
	@RequestMapping(path="/query/{userName}",method=RequestMethod.GET)
	public @ResponseBody List<SysUser> GetUsersAll(@PathVariable String userName,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		//ModelAndView mav = new ModelAndView();
		List<SysUser> userList = null;
		try{
			
			if(userName.equals("all" ))
			{
				 userList = userService.getUsersAll();
				/*if(null!=userList){
					session.setAttribute("users", userList);
					//mav.setViewName("user/queryresult");
					//mav.addObject("users",userList);	
				}
				else
				{
					//mav.setViewName("user/queryresult");
					//mav.addObject("users",userList);	
				}	*/
			}
			else
			{
				 userList = userService.getUserMatchUserName(userName);
				/*if(null!=userList){
					//session.setAttribute("users", userList);
					//mav.setViewName("user/queryresult");
					//mav.addObject("users",userList);	
				}
				else
				{
					//mav.setViewName("user/queryresult");
					//mav.addObject("users",userList);	
				}	*/
			}
			
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return userList;	
	}	
	
	@RequestMapping(path="/users111",method=RequestMethod.POST)
	public @ResponseBody SysUser  GetUserInfo(@RequestBody SysUser ReqUser) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		SysUser RspUser = new SysUser();
		try{
			List<SysUser> userList = userService.getUsersAll();
			if(null!=userList){
	
			}
			else
			{	
			}			
		}
		catch(Exception e)
		{
			//log.info(e.getMessage());
		}
		return RspUser;	
	}		
	
    @RequestMapping(path="/query",method=RequestMethod.GET)
    public SysUser testQuery(HttpServletResponse rsp ){
       SysUser user = userService2.getSysUserByLoginName("fengling");
       System.out.println(user.toString());
       rsp.setHeader("Access-Control-Allow-Origin", "*");
       rsp.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
       rsp.setHeader("Access-Control-Allow-Credentials", "true");
       rsp.setHeader("Access-Control-Max-Age", "3600");
       rsp.setHeader("Access-Control-Allow-Headers", "x-requested-with");       
       return user;
    }
}
