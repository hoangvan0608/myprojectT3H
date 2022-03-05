<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý tài khoản</title>
    <jsp:include page="../common/headDataSet.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../common/nav.jsp"></jsp:include>

<div class="container-fluid">
    <div class="bg-light p-5 rounded">
        <div class="col-sm-8 mx-auto">
            <br>
            <h1>Quản lý tài khoản</h1>
            <h2 style="color: red">${message}</h2>
            <table  id="example" class="table table-striped" style="width:100%">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Username</th>
                    <th scope="col">Phone number</th>
                    <th scope="col">Email</th>
                    <th scope="col">Role</th>
                    <th scope="col">Description</th>
                    <th scope="col">Option</th>

                </tr>
                </thead>
                <tbody>
                <c:set var="stt" value="1"></c:set>
                <c:forEach items="${accounts}" var="account">
                    <tr>
                        <th scope="row">${stt}</th>
                        <td>${account.username}</td>
                        <td>${account.phone}</td>
                        <td>${account.email}</td>
                        <td>${account.role}</td>
                        <td>${account.des}</td>

                        <td><a href="/backend/account/edit/${account.id}">Sửa</a>
                            <a href="/backend/account/delete/${account.id}">Xóa</a></td>
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