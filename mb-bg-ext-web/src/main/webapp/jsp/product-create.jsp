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
		<form action="/mb-bg-ext-web/web/admin_product_create_submit" method="post"  enctype="multipart/form-data">
		
			<div class="contentContainer">
			<div style="font-size: 30px">
				${message}
			</div>
				<div class="titleBar">
					<span>创建产品</span>
					<div class="toolbar"></div>
				</div>
				<div class="dataTable">
					<div class="two-line-input">
						<span class="label">类型</span>
						<select name="type" class="value">
							<option value="F">家庭</option>
							<option value="A">别墅</option>
							<option value="0">办公室</option>
							<option value="C">其他</option>
						</select>
					</div>
					<div class="two-line-input">
						<span class="label">产品名称</span><input name="name" class="value"
							type="text" placeholder=产品名称></input>
					</div>
					<div class="two-line-input">
						<span class="label">点位数</span><input name="points" class="value"
							type="text" placeholder=点位数></input>
					</div>
					<div class="two-line-input">
						<span class="label">价格</span><input name="price" class="value"
							type="text" placeholder=价格></input>
					</div>
					<div class="two-line-textarea">
						<span class="label">产品描述(如需引用图片, 请使用图片查询功能的引用路径)</span>
						<textarea name="description" class="article-content" placeholder=描述></textarea>
					</div>
					<div class="two-line-input">
						<span class="label">产品图片(png格式, 80x80)</span>
						<input type="file" name="image" class="value"></input>
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