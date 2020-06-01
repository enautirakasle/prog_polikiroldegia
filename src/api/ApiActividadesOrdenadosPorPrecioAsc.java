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
import modelo.util.ActividadNombreComparatorDesc;


/**
 * Servlet implementation class ApiActividadesOrdenadosPorPrecioAsc
 */
@WebServlet("/ApiActividadesOrdenadosPorPrecioAsc")
public class ApiActividadesOrdenadosPorPrecioAsc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiActividadesOrdenadosPorPrecioAsc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloActividad mActividad = new ModeloActividad();
		ArrayList<Actividad> actividades = mActividad.selectAll();
		
		actividades.sort(new ActividadNombreComparatorDesc());
		
		response.setHeader("Access-Control-Allow-Origin", "*"); // jsonp deia denean ez da behar
		response.setContentType("application/json");	//erantzunaren MIME mota zein den zehazten du
		
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
