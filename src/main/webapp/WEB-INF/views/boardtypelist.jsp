<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="resources/cssfile.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<%--PageController로 jsp에 온다음. list를 불러오는 비동기요청을 다시함--%>
<script>
    $(document).ready(function () {

        console.log('load완료');
        $.ajax({
            url: '/board/list',
            type: 'GET',
            success: function (data) {
                str = '<TR>';
                $.each(data, function (i) {
                    console.log(i)
                    str += '<TD id="bno'+i+'"> ' + data[i].boardtypeNo + '</TD>' +
                        '<TD id="bname'+i+'"> <a href="board/'+ data[i].boardtypeNo +'">'+data[i].boardtypeName+'</a></TD>';
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

<%--BoardType을 추가하는 요청--%>
<script>

    function Type_insert(){
        const typeName = $('#typeName').val();
        console.log(typeName);

        $.ajax({
            url: 'board/boardtype-add', /*BoardType Controller 요청*/
            type: 'POST',
            data_type: "json",
            contentType: 'application/json',
            data:JSON.stringify({
                typeName:typeName
            }),
            success: function (data) {
                location.href='board'
            },
            error: function () {
                console.log('에러');
            }
        });

    }

</script>
<body>
접속중인아이디: ${sessionid} <br>
게시판종류 추가하기: <input id="typeName" type="text"/> <input type="button" onclick="Type_insert()" value="추가"/>

<div id="bbslist_wrap">
    <h2 class="bbslist_title">게시판 목록</h2>
    <table id="bbslist_t">
        <tr align="center" valign="middle" bordercolor="#333333">
            <td style="font-family: Tahoma; font-size: 11pt;" width="8%" height="26">
                <div align="center">boardTypeNo</div>
            </td>
            <td style="font-family: Tahoma; font-size: 11pt;" width="47%">
                <div align="center">boardTypeName</div>
            </td>
        </tr>
        <tbody class="table_body">

        </tbody>
    </table>
    <div id="result"></div>
</div>
</body>
</html>