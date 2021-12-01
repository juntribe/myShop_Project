<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page import="com.Project.board.vo.BoardBean" %>
<%@ page import="com.Project.board.vo.PageInfo" %>

<%
	ArrayList<BoardBean> articleList=(ArrayList<BoardBean>)request.getAttribute("articleList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();

	System.out.println("스타트 페이지"+startPage);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Shop Homepage</title>
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="<c:url value="/common/bootstrap/assets/favicon.ico"/>" />
	<!-- Bootstrap icons-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="<c:url value="/common/bootstrap/css/styles.css"/>" rel="stylesheet" />
<meta charset="UTF-8" />

<style type="text/css">
#registForm {
	width: 500px;
	height: 600px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	margin-top: 50px;
	text-align: center;
}


table {
	text-align: center;
	margin-top: 30px;
	margin-left: 100px;
	table-layout: fixed;

	width: 90%;
	height: 400px;


}
#bt{
	margin-left: 100px;
}

#tr_top {
	background: aliceblue;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 450px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>

<body>
<jsp:include page="/common/nav.jsp"/>
	<!-- 게시판 리스트 -->

	<section id="listForm">

		<h2>
			글 목록
		</h2>
		<button id="bt" type="button" class="btn btn-primary" onclick="location.href='boardWriteForm.bo';">글쓰기</button>
		<table>



			<%
if(articleList != null && listCount > 0){
%>

			<tr id="tr_top">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>

			<%
		for(int i=0;i<articleList.size();i++){
			
	%>
			<tr>
				<td><%=articleList.get(i).getBOARD_NUM()%></td>

				<td>
					<%
						if(articleList.get(i).getBOARD_RE_LEV()!=0){ %>
					<%for(int a=0;a<=articleList.get(i).getBOARD_RE_LEV()*2;a++){
						%>
					&nbsp; <%} %> ▶ <%}else{ %> ▶ <%} %>
					<a href="boardDetail.bo?board_num=<%=articleList.get(i).getBOARD_NUM()%>&page=<%=nowPage%>">
						<%=articleList.get(i).getBOARD_SUBJECT()%>
				</a>
				</td>

				<td><%=articleList.get(i).getBOARD_NAME() %></td>
				<td><%=articleList.get(i).getBOARD_DATE() %></td>
				<td><%=articleList.get(i).getBOARD_READCOUNT() %></td>
			</tr>
			<%} %>
			<th>

	</section>

	<section id="pageList">
		<%if(nowPage<=1){ %>
		[이전]&nbsp;
		<%}else{ %>
		<a href="boardList.bo?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="boardList.bo?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		[다음]
		<%}else{ %>
		<a href="boardList.bo?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
	</section>
	<%
    }
	else
	{
	%>
	<section id="emptyArea">등록된 글이 없습니다.</section>
	<%
	}
%>

</body>
</html>