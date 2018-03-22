<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<title>member>index</title>

<script src="/resources/lib/jquery-3.3.1.js"></script>
<script>

	

	$(function() {
		
		test().done(function(name){
			alert(name);
		})
		
		$('body')
		.append($('<a>')
// 				.hide()
					.attr({ id: "pdf", href: "/resources/doc/중소기업_취업자_소득세_감면.pdf", target: "_blank" })
						.append("다운로드")
		);
		
		$("#btn").click(function(e){
			e.preventDefault();
			$("#pdf")[0].click();
		});
		
		$("#btnDefferd").click(function(e){
			e.preventDefault();
			
			ajax().done(function(data){
				console.log("success");
				console.log(data);
			}).fail(function(data){
				console.log("fail");
				console.log(data);
			});
			
			ajax2().done(function(data){
				console.log("success");
				console.log(data);
			}).fail(function(data){
				console.log("fail");
				console.log(data);
			});
		})
	})
	
	var dfd = $.Deferred();
	
	function ajax(){
		
		$.ajax({
			  method: "POST",
			  url: "<c:url value='/web/memberRest/getMember'/>",
			  data: { name: "John", location: "Boston" },
			  success: function(data){
				  var res = {result : 'success'};
				  dfd.resolve($.extend(res, data));
			  }
			});
		
		$.ajax({
			  method: "POST",
			  url: "<c:url value='/web/memberRest/getMemberSecond'/>",
			  data: { name: "John", location: "Boston" },
			  success: function(data){
				  var rej = {result : 'fail'};
				  dfd.reject($.extend(rej, data));
			  }
			});
		return dfd.promise();
	}
	
	function ajax2(){
		
		$.ajax({
			  method: "POST",
			  url: "<c:url value='/web/memberRest/getMember'/>",
			  data: { name: "John", location: "Boston" },
			  success: function(data){
				  var res = {result : 'success'};
				  dfd.resolve($.extend(res, data));
			  }
			});
		
		$.ajax({
			  method: "POST",
			  url: "<c:url value='/web/memberRest/getMemberSecond'/>",
			  data: { name: "John", location: "Boston" },
			  success: function(data){
				  var rej = {result : 'fail'};
				  dfd.reject($.extend(rej, data));
			  }
			});
		return dfd.promise();
	}
	
	function test(){
		
		dfd.promise();
		dfd.resolve( "John" );
	}
	


</script>

</head>
<body>
	<h1>index</h1>
	<div>
		<a href="/resources/doc/성인발레 강의계획서.hwp" target="_blank">HWP</a>
		<a href="/resources/doc/중소기업_취업자_소득세_감면.pdf" target="_blank">PDF</a>
		<button id="btn">버튼</button>
		<button id="btnDefferd">defferd Test</button>
	</div>
	
</body>
</html>