<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>member/practice</title>

<script src="/resources/lib/jquery-3.3.1.js"></script>
<script>
	$(function(){
		
		
		$("#btnEach").click(function(e){
			
			eachTest01();
		});
		
	});
	
	
	function eachTest01(){
		
		var arr = [];
		var obj = {};
		obj.a = "a";
		obj.b = "b";
		obj.c = "c";
		obj.d = "d";
		obj.e = "e";
		
		$.each(obj, function(_idx, _obj){

			console.log(obj);
			
			if(_idx == "d"){
				return false;
			}
		})
		
		console.log("test");
		
	}
</script>

</head>
<body>
	<h1>practice.jsp</h1>
	<button id="btnEach" name="btnEach">EachTest</button>
</body>
</html>