<%-- 
    Document   : adminDoanhThuStats
    Created on : Aug 19, 2022, 4:09:57 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Thống kê doanh thu tuyến xe theo tháng và quý trong năm</h3>

<form class="find_form">
    <div class="form-group">
        <label>Điểm đi: </label>
        <input type="text" name="diemDi" class="form-control" />
    </div>
    
    <div class="form-group">
        <label>Điểm đến: </label>
        <input type="text" name="diemDen" class="form-control" />
    </div>
    
    <div class="form-group">
        <label>Ngày bắt đầu: </label>
        <input type="date" name="fromDate" class="form-control" />
    </div>
    
    <div class="form-group">
        <label>Ngày kết thúc: </label>
        <input type="date" name="toDate" class="form-control" />
    </div>
    
    <input type="submit" value="Thống kê" class="btn btn-success" />
</form>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${doanhThuStats}" var="p">
        <tr>
            <td>${p[0]}/${p[1]}</td>
            <td>${p[2]} VND</td>
        </tr>
    </c:forEach>
</table>

<div style="width: 800px; margin: 20px 0">
    <canvas id="doanhThuStatsByMonthChart"></canvas>
</div>

<script>
    window.onload = () => {
        let categoryLabels = []
        let categoryData = []
        
        <c:forEach items="${doanhThuStats}" var="p">
            categoryLabels.push('${p[0]}/${p[1]}')
            categoryData.push(${p[2]})
        </c:forEach>
            
        doanhThuStatsByMonth('doanhThuStatsByMonthChart', categoryLabels, categoryData);
    }
</script>