<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <TITLE>青鸟租房 - 用户注册</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script type="text/javascript" src="js/register.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</HEAD>

<BODY>
<DIV id=header class=wrap>
    <DIV id=logo>
        <IMG src="../images/logo.gif">
    </DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DL class=clearfix>
            <DT>新用户注册</DT>
            <DD class=past>填写个人信息</DD>
        </DL>
        <DIV class=box>
            <FORM method="post" action="/newUser">
                <DIV class=infos>
                    <TABLE class=field>
                        <TR>
                            <TD class=field>用 户 名：</TD>
                            <TD>
                                <INPUT class=text type=text name="name" onblur="message1(this)">
                                <span id="message1"></span>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>密　　码：</TD>
                            <TD>
                                <INPUT class=text type=password name="password" onblur="message2(this)"
                                       id="oldPassword">
                                <span id="message2"></span>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>确认密码：</TD>
                            <TD><INPUT class=text type=password name="repassword" onblur="message3(this)">
                                <span id="message3"></span>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>电　　话：</TD>
                            <TD><INPUT class=text type=text name="telephone">
                                <span id="message4"></span>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>年　　龄：</TD>
                            <TD><INPUT class=text type=text name="age" onblur="message5(this)">
                                <span id="message5"></span>
                            </TD>
                        </TR>
                    </TABLE>
                    <DIV class=buttons>
                        <INPUT value="立即注册" type="submit">
                    </DIV>
                </DIV>
            </FORM>
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
</HTML>
