package assign.servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import assign.dbaccess.Group;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get All Groups Servlet 
 */

public class GetAllGroupListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";
        response.setContentType("text/html");

	EMailBO eMailBO = new EMailBO();
	Group group = null;

	try{
	    ArrayList list = eMailBO.getAllGroups();
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		response.sendRedirect("/mysite/viewallgroups.jsp");	

	}
	else {
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/error.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

