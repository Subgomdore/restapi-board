<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<script>
    $(document).ready(function () {


        /*게시판 리스트*/
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
                    str += '<TD align="center" id="bno'+i+'">' + data[i].typeNo + '</TD>' +
                        // '<TD align="center" id="bsubject'+i+'"> <a class="btn btn-default" onclick="upCount('+data[i].boardNo+','+data[i].typeNo+')" >'+data[i].boardSubject+'</a></TD>' +
                        '<TD align="center" id="bsubject'+i+'"> <a class="btn btn-default" onclick="upCount('+data[i].boardNo+','+data[i].typeNo+')" href="${typeNo}/'+ data[i].boardNo +'">'+data[i].boardSubject+'</a></TD>' +
                        '<TD align="center" id="buserId'+i+'">' + data[i].userId + '</TD>' +
                        '<TD align="center" id="bcreate'+i+'">' + data[i].boardCreate + '</TD>' +
                        '<TD align="center" id="bcount'+i+'">'+data[i].boardCount+'</TD>'+
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
<%-- 조회수 증가 Function --%>
<script>
    function upCount(bno, tNo){
        const boardNo = bno;
        const typeNo = tNo;

        $.ajax({
            // URL: '/board/'+typeNo+'/'+boardNo+'/count' ,
            url: '/board/'+typeNo+'/'+boardNo+'/count',
            method: 'PUT',
            data_type: "json",
            contentType: 'application/json',
            data:JSON.stringify({
                boardNo: boardNo,
                typeNo:typeNo
            }),
            success: function () {
                console('조회수성공')

            },
            error: function (){
                console('조회수실패')
            }
        })
    }

</script>
<body>
접속중인아이디: ${sessionid} <br>
<div class="container" align="center">
    <h2 class="text-primary">게시판 목록</h2>
    <table class="table table-striped">
        <tr>
            <td align="center">번호</td>
            <td align="center">제목</td>
            <td align="center">작성자</td>
            <td align="center">작성일</td>
            <td align="center">조회수</td>
        </tr>
        <tbody class="table_body">

        </tbody>
    </table>


    <form<%-- action="${path}/list/pageNum/1"--%>>
        <select name="search">
            <option value="subject"
                    <c:if test="${search=='subject'}">selected="selected" </c:if>>제목
            </option>
            <option value="content"
                    <c:if test="${search=='content'}">selected="selected" </c:if>>내용
            </option>
            <option value="writer"
                    <c:if test="${search=='writer'}">selected="selected" </c:if>>작성자
            </option>
            <option value="subcon"
                    <c:if test="${search=='subcon'}">selected="selected" </c:if>>제목+내용
            </option>
        </select>
        <input type="text" name="keyword">
        <input type="submit" value="확인">
    </form>
    <ul class="pagination">
        <c:if test="${not empty keyword}">
            <c:if test="${pp.startPage > pp.pagePerBlk }">
                <li><a href="${path }/list/pageNum/${pp.startPage - 1}?search=${search}&keyword=${keyword}">이전</a></li>
            </c:if>
            <c:forEach var="i" begin="${pp.startPage}" end="${pp.endPage}">
                <li <c:if test="${pp.currentPage==i}">class="active"</c:if>><a
                        href="${path }/list/pageNum/${i}?search=${search}&keyword=${keyword}">${i}</a></li>
            </c:forEach>
            <c:if test="${pp.endPage < pp.totalPage}">
                <li><a href="${path }/list/pageNum/${pp.endPage + 1}?search=${search}&keyword=${keyword}">다음</a></li>
            </c:if>
        </c:if>
        <c:if test="${empty keyword}">
            <c:if test="${pp.startPage > pp.pagePerBlk }">
                <li><a href="${path }/list/pageNum/${pp.startPage - 1}">이전</a></li>
            </c:if>
            <c:forEach var="i" begin="${pp.startPage}" end="${pp.endPage}">
                <li <c:if test="${pp.currentPage==i}">class="active"</c:if>><a
                        href="${path }/list/pageNum/${i}">${i}</a></li>
            </c:forEach>
            <c:if test="${pp.endPage < pp.totalPage}">
                <li><a href="${path }/list/pageNum/${pp.endPage + 1}">다음</a></li>
            </c:if>
        </c:if>
    </ul>
    <div align="center">
        <input type="button" value="글쓰기" class="btn btn-info" onclick="location.href=${typeNo} + '/boardwrite'">
    </div>
</div>
</body>
</html>