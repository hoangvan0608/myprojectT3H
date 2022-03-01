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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head><!--/head-->

<body>

<jsp:include page="../common/nav.jsp"></jsp:include>
    <center><h1>Add Product</h1></center>


    <div class="container">
        <form class="row g-3 needs-validation" novalidate action="/backend/product/save" method="post">
            <div class="col-md-5">
                <label for="name" class="form-label">Product name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Product name" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Vui lòng nhập tên
                </div>
            </div>
            <div class="col-md-4">
                <label for="des" class="form-label">Product Description</label>
                <input type="text" class="form-control" id="des" name="des" placeholder="Product name" required>
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
                        <option value="${category.name}">${category.name}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Vui lòng chọn loại sản phẩm
                </div>
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">Product price</label>
                <input type="number" min = "0" class="form-control" id="price" name="price" placeholder="Product price" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Vui lòng nhập giá
                </div>
            </div>
            <div class="col-md-8">
                <label for="urlimg" class="form-label">Product image file</label>
                <input class="form-control" name="img" type="file" id="urlimg" required >
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

<script src="/frontend/js/jquery.js"></script>
<script src="/frontend/js/bootstrap.min.js"></script>
<script src="/frontend/js/jquery.scrollUp.min.js"></script>
<script src="/frontend/js/price-range.js"></script>
<script src="/frontend/js/jquery.prettyPhoto.js"></script>
<script src="/frontend/js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
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
