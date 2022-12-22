<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<script>
    function submitWrite() {

        const userId = '${sessionid}';
        const typeNo = ${typeNo};
        const ref = 0;
        const reStep = 0;
        const reLevel= 0;

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
                console.log("글쓰기성공")
                // alert("성공");
                // location.href='/board/'+typeNo;
            },
            error: function (data) {
                alert("실패");
            }
        })
    }
</script>

<body>
접속중인아이디: ${sessionid} <br>
<div class="container" align="center">
    <h2 class="text-primary">게시판 글쓰기</h2>

    <input type="hidden" value="${typeNo}" name="typeNo"/>

        <table class="table table-striped">
            <tr>
                <td>제목</td>
                <td><input type="text" id="boardSubject" name="boardSubject" required="required"></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" name="userId" required="required" readonly value="${sessionid}" style="border:0 solid black; outline: none" ></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea rows="5" id="boardContent" cols="30" name="boardContent" required="required"></textarea></td>
            </tr>
        </table>

    <div id="bbswrite_menu">
        <input type="button" value="등록" onclick="submitWrite()" class="input_button"/>
        <input type="reset" value="취소" class="input_button" onclick="$('#boardSubject').focus();"/>
    </div>

    </form>

</div>
</body>
</html>