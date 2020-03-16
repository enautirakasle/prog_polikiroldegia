package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class InsertarActividad
 */
@WebServlet("/InsertarActividad")
public class InsertarActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarActividad() {
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

		//datuak jaso
		Date fechaInicio = null;
		String nombre = request.getParameter("nombre");
		String diasSemana = request.getParameter("dias_semana");
		String fechaInicioParametro = request.getParameter("fecha_inicio");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaInicio = formato.parse(request.getParameter("fecha_inicio"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int horas = Integer.parseInt(request.getParameter("horas"));
		int maxParticipantes = Integer.parseInt(request.getParameter("max_participantes"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		
//		System.out.println(nombre);
//		System.out.println(fechaInicio);
//		System.out.println(diasSemana);
//		System.out.println(horas);
//		System.out.println(maxParticipantes);
//		System.out.println(precio);
		
		//sortu acgividade objektu bat
		Actividad actividad = new Actividad();
		//jasotako datuekin setak egin
		actividad.setNombre(nombre);
		actividad.setFecha_inicio(fechaInicio);
		actividad.setDias(diasSemana);
		actividad.setHoras(horas);
		actividad.setMaxParticipantes(maxParticipantes);
		actividad.setPrecio(precio);
		
		//modeloa sortu
		ModeloActividad mActividad = new ModeloActividad();
		//inserta egin
		mActividad.insert(actividad);
		
		//VerActividades kontrolatzaileari deitu
		response.sendRedirect("VerActividades");

		
	}

}
