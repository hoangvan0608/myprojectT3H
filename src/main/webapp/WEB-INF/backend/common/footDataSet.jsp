<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js" ></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js" ></script>
<script>
    $(document).ready(function() {
        $('#example').DataTable();
    } );
</script>
