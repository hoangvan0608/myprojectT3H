<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category</title>
    <jsp:include page="../common/headDataSet.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../common/nav.jsp"></jsp:include>

<div class="container">
    <div class="bg-light p-5 rounded">
        <div class="col-sm-8 mx-auto">
            <br>
            <h1>Thể Loại Sản Phẩm</h1>
            <h2 style="color: red">${message}</h2>
            <table  id="example" class="table table-striped" style="width:100%">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên loại sản phẩm</th>
                    <th>Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="stt" value="1"></c:set>
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <th scope="row">${stt}</th>
                        <td>${category.name}</td>
                        <td><a href="/backend/category/edit/${category.id}">Sửa</a>
                            <a href="/backend/category/delete/${category.id}">Xóa</a></td>
                    </tr>
                    <c:set var="stt" value="${stt + 1}"></c:set>
                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>
</div>
<jsp:include page="../common/footDataSet.jsp"></jsp:include>
</body>


</html>



