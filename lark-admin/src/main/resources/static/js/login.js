
function changeImg() {        
        var imgSrc = $("#imgObj");    
        var src = imgSrc.attr("src");        
        imgSrc.attr("src", chgUrl(src));
    }
    
// 时间戳
// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function chgUrl(url) {
    var timestamp = (new Date()).valueOf();
    url = url.substring(0, 22);
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}


function setOpName(){
	var OpName = $('.opName-txt').val();
	var base_opName=Base.encode(OpName);
	 $(".opName").val(base_opName);
}

function setPassWord(){
	var passWord = $('.passWord-txt').val();
	var base_passWord=Base.encode(passWord);
	$(".passWord").val(base_passWord);
}

// 登录帐号密码非空检查
function check(){
	var opName = $('.opName').val();
	var passWord = $('.passWord').val();
	
	//var loginCode= $('.photokey').val();
	
　　/*if(loginName == null || loginName == ""){
　　　　alert("用户名不能为空");
　　　　return false;
　　}else if(passWord == null || passWord == ""){
	 	alert("密码不能为空");
	　　return false;
	}*/
　　return true;
}
