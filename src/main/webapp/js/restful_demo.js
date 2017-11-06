$(function() {
	$(addMember).on("click",function(){ 
		$.ajax({
			url : "member" ,	// 处理的请求路径
			type : "post" ,		// 此处发送的是POST请求
			dataType : "json" ,	// 返回的数据类型为json类型
			data : {
				mid : 1001 ,
				name : "zhy" ,
				salary : 9888.12 ,
				hiredate : "1981-10-10"
			} ,
			success : function(data) {
				$(showDiv).append("<p>增加处理结果：" + data.flag + "</p>") ;
			} ,
			error : function(data) {
				$(showDiv).append("<p>对不起，出错啦！</p>") ;
			} 
		}) ;
	}) ;
})

$(function() {
	$(editMember).on("click",function(){ 
		$.ajax({
			url : "member?mid=1009&name=sql&salary=1000&hiredate=1993-09-08" ,	// 处理的请求路径
			type : "put" ,		// 此处发送的是POST请求
			dataType : "json" ,	// 返回的数据类型为json类型
			success : function(data) {
				$(showDiv).append("<p>增加处理结果：" + data.flag + "</p>") ;
			} ,
			error : function(data) {
				$(showDiv).append("<p>对不起，出错啦！</p>") ;
			} 
		}) ;
	}) ;
})

$(function() {
    $(removeMember).on("click",function(){
        $.ajax({
            url : "member/1001" ,	// 处理的请求路径
            type : "delete" ,		// 此处发送的是delete请求
            dataType : "json" ,	// 返回的数据类型为json类型
            success : function(data) {
                $(showDiv).append("<p>增加处理结果：" + data.flag + "</p>") ;
            } ,
            error : function(data) {
                $(showDiv).append("<p>对不起，出错啦！</p>") ;
            }
        }) ;
    }) ;
})

$(function() {
    $(getMember).on("click",function(){
        $.ajax({
            url : "member/1001" ,	// 处理的请求路径
            type : "get" ,		// 此处发送的是get请求
            dataType : "json" ,	// 返回的数据类型为json类型
            success : function(data) {
                $(showDiv).append("<p>增加处理结果：" + data.name + "|" + data.salary + "</p>") ;
            } ,
            error : function(data) {
                $(showDiv).append("<p>对不起，出错啦！</p>") ;
            }
        }) ;
    }) ;
})

$(function() {
    $(listMember).on("click",function(){
        $.ajax({
            url : "member/1001" ,	// 处理的请求路径
            type : "patch" ,		// 此处发送的是get请求
            dataType : "json" ,	// 返回的数据类型为json类型
            success : function(data) {
                $(showDiv).append("<p>增加处理结果：" + data.condition + "</p>") ;
                $(showDiv).append("<p>增加处理结果：" + data.memberCount + "</p>") ;
                for(var i = 0; i < data.allMembers.length; i++) {
                	$(showDiv).append("结果：" + data.allMembers.name);
                }
            } ,
            error : function(data) {
                $(showDiv).append("<p>对不起，出错啦！</p>") ;
            }
        }) ;
    }) ;
})


