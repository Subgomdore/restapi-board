<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="resources/cssfile.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판 내용보기</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<script>

    $(document).ready(function () {
        console.log('boardcontent function test');
        const typeNo = ${typeNo};
        const boardNo = ${boardNo};
        console.log(boardNo);
        console.log(typeNo+boardNo)
        $.ajax({
            url: '/board/'+typeNo+'/'+boardNo ,
            type: 'POST',
            // data_type: "json",
            // contentType: 'application/json',
            // data:JSON.stringify({
            //     boardNo:boardNo
            // }),
            success: function (data) {
                console.log(data)
                console.log(data.boardSubject)
            },
            error: function (data) {
                console.log(data);
            }
        });
    })

</script>

<body>
<div id="boardcont_wrap">
    <h2 class="boardcont_title">게시물 내용보기</h2>
    <table id="boardcont_t">

        <tr>
            <th>제목</th>
            <td></td>
        </tr>

        <tr>
            <th>글내용</th>
            <td>
                <pre></pre>
            </td>
        </tr>
    </table>

    <div id="boardcont_menu">
        <input type="button" value="수정" class="input_button"
               onclick="location='board_cont.do?board_num=${bcont.board_num}&page=${page}&state=edit'" />
        <input type="button" value="삭제" class="input_button"
               onclick="location='board_cont.do?board_num=${bcont.board_num}&page=${page}&state=del'" />
        <input type="button" value="답변" class="input_button"
               onclick="location='board_cont.do?board_num=${bcont.board_num}&page=${page}&state=reply'" />
        <input type="button" value="목록" class="input_button"
               onclick="location='board_list.do?page=${page}'" />
    </div>
</div>
</body>
</html>