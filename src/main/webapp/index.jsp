<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="utf-8" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
<meta name="description" content=""/>
<meta name="author" content=""/>
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="common/bootstrap/assets/favicon.ico"/>
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
<!-- Core theme CSS (includes Bootstrap)-->
<link href="common/bootstrap/css/styles.css" rel="stylesheet"/>


<script src="common/js/jquery-3.6.0.js"></script>
<script src="http://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<!DOCTYPE html>
<html>
<head>
    <title>project</title>
</head>
<body>





<jsp:include page="common/nav.jsp"/>
<%--<jsp:include page="goods/List.jsp"/>--%>
<%--<c:redirect url="/"/>--%>
<jsp:forward page="/main"/>




</body>
</html>