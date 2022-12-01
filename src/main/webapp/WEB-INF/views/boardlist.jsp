<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@include file="resources/cssfile.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<script>
    $(document).ready(function () {

        console.log('작동');
        $.ajax({
            url: '/board/list', //Controller에서 요청 받을 주소
            type: 'GET', //POST 방식으로 전달
            success: function (data) {
                console.log("통신성공");
                console.log(data);
                str = '<TR>';
                $.each(data, function (i) {
                    console.log(i)
                    str += '<TD id="bno'+i+'">' + data[i].boardtype_no + '</TD>' +
                        '<TD id="bname'+i+'">' + data[i].boardtype_name + '</TD>';
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
<div id="bbslist_wrap">
    <h2 class="bbslist_title">게시판 목록</h2>
    <table id="bbslist_t">
        <tr align="center" valign="middle" bordercolor="#333333">
            <td style="font-family: Tahoma; font-size: 11pt;" width="8%" height="26">
                <div align="center">boardType_no</div>
            </td>
            <td style="font-family: Tahoma; font-size: 11pt;" width="47%">
                <div align="center">boardType_name</div>
            </td>
        </tr>
        <tbody class="table_body">

        </tbody>
    </table>
    <div id="result"></div>
</div>
</body>
</html>