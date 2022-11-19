<%-- 
    Document   : index
    Created on : Aug 11, 2022, 4:51:29 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page </title>
    </head>
    <body>  
        <div class="contact_block">
            <div class="contact_info">
                <div class="contact_info_detail">
                    <i class="fa-solid fa-phone"></i>
                    <p style="margin: 0 10px 0">0866683072</p>
                </div>
                <div class="contact_info_detail">
                    <i class="fa-solid fa-envelope"></i>
                    <p style="margin: 0 10px 0">alexanderthinh@gmail.com</p>
                </div>
            </div>
            <div>
                <i class="fa-brands fa-facebook" style="font-size: 18px"></i>
                <i class="fa-brands fa-youtube" style="margin: 0 20px; font-size: 18px"></i>
                <i class="fa-brands fa-instagram" style="font-size: 18px"></i>
            </div>
        </div>
        <img src="https://res.cloudinary.com/dk2yfgnb4/image/upload/v1662735089/slider_nvuh2k.png" style="width: 100%" alt="logo"/>
        <c:if test="${currentUser != null}">
            <c:set var = "username" scope = "session" value = "${currentUser.username}"/>
            <p id="username" style="opacity: 0">${currentUser.username}</p>
        </c:if>
            
        <p class="title_chat" onclick="handleShowTitleChat()">Trò chuyện trực tuyến</p>   
        <div id="chat">
            
            <button class="btn btn-danger" onclick="testScrollBottom()" style="opacity: 0">Scroll</button>
            <!-- messages will display here -->
            <ul id="messages"></ul>

            <!-- form to send message -->
            <form id="message-form" onsubmit="sendMessage(event, '${username}')"> 
                <input id="message-input" placeholder="Viết phản hồi" type="text" />
                <button id="message-btn" type="submit" class="btn btn-primary">Send</button>
            </form>
        </div>
        <%--<c:url value="/sendEmail" var="actionSendEmail" />--%>
<!--        <form style="width: 100%" method="post" action="${actionSendEmail}">
            <div class="form-group">
                <label>Người gửi: </label>
                <input type="email" name="from" class="form-control" />
            </div>

            <div class="form-group">
                <label>Người nhận: </label>
                <input type="email" name="to" class="form-control" />
            </div>

            <div class="form-group">
                <label>Subject: </label>
                <input type="text" name="subject" class="form-control" />
            </div>
            
            <div class="form-group">
                <label>Message: </label>
                <input type="text" name="message" class="form-control" />
            </div>
            
            <input type="submit" value="Send email" class="btn btn-success" />
        </form> -->
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div>
                <a class="btn btn-primary" href="<c:url value="/admin/them-nha-xe" />">Thêm nhà xe</a>
                <a class="btn btn-primary" href="<c:url value="/admin/quan-ly-nha-xe" />">Quản lý nhà xe</a>
                <a class="btn btn-primary" href="<c:url value="/admin/doanh-thu-stats" />">Thống kê doanh thu tuyến xe theo tháng và quý trong năm</a>
                <a class="btn btn-primary" href="<c:url value="/admin/doanh-thu-stats-by-year" />">Thống kê doanh thu tuyến xe theo năm</a>
            </div>
        </sec:authorize>
        
        <sec:authorize access="hasRole('ROLE_NHA_XE')">
            <div>
                <a class="btn btn-primary" href="<c:url value="/nx/them-nha-xe" />">Đăng ký nhà xe</a>
                <a class="btn btn-primary" href="<c:url value="/chuyen-xe/create" />">Đăng ký chuyến xe</a>
                <a class="btn btn-primary" href="<c:url value="/tuyen-xe/create" />">Đăng ký tuyến xe</a>
            </div>
        </sec:authorize>
        
        <h3 class="text-success title_index" style="margin: 20px 0">Tìm kiếm chuyến xe</h3>
        
        <c:url value="/chuyen-xe/list" var="actionListCXCommon" />
        <form action="${actionListCXCommon}" class="find_form">
            <div class="form-group" style="width: 80%; margin: 0 20px; border: 1px solid #ccc; padding: 20px; border-radius: 8px;">
                <label>Điểm đi: </label>
                <input type="text" name="diem-di" class="form-control" placeholder="Nhập điểm đi..." style="border: none" />
            </div>

            <div class="form-group" style="width: 80%; margin: 0 20px; border: 1px solid #ccc; padding: 20px; border-radius: 8px;"">
                <label>Điểm đến: </label>
                <input type="text" name="diem-den" class="form-control" placeholder="Nhập điểm đến..." style="border: none" />
            </div>

            <div class="form-group" style="width: 80%; margin: 0 20px; border: 1px solid #ccc; padding: 20px; border-radius: 8px;"">
                <label>Ngày đi: </label>
                <input type="date" name="ngay-di" class="form-control" style="border: none" />
            </div>

            <input type="submit" value="Tìm kiếm" class="btn btn-success" style="margin-top: 70px" />
        </form> 
            
        <h3 class="text-success title_index" style="margin: 20px 0">Các tuyến xe phổ biến</h3>
        
        <div id="listTuyenXeBlock">
            
        </div>
        
        <div class="quality_block">
            <h4 class="quality_title">CHẤT LƯỢNG LÀ DANH DỰ</h4>
            <div class="quality">
                <div class="quality_detail">
                    <i class="fa-solid fa-people-group quality_icon"></i>
                    <div>
                        <p style="margin: 10px 0; font-size: 18px; font-weight: 500">Hơn 10 triệu khách hàng</p>
                        <p>Chúng tôi phục vụ hơn 20 triệu lượt khách/bình quân 1 năm trên toàn quốc</p>
                    </div>
                    
                    
                </div>
                <div class="quality_detail">
                    <i class="fa-solid fa-check quality_icon"></i>
                    <div>
                        <p style="margin: 10px 0; font-size: 18px; font-weight: 500">Hơn 150 phòng vé, phòng hàng</p>
                        <p>Chúng tôi có hơn 150 phòng vé, trạm trung chuyển, bến xe... trên toàn hệ thống</p>
                    </div>
                    
                </div>
                <div class="quality_detail">
                    <i class="fa-solid fa-bus-simple quality_icon"></i>
                    <div>
                        <p style="margin: 10px 0; font-size: 18px; font-weight: 500">Hơn 1200 chuyến mỗi ngày</p>
                        <p>Chúng tôi phục vụ hơn 1200 chuyến xe đường dài và liên tỉnh mỗi ngày</p>
                    </div>
                    
                </div>
            </div>
        </div>
    </body>
</html>

<script>
    <c:url value="/api/get-top-tuyen-xe" var="endpoint" />
    <c:url value="/tuyen-xe" var="endpointDetailChuyenXe" />
        
    window.onload = () => { 
        listTuyenXe(`${endpoint}`, `${endpointDetailChuyenXe}`)
    }
    
</script>
