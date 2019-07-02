<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <TITLE>青鸟租房 - 用户登录</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script type="text/javascript" src="../admin/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../admin/js/login.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DIV class=box>
            <H4>用户登录</H4>
            <DIV class=infos>
                <TABLE class=field>
                    <TR>
                        <TD colSpan=2>
                            <input type="text" hidden value="${result}" id="result1">
                        </TD>
                    </TR>
                    <TR>
                        <TD class=field>用 户 名：</TD>
                        <TD>
                            <INPUT class=text type=text id="userName">
                        </TD>
                    </TR>
                    <TR>
                        <TD class=field>密　　码：</TD>
                        <TD>
                            <INPUT class=text type=password id="password">
                        </TD>
                    </TR>
                </TABLE>
                <DIV class=buttons>
                    <INPUT type="button" value="登陆" id="login">
                    <INPUT onclick='document.location="register.jsp"' value=注册 type=button>
                </DIV>
                <div style="height: 20px">
                    <span style="color: red" id="message">&nbsp</span>
                </div>
            </DIV>
        </DIV>
    </DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
<script>
    $(function () {
       $.post(
           "",
           {},
           function (date) {
               $("#id").html(date.username);//去session里面找东西丢回来
           },"json"
       )
    });
    $("#login")[0].onclick = function(ev){
        //获取用户输入的用户名和密码
        var userName = $("#userName")[0].value;
        var password = $("#password")[0].value;
        //ajax技术提交表单
        $.post(
            "/login",
            {"userName":userName,"password":password},
            function (data) {
                if(data.result!=="false"){//登录成功
                    if (data.result==="guanli"){
                        alert("管理界面");
                        window.location="/admin/guanli.jsp";
                    }else{
                        alert("普通用户页面");
                        window.location="/admin/list.jsp";
                    }
                    //window.location="";
                }else{//登录失败
                    $("#message").text("用户名或密码输入错误");
                    alert("用户名或密码输入错误");
                }
            },"json")//返回json对象【返回json字符串需要解决乱码问题】
    };
    $("#password").focus(function () {
        $("#message").text("");
    })
</script>
</HTML>