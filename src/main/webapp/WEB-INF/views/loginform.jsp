<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="resources/cssfile.jsp" %>
<%--<%@include file="resources/loginformScript.jsp" %>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(function () {
            $('#loginBtn').click(function () {
                if ($.trim($("#user_id").val()) == "") {
                    alert("로그인 아이디를 입력하세요!");
                    $("#id").val("").focus();
                    return false;
                }
                if ($.trim($("#user_pass").val()) == "") {
                    alert("비밀번호를 입력하세요!");
                    $("#pwd").val("").focus();
                    return false;
                }

                const user_id = $('#user_id').val();
                const user_pass = $('#user_pass').val();
                const data = JSON.stringify({
                    user_id: user_id,
                    user_pass: user_pass
                })

                $.ajax({
                    url: "/user/signin",
                    type: 'post',
                    data_type: "json",
                    contentType: 'application/json',
                    data: data,
                    success: function (response) {
                        if (response == 1) {
                            location.href = 'board'/* PageController - board 요청*/
                        } else {
                            alert('비번틀림');
                        }
                    },
                    error: function (e) {
                        alert("오류");
                    }
                })
            })
        })
    </script>

</head>
<body>
<div id="login_wrap">
    <h2 class="login_title">로그인</h2>
    <form method="post" onsubmit="return check()">
        <table id="login_t">
            <tr>
                <th>아이디</th>
                <td>
                    <input id="user_id" name="user_id" size="20" class="input_box"/>
                </td>
            </tr>

            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="password" id="user_pass" name="user_pass" size="20" class="input_box"/>
                </td>
            </tr>
        </table>
        <div id="login_menu">
            <input type="button" id="loginBtn" value="로그인" class="input_button"/>
            <input type="reset" value="취소" class="input_button" onclick="$('#user_id').focus();"/>
            <input type="button" value="회원가입" class="input_button" onclick="location.href='join'"/>
            <input type="button" value="비번찾기" class="input_button" onclick="pwd_find()"/>
        </div>
    </form>
</div>
</body>
</html>