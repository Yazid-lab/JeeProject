package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Meds;
import entities.Patient;
import service.ILocalMeds;

/**
 * Servlet implementation class updateMed
 */
@WebServlet("/updateMed")
public class updateMed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ILocalMeds serviceMed;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("editFormMeds.jsp");
    	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("idMed"));
		String name=request.getParameter("nameMed");
		Meds newmed=new Meds(id,name);
    	serviceMed.updateMeds(newmed);
    	System.out.println("med "+id+" update");
    	response.sendRedirect("ListMeds");
	}

}
