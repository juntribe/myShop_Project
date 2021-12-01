<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.Project.goods.vo.Goods" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap"%>

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

			text-align: center;

		}

		#productImage{
			height: 200px;
		}
		section{
			margin-top: 0px;
		}

		aside{
			margin: 100px 0px 0px 40px;
		}
		#todayImage{
			padding: 0px;
			margin-top: 5px;
			display: flex;
			flex-direction: column;
			justify-content: center;
			height: 40px;

		}

	</style>

</head>
<body>
<nav>
	<jsp:include page="/common/nav.jsp"/>
</nav>
<jsp:include page="/common/header.jsp"/>
<aside>
	<c:if test="${todayImageList !=null }">
		<div id ="todayImageList">
			오늘 본  상품 목록
			<div style="height: 100px; width: 100px">
				<table>
				<c:forEach var="todayImage" items="${todayImageList}" varStatus="status">
					<tr>
						<td>
							<img src="image/${todayImage}" id="todayImage"/>
						</td>
					</tr>

					<c:if test="${((status.index+1) mod 4)==0 }">
					</c:if>
				</c:forEach>
				</table>
			</div>
		</div>
	</c:if>
</aside>
<article>
<section class="py-5">


	<div class="container px-4 px-lg-5 mt-5">
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

<c:forEach var = "Goods" items="${GoodsList}" varStatus="status">
			<div class="col mb-5" style="width: 250px">
				<div class="card h-100">
					<!-- Product image-->
					<a href="View.gd?id=${Goods.id}">
					<img class="card-img-top" src="image/${Goods.image}" alt="이미지" id="productImage" />
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

</article>


<footer>
	<div class="container"><p class="m-0 text-center">Copyright &copy; Project 2021</p></div>
</footer>

</body>
</html>
