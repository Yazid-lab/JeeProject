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
 * Servlet implementation class EditPatient
 */
@WebServlet("/update")
public class UpdatePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB ILocalPatient servicePatient; 
    @EJB ILocalMeds serviceMed;
    ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatient() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		List<Patient> listPatients = servicePatient.listPatients();
		List<Meds> listMeds=serviceMed.listMeds();
		context.setAttribute("listMeds", listMeds);
		Patient patientToEdit =new Patient();
		int idPatient=Integer.parseInt(request.getParameter("idPatient"));
		patientToEdit = findpatientbyid(listPatients, idPatient);
		context.setAttribute("listPatients", listPatients);
		context.setAttribute("patientToEdit", patientToEdit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editForm.jsp");
    	dispatcher.forward(request, response);
	}

	private Patient findpatientbyid(List<Patient> listPatients, int idPatient) {
		for (Patient patient : listPatients) {
			if (patient.getIdPatient()==idPatient)
				return patient;
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("idPatient"));
		String name = request.getParameter("namePatient");
    	String email = request.getParameter("emailPatient");
    	String country = request.getParameter("countryPatient");
    	String idm = request.getParameter("choice").split("-")[0];
    	Meds selectedMed =serviceMed.findMed(Integer.parseInt(idm));
    	Patient newPatient = new Patient(id,name, email, country);
    	newPatient.setMedtaken(selectedMed);
    	servicePatient.updatePatient(newPatient,selectedMed);
    	response.sendRedirect("listPatients");
	}

}
