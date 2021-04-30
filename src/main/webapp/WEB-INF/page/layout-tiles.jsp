<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<title>FOR DIARY</title>
		<meta name="robots" content="noindex,nofollow"/>
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script src="../assets/layui/layui.all.js"></script>
		<script src="../assets/js/jquery-1.11.1.js"></script>
		<script src="../assets/js/diary.js?v1.0.6"></script>
		<link rel="stylesheet" type="text/css" href="../assets/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="../assets/css/main.css?1.0.6">
		<link rel="stylesheet" type="text/css" href="../assets/css/diary_layout.css?ver=7">
		
</head>
<body>
<div>
	<nav>
		<div id="layout-header">
			<tiles:insertAttribute name="header"/>
		</div>
		<div id="layout-menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="layout-content">
			<tiles:insertAttribute name="content" />
		</div>
	</nav>
	<tiles:insertAttribute name="footer" />
</div>

</body>
</html>