package api;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiUpdateActividadValidado
 */
@WebServlet("/ApiUpdateActividadValidado")
public class ApiUpdateActividadValidado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiUpdateActividadValidado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		datuak jaso
		request.setCharacterEncoding("UTF-8"); 
		String jsonActividad = request.getParameter("actividad");
		
		System.out.println(jsonActividad);
		JSONObject jsonObject = new JSONObject(jsonActividad);
		
//		aktibidade objektua sortu
		Actividad actividad = new Actividad();
		actividad.setId(jsonObject.getInt("id"));
		actividad.setNombre(jsonObject.getString("nombre"));
		actividad.setDias(jsonObject.getString("dias"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			actividad.setFecha_inicio(sdf.parse(jsonObject.getString("fecha_inicio")));
		} catch (ParseException e1) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Data gaizki");
			e1.printStackTrace();
		}
		actividad.setFecha_inicio(new Date());
		actividad.setHoras(jsonObject.getInt("horas"));
		actividad.setMaxParticipantes(jsonObject.getInt("max_participantes"));
		actividad.setPrecio(jsonObject.getDouble("precio"));
		
		if(actividad.getHoras()<0 || actividad.getPrecio()<0) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Errorea balidatzean");
		}else {
			ModeloActividad mActividad = new ModeloActividad();
			mActividad.update(actividad);
				
			try {
				mActividad.getConexion().close();
			} catch (SQLException e) {
				System.out.println("Errorea conexioa ixtean");
				e.printStackTrace();
			}
			
			response.setHeader("Access-Control-Allow-Origin","*");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		}
	
	}

}
