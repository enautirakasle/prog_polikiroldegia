package api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiPrezioOrduko
 */
@WebServlet("/ApiPrezioOrduko")
public class ApiPrezioOrduko extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiPrezioOrduko() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ida jaso
		int idActividad = Integer.parseInt(request.getParameter("id"));
		
		//id horrekin aktibidadea lortu modelotik
		ModeloActividad mActividad = new ModeloActividad();
		Actividad actividad = mActividad.get(idActividad);
		
//		kalkulua egin
		Double prezioOrduko = actividad.getPrecio() / actividad.getHoras();
		
//		jason-a osatu
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("prezio_orduko", prezioOrduko);
	
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
//		datuak itzuli
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
		out.print(jsonObject);
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
