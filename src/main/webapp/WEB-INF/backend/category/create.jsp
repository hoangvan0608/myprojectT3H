<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../common/head.jsp"></jsp:include>
    <title>Sửa sản phẩm</title>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../common/nav.jsp"></jsp:include>
    <center><h1>Edit Product</h1></center>


    <div class="container">
        <form class="row g-3 needs-validation" novalidate action="/backend/product/update" method="POST">
            <div class="col-md-4">
                <input value="${account.id}" name="id" hidden="true">
                <label for="name" class="form-label">Tên thể loại</label>
                <input type="text" class="form-control" id="name" value="${account.username}" name="name" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" value="${account.phone}" name="phone" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${account.email}" placeholder="Email" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-2">
                <label for="validationCustom04" class="form-label">Loại toài khoản</label>
                <select name="role" class="form-select" id="validationCustom04" required>
                    <option selected disabled value="">${account.role}</option>
                    <%--                    <c:forEach items="${category}" var="category">--%>
                    <%--                        <option value="${category.name}">${category.name}</option>--%>
                    <%--                    </c:forEach>--%>
                    <option value="MANAGER">Manager</option>
                    <option value="ADMIN">Admin</option>
                    <option value="USER">User</option>
                </select>
            </div>
            <div class="col-md-6">
                <label for="description" class="form-label">Description</label>
                <input type="text" class="form-control" id="description" value="${account.description}" name="description" placeholder="description" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-12">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                    <label class="form-check-label" for="invalidCheck">
                        Agree to terms and conditions
                    </label>
                    <div class="invalid-feedback">
                        You must agree before submitting.
                    </div>
                </div>
            </div>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">Submit form</button>
            </div>
        </form>
    </div>
</div>



<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>