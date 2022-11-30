<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입폼</title>
    <link rel="stylesheet" type="text/css" href="./css/admin.css"/>
    <link rel="stylesheet" type="text/css" href="./css/member.css"/>
    <!-- <script src="/springmember/js/jquery.js"></script> -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="./js/member.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script>
        //우편번호, 주소 Daum API
        function openDaumPostcode() {
            new daum.Postcode({
                oncomplete: function (data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                    // 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
                    document.getElementById('join_zip1').value = data.zonecode;
                    document.getElementById('join_addr1').value = data.address;
                }
            }).open();
        }
    </script>

</head>
<body>
<div id="join_wrap">
    <h2 class="join_title">회원가입</h2>
    <form name="f" method="post" action="member_join_ok.do"
          onsubmit="return check()" enctype="multipart/form-data">
        <!-- 이진파일을 업로드 할려면 enctype 속성을 지정 -->
        <table id="join_t">
            <tr>
                <th>회원아이디</th>
                <td>
                    <input name="join_id" id="join_id" size="14" class="input_box"/>
                    <input type="button" value="아이디 중복체크" class="input_button"
                           onclick="id_check()"/>
                    <div id="idcheck"></div>
                </td>
            </tr>

            <tr>
                <th>회원비번</th>
                <td>
                    <input type="password" name="join_pwd" id="join_pwd1" size="14"
                           class="input_box"/>
                </td>
            </tr>

            <tr>
                <th>회원비번확인</th>
                <td>
                    <input type="password" name="join_pwd2" id="join_pwd2" size="14"
                           class="input_box"/>
                </td>
            </tr>

            <tr>
                <th>전자우편</th>
                <td>
                    <input name="join_mailid" id="join_mailid" size="10"
                           class="input_box"/>@<input name="join_maildomain"
                                                      id="join_maildomain" size="20" class="input_box" readonly/>
                    <!--readonly는 단지 쓰기,수정이 불가능하고 읽기만 가능하다 //-->
                    <select name="mail_list" onchange="domain_list()">
                        <option value="">=이메일선택=</option>
                        <option value="daum.net">daum.net</option>
                        <option value="nate.com">nate.com</option>
                        <option value="naver.com">naver.com</option>
                        <option value="hotmail.com">hotmail.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="0">직접입력</option>
                    </select>
                </td>
            </tr>

        </table>

        <div id="join_menu">
            <input type="submit" value="회원가입" class="input_button"/>
            <input type="reset" value="가입취소" class="input_button"
                   onclick="$('#join_id').focus();"/>
        </div>
    </form>
</div>
</body>
</html>
