<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<style>
    @CHARSET "UTF-8";

    #main_wrap{
        width:400px; height:300px;
        border:1px solid red; border-radius:20px;
        margin-top:100px; margin-left:auto; margin-right:auto;
        box-shadow:15px 15px 15px blue;
    }
    #main_wrap .main_title{
        margin:20px 0 0 120px; width:170px; background:skyblue;
        font-size:20px; border-radius:20px; padding:3px; text-align:center;
    }
    #main_t{
        margin:20px 0 0 30px;
    }
    #main_t th{background:skyblue; border-radius:15px;}
</style>

<style>
    @CHARSET "UTF-8";

    /*관리자 로그인 창 ui */
    #adminLogin_wrap{
        width:300px;
        height:200px; border:1px solid blue;
        border-radius:20px; box-shadow:15px 15px 15px red;
        margin-top:100px; margin-left:auto; margin-right:auto;
    }
    #adminLogin_wrap .adminLogin_title{
        margin:20px 0 0 80px;
        font-size:20px; width:140px; padding:3px;
        border-radius:15px; text-align:center;
        background:skyblue;
    }
    #adminLogin_t{
        margin:20px 0 0 20px;
    }
    #adminLogin_t th{
        background:skyblue; border-radius:15px;
    }
    .input_box{
        border:1px solid skyblue; border-radius:15px; padding:2px;
    }
    .input_box:hover{
        background:#ccc;
    }
    #adminLogin_menu{
        margin:20px 0 0 90px;
    }
    .input_button:hover{
        cursor:pointer; cursor:hand;
        background:pink; border:1px solid red;
        padding:2px; border-radius:15px; font-weight:bold;
    }

    /*관리자 메인 ui*/
    #adminmain_wrap{
        width:1024px; height:860px;
        border:1px solid blue;
        border-radius:15px;
        margin-top:20px; margin-left:auto; margin-right:auto;
    }

    #adminmain_header{
        width:1004px; height:180px;
        margin:10px 0 0 10px; border:1px solid red;
        border-radius:15px;
    }

    #adminheader_left{
        float:left; /*div영역안의 복수개 div 영역을 수직정렬에서 수평정렬로 */
        width:600px; height:160px;
        margin:10px 0 0 10px; border:1px solid skyblue;
        border-radius:15px;
    }

    #adminheader_right{
        float:left; width:370px; height:160px;
        margin:10px 0 0 10px; border:1px solid skyblue; border-radius:15px;
    }

    .clear{clear:both;}

    #adminmain_cont{
        width:1004px; height:560px; margin:10px 0 0 10px;
        border:1px solid red; border-radius:15px;
    }

    #adminmain_footer{
        width:1004px; height:74px; margin:10px 0 0 10px;
        border:1px solid red; border-radius:15px;
    }

    #adminheader_left ul li{
        list-style:none; /*목록앞 점없애기*/
        float:left; /*목록 수직정렬을 수평정렬 */
        margin:70px 0 0 0 ; padding:0 60px 0 23px;
    }

    a:link{text-decoration:none;}
    a:hover{text-decoration:underline;}
    a:active{text-decoration:none;}
    a:visited{text-decoration:none;}

    #adminheader_left .adminheader_title{
        margin:20px 0 0 170px; background:skyblue; border-radius:10px;
        width:240px; padding:3px; font-size:20px; text-align:center;
    }

    #adminheader_right ul li{
        list-style:none; float:left;
        padding:10px 0 0 8px;
    }

    #adminmain_footer .adminmain_footer_title{
        font-size:14px; margin:30px 0 0 110px;
    }

    #adminmain_cont .adminmaincont_title{
        margin:250px 0 0 450px; font-size:18px;
    }

    #admin_home{
        margin:25px 0 0 33px; float:left;
    }

    /*관리자 공지사항 글쓰기 폼(admin_gongji_write.jsp) ui */
    #adminmain_cont .gongjiwrite_title{
        margin:100px 0 0 400px;
        background:skyblue; width:190px; font-size:20px;
        padding:3px; border-radius:15px; text-align:center;
    }

    #gongjiwrite_t{margin:20px 0 0 330px;}

    #gongjiwrite_t th{background:skyblue; border-radius:10px;}

    #gongjiwrite_menu{margin:20px 0 0 430px;}

    /*관리자 공지목록(adminGongji_List.jsp) ui*/
    #adminmain_cont .gongjiList_title{
        margin:30px 0 0  400px; background:skyblue;
        width:180px; font-size:20px; padding:3px; border-radius:15px;
        text-align:center;
    }

    #adminmain_cont .gongjiListcount{
        margin:20px 0 0 600px;
    }

    #gongjilist_t{
        margin:20px 0 0 280px;
    }

    #gongjiList_paging{margin:15px 0 0 370px;}

    #gongjiwrite_input{margin:10px 0 0 600px;}

    /* 관리자 공지 내용 ui */
    #adminmain_cont .gongjicont_title{
        margin:100px 0 0 400px; width:160px;
        background:skyblue; border-radius:20px;
        font-size:20px; text-align:center;padding:3px;
    }
    #gongjicont_t{
        margin:25px 0 0 380px;
    }
    #gongjicont_t th{background:skyblue;border-radius:15px;}
    #gongjicont_menu{
        margin:20px 0 0 400px;
    }

    /*관리자 공지 삭제 ui*/
    #gongjidel_t{
        margin:20px 0 0 380px;
    }
    #gongjidel_t th{
        background-color:skyblue; border-radius:15px;
    }
