<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="resources/cssfile.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기게시판</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<script>

    function submitWrite() {
        console.log('submitWrite 작동');
        const frmData = $('form').serialize();
        console.log(frmData);


        const userId = '${sessionid}';
        const typeNo = '${typeNo}';
        const ref = 0;
        const reStep =0;
        const reLevel=0;

        const boardSubject = $('#boardSubject').val();
        console.log(boardSubject);
        const boardContent = $('#boardContent').val();
        console.log(boardContent)


        $.ajax({
            url: 'write-add',
            type: 'POST',
            data_type: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({
                userId: userId,
                typeNo: typeNo,
                boardSubject:boardSubject,
                boardContent:boardContent,
                ref:ref,
                reStep:reStep,
                reLevel:reLevel


            }),
            success: function (data) {
                console.log(data);

            },
            error: function (data) {
                console.log(data);
            }


        })
    }


</script>
<body>
${typeNo}의 게시판 <br>
접속중인아이디: ${sessionid} <br>

<div id="bbswrite_wrap">
    <h2 class="bbswrite_title">게시판 입력폼</h2>
    <form id="frm" name="frm">
        <input type="hidden" value="${typeNo}" name="typeNo"/>
        <input type="hidden" value="${sessionid}" name="userId"/>

        <table id="bbswrite_t">
            <tr>
                <th>글제목</th>
                <td>
                    <input name="boardSubject" id="boardSubject" size="40"
                           class="input_box"/>
                </td>
            </tr>

            <tr>
                <th>글내용</th>
                <td>
      <textarea name="boardContent" id="boardContent" rows="8" cols="50" class="input_box"></textarea>
                </td>
            </tr>

        </table>

        <div id="bbswrite_menu">
            <input type="button" value="등록" onclick="submitWrite()" class="input_button"/>
            <input type="reset" value="취소" class="input_button" onclick="$('#board_name').focus();"/>
        </div>
    </form>
</div>


</body>
</html>