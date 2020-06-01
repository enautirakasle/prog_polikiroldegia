package api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONStringer;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;
import modelo.util.ActividadPrecioComparatorAsc;
import modelo.util.ActividadPrecioComparatorDesc;

/**
 * Servlet implementation class ApiActividadesOrdenadosPrecio
 */
@WebServlet("/ApiActividadesOrdenadosPrecio")
public class ApiActividadesOrdenadosPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiActividadesOrdenadosPrecio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orden = request.getParameter("orden");
		
		ModeloActividad mActividad = new ModeloActividad();
		ArrayList<Actividad> actividades = mActividad.selectAll();
		
		if(orden.equals("asc")) {
			actividades.sort(new ActividadPrecioComparatorAsc());
		}else if(orden.equals("desc")) {
			actividades.sort(new ActividadPrecioComparatorDesc());
		}
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");	
		
		String jsonString = JSONStringer.valueToString(actividades);
		
	    PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
		out.print(jsonString);
		out.flush();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
