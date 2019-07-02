<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/18
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="Css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="myjs/district.js"></script>
</head>
<body>

<!--工具栏展示-->
<div id="ToolBar">
    <div style="height: 40px;">
    <a href="javascript:Open('AddDistrict')" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a>
    <a href="javascript:ToChange()" class="easyui-linkbutton"
       iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:DeleteDistrict()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>
<!--展示数据-->
<table id="dg"></table>
r
<!--添加窗口内容填充-->
<div id="AddDistrict" closed="true" buttons ="#AddDialogButtons" title="添加区域"
     style="width: 280px; height: 250px; padding: 10px 20px;" class="easyui-dialog">
    <form id="AddForm" method="post">
        <table>
            <tr>
                <td>区域:</td>
                <td><input type="text" name="name" required
                           class="easyui-validatebox" id="bname" /></td>
                <!--requered代表必须输入内容-->
            </tr>
        </table>
    </form>
</div>

<!--修改窗口内容填充--><!--通过buttons注册两个按钮-->
<div id="ChangeDistrict" closed="true" buttons ="#ChangeDialogButtons" title="修改区域"
     style="width: 280px; height: 250px; padding: 10px 20px;" class="easyui-dialog">
    <form id="ChangeForm" method="post">
        <table>
            <tr>
                <td><input type="hidden" name="id" required
                           class="easyui-validatebox" id="dname" /></td>
                <!--requered代表必须输入内容-->
            </tr>
            <tr>
                <td>区域:</td>
                <td><input type="text" name="name" required
                           class="easyui-validatebox" id="cname" /></td>
                <!--requered代表必须输入内容-->
            </tr>
        </table>
    </form>
</div>

<!--给添加对话框添加按钮--><!--href：数据提交函数-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDistrict()"
       class="easyui-linkbutton" iconCls="icon-ok">提交</a>
    <a href="javascript:Close('AddDistrict')"
       class="easyui-linkbutton" iconCls="icon-cancel">返回</a>
</div>
<!--给修改对话框添加按钮-->
<div id="ChangeDialogButtons">
    <a href="javascript:UpdataDistrict()"
       class="easyui-linkbutton" iconCls="icon-ok">提交</a>
    <a href="javascript:Close('ChangeDistrict')"
       class="easyui-linkbutton" iconCls="icon-cancel">返回</a>
</div>
</body>
</html>
