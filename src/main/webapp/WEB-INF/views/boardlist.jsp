<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="resources/cssfile.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>컨텐츠 리스트(특정게시판의 글리스트)</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<script>
    $(document).ready(function () {
        console.log('boardlist/{boardtypeNo}의 function 실행완료');
        const boardtypeNo = '${boardtypeNo}';
        console.log(boardtypeNo);
        $.ajax({
            url: '/board/1002/list',
            type: 'POST',
            data_type: "json",
            contentType: 'application/json',
            data:JSON.stringify({
                boardtypeNo:boardtypeNo
            }),
            success: function (data) {
                str = '<TR>';
                $.each(data, function (i) {
                    console.log(i)
                    str += '<TD id="bno'+i+'"> ' + data[i].boardNo + '</TD>' +
                        '<TD id="bname'+i+'"> <a href="board/'+ data[i].boardNo +'">'+data[i].boardSubject+'</a></TD>';
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
${boardtypeNo}의 게시판 <br>
접속중인아이디: ${sessionid} <br>


<div id="bbslist_wrap">
    <h2 class="bbslist_title">게시글목록</h2>
    <table id="bbslist_t">
        <tr align="center" valign="middle" bordercolor="#333333">
            <td style="font-family: Tahoma; font-size: 11pt;" width="8%" height="26">
                <div align="center">boardNo</div>
            </td>
            <td style="font-family: Tahoma; font-size: 11pt;" width="47%">
                <div align="center">boardSubject</div>
            </td>
        </tr>
        <%--여기에 AJAX 리턴값을 추가해서 반환한다.--%>
        <tbody class="table_body">

        </tbody>
    </table>

    <div id="bbslist_w">
        <input type="button" value="글쓰기" class="input_button" onclick="location.href=${boardtypeNo} + '/boardwrite'">
    </div>
</div>
</body>
</html>