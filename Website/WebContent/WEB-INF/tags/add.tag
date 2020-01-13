<%@ tag language="java" pageEncoding="UTF-8"%>

<%@taglib prefix="er" tagdir="/WEB-INF/tags"%>

<form method=post action=AddItem>

	<tr><er:error/></tr>

		<table class="center">

	<tr><td colspan=2><h2>Add</h2></td></tr>
	<tr>
		<td align=left>Item Name: </td>
		<td><input type=text name=iname></td>
	</tr>
	<tr>
		<td align=left>Quantity: </td>
		<td><input type=number name=qnum></td>
	</tr>
	<tr><td colspan=2><input type=submit value=Add></td>
	</form>
	<td>
		<form action = Home>
		<input type = submit value = Back>
		 </form>
		 </td>
	</tr>
</table>