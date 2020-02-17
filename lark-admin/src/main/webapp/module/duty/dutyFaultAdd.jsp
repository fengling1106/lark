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
		<link rel="stylesheet" href="/js/layui/css/layui.css" />
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="/css/duty/fault.css" />		
		<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="/js/template.js"></script>
		<script type="text/javascript" src="/js/layui/layui.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>	
		<script type="text/javascript" src="/js/utils.js"></script>	
   <style>
 
 
    </style>

	</head>

	<body>
		<div class="content-container">
			<div class="content-head">
				故障新增
			</div>
			<div class="content-body">
				<div class="content-body-head">
					<input class="oc-btn reset-btn" type="button" value="重置" />				
				</div>
				<div class="content-body-content">
					<div class="table-head oc-box">
						<div class="table-title">工单详情</div>
					</div>
					<div class="table-content">
						<table class="table-list" id="FautlTable">
							<thead>
								<tr>
								    <th>序列号</th>
									<th style="color:red">故障编号</th>
									<th style="width:200px;">故障标题</th>
									<th style="width:200px;">故障类容</th>
									<th>是否故障</th>
									<th>故障等级</th>
									<th>故障类型</th>
									<th>发生时间</th>
									<th>恢复时间</th>
									<th>处理状态</th>
								</tr>
							</thead>
							<tbody id="tableDataList">
							
							</tbody>
						</table>
					</div>
					<div class="table-page" id="page"></div>
				</div>
			<div id="popLayer"></div>
			<div id="popBox">
			    <div class="close">
			        <button onclick="closeBox()">关闭</button>
			    </div>
			    <div class="dialog-content" >
				  <label>故障ID：</label>
				  <input type="text" style="width:150px;" id="faultId">
				  <label>故障等级：</label>
				  <input type="text" style="width:50px;" id="faultGrade">
				  <label>故障类型：</label>
				  <input type="text" style="width:100px" id="faultType">
				  <label>处理状态 ：</label>
				  <input type="text" style="width:50px;" id="processSts">
				  <label>故障日期 ：</label>
				  <input type="text" style="width:50px;" id="faultDate">				  
				  <br/>  
				  <br/> 
				  <label>故障标题：</label>
				  <input type="text" style="width:200px;" id="faultTitle">
				  <br/>
                  <br/>				    
				  <label style="width:90%;text-align:center;"> 故障描述：</label> <br/>				     
				  <p id="faultDesc"></p>
                  <br/>				    
				  <label style="width:90%;text-align:center;"> 故障原因：</label> <br/>				     
				  <p id="reason"></p>
				  <br/>				  
			    </div>
			</div>				
			</div>
		</div>
	</body>
<script id="tableTem" type="text/javascript">
		var params = {};
		var result2;
		$(function(){
	    	$("button").bind("click",function(){
		    	JavaService.postJsonService("/fault/queryDetailAll",params,
		    			function(result){
		    				//alert(result);
		    				$("#FautlTable tbody").html('');
		    				result2=result;
		    				if(jQuery.isArray(result)){
		    					var i=0;
		    					while(result[i]){
		    						//$("#aaa").text(result[i].faultTitle);
		    						
		    						var tdHead="<tr>";
		    						var tdEnd="</tr>";
		    						var sortId="<td>"+i+"</td>";
									var faultId="<td>"+result[i].faultId+"</td>";
									var faultTitle="<td style=\"width:200px;display:inline-block;\">"+result[i].faultTitle+"</td>";
									var faultDesc="<td style=\"width:200px;display:inline-block;\">"+result[i].faultDesc+"</td>";
									var isFault="<td>"+result[i].isFault+"</td>";
									var faultGrade="<td>"+result[i].faultGrade+"</td>";	
									var faultType="<td>"+result[i].faultType+"</td>";	
									var faultGenTime="<td>"+timeStamp2Date(result[i].faultGenTime)+"</td>";	
									var faultRecoverTime="<td>"+timeStamp2Date(result[i].faultRecoverTime)+"</td>";	
									var processSts="<td>"+EnumPara("ENUM_ProcessSts",result[i].processSts)+"</td>";												
									var record=tdHead+sortId+faultId+faultTitle+faultDesc+isFault+faultGrade+faultType+faultGenTime+faultRecoverTime+processSts+tdEnd;
									$("#tableDataList").append(record);
									i++;
		    					}
		    				}
		    			})
						});
	    	
	    	
	    	/*$("#FautlTable").dbclick(function(){
	            alert("aaa");
	    	});*/
	    	$("#FautlTable tbody").on("dblclick", "tr", function() {
	    		//var faultId='故障ID：'+$(this).children('td').eq(0).text()+'\r\n';
	    		//var faultTitle="故障标题："+$(this).children('td').eq(1).text()+'\r\n';
	    		//var faultDesc="故障描述："+$(this).children('td').eq(2).text()+'\r\n';	    		
	    		//console.log(cod);
	    		
	    		var j=0;
		    	while(result2[j]){
		    		//$("#faultId").val(result2[j].faultId);
		    		if (result2[j].faultId == $(this).children('td').eq(0).text())
		    			{
		    				$("#faultId").val(result2[j].faultId);
		    				$("#faultTitle").val(result2[j].faultTitle);
		    				$("#faultDesc").text(result2[j].faultDesc);
		    				$("#faultGrade").val(result2[j].faultGrade);
		    				$("#faultType").val(result2[j].faultType);	
		    				$("#processSts").val(result2[j].processSts);
		    				$("#reason").text(result2[j].reason);
		    			}
		    		j++;
		    	}
	    		
	    		//$("#faultId").val(faultId);
	    		//$("#faultTitle").val(faultTitle);
	    		//$("#faultDesc").val(faultDesc);
		        var popBox = document.getElementById("popBox");
		        var popLayer = document.getElementById("popLayer");
		        popBox.style.display = "block";
		        popLayer.style.display = "block";
	    		});
	    });
		
	 
	    /*点击关闭按钮*/
	    function closeBox() {
	        var popBox = document.getElementById("popBox");
	        var popLayer = document.getElementById("popLayer");
	        popBox.style.display = "none";
	        popLayer.style.display = "none";
	    }
	    
	 /*Adjust the width of thead cells when *window* resizes
	    $(window).resize(function() {
	        
	    }).resize(); */     
	
</script>
</html> 
