<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Github404</title>
	<link rel="stylesheet" href="404.css">
</head>
<body>
	<div id="top">	
			<div id="bg">
				<img id="bg-pic" class ="1" src="bg.jpg" alt="">
			</div>
			<div id="front">
				<img id="error-pic" src="${pageContext.request.contextPath}/error/404.png" alt="404">
				<img id="cat-pic" src="${pageContext.request.contextPath}/error/cat.png" alt="cat">
				<img id="catshadow-pic" src="${pageContext.request.contextPath}/error/catshadow.png" alt="catshadow">
				<img id="bed-pic" src="${pageContext.request.contextPath}/error/bed.png" alt="bed">
				<img id="bedshadow-pic" src="${pageContext.request.contextPath}/error/bedshadow.png" alt="bedshadow">
				<img id="house1-pic" src="${pageContext.request.contextPath}/error/house1.png" alt="house1">
				<img id="house2-pic" src="${pageContext.request.contextPath}/error/house1.png" alt="house2">
			</div>
	
	</div>
	<div id="bottom">	
	</div>
	<script>
		var oBg = document.getElementById('bg-pic');
		var oError = document.getElementById('error-pic');
		var oCat = document.getElementById('cat-pic');
		var oCats = document.getElementById('catshadow-pic');
		var oBed = document.getElementById('bed-pic');
		var oBeds = document.getElementById('bedshadow-pic');
		var oHouse1 = document.getElementById('house1-pic');
		var oHouse2 = document.getElementById('house2-pic');
		
		var oCatLeft = oCat.offsetLeft,
			oCatsLeft = oCats.offsetLeft,
			oBedLeft = oBed.offsetLeft,
			oBedsLeft = oBeds.offsetLeft,
			oHouse1Left = oHouse1.offsetLeft,
			oHouse2Left = oHouse2.offsetLeft,
			oErrorLeft = oError.offsetLeft,	
			oBgTop = oBg.offsetTop,		
			oCatTop = oCat.offsetTop,
			oCatsTop = oCats.offsetTop,
			oBedTop = oBed.offsetTop,
			oBedsTop = oBeds.offsetTop,
			oHouse1Top = oHouse1.offsetTop,
			oHouse2Top = oHouse2.offsetTop,
			oErrorTop = oError.offsetTop;
		document.onmousemove = function(e) {
			e = e||window.event; 
			lineX = e.clientX/document.body.clientWidth*20;
			lineY = e.clientY/document.body.clientHeight*10;

			oCat.style.left = oCatLeft+(lineX)+'px';
			oCats.style.left = oCatsLeft+(lineX)+'px';
			oBed.style.left = oBedLeft+(lineX)+'px';
			oBeds.style.left = oBedsLeft+(lineX)+'px';
			oError.style.left = oErrorLeft+(lineX)+'px';
			oHouse1.style.left = oHouse1Left-(lineX)+'px';
			oHouse2.style.left = oHouse2Left-(lineX)+'px';
			oBg.style.top = oBgTop-(lineY)+'px';
			oCat.style.top = oCatTop+(lineY)+'px';
			oCats.style.top = oCatsTop+(lineY)+'px';
			oBed.style.top = oBedTop+(lineY)+'px';
			oBeds.style.top = oBedsTop+(lineY)+'px';
			oError.style.top = oErrorTop+(lineY)+'px';
			oHouse1.style.top = oHouse1Top-(lineY)+'px';
			oHouse2.style.top = oHouse2Top-(lineY)+'px';
		}

	
	</script>
	
</body>
</html>