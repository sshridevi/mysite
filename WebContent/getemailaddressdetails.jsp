<html>

<head> 
<title>Add Contact</title>
</head>
<body bgcolor="#ffffee">
<center>
<h1>GetEmailInfo</h1>
<br>
<br>

<!-- errors display -->
<% 
String formErrors = (String) request.getSession().getAttribute("Errors");
System.out.println(formErrors);
%>

<%if (formErrors != null && !formErrors.equals("")){%>
<h3><font color="red" face="Arial, Helvetica, sans-serif" size="2">Please correct the following errors and try again:</font></h3>
<ul><font size="2" color="black" face="Arial, Helvetica, sans-serif"><%=request.getSession().getAttribute("Errors") %></font>
</ul>
<%}%>
<!-- end errors display -->

<!--getemail address information-->
<form action="http://localhost:8080/mysite/servlet/emailaddressdtls">
Email ID: <input type=text name="emailid" value="" size=20 class="tf"/>&nbsp;&nbsp;<br><br>
<input type=submit name="submit" value="submit"/>
</form>
</center>
</html>