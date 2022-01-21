package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Meds;
import service.ILocalMeds;

/**
 * Servlet implementation class ListMeds
 */
@WebServlet("/ListMeds")
public class ListMeds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	@EJB private ILocalMeds serviceMeds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMeds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		List<Meds> listMeds= serviceMeds.listMeds();
		context.setAttribute("listMeds", listMeds);
		request.getRequestDispatcher("/listMeds.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
