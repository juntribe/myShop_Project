
<%@ page import="com.Project.member.db.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script>
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
        function fn_overlapped() {
            var id = $("#id").val();
            if (id == '') {
                alert("ID를 입력하세요");
                return;
            }
        }
    </script>
<title>Insert title here</title>
</head>
<body>


  
  <%
    // request.setAttribute("mdto", mdto);
    MemberDTO mdto = (MemberDTO) request.getAttribute("mdto");
  %>

  <!-- 아이디,비밀번호, 이름,나이, 성별(라디오버튼),이메일 -->
  
  
  <fieldset>
    <legend>  회원 수정 페이지 </legend>
    <form action="./MemberUpdateProAction.mm" method="post">
      아이디 : <input type="text" name="id" value="<%=mdto.getId()%>" readonly><br>
      비밀번호 : <input type="password" name="pass" placeholder="비밀번호 입력하시오."><br>
      이름 : <input type="text" name="name" value="${mdto.name }"><br>
      나이 : <input type="number" name="age" value="${mdto.age }"><br>
      성별 : <input type="radio" name="gender" value="남" 
         <% 
           if(mdto.getGender().equals("남")) {
       	 %> 
        	 checked="checked" 
       	 <% 
       	   } 
       	 %>
         > 남
      <input type="radio" name="gender" value="여" 
        <% 
           if(mdto.getGender().equals("여")) {
       	 %> 
        	 checked="checked" 
       	 <% 
       	   } 
       	 %>
      > 여  <br>
      이메일 : <input type="email" name="email" value="<%=mdto.getEmail()%>"><br>
        <table>
            <tr>
                <td>
                    우편번호 : <input type="text" id="zipcode" name="zipcode" value="<%=mdto.getZipcode()%>" size="5">
                    <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
                    <p>
                        주소 : <input type="text" id="roadAddress" name="roadAddress" value="<%=mdto.getRoadAddress()%>" size="10">
                        <input type="text" id="jibunAddress" name="jibunAddress" value="<%=mdto.getJibunAddress()%>" size="10">
                        <input type="text" id="namujiAddress" name="namujiAddress" value="<%=mdto.getNamujiAddress()%>" size="10">
                    </p>
                </td>
            </tr>


                <br>






        </table>

      <hr>
     <input type="submit" value="회원수정">           
    
    </form>  
  </fieldset>
  
  
  
  
  
  
  
  
  

</body>
</html>