<%-- 
    Document   : register
    Created on : Aug 15, 2022, 12:11:12 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center text-success" style="margin: 20px 0">Đăng Ký</h2>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action" />
<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
    <div class="form-group">
        <label for="firstname">First name</label>
        <form:input type="text" id="firstname" path="firstName" class="form-control" />
    </div>
     
    <div class="form-group">
        <label for="lastname">Last name</label>
        <form:input type="text" id="lastname" path="lastName" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="phone">Số điện thoại</label>
        <form:input type="text" id="phone" path="phone" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="avatar">Avatar</label>
        <form:input type="file" id="avatar" path="file" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="password">Mật khẩu</label>
        <form:input type="password" id="password" path="password" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="confirm-password">Nhập lại mật khẩu</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
    </div>
    
    <div class="form-group">
        <input type="submit" value="Đăng ký" class="btn btn-success" />
    </div>
</form:form>
