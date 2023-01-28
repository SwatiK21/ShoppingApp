<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.product.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List<Product> productsList = (ArrayList) request.getAttribute("productList");
	%>
	<h2>
		Showing
		<%=productsList.size()%>
		results
	</h2>

	<table>



		<%
			for (Product p : productsList) {
		%>
		<tr>
			<td><img src="<%=p.getImage()%>" alt="<%=p.getName()%>"
				width="200"> <br> <%=p.getName()%> <br> USD <%=p.getPrice()%>
				<br> <input type="number" name="qty"> <input
				type="button" value="Add To Cart"></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>