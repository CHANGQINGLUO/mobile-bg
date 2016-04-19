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
		<div class="contentContainer">
			<div class="titleBar">
				<span>创建文章</span>
				<div class="toolbar"></div>
			</div>
			<form action="/mb-bg-ext-web/web/admin_article_modify_submit" method="post">
			<div class="dataTable">
				<div class="two-line-input">
					<span class="label">文章类型</span>
						<select name="type" class="value">
							<option value="1">环保知识</option>
							<option value="2">健康知识</option>
							<option value="3">装修知识</option>
							<option value="4">环境检测</option>
							<option value="5">公司新闻</option>
						</select>
				</div>
				<script type="text/javascript">
					if("${type}"=='1') 
						document.getElementsByName('type')[0].options[0].selected=true;
					else if("${type}"=='2') 
						document.getElementsByName('type')[0].options[1].selected=true;
					else if("${type}"=='3') 
						document.getElementsByName('type')[0].options[2].selected=true;
					else if("${type}"=='4') 
						document.getElementsByName('type')[0].options[3].selected=true;
					else if("${type}"=='5') 
						document.getElementsByName('type')[0].options[4].selected=true;
				</script>
				<!-- 
				<div class="two-line-input">
					<span class="label">是否推荐</span>
					<input class="value"  style="width: 4%" type="checkbox" name="isRecommended" 
						value="1"></input>
				</div>
				 -->
				<script type="text/javascript">
					if("${isRecommended}"=='1') 
						document.getElementsByName("isRecommended")[0].checked=true;
				</script>
				<div class="two-line-input">
					<span class="label">标题</span><input class="value" type="text" name="title" 
						value="${title}" placeholder=标题></input>
				</div>
				<div class="two-line-textarea">
					<span class="label">内容</span>
					<textarea class="article-content" name="content" placeholder=内容>${content}</textarea>
				</div>

				<input type="hidden" name="uuid" value="${uuid}">
				<div class="two-line-input">
					<!-- <input class="button" type="button" value="返回"></input> -->
					<input class="button" type="submit" value="提交"></input>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>