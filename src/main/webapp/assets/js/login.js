function loadCode(){
	$("#verifycode").attr("src","verify.htm?common=login&_=" + Math.random());
}

$(function(){
		loadCode();
})
