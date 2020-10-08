<%@include file="header.html"%>
<html>
<head>
<title>Modify Contact</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

<center>
<h2>Modify Contact</h2>
</center>
<!--Body: Modify contact information-->
<center>
<form method="post" action="/mysite/servlet/getemailinfoforupdate">
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
					<td><input type="submit" name="save" value="Modify"/></td>
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
