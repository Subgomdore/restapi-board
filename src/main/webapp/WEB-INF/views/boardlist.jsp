<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>boardlist.jsp</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<script>
    $(document).ready(function() {

            console.log('작동');
            $.ajax({
                url: '/board/list', //Controller에서 요청 받을 주소
                type: 'GET', //POST 방식으로 전달
                success: function (data) {
                    console.log("통신성공");
                    console.log(data);
                    str = '<TR>';
                    $.each(data, function (i) {
                        str += '<TD>' + data[i].boardtype_no + '</TD>' +
                            '<TD>' + data[i].boardtype_name + '</TD>';
                        str += '</TR>';
                    });
                    $('.table_body').append(str);
                },
                error: function () {
                    console.log('에러');
                }
            });
    })
</script>
<body>
<table border="1">
    <thead>
    <tr>
        <th>boardType_no</th>
        <th>boardType_name</th>
    </tr>
    </thead>
    <tbody class="table_body">

    </tbody>
</table>
<div id="result"></div>
</body>
</html>