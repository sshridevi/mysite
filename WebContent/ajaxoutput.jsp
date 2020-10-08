<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
    <body>
    <jsp:useBean id="emailobject" class="assign.dbaccess.EMailAddressVOO" scope="session"> </jsp:useBean>
    
	 Here is email details: <br>
	 	emailid: <jsp:getProperty name="emailobject" property="eMailID"/> <br>
	 	firstname:  <jsp:getProperty name="emailobject" property="fName"/><br>
	 	lastname:  <jsp:getProperty name="emailobject" property="lName"/><br>
	 	middlename:  <jsp:getProperty name="emailobject" property="mName"/><br>
	 	phoneno:  <jsp:getProperty name="emailobject" property="mPhone"/><br>
    </body>
</html>