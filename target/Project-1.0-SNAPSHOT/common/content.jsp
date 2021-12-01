<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.Project.goods.vo.Goods" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2021/05/22
  Time: 1:15 오후
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Shop Homepage</title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="common/bootstrap/assets/favicon.ico" />
  <!-- Bootstrap icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="common/bootstrap/css/styles.css" rel="stylesheet" />




  <title>Title</title>
  <style>
    nav{

      margin: auto auto 30px;
    }

    header {
      margin: auto;
      text-align: center;
      width: auto;
    }


    section{

      width: auto;
      margin: auto;
      overflow: scroll;

    }
    #productImage{
      <%--background-image: url("${Goods.image}");--%>


      height: 200px;
    }

  </style>

</head>
<body>
<nav>
  <jsp:include page="nav.jsp"/>
</nav>
<header>
<jsp:include page="header.jsp"/>
</header>
<section class="py-5">
  <a href="RegistForm.gd">상품등록</a>
  <div class="container px-4 px-lg-5 mt-5">
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

      <c:forEach var = "Goods" items="${GoodsList}" varStatus="status">
        <div class="col mb-5">
          <div class="card h-100">
            <!-- Product image-->
            <a href="View.gd?id=${Goods.id}">
              <img class="card-img-top" src="images/${Goods.image}" alt="..." id="productImage" />
            </a>
            <!-- Product details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- Product name-->
                <h5 class="fw-bolder">상품명 :${Goods.name}</h5>
                <!-- Product reviews-->

                <!-- Product price-->
                가격 : ${Goods.price}
              </div>
            </div>
            <!-- Product actions-->
            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
              <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="CartAdd.gd?id=${Goods.id}">Add to cart</a></div>
            </div>
          </div>

        </div>
      </c:forEach>
    </div>
  </div>

</section>
<footer>
  <div class="container"><p class="m-0 text-center">Copyright &copy; Project 2021</p class="m-0 text-center"></div>
</footer>

</body>
</html>
