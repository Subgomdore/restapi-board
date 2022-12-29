<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cssfile.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입폼</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>

    <!-- 아이디 중복검사 Ajax -->
    <script>
        function id_check() {
            const userId = $('#userId').val(); //id값이 "id"인 입력란의 값을 저장
            $.ajax({
                url: 'user/idCheck', //Controller에서 요청 받을 주소
                type: 'post', //POST 방식으로 전달
                data_type: "json",
                contentType: 'application/json',
                data: JSON.stringify({
                    userId: userId
                }),
                success: function (cnt) { //컨트롤러에서 넘어온 cnt값을 받는다
                    if (cnt == 0 && userId.length > 0) { //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
                        $('.id_ok').css("display", "inline-block");
                        $('.id_already').css("display", "none");
                    } else if (cnt == 1 && userId.length > 0) { // cnt가 1일 경우 -> 이미 존재하는 아이디
                        $('.id_already').css("display", "inline-block");
                        $('.id_ok').css("display", "none");
                    } else {
                        $('.id_ok').css("display", "none");
                        $('.id_already').css("display", "none");
                    }
                },
                error: function () {
                    console.log("err");
                }
            });
        };
    </script>

    <script>
        function domain_list() {
            const num = f.mail_list.selectedIndex;
            /*selected Index속성은 select객체하위의 속성으로서 해당리스트 목록번호를 반환 */
            if (num == -1) {
                //num==-1은 해당 리스트목록이 없다
                return true;
            }
            if (f.mail_list.value == "0") // 직접입력
            {
                f.userEmail2.value = "";
                f.userEmail2.readOnly = false;
                f.userEmail2.focus();
            } else {
                f.userEmail2.value = f.mail_list.options[num].value;
                f.userEmail2.readOnly = true;
            }
        }

    </script>
    <script>
        function userJoin() {
            const userId = $('#userId').val();
            const userPass = $('#userPass').val();
            const userEmail = $('#userEmail').val() + '@' + $('#userEmail2').val();

            if (document.getElementById('already').innerText == '사용중') {
                alert("사용중인 아이디 입니다");
                $("#userId").val("").focus();
                return false;
            }
            if ($.trim($("#userPass").val()) == "") {
                alert("비밀번호를 입력하세요!");
                $("#userPass").val("").focus();
                return false;
            }
            if ($.trim($("#userPass2").val()) == "") {
                alert("확인 비밀번호를 입력하세요!");
                $("#userPass2").val("").focus();
                return false;
            }
            if ($.trim($("#userPass").val()) != $.trim($("#userPass2").val())) {
                alert("입력한 비밀번호가 일치하지 않습니다.");
                $("#userPass2").val("").focus();
                return false;
            }


            $.ajax({
                url: 'user/save', /* UserController */
                type: 'post',
                data_type: "json",
                contentType: 'application/json',
                data: JSON.stringify({
                    userId: userId,
                    userPass: userPass,
                    userEmail: userEmail
                }),
                success: function (data) {
                    alert('회원가입 성공');
                    location.href = 'board'/* PageController - board 요청*/
                },
                error: function () {
                    console.log("err");
                }
            });
        }


    </script>
    <style>
        .id_ok {
            color: #6A82FB;
            display: none;
        }

        .id_already {
            color: #FF0000;
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
                    <input name="userId" id="userId" placeholder="ID"
                           required oninput="id_check()" size="14" class="input_box"/>
                    <span id="already" class="id_already"> 사용중 </span>
                    <span id="ok" class="id_ok"> 사용가능 </span>
                </td>
            </tr>
            <tr>
                <th>회원비번</th>
                <td>
                    <input type="password" name="userPass" id="userPass" size="14"
                           class="input_box"/>
                </td>
            </tr>

            <tr>
                <th>회원비번확인</th>
                <td>
                    <input type="password" name="userPass2" id="userPass2" size="14"
                           class="input_box"/>
                </td>
            </tr>

            <tr>
                <th>전자우편</th>
                <td>
                    <input name="userEmail" id="userEmail" size="10" class="input_box"/>@
                    <input name="userEmail2" id="userEmail2" size="20" class="input_box" readonly/>
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
            <input type="button" value="회원가입" onclick="userJoin()" class="input_button"/>
            <input type="reset" value="가입취소" class="input_button"
                   onclick="$('#join_id').focus();"/>
        </div>
    </form>
</div>
</body>
</html>
