url="http://localhost:8088/"
function getData(api,data,enctype) {
    var xmlHttp = creatXmlHttpRequest();
    xmlHttp.open("POST",url+api,true);
    xmlHttp.setRequestHeader("Content-type", enctype,"charset=UTF-8");
    xmlHttp.send(data);
    var text = xmlHttp.responseText;
    return text;
}


//创建XMLHttpRequest对象
function creatXmlHttpRequest() {
    var xmlHttp;
    try{
        //非IE浏览器使用
        xmlHttp = new XMLHttpRequest();
    }catch(e){
        try{
            xmlHttp = new ActiveXobject("Msxm.XMLHTTP");
        }catch(e){
            try{
                xmlHttp = new ActiveXobject("Microsoft.XMLHTTP");
            }catch(e){

            }
        }
    }
    return xmlHttp;
}


function requestData(api,data){
    var str;
    $.ajax({
        //请求路径
        url : api,
        //请求类型
        type : "POST",
        //data表示发送的数据
        /**data : JSON.stringify({
                pname : pname,
                password : password,
                page : page
            }), //定义发送请求的数据格式为JSON字符串**/
        data:data,
        contentType : "application/json;charset=utf-8",
        //定义回调响应的数据格式为JSON字符串，该属性可以省略
        dataType : "json",
        //成功响应的结果
        success : function(data) {
            str = data;
            alert(data)
        }
    });
    return str;
}