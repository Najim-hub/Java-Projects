<%@ tag language="java" pageEncoding="UTF-8"%>

<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>

 <form method=post action=EditAccount>
<table class="center">


	<tr><tg:error/></tr>
	
	
	
	
	
	<tr><td colspan=2><h2>Edit</h2></td></tr>
	
	<tr>
		<td align=left>Your ID: </td>
		<td><input type = text uid value = 
		  "${uid}"readonly></td>
	</tr>
	<tr>
		<td align=left> Full Name: </td>
		<td><input type = text name = fullName maxlength="25"></td>
	</tr>
	<tr>
		<td align=left> Login Name: </td>
		<td><input type = text name = iname></td>
	</tr>
	<tr>
		<td align=left> Password: </td>
		<td><input type=password name=pass2></td>
	</tr>
	
	
	<tr><td colspan=2><input type=submit value=Edit></td></tr>


</form>

<td>
		<form action = Home>
		<input type = submit value = Back>
		 </form>
		 </td>
		 
		 </table>