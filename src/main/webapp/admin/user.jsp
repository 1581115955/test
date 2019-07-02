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
</head>
<script language="JavaScript">
    $(function(){
        //使用datagrid绑定数据展示
        $('#dg').datagrid({
            url:'/getUserByPage',
            fitColumns: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            toolbar:"#ToolBar",
            pageSize:5,
            columns: [[
                {field:'ck',checkbox:true},  //复选框列
                { field: 'id', title: '编号', width: 50, align: "center" },
                { field: 'name', title: '姓名', width: 50, align: "center" },
                { field: 'telephone', title: '电话', width: 50, align: "center" },
                { field: 'isadmin', title: '身份', width: 50, align: "center" },
                { field: 'age', title: '年龄', width: 50, align: "center" },
                { field: 'cz', title: '操作', width: 50, align: "center",
                    formatter:function(value,row,index){
                        return "<a href='javascript:deleteOneUser("+row.id+")'>删除</a>";
                    }
                }
            ]]
        });
    });
    //添加数据并弹框给出反馈
    function SaveDistrict(){
        $('#AddForm').form('submit', {
            url:"/addUser",  //提交的服务器地址
            success:function(data){ //成功的回调函数
                //data接收服务器返回值json字符串（不是json对象）
                var obj=$.parseJSON(data);
                if(obj.result>0){
                    $("#AddDistrict").window("close");//关闭添加窗口
                    $.messager.alert('提示框','恭喜添加成功!');
                    $("#dg").datagrid("reload");//刷新页面
                }else{
                    $.messager.alert('提示框','系统正在维护!');
                }
            }
        });
    }

    //修改数据并给出弹框给出反馈
    function UpdataUser(){
        $('#ChangeForm').form('submit', {
            url:"/changeUsers",  //提交的服务器地址
            success:function(data){ //成功的回调函数
                //data接收服务器返回值json字符串（不是json对象）
                var obj=$.parseJSON(data);
                if(obj.result>0){
                    $("#ChangeUser").window("close");//关闭添加窗口
                    $.messager.alert('提示框','恭喜修改成功!');
                    $("#dg").datagrid("reload");//刷新页面
                }else{
                    $.messager.alert('提示框','系统正在维护!');
                }
            }
        });
    }

    //弹出修改对话框
    function ToChange(){
        var num = $("#dg").datagrid('getSelections');//获取所有选中行，如果没有选中返回空数组
        //判断是否选择了一条记录
        if(num.length!=1){
            $.messager.alert('系统提示','你还没有选中行，或者选择了多行');
            return;
        }
        //选择了一行
        var SelectRow = num[0];  //获取当前行的json:{"id":1000,"name":"丰台"}
        $("#ChangeUser").window("open");//打开修改对话框
        $("#ChangeForm").form('load',SelectRow);//将数据填充到文本框中
    }
    //批量删除
    function DeleteUser(){
        var num = $("#dg").datagrid('getSelections');//获取所有选中行，如果没有选中返回空数组
        //判断是否空选择
        if(num.length==0){
            $.messager.alert("系统提示", "请选择要删除的数据");
            return;
        }
        var deleteId=[];
        for (var i = 0; i < num.length; i++) {
            deleteId.push(num[i].id);
        }
        var idString = deleteId.join(",");//将id用"，"分割并拼接字符串
        $.post("/deleteUsers",{id:idString});
        $("#dg").datagrid("reload");//刷新页面
    }
    //删除单行
    function deleteOneUser(id){
        $.post("/deleteOneUsers",{id:id},function (result) {
            if (result==1){
                $("#dg").datagrid("reload");//刷新页面
                $.messager.alert("系统提示", "删除成功");
            }else{
                $("#dg").datagrid("reload");//刷新页面
                $.messager.alert("系统提示", "服务器正在维护");
            }
        });
    }
    //搜索按钮
    function findUser() {
        var $telephone=$("#tel").val();
        var $startAge=$("#startAge").val();
        var $endAge=$("#endAge").val();
        $("#dg").datagrid("load",{"telephone":$telephone,"startAge":$startAge,"endAge":$endAge});
    }
    //--------------------------------打开/关闭窗口---------------------------------------------
    function Open(message) {//打开窗口
        $("#"+message).window("open");
    }
    function Close(message){//关闭窗口
        $("#"+message).window("close");
    }
</script>
<!-------------------------------------------------------------------------------------->
<body>
<!--工具栏展示-->
<div id="ToolBar">
    <div id="findUser">
        电话：<input class="easyui-validatebox" type="text" name="telephone" id="tel"/>
        开始年龄:<input class="easyui-validatebox" type="text" name="startAge" id="startAge"/>
        结束年龄：<input class="easyui-validatebox" type="text" name="endAge" id="endAge"/>
        <a id="btn" href="javascript:findUser()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    </div>
    <div style="height: 40px;">
    <a href="javascript:Open('AddUser')" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a>
    <a href="javascript:ToChange()" class="easyui-linkbutton"
       iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:DeleteUser()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>
<!--展示数据-->
<table id="dg"></table>

<!--添加窗口内容填充-->
<div id="AddUser" closed="true" buttons ="#AddDialogButtons" title="添加区域"
     style="width: 280px; height: 250px; padding: 10px 20px;" class="easyui-dialog">
    <form id="AddForm" method="post">
        <table>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name" required
                           class="easyui-validatebox" id="bname" /></td>
                <!--requered代表必须输入内容-->
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" name="password" required
                           class="easyui-validatebox" id="pname" /></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" name="telephone" required
                           class="easyui-validatebox" id="tname" /></td>
            </tr>
            <tr>
                <td>身份:</td>
                <td><input type="text" name="isadmin" required
                           class="easyui-validatebox" id="isname" /></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="age" required
                           class="easyui-validatebox" id="agname" /></td>
            </tr>
        </table>
    </form>
</div>

<!--修改窗口内容填充--><!--通过buttons注册两个按钮-->
<div id="ChangeUser" closed="true" buttons ="#ChangeDialogButtons" title="修改区域"
     style="width: 280px; height: 250px; padding: 10px 20px;" class="easyui-dialog">
    <form id="ChangeForm" method="post">
        <table>
            <tr>
                <td><input type="hidden" name="id" required
                           class="easyui-validatebox" id="dname" /></td>
                <!--requered代表必须输入内容-->
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name" required
                           class="easyui-validatebox" id="bname2" /></td>
                <!--requered代表必须输入内容-->
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" name="password" required
                           class="easyui-validatebox" id="pname2" /></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" name="telephone" required
                           class="easyui-validatebox" id="tname2" /></td>
            </tr>
            <tr>
                <td>身份:</td>
                <td><input type="text" name="isadmin" required
                           class="easyui-validatebox" id="isname2" /></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="age" required
                           class="easyui-validatebox" id="agname2" /></td>
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
    <a href="javascript:UpdataUser()"
       class="easyui-linkbutton" iconCls="icon-ok">提交</a>
    <a href="javascript:Close('ChangeUser')"
       class="easyui-linkbutton" iconCls="icon-cancel">返回</a>
</div>
</body>
</html>
