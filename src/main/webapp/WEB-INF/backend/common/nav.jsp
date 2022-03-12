<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--Đây là file dùng làm navi(menu) cho trang backend--%>
<nav class="navbar navbar-expand-xxl navbar-dark bg-dark" aria-label="Seventh navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">BackendShop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExampleXxl" aria-controls="navbarsExampleXxl" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExampleXxl">
            <ul class="navbar-nav me-auto mb-2 mb-xl-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Trang chủ</a>
                </li>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="#">Link</a>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
                <%--                </li>--%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle " href="#" id="dropdownXxl" data-bs-toggle="dropdown" aria-expanded="false">Sản phẩm</a>
                    <ul class="dropdown-menu hove" aria-labelledby="dropdownXxl">
                        <li><a class="dropdown-item" href="/backend/product/create">Tạo mới</a></li>
                        <li><a class="dropdown-item" href="/backend/product/list">Danh sách</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle " href="#" id="dropdownXxl class11" data-bs-toggle="dropdown" aria-expanded="false">Thể loại</a>
                    <ul class="dropdown-menu hove" aria-labelledby="dropdownXxl">
                        <li><a class="dropdown-item" href="/backend/category/create">Tạo mới</a></li>
                        <li><a class="dropdown-item" href="/backend/category/list">Danh sách</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle " href="#" id="dropdownXxl class1" data-bs-toggle="dropdown" aria-expanded="false">Tài khoản</a>
                    <ul class="dropdown-menu hove" aria-labelledby="dropdownXxl">
                        <li><a class="dropdown-item" href="/backend/account/create">Tạo mới</a></li>
                        <li><a class="dropdown-item" href="/backend/account/list">Danh sách</a></li>
                    </ul>
                </li>
            </ul>
            <form>
                <input class="form-control" type="text" placeholder="Search" aria-label="Search">
            </form>
        </div>
    </div>
</nav>
