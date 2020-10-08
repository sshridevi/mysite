package assign.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get Email Address Servlet 
 */

public class GetEMailAddressDtlsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	String errors = "";
    	//step1
    	String emailaddress = request.getParameter("emailid");
    	System.out.println(emailaddress);
    	
    	//step2 JDBC
    	//2a
    	EMailBO eMailBO = new EMailBO();
    	EMailAddressVOO eMailAddressVOO = null;
    	try {
    		eMailAddressVOO = eMailBO.getEMailAddress(emailaddress);
		} catch (EMailValidationException e) {
			errors = e.getErrorMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		if (errors.equals("")) {
			System.out.println("first Name: " + eMailAddressVOO.getfName());
			request.setAttribute("emailVO", eMailAddressVOO);
			RequestDispatcher rd = request.getRequestDispatcher("/viewsuccess.jsp");
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/viewcontact.jsp");
		}
    	
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

