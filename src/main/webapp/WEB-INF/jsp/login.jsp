<%-- 
    Document   : login
    Created on : Aug 14, 2022, 11:42:03 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h3 class="text-success" style="margin: 20px 0">Trang Đăng Nhập</h3>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Something went wrong!
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Unauthorized
    </div>
</c:if>

<c:url value="/login" var="action" />

<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label> 
        <input type="text" id="username" name="username" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="password">Mật khẩu</label>
        <input type="password" id="password" name="password" class="form-control" />
    </div>
    
    <div class="form-group">
        <input type="submit" value="Đăng nhập" class="btn btn-success" />
    </div>
</form>
