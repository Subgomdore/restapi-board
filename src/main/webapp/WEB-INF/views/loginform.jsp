<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
<%--    <link rel="stylesheet" type="text/css" href="./css/admin.css" />--%>
<%--    <link rel="stylesheet" type="text/css" href="./css/member.css" />--%>
<%--    <link rel="stylesheet" th:href="@{/css/style.css}"/>--%>
    <!-- <script src="./js/jquery.js"></script> -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>

    <script>
        function login() {
            if ($.trim($("#userId").val()) == "") {
                alert("로그인 아이디를 입력하세요!");
                $("#userId").val("").focus();
                return false;
            }
            if ($.trim($("#userPw").val()) == "") {
                alert("비밀번호를 입력하세요!");
                $("#userPw").val("").focus();
                return false;
            }
            const userId = $('#userId').val();
            const userPw = $('#userPw').val();
            const data = JSON.stringify({
                userId: userId,
                userPw: userPw
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
                        alert('비번오류');
                    }
                },
                error: function (e) {
                    alert("오류");
                }
            })
        }

    </script>
</head>
<body>
<div id="login_wrap">
    <h2 class="login_title">로그인</h2>
        <table id="login_t">
            <tr>
                <th>아이디</th>
                <td>
                    <input name="userId" id="userId" size="20" class="input_box" />
                </td>
            </tr>

            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="userPw" name="userPw" id="userPw" size="20" class="input_box"/>
                </td>
            </tr>
        </table>
        <div id="login_menu">
            <input type="button" value="로그인" class="input_button" onclick="login()" />
            <input type="button" value="취소" class="input_button"
                   onclick="$('#id').focus();" />
            <input type="button" value="회원가입" class="input_button"
                   onclick="location=''" />
            <input type="button" value="비번찾기" class="input_button" />
        </div>
    </form>
</div>
</body>
</html>