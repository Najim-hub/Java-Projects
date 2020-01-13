<%@ tag language="java" pageEncoding="UTF-8"%>

<%@taglib prefix="er" tagdir="/WEB-INF/tags"%>

<form method=post action=addAccount>
<table class="center">


 	<tr><er:error/></tr>

	<tr><td colspan=2><h2>Create Account</h2></td></tr>
	
	
	<tr>
		<td align=left> Full Name: </td>
		<td><input type = text name = fullName></td>
	</tr>
	<tr>
		<td align=left> Login Name: </td>
		<td><input type = text name = lname></td>
	</tr>
	<tr>
		<td align=left> Password: </td>
		<td><input type=password name=pass></td>
	</tr>
	<tr>
		<td align=left> Re-Type Password: </td>
		<td><input type=password name=pass2></td>
	</tr>
	
	<tr><td colspan=2><input type=submit value=Add></td></tr>


</form>

<td>
		<form action = Login>
		<input type = submit value = Back>
		 </form>
		 </td>
		 
		 </table>