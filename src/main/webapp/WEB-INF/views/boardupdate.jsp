<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%-- 게시판 내용 불러오기--%>
    <script>
        $(document).ready(function () {

            console.log('boardcontent function test');
            const typeNo = ${typeNo};
            const boardNo = ${boardNo};
            console.log(boardNo);
            console.log(typeNo + boardNo)
            $.ajax({
                url: '/board/' + typeNo + '/' + boardNo,
                type: 'POST',
                success: function (data) {
                    console.log(data)
                    console.log(data.boardSubject)
                    $('#boardSubject').val(data.boardSubject);
                    $('#userId').append(data.userId);
                    $('#boardCount').append(data.boardCount);
                    $('#boardCreate').append(data.boardCreate);
                    $('#boardRevision').append(data.boardRevision);
                    $('#boardContent').val(data.boardContent);
                    $('#typeNo').val(data.typeNo);
                },
                error: function (data) {
                    console.log(data);
                }
            });



            /* 수정 요청 */
            $('.btnupdate').click(function(){


                const boardSubject = $('#boardSubject').val();
                console.log(boardSubject);
                const boardContent = $('#boardContent').val();
                console.log(boardContent)

                $.ajax({
                    url: '/board/'+typeNo+'/'+boardNo+'/update',
                    type: 'PUT',
                    data_type: 'json',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify({
                        boardSubject:boardSubject,
                        boardContent:boardContent,
                    }),
                    success: function (data) {
                        alert("성공");
                        // location.href='/board/'+typeNo;
                    },
                    error: function (data) {
                        alert("실패");
                    }
                })
            })


        })


    </script>
</head>
<body>
<div class="container" align="center">
    <h2 class="text-primary">게시글 상세정보</h2>
    <table class="table table-bordered">
        <tr>
            <td>제목</td>
            <td><input type="text" id="boardSubject" /> </td>
        </tr>
        <tr>
            <td>작성자</td>
            <td id="userId"></td>
        </tr>
        <tr>
            <td>조회수</td>
            <td id="boardCount"></td>
        </tr>
        <tr>
            <td>작성일</td>
            <td id="boardCreate"></td>
        </tr>
        <tr>
            <td>수정일</td>
            <td id="boardRevision"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <textarea rows="3" id="boardContent" cols="50" name="boardContent" style="display: block;  resize: none;"></textarea>
            </td>
        </tr>

    </table>
    <input type="button" class="btn btn-info btnupdate" value="수정"/>
    <input type="button" class="btn btn-info btncancel" value="취소"/>

</div>
</body>
</html>