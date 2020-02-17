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
		<title>订单管理</title>
		<link rel="stylesheet" href="/js/layui/css/layui.css" />
		<link rel="stylesheet" href="/css/style.css" />
		<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="/js/template.js"></script>
		<script type="text/javascript" src="/js/layui/layui.js"></script>
		<script type="text/javascript" src="/js/config.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/modules/order/orderManage.js"></script>
	</head>

	<body>
		<div class="content-container">
			<div class="content-head">
				政企业务预约待办订单管理
			</div>
			<div class="content-body">
				<div class="content-body-head">
					工单编号：
					<input class="txt-input param-in" data-id="orderCode" type="text" /> 
					政企业务种类：
					<div class="select-group" style="width: 100px;">
						<div data-val="" data-id="orderType" class="current-option param-in">全部</div>
						<ul class="option-list">
							<li class="select-option" data-val="">全部</li>
							<li class="select-option" data-val="1">ims</li>
							<li class="select-option" data-val="2">集团专线</li>
							<li class="select-option" data-val="3">商务宽带</li>
							<li class="select-option" data-val="4">云视讯</li>
							<li class="select-option" data-val="5">4G千里眼</li>
							<li class="select-option" data-val="6">和对讲</li>
							<li class="select-option" data-val="7">集团V号簿</li>
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
					<input class="oc-btn query-btn" type="button" value="查询" />
					<input class="oc-btn reset-btn" type="button" value="重置" />
				</div>
				<div class="content-body-content">
					<div class="table-head oc-box">
						<div class="table-title">政企业务预约订单待办列表</div>
						<div class="span1 txt-align-r">
							<button class="oc-btn other-btn" onclick="Order.orderEdit()">处理</button>
							<button class="oc-btn other-btn" onclick="Order.overOrder()">归档</button>
						</div>
					</div>
					<div class="table-content">
						<table class="table-list oneline-table">
							<thead>
								<tr>
									<th width="80">选择</th>
									<th>工单编号</th>
									<th>政企业务种类</th>
									<th>创建时间</th>
									<th>当前状态</th>
									<th>发起人</th>
									<th>联系电话</th>
									<th>处理人</th>
									<th>处理时间</th>
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
				<input type='checkbox' name='orderCheckName' value='{{data.order_id}}'><label></label>
			</div>
		</td>
		<td title="{{data.order_code}}">{{data.order_code}}</td>
		<td title="{{data.service_type}}">{{data.service_type}}</td>
		<td title="{{data.create_date}}">{{data.create_date}}</td>
		<td title="{{data.status}}">{{data.status}}</td>
		<td title="{{data.customer}}">{{data.customer}}</td>
		<td title="{{data.phone}}">{{data.phone}}</td>
		<td title="{{data.handle_person}}">{{data.handle_person}}</td>
		<td title="{{data.handle_date}}">{{data.handle_date}}</td>
	</tr>
{{/each}}{{/if}}
</script>
</html> 
