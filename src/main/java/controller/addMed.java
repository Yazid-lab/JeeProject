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
import service.ILocalMeds;

/**
 * Servlet implementation class addMed
 */
@WebServlet("/addMed")
public class addMed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ILocalMeds serviceMeds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("formMed.jsp");
    	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nameMed");
    	Meds newMed= new Meds(name);
    	serviceMeds.addMeds(newMed);
    	System.out.println("New med added");
    	response.sendRedirect("ListMeds");
	}

}
