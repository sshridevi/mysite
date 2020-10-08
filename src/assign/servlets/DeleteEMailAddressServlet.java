package assign.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Delete Email Address Servlet 
 */
@WebServlet("/deleteEmail")
public class DeleteEMailAddressServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";
	String inEmailID = request.getParameter("emailid");
        response.setContentType("text/html");

	EMailBO eMailBO = new EMailBO();
	EMailAddressVOO eMailAddress = null;

	try{
	    eMailBO.deleteEMailAddress(inEmailID);
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		response.sendRedirect("/mysite/home.jsp");	
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

