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
		<div style="font-size: 30px">
				${message}
			</div>
			<div class="titleBar">
				<span>转帐给代理商</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_article_create"></a>
				</div>
			</div>
			
			
			
			
			<div class="dataTable">
				<form action="/mb-bg-ext-web/web/admin_create_transfer" method="get">
				<div class="two-line-input">
					<span class="label">客户登录ID(手机号码)</span>
					<span class="value"><input type="text" name="loginId" style="height: 100%"/>&nbsp&nbsp&nbsp&nbsp<input  style="height: 100%" type="submit" value="查询"/></span>
				</div>
				</form>
				<div class="two-line-input">
					<span class="label">姓名</span>
					<span class="value">${userDTO.name}</span>
				</div>
				<div class="two-line-input">
					<span class="label">电话号码</span>
					<span class="value">${userDTO.hp}</span>
				</div>
				<div class="two-line-input">
					<span class="label">客户代码</span>
					<span class="value">${userDTO.clientCode}</span>
				</div>
				<form action="/mb-bg-ext-web/web/admin_create_transfer_submit" method="post">
				<input type="hidden" name="customerLoginId" value="${userDTO.loginId}"/>
				<div class="two-line-input">
					<span class="label">转帐金额</span>
					<span class="value"><input type="text" name="amount" style="height: 100%"></input></span>
				</div>
				<div class="two-line-input">
					<input class="button" type="submit" value="提交"></input>
				</div>
				</form>
			</div>
			
	</div>
</body>
</html>