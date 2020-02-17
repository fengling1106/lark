<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>故障展示</title>

<head>
	<link rel="stylesheet" href="/css/style.css" />	
	<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>	
	<script type="text/javascript" src="/js/utils.js"></script>		
	<script type="text/javascript">
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
</head>
<body>
<div class="content-container">
	<div class="content-body">
<button class="btn" id="qryFaultButton">故障查询</button>
</div>
<form>
<table border="1" id="FautlTable">
<thead>
<tr id="FaultTableTitle">
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
<tbody>
</tbody>
</table>
</form>
</div>
</body>
</html>