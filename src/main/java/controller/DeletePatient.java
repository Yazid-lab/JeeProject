package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ILocalPatient;

/**
 * Servlet implementation class DeletePatient
 */
@WebServlet("/delete")
public class DeletePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ILocalPatient servicePatient;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePatient() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("idPatient"));
		servicePatient.deletePatient(id);
		System.out.println("patient "+id+" deleted");
		response.sendRedirect("listPatients");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
