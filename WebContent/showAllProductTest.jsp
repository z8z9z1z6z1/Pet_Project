<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<c:url value='/js/jquery-1.12.2.min.js' />" ></script>
<script type="text/javascript">
$(document).ready(function () {
	 $("#test").click(function(){
// 		 alert("123");

	$.ajax({
	method: "GET",
	url:"<c:url value='/allProductNoImage'/>", //請求的url地址
	dataType : "json", //返回格式為json
	async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
	success:function(response){
// 		var a= JSON.parse(response);
		console.log(response[1].bean);
		console.log(response[1].imageData);
// 			$("#test2").html("<img src="+response[1].imageData +"/>");

// 		for (var i = 0 ; i < response.length;i++){
// // 			alert("name=" + response[i].name + "price=" +response[i].price); 
// 			}
	}
	});
	

	
	});

});	 


// window.onload=function(){
// 	var test =document.getElementById("test");
// 	var test2 =document.getElementById("test2");
// 	test.onclick=function(){
// 		var xhr = new XMLHttpRequest();
// 		xhr.open("GET", "<c:url value='/allProductNoImage' />", true);
// 		xhr.send();
// 		xhr.onreadystatechange = function() {
// 			if (xhr.readyState == 4 && xhr.status == 200) {
// 				var content ="123";
// 				console.log(content);
// 				var Product =JSON.parse(xhr.responseText);
// 				console.log(Product)
				
// 			}
// 		}
// }
// }
</script>
<body>
<div align="center">
<h2>查看商品</h2>
<input type="submit" value="Submit" id="test"/>
<div id='test2'>2</div>
</div>
</body>
</html>