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
				<span>查看订单</span>
				<div class="toolbar"></div>
			</div>
			<form action="/mb-bg-ext-web/web/admin_order_upload_report" method="post" enctype="multipart/form-data">
			<div class="dataTable">
				<div class="two-line-input">
					<span class="label">订单号</span>
					<span class="value">${orderDTO.orderNumber}</span>
				</div>
				<div class="two-line-input">
					<span class="label">订单创建日期</span>
					<span class="value">${orderDTO.createDateStr}</span>
				</div>
				<div class="two-line-input">
					<span class="label">订单状态</span>
					<span class="value">${orderDTO.statusDescription}</span>
				</div>
				<div class="two-line-input">
					<span class="label">产品名称</span>
					<span class="value">${orderDTO.productName}</span>
				</div>
				<div class="two-line-input">
					<span class="label">产品单价</span>
					<span class="value">${orderDTO.productPrice}</span>
				</div>
				<div class="two-line-input">
					<span class="label">产品数量</span>
					<span class="value">${orderDTO.count}</span>
				</div>
				<div class="two-line-input">
					<span class="label">订单总价</span>
					<span class="value">${orderDTO.amount}</span>
				</div>
				<div class="two-line-input">
					<span class="label">客户姓名</span>
					<span class="value">${orderDTO.customerName}</span>
				</div>
				<div class="two-line-input">
					<span class="label">客户地址</span>
					<span class="value">${orderDTO.mailAddress}</span>
				</div>
				<div class="two-line-input">
					<span class="label">客户电话</span>
					<span class="value">${orderDTO.phone}</span>
				</div>
				<div class="two-line-input">
					<span class="label">报告文件</span>
					<span class="value"><input type="file" name="report"></span>
				</div>
				<input type="hidden" name="orderNumber" value="${orderDTO.orderNumber}">
				<div class="two-line-input">
					<input class="button" type="submit" value="上传报告"></input>
				</div>
				 
			</div>
			</form>
		</div>
	</div>
</body>
</html>