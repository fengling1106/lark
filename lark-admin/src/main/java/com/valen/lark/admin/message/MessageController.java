/**  
* <p>Title: MessageController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: valen.com</p>  
* @author fengling  
* @date 2020年2月21日  
* @version 1.0  
*/  
package com.valen.lark.admin.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valen.lark.admin.fault.FaultController;
import com.valen.lark.bean.message.RequestMessage;
import com.valen.lark.bean.message.RequestMsgBody;
import com.valen.lark.bean.message.RequestMsgHead;

/**
 * <p>Title: MessageController</p>  
 * <p>Description: </p>
 * @author fengling
 * @date 2020年2月21日
 */
@RestController
@SessionAttributes("reqMsg")
@RequestMapping("/msg")
public class MessageController {

	 @RequestMapping(method=RequestMethod.POST)
	 public void exchange(@RequestBody RequestMsgBody reqMsgBody,RedirectAttributes attr,HttpServletRequest req, HttpServletResponse rsp, HttpSession session) throws Exception{

		 int MainBusiId = reqMsgBody.getMainBusiId();
		 //int SubBusiId = busiReqObj.getSubBusiType();
		 RequestMsgHead reqMsgHead = new RequestMsgHead();
		 RequestMessage reqMsg = new RequestMessage();
		 
		 if (MainBusiId>=20000 && MainBusiId <29999){
			 reqMsgHead.setSrcSystemId(25);
			 reqMsgHead.setDestSystemId(28);
			 
		 }

		 reqMsg.setReqMsgHead(reqMsgHead);
		 reqMsg.setReqMsgBody(reqMsgBody);
		 
		 //FaultController faultController = new FaultController();
		 //faultController.AddNewFault3(reqMsg);
		 
		 attr.addFlashAttribute("reqMsg",reqMsg);
		 session.setAttribute("reqMsg1", reqMsg);
		 
		 String strReturn ="";
		 switch(MainBusiId) {
		 	case 20000:
		 		 strReturn="/fault/addnewfault";
		 		 //rsp.sendRedirect("/fault/addnewfault");
		 		break;
		 	default:
		 		;
		 }
		 rsp.sendRedirect(strReturn);
	 }
}
