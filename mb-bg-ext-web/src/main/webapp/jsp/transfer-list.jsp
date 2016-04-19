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
				<span>转帐记录</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_article_create"></a>
				</div>
			</div>
			<form action="/mb-bg-ext-web/web/admin_list_transfers" method="get">
			<div>
			客户登录ID(手机号码):&nbsp&nbsp<input type="text" name="loginId"/>&nbsp&nbsp&nbsp&nbsp<input type="submit" value="查询"/>
			</div>
			</form>
			<div class="dataTable">
				<table>
					<thead>
						<tr>
							<td>客户姓名</td>
							<td>转帐日期</td>
							<td>转帐金额</td>
						</tr>
					</thead>
					<tbody>
					
						<c:if test="${not empty transferList}">
							<c:forEach var="transfer" items="${transferList}">
							<tr class="odd">
								<td>${transfer.toName}</td>
								<td>${transfer.transferDateStr}</td>
								<td>${transfer.amount}</td>
							</tr>
							</c:forEach>
						</c:if>
					<form name="modifyForm" action="/mb-bg-ext-web/web/admin_order_modify" method="post">
						<input type="hidden" name="uuid"/>
					</form>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>