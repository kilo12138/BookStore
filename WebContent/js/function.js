function change(img){
	
	img.src="getcode?"+new Date().getTime();
}

function FocusItem(obj){
	if($(obj).attr('name') != 'veryCode'){
	$(obj).next().next('span').html('').removeClass('error');}
	else{
		$(obj).next('span').html('').removeClass('error');
	}
}


var flag=0;//标记位，标记input里面输入值是否满足要求，

function CheckItem(obj){
	var msgBox = $(obj).next('span');
	
	switch($(obj).attr('name')){
	case "userid":
		if(obj.value == ""){
			msgBox.html("用户名不能为空");
			msgBox.addClass("error");
			
		}else{
			var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();

			$.get(url,function(data){

				if(data == "false"){
					msgBox.html("用户名不能使用");
					msgBox.addClass("error");
					
				}
				else{
					msgBox.html('').removeClass('error');
				}
			});
		}
		break;
	case "userpaw":
		if(obj.value == ""){
			msgBox.html("密码不能为空");
			msgBox.addClass("error");
			
		}else{
			msgBox.html('').removeClass('error');
		}
		break;
	case "repaw":
		if(obj.value == ""){
			msgBox.html("确认密码不能为空");
			msgBox.addClass("error");
			
		}else if($(obj).val() != $('input[name="userpaw"]').val()){
			msgBox.html("两次密码不一致");
			msgBox.addClass("error");
			
		}else{
			msgBox.html('').removeClass('error');
		}
		break;
	case "veryCode":
		var yzm = $(obj).next().next('span');
		if(obj.value == ""){
			yzm.html("验证码不能为空");
			yzm.next().addClass('error');
			
		}else{
			var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
			
			$.get(url,function(numdata){
				if(numdata == "false"){
					yzm.html('验证码输入有误');
					yzm.addClass('error');
					
				}
				else{
					yzm.html('').removeClass('error');
				}
			});
		}
		break;
	}
}




function checkFrom(frm){
	var els = frm.getElementsByName('input');

	for(var i=0;i<els.length;i++){
		if(els[i] != null){
			if(els[i].getAttribute("onblur")){
				CheckItem(els[i]);
			}
		}
		
	}

}