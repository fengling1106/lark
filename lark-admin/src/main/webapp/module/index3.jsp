<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE>
<html>
<body>
<h1>光临!请选择你的操作:</h1><br>
    <ul>
        <shiro:hasPermission name="1000001"><li>增加</li></shiro:hasPermission>
        <shiro:hasPermission name="1000002"><li>删除</li></shiro:hasPermission>
        <shiro:hasPermission name="1000003"><li>修改</li></shiro:hasPermission>
        <shiro:hasPermission name="1000004"><li>查询</li></shiro:hasPermission>
    </ul>
        <a href="${pageContext.request.contextPath }/logOut">点我注销</a>
</body>
</html>
