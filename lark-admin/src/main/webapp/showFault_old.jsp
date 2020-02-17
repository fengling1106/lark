<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>故障展示</title>

<head>
	<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>	
	<script type="text/javascript">
	var params = {};
	/*$(document).ready(function(){
	  $("button").click(function(){
		  JavaService.postJsonService("/fault/queryAll",params, 
				  function(result){
			  		alert(result); 
			  		$("#test").text(result.faultTitle);
				  });	
	  });
	});*/
	
	/*$(function(){
	    $("button").bind("click",function(){
	    	$.ajax({
			url:"http://localhost:8088/fault/queryAll",
			type:"POST",
			data:params,
			contentType:"application/json; charset=UTF-8",
			dataType:"json",
			success:function(result) {
			$("#aaa").text(result.faultTitle)	
			//alert("返回结果:"+rsp.faultTitle);
			}});
	    	});
	    });	*/
	    
		$(function(){
	    	$("button").bind("click",function(){
		    	JavaService.postJsonService("/fault/queryAll",params,
		    			function(rsp){alert(rsp); 
										$("#aaa").text(rsp.faultTitle);})
										});
	    });	
	    	    
	</script>
</head>
<body>
<div>
<div>
<button class="btn" id="qryFaultButton">故障查询</button>
</div>
<form>
<table border="1">
<tr>
<th>故障标题</th>
<th>故障类容</th>
</tr>
<tr>
<td id ="aaa">4A登录故障</td>
<td>用户无法登录4A，提示数据库异常</td>
</tr>
</table>
</form>
<p id="test"></p>
</div>
</body>
</html>