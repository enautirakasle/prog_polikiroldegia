package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Actividad;
import modelo.bean.Usuario;
import modelo.dao.ModeloActividad;
import modelo.dao.ModeloInscripcion;
import modelo.dao.ModeloUsuario;

/**
 * Servlet implementation class InscribirUsuario
 */
@WebServlet("/InscribirUsuario")
public class InscribirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscribirUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idActividad = Integer.parseInt(request.getParameter("idactividad"));
		int idUsuario = Integer.parseInt(request.getParameter("idusuarios"));
		
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		
		String msg = "";
		if(!mInscripcion.estaInscrito(idUsuario, idActividad)) {
			mInscripcion.inscribir(idUsuario, idActividad);
			msg="inscripcion_ok";
		}else {
			msg="inscripcion_nok";
		}
		
		response.sendRedirect("VerActividad?id="+idActividad+"&msg="+msg);
	}

}
