<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>RM Mobility</title>
</head>
<body>
	<table border="1">

		<tr>
			<th colspan="1">Version</th>
			<th colspan="1">Host</th>
			<th colspan="1">Port</th>
			<th colspan="1">Access Time</th>
			<th colspan="1">Status</th>
		</tr>
		<c:if test="${not empty connDetails}">
			<c:forEach var="conn" items="${connDetails}">
				<tr>
					<td colspan="1"><c:out value="${conn.version}"></c:out></td>
					<td colspan="1"><c:out value="${conn.hostName}"></c:out></td>
					<td colspan="1"><c:out value="${conn.port}"></c:out></td>
					<td colspan="1"><c:out value="${conn.accessTime}"></c:out></td>
					<td colspan="1"><c:out value="${conn.message}"></c:out></td>

				</tr>
			</c:forEach>
		</c:if>
		
	</table>
</body>
</html>
