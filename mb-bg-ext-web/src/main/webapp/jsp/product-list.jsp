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
				<span>产品列表</span>
				<div class="toolbar">
					<a href="/mb-bg-ext-web/web/admin_product_create">添加</a>
				</div>
			</div>
			<div class="dataTable">
				<table>
					<thead>
						<tr>
							<td>产品类型</td>
							<td>产品名称</td>
							<td>点位数</td>
							<td>产品价格</td>
							<td>创建时间</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
						<c:if test="${not empty fProductList}">
							<c:forEach var="product" items="${fProductList}">
							<tr class="odd">
								
								<td>
								<c:if test="${product.type=='F'}">
									家庭
								</c:if>
								<c:if test="${product.type=='A'}">
									别墅
								</c:if>
								<c:if test="${product.type=='O'}">
									办公室
								</c:if>
								<c:if test="${product.type=='C'}">
									其他
								</c:if>
								
								</td>
								<td><a href="javascript:submitForm('modifyForm','${product.uuid}')">${product.name}</a></td>
								<td>${product.points}</a></td>
								<td>${product.price}元</td>
								<td>${product.createDateStr}</td>
								<td><a href="javascript:submitForm('deleteForm','${product.uuid}')">删除</a></td>
								
							</tr>
							</c:forEach>
							</c:if>
							<c:if test="${not empty aProductList}">
							<c:forEach var="product" items="${aProductList}">
							<tr class="odd">
								
								<td>
								<c:if test="${product.type=='F'}">
									家庭
								</c:if>
								<c:if test="${product.type=='A'}">
									别墅
								</c:if>
								<c:if test="${product.type=='O'}">
									办公室
								</c:if>
								<c:if test="${product.type=='C'}">
									其他
								</c:if>
								
								</td>
								<td><a href="javascript:submitForm('modifyForm','${product.uuid}')">${product.name}</a></td>
								<td>${product.points}</a></td>
								<td>${product.price}元</td>
								<td>${product.createDateStr}</td>
								<td><a href="javascript:submitForm('deleteForm','${product.uuid}')">删除</a></td>
								
							</tr>
							</c:forEach>
							</c:if>
							<c:if test="${not empty oProductList}">
							<c:forEach var="product" items="${oProductList}">
							<tr class="odd">
								
								<td>
								<c:if test="${product.type=='F'}">
									家庭
								</c:if>
								<c:if test="${product.type=='A'}">
									别墅
								</c:if>
								<c:if test="${product.type=='O'}">
									办公室
								</c:if>
								<c:if test="${product.type=='C'}">
									其他
								</c:if>
								
								</td>
								<td><a href="javascript:submitForm('modifyForm','${product.uuid}')">${product.name}</a></td>
								<td>${product.points}</a></td>
								<td>${product.price}元</td>
								<td>${product.createDateStr}</td>
								<td><a href="javascript:submitForm('deleteForm','${product.uuid}')">删除</a></td>
								
							</tr>
							</c:forEach>
							</c:if>
							<c:if test="${not empty cProductList}">
							<c:forEach var="product" items="${cProductList}">
							<tr class="odd">
								
								<td>
								<c:if test="${product.type=='F'}">
									家庭
								</c:if>
								<c:if test="${product.type=='A'}">
									别墅
								</c:if>
								<c:if test="${product.type=='O'}">
									办公室
								</c:if>
								<c:if test="${product.type=='C'}">
									其他
								</c:if>
								
								</td>
								<td><a href="javascript:submitForm('modifyForm','${product.uuid}')">${product.name}</a></td>
								<td>${product.points}</a></td>
								<td>${product.price}元</td>
								<td>${product.createDateStr}</td>
								<td><a href="javascript:submitForm('deleteForm','${product.uuid}')">删除</a></td>
								
							</tr>
							</c:forEach>
						</c:if>
					<form name="deleteForm" action="/mb-bg-ext-web/web/admin_product_delete" method="post">
						<input type="hidden" name="uuid"/>
					</form>
					<form name="modifyForm" action="/mb-bg-ext-web/web/admin_product_modify" method="post">
						<input type="hidden" name="uuid"/>
					</form>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>