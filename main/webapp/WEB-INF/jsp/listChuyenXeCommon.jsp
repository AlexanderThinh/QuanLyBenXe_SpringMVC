<%-- 
    Document   : listChuyenXeCommon
    Created on : Aug 19, 2022, 6:24:17 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Danh sách chuyến xe common</h3>

<c:if test="${listChuyenXe.size() > 0}">
    <p>Có ${listChuyenXe.size()} chuyến xe được tìm thấy</p>
    
    <table class="table" id="tableCompareChuyenXe">
        <tr>
            <th>Nhà xe</th>
            <th>Biển số</th>
            <th>Tuyến đường</th>
            <th>Giá vé</th>
            <th>Dịch vụ</th>
        </tr>
        <c:forEach items="${listChuyenXe}" var="cx">
            <tr>
                <td>${cx.nhaXeId.tenNhaXe}</td>
                <td>${cx.bienSo}</td>
                <td>${cx.tuyenXeId.diemDi} -> ${cx.tuyenXeId.diemDen}</td>
                <td>${cx.gia} VND</td>
                <td>${cx.dichVu}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${listChuyenXe.size() == 0}">
    <div class="alert alert-danger">
        <p>Không tìm thấy thông tin chuyến xe!</p>
    </div>
</c:if>
