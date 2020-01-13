<%@ tag language="java" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="er" tagdir="/WEB-INF/tags"%>

<table class="center">

	<tr><er:error/></tr>

	<form method=post action=EditItem>

	<tr><td colspan=2><h2>Edit</h2></td></tr>
	
	<tr>
		<td align=left>Item ID: </td>
		
		
		<td><input type = text name = iid value = 
		  "${id}" readonly></td>
	</tr>
	<tr>
		<td align=left> Item Name: </td>
		<td><input type = text name = iname></td>
	</tr>
	<tr>
		<td align=left> Quantity: </td>
		<td><input type=text name=iqty></td>
	</tr>
	<tr><td colspan=2><input type=submit value=Edit></td></tr>

     </form>
     
     <td>
		<form action = Home>
		<input type = submit value = Back>
		 </form>
		 </td>
		 </table>