<%@ tag language="java" pageEncoding="UTF-8"%>



	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<table class="center" width="70%">
	<tr>
		<td align=left>${name}</td>
		
		<td align=right>
			<a href="EditAccount">Edit Account</a> 
			<a href="Logout">Log out</a>
		</td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<h2>Item</h2>
			
			<table class="center">
				<tr><th>Actions</th><th>Item Name</th><th>Quantity</th></tr>
						
						<c:forEach var="i" items="${viewItems}">
						
						<tr>
								<td>
									
									<a href="EditItem?id=${i.id}">Edit</a> 
									<a href="DeleteItem?id=${i.id}">Delete</a>
								</td>
								<td>${i.name}</td>
								<td>${i.qty}</td>
								<td>
				                 <form action = Home>
			                	<input type = submit value = Back>
		                    	</form>
		                    	</td>
							</tr>
						
						</c:forEach>
							
			</table>
			
		</td>
	</tr>
</table>
