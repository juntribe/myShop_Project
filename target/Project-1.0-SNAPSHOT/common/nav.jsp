<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2021/05/20
  Time: 5:01 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<html>
<head>


    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="bootstrap/assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="bootstrap/css/styles.css" rel="stylesheet" />


    <script src="js/jquery-3.6.0.js"></script>
    <script src="http://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        #cart{
            margin-left: 10px;
        }
        * {box-sizing: border-box;}

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #e9e9e9;
        }

        .topnav a {
            float: left;
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #2196F3;
            color: white;
        }

        .topnav .search-container {
            float: right;
        }

        .topnav input[type=text] {
            padding: 6px;
            margin-top: 8px;
            font-size: 17px;
            border: none;
        }

        .topnav .search-container button {
            float: right;
            padding: 6px 10px;
            margin-top: 8px;
            margin-right: 16px;
            background: #ddd;
            font-size: 17px;
            border: none;
            cursor: pointer;
        }

        .topnav .search-container button:hover {
            background: #ccc;
        }

        @media screen and (max-width: 600px) {
            .topnav .search-container {
                float: none;
            }
            .topnav a, .topnav input[type=text], .topnav .search-container button {
                float: none;
                display: block;
                text-align: left;
                width: 100%;
                margin: 0;
                padding: 14px;
            }
            .topnav input[type=text] {
                border: 1px solid #ccc;
            }
        }

    </style>
    <script type="text/javascript">
        var loopSearch=true;
        function keywordSearch(){
            if(loopSearch==false)
                return;
            var value=document.frmSearch.searchWord.value;
            $.ajax({
                type : "get",
                async : true, //false인 경우 동기식으로 처리한다.
                url : "/goods/keywordSearch.gd",
                data : {search:value},
                success : function(data, textStatus) {
                    var jsonInfo = JSON.parse(data);
                    displayResult(jsonInfo);
                },
                error : function(data, textStatus) {
                    alert("에러가 발생했습니다."+data);
                },
                complete : function(data, textStatus) {
                    //alert("작업을완료 했습니다");

                }
            }); //end ajax
        }

    </script>
    <title>Title</title>
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/">프로젝트</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link" aria-current="page"
                                        href="/main">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="boardList.bo">게시판</a></li>

            </ul>

                <div class="search-container">
                    <form action="">
                        <input type="text" placeholder="Search.." name="search">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>



            <%
                String id = (String)session.getAttribute("id");

                if(id == null){
                 %>
            <a class="nav-link" href="./MemberLogin.mm">로그인</a>
            <%
                }
                else {
            %>
            <a class="nav-link" href="./MemberLogout.mm">로그아웃</a>

            <a href="./MemberInfo.mm">마이페이지</a>
            <%
            }

            %>


            <form class="d-flex" action="CartList.gd">
                <button id="cart" class="btn btn-outline-dark" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                     Cart

                    <span class="badge bg-dark text-white ms-1 rounded-pill">${cartList.size()}</span>
                </button>
                <%
                    if (id != null && id.equals("admin")){
                %>

               <u><small> <a class="nav-link" href="./admin/admin.mm">관리자</a></small></u>
                <%
                    }
                %>
            </form>
        </div>
    </div>
</nav>


</body>
</html>
