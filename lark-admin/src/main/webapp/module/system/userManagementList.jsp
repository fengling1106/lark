<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

	<head>
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.ico" />
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
		<title>用户管理</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/js/layui/css/layui.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/template.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/config.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/modules/system/js/userManage.js"></script>
	</head>
	<script type="text/javascript">
	</script>
	<body>
		<div class="content-container">
			<div class="content-head">
				用户管理
			</div>
			<div class="content-body">
				<div class="content-body-head">
					用户名称：<input class="txt-input param-in" data-id="userName" type="text" /> 
					用户账号：<input class="txt-input param-in" data-id="userCode" type="text" /> 
					
					<input class="oc-btn query-btn" type="button" value="查询" />
					<input class="oc-btn reset-btn" type="button" value="重置" />
				</div>
				<div class="content-body-content">
					<div class="table-head oc-box">
						<div class="table-title"></div>
						<div class="span1 txt-align-r">
							<button class="oc-btn other-btn" onclick="addUser();">新增</button>
							<button class="oc-btn other-btn" onclick="updateOrviewUser(1);">修改</button>
							<button class="oc-btn other-btn" onclick="userSystem.deleteUser();">删除</button>
							<button class="oc-btn other-btn" onclick="userSystem.updateUserState('1');">启用</button>
							<button class="oc-btn other-btn" onclick="userSystem.updateUserState('0');">停用</button>
							<button class="oc-btn other-btn" onclick="updateOrviewUser(2);">查看</button>
						</div>
					</div>
					<div class="table-content">
						<table class="table-list oneline-table" id="tableData">
							<thead>
								<tr>
									<th width="50">选择</th>
									<th width="80">序号</th>
									<th>用户名称</th>
									<th>用户账号</th>
									<th>联系电话</th>
									<th>状态</th>
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
<script id="tableTem" type="text/html">
{{if applist}}{{each applist as data i}}
	<tr>
		<td>
			<div class="checkbox">
				<input type='checkbox' name='userCheckName' value='{{data.user_id}},{{data.staffname}}'><label></label>
			</div>
		</td>
		<td title="">{{((pageNum-1)*10)+(i+1)}}</td>
		<td title="">{{data.staffname}}</td>
		<td title="">{{data.username}}</td>
		<td title="">{{data.phone}}</td>
		<td title="">{{data.state}}</td>
	</tr>
{{/each}}{{/if}}
</script>
</html>