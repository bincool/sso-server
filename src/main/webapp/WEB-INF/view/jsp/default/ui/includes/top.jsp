<!DOCTYPE html>

<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <title>CAS &#8211; Central Authentication Service</title>

  <meta name="_csrf" content="${_csrf.token}"/>
  <meta name="_csrf_header" content="${_csrf.headerName}"/>

  <meta http-equiv="Content-Type" content="charset=utf-8" />

  <spring:theme code="standard.custom.css.file" var="customCssFile" />
  <link rel="stylesheet" href="<c:url value="${customCssFile}" />" />
  <link rel="icon" href="<c:url value="/favicon.ico" />" type="image/x-icon" />
  <link rel="stylesheet" href="project-fonts/iconfont.css?v=20180531">
  <link rel="stylesheet" href="css/login_add.min.css?v=20180531">

</head>
<body id="cas">

<div id="container">
  <%--<header>--%>
  <%--<div class="clearfix">--%>
  <%--<div class="left">--%>
  <%--<a href="javascript:void(0);"  title="<spring:message code="logo.title" />">--%>
  <%--<div class="logo">--%>
  <%--<i class="icon_logo"></i>--%>
  <%--</div>--%>
  <%--<div class="name">--%>
  <%--<p>HR后台管理系统</p>--%>
  <%--</div>--%>
  <%--</a>--%>
  <%--<div class="loginTip">--%>
  <%--<span class="tip">欢迎登录</span>--%>
  <%--</div>--%>
  <%--</div>--%>
  <%--<div class="right">--%>
  <%--<p>--%>
  <%--<i class="icon_tel"></i>--%>
  <%--<span class="business_tel">全国服务热线：400-1224-365</span>--%>
  <%--</p>--%>
  <%--</div>--%>
  <%--</div>--%>
  <%--</header>--%>
  <header>
    <a id="logo" title="<spring:message code="logo.title" />">Apereo</a>
    <%--<h1>Central Authentication Service (CAS)</h1>--%>
  </header>
  <div id="content">
