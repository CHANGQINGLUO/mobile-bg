<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META   HTTP-EQUIV="pragma"   CONTENT="no-cache">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>中环博业务管理</title>
<link rel="stylesheet" type="text/css" href="/mb-bg-ext-web/styles/main.css" />
<script type="text/javascript">
	function submitForm(formName, loginId){
		
		document.forms[formName].loginId.value=loginId;
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
				<span>代理商列表</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_article_create"></a>
				</div>
			</div>
			<form action="/mb-bg-ext-web/web/admin_advisor_modify" method="get">
			<div>
			代理商登录ID(手机号码):&nbsp&nbsp<input type="text" name="loginId"/>&nbsp&nbsp&nbsp&nbsp<input type="submit" value="查询"/>
			</div>
			</form>
			<div class="dataTable">
				<table>
					<thead>
						<tr>
							<td>姓名</td>
							<td>电话</td>
							<td>邮箱</td>
							<td>8位客户代码</td>
						</tr>
					</thead>
					<tbody>
					
						<c:if test="${not empty advisorList}">
							<c:forEach var="advisor" items="${advisorList}">
							<tr class="odd">
								<td><a href="javascript:submitForm('modifyForm','${advisor.loginId}')">${advisor.name}</a></td>
								<td>${advisor.hp}</td>
								<td>${advisor.email}</td>
								<td>${advisor.clientCode}</td>							
							</tr>
							</c:forEach>
						</c:if>
					<form name="modifyForm" action="/mb-bg-ext-web/web/admin_advisor_modify" method="get">
						<input type="hidden" name="loginId"/>
					</form>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>