<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Create Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head><!--/head-->

<body>
    <jsp:include page="../common/nav.jsp"></jsp:include>

    <table class="table">
        <thead>
        <h1>${message}</h1>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Image</th>
            <th scope="col">Category</th>
            <th scope="col" colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.data}" var="product">
            <tr>
                <th scope="row">${product.id}</th>
                <td>${product.name}</td>
                <td >${product.price}</td>
                <td><img style="max-height: 200px; object-fit: cover;" src="${product.img}" alt=""></td>
                <td >${product.category}</td>
                <td><a href="/backend/product/edit/${product.id}">Sửa</a> <a href="/backend/product/delete/${product.id}">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${data.totalPages > 1}">
        <nav aria-label="Phân trang">
            <ul class="pagination">
                <li class="page-item <c:if test="${data.page == 1}"> disabled</c:if>"><a class="page-link" href="/backend/product/list?page=${data.page -1}">Trước</a></li>
                <c:forEach begin="1" end="${data.totalPages}" var="p" step="1">
                    <li class="page-item  <c:if test="${data.page == p}"> active</c:if>"><a class="page-link"  href="/backend/product/list?page=${p}">${p}</a></li>
                </c:forEach>
                <li class="page-item <c:if test="${data.page == data.totalPages}"> disabled</c:if>"><a class="page-link" href="/backend/product/list?page=${data.page+1}">Sau</a></li>
            </ul>
        </nav>
    </c:if>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>

</html>