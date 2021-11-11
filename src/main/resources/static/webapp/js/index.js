var  url="http://localhost:8088";
var getsession="/admit/getsession"
var getRank="/admit/getRank"
var deleteRank="/admit/deleteRank"
var resivateRank="/admit/resivateRank"
var admitLook="/admit/admitLook"
var resivateadmit ="/admit/resivateadmit"
var deleteadmit ="/admit/deleteadmit"
var admitinformation ="/admit/admitinformation"
var information = "/admit/information"
var getinformation = "/admit/getinformation"
function login(){
    var submit = document.getElementById("login");
    submit.action = url + "/admit/login";
}
function register(){
    var submit = document.getElementById("register");
    submit.action = url + "/admit/register";
}
function addRank(){
    var submit = document.getElementById("addrank");
    submit.action = url + "/admit/addRank";
}