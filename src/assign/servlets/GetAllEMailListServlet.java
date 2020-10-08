package assign.servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get Email Address Servlet 
 */

public class GetAllEMailListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException {
    	String errors = "";
        response.setContentType("text/html");

        EMailBO eMailBO = new EMailBO();
        EMailAddressVOO[] eMailList = null;

        try {
        	ArrayList list = eMailBO.getAllEMailAddressList();
        	Object[] aList = list.toArray(new EMailAddressVOO[list.size()]);
        	eMailList = new EMailAddressVOO[list.size()];
        	for (int i = 0;i < aList.length;i++) {
        		eMailList[i] = (EMailAddressVOO) aList[i];
        		System.out.println("Get Email list :"+eMailList[i].geteMailID());
        	}
        }	catch (EMailValidationException emve){
        	errors = emve.getErrorMessage();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	
        if (errors.equals("")){
        	request.getSession().setAttribute("emaillist", eMailList);
        	//	request.setAttribute("emaillist", eMailList);
        	response.sendRedirect("/mysite/viewaall.jsp");
        }	else {
        	request.getSession().setAttribute("Errors", errors);
        	response.sendRedirect("/mysite/error.jsp");
        }
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException {
        doGet(request, response);
    }

}

