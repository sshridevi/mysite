package assign.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import assign.dbaccess.Group;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Add Group Servlet 
 */

public class AddGroupServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";

	Group group = new Group();

	//Get Group details and set to the Group

	group.setgroupID(request.getParameter("groupid"));
	group.setgName(request.getParameter("gname"));

        response.setContentType("text/html");
        HttpSession ses = request.getSession();
        

	EMailBO eMailBO = new EMailBO();


	try{
	    eMailBO.addGroup(group);
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		System.out.println("222222222222222222");
		response.sendRedirect("SUCCESS");	

	}
	else {
		System.out.println(request.getRequestURI());
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/addgroup.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

