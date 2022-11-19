<%-- 
    Document   : adminQuanLyNhaXe
    Created on : Aug 16, 2022, 11:29:41 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Quản lý Nhà Xe</h3>

<div class="spinner-border" id="spinnerLoadProduct"></div>

<table class="table">
    <tr>
        <th>Tên nhà xe</th>
        <th>Hoạt động</th>
        <th>Nhận giao hàng</th>
        <th></th>
    </tr>
    <tbody id="mainID">
        
    </tbody>
</table>

<script>
    <c:url value="/api/get-all-nha-xe" var="endpoint" />
    <c:url value="/api/update-active-nha-xe" var="endpointKhoaNX" />
    
    window.onload = () => {
        loadDSNhaXe(`${endpoint}`, `${endpointKhoaNX}`)
        
    }
</script>
