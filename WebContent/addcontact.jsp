<%@include file="header.html"%>
<html>
<head>
<title>Add Contact</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

<center>
<%@include file="displayformerrors.jsp"%>
<h2>Add contact</h2>
</center>
<!--Body: add contact information-->
<center>
<form method="post" action="/mysite/servlet/addemailaddress">
	<table  cellpadding="0" cellspacing="0" width="50%"">
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail</td>
			<td><input type="text" name="emailid" maxlength="50" value="<%= request.getParameter("emailid") %>" /></td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">First name</td>
			<td><input type="text" name="fname" maxlength="30" value="" /></td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle name</td>
			<td><input type="text" name="mname" maxlength="10" value="" /></td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last name</td>
			<td><input type="text" name="lname" maxlegth="30" value="" /></td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Home Phone</td>
			<td><input type="text" name="hphone" maxlength="12" value="" /></td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Work Phone</td>
			<td><input type="text" name="wphone" maxlength="12" value="" /></td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Mobile Phone</td>
			<td><input type="text" name="mphone" maxlength="12" value="" /></td>
		</tr>
		<td bgcolor="#FAFAF9" style="padding-left: 10px;">
		<lable for="group">Group</lable>
		</td>
			<td><select name="group" id="group">
			<option value=7>Friends</option>
			<option value=8>Personal</option>
			<option value=9>Relatives</option>
			</select> </td>
		</tr>

		<tr>
			<td colspan="2" align="right">
			<br>
			<table  width="50%">
				<tr>
					<td><input type="submit" name="save" value="Save"/></td>
					<td width="201"><input type="reset" name="clear" value="Clear" />&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</form>
</center>
</body>

	

</html>
<%@include file="footer.html"%>

</body>
