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
				<span>上传图片</span>
				<div class="toolbar">
					
				</div>
			</div>
			<div class="dataTable">

				<form action="/mb-bg-ext-web/web/admin_article_image_create_submit" method="post"  enctype="multipart/form-data">
					
				<div class="two-line-input">
					<span class="label" style="width:50%">请选择图片</span>
					<input class="value" style="width:25%" type="file" name="image"></input>
					<input class="button" style="width:25%;margin-right:0px;float:left" type="submit" value="上传"></input>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>