<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .boardtypelist{

        }
        .boardId_ok{
            display: none;
            color: blue;
        }
        .boardId_num{
            display: none;
            color: red;
        }
        .boardId_already{
            display: none;
            color: red;
        }
    </style>
</head>
<body>
    <form>
        boardId : <input type="text" id="boardId" name="boardId">
        <span class="boardId_ok">사용가능한 번호 입니다.</span>
        <span class="boardId_num">boardId는 숫자만 가능합니다.</span>
        <span class="boardId_already">중복된 번호입니다.</span>
        boardName<input type="text" id="boardName" name="boardName">
        <button type="submit">등록</button>
    </form>

</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(document).ready(function(){
        $('#boardId').on('input',function() {
            const boardId = document.getElementById("boardId").value;
            console.log(boardId);

            if ($.isNumeric(boardId)) {
                $.ajax({
                    url: '/boardtype/IdCheck',
                    type: 'get',
                    data: {boardId: boardId},
                    success: function (cnt) {
                        if (cnt) {
                            $('.boardId_num').css("display", "none");
                            $('.boardId_ok').css("display", "none");
                            $('.boardId_already').css("display", "inline-block");
                        } else {
                            $('.boardId_num').css("display", "none");
                            $('.boardId_ok').css("display", "inline-block");
                            $('.boardId_already').css("display", "none");
                        }
                    },
                    error: function () {
                        alert("에러입니다. 관리자에게 문의해주세요.");
                        return false;
                    }
                })
            } else {
                $('.boardId_num').css("display", "inline-block");
                $('.boardId_ok').css("display", "none");
                $('.boardId_already').css("display", "none");
            }
        })
        $("button[name='join']").click(function (){
            if($("#boardId").val()===""){
                alert("boardId를 입력하세요.");
                $("#boardId").focus();
                return false;
            }
            if($("#boardName").val()===""){
                alert("boardName을 입력하세요.");
                $("#boardName").focus();
                return false;
            }
            let regPass = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
            if(!regPass.test($("input[id='userPass']").val())){
                alert("영문, 숫자, 특수문자 조합으로 8-20자리를 입력하십시오.");
                $('#userPass').focus();
                return false;
            }
            if($("input[id='userPass']").val() != $("input[id='pass_check']").val()){
                alert("비밀번호를 다시 확인하세요.")
                $('#userPass').focus();
                return false;
            }
            if($("#userEmail").val()===""){
                alert("이메일을 입력하세요.");
                $("#userEmail").focus();
                return false;
            }
            let regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            if(!regEmail.test($("input[id='userEmail']").val())){
                alert("이메일 형식에 맞게 입력하십시오.");
                $('#userEmail').focus();
                return false;
            }

            let data = {
                userId : $("#userId").val(),
                nickName: $("#nickName").val(),
                userPass : $("#userPass").val(),
                userEmail : $("#userEmail").val()
            }
            console.log(data);

            $.ajax({
                url: './users/save',
                type: "POST",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success:function(User) {
                    alert("회원가입에 성공했습니다.");
                    location.href="/loginForm";
                },
                error:function (){
                    alert("에러입니다. 아이디,비밀번호, 이메일 확인 후 관리자에게 문의해주세요.");
                }
            })
        });
    });
</script>
</html>
