window.onload=function (ev) {
    $('#dg').datagrid({//当页面加载时展示表格信息
        url: '/getDistrictByPage',
        fitColumns: true,
        pagination: true,
        pageList: [5, 10, 15, 20],
        toolbar: "#ToolBar",
        pageSize: 5,
        columns: [[
            {field: 'ck', checkbox: true},  //复选框列
            {field: 'id', title: '编号', width: 50, align: "center"},
            {field: 'name', title: '名称', width: 50, align: "center"},
            {
                field: 'cz', title: '操作', width: 50, align: "center",
                formatter: function (value, row, index) {
                    return "<a href='javascript:deleteOneDistrict(" + row.id + ")'>删除</a>";
                }
            }
        ]]
    });
};
//添加数据并弹框给出反馈
function SaveDistrict() {
    $('#AddForm').form('submit', {
        url: "/addDistrict",  //提交的服务器地址
        success: function (data) { //成功的回调函数
            //data接收服务器返回值json字符串（不是json对象）
            var obj = $.parseJSON(data);
            if (obj.result > 0) {
                $("#AddDistrict").window("close");//关闭添加窗口
                $.messager.alert('提示框', '恭喜添加成功!');
                $("#dg").datagrid("reload");//刷新页面
            } else {
                $.messager.alert('提示框', '系统正在维护!');
            }
        }
    });
}
//修改数据并给出弹框给出反馈
function UpdataDistrict() {
    $('#ChangeForm').form('submit', {
        url: "/changeDistrict",  //提交的服务器地址
        success: function (data) { //成功的回调函数
            //data接收服务器返回值json字符串（不是json对象）
            var obj = $.parseJSON(data);
            if (obj.result > 0) {
                $("#ChangeDistrict").window("close");//关闭添加窗口
                $.messager.alert('提示框', '恭喜修改成功!');
                $("#dg").datagrid("reload");//刷新页面
            } else {
                $.messager.alert('提示框', '系统正在维护!');
            }
        }
    });
}
//弹出修改对话框
function ToChange() {
    var num = $("#dg").datagrid('getSelections');//获取所有选中行，如果没有选中返回空数组
    //判断是否选择了一条记录
    if (num.length != 1) {
        $.messager.alert('系统提示', '你还没有选中行，或者选择了多行');
        return;
    }
    //选择了一行
    var SelectRow = num[0];  //获取当前行的json:{"id":1000,"name":"丰台"}
    $("#ChangeDistrict").window("open");//打开修改对话框
    $("#ChangeForm").form('load', SelectRow);//将数据填充到文本框中
}

//批量删除
function DeleteDistrict() {
    var num = $("#dg").datagrid('getSelections');//获取所有选中行，如果没有选中返回空数组
    //判断是否空选择
    if (num.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据");
        return;
    }
    var deleteId = [];
    for (var i = 0; i < num.length; i++) {
        deleteId.push(num[i].id);
    }
    var idString = deleteId.join(",");//将id用"，"分割并拼接字符串
    $.post("/deleteDistrict", {id: idString});
    $("#dg").datagrid("reload");//刷新页面
}

//删除单行
function deleteOneDistrict(id) {
    $.post("/deleteOneDistrict",//URL
        {id: id},               //参数
        function (result) {     //回掉函数
            if (result == 1) {
                $("#dg").datagrid("reload");//刷新页面
                $.messager.alert("系统提示", "删除成功");
            } else {
                $("#dg").datagrid("reload");//刷新页面
                $.messager.alert("系统提示", "服务器正在维护");
            }
    });
}

//--------------------------------打开/关闭窗口---------------------------------------------
function Open(id) {//打开窗口
    $("#" + id).window("open");
}
function Close(id) {//关闭窗口
    $("#" + id).window("close");
}