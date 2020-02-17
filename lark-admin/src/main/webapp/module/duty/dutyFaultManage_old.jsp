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
		<title>值班故障管理</title>
		<link rel="stylesheet" href="/js/layui/css/layui.css" />
		<link rel="stylesheet" href="/css/style.css" />
		<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="/js/template.js"></script>
		<script type="text/javascript" src="/js/layui/layui.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>	
		<script type="text/javascript" src="/js/utils.js"></script>	
	</head>

	<body>
		<div class="content-container">
			<div class="content-head">
				值班管理
			</div>
			<div class="content-body">
				<div class="content-body-head">
					故障编号：
					<input class="txt-input param-in" data-id="orderCode" type="text" /> 
					工单状态：
					<div class="select-group" style="width: 100px;">
						<div data-val="" data-id="orderType" class="current-option param-in">全部</div>
						<ul class="option-list">
							<li class="select-option" data-val="">全部</li>
							<li class="select-option" data-val="1">待跟进</li>
							<li class="select-option" data-val="2">已完成</li>
						</ul>
					</div>
					<!--<input class="txt-input param-in" data-id="" type="text" />-->
					发起时间：
					<div class="layui-input-inline date-sel">
						<input type="text" class="layui-input txt-input" id="startDate" onfocus="this.blur()">
					</div>
					--
					<div class="layui-input-inline date-sel">
						<input type="text" class="layui-input txt-input" id="endDate" onfocus="this.blur()">
					</div>
					<button class="oc-btn query-btn" id="qryFaultButton">故障查询</button>

					<input class="oc-btn reset-btn" type="button" value="重置" />
					
				</div>
				<div class="content-body-content">
					<div class="table-head oc-box">
						<div class="table-title">工单列表</div>
						<div class="span1 txt-align-r">
							<button class="oc-btn other-btn" onclick="Order.orderEdit()">处理</button>
							<button class="oc-btn other-btn" onclick="Order.overOrder()">归档</button>
						</div>
					</div>
					<div class="table-content">
						<table class="table-list oneline-table" id="FautlTable">
							<thead>
								<tr>
									<th>故障编号</th>
									<th>故障标题</th>
									<th>故障类容</th>
									<th>是否故障</th>
									<th>故障等级</th>
									<th>故障类型</th>
									<th>发生时间</th>
									<th>恢复时间</th>
									<th>处理状态</th>
									<th>故障原因</th>
								</tr>
							</thead>
							<tbody id="tableDataList">
							
							</tbody>
						</table>
					</div>
					<div class="table-page" id="page"></div>
				</div>
			</div>
		</div>
	</body>
<script id="tableTem" type="text/javascript">
		var params = {};
		$(function(){
	    	$("button").bind("click",function(){
		    	JavaService.postJsonService("/fault/queryAll",params,
		    			function(result){
		    				//alert(result);
		    				$("#FautlTable tbody").html('');
		    				if(jQuery.isArray(result)){
		    					var i=0;
		    					while(result[i]){
		    						//$("#aaa").text(result[i].faultTitle);
		    						
		    						var tdHead="<tr>";
		    						var tdEnd="</tr>";
									var faultId="<td>"+result[i].faultId+"</td>";
									var faultTitle="<td>"+result[i].faultTitle+"</td>";
									var faultDesc="<td>"+result[i].faultDesc+"</td>";
									var isFault="<td>"+EnumPara("ENUM_IsFault",result[i].isFault)+"</td>";
									var faultGrade="<td>"+EnumPara("ENUM_FaultGrade",result[i].faultGrade)+"</td>";	
									var faultType="<td>"+EnumPara("ENUM_FaultType",result[i].faultType)+"</td>";	
									var faultGenTime="<td>"+timeStamp2Date(result[i].faultGenTime)+"</td>";	
									var faultRecoverTime="<td>"+timeStamp2Date(result[i].faultRecoverTime)+"</td>";	
									var processSts="<td>"+EnumPara("ENUM_ProcessSts",result[i].processSts)+"</td>";		
									var reason="<td>"+result[i].reason+"</td>";											
									var record=tdHead+faultId+faultTitle+faultDesc+isFault+faultGrade+faultType+faultGenTime+faultRecoverTime+processSts+reason+tdEnd;
									$("#FautlTable tbody").append(record);
									i++;
		    					}
		    				}
		    			})
						});
	    });	
    	    
</script>
</html> 
