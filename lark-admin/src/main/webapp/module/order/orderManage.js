var Order = (function() {
	var start, end;
	var isFirst = true;
	var params = {};
	params.limit = 10;
	var cdate = new Date();
	params.startDate = CommonJs.formatDateChange(cdate, -1);
	params.endDate = CommonJs.formatDate(cdate);
//	params.userName = CommonJs.GetQueryString("userName");
	
	$(document).ready(function() {
		//日期插件
		renderDate();
		//分页
		//renderLayPage(60);
		//调用取数服务
		getServiceData(1);
		//监听事件
		bindEvent();
	});

	//获取表格数据
	function getServiceData(currpage) {
		params.currentPage = currpage;
		JavaService.getOrderInfo(
			params,
			function(result) {
				console.log(result);
				if(parseInt(result.code)==1){
					if(isFirst) {
						CommonJs.renderHmtlTem("tableTem","tableDataList",result.data);
						renderLayPage(parseInt(result.data.allSize));
					} else {
						CommonJs.renderHmtlTem("tableTem","tableDataList",result.data);
					}
					bindEvent();
				}else{
					alert("获取数据出错!");
				}	
			}
		);
	}

	//日期组件
	function renderDate() {
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			start = laydate.render({
				elem: '#startDate',
				theme: '#00CCA2',
				btns: ['now', 'confirm'],
				//min: params.startDate,
				//max: params.endDate,
				value: params.startDate,
				done: function(value, date) {
					var selector = this.elem.selector.replace(/#/, "");
					var d1 = (new Date(value)).getTime();
					var d2 = (new Date(params.endDate)).getTime();
					if(d1 > d2) {
						var d = new Date(params.startDate);
						this.dateTime = {
							year: d.getFullYear(),
							month: d.getMonth(),
							date: d.getDate(),
							hours: 0,
							minutes: 0,
							seconds: 0,
						}
						document.getElementById(selector).value = params.startDate;
						alert("开始时间不能大于结束时间");
					} else {
						params.startDate = value;
						this.value = value;
						//end.config.max = date;
						//end.config.max.month = date.month;
					}
				}
			});

			end = laydate.render({
				elem: '#endDate',
				theme: '#00CCA2',
				btns: ['now', 'confirm'],
				//min: params.startDate,
				//max: params.endDate,
				value: params.endDate,
				done: function(value, date) {
					var selector = this.elem.selector.replace(/#/, "");
					var d1 = (new Date(value)).getTime();
					var d2 = (new Date(params.startDate)).getTime();
					if(d1 < d2) {
						var d = new Date(params.endDate);
						this.dateTime = {
							year: d.getFullYear(),
							month: d.getMonth(),
							date: d.getDate(),
							hours: 0,
							minutes: 0,
							seconds: 0,
						}

						document.getElementById(selector).value = params.endDate;
						alert("结束时间不能小于开始时间!");
					} else {
						params.endDate = value;
						this.value = value;
						//start.config.min = date;
						//start.config.min.month = date.month - 2;
					}
				}
			});
		});
	}

	//事件监听
	function bindEvent() {
		//查询
		$(".query-btn").off().on('click', function() {
			$(".param-in").each(function(i){
	    		var id = $(this).attr("data-id");
	    		console.log(id);
	    		var value = $(this).attr("data-val")||$(this).val();
	    		params[id] = value;
	    	})
			isFirst = true;
			getServiceData(1);
		});
		
		//重置
		$(".reset-btn").off().on('click', function() {
			$(".param-in").each(function(i){
	    		$(this).val('').attr('data-val','').text('全部');
	    		$(this).next().find(".select-option").removeClass("active");
	    		var id = $(this).attr("data-id");
	    		var value = $(this).attr("data-val")||$(this).val();
	    		params[id] = value;
	    	})
			start.config.value = params.startDate = CommonJs.formatDateChange(cdate, -1);
			end.config.value = params.endDate = CommonJs.formatDate(cdate);
			$("#startDate").val(params.startDate);
			$("#endDate").val(params.endDate);
			isFirst = true;
			getServiceData(1);
		});

		//选择
		$("tbody tr").off().on('click', function() {
			$(this).find("input").trigger("click");
		});

		//阻止事件冒泡
		$("tbody tr input").off().on('click', function(e) {
			e.stopPropagation();
		});
		
		CommonJs.selectOption();
	}

	//分页组件
	function renderLayPage(total) {
		CommonJs.getLayPage(total, params.limit, function(obj) {
			var currpage = obj.curr;
			if(!isFirst) {
				getServiceData(currpage);
			}
			isFirst = false;
		});
	}
	
	return {
		// 归档订单
		overOrder:function(){
			if(window.confirm("您确定要对工单进行归档吗？")){
				var idstr = [];
				$(".checkbox input:checked").each(function(i){
					idstr.push($(this).val()) ;
				})
				if(idstr.length <= 0){
					alert("请选择要操作的数据！");
					return false;
				}
				var str = idstr.join(",");
				//alert(str);
				JavaService.orderEditInfo({"str":str},
					function(result) {
						alert(result);
						isFirst = true;
						// 更新表格,默认第一页
						getServiceData(1);
					}
				);
				
			}
		},
		// 打开订单处理页面
	    orderEdit:function(){
	    	var idstr = [];
			$(".checkbox input:checked").each(function(i){
				idstr.push($(this).val()) ;
			})
			if(idstr.length != 1){
				alert("请选择1条数据！");
				return false;
			}
			var orderid = idstr.join(",");
			parent.layer.open({
		        type: 2,
		        title: "订单管理-订单处理",//是否显示标题
		        shadeClose: false, //是否点击遮罩关闭层
//		        shade: true,//是否显示遮罩
		        maxmin: false, //是否开启最大化最小化按钮
		        resize:true,//是否改变窗口大小
		        area : ['900px' , '500px'],//窗口大小
		        content: '../modules/order/orderEdit.jsp?orderid='+orderid
		    });
		},
		//刷新页面
		getPage:function(){
			//刷新pagenum
			isFirst = true;
			//调用取数服务
			getServiceData(1);
		}
	}

})();