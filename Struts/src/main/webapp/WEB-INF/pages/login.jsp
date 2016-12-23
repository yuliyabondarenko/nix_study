<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Log in</title>

    <link href="<s:url value="/resources/lib/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<s:url value="/resources/css/shared.css"/>" rel="stylesheet"/>
    <link href="<s:url value="/resources/css/login.css"/>" rel="stylesheet"/>
</head>

<body>
<div class="container">
    <s:form action="login" class="form-login">
        <div class="centerLabel"><h2 class="form-signin-heading">Please sing in</h2></div>
        <s:textfield key="login" cssClass="form-control" placeholder="Login"/>
        <s:password key="password" cssClass="form-control" placeholder="Password"/>
        <s:submit cssClass="btn btn-lg btn-primary btn-block" value="Sign in"/>
    </s:form>

    <div class="centerLabel"><s:a href="/register"><h5>Register</h5></s:a></div>
</div>
</body>
</html>