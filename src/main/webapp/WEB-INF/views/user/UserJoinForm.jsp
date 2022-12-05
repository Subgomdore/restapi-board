<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Join</title>
    <style>
        .id_ok{
            display: none;
            color: blue;
        }
        .id_already {
            display: none;
            color: red;
        }
        .id_size{
            display: inline-block;
        }
        .pass_size{
            display: inline-block;
            color:red;
        }
        .pass_check{
            display: none;
            color:red;
        }
    </style>
</head>
<body>
<div>
    <label for="userId">ID: </label><input type="text" id="userId" name="userId" >
    <span class="id_size">아이디의 길이은 2~8글자 입니다.</span>
    <span class="id_ok">사용가능한 아이디 입니다.</span>
    <span class="id_already">사용중인 아이디 입니다.</span>
</div>
<div>
    비밀번호 : <input type="password" id="userPass" name="userPass" />
    <span class="pass_size">영문, 숫자, 특수기호 조합으로 8~20글자를 입력하십시오.</span>
    비밀번호 확인 : <input type="password" id="pass_check" name="pass_check" />
    <span class="pass_check">비밀번호가 일치 하지 않습니다.</span>
</div>
<div>
    e-mail: <input type="text" id="userEmail" name="userEmail" />
</div>
<div>
    <button type="button" name="join">가입</button>
</div>
</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(document).ready(function(){
        $('#userId').on('input',function(){

            const userId = document.getElementById("userId").value;
            console.log(userId);

            if(userId.length > 2 && userId.length <=8){
                $('.id_size').css("display","none");
                $.ajax({
                    url: './users/IdCheck',
                    type: 'get',
                    data: {userId : userId},
                    success:function(cnt) {
                        if(cnt){
                            $('.id_ok').css("display","none");
                            $('.id_already').css("display", "inline-block");
                        }else{
                            $('.id_ok').css("display", "inline-block");
                            $('.id_already').css("display","none");
                        }
                    },
                    error:function (){
                        alert("에러입니다. 관리자에게 문의해주세요.");
                    }
                })
            }else{
                $('.id_ok').css("display", "none");
                $('.id_already').css("display", "none");
                $('.id_size').css("display","inline-block");
            }
        });
        $('#userPass').on('input',function(){

            const userPass = document.getElementById("userPass").value;

            if(userPass.length > 8 && userPass.length <=20){
                $('.pass_size').css("display","none");
            }else{
                $('.pass_size').css("display", "inline-block");
            }
        });
        $('#pass_check').on('input',function(){

            const userPass = document.getElementById("userPass").value;
            const pass_check = document.getElementById("pass_check").value;

            if(userPass != pass_check){
                $('.pass_check').css("display","inline-block");
            }else{
                $('.pass_check').css("display", "none");
            }
        });

        $("button[name='join']").click(function (){
            if($("#userId").val()===""){
                alert("ID를 입력하세요.");
                $("#userId").focus();
                return false;
            }
            if($("#userPass").val()===""){
                alert("비밀번호를 입력하세요.");
                $("#userPass").focus();
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
