<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="resources/cssfile.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기게시판</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<script>

    function submitWrite(){
        console.log('submitWrite 작동');
        const frmData = $('form').serialize();
        console.log(frmData);
        const user_id = $('#user_id').val();
        console.log(user_id);

        const boardtype_no = $('#boardtype_no').val();
        console.log(boardtype_no);

        const board_subject = $('#board_subject').val();
        console.log(board_subject);

        $.ajax({
            url: 'insert',
            type: 'POST',
            data_type: 'json ',
            contentType: 'application/json; charset=utf-8',
            data:JSON.stringify({
                board_subject: board_subject,
                user_id:user_id,
                boardtype_no:boardtype_no
            }),
            success: function (){
                alert('글쓰기 성공');

            },
            error: function (){
                console.log('error');
            }


        })
    }


</script>
<body>
${boardtype_no}의 게시판 <br>
접속중인아이디: ${sessionid} <br>

<div id="bbswrite_wrap">
    <h2 class="bbswrite_title">게시판 입력폼</h2>
    <form id="frm" name="frm">
        <table id="bbswrite_t">
            <input type="hidden" id="user_id" value="${sessionid}"/>
            <input type="hidden" id="boardtype_no" value="${boardtype_no}" />
            <tr>
                <th>글제목</th>
                <td>
                    <input name="board_subject" id="board_subject" size="40"
                           class="input_box" />
                </td>
            </tr>

            <tr>
                <th>글내용</th>
                <td>
      <textarea name="board_content"  id="board_content" rows="8" cols="50"
                class="input_box"></textarea>
                </td>
            </tr>

        </table>

        <div id="bbswrite_menu">
            <input type="button" value="등록" onclick="submitWrite()" class="input_button" />
            <input type="reset" value="취소" class="input_button" onclick="$('#board_name').focus();" />
        </div>
    </form>
</div>


</body>
</html>