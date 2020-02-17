//JS工具类

function EnumPara(enumType, enumKey) {
	
	var enumValue=''
		
	if (enumType=="ENUM_IsFault"){
		if(enumKey){
			enumValue='是';
		}
		else{
			enumValue='否'	
		}
		return enumValue;
	}		
		
	if (enumType=="ENUM_FaultGrade"){		
		switch(enumKey){
		case 1: 
			enumValue='1级';
			 break;	
		case 2: 
			enumValue='2级';
			 break;	
		case 3: 
			enumValue='3级';
			 break;				 
		default: 
			enumValue='undefine';
		}
	}

	if (enumType=="ENUM_FaultType"){		
		switch(enumKey){
		case 1: 
			enumValue='系统故障';
			 break;	
		case 2: 
			enumValue='业务故障';
			 break;				 
		default: 
			enumValue='undefine';
			break;
		}
	}	

	if (enumType=="ENUM_ProcessSts"){		
		switch(enumKey){
		case 1: 
			enumValue='待处理';
			 break;	
		case 2: 
			enumValue='处理中';
			 break;	
		case 2: 
			enumValue='已完成';
			 break;					 
		default: 
			enumValue='undefine';
		}
	}	
	return enumValue	
}

function timeStamp2Date(timestamp){
	if (timestamp !=null){ 
		var datetime = new Date();
		datetime.setTime(timestamp);
		
		var year = datetime.getFullYear();
		var month = datetime.getMonth()+1;
		var date = datetime.getDate();
		var hour = datetime.getHours();
		var minute = datetime.getMinutes();
		var second = datetime.getSeconds();
		var msecond = datetime.getMilliseconds();
		return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
	}
	else
		{
			return "null";
		}
}
