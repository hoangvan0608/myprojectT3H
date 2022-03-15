<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script>
    $("#fileUploadId").on("change", function (e) {
        var file = $(this)[0].files[0];// lấy file

        var reader = new FileReader();
        reader.onload = function(){
            var output = document.getElementById('outputImage');
            output.src = reader.result;
        };
        reader.readAsDataURL(file);
        var formData = new FormData();

        // add assoc key values, this will be posts values
        formData.append("file", file, file.name);
        formData.append("upload_file", true);

        $.ajax({// gọi api từ client lên server
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/api/image/uploadFile",
            xhr: function () {
                var myXhr = $.ajaxSettings.xhr();
                // if (myXhr.upload) {
                //     myXhr.upload.addEventListener('progress', that.progressHandling, false);
                // }
                return myXhr;
            },
            success: function (data) {
                if (data) {
                    $('#fileUploadName').val(data);
                    alert("Tải file " + data + " thành công");
                }
                else alert("Tải file " + data + " thất bại");
            },
            error: function (error) {
                alert("Có lỗi xảy ra!");
            },
            async: true,
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            timeout: 60000
        });
    });
    var imagesPreview = function(input, placeToInsertImagePreview) {
        if (input.files) {
            var filesAmount = input.files.length;

            for (i = 0; i < filesAmount; i++) {
                var reader = new FileReader();

                reader.onload = function(event) {
                    $($.parseHTML('<img>')).attr('src', event.target.result).appendTo(placeToInsertImagePreview);
                }

                reader.readAsDataURL(input.files[i]);
            }
        }

    };
</script>
