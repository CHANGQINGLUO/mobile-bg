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
		<div style="font-size: 30px">
				${message}
			</div>
			<div class="titleBar">
				<span>创建产品</span>
				<div class="toolbar"></div>
			</div>
			<form action="/mb-bg-ext-web/web/admin_product_modify_submit" method="post" enctype="multipart/form-data">
			<div class="dataTable">
				<div class="two-line-input">
					<span class="label">产品类型</span>
						<select name="type" class="value">
							<option value="F">家庭</option>
							<option value="A">别墅</option>
							<option value="O">办公室</option>
							<option value="C">其他</option>
						</select>
				</div>
				<script type="text/javascript">
					if("${productDTO.type}"=='F') 
						document.getElementsByName('type')[0].options[0].selected=true;
					else if("${productDTO.type}"=='A') 
						document.getElementsByName('type')[0].options[1].selected=true;
					else if("${productDTO.type}"=='O') 
						document.getElementsByName('type')[0].options[2].selected=true;
					else if("${productDTO.type}"=='C') 
						document.getElementsByName('type')[0].options[3].selected=true;
				</script>

				<div class="two-line-input">
					<span class="label">产品名称</span><input class="value" type="text" name="name" 
						value="${productDTO.name}" placeholder=产品名称></input>
				</div>
				<div class="two-line-input">
					<span class="label">点位数</span><input class="value" type="text" name="points" 
						value="${productDTO.points}" placeholder=点位数></input>
				</div>
				<div class="two-line-input">
					<span class="label">产品价格(元)</span><input class="value" type="text" name="price" 
						value="${productDTO.price}" placeholder=产品价格></input>
				</div>
				<div class="two-line-input">
					<span class="label">预付金额(元)</span><input class="value" type="text" name="prePrice" 
						value="${productDTO.prePrice}" placeholder=预付金额></input>
				</div>
				<div class="two-line-textarea">
					<span class="label">产品描述(如需引用图片, 请使用图片查询功能的引用路径)</span>
					<textarea class="article-content" name="description" placeholder=内容>${productDTO.description}</textarea>
				</div>
				<div class="two-line-input">
					<span class="label">产品图片(png格式, 80x80)</span><input class="value" type="file" name="image"></input>
				</div>
				<div  class="two-line-input" style="height:80px">
  					<span class="label"></span><iframe src="/mb-bg-ext-web/download/downloadProductImage?id=${productDTO.uuid}" width="80px" height="80px" style="float:left"></iframe>
				</div>
				<input type="hidden" name="uuid" value="${productDTO.uuid}">
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