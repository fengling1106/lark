<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

	<head>
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/statics/img/favicon.ico" />
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
		<title>角色管理</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/statics/js/layui/css/layui.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/statics/css/style.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/statics/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/statics/js/template.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/statics/js/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/statics/js/config.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/modules/system/js/roleManage.js"></script>
	</head>

	<body>
		<div class="content-container">
			<div class="content-head">
				角色管理
			</div>
			<div class="content-body">
				<div class="content-body-head">
					角色名称：<input class="txt-input param-in" data-id="roleName" type="text" /> 
					角色类型：
						<div class="select-group" style="width: 150px;">
							<div data-val="" data-id="type" class="current-option param-in">全部</div>
							<ul class="option-list">
								<li class="select-option" data-val="">全部</li>
								<li class="select-option" data-val="1">系统默认角色</li>
								<li class="select-option" data-val="2">非系统默认角色</li>
							</ul>
						</div>
					
					<input class="oc-btn query-btn" type="button" value="查询" />
					<input class="oc-btn reset-btn" type="button" value="重置" />
				</div>
				<div class="content-body-content">
					<div class="table-head oc-box">
						<div class="table-title"></div>
						<div class="span1 txt-align-r">
							<button class="oc-btn other-btn" onclick="addOrupdateOrviewRole(3);">新增</button>
							<button class="oc-btn other-btn" onclick="addOrupdateOrviewRole(1);">修改</button>
							<button class="oc-btn other-btn" onclick="roleSystem.deleterRole();">删除</button>
							<button class="oc-btn other-btn" onclick="addOrupdateOrviewRole(2);">查看</button>
						</div>
					</div>
					<div class="table-content">
						<table class="table-list oneline-table" id="tableData">
							<thead>
								<tr>
									<th width="50">选择</th>
									<th width="80">序号</th>
									<th>角色名称</th>
									<th>角色描述</th>
									<th>角色类型</th>
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
				<input type='checkbox' name='roleCheckName' value='{{data.role_id}},{{data.rolename}}'><label></label>
			</div>
		</td>
		<td title="">{{((pageNum-1)*10)+(i+1)}}</td>
		<td title="{{data.rolename}}">{{data.rolename}}</td>
		<td title="{{data.comment}}">{{data.comment}}</td>
		<td title="{{data.type}}">{{data.type}}</td>
	</tr>
{{/each}}{{/if}}
</script>
</html>