<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout/online">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"
	rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<head>
<title>My Topics List</title>
</head>
<body>
	<main layout:fragment="content">
		<article class="container" style="padding: 3% 0 2%;">
			<header class="row">
				<blockquote class="flow-text left">
					<a href="<c:url value='forum' />" style="color: black">回討論區首頁</a>
				</blockquote>
				<blockquote class="flow-text right" style="color: black">
					我的文章數量：
					<c:out value="${MyTopicsTotalNum}" default="0"></c:out>
				</blockquote>
			</header>
			<section class="row">
				<div class="col s12">
					<table class="striped bordered centered"
						th:if="${topics.size() != 0}">
						<thead>
							<tr>
								<th>回覆數量</th>
								<th>類別</th>
								<th>標題</th>
								<th>發表時間</th>
								<th>Enter</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="star" var="aMyTopicBean"
								items="${mytitle_list}">
								<tr>
									<td>${aMyTopicBean.replyNum}</td>
									<td>${aMyTopicBean.category}</td>
									<td>${aMyTopicBean.title}</td>
									<td><fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm"
											value="${aMyTopicBean.postTime}" /></td>
									<td class="btn btn-floating pulse"><i
										class="material-icons"> <a
											href="<c:url value='mytopic?topicId=${aMyTopicBean.topicId}' />"
											style="color: white">arrow_forward</a></i></td>
								</tr>
							</c:forEach>
						</tbody>


					</table>

				</div>
			</section>
		</article>
	</main>
</body>
</html>