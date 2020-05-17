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
	url:"<c:url value='/allProductWithImage'/>", //請求的url地址
	dataType : "json", //返回格式為json
	async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
// 	contentType: 'application/json; charset=UTF-8',//好像是post方法才要
	success:function(response){
// 		var a= JSON.parse(response);
		console.log(response[0].imageData);
		$("#test2").empty();
		var $table = $('<table border="1">')
		.appendTo($('#test2'))
		.append("<tr><th>編號</th><th>名字</th><th>價格</th><th>描述</th><th>檔案名字</th><th>圖片</th></tr>");
		$("#test2").append($table)
		$.each(response,
			function(index,element){
			$('<tr>').appendTo($table)
			.append($('<td align="center">').text(element.bean.productId))
			.append($('<td>').text(element.bean.name))
			.append($('<td align="right">').text(element.bean.price))
			.append($('<td>').text(element.bean.descriptrion))
			.append($('<td>').text(element.bean.fileName))
			.append("<td><img src='" + element.imageData + " ' '></td>");
		})
		
// 		$("#test2").html("<img src="+response[1].imageData +" />");
// 			$("#test2").html("<img src="+response[1].imageData +"/>");

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
// 				console.log(Product[0])
				
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