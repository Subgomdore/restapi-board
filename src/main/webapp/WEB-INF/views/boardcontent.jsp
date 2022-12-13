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
                    $('#boardSubject').append(data.boardSubject);
                    $('#userId').append(data.userId);
                    $('#boardCount').append(data.boardCount);
                    $('#boardCreate').append(data.boardCreate);
                    $('#boardRevision').append(data.boardRevision);
                    $('#boardContent').append(data.boardContent);
                    $('#typeNo').append(data.typeNo);
                },
                error: function (data) {
                    console.log(data);
                }
            });

            /* 목록버튼 기능 (해당타입의 게시판리스트로) */
            $('.bfoPage').click(function(){
                location.href='/board/'+typeNo;
            })

            $('.uppage').click(function(){
                location.href='/board/'+typeNo+'/'+boardNo+'/update';
            })

            $('.delete').click(function(){
                location.href='';
            })

            $('.reply').click(function(){
                location.href='';
            })


        })
    </script>

    <%--댓글 입력하기--%>
    <script type="text/javascript">
        /* 	window.onload=function() {

         } */
        $(function () {
            <%--$('#slist').load('${path}/slist/num/${board.num}')--%>
//		$('#list').load('${path}/list/pageNum/${pageNum}');
            $('#repInsert').click(function () {
                if (!frm.replytext.value) {
                    alert('댓글 입력후에 클릭하시오');
                    frm.replytext.focus();
                    return false;
                }
                var frmData = $('form').serialize();
                // var frmData = 'replyer='+frm.replyer.value+'&bno='+
                //				  frm.bno.value+'&replytext='+frm.replytext.value;
                $.post('${path}/sInsert', frmData, function (data) {
                    $('#slist').html(data);
                    frm.replytext.value = '';
                });
            });
        });
    </script>
</head>
<body>
<div class="container" align="center">
    <h2 class="text-primary">게시글 상세정보</h2>
    <table class="table table-bordered">
        <tr>
            <td>제목</td>
            <td id="boardSubject"></td>
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
                <textarea rows="3" id="boardContent" cols="50" name="boardContent" readonly="readonly"
                          style="display: block; border: 1px; outline: none; resize: none;"></textarea>
            </td>
        </tr>

    </table>
    <input type="button" class="btn btn-info bfoPage" value="목록"/>
    <input type="button" class="btn btn-info uppage" value="수정" onclick=""/>
    <input type="button" class="btn btn-info delete" value="삭제" onclick=""/>
    <input type="button" class="btn btn-info reply" value="답변" onclick=""/>

    <p>
    <form name="frm" id="frm">
        <input type="hidden" name="replyer" value="${board.writer}">
        <input type="hidden" name="bno" value="${board.num}"> 댓글 :
        <textarea rows="3" cols="50" name="replytext"></textarea>
        <input type="button" value="확인" id="repInsert">
    </form>
    <div id="slist"></div>
    <!-- <div id="list"></div> -->
</div>
</body>
</html>