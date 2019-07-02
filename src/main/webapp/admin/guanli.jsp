<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <TITLE>青鸟租房 - 用户管理</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="../css/style.css">
    <META name=GENERATOR>
    <script src="js/test.js"></script>
</HEAD>

<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><%--页面Logo--%>
        <IMG src="../images/logo.gif">
    </DIV>
    <div>
        <span></span>
    </div>
    <DIV class=search><%--右上角跳转按钮--%>
        <LABEL class="ui-green searchs">
            <a href="fabu.htm" title="">发布房屋信息</a>
        </LABEL>
        <LABEL class=ui-green><INPUT onclick='document.location="index.jsp"' value="退       出" type=button name=search></LABEL>
    </DIV>
</DIV>
<DIV class="main wrap">
    <DIV id=houseArea>
        <TABLE class=house-list>
            <c:forEach items="${pageinfo}" var="page">
            <TR>
                <!--图片-->
                <TD class=house-thumb>
                    <A href="#" target="_blank">
                        <img src="http://localhost:82/${page.path}" width="100" height="75">
                    </A>
                </TD>
                <!--文字描叙-->
                <TD>
                    <DL>
                        <DT><A href="#" target="_blank">${page.title}</A></DT>
                        <DD>${page.dName},${page.floorage}<BR>${page.contact}：123</DD>
                    </DL>
                </TD>
                <!--功能按钮-->
                <TD class=house-type>
                    <LABEL class=ui-green>
                        <INPUT onclick="update(46)" value="修    改" type=button name=search>
                    </LABEL>
                </TD>
                <TD class=house-price>
                    <LABEL class=ui-green>
                        <INPUT value="删    除" type=button name=search>
                    </LABEL>
                </TD>
            </TR>
            </c:forEach>
        </TABLE>
    </DIV>
    <!--分页-->
    <DIV class=pager>
        <UL>
            <LI class=current><A id=widget_338868862
                                 href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=1"
                                 parseContent="true" showError="true" targets="houseArea"
                                 ajaxAfterValidation="false" validate="false"
                                 dojoType="struts:BindAnchor">1</A>
            </LI>
            <LI class=current><A id=widget_1160989910
                                 href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=2"
                                 parseContent="true" showError="true" targets="houseArea"
                                 ajaxAfterValidation="false" validate="false"
                                 dojoType="struts:BindAnchor">2</A>
            </LI>
        </UL>
        <SPAN class=total>1/2页</SPAN></DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
<input type="button" onclick="fun()" value="获取URL">
</BODY>
</HTML>
