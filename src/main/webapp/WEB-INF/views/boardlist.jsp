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
        const typeNo = '${typeNo}';
        const page = ${page};

        /*게시판 페이징과 토탈카운트 조회*/
        $.ajax({
            url: '/board/' + typeNo + '/PN',
            type: 'POST',
            data_type: "json",
            contentType: 'application/json',
            data: JSON.stringify({
                typeNo: typeNo
            }),
            success: function (data){
                $('#totalPages').val(data.totalPages)
                console.log('-------------')
                console.log(data.totalPages);
                console.log(data.totalElements);
                console.log('-------------')
            },
            error: function (){
                console.log('페이징조회 실패');
            }
        })


        /*게시판 리스트*/
        console.log('boardlist/{boardtypeNo}의 function 실행완료');
        console.log(typeNo);
        console.log("page"+page);
        $.ajax({
            url: '/board/' + typeNo + '/list',
            type: 'POST',
            data_type: "json",
            contentType: 'application/json',
            data: JSON.stringify({
                typeNo: typeNo,
                page: page
            }),
            success: function (data) {
                str = '<TR align="center">';
                $.each(data, function (i) {
                    console.log(i)
                    str += '<TD align="center" id="bno' + i + '">' + data[i].typeNo + '</TD>' +
                        // '<TD align="center" id="bsubject'+i+'"> <a class="btn btn-default" onclick="upCount('+data[i].boardNo+','+data[i].typeNo+')" >'+data[i].boardSubject+'</a></TD>' +
                        '<TD align="center" id="bsubject' + i + '"> <a class="btn btn-default" onclick="upCount(' + data[i].boardNo + ',' + data[i].typeNo + ')" href="${typeNo}/' + data[i].boardNo + '">' + data[i].boardSubject + '</a></TD>' +
                        '<TD align="center" id="buserId' + i + '">' + data[i].userId + '</TD>' +
                        '<TD align="center" id="bcreate' + i + '">' + data[i].boardCreate + '</TD>' +
                        '<TD align="center" id="bcount' + i + '">' + data[i].boardCount + '</TD>' +
                        '<input type="hidden" id="bno+' + i + '" value="' + data[i].boardNo + '">';
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
접속중인아이디: ${sessionid} <br>
Page의 원소 값: ${page} <br>
<c:set var="viewpage" value="${page+1}" />
ViewPage 페이징 값: ${viewpage} <br>
totalPages 페이징 값: <input type="text" id="totalPages" name="totalPages" readonly="readonly" style="outline: none; border: 0;"> <br>
pageSize 페이징 값: ${pageSize} <br>

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

        <%--검색된내용이 없을경우--%>
        <c:if test="${empty keyword}">
            <c:if test="${viewpage <=1 }">
                <li><a>이전</a></li>
            </c:if>

            <c:if test="${viewpage > 1 }">
                <li><a onClick="Before(${viewpage},${product_num })">이전</a></li>
            </c:if>

            <c:forEach var="a" begin="${startpage}" end="${endpage}">
                <c:if test="${a == viewpage }">
                    <li><a>${a}</a></li>
                </c:if>
                <c:if test="${a != viewpage }">
                    <li><a onClick="SelPage(${a},${product_num })">${a}</a></li>
                </c:if>
            </c:forEach>

            <c:if test="${viewpage >= maxpage }">
                <li><a>다음</a></li>
            </c:if>
            <c:if test="${viewpage < maxpage }">
                <li><a onClick="Next(${viewpage},${product_num })">다음</a></li>
            </c:if>
        </c:if>
    </ul>
    <div align="center">
        <input type="button" value="글쓰기" class="btn btn-info" onclick="location.href=${typeNo} + '/boardwrite'">
    </div>
</div>
</body>
</html>