//1、获得主机地址
var sitePath = 'http://'+ window.location.host;
siteDir = sitePath;


var CommonJs = {
	/*
	  @param {date} 标准时间格式
	  @return yyyy-mm-dd
	*/
	formatDate: function(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		m = m < 10 ? ('0' + m) : m;
		var d = date.getDate();
		d = d < 10 ? ('0' + d) : d;
		return y + '-' + m + '-' + d;
	},
	/*
	  @number个月前/后的时间
	  @param {date,number} 标准时间格式,数字
	  @return yyyy-mm-dd
	*/
	formatDateChange: function(date, number) {
		var newstr = this.formatDate(date);
		newstr = this.getPreMonth(newstr, number);
		return newstr;
	},
	/* 
	 * @number个月前/后的时间
	 * @date 格式为yyyy-mm-dd的日期，如：2014-01-25 
	 */
	getPreMonth: function(date, number) {
		var arr = date.split('-');
		var year = arr[0]; //获取当前日期的年份  
		var month = arr[1]; //获取当前日期的月份  
		var day = arr[2]; //获取当前日期的日  
		var days = new Date(year, month, 0).getDate(); //获取当前日期中月的天数  
		
		var month = parseInt(month) + number;
		if(month < 1) {
			year = parseInt(year) - 1;
			month = month + 12;
		}else if(month > 12) {
			year = parseInt(year) + 1;
			month = month - 12;
		}
		
		var newdays = new Date(year, month, 0).getDate();
		day = (day > newdays)?newdays:parseInt(day);
		day = (day < 10)?('0' + day):day;
		month = (month < 10)?('0' + month):month;
		var newdate = year + '-' + month + '-' + day;
		return newdate;
	},
	//计算天数差的函数，通用  
	dateDiff: function(sDate1, sDate2) { //sDate1和sDate2是2006-12-18格式
		var aDate, oDate1, oDate2, iDays;
		aDate = sDate1.split("-");
		oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]); //转换为12-18-2006格式  
		aDate = sDate2.split("-");
		oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
		iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数  
		return iDays
	},
	//取得地址栏的参数
	GetQueryString: function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r != null) return unescape(r[2]);
		return null;
	},
	//分页
	getLayPage: function(total, limit, callback) {
		layui.use('laypage', function() {
			var laypage = layui.laypage;

			//执行一个laypage实例
			laypage.render({
				elem: 'page', //注意，这里的 test1 是 ID，不用加 # 号
				count: total, //数据总数，从服务端得到
				layout: ['count', 'prev', 'page', 'next', 'skip'],
				theme: '#4E85D7',
				limit: limit,
				jump: function(obj) {
					if(callback) callback(obj);
				}
			});
		});
	},
	//渲染数据
	renderHmtlTem: function(tem, con, data) {
		template.config("escape", false);
		var html = template(tem, data);
		$('#' + con).html(html);
	},
	//下拉框选择
	selectOption:function(callback){
		
		$(document).off().on('click',function(){
			$('.option-list').hide().prev().removeClass("option-open"); 
		});
		
		$(".current-option").off().on("click",function(e){
			if($('.current-option').not(this).hasClass("option-open")){
				$('.option-list').hide().prev().removeClass("option-open"); 
			}
	    	//$(this).toggleClass("option-open");
	    	$(this).toggleClass("option-open").next().toggle();
	    	stopPropagation(e);
	    });
	    
	    $(".select-option").off().on("click",function(e){
	    	var item = {txt:'',val:''};
	    	var back = $(this).parent().attr("data-callback");
	    	
	    	if($(this).parent().parent().hasClass("checkbox-select")){  //多选
	    		var activelen = $(this).parent().find(".active").length;
	    		var active = $(this).hasClass("active");
	    		if(!$(this).hasClass("option-disable")){
		    		if(activelen == 1 && active){
		    			back = false;
		    		}else{
		    			$(this).toggleClass("active");
		    		}
		    		
		    		if(activelen == 3 && !active){
		    			$(this).parent().find(".select-option").not(".active").addClass("option-disable");
		    		}else{
		    			$(this).parent().find(".select-option").removeClass("option-disable");
		    		}
		    		
			    	$(this).parent().find(".active").each(function(){
			    		item.txt += $(this).text() + '/';
			    		item.val += $(this).attr("data-val") + ',';
			    	});
			    	item.txt = item.txt.substr(0,item.txt.length-1);
			    	item.val = item.val.substr(0,item.val.length-1);
			    	$(this).parent().prev().attr("data-val",item.val).text(item.txt);
		    	}else{
		    		back = false;
		    	}
	    	}else{   //单选
		    	$(this).addClass("active").siblings().removeClass("active").parent().hide().prev().removeClass("option-open");
		    	item.txt = $(this).text();
		    	item.val = $(this).attr("data-val");
		    	$(this).parent().prev().attr("data-val",item.val).text(item.txt);
	    	}
	    	//是否回调
	    	if(back){
	    		if (callback) callback(item);
	    	}
	    	stopPropagation(e);
	    });
	    
	    //阻止事件冒泡
	    function stopPropagation(e) { 
			if (e.stopPropagation) 
			e.stopPropagation(); 
			else 
			e.cancelBubble = true; 
		} 
	}
}

