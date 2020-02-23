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
		<title>值班故障查询</title>
		<link rel="stylesheet" href="/js/layui/css/laydate.css" />			
		<link rel="stylesheet" href="/js/layui/css/layui.css" />
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="/css/global-select.css" />		
		<link rel="stylesheet" href="/css/global.css" />		
		<link rel="stylesheet" href="/css/duty/fault.css" />		
		<script type="text/javascript" src="/js/layui/lay/modules/laydate.js"></script>			
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
			故障查询条件
			</div>
			<div class="content-body">
				<div class="content-body-head">
					<div class="content-body-head-condition">
						<label>故障编号：</label>
						<input type="text" id="in_qry_faultId" /> 
					</div>

					<div class="content-body-head-condition">
						<label>工单状态：</label>
						<select style="width: 200px; border: 1px solid #800040; height: 25px;">
							<option value ="0">全部</option>
							<option value ="1">跟进</option>
							<option value="2">完成</option>
						</select>				
					</div>
					<div class="content-body-head-condition" style="visibility:hidden;">
		
					</div>
					<div class="content-body-head-condition" style="display:block;">
						<label>开始时间：</label>
						<input type="text" id="qryStartDate" onfocus="this.blur()">
					</div>
				
					<div class="content-body-head-condition">
						<label>结束时间：</label>
						<input type="text" class="" id="qryEndDate" onfocus="this.blur()">
					</div>
						
					
				</div>
				<div class="content-body-content">
					<div class="content-body-content-action">
						<div class="table-title-decription">工单列表</div>
						<div class="exec-button">
							<button class="widget-self-btn query" id="qryBtn">查询详情</button>
						</div>
					</div>
					<div class="table-content">
						<table class="table-list" id="FautlTable">
							<thead>
								<tr>
								    <th style="width:64px; height:32px;">序列号</th>
									<th style="width:160px; height:32px;">故障编号</th>
									<th style="width:128px; height:32px;">故障标题</th>
									<th style="width:288px; height:32px;">故障类容</th>
									<th style="width:80px; height:32px;">是否故障</th>
									<th style="width:80px; height:32px;">故障等级</th>
									<th style="width:96px; height:32px;">故障类型</th>
									<th style="width:128px; height:32px;">发生时间</th>
									<th style="width:128px; height:32px;">恢复时间</th>
									<th style="width:80px; height:32px;">状态</th>
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
laydate.render({
	  elem: '#qryStartDate' //指定元素
	  ,type: 'datetime'
	}
	
	);
laydate.render({
	  elem: '#qryEndDate' //指定元素
	  ,type: 'datetime'
	}
	
	);

		var params = {};
		var result2;
		$(function(){
	    	$("#qryBtn").bind("click",function(){
		    	JavaService.postJsonService("/fault/queryDetailAll",params,
		    			function(result){
		    				//alert(result);
		    				$("#FautlTable tbody").html('');
		    				result2=result;
		    				if(jQuery.isArray(result)){
		    					var i=0,j=0;
		    					while(result[i] && i<9){
		    						//$("#aaa").text(result[i].faultTitle);
		    						j=i+1;
		    						var tdHead="<tr>";
		    						var tdEnd="</tr>";
		    						var sortId="<td style=\"width:64px;\">"+j+"</td>";
									var faultId="<td style=\"width:160px;\">"+result[i].faultId+"</td>";
									var faultTitle="<td style=\"width:128px;\">"+result[i].faultTitle+"</td>";
									var faultDesc="<td style=\"width:288px;\">"+result[i].faultDesc+"</td>";
									var isFault="<td style=\"width:80px;\">"+EnumPara("ENUM_IsFault",result[i].isFault)+"</td>";
									var faultGrade="<td style=\"width:80px;\">"+result[i].faultGrade+"</td>";	
									var faultType="<td style=\"width:96px;\">"+result[i].faultType+"</td>";	
									var startTime="<td style=\"width:128px;\">"+timeStamp2Date(result[i].startTime)+"</td>";	
									var endTime="<td style=\"width:128px;\">"+timeStamp2Date(result[i].entTime)+"</td>";	
									var processSts="<td style=\"width:80px;\">"+EnumPara("ENUM_ProcessSts",result[i].processSts)+"</td>";												
									var record=tdHead+sortId+faultId+faultTitle+faultDesc+isFault+faultGrade+faultType+startTime+endTime+processSts+tdEnd;
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
		    		if (result2[j].faultId == $(this).children('td').eq(1).text())
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
