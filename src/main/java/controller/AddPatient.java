package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Meds;
import entities.Patient;
import service.ILocalMeds;
import service.ILocalPatient;

/**
 * Servlet implementation class AddPatient
 */
@WebServlet("/add")
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ILocalPatient servicePatient;
	@EJB private ILocalMeds serviceMed;
	ServletContext context;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatient() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		List<Meds> listMeds=serviceMed.listMeds();
		context.setAttribute("listMeds", listMeds);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formPatient.jsp");
    	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Meds> listMeds=serviceMed.listMeds();
		String name = request.getParameter("namePatient");
    	String email = request.getParameter("emailPatient");
    	String country = request.getParameter("countryPatient");
    	String id = request.getParameter("choice").split("-")[0];
    	Meds selectedMed =serviceMed.findMed(Integer.parseInt(id));
    	Patient newPatient = new Patient(name, email, country);
    	newPatient.setMedtaken(selectedMed);
    	servicePatient.addPatient(newPatient);
    	request.setAttribute("beanPatient", newPatient);
    	System.out.println("New patient added");
    	response.sendRedirect("listPatients");
	}

}