var JavaService = {
	postJsonService: function(serviceName, param, callback, errorback) {
		console.log(param);
		$.ajax({
			type: "post",
			url: siteDir + serviceName,
			data: param,
            dataType : "json",
			success: function(result) {
				console.log(result);
				if(callback) callback(result);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				if(errorback) errorback(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	},

	
	getOrderInfo: function(param, callback, errorback) {
		this.postJsonService('modules/orders/getOrder.do', param, callback, errorback);
	},
	
	selectOrderInfo: function(param, callback, errorback) {
		this.postJsonService('modules/orders/selectOrder.do', param, callback, errorback);
	},
	
	queryH5LogInfo: function(param, callback, errorback) {
		this.postJsonService('modules/orders/queryH5Log.do', param, callback, errorback);
	},
	
	orderEditInfo: function(param, callback, errorback) {
		this.postJsonService('modules/orders/orderEdit.do', param, callback, errorback);
	},
	
	getOrderDetail: function(param, callback, errorback) {
		this.postJsonService('modules/orders/getOrderDetail.do', param, callback, errorback);
	},
	
	saveOrderDraft: function(param, callback, errorback) {
		this.postJsonService('modules/orders/saveOrderDraft.do', param, callback, errorback);
	},

	saveOrderDraftAndOver: function(param, callback, errorback) {
		this.postJsonService('modules/orders/saveOrderDraftAndOver.do', param, callback, errorback);
	},

	getOrderHistory: function(param, callback, errorback) {
		this.postJsonService('modules/orders/getOrderHistory.do', param, callback, errorback);
	},
	
	selectCountyByCity: function(param, callback, errorback) {
		this.postJsonService('modules/orders/selectCountyByCity.do', param, callback, errorback);
	},

	
	
	queryUserInfo: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/getUserInfo.do', param, callback, errorback);
	},
	
	deletUserInfo: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/deletUserInfo.do', param, callback, errorback);
	},
	
	updateUserState: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/updateUserState.do', param, callback, errorback);
	},
	
	updateOrInsertUser: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/updateOrInsertUser.do', param, callback, errorback);
	},
	
	
	
	queryAuthorityInfo: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/getAuthorityInfo.do', param, callback, errorback);
	},

	toUpdateAuth: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/toUpdateAuth.do', param, callback, errorback);
	},

	saveUpdateAuth: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/saveUpdateAuth.do', param, callback, errorback);
	},
	
	
	

	queryRoleInfo: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/getRoleInfo.do', param, callback, errorback);
	},
	
	deletRoleInfo: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/deletRoleInfo.do', param, callback, errorback);
	},

	getRolePage: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/getRolePage.do', param, callback, errorback);
	},
	
	savaRoleInfo: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/savaRoleInfo.do', param, callback, errorback);
	},
	

	queryLogInfo: function(param, callback, errorback) {
		this.postJsonService('modules/systemManagement/getLogInfo.do', param, callback, errorback);
	},
}