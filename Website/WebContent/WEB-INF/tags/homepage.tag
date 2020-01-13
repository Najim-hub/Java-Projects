<%@ tag language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="mytags" uri="/WEB-INF/greeting.tld" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<head>
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta charset="UTF-8">
	<title>Home</title>
	</head>
	
	
	<body>
	<table class="center" width="70%">
		<tr>
			<td align=left>
			<mytags:tagOne>${name}</mytags:tagOne>
			</td>
			<td align=right>
				<a href="EditAccount">Edit Account</a> 
				<a href="Logout">Log out</a>
				<a href="AddItem">Add item</a>
				
			</td>
		</tr>
		<tr>
			<td colspan=2 align=center>
	
						<h2>List of Items</h2>
				
				<table class="center">
				
					<tr><th>Actions</th><th>Item Name</th><th>Quantity</th></tr>
					
					<c:forEach var="i" items="${allItems}">
					
					<tr>
									<td>
						<a href="ViewItem?id=${i.id}">View</a> 
						<a href="EditItem?id=${i.id}">Edit</a> 
						<a href="DeleteItem?id=${i.id}">Delete</a>
										
								</td>
	       
	                        <td> ${i.name } </td>
	                        <td> ${i.qty} </td>
	                        
	                 </tr>
	                 
	                 
	       
	
	</c:forEach>
	
	</table>
	
			
			</td>
		</tr>
	</table>
					
							
	</body>
	