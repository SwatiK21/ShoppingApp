<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@page import="com.product.Product"%>
<%@page import="com.order.OrderItem"%>
<%@page import="com.order.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% List<Order> ordersList = (ArrayList) request.getAttribute("ordersList"); %>
 	<h2> Hello Swati</h2>
 	
 		Here are your orders :
 		<br> 
 		<table border="1">
 		
 		<%
 			for(Order o: ordersList) { %>
 				<tr>
 					<td> Order id : <%= o.getId() %> </td>
	 				<td> Date : <%= o.getDate() %> </td>
	 			</tr>
	 			<br>
		 		<tr> 
		 			<td colspan = "4">
		 				  <table cellspacing="5">
		 				  <%
		 				  	for(OrderItem oi : o.getItems()) { 
		 				  %>
		 				  
		 				  	<tr>
		 				  		<td> <%= oi.getProduct().getImage() %>  </td>
		 				  		<td> <%= oi.getProduct().getName() %></td>
		 				  		<td> Quantity - <%= oi.getQuantity() %>  </td>
		 				  		<td> price - <%= oi.getProduct().getPrice() %> </td>
		 				  	</tr>
		 				  	
		 				  <% } %>
		 				  </table> 
		 			</td>
	 			</tr>
 		<% 
 			}
 		%>
	 		<!-- <tr> 
	 			<td> Order id : 1 </td>
	 			<td> Date : 15th jan 2023 </td>
	 			<br>
	 			
	 		</tr>
	 		<tr> 
	 			<td colspan = "4">
	 				  <table cellspacing="5">
	 				  	<tr>
	 				  		<td> Image </td>
	 				  		<td> Shirt</td>
	 				  		<td> Quantity - 3 </td>
	 				  		<td> price - 29.99 </td>
	 				  	</tr>
	 				  	<tr>
	 				  		<td> Image </td>
	 				  		<td> pant</td>
	 				  		<td> Quantity - 2 </td>
	 				  		<td> price - 49.99 </td>
	 				  	</tr>
	 				  </table> 
	 			</td>
	 		</tr> -->
	 		
	 		<!-- <tr> 
	 			<td> Order id : 2 </td>
	 			<td> Date : 15th jan 2023 </td>
	 			<br>
	 			
	 		</tr>
	 		<tr> 
	 			<td colspan = "2 ">
	 				  <table>
	 				  	<tr>
	 				  		<td> Image </td>
	 				  		<td> Shoes</td>
	 				  		<td> Quantity - 1 </td>
	 				  		<td> price - 39.99 </td>
	 				  	</tr>
	 				  </table> 
	 			</td>
	 		</tr> -->
 		</table>
 		
 		
 

</body>
</html>