<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <!-- <script src="./js/jquery.js"></script> -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>

    <script>
        function check(){
            if($.trim($("#username").val())==""){
                alert("로그인 아이디를 입력하세요!");
                $("#username").val("").focus();
                return false;
            }
            if($.trim($("#userPass").val())==""){
                alert("비밀번호를 입력하세요!");
                $("#userPass").val("").focus();
                return false;
            }
        }

        /*비번찾기 공지창*/
        function pwd_find(){
            window.open("pwd_find.do","비번찾기","width=450,height=500");
        }
    </script>
</head>
<body>
<div id="login_wrap">
    <h2 class="login_title">로그인</h2>
    <form method="POST" action="/login" onsubmit="return check()">
        <table id="login_t">
            <tr>
                <th>아이디</th>
                <td>
                    <input name="username" id="username" size="20" class="input_box" />
                </td>
            </tr>

            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="password" name="userPass" id="userPass" size="20" class="input_box"/>
                </td>
            </tr>
        </table>
        <div id="login_menu">
            <input type="submit" value="로그인" class="input_button" />
            <input type="reset" value="취소" class="input_button"
                   onclick="$('#id').focus();" />
            <input type="button" value="회원가입" class="input_button"
                   onclick="location.href='/joinForm'" />
            <input type="button" value="비번찾기" class="input_button"
                   onclick="pwd_find()" />
            <a href="/oauth2/authorization/google">구글 로그인</a>
        </div>
    </form>
</div>
</body>
</html>