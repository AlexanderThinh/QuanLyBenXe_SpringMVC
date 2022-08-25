<%-- 
    Document   : tuyenXeDetail
    Created on : Aug 12, 2022, 5:17:49 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Chi Tiết Tuyến Xe ${tuyenXeID}</h3>
    
<div class="tx_info_detail_wrap">
    <h5 class="tx_title text-center">Thông tin tuyến xe</h5>
    <div class="tx_info_detail">
        <p><i><strong>Tuyến xe: </strong></i>${tuyenXe.diemDi} <i class="fa-solid fa-arrow-right"></i> ${tuyenXe.diemDen}</p>
        <p><strong>Quãng đường</strong>: ${tuyenXe.quangDuong} km</p>
        <p><strong>Lộ trình</strong>: ${tuyenXe.loTrinh}</p>
        <p><strong>Thời gian di chuyển</strong>: ${tuyenXe.timeDiChuyen}</p>
    </div>
</div>

<div class="tx_info_detail_wrap">
    <h5 class="cx_title text-center">Thông tin các chuyến xe tương ứng</h5>
    <c:forEach items="${tuyenXe.chuyenXeSet}" var="cx">
        <div class="cx_info_detail">
            <p><strong>Nhà xe: </strong>: ${cx.nhaXeId.tenNhaXe}</p>
            <p><i><strong>Biển số: </strong></i> ${cx.bienSo}</p>
            <p><strong>Ngày đi</strong>: ${cx.ngayDi}</p>
            <p><strong>Ngày về</strong>: ${cx.ngayVe}</p>
            <p><strong>Số ghế: </strong>: ${cx.soGhe} ghế</p>
            <p><strong>Giá vé: </strong>: ${cx.gia} VND</p>
            <p><strong>Dịch vụ: </strong>: ${cx.dichVu}</p>
            <p><strong>Loại xe: </strong>: ${cx.loaiXeId.tenLoaiXe}</p>
        </div>
    </c:forEach>
</div>

<script>
    <c:url value="/api/get-tuyen-xe/${tuyenXeID}" var="endpoint" />
    
    window.onload = () => {
        tuyenXeDetail(`${endpoint}`)
    }
</script>
