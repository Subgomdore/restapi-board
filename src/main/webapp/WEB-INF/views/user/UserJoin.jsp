<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가</title>
    <style>
        .id_ok{
            display: none;
        }
        .id_already {
            display: none;
        }
        .id_size{
            display: inline-block;
        }
        .pass_size{
            display: inline-block;
            color:red;
        }
    </style>
</head>
<body>
<div>
    ID: <input type="text" id="member_id" name="member_id" >
    <span class="id_size">아이디의 길이은 2~8글자 입니다.</span>
    <span class="id_ok">사용가능한 아이디 입니다.</span>
    <span class="id_already">사용중인 아이디 입니다.</span>
</div>
<div>
    name: <input type="text" id="member_name" name="member_name" />
</div>
<div>
    password: <input type="text" id="member_pass" name="member_pass" />
    <span class="pass_size">비밀번호의 길이은 2~8글자 입니다.</span>
</div>
<div>
    e-mail: <input type="text" id="member_email" name="member_email" />
</div>
<div>
    <button type="button" name="join">가입</button>
</div>
</body>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function(){
        $('#member_id').on('input',function(){

            const member_id = document.getElementById("member_id").value;

            if(member_id.length > 2 && member_id.length <=8){
                $('.id_size').css("display","none");
                $.ajax({
                    url: './IdCheck',
                    type: 'get',
                    data: {member_id : member_id},
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
        $('#member_pass').on('input',function(){

            const member_id = document.getElementById("member_pass").value;

            if(member_id.length > 2 && member_id.length <=8){
                $('.pass_size').css("display","none");
            }else{
                $('.pass_ok').css("display", "inline-block");
            }
        });

        $("button[name='join']").click(function (){
            if($("#member_id").val()==""){
                alert("ID를 입력하세요.");
                $("#member_id").focus();
                return false;
            }
            if($("#member_name").val()==""){
                alert("이름을 입력하세요.");
                $("#member_name").focus();
                return false;
            }
            if($("#member_pass").val()==""){
                alert("비밀번호를 입력하세요.");
                $("#member_pass").focus();
                return false;
            }
            if($("#member_email").val()==""){
                alert("이메일을 입력하세요.");
                $("#member_email").focus();
                return false;
            }
        });
    });

</script>
</html>
