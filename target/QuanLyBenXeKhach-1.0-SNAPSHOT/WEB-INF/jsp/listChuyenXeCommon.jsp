<%-- 
    Document   : listChuyenXeCommon
    Created on : Aug 19, 2022, 6:24:17 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Danh sách chuyến xe common</h3>

<c:if test="${listChuyenXe.size() > 0}">
    <p class="text-success" style="font-size: 20px; font-weight: 600;">Có ${listChuyenXe.size()} chuyến xe được tìm thấy</p>
    
    <c:forEach items="${listChuyenXe}" var="cx">
        <li class="chuyen_xe_info">
            <p><i class="fa-solid fa-table chuyen_xe_info_icon"></i><i style="font-weight: 600">Biển số</i>: ${cx.bienSo}</p>
            <p><i class="fa-solid fa-bus chuyen_xe_info_icon"></i><i style="font-weight: 600">Loại xe</i>: ${cx.loaiXeId.tenLoaiXe}</p>
            <p><i class="fa-solid fa-location-crosshairs chuyen_xe_info_icon"></i><i style="font-weight: 600">Điểm đi</i>: ${cx.tuyenXeId.diemDi}</p>
            <p><i class="fa-solid fa-location-dot chuyen_xe_info_icon"></i><i style="font-weight: 600">Điểm đến</i>: ${cx.tuyenXeId.diemDen}</p>
            <p><i class="fa-solid fa-dollar-sign chuyen_xe_info_icon"></i><i style="font-weight: 600">Giá vé</i>: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cx.gia}" /> VND</p>
            <p><i class="fa-solid fa-calendar-days chuyen_xe_info_icon"></i><i style="font-weight: 600">Ngày đi</i>: <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${cx.ngayDi}" /></p>
            <td>
                <a id="btnSelectBooking${cx.id}" onclick="showBookingDetail(${cx.id})" class="btn btn-success">Chọn</a>
            </td>
        </li> 
        
        <div style="display: none" class="bookingDetail${cx.id}">
            <c:set var = "styleDisplay" scope = "session" value = "${'flex'}"/>

            <form style="display: ${styleDisplay}; flex-wrap: wrap; width: 250px; margin: 0 20px">

                <c:forEach begin="1" end="${cx.soGhe}" var="soGhe">                                    
                    <c:if test="${soGhe <= cx.soGhe}">
                        <div class="form-check" style="margin: 0 6px">
                            <input name="checkBoxSoGhe${cx.id}" onclick="testSelectCheckBoxValue(${cx.id}, ${cx.gia})" type="checkbox" class="form-check-input" value="${soGhe}">
                            <label class="form-check-label" for="exampleCheck1" style="margin-left: -6px">${soGhe}</label>
                        </div>  
                    </c:if> 
                </c:forEach>
            </form>
            <form style="width: 100%">
                <div class="form-group">
                    <label>Họ tên: </label>
                    <input type="text" name="bookingName${cx.id}" class="form-control" />
                </div>

                <div class="form-group">
                    <label>Email: </label>
                    <input type="email" name="bookingEmail${cx.id}" class="form-control" />
                </div>

                <div class="form-group">
                    <label>Số điện thoại: </label>
                    <input type="text" name="bookingPhone${cx.id}" class="form-control" />
                </div>
            </form> 
        </div>
                
        <c:url value="api/booking" var="endpointBooking2" />
                        
        <div style="display: none" class="bookingDetail${cx.id}">
            <p><i class="quantityVe${cx.id}">0</i> vé</p>
            <p style="margin: 0 30px">Tổng tiền: <i class="totalMoney${cx.id}">0</i> VND</p>
            <div class="spinner-border mySpinner${cx.id}" style="display: none"></div>
            <input onclick="handleBooking(`http://localhost:8080/QuanLyBenXeKhach/api/booking`, `${cx.id}`, `${cx.gia}`)" value="Đặt vé" class="btn btn-success btn_booking${cx.id}" />
        </div>
    </c:forEach>  
</c:if>

<c:if test="${listChuyenXe.size() == 0}">
    <div class="alert alert-danger">
        <p>Không tìm thấy thông tin chuyến xe!</p>
    </div>
</c:if>
