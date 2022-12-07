<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    메인페이지 입니다.
    <button name="updateform">회원정보 수정</button>
</body>
</html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(document).ready(function(){
        $("button[name='updateform']").click(function (){
            let sid = '<%=(String)session.getAttribute("userId")%>';

            console.log(sid)

            let data = {
                userId : sid
            }
            console.log(data);

            $.ajax({
                url: './user/updateRead',
                type: "POST",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success:function(User) {
                    location.href="/user/updateForm";
                },
                error:function (){
                    alert("에러입니다. 아이디,비밀번호, 이메일 확인 후 관리자에게 문의해주세요.");
                }
            })
        });
    });
</script>