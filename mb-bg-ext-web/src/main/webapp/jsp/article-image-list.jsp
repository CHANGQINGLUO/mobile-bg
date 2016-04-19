<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META   HTTP-EQUIV="pragma"   CONTENT="no-cache">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>中环博业务管理</title>
<link rel="stylesheet" type="text/css" href="/mb-bg-ext-web/styles/main.css" />
<script type="text/javascript">
	function submitForm(formName, fileName){
		
		document.forms[formName].fileName.value=fileName;
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
				<span>图片列表</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_article_image_create">添加</a>
				</div>
			</div>
			<div class="dataTable">
				<table>
					<thead>
						<tr>
							<td>文件名称</td>
							<td>引用路径</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
						<c:if test="${not empty fileList}">
							<c:forEach var="file" items="${fileList}">
							<tr class="odd">
								<td><a href="/mb-bg-ext-web/download/downloadArticleImage?name=${file.fileName}">${file.fileName}</a></td>
								<td>${file.referURL }</td>
								<td><a href="javascript:submitForm('deleteForm','${file.fileName}')">删除</a></td>
								
							</tr>
							</c:forEach>
						</c:if>
					<form name="deleteForm" action="/mb-bg-ext-web/web/admin_article_image_delete" method="post">
						<input type="hidden" name="fileName"/>
					</form>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>