<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>中环博业务管理</title>
<link rel="stylesheet" type="text/css"
	href="/mb-bg-ext-web/styles/main.css" />
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
				<span>代理商详情</span>
				<div class="toolbar"></div>
			</div>
			<form action="/mb-bg-ext-web/web/admin_order_upload_report" method="post" enctype="multipart/form-data">
			<div class="dataTable">
				<div class="two-line-input">
					<span class="label">姓名</span>
					<span class="value">${userDTO.name}</span>
				</div>
				<div class="two-line-input">
					<span class="label">电话号码</span>
					<span class="value">${userDTO.hp}</span>
				</div>
				<div class="two-line-input">
					<span class="label">电子邮箱</span>
					<span class="value">${userDTO.email}</span>
				</div>
				<div class="two-line-input">
					<span class="label">公司</span>
					<span class="value">${userDTO.company}</span>
				</div>
				<div class="two-line-input">
					<span class="label">地址</span>
					<span class="value">${userDTO.address}</span>
				</div>
				<div class="two-line-input">
					<span class="label">客户代码</span>
					<span class="value">${userDTO.clientCode}</span>
				</div>
				 
			</div>
			</form>
			<div class="titleBar">
				<span>客户列表</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_article_create"></a>
				</div>
			</div>
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
					
						<c:if test="${not empty customerList}">
							<c:forEach var="customer" items="${customerList}">
							<tr class="odd">
								<td><a href="javascript:submitForm('modifyForm','${customer.loginId}')">${customer.name}</a></td>
								<td>${customer.hp}</td>
								<td>${customer.email}</td>
								<td>${customer.clientCode}</td>							
							</tr>
							</c:forEach>
						</c:if>
					<form name="modifyForm" action="/mb-bg-ext-web/web/admin_customer_modify" method="get">
						<input type="hidden" name="loginId"/>
					</form>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>