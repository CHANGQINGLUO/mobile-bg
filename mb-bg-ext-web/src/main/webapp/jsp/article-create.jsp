<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<title>中环博业务管理</title>
<link rel="stylesheet" type="text/css"
	href="/mb-bg-ext-web/styles/main.css" />
</head>
<body>

	<div class="pageContainer">
	<div class="banner"><a href="/mb-bg-ext-web/web/admin_logout">退出登录</a></div>
		<jsp:include page="menu.jsp"></jsp:include>
		<form action="/mb-bg-ext-web/web/admin_article_create_submit" method="post">
		
			<div class="contentContainer">
				<div class="titleBar">
					<span>创建文章</span>
					<div class="toolbar"></div>
				</div>
				<div class="dataTable">
					<div class="two-line-input">
						<span class="label">类型</span>
						<select name="type" class="value">
							<option value="1">环保知识</option>
							<option value="2">健康知识</option>
							<option value="3">装修知识</option>
							<option value="4">环境检测</option>
							<option value="5">公司新闻</option>
						</select>
					</div>
					<!-- 
					<div class="two-line-input">
						<span class="label">是否推荐</span>
						<input name="isRecommended" class="value" value="1" style="width: 4%"
							type="checkbox"></input>
					</div>
					 -->
					<div class="two-line-input">
						<span class="label">标题</span><input name="title" class="value"
							type="text" placeholder=标题></input>
					</div>
					<div class="two-line-textarea">
						<span class="label">内容</span>
						<textarea name="content" class="article-content" placeholder=内容></textarea>
					</div>
					<div class="two-line-input">
						<!-- <input class="button" type="button" value="返回"></input> --> <input
							class="button" type="submit" value="提交"></input>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>