<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META   HTTP-EQUIV="pragma"   CONTENT="no-cache">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>中环博业务管理</title>
<link rel="stylesheet" type="text/css" href="/mb-bg-ext-web/styles/main.css" />
</head>
<body>

	<div class="pageContainer">
	<div class="banner"><a href="/mb-bg-ext-web/web/admin_logout">退出登录</a></div>
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="contentContainer">
			<div class="titleBar">
				<span>首页轮滚图设置</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_article_create"></a>
				</div>
			</div>
			
			<div class="dataTable">
				<form action="/mb-bg-ext-web/web/admin_upload_image?id=1" method="POST"  enctype="multipart/form-data">
				<div class="two-line-textarea" style="height: 100px">
					<span class="label" style="width:50%"><a href="javascript:void(0)" onclick="javascript:window.open('/mb-bg-ext-web/download/downloadMainImage?id=1')">第一张图片(分辨率320x200, png格式)</a></span>
					<input class="value" style="width:25%" type="file" name="image"></input>
					<input class="button" style="width:25%;margin-right:0px;float:left" type="submit" value="提交"></input>
				</div>
				</form>
				<div style="text-align: left">
  					<iframe src="/mb-bg-ext-web/download/downloadMainImage?id=1" width="320px" height="200px"></iframe>
				</div>
				<form action="/mb-bg-ext-web/web/admin_upload_image?id=2" method="POST"  enctype="multipart/form-data">
				<div class="two-line-textarea" style="height: 100px">
					<span class="label" style="width:50%"><a href="javascript:void(0)" onclick="javascript:window.open('/mb-bg-ext-web/download/downloadMainImage?id=2')">第二张图片(分辨率320x200, png格式)</a></span>
					<input class="value" style="width:25%" type="file" name="image"></input>
					<input class="button" style="width:25%;margin-right:0px;float:left" type="submit" value="提交"></input>
				</div>
				</form>
				<div style="text-align: left">
  					<iframe src="/mb-bg-ext-web/download/downloadMainImage?id=2" width="320px" height="200px"></iframe>
				</div>
				<form action="/mb-bg-ext-web/web/admin_upload_image?id=3" method="POST"  enctype="multipart/form-data">
				<div class="two-line-textarea" style="height: 100px">
					<span class="label" style="width:50%"><a href="javascript:void(0)" onclick="javascript:window.open('/mb-bg-ext-web/download/downloadMainImage?id=3')">第三张图片(分辨率320x200, png格式)</a></span>
					<input class="value" style="width:25%" type="file" name="image"></input>
					<input class="button" style="width:25%;margin-right:0px;float:left" type="submit" value="提交"></input>
				</div>
				</form>
				<div style="text-align: left">
  					<iframe src="/mb-bg-ext-web/download/downloadMainImage?id=3" width="320px" height="200px"></iframe>
				</div>
			</div>
		</div>
	</div>
</body>
</html>