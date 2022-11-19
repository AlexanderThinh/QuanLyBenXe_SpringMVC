<%-- 
    Document   : listChuyenXe
    Created on : Aug 12, 2022, 11:58:25 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<c:if test="${DSChuyenXe.size() != 0 && nhaXe.active == true}">
    <h3 class="text-center text-success" style="margin: 20px 0">Danh Sách Chuyến Xe Của Nhà Xe ${nhaXe.tenNhaXe}</h3>
    
    <form class="find_form">
        <div class="form-group" style="width: 80%; margin: 0 20px; border: 1px solid #ccc; padding: 20px; border-radius: 8px;">
            <label>Điểm đi: </label>
            <input type="text" name="diem-di" class="form-control" placeholder="Nhập điểm đi..." style="border: none" />
        </div>

        <div class="form-group" style="width: 80%; margin: 0 20px; border: 1px solid #ccc; padding: 20px; border-radius: 8px;">
            <label>Điểm đến: </label>
            <input type="text" name="diem-den" class="form-control" placeholder="Nhập điểm đến..." style="border: none" />
        </div>

        <div class="form-group" style="width: 80%; margin: 0 20px; border: 1px solid #ccc; padding: 20px; border-radius: 8px;">
            <label>Ngày đi: </label>
            <input type="date" name="ngay-di" class="form-control" />
        </div>

        <input type="submit" value="Tìm kiếm" class="btn btn-success" />
    </form>  

    <h5 class="text-success " style="margin: 20px 0;">Có ${DSChuyenXe.size()} chuyến xe được tìm thấy từ nhà xe ${nhaXe.tenNhaXe}</h5>
    
    <c:forEach items="${DSChuyenXe}" var="cx">
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
    
    <c:if test="${DSChuyenXe.size() > 1}">
        <button class="btn btn-success" id="btnCompareChuyenXe" style="margin: 0 0 20px 0;" onclick="">So sánh giá và dịch vụ của các chuyến xe</button>
        
        <table class="table" id="tableCompareChuyenXe">
            <tr>
                <th>Biển số</th>
                <th>Tuyến đường</th>
                <th>Loại xe</th>
                <th>Giá vé</th>
                <th>Dịch vụ</th>
            </tr>
            <c:forEach items="${DSChuyenXe}" var="cx">
                <tr>
                    <td>${cx.bienSo}</td>
                    <td>${cx.tuyenXeId.diemDi} -> ${cx.tuyenXeId.diemDen}</td>
                    <td>${cx.loaiXeId.tenLoaiXe}</td>
                    <td>${cx.gia} VND</td>
                    <td>${cx.dichVu}</td>
                </tr>
            </c:forEach>
        </table>
        
        <c:if test="${othersChuyenXe.size() > 0}">
            <h5 class="text-success title_index" style="margin: 20px 0">Các chuyến xe tương tự khác</h5>
            <table class="table">
                <tr>
                    <th>Biển số</th>
                    <th>Nhà xe</th>
                    <th>Tuyến đường</th>
                    <th>Loại xe</th>
                    <th>Giá vé</th>
                    <th>Dịch vụ</th>
                </tr>

                <c:set var = "stopValueLoop" scope = "session" value = "${valueForStopLoop}"/>

                <c:forEach items="${DSChuyenXe}" var="cxMain">  
                    <c:if test="${stopValueLoop == 1}">
                        <c:forEach items="${othersChuyenXe}" var="cxOther">
                            <c:if test="${cxOther.nhaXeId.tenNhaXe != cxMain.nhaXeId.tenNhaXe}">
                                <tr>
                                    <td>${cxOther.bienSo}</td>
                                    <td>${cxOther.nhaXeId.tenNhaXe}</td>
                                    <td>${cxOther.tuyenXeId.diemDi} -> ${cxOther.tuyenXeId.diemDen}</td>
                                    <td>${cxOther.loaiXeId.tenLoaiXe}</td>
                                    <td>${cxOther.gia} VND</td>
                                    <td>${cxOther.dichVu}</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </c:if>

                    <c:set var = "stopValueLoop" scope = "session" value = "${valueForStopLoop + 1}"/>
                </c:forEach>
            </table>
        </c:if>
    </c:if>  

    <c:if test="${currentUser != null}">
        <ul class="rating">
            <li class="rating-item" data-rate="1"></li>
            <li class="rating-item" data-rate="2"></li>
            <li class="rating-item" data-rate="3"></li>
            <li class="rating-item" data-rate="4"></li>
            <li class="rating-item" data-rate="5"></li>
        </ul>
    </c:if>
    
        
    <form style="margin: 20px 0">
        <c:url value="/api/add-comment/${nhaXeID}" var="apiCommentNX" />

        <div class="form-group">
            <textarea id="commentContent" class="form-control" placeholder="Nhập bình luận..." rows="4"></textarea>
        </div>
        <a href="javascript:;" class="btn btn-success" onclick="addCommentNhaXe(`${apiCommentNX}`)">Bình luận</a>
    </form>

    <div id="commentBlock">
        <c:forEach items="${nhaXe.commentSet}" var="comment">
            <div class="row" style="margin: 20px 0">
                <div class="col-md-1">
                    <img src="<c:url value="${comment.user.avatar}" />" class="rounded-circle img-fluid" />
                </div>
                <div class="col-md-11 myDate">
                    <p class="text-primary">${comment.user.username}</p>
                    <p>${comment.noiDung}</p>
                    <i>${comment.createdDate}</i>
                </div>
            </div>
        </c:forEach>
    </div> 
</c:if>      

<c:if test="${DSChuyenXe.size() == 0}">
    <h4 class="text-center text-success" style="margin: 20px 0">Không tìm thấy thông tin chuyến xe</h4>
</c:if>
    
<c:if test="${nhaXe.active == false}">
    <div class="alert alert-danger" style="margin: 20px 0">
        <h5>${nhaXe.tenNhaXe} đã bị khóa, vui lòng liên hệ quản trị viên để biết thêm thông tin!</h5>
    </div>
</c:if>
         
<script>
    <c:url value="/api/nha-xe/rating/${nhaXeID}" var="endpointRating" />
    
    if(${rateListLength} > 0) {
        let ratingItemActive = document.querySelector('.rating :nth-child(${rate.rate})')
        if (ratingItemActive != null) {
            ratingItemActive.classList.add('active')
        }
    }
    
    window.onload = () => {
        let tableCompareChuyenXe = document.querySelector('#tableCompareChuyenXe')     
        let btnCompareChuyenXe = document.querySelector('#btnCompareChuyenXe')

        if (tableCompareChuyenXe != null) {
            tableCompareChuyenXe.style.display = 'none'

            btnCompareChuyenXe.onclick = () => {
                if (tableCompareChuyenXe.style.display == 'block') {
                    tableCompareChuyenXe.style.display = 'none'
                } else if (tableCompareChuyenXe.style.display == 'none') {
                    tableCompareChuyenXe.style.display = 'block'
                }
            }
        }
        
        let dateBlock = document.querySelectorAll(".myDate > i")
        for (let i = 0; i < dateBlock.length; i++) {
            dateBlock[i].innerText = moment(dateBlock[i].innerText).fromNow()
        }
        
//        For rating
        ratingNhaXe(`${endpointRating}`)
    }
</script>