package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloInscripcion;

/**
 * Servlet implementation class EliminarInscripcion
 */
@WebServlet("/EliminarInscripcion")
public class EliminarInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idActividad = Integer.parseInt(request.getParameter("idactividad"));
		int idUsuario = Integer.parseInt(request.getParameter("idusuario"));
		
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		mInscripcion.delete(idActividad, idUsuario);
		
		String msg = "cancelacion_ok";
		response.sendRedirect("VerActividad?id="+idActividad+"&msg="+msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
