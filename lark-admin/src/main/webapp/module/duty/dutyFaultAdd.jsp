<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

	<head>
		<link rel="shortcut icon" href="/img/favicon.ico" />
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
		<title>值班故障新增</title>
		<link rel="stylesheet" href="/css/duty/fault.css" />		
		<link rel="stylesheet" href="/js/layui/css/laydate.css" />		
		<link rel="stylesheet" href="/js/layui/css/layui.css" />		
		<link rel="stylesheet" href="/css/style.css" />
	
		<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="/js/template.js"></script>
		<script type="text/javascript" src="/js/layui/lay/modules/laydate.js"></script>		
		<script type="text/javascript" src="/js/layui/layui.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>	
		<script type="text/javascript" src="/js/utils.js"></script>
		<!--  script type="text/javascript" src="/other/ueditor1.4.3.2/ueditor.config.js"></script-->
        <!--  script type="text/javascript" src="/other/ueditor1.4.3.2/ueditor.all.js"></script-->	
   <style>
 
 
    </style>

	</head>

	<body>
		<div class="content-container">
			<div class="content-head">
				新增故障
			</div>
			<div class="content-body">
				<div class="content-body-content">
					<div class="table-head oc-box">
						<div class="table-title">故障基本信息填写</div>
					</div>
					<div class="content-new-fault">
						<div class="content-new-fault-groupbox">
							<div class="content-new-fault-module">
								<label for="faulttitle">故障标题：</label>
								<input type="text" name="faultTitle" id="faulttitle" />
							</div>
							<div class="content-new-fault-module">
								<label>所属系统：</label>
								<input type="text" name="systemName" id="systemname" />
							</div>	
							<div class="content-new-fault-module">	
								<label>所属模块：</label>
								<input type="text" name="systemModule" id="systemodule"/>
							</div>		
							<div class="content-new-fault-module">
								<label>故障类型：</label>
								<!-- input type="text" name="faultType" id="faulttype" /-->
								<select  name="faultType" id="faulttype">
									<option>业务故障</option>
									<option>系统故障</option>
								</select>								
							</div>	
							<div class="content-new-fault-module">	
								<label>故障等级：</label>
								<select style="width:200px; padding: 0 2%; margin: 0;" name="faultGrade" id="faultgrade">
									<option>1级</option>
									<option>2级</option>
									<option>3级</option>
								</select>
							</div>	
							<br/>
							<div class="content-new-fault-module">
								<label>故障开始时间：</label>
								<input type="text" name="startTime" id="starttime" />
								
							</div>		
							<br/>
							<div class="content-new-fault-module">		
								<label>故障上报人：</label>
								<input type="text" name="faultReporter" id="faultreporter"/>
							</div>
							<div class="content-new-fault-module" >			
								<label>报障人联系电话：</label>
								<input type="text" name="reporterPhone" id="reporterphone"/>
							</div>
							<div class="content-new-fault-module" >			
								<label>关联事件单号：</label>
								<input type="text" name="linkEventId" id="linkeventid"/>
							</div>	
						</div>									
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<div class="content-new-fault-textarea">
							<label>故障详细描述</label>
							<!-- script id="faultdesc" type="text/plain" style="width:100%;"></script-->
							<!-- 实例化编辑器 -->
						    <!--script type="text/javascript">
						        var ue = UE.getEditor('faultdesc');
						    </script-->
						    <textArea id="faultdesc" name="faultDesc" cols="125" rows="16"></textArea>
						</div>
						<div class="content-new-fault-submit">
							<button class="submitA" id="sign">提交</button>
							<input  class="submitA" type="reset" value="重置"/>
						</div>							
					</div>
				</div>			
			</div>
		</div>
	</body>
<script type="text/javascript">
laydate.render({
	  elem: '#starttime' //指定元素
	  ,type: 'datetime'
	});

$(function(){
    $("#sign").bind("click",function(){
    	var v_faultTitle = $("#faulttitle").val();
    	var v_systemName = $("#systemname").val();
    	var v_systemModule = $("#systemodule").val();
    	var v_faultType = $("#faulttype").val();
    	var v_faultGrade =$("#faultgrade").val();
    	var v_startTime = $("#starttime").val();
    	var v_faultReporter = $("#faultreporter").val(); 
    	var v_reporterPhone = $("#reporterphone").val();
    	var v_linkEventId = $("#linkeventid").val();
    	var v_faultDesc = $("#faultdesc").val();
    	var v_busiEntityObj = {faultTitle:v_faultTitle,systemName:v_systemName,systemModule:v_systemModule,faultType:v_faultType,faultGrade:v_faultGrade,
    			startTime:v_startTime,faultReporter:v_faultReporter,reporterPhone:v_reporterPhone,linkEventId:v_linkEventId,faultDesc:v_faultDesc};
    	console.log(v_busiEntityObj);
    	var busiMsgBodyObj = {mainBusiId:20000,subBusiId:10000,operateType:10,busiObj:v_busiEntityObj};    	
    	
    	var busiJsonObj = JSON.stringify(busiMsgBodyObj);
    	
    	$.ajax({
    			url:"http://localhost:8088/msg",
				type:"POST",
				data:busiJsonObj,
				contentType:"application/json; charset=UTF-8",
				dataType:"json",
				success:function(rsp) {
					alert("返回结果:"+rsp+"\r\n");
				}
			});
		});
	});
</script>
</html> 
