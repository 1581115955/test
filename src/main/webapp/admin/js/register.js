window.onload=function (ev) {

};
function message1(ev) {//验证用户名是否存在
    var mess = $("#message1");
    $.post(
        "/toName",
        {"name":ev.value},
        function (result) {
            if (!result){
                mess.html("用户名可用").css("color","green");
            }else{
                mess.html("用户名已存在").css("color","red");
            }
        });
}
function message2(ev) {//验证密码格式是否合法
    var mess = $("#message2");
    var password = ev.value;
    var rel = /[0-9]{6,12}/;
    if (rel.test(password)){
        mess.html("").css("color","green");
    }else{
        mess.html("只能是6-12位数字").css("color","red");
    }
}
function message3(ev) {//验证两次密码输入是否相同
    var mess = $("#message3");
    var old = $("#oldPassword").val();
    var newPassword = ev.value;
    if (old===newPassword){
        mess.html("").css("color","green");
    }else{
        mess.html("两次密码不相同").css("color","red");
    }
}
function message5(ev) {//校验年龄是否合法
    var mess = $("#message5");
    var age = ev.value;
    var rels = /[0-9]{1,3}/;
    if (rels.test(age)){
        mess.html("").css("color","green");
    }else{
        mess.html("年龄输入不合法").css("color","red");
    }
}
