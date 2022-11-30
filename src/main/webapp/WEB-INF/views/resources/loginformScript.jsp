<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    function check() {
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
    }

    $(function () {
        $('#loginBtn').click(function () {
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
                        alert(response);
                    } else {
                        alert('?');
                    }
                },
                error: function (e) {
                    alert("오류");
                }
            })
        })
    })
</script>