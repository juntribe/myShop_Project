<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>회원가입</title>
  <style>
    div{
      margin-right: 500px;
    }
    *{
      margin: 1px;
      padding: 0;
    }
    div{
      list-style-type: none;
    }
    h3{
      margin: 150px 0 0 50px;
    }
    #detail_table{
      width: 500px;
      margin: 10px 0 0 50px;
      font-family: "돋움";
      font-size: 10px;
      color: #444444;
      padding-top: 5px;
      padding-bottom: 10px;
      border-top:solid 1px #cccccc;
      border-bottom: solid 1px #cccccc ;
    }
    .sub {
      margin-left: 120px;
    }

  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  <script type="text/javascript">
    function execDaumPostcode() {
      new daum.Postcode({
        oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 각 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var addr = ''; // 주소 변수
          var extraAddr = ''; // 참고항목 변수

          //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            addr = data.roadAddress;
          } else { // 사용자가 지번 주소를 선택했을 경우(J)
            addr = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if(data.userSelectedType === 'R'){
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
              extraAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
              extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraAddr !== ''){
              extraAddr = ' (' + extraAddr + ')';
            }
            // 조합된 참고항목을 해당 필드에 넣는다.
            document.getElementById("jibunAddress").value = extraAddr;

          } else {
            document.getElementById("jibunAddress").value = '';
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('zipcode').value = data.zonecode;
          document.getElementById("roadAddress").value = addr;
          // 커서를 상세주소 필드로 이동한다.
          document.getElementById("namujiAddress").focus();
        }
      }).open();
    }
    function fn_overlapped(){
      var id =$("#id").val();
      if (id ==''){
        alert("ID를 입력하세요");
        return;
      }
      $.ajax({
        type:"post",
        async:false,
        url:"/LoginCheck.mm",
        dataType:"text",
        data:{id:id},
        success:function (data,textStatus){
          if (data =='false'){
            alert(data);
            $('#btnOverlapped').prop("disabled",true);
            $('#id').prop("disabled",true);
            $('#id').val(id);
          }
          else {
            alert(data);
          }
        },
        error:function (data,textStatus){
          alert("에러가 발생했습니다.");
        },
        complete:function (data,textStatus){
        }
      });
    }
  </script>
</head>
<body>
<div>

<h3>회원 가입</h3>
<form action="./MemberJoinAction.mm" method="post">
  <div id="detail_table">
    <table>
      <tbody>
      <tr class="dot_line">
        <td class="fixed_join">아이디</td>
        <td>
          <input type="text" name="id" id="id"  size="20" check_result="fail" required="required"/>
          <input type="hidden" name="id"/>
          <input type="button" id="btnOverlapped" value="중복체크" onclick="fn_overlapped()" required="required"/>
        </td>
      </tr>
      <tr class="dot_line">
        <td class="fixed_join">비밀번호</td>
        <td><input type="password" name="pass" size="20" required="required"></td>
      </tr>
      <tr class="dot_line">
        <td class="fixed_join">이름</td>
        <td><input type="text" name="name" required="required"></td>
      </tr>
      <tr class="dot_line">
        <td class="fixed_join">나이</td>
        <td><input type="number" name="age" required="required"></td>
      </tr>
      <tr class="dot_line">
        <td class="fixed_join">성별</td>
        <td><input type="radio" name="gender" value="남" checked>남
          <input type="radio" name="gender" value="여">여
        </td>
      </tr>
      <tr class="dot_line">
        <td class="fixed_join">이메일</td>
        <td><input type="email" name="email" required="required"></td>
      </tr>
      <tr class="dot_line">
        <td class="fixed_join">주소</td>
        <td>
          <input type="text" id="zipcode" name="zipcode" size="10" >
          <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
          <p>
            <input type="text" id="roadAddress" name="roadAddress" placeholder="주소" required="required"><br>
            <input type="text" id="jibunAddress" name="jibunAddress" placeholder="상세주소" required="required">
            <input type="text" id="namujiAddress" name="namujiAddress" placeholder="나머지 주소" required="required"><br>
          </p>
        </td>
      </tr>
      </tbody>
    </table>
  </div>

  <div class="clear">
    <br><br>
    <table class="sub">
      <tr>
        <td>
          <input type="submit" value="회원가입">
          <input type="reset" value="다시입력">
        </td>
      </tr>
    </table>
  </div>

</form>
</div>
</body>
</html>
