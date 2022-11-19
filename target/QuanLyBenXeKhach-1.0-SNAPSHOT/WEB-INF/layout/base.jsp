<%-- 
    Document   : base
    Created on : Aug 11, 2022, 10:46:12 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value="/css/style.css" />" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>
        <!--HEADER-->
        <tiles:insertAttribute name="header" />
        
        <div class="container">
            <!--CONTENT-->
            
           
            
            <tiles:insertAttribute name="content" />
        </div>
        
        <!--FOOTER-->
        <tiles:insertAttribute name="footer" />
        
        <script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-app.js"></script>
        <script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-database.js"></script>
        <script src="<c:url value="/js/main.js" />"></script>
        <script src="<c:url value="/js/nhaXe.js" />"></script>
        <script src="<c:url value="/js/admin.js" />"></script>
    </body>
</html>
