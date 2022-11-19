<%-- 
    Document   : booking
    Created on : Aug 22, 2022, 11:22:18 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Trang đặt vé xe trực tuyến</h3>

<form class="find_form">
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
    
    <div class="form-group" style="display: flex; flex-direction: column;">
        <label for="benXeId">Bến cho xuất phát</label>
        <select type="text" id="benXeId" name="benXeId" cssClass="form-control" style="padding: 6px; border-radius: 6px;">
            <c:forEach items="${DSBenXe}" var="bx">
                <option value="${bx.id}">${bx.tenBenXe}</option>
            </c:forEach>
        </select>
    </div>

    <input type="submit" value="Tìm kiếm" class="btn btn-success" style="margin-top: 12px" />
</form> 

<c:if test="${listChuyenXe.size() > 0}">
    <p class="text-success" style="font-size: 20px; font-weight: 600; margin: 20px 0;">Có ${listChuyenXe.size()} chuyến xe được tìm thấy</p>
    
    <table class="table" id="tableCompareChuyenXe">
        <tr>
            <th>Nhà xe</th>
            <th>Biển số</th>
            <th>Tuyến đường</th>
            <th>Giờ xe chạy</th>
            <th>Giá vé</th>
            <th>Dịch vụ</th>
            <th></th>
        </tr>
        <c:forEach items="${listChuyenXe}" var="cx">
            <div style="display: flex; flex-direction: column">
                <tr>
                    <td>${cx.nhaXeId.tenNhaXe}</td>
                    <td>${cx.bienSo}</td>
                    <td>${cx.tuyenXeId.diemDi} -> ${cx.tuyenXeId.diemDen}</td>
                    <td>${cx.gioXeChay}</td>
                    <td>${cx.gia} VND</td>
                    <td>${cx.dichVu}</td>
                    <td>
                        <a id="btnSelectBooking${cx.id}" onclick="showBookingDetail(${cx.id})" class="btn btn-success">Chọn</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="6">
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
                    </td>
                </tr>
                <tr>
                    <td colspan="6">
                        <c:url value="api/booking" var="endpointBooking" />
                        
                        <div style="display: none" class="bookingDetail${cx.id}">
                            <p><i class="quantityVe${cx.id}">0</i> vé</p>
                            <p style="margin: 0 30px">Tổng tiền: <i class="totalMoney${cx.id}">0</i> VND</p>
                            <div class="spinner-border mySpinner${cx.id}" style="display: none"></div>
                            <input onclick="handleBooking(`${endpointBooking}`, `${cx.id}`, `${cx.gia}`)" type="submit" value="Đặt vé" class="btn btn-success btn_booking${cx.id}" />
                        </div>
                    </td>
                </tr>
            </div>
        </c:forEach>
    </table>
</c:if>

<c:if test="${listChuyenXe.size() == 0}">
    <div class="alert alert-danger">
        <p>Không tìm thấy thông tin chuyến xe!</p>
    </div>
</c:if>
    
<script>
    window.onload = () => {
        
    }
</script>