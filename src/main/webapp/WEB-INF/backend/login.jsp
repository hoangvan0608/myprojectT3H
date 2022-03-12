<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <jsp:include page="/WEB-INF/backend/common/head.jsp"/>
    <title>Tạo mới thể loại!</title>
</head>
<body>

<div class="container">
    <div class="bg-light p-5 rounded">
        <div class="col-sm-8 mx-auto">
            <br>
            <h1>Đăng nhập</h1>
            <form class="row g-3 needs-validation"  action="/_admin/doLogin" method="post" >
                <div class="col-md-4">
                    <label for="validationCustom01" class="form-label">Tên đăng nhập</label>
                    <input type="text" name="username" class="form-control"  id="validationCustom01" value=""/>
                </div>
                <div class="col-md-4">
                    <label  class="form-label">Mật khẩu</label>
                    <input type="password" name="password" class="form-control" id="password" />
                </div>

                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Đăng nhập</button>
                </div>
            </form>
        </div>
    </div>

</div>


<jsp:include page="/WEB-INF/backend/common/foot.jsp"/>
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>

</body>
</html>
