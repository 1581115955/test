$(function () {
    var qu = document.getElementById("qu").value;
    var jieHTML = "";
    $.post("/getStreet",{"id":qu},function (result) {
        for (var i = 0; i < result.length; i++) {
            jieHTML = jieHTML +"<option name="+result[i].id+">"+result[i].name+"</option>";
        }
        console.log(jieHTML);
        $("#streetId").html(jieHTML);
    });
});
function showJieDao(ev) {
    var qu = ev.value;
    var jieHTML = "";
    $.post("/getStreet",{"id":qu},function (result) {
        for (var i = 0; i < result.length; i++) {
            jieHTML = jieHTML +"<option name="+result[i].id+">"+result[i].name+"</option>";
        }
        console.log(jieHTML);
        $("#streetId").html(jieHTML);
    });
};