<%@include file="header.html"%>
<html>
<head>
<title>View Contact</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

<center>
<h2>View Contact</h2>
<%@include file="displayformerrors.jsp"%>
</center>
<!--Body: view contact information-->
<center>
<form method="post" action="/mysite/servlet/emailaddressdtls">
	<table  cellpadding="0" cellspacing="0" width="50%"">
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail</td>
			<td><input type="text" name="emailid" maxlength="50" value="" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<br>
			<table  width="50%">
				<tr>
					<td><input type="submit" name="save" value="View"/></td>
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