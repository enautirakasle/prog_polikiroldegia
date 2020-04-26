package api;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.bean.Usuario;
import modelo.dao.ModeloUsuario;

/**
 * Servlet implementation class ApiCreateUsuarios
 */
@WebServlet("/ApiCreateUsuarios")
public class ApiCreateUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiCreateUsuarios() {
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
		request.setCharacterEncoding("UTF-8"); //enieak eta ondo irakurtzeko
		String jsonUsuarios = request.getParameter("usuarios");
		System.out.println(jsonUsuarios);
		
		JSONArray jsonArray = new JSONArray(jsonUsuarios);
		ModeloUsuario mUsuario = new ModeloUsuario();
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Usuario usuario = new Usuario();
			usuario.setNombreApellido(jsonObject.getString("nombreApellido"));
			usuario.setCodigo(jsonObject.getString("codigo"));
			usuario.setDni(jsonObject.getString("dni"));
			
			mUsuario.insert(usuario);
		}
		
		try {
			mUsuario.getConexion().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.setHeader("Access-Control-Allow-Origin","*"); //jsonp deia denean ez da behar
		response.setCharacterEncoding("UTF-8");
	}

}
