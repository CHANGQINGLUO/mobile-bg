<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
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
				<span>客户详情</span>
				<div class="toolbar"></div>
			</div>
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
					<span class="label">地址</span>
					<span class="value">${userDTO.address}</span>
				</div>
				<div class="two-line-input">
					<span class="label">客户代码</span>
					<span class="value">${userDTO.clientCode}</span>
				</div>
				 <div class="two-line-input">
					<span class="label">推荐人</span>
					<span class="value"><a href="javascript:submitForm('modifyForm','${advisorDTO.loginId}')">${advisorDTO.name}</a></span>
				</div>
				<form name="modifyForm" action="/mb-bg-ext-web/web/admin_advisor_modify" method="get">
					<input type="hidden" name="loginId"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>