<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <style>
    .container{

      margin-top: 200px;
      margin-right: 100px;
    }
    legend{
      border-bottom: 0px;
    }
  </style>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="span12">
      <form class="form-horizontal" action='./MemberLoginAction.mm' method="POST">
        <fieldset>
          <div id="legend">
            <legend class="12">Login</legend>
          </div>
          <div class="control-group">
            <!-- Username -->
            <label class="control-label"  for="id">ID</label>
            <div class="controls">
              <input type="text" id="id" name="id" placeholder="" class="input-xlarge">
            </div>
          </div>
          <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="pass">Password</label>
            <div class="controls">
              <input type="password" id="pass" name="pass" placeholder="" class="input-xlarge">
            </div>
          </div>
          <div class="control-group">
            <!-- Button -->
            <div class="controls">
              <button class="btn btn-success">로그인</button>
             <u style="margin-left: 30px; margin-top: 100px"> <small><a href="./MemberJoin.mm">회원가입</a></small></u>

            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>

</body>

</html>