window.onload=function (ev) {

    //1、页面初始化
    {$.post("/getUserMessage",
        {},
        function (data) {
            if (data.userName==="null"){//未登录
                $("#userMessage")[0].style.display="block";
                $("#userMessage2")[0].style.display="none";
            }else{//已登录
                $("#userMessage")[0].style.display="none";
                $("#userMessage2")[0].style.display="block";
                $("#userLogo").text("【欢迎："+data.userName+"】");
            }
        },"json");}
    //2、
};