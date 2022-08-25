<%-- 
    Document   : index
    Created on : Aug 11, 2022, 4:51:29 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page </title>
    </head>
    <body>  
        <%--<c:url value="/sendEmail" var="actionSendEmail" />--%>
<!--        <form style="width: 100%" method="post" action="${actionSendEmail}">
            <div class="form-group">
                <label>Người gửi: </label>
                <input type="email" name="from" class="form-control" />
            </div>

            <div class="form-group">
                <label>Người nhận: </label>
                <input type="email" name="to" class="form-control" />
            </div>

            <div class="form-group">
                <label>Subject: </label>
                <input type="text" name="subject" class="form-control" />
            </div>
            
            <div class="form-group">
                <label>Message: </label>
                <input type="text" name="message" class="form-control" />
            </div>
            
            <input type="submit" value="Send email" class="btn btn-success" />
        </form> -->
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div>
                <a class="btn btn-primary" href="<c:url value="/admin/them-nha-xe" />">Thêm nhà xe</a>
                <a class="btn btn-primary" href="<c:url value="/admin/quan-ly-nha-xe" />">Quản lý nhà xe</a>
                <a class="btn btn-primary" href="<c:url value="/admin/doanh-thu-stats" />">Thống kê doanh thu tuyến xe theo tháng và quý trong năm</a>
                <a class="btn btn-primary" href="<c:url value="/admin/doanh-thu-stats-by-year" />">Thống kê doanh thu tuyến xe theo năm</a>
            </div>
        </sec:authorize>
        
        <sec:authorize access="hasRole('ROLE_NHA_XE')">
            <div>
                <a class="btn btn-primary" href="<c:url value="/nx/them-nha-xe" />">Đăng ký nhà xe</a>
                <a class="btn btn-primary" href="<c:url value="/chuyen-xe/create" />">Đăng ký chuyến xe</a>
                <a class="btn btn-primary" href="<c:url value="/tuyen-xe/create" />">Đăng ký tuyến xe</a>
            </div>
        </sec:authorize>
        
        <h3 class="text-success" style="margin: 20px 0">Tìm kiếm chuyến xe</h3>
        
        <c:url value="/chuyen-xe/list" var="actionListCXCommon" />
        <form action="${actionListCXCommon}">
            <div class="form-group">
                <label>Điểm đi: </label>
                <input type="text" name="diem-di" class="form-control" />
            </div>

            <div class="form-group">
                <label>Điểm đến: </label>
                <input type="text" name="diem-den" class="form-control" />
            </div>

            <div class="form-group">
                <label>Ngày đi: </label>
                <input type="date" name="ngay-di" class="form-control" />
            </div>

            <input type="submit" value="Tìm kiếm" class="btn btn-success" />
        </form> 
            
        <h3 class="text-success" style="margin: 20px 0">Các tuyến xe phổ biến</h3>
        
        <div id="listTuyenXeBlock">
            
        </div>
        
        <button id="btnTest" onclick="testBtn()">Hello</button>
        
        <h5>Thông tin tuyến xe id = 2</h5>
        <p class="text-danger">Điểm đi: ${tx2.diemDi} - Điểm đến: ${tx2.diemDen}</p>
        
        <h5>Danh sách các chuyến xe của tuyến xe id = 2</h5>
        <c:forEach items="${tx2.chuyenXeSet}" var="cx">
            <li>Biển số: ${cx.bienSo}</li>
        </c:forEach>
        
        <spring:message code="label.firstName" />
        
        <h5>Danh sách bến xe</h5>
        <ul>
            <c:forEach items="${listBenXe}" var="benXe">
                <p>${benXe.id} - ${benXe.tenBenXe}</p>
            </c:forEach>
        </ul>
        
        <h5>Danh sách nhà xe</h5>
        <ul>
            <c:forEach items="${listNhaXe}" var="nhaXe">
                <p>${nhaXe.id} - ${nhaXe.tenNhaXe}</p>
            </c:forEach>
        </ul>
        
        <h5>Các comment cua user 2</h5>
        <ul>
            <c:forEach items="${user2.commentSet}" var="c">
                <p>${c.noiDung}</p>
            </c:forEach>
        </ul>
    </body>
</html>

<script>
    <c:url value="/api/get-top-tuyen-xe" var="endpoint" />
    <c:url value="/tuyen-xe" var="endpointDetailChuyenXe" />
        
    window.onload = () => { 
        listTuyenXe(`${endpoint}`, `${endpointDetailChuyenXe}`)
    }
</script>
