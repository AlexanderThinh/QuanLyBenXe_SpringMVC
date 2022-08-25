<%-- 
    Document   : giaoHang
    Created on : Aug 24, 2022, 11:33:13 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Đăng ký giao hàng</h3>

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
    
    <div class="form-group">
        <label for="benXeId">Bến cho xuất phát</label>
        <select type="text" id="benXeId" name="benXeId" cssClass="form-control">
            <c:forEach items="${DSBenXe}" var="bx">
                <option value="${bx.id}">${bx.tenBenXe}</option>
            </c:forEach>
        </select>
    </div>

    <input type="submit" value="Tìm kiếm" class="btn btn-success" />
</form> 
            
<c:if test="${listChuyenXe.size() > 0}">
    <p>Có ${listChuyenXe.size()} chuyến xe được tìm thấy</p>
    
    <table class="table" id="tableCompareChuyenXe">
        <tr>
            <th>Nhà xe</th>
            <th>Biển số</th>
            <th>Tuyến đường</th>
            <th>Giá vé</th>
            <th>Dịch vụ</th>
            <th></th>
        </tr>
        <c:forEach items="${listChuyenXe}" var="cx">
            <tr>
                <td>${cx.nhaXeId.tenNhaXe}</td>
                <td>${cx.bienSo}</td>
                <td>${cx.tuyenXeId.diemDi} -> ${cx.tuyenXeId.diemDen}</td>
                <td>${cx.gia} VND</td>
                <td>${cx.dichVu}</td>
                <td>
                    <a id="btnSelectGiaoHang${cx.id}" onclick="handleShowInfoGiaoHang(${cx.id})" class="btn btn-success">Chọn</a>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="infoGiaoHang${cx.id}" style="display: none">
                        <form>
                            <div class="form-group">
                                <label>Họ tên người gửi: </label>
                                <input type="text" name="name-nguoi-gui${cx.id}" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Số điện thoại người gửi: </label>
                                <input type="text" name="phone-nguoi-gui${cx.id}" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Email người gửi </label>
                                <input type="email" name="email-nguoi-gui${cx.id}" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Mô tả hàng hóa: </label>
                                <input type="text" name="desc-hang-hoa${cx.id}" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Khối lượng(kg): </label>
                                <input onchange="handleChangeValueKL(${cx.id})" type="number" name="KL-hang-hoa${cx.id}" min="0" class="form-control" />
                            </div>
                        </form> 
                        
                        <c:url value="/api/giao-hang" var="endpointGiaoHang" />
                        <p>Tổng tiền: <i id="totalMoneyDatHang${cx.id}">0</i> VND</p>
                        <button onclick="handleRegisterGiaoHang(${cx.id}, `${endpointGiaoHang}`)" class="btn btn-success">Đăng ký giao hàng</button>
                    </div>
                </td>
                <td colspan="3">
                    <div class="infoGiaoHang${cx.id}" style="display: none">
                        <form>
                            <div class="form-group">
                                <label>Họ tên người nhận </label>
                                <input type="text" name="name-nguoi-nhan${cx.id}" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Số điện thoại người nhận: </label>
                                <input type="text" name="phone-nguoi-nhan${cx.id}" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Email người nhận: </label>
                                <input type="email" name="email-nguoi-nhan${cx.id}" class="form-control" />
                            </div>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${listChuyenXe.size() == 0}">
    <div class="alert alert-danger">
        <p>Không tìm thấy thông tin chuyến xe!</p>
    </div>
</c:if>
    
<script>

</script>
