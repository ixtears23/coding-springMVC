<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<title>member>index</title>

<script src="/resources/lib/jquery-3.3.1.js"></script>
<script>

	$(function() {
		
		$('body')
		.append($('<a>')
// 				.hide()
					.attr({ id: "pdf", href: "/resources/doc/중소기업_취업자_소득세_감면.pdf", target: "_blank" })
						.append("다운로드")
		);
		
		$("#btn").click(function(e){
			e.preventDefault();
			$("#pdf")[0].click();
		})
	})
	


</script>

</head>
<body>
	<h1>index</h1>
	<div>
		<a href="/resources/doc/성인발레 강의계획서.hwp" target="_blank">HWP</a>
		<a href="/resources/doc/중소기업_취업자_소득세_감면.pdf" target="_blank">PDF</a>
		<button id="btn">버튼</button>
	</div>
	
</body>
</html>