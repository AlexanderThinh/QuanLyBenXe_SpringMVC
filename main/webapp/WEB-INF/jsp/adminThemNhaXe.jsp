<%-- 
    Document   : adminThemNhaXe
    Created on : Aug 16, 2022, 5:06:46 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-success" style="margin: 20px 0">Thêm Nhà Xe</h3>

<form>
    <div class="form-group">
        <label for="tenNhaXe">Tên nhà xe</label>
        <input type="text" id="tenNhaXe" name="tenNhaXe" class="form-control" />
    </div>
     
    <div class="form-group">
        <label for="benXeId">Bến cho hoạt động</label>
        <select type="text" id="benXeId" name="benXeId" cssClass="form-control">
            <c:forEach items="${DSBenXe}" var="bx">
                <option value="${bx.id}">${bx.tenBenXe}</option>
            </c:forEach>
        </select>
    </div>
    
    <div class="form-check mb-2 mr-sm-2">
        <label class="form-check-label">
            <input class="form-check-input" id="inputNhanGiaoHang" type="checkbox"> 
          Nhận giao hàng
        </label>
    </div>
    
    <c:url value="/api/add-nha-xe" var="endpoint" />
    
    <div class="form-group">
        <input onclick="themNhaXe(`${endpoint}`)" value="Thêm nhà xe" class="btn btn-success" />
    </div>
</form>
