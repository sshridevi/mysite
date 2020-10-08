package assign.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;


public class UpdateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String errors = "";
		//Step1: capture input and populate the VO
		EMailAddressVOO eMailAddressVO = (EMailAddressVOO)request.getSession().getAttribute("emailVO2");
		// Get registration details and set to the EMailAddress
		//Step:1
		/*if(eMailAddressVO == null) {
			System.out.println("Did not receive eMailAddressVO object");
		}*/
		eMailAddressVO.setwPhone(request.getParameter("wphone"));
		eMailAddressVO.setmPhone(request.getParameter("mphone"));
		

		// Step2: Do processing or Business logic
		 EMailBO eMailBO = new EMailBO();
		
		 try{
		 	eMailBO.updateEMailAddress(eMailAddressVO);
		 }catch (EMailValidationException emve){
			 errors = emve.getErrorMessage();
		 }
		 catch (Exception e){
		 e.printStackTrace();
		 }
		 
		//step3: Response Back
		if (errors.equals("")) {
			response.sendRedirect("/mysite/home.jsp");
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/addcontact.jsp");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doGet(request, response);
	}

}
	 

	
