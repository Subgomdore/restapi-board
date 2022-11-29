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
    <label for="user_id">ID: </label><input type="text" id="user_id" name="user_id" >
    <span class="id_size">아이디의 길이은 2~8글자 입니다.</span>
    <span class="id_ok">사용가능한 아이디 입니다.</span>
    <span class="id_already">사용중인 아이디 입니다.</span>
</div>
<div>
    비밀번호 : <input type="password" id="user_pass" name="user_pass" />
    <span class="pass_size">영문, 숫자, 특수기호 조합으로 8~20글자를 입력하십시오.</span>
    비밀번호 확인 : <input type="password" id="pass_check" name="pass_check" />
    <span class="pass_check">비밀번호가 일치 하지 않습니다.</span>
</div>
<div>
    e-mail: <input type="text" id="user_email" name="user_email" />
</div>
<div>
    <button type="button" name="join">가입</button>
</div>
</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(document).ready(function(){
        $('#user_id').on('input',function(){

            const user_id = document.getElementById("user_id").value;
            console.log(user_id);

            if(user_id.length > 2 && user_id.length <=8){
                $('.id_size').css("display","none");
                $.ajax({
                    url: './user/IdCheck',
                    type: 'get',
                    data: {user_id : user_id},
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
        $('#user_pass').on('input',function(){

            const user_pass = document.getElementById("user_pass").value;

            if(user_pass.length > 8 && user_pass.length <=20){
                $('.pass_size').css("display","none");
            }else{
                $('.pass_size').css("display", "inline-block");
            }
        });
        $('#pass_check').on('input',function(){

            const user_pass = document.getElementById("user_pass").value;
            const pass_check = document.getElementById("pass_check").value;

            if(user_pass != pass_check){
                $('.pass_check').css("display","inline-block");
            }else{
                $('.pass_check').css("display", "none");
            }
        });

        $("button[name='join']").click(function (){
            if($("#user_id").val()===""){
                alert("ID를 입력하세요.");
                $("#user_id").focus();
                return false;
            }
            if($("#user_pass").val()===""){
                alert("비밀번호를 입력하세요.");
                $("#user_pass").focus();
                return false;
            }
            let regPass = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
            if(!regPass.test($("input[id='user_pass']").val())){
                alert("영문, 숫자, 특수문자 조합으로 8-20자리를 입력하십시오.");
                $('#user_pass').focus();
                return false;
            }
            if($("input[id='user_pass']").val() != $("input[id='pass_check']").val()){
                alert("비밀번호를 다시 확인하세요.")
                $('#user_pass').focus();
                return false;
            }
            if($("#user_email").val()===""){
                alert("이메일을 입력하세요.");
                $("#user_email").focus();
                return false;
            }
            let regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            if(!regEmail.test($("input[id='user_email']").val())){
                alert("이메일 형식에 맞게 입력하십시오.");
                $('#user_email').focus();
                return false;
            }

            let data = {
                user_id : $("#user_id").val(),
                user_pass : $("#user_pass").val(),
                user_email : $("#user_email").val()
            }
            console.log(data);

            $.ajax({
                url: './user/save',
                type: "POST",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success:function(User) {
                    alert("회원가입에 성공했습니다.");
                    location.href="/";
                },
                error:function (){
                    alert("에러입니다. 아이디,비밀번호, 이메일 확인 후 관리자에게 문의해주세요.");
                }
            })
        });
    });
</script>
</html>
