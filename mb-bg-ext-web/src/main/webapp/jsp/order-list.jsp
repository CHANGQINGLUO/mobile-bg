<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META   HTTP-EQUIV="pragma"   CONTENT="no-cache">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>中环博业务管理</title>
<link rel="stylesheet" type="text/css" href="/mb-bg-ext-web/styles/main.css" />
<script type="text/javascript">
	function submitForm(formName, orderNumber){
		
		document.forms[formName].orderNumber.value=orderNumber;
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
				<span>订单列表</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_article_create"></a>
				</div>
			</div>
			<form action="/mb-bg-ext-web/web/admin_list_orders_for_user" method="get">
			<div>
			客户登录ID(手机号码):&nbsp&nbsp<input type="text" name="loginId"/>&nbsp&nbsp&nbsp&nbsp<input type="submit" value="查询"/>
			</div>
			</form>
			<div class="dataTable">
				<table>
					<thead>
						<tr>
							<td>订单号</td>
							<td>客户姓名</td>
							<!-- <td>客户地址</td>  -->
							<td>创建日期</td>
							<td>状态</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
						<c:if test="${not empty orderList}">
							<c:forEach var="order" items="${orderList}">
							<tr class="odd">
								<td><a href="javascript:submitForm('modifyForm','${order.orderNumber}')">${order.orderNumber}</a></td>
								<td>${order.customerName}</td>
								<!-- <td>${order.mailAddress}</td> -->
								<td>${order.createDateStr}</td>
								<td>${order.statusDescription}</td>
								<td>
								<c:if test="${order.status eq 'D'}">
									<a href="" onclick="javascript:window.open('/mb-bg-ext-web/download/downloadReport?orderNumber=${order.orderNumber}')">查看报告</a>
								</c:if></td>							
							</tr>
							</c:forEach>
						</c:if>
					<form name="modifyForm" action="/mb-bg-ext-web/web/admin_order_modify" method="post">
						<input type="hidden" name="orderNumber"/>
					</form>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>