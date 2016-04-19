<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META   HTTP-EQUIV="pragma"   CONTENT="no-cache">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>中环博业务管理</title>
<link rel="stylesheet" type="text/css" href="/mb-bg-ext-web/styles/main.css" />
<script type="text/javascript">
	function submitForm(formName, uuid){
		
		document.forms[formName].uuid.value=uuid;
		document.forms[formName].submit();
	}
</script>
</head>
<body>

	<div class="pageContainer">
	<div class="banner"><a href="/mb-bg-ext-web/web/admin_logout">退出登录</a></div>
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="contentContainer">
			<div class="titleBar">
				<span>文章列表</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_article_create">添加</a>
				</div>
			</div>
			<div class="dataTable">
				<table>
					<thead>
						<tr>
							<td>文章标题</td>
							<td>创建时间</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
						<c:if test="${not empty articleList}">
							<c:forEach var="article" items="${articleList}">
							<tr class="odd">
								<td><a href="javascript:submitForm('modifyForm','${article.id}')">${article.title}</a></td>
								<td>${article.creationDate}</td>
								<td><a href="javascript:submitForm('deleteForm','${article.id}')">删除</a></td>
								
							</tr>
							</c:forEach>
						</c:if>
					<form name="deleteForm" action="/mb-bg-ext-web/web/admin_article_delete" method="post">
						<input type="hidden" name="uuid"/>
					</form>
					<form name="modifyForm" action="/mb-bg-ext-web/web/admin_article_modify" method="post">
						<input type="hidden" name="uuid"/>
					</form>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>