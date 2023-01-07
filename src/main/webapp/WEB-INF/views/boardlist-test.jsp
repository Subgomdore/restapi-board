<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>


<body>
<hr>
페이지에 도착하면 가지고 있어야 할 값들 <br>
* typeNo 는 게시판에 대한 처리를 위해 종속적으로 값을 가지고 다녀야함 <br><br>

1. page_number -> @PathVariable 처리<br>
2. pageSize -> 디폴트값을 주되, 요청받은 값이 있을경우 값을 변경해서 리턴<br>
3. 검색에 대한 키워드 (제목, 내용, 작성자, 제목+작성자) -> 특정 select하고 서치를 할 경우 requst해서 object로 다시 가져옴<br>
그 다음 다시 현재페이지에서 ajax로 요청

<hr>

<input type="hidden" name="typeNo" id="typeNo" value="${typeNo}"/>
<input type="hidden" value="${sessionid}"/>
<div id="Board">


    <div id="boardList">
        <div class="container" align="center">
            <h2 align="center" class="text-primary">게시판 목록</h2>
            <table class="table table-striped">
                <tr>
                    <td align="center">번호</td>
                    <td align="center">제목</td>
                    <td align="center">작성자</td>
                    <td align="center">작성일(수정일)</td>
                    <td align="center">조회수</td>
                </tr>
                <tbody class="table_body">

                </tbody>
            </table>

            <form>
                <select onchange="pageSize(this)">
                    <option value="5" selected="selected" >5개씩보기</option>
                    <option value="10">10개씩보기</option>
                </select>

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
                <%--                /board/{typeNo}/boardwrite--%>
                <input type="button" value="글쓰기" class="btn btn-info" onclick="location.href='/board/'+ ${typeNo} + '/boardwrite'">
            </div>
        </div>
    </div>
</div>
</body>

</html>