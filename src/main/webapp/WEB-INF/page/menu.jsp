<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul class="layui-nav layui-nav-tree menu" lay-filter="test">
<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
  <li class="layui-nav-item">
    <a href="../login/diaryPageInit.action">日记</a>
    <!-- <dl class="layui-nav-child">
      <dd><a href="javascript:;">选项1</a></dd>
      <dd><a href="javascript:;">选项2</a></dd>
      <dd><a href="">跳转</a></dd>
    </dl> -->
  </li>
  <li class="layui-nav-item">
    <a href="../login/mainPage.action">读书</a>
    <!-- <dl class="layui-nav-child">
      <dd><a href="">移动模块</a></dd>
      <dd><a href="">后台模版</a></dd>
      <dd><a href="">电商平台</a></dd>
    </dl> -->
  </li>
  <li class="layui-nav-item"><a href="">学习</a></li>
  <li class="layui-nav-item"><a href="">每日计划</a></li>
</ul>

