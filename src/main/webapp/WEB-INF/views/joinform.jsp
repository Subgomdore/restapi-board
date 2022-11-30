<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="resources/cssfile.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입폼</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        function id_check() {
            var id = $('#user_id').val(); //id값이 "id"인 입력란의 값을 저장
            $.ajax({
                url: './idCheck', //Controller에서 요청 받을 주소
                type: 'post', //POST 방식으로 전달
                data: {id: id},
                success: function (cnt) { //컨트롤러에서 넘어온 cnt값을 받는다
                    if (cnt == 0) { //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
                        $('.id_ok').css("display", "inline-block");
                        $('.id_already').css("display", "none");
                    } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                        $('.id_already').css("display", "inline-block");
                        $('.id_ok').css("display", "none");
                        alert("아이디를 다시 입력해주세요");
                        $('#id').val('');
                    }
                },
                error: function () {
                    alert("에러입니다");
                }
            });
        };
    </script>
    <style>
        .id_ok{
            color:#008000;
            display: none;
        }

        .id_already{
            color:#6A82FB;
            display: none;
        }
    </style>
</head>
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
                    <input name="user_id" id="user_id" size="14" class="input_box"/>
                    <input type="button" value="아이디 중복체크" class="input_button" oninput="id_check()"/>
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
