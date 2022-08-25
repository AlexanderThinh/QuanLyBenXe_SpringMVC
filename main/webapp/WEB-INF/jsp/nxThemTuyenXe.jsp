<%-- 
    Document   : nxThemTuyenXe
    Created on : Aug 17, 2022, 10:47:42 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Thêm Tuyến Xe</h3>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        <p>${errMsg}</p>
    </div>
</c:if>

<c:url value="/tuyen-xe/create" var="action" />
<form:form method="post" action="${action}" modelAttribute="tuyenXe" enctype="multipart/form-data">
    <div class="form-group">
        <label for="diemDi">Điểm đi</label>
        <form:input type="text" id="diemDi" path="diemDi" class="form-control" />
    </div>
     
    <div class="form-group">
        <label for="dienDen">Điểm đến</label>
        <form:input type="text" id="dienDen" path="diemDen" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="loTrinh">Lộ trình</label>
        <form:input type="text" id="loTrinh" path="loTrinh" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="quangDuong">Quãng đường (km)</label>
        <form:input type="text" id="quangDuong" path="quangDuong" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="timeDiChuyen">Thời gian di chuyển</label>
        <form:input type="text" id="timeDiChuyen" path="timeDiChuyen" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="image">Ảnh</label>
        <form:input type="file" id="image" path="file" class="form-control" />
    </div>
    
    <div class="form-group">
        <input type="submit" value="Thêm tuyến xe" class="btn btn-success" />
    </div>
</form:form>
