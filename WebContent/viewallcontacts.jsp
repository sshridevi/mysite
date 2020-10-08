<%@include file="header.html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="assign.dbaccess.EMailAddressVOO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style>
			table, th, td {
  			border: 1px solid black;
  			border-collapse: collapse;
			}
		</style>
	</head>

	<body>
		<center>
			<h2>View By Group</h2>
			<%@include file="displayformerrors.jsp"%>
		</center>
		
		<center>
			<table>
				<tr>
					<th>email Address</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>Home Phone</th>
					<th>Work Phone</th>
					<th>Mobile Phone</th>
					<th>Group Id</th>
				</tr>
	<%
	EMailAddressVOO[] eMailList = (EMailAddressVOO[]) request.getSession().getAttribute("emaillist2");
	EMailAddressVOO emailVO;
	for (int i = 0;i < eMailList.length;i++) {
		emailVO = eMailList[i];	
	%>
				<tr>
					<td><%= emailVO.geteMailID() %> </td>
					<td><%= emailVO.getfName()  %></td>
					<td><%= emailVO.getmName()  %></td>
					<td><%= emailVO.getlName()  %></td>
					<td><%= emailVO.gethPhone()  %></td>
					<td><%= emailVO.getwPhone()  %></td>
					<td><%= emailVO.getmPhone()  %></td>
					<td><%= emailVO.getgroupID()  %></td>
				</tr>
		<%
	}
		%>
			</table>
		</center>	



	</body>
</html>