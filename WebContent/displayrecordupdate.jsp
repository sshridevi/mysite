
<%@page import="assign.dbaccess.EMailAddressVOO"%>
<%@include file="header.html"%>
<html>
<head>
<title>Update Contact</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

<center>
<%@include file="displayformerrors.jsp"%>
<h2>Update contact</h2>
</center>
<!--Body: add contact information-->
<center>
<form method="post"  action="/mysite/update">
	<table  cellpadding="0" cellspacing="0" width="50%"">


		<%
			EMailAddressVOO eMailAddressVOO = (EMailAddressVOO) request.getAttribute("emailVO");
			request.getSession().setAttribute("emailVO2",eMailAddressVOO);
 		%>

		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Work Phone</td>
			<td><input type="text" name="wphone" maxlength="12" value="<%=eMailAddressVOO.getwPhone() %>" /></td>
		</tr>
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">Mobile Phone</td>
			<td><input type="text" name="mphone" maxlength="12" value="<%=eMailAddressVOO.getmPhone() %>" /></td>
		</tr>

		<tr>
			<td colspan="2" align="right">
			<br>
			<table  width="50%">
				<tr>
					<td><input type="submit" name="update" value="Update"/></td>
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
