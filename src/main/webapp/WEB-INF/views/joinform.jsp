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
            const user_id = $('#user_id').val(); //id값이 "id"인 입력란의 값을 저장
            $.ajax({
                url: 'user/idCheck', //Controller에서 요청 받을 주소
                type: 'post', //POST 방식으로 전달
                data_type: "json",
                contentType: 'application/json',
                data: JSON.stringify({
                    user_id:user_id
                }),
                success: function (cnt) { //컨트롤러에서 넘어온 cnt값을 받는다
                    console.log(cnt)
                    console.log(user_id.length)
                    if (cnt == 0 && user_id.length > 0) { //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
                        $('.id_ok').css("display", "inline-block");
                        $('.id_already').css("display", "none");
                    } else if (cnt == 1 && user_id.length > 0){ // cnt가 1일 경우 -> 이미 존재하는 아이디
                        $('.id_already').css("display", "inline-block");
                        $('.id_ok').css("display", "none");
                        console.log('중복된아이디')
                    } else {
                        $('.id_ok').css("display", "none");
                        $('.id_already').css("display","none");
                    }
                },
                error: function () {
                    console.log("err");
                }
            });
        };
    </script>
    <style>
        .id_ok{
            color:#6A82FB;
            display: none;
        }

        .id_already{
            color:#FF0000;
            display: none;
        }
    </style>
</head>
<body>
<div id="join_wrap">
    <h2 class="join_title">회원가입</h2>
    <form name="f" method="post" onsubmit="return check()" enctype="multipart/form-data">
        <table id="join_t">
            <tr>
                <th>회원아이디</th>
                <td>
                    <input name="user_id" id="user_id" placeholder="ID"
                           required oninput="id_check()" size="14" class="input_box"/>
                    <span class="id_already"> already </span>
                    <span class="id_ok"> ok </span>
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
                    <input name="user_mail" id="user_mail" size="10"
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
