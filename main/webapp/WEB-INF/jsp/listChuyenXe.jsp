<%-- 
    Document   : listChuyenXe
    Created on : Aug 12, 2022, 11:58:25 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${DSChuyenXe.size() != 0 && nhaXe.active == true}">
    <h3 class="text-center text-success" style="margin: 20px 0">Danh Sách Chuyến Xe Của Nhà Xe ${nhaXeID}</h3>
    
    <c:if test="${currentUser != null}">
        <p>${rate.userId.username}: ${rate.rate} sao</p>
    </c:if>

    <h5 class="text-success" style="margin: 20px 0">Có ${DSChuyenXe.size()} chuyến xe được tìm thấy từ nhà xe ${nhaXe.tenNhaXe}</h5>
    
    <c:if test="${DSChuyenXe.size() > 1}">
        <button class="btn btn-success" id="btnCompareChuyenXe" onclick="">So sánh giá và dịch vụ của các chuyến xe</button>
        
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
        
        <p>${othersChuyenXe.size()}</p>
        
        <c:if test="${othersChuyenXe.size() > 0}">
            <h5 class="text-success" style="margin: 20px 0">Các chuyến xe tương tự khác</h5>
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
    
    <c:forEach items="${DSChuyenXe}" var="cx">
        <li>Biển số: ${cx.bienSo} - Loại xe: ${cx.loaiXeId.tenLoaiXe} - Điểm đi: ${cx.tuyenXeId.diemDi} - Điểm đến: ${cx.tuyenXeId.diemDen} - Ngày đi: ${cx.ngayDi}</li> 
    </c:forEach>    

    <form>
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