<%--
  Created by IntelliJ IDEA.
  User: induck_h
  Date: 2022/12/19
  Time: 9:49 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>관리자 페이지</title>
    <style>
        .admin-header{
            width: 1200px;
            height: 100px;
            border: 1px solid;
            box-sizing: border-box;
        }
        .admin-body{
            display: flex;
        }
        .admin-sidebar{
            border: 1px solid;
            width: 200px;
            min-height: 800px;
            box-sizing: border-box;

        }
        .admin-content{
            border: 1px solid;
            width: 1000px;
            min-height: 800px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<section>
    <div class="admin-header">최고관리자 페이지</div>
    <div class="admin-body">
        <div class="admin-sidebar">
            <ul>
                <li><button id="allUser">전체 가입자</button></li>
                <li><button>매니져 관리</button></li>
            </ul>
        </div>
        <div class="admin-content">
            목록 출력 div
        </div>
    </div>
</section>
</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(document).ready(function() {
        $("button[id=allUser]").click(function () {

            alert("체크");

            $.ajax({
                url: '',
                type: '',
                data: {userId: userId},
                success: function (cnt) {
                    if (cnt) {
                        $('.id_ok').css("display", "none");
                        $('.id_already').css("display", "inline-block");
                    } else {
                        $('.id_ok').css("display", "inline-block");
                        $('.id_already').css("display", "none");
                    }
                },
                error: function () {
                    alert("에러입니다. 관리자에게 문의해주세요.");
                }
            })
        } else {
            $('.id_ok').css("display", "none");
            $('.id_already').css("display", "none");
            $('.id_size').css("display", "inline-block");
        }
    });
</script>
</html>