</style>
<style>

    @CHARSET "UTF-8";

    /*로그인 페이지 ui*/
    #login_wrap{
        width:350px; height:227px; margin-top:100px;
        margin-left:auto; margin-right:auto;
        border:1px solid blue;
        border-radius:20px; box-shadow:15px 15px 15px red;
    }
    #login_wrap .login_title{
        margin:30px 0 0 135px; width:70px;
        background:skyblue; border-radius:15px; text-align:center;
        font-size:20px;
    }
    #login_wrap th{
        background:skyblue; border-radius:15px;
    }
    #login_t{
        margin:20px 0 0 50px;
    }
    #login_menu{
        margin:25px 0 0 47px;
    }

    /*비번찾기 ui*/
    #pwd_wrap{
        width:270px; height:270px;
        margin-top:14px;
        margin-left:auto; margin-right:auto;
        border:1px solid red;
        border-radius:15px;
    }
    #pwd_wrap .pwd_title{
        margin:30px 0 0 88px; width:90px; font-size:20px;
        text-align:center; background:skyblue; border-radius:10px;
    }
    #pwd_t{
        margin:20px 0 0 30px;
    }
    #pwd_t th{background:skyblue; border-radius:15px;}
    #pwd_menu{margin:20px 0 0 88px;}
    #pwd_close{margin:47px 0 0 109px;}

    /*회원가입(member_join.jsp) ui */
    #join_wrap{
        width:570px; height:500px;
        margin-top:50px; margin-left:auto; margin-right:auto;
        border:1px solid blue;
        border-radius:20px;
    }
    #join_wrap .join_title{
        margin:25px 0 0 225px; width:120px;
        font-size:20px; background:skyblue; border-radius:15px;
        text-align:center;
    }
    #join_t{margin:20px 0 0 30px;}

    #join_t th{background:skyblue; border-radius:15px;}

    #join_menu{margin:30px 0 0 220px;}

    /*비번찾기 결과 ui*/
    #pwd_wrap .pwd_title2{
        margin:50px 0 0 65px; width:140px; background:skyblue;
        border-radius:20px; text-align:center;
        font-size:20px; padding:3px;
    }

    #pwd_t2{margin:20px 0 0 60px;}
    #pwd_t2 th{background:skyblue; border-radius:20px;}
    #pwd_close2{
        margin:110px 0 0 120px;
    }

    /*회원 탈퇴*/
    #del_wrap{
        width:400px; height:350px; margin-top:70px;
        margin-left:auto; margin-right:auto;
        border:1px solid blue; border-radius:20px;
        box-shadow:15px 15px 15px red;
    }

    #del_wrap .del_title{
        margin:20px 0 0 140px; width:100px; background:skyblue;
        border-radius:15px; text-align:center; font-size:20px;
    }
    #del_t{
        margin:20px 0 0 30px;
    }
    #del_t th{background:skyblue; border-radius:15px;}
    #del_menu{margin:26px 0 0 140px;}
</style>


<%-- sbboard bbs.css--%>
<style>

    #bbswrite_wrap{
        width:570px; height:412px;
        margin-top:70px; margin-left:auto; margin-right:auto;
        border:1px solid blue; border-radius:20px;
        box-shadow:15px 15px 15px red;
    }
    #bbswrite_wrap .bbswrite_title{
        margin:20px 0 0 220px; width:140px; border-radius:15px;
        font-size:20px; background:skyblue; text-align:center;
        padding:3px;
    }
    #bbswrite_t{margin:20px 0 0 50px;}
    #bbswrite_wrap th{background:skyblue; border-radius:15px;}
    #bbswrite_menu{
        margin:20px 0 0 220px;
    }

    /*자료실 목록*/
    #bbslist_wrap{
        width:560px; height:550px; margin-top:70px;
        margin-left:auto; margin-right:auto;
        border:1px solid blue; border-radius:20px;
        box-shadow:15px 15px 15px #ccc;
    }
    #bbslist_wrap .bbslist_title{
        margin:20px 0 0 220px; width:120px; padding:3px;
        background:skyblue; border-radius:15px;font-size:20px;
        text-align:center;
    }
    #bbslist_c{
        margin:15px 0 0 430px;
    }
    #bbslist_t{
        margin:15px 0 0 40px;
    }
    #bbslist_paging{
        margin:13px 0 0 190px;
    }
    #bbslist_w{
        margin:13px 0 0 450px;
    }

    /*게시물 내용 ui*/
    #bbscont_wrap{
        padding:30px; margin-top:70px;
        margin-left:auto; margin-right:auto;
        border:1px solid blue; border-radius:20px;
        box-shadow:15px 15px 15px red; width:400px;
    }
    #bbscont_wrap .bbscont_title{
        margin:0 0 0 115px; width:170px; padding:3px;
        font-size:20px; text-align:center; background:skyblue;
        border-radius:15px;
    }

    #bbscont_t{
        margin:15px 0 0 30px;
    }
    #bbscont_t th{background:skyblue; border-radius:15px;}
    #bbscont_menu{
        margin:15px 0 0 90px;
    }

    /*게시물 삭제 ui*/
    #del_wrap{
        width:250px; height:180px; margin-top:70px;
        margin-left:auto; margin-right:auto;
        border:1px solid blue; border-radius:20px;
        box-shadow:15px 15px 15px red;
    }
    #del_wrap .del_title{
        margin:20px 0 0 70px; width:120px; background:skyblue;
        border-radius:15px; text-align:center; font-size:20px;
        padding:3px;
    }
    #del_t{
        margin:20px 0 0 30px;
    }
    #del_t th{
        background:skyblue; border-radius:15px;
    }
    #del_menu{
        margin:23px 0 0 80px;
    }

    /*검색 ui*/
    #bbsfind{
        margin:26px 0 0 143px;
    }
</style>

</body>
</html>