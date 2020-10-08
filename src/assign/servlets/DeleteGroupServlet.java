package assign.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import assign.dbaccess.Group;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Delete Email Address Servlet 
 */

public class DeleteGroupServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";
	String groupID = request.getParameter("groupid");
        response.setContentType("text/html");

	EMailBO eMailBO = new EMailBO();
	Group group = null;

	try{
	    eMailBO.deleteGroup(groupID);
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		response.sendRedirect("/mysite/success.jsp");	
	}
	else {
		System.out.println(request.getRequestURI());
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/deletecontact.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

