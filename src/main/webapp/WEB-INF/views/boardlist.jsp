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

        const typeNo = $("#typeNo").val();
        const page = ${page};

        /*게시판 리스트*/
        console.log('boardlist/{boardtypeNo}의 function 실행완료');
        console.log(typeNo);
        $.ajax({
            url: '/board/' + typeNo + '/list/' + page,
            type: 'POST',
            // data_type: "json",
            // contentType: 'application/json',
            data: {
                typeNo:typeNo
            },
            success: function (data) {

                let list = data.list;
                let paging = data.paging;

                $.each(list, function (i) {
                    //    방법 1
                    // str = '<TR align="center">';
                    //     str +=
                    //         '<TD align="center" id="bno' + i + '">' + data[i].typeNo + '</TD>' +
                    //         '<TD align="center" id="bsubject' + i + '"> ' +
                    //
                    // '<a class="btn btn-default" onclick="upCount(' + data[i].boardNo + ',' + data[i].typeNo + ')" ' +
                    // 'href="/board/'+typeNo+'/content/' + data[i].boardNo + '">' + data[i].boardSubject + '</a></TD>' +
                    //
                    // '<TD align="center" id="buserId' + i + '">' + data[i].userId + '</TD>' +
                    // '<TD align="center" id="bcreate' + i + '">' + data[i].boardCreate + '</TD>' +
                    // '<TD align="center" id="bcount' + i + '">' + data[i].boardCount + '</TD>' +
                    // '<input type="hidden" id="bno+' + i + '" value="' + data[i].boardNo + '">';
                    // str += '</TR>';

                    //    방법2
                    $('.table_body').append('<TR>');
                    $('.table_body').append('<TD align="center" id="bno' + i + '">' + list[i].typeNo + '</TD>');

                    $('.table_body').append('<TD align="center" id="bsubject' + i + '"> ' +
                        '<a class="btn btn-default" onclick="upCount(' + list[i].boardNo + ',' + list[i].typeNo + ')" ' +
                        'href="/board/'+typeNo+'/content/' + list[i].boardNo + '">' + list[i].boardSubject + '</a></TD>');

                    $('.table_body').append('<TD align="center" id="buserId' + i + '">' + list[i].userId + '</TD>');
                    $('.table_body').append('<TD align="center" id="bcreate' + i + '">' + list[i].boardCreate + '</TD>');
                    $('.table_body').append('<TD align="center" id="bcount' + i + '">' + list[i].boardCount + '</TD>');
                    $('.table_body').append('<TD align="center" id="buserId' + i + '">' + list[i].userId + '</TD>');
                    $('.table_body').append('<input type="hidden" id="bno+' + i + '" value="' + list[i].boardNo + '">');
                    $('.table_body').append('</TD>');
                });

            },
            error: function () {
                console.log('에러');
            }
        });
    })
</script>
<%-- 조회수 증가 Function --%>
<script>
    function upCount(bno, tNo) {
        const boardNo = bno;
        const typeNo = tNo;

        $.ajax({
            // URL: '/board/'+typeNo+'/'+boardNo+'/count' ,
            url: '/board/' + typeNo + '/' + boardNo + '/count',
            method: 'PUT',
            data_type: "json",
            contentType: 'application/json',
            data: JSON.stringify({
                boardNo: boardNo,
                typeNo: typeNo,
            }),
            success: function () {
                console('조회수성공')

            },
            error: function () {
                console('조회수실패')
            }
        })
    }


</script>
<body>
접속중인아이디: ${sessionid} ||
totalElements:${totalElements} ||
totalPages:${totalPages} ||
startPage:${startPage} ||
endPage:${endPage} ||
page: ${page} ||
paging: ${page+1} ||
<c:set var="paging" value="${page+1}"/>

<input type="hidden" name="typeNo" id="typeNo" value="${typeNo}" />
<input type="hidden" value="${sessionid}" />


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


    <form>
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
        <%--        <c:if test="${not empty keyword}">--%>

        <%--            <c:if test="${pp.startPage > pp.pagePerBlk }">--%>
        <%--                <li><a href="${path }/list/pageNum/${pp.startPage - 1}?search=${search}&keyword=${keyword}">이전</a></li>--%>
        <%--            </c:if>--%>

        <%--            <c:forEach var="i" begin="${pp.startPage}" end="${pp.endPage}">--%>
        <%--                <li <c:if test="${pp.currentPage==i}">class="active"</c:if>><a--%>
        <%--                        href="${path }/list/pageNum/${i}?search=${search}&keyword=${keyword}">${i}</a></li>--%>
        <%--            </c:forEach>--%>

        <%--            <c:if test="${pp.endPage < pp.totalPage}">--%>
        <%--                <li><a href="${path }/list/pageNum/${pp.endPage + 1}?search=${search}&keyword=${keyword}">다음</a></li>--%>
        <%--            </c:if>--%>

        <%--        </c:if>--%>


        <tbody class="body_paging">

        </tbody>
        <%--검색된내용이 없을경우--%>

        <%--        <c:if test="${empty keyword}">--%>
        <%--조건만족시 a태그 링크위치 없음--%>
        <c:if test="${paging <=1 }">
            <li><a>이전</a></li>
        </c:if>

        <%--1페이지를 초과한 값이 셀렉션된경우--%>
        <c:if test="${paging > 1 }">
            <li><a onClick="Before()">이전</a></li>
        </c:if>

        <%--페이징 버튼--%>
        <c:forEach var="now" begin="${startPage}" end="${endPage}">
            <%--값이 같을 경우 링크없음--%>
            <c:if test="${now == paging }">
                <li><a>${now}</a></li>
            </c:if>
            <%--값이 다를 경우--%>
            <c:if test="${now != paging }">
                <li><a onclick="location.href='/board/' + ${typeNo} + '/page/' + ${now} "> ${now}</a></li>
            </c:if>
        </c:forEach>

        <c:if test="${page >= endPage }">
            <li><a>다음</a></li>
        </c:if>
        <c:if test="${page < endPage }">
            <li><a onClick="Next()">다음</a></li>
        </c:if>
        <%--        </c:if>--%>
    </ul>
    <div align="center">
        <input type="button" value="글쓰기" class="btn btn-info" onclick="location.href=${typeNo} + '/boardwrite'">
    </div>
</div>


<body>
</body>
</body>
</html>