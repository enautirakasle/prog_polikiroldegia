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

import modelo.bean.Usuario;
import modelo.dao.ModeloUsuario;
import modelo.util.NombreComparator;

/**
 * Servlet implementation class ApiUsuariosOrdenados
 */
@WebServlet("/ApiUsuariosOrdenados")
public class ApiUsuariosOrdenados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiUsuariosOrdenados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloUsuario mUsuario = new ModeloUsuario();
		ArrayList<Usuario> usuarios = mUsuario.selectAll();
		
		usuarios.sort(new NombreComparator());
		
		response.setHeader("Access-Control-Allow-Origin", "*"); // jsonp deia denean ez da behar
		response.setContentType("application/json");	//erantzunaren MIME mota zein den zehazten du
		//response.setCharacterEncoding("UTF-8");			//kodifikazioa zehazten du
		
		String jsonString = JSONStringer.valueToString(usuarios);
		
	    PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
//		PrintWriter out = response.getWriter();
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
