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
            console.log('게시판 내용불러오기 ajax')
            const typeNo = ${typeNo};
            const boardNo = ${boardNo};
            $.ajax({
                url: '/board/' + typeNo + '/' + boardNo,
                type: 'POST',
                success: function (data) {
                    console.log(data)
                    console.log(data.boardSubject)
                    $('#boardSubject').val(data.boardSubject); // id 값에 값을 추가
                    $('#userId').val(data.userId);
                    $('#boardCount').val(data.boardCount);
                    $('#boardCreate').val(data.boardCreate);
                    $('#boardRevision').val(data.boardRevision);
                    $('#boardContent').val(data.boardContent);
                    $('#typeNo').val(data.typeNo);
                    $('#boardNo').val(data.boardNo);
                },
                error: function (data) {
                    console.log(data);
                }
            });


            /* 수정 요청 */
            $('.btnupdate').click(function () {
                console.log('수정요청 ajax')
                const frmData = $("form").serialize();  // name 태그값을 가져옴... 주의
                console.log(frmData)

                $.ajax({
                    url: '/board/' + typeNo + '/' + boardNo + '/update',
                    type: 'PUT',
                    // data_type: 'json',
                    // contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(
                        frmData
                    ),
                    success: function (data) {
                        alert("성공");
                        // location.href = '/board/' + typeNo + '/' + boardNo;
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
접속중인아이디: ${sessionid} <br>
<div class="container" align="center">
    <h2 class="text-primary">게시글 상세정보</h2>
    <form>
        <input type="hidden" id="typeNo" name="typeNo" />
        <input type="hidden" id="boardNo" name="boardNo"/>
        <table class="table table-bordered">
            <tr>
                <td>제목</td>
                <td><input type="text" id="boardSubject" name="boardSubject"/></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" id="userId" name="userId" readonly="readonly" style="border:0 solid black; outline: none"/> </td>
            </tr>
            <tr>
                <td>조회수</td>
                <td><input type="text" id="boardCount" name="boardCount" readonly="readonly" style="border:0 solid black; outline: none"/></td>
            </tr>
            <tr>
                <td>작성일</td>
                <td><input type="text" id="boardCreate" name="boardCreate" readonly="readonly" style="border:0 solid black; outline: none"/></td>
            </tr>
            <tr>
                <td>수정일</td>
                <td><input type="text" id="boardRevision" name="boardRevision" readonly="readonly" style="border:0 solid black; outline: none"/></td>
            </tr>
            <tr>
                <td>내용</td>
                <td>
                    <textarea rows="3" id="boardContent" cols="50" name="boardContent" style="display: block;  resize: none;"></textarea>
                </td>
            </tr>
        </table>
    </form>
        <input type="button" class="btn btn-info btnupdate" value="수정"/>
        <input type="button" class="btn btn-info btncancel" value="취소"/>
</div>
</body>
</html>