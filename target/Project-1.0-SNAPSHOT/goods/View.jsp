<%@page import="com.Project.goods.vo.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#listForm{
		width:640px;
		border:1px solid white;
		margin:auto;
	}
	h2{
		text-align:center;
	}
	img{
		width: 280px;
		height: 280px;
		border: none;
	}
	#content_main{
		height:300px;
	}
	#content_left{
		width: 300px;
		float:left;
	}
	#content_right{
		width: 340px;
		float:left;
	}
	#commandList{
		text-align: center;
	}
	#desc{
		height:170px;

	}
</style>
</head>
<body>



<section id = "listForm">
<h2>${goods.name}의 상세정보</h2>

	<section id="content_main">
		<section id = "content_left">
			<img src="/image/${goods.image}"/>
		</section>
		<section id = "content_right">
			<b>상품명 : </b> ${goods.name}<br>
			<b>가격 : </b> ${goods.price}<br>
			<b>사이즈 : </b> ${goods.size}<br>
			<b>색상 : </b> ${goods.color}<br>
			<p id="desc">
			<b>내용 : </b> ${goods.content}<br>
			</p>
		</section>
		<div style="clear:both"></div>
		<nav id = "commandList">
			<a href="List.gd">쇼핑계속하기</a>
			<a href="CartAdd.gd?id=${goods.id}">장바구니에담기</a>
		</nav>
	</section>
</section>
</body>
</html>