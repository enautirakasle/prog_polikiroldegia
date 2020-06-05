package api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONStringer;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiActividadesMasCarasQue
 */
@WebServlet("/ApiActividadesMasCarasQue")
public class ApiActividadesMasCarasQue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApiActividadesMasCarasQue() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int precio = Integer.parseInt(request.getParameter("precio"));
		int horas = Integer.parseInt(request.getParameter("horas")); 

		ModeloActividad mActividades = new ModeloActividad();
		ArrayList<Actividad> actividades = mActividades.selectAll();

		//filtrar la lista
		Iterator<Actividad> it = actividades.iterator();
		
		while (it.hasNext()) {
			Actividad actividad = it.next();
			if (actividad.getPrecio() > precio || actividad.getHoras() < horas) {
				it.remove();
			}
		}
		
//		while (it.hasNext()) {
//		Actividad actividad = it.next();
//		if (actividad.getPrecio() < precio && actividad.getHoras() > horas) {
//			
//		}else {
//			it.remove();
//		}
//	}
		
		// while (it.hasNext()) {
		// Actividad actividad = it.next();
		// if(actividad.getPrecio() < precio && actividad.getHoras() < horas) {
		// it.remove();
		// }
		// if(actividad.getPrecio() > precio && actividad.getHoras() > horas) {
		// it.remove();
		// }
		// if(actividad.getPrecio() > precio && actividad.getHoras() < horas) {
		// it.remove();
		// }
		// }
		
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setContentType("application/json");
		
		String jsonString = JSONStringer.valueToString(actividades);
		
	    PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
		out.print(jsonString);
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
