//1、获得主机地址
var sitePath = 'http://'+ window.location.host;
siteDir = sitePath;


//调用后台的统一方法
var JavaService = {
	postJsonService: function(serviceName, param, callback, errorback) {
		console.log(param);
		$.ajax({
			type: "post",
			url: siteDir + serviceName,
			data: param,
			contentType:"application/json; charset=UTF-8",
            dataType : "json",
			success: function(result) {
				console.log(result);
				if(callback) callback(result);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				if(errorback) errorback(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	}
}


