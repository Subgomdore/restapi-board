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
        const page_number = 1;

        console.log('load완료');
        $.ajax({
            url: '/board/list',
            type: 'GET',

            success: function (data) {
                str = '<TR align="center">';
                $.each(data, function (i) {
                    console.log(i)
                    str += '<TD align="center" id="bno'+i+'"> ' + data[i].typeNo + '</TD>' +
                        '<TD align="center" id="bname'+i+'"> <a href="/board/'+ data[i].typeNo +'/page/'+page_number+'">'+data[i].typeName+'</a></TD>';
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

<script>

    function Type_insert(){
        const typeName = $('#typeName').val();
        console.log(typeName);

        $.ajax({
            url: 'board/boardtype-add', /*BoardType Controller 요청*/
            type: 'POST',
            data_type: "json",
            contentType: 'application/json',
            data:JSON.stringify({
                typeName:typeName
            }),
            success: function (data) {
                location.href='board'
            },
            error: function () {
                console.log('에러');
            }
        });
    }

</script>
<body>

접속중인아이디: ${sessionid} <br>
게시판종류 추가하기: <input id="typeName" type="text"/> <input type="button" onclick="Type_insert()" value="추가"/>

<div class="container" align="center">
    <h2 class="text-primary">게시판 목록</h2>
    <table class="table table-striped">
        <tr>
            <td align="center">번호</td>
            <td align="center">제목</td>
        </tr>
<%--        <c:if test="${empty list}">--%>
<%--            <tr>--%>
<%--                <td colspan="5">데이터가 없습니다</td>--%>
<%--            </tr>--%>
<%--        </c:if>--%>


        <tbody class="table_body">

        </tbody>
    </table>



</div>
</body>
</html>