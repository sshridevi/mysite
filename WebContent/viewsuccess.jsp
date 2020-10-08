<%@include file="header.html"%>
<html>
<head>
<title>View Contact Success page</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>View Contact</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
		<jsp:useBean id="emailVO" class="assign.dbaccess.EMailAddressVOO"
			scope="request">
		</jsp:useBean>
		<table border="1" cellpadding="1" cellspacing="0" width="50%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail id</td>
				<td><jsp:getProperty name="emailVO" property="eMailID" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">firstName</td>
				<td><jsp:getProperty name="emailVO" property="fName" /></td>
			</tr>

			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">LastName</td>
				<td><jsp:getProperty name="emailVO" property="lName" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">MiddleName</td>
				<td><jsp:getProperty name="emailVO" property="mName" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">HomePhone</td>
				<td><jsp:getProperty name="emailVO" property="hPhone" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">MobilePhone</td>
				<td><jsp:getProperty name="emailVO" property="mPhone" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">WorkPhone</td>
				<td><jsp:getProperty name="emailVO" property="wPhone" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Group</td>
				<td><jsp:getProperty name="emailVO" property="groupID" /></td>
			</tr>
		</table>

	</center>
</body>



</html>
<%@include file="footer.html"%>