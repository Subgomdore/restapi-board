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
        const typeNo = '${typeNo}';
        console.log(typeNo);
        $.ajax({
            url: '/board/'+typeNo+'/list',
            type: 'POST',
            data_type: "json",
            contentType: 'application/json',
            data:JSON.stringify({
                typeNo:typeNo
            }),
            success: function (data) {
                str = '<TR align="center">';
                $.each(data, function (i) {
                    console.log(i)
                    str += '<TD align="center" id="bno'+i+'"> ' + data[i].typeNo + '</TD>' +
                        '<TD align="center" id="bsubject'+i+'"> <a href="${typeNo}/'+ data[i].boardNo +'">'+data[i].boardSubject+'</a></TD>' +
                        '<TD align="center" id="buserId'+i+'">' + data[i].userId + '</TD>' +
                    '<input type="hidden" id="bno+'+i+'" value="'+ data[i].boardNo +'">';
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
${typeNo}의 게시판 <br>
접속중인아이디: ${sessionid} <br>


<div id="bbslist_wrap">
    <h2 class="bbslist_title">게시글목록</h2>
    <table id="bbslist_t" border="1">
        <tr align="center" valign="middle" bordercolor="#333333">
            <td style="font-family: Tahoma; font-size: 11pt;" width="15%" height="26">
                <div align="center">글번호(페이징값으로 변경예정)</div>
            </td>
            <td style="font-family: Tahoma; font-size: 11pt;" width="25%">
                <div align="center">글제목</div>
            </td>
            <td style="font-family: Tahoma; font-size: 11pt;" width="25%">
                <div align="center">작성자</div>
            </td>
        </tr>
        <%--여기에 AJAX 리턴값을 추가해서 반환한다.--%>
        <tbody class="table_body">

        </tbody>
    </table>

    <div id="bbslist_w">
        <input type="button" value="글쓰기" class="input_button" onclick="location.href=${typeNo} + '/boardwrite'">
    </div>
</div>
</body>
</html>