<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Create Product</title>
    <jsp:include page="../common/head.jsp"></jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head><!--/head-->

<body>

<jsp:include page="../common/nav.jsp"></jsp:include>

<div class="container">
    <center><h1>Edit Product</h1></center>
    <form class="row g-3 needs-validation" novalidate action="/backend/product/save" method="post">
        <div class="col-md-5">
            <input name="id" value="${product.id}" hidden="true">
            <label for="name" class="form-label">Product name</label>
            <input type="text" class="form-control" id="name" name="name" value="${product.name}" placeholder="Product name" required>
            <div class="valid-feedback">
                Looks good!
            </div>
            <div class="invalid-feedback">
                Vui lòng nhập tên
            </div>
        </div>
        <div class="col-md-4">
            <label for="des" class="form-label">Product Description</label>
            <input type="text" class="form-control" id="des" value="${product.des}" name="des" placeholder="Product name" required>
            <div class="valid-feedback">
                Looks good!
            </div>
            <div class="invalid-feedback">
                Vui lòng nhập mô tả
            </div>
        </div>
        <div class="col-md-3">
            <label for="validationCustom04" class="form-label">Product Category</label>
            <select name="category" class="form-select" id="validationCustom04" required>
                <option selected disabled value="">Chọn thể loại</option>
                <c:forEach items="${category}" var="category">
                    <option value="${category.id}" <c:if test="${product.category == category.id}">selected</c:if>>${category.name}</option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">
                Vui lòng chọn loại sản phẩm
            </div>
        </div>
        <div class="col-md-4">
            <label for="price" class="form-label">Product price</label>
            <input type="number" min = "0" class="form-control" id="price" value="${product.price}" name="price" placeholder="Product price" required>
            <div class="valid-feedback">
                Looks good!
            </div>
            <div class="invalid-feedback">
                Vui lòng nhập giá
            </div>
        </div>
        <div class="col-md-8">
            <label for="img" class="form-label">Product image file</label>
            <input class="form-control" name="img" type="file" id="img" src="api/product-image/${product.img}" required >  <%--/${product.img} = 1--%>
            <%--                <div class="valid-feedback">--%>
            <%--                    Looks good!--%>
            <%--                </div>--%>
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
        ${aleft}
    </form>
</div>
<jsp:include page="../common/foot.jsp"></jsp:include>
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
