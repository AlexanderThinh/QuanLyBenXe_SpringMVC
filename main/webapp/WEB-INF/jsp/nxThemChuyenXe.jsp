<%-- 
    Document   : nxThemChuyenXe
    Created on : Aug 17, 2022, 6:09:49 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Đăng ký chuyến xe</h3>

<form>
    <div class="form-group">
        <label for="bienSo">Biển số</label> 
        <input type="text" id="bienSo" name="bienSo" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="loaiXeID">Loại xe</label>
        <select type="text" id="loaiXeID" name="loaiXeID" cssClass="form-control">
            <c:forEach items="${DSLoaiXe}" var="lx">
                <option value="${lx.id}">${lx.tenLoaiXe}</option>
            </c:forEach>
        </select>
    </div>
            
    <div class="form-group">
        <label for="nhaXeID">Nhà xe</label>
        <select type="text" id="nhaXeID" name="nhaXeID" cssClass="form-control">
            <c:forEach items="${DSNhaXe}" var="nx">
                <option value="${nx.id}">${nx.tenNhaXe}</option>
            </c:forEach>
        </select>
    </div>
            
    <div class="form-group" style="display: flex; align-items: center">
        <label for="tuyenXeID">Tuyến xe</label>
        <select type="text" id="tuyenXeID" name="tuyenXeID" cssClass="form-control">
            <c:forEach items="${DSTuyenXe}" var="tx">
                <option value="${tx.id}">${tx.diemDi} -> ${tx.diemDen}</option>
            </c:forEach>
        </select>
        <a href="<c:url value="/tuyen-xe/create" />" class="btn btn-success">Tạo tuyến xe mới</a>
    </div>
    
    <div class="form-group">
        <label>Ngày đi: </label>
        <input type="date" name="ngayDi" class="form-control" />
    </div>
    
    <div class="form-group">
        <label>Ngày về: </label>
        <input type="date" name="ngayVe" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="soGhe">Số ghế</label> 
        <input type="number" id="soGhe" name="soGhe" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="gia">Giá vé</label> 
        <input type="number" id="gia" name="gia" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="dichVu">Dịch vụ</label> 
        <input type="text" id="dichVu" name="dichVu" class="form-control" />
    </div>
    
    <c:url value="/api/add-chuyen-xe" var="endpoint" />
    
    <div class="form-group">
        <input onclick="handleThemChuyenXe(`${endpoint}`)" value="Thêm chuyến xe" class="btn btn-success" />
    </div>
</form>
