<%-- 
    Document   : header
    Created on : Aug 11, 2022, 10:46:26 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="<c:url value="/" />"><i class="fa-solid fa-house"></i> Home</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
              Danh sách nhà xe
            </a>
            
            <div class="dropdown-menu">
              <c:forEach var="nhaXe" items="${listNhaXe}">
                <a class="dropdown-item" href="<c:url value="/" />nha-xe/${nhaXe.id}">${nhaXe.tenNhaXe}</a>
            </c:forEach>
            </div>
        </li>
        
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/booking" />">Vé trực tuyến</a>
        </li>
        
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/giao-hang" />">Vận chuyển hàng hóa</a>
        </li>
            
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li class="nav-item">
                <a class="nav-link text-primary" href="<c:url value="/register" />">Đăng ký</a>
            </li>

            <li class="nav-item">
                <a class="nav-link text-primary" href="<c:url value="/login" />">
                    <i class="fa-solid fa-right-to-bracket"></i>
                    Đăng nhập
                </a>
            </li>
        </c:if>
            
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item" style="display: flex; align-items: center; margin-left: 10px">
                <img src="${currentUser.avatar}" alt="${currentUser.username}" class="rounded-circle img-fluid" style="width: 20px" />
                <a class="nav-link text-primary" href="<c:url value="/login" />">${pageContext.request.userPrincipal.name}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-primary" href="<c:url value="/logout" />">
                    <i class="fa-solid fa-right-from-bracket"></i>
                    Đăng xuất
                </a>
            </li>
        </c:if>
    </ul>
  </div>
</nav>
