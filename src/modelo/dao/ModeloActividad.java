package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;

public class ModeloActividad extends Conector {

	public ArrayList<Actividad> selectAll() {
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				actividades.add(actividad);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}
	
	public ArrayList<Actividad> selectAllMasCarosQue(double precio){
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where precio > ?");
			pst.setDouble(1, precio);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				actividades.add(actividad);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
		
	}
	
	public int numActividadesMasCarosQue(double precio) {
		int num = 0;
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where precio > ?");
			pst.setDouble(1, precio);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				num++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
	public int numActividadesMasCarosQue2(double precio) {
		return this.selectAllMasCarosQue(precio).size();
	}
	
	
	public ArrayList<Actividad> selectAllMasCarosQue2(double precio){
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			pst.setDouble(1, precio);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				if(rs.getDouble("precio") > precio) {
					Actividad actividad = new Actividad();
					actividad.setId(rs.getInt("id"));
					actividad.setNombre(rs.getString("nombre"));
					actividad.setDias(rs.getString("dias_semana"));
					actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
					actividad.setHoras(rs.getInt("horas"));
					actividad.setMaxParticipantes(rs.getInt("max_participantes"));
					actividad.setPrecio(rs.getDouble("precio"));
	
					actividades.add(actividad);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}
	
	
	
	public ArrayList<Actividad> selectAllConInscripciones() {
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));
				
				//consegir los usuarios inscritos con el id de actividad
				PreparedStatement pst2 = super.conexion.prepareStatement("select inscripciones.*, usuarios.* from inscripciones join usuarios on inscripciones.id_usuario= usuarios.id where id_actividad=?");
				pst2.setInt(1, actividad.getId());
				ResultSet rs2 = pst2.executeQuery();
				
				ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
				
				//crear inscripciones de la actividad con usuario rellenado
				while(rs2.next()) {
					Inscripcion inscripcion = new Inscripcion();
					inscripcion.setId(rs2.getInt("inscripciones.id"));
					
					Usuario usuario = new Usuario();
					usuario.setId(rs2.getInt("usuarios.id"));
					usuario.setNombreApellido(rs2.getString("nombre_apellido"));
					usuario.setDni(rs2.getString("dni"));
					usuario.setCodigo(rs2.getString("codigo"));
					
					inscripcion.setUsuario(usuario);
					
					inscripciones.add(inscripcion);
					
				}
				actividad.setIscripciones(inscripciones);

				actividades.add(actividad);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}
	
	
	public ArrayList<Actividad> selectAllConInscripciones2() {
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));
				
				//-------------------
				ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
				ArrayList<Usuario> usuariosInscritos = mInscripcion.getUsuariosInscritos(actividad.getId());
				
				Iterator<Usuario> i = usuariosInscritos.iterator();
				while(i.hasNext()) {
					Usuario usuario = i.next();
					
					Inscripcion inscripcion = new Inscripcion();
					inscripcion.setUsuario(usuario);
					
					inscripciones.add(inscripcion);
					
				}
				
				//------------------
				actividad.setIscripciones(inscripciones);

				actividades.add(actividad);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}
	
	public ArrayList<Actividad> buscar(String query) {
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where nombre like ?");
			pst.setString(1, "%"+query+"%");
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				actividades.add(actividad);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}

	public Actividad getConUsuariosInscritos(int idActividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select inscripciones.*, usuarios.* "
					+ "from inscripciones join usuarios on inscripciones.id_usuario= usuarios.id "
					+ "where inscripciones.id_actividad = ?");
			pst.setInt(1, idActividad);

			ResultSet rs = pst.executeQuery();
			Actividad actividad = this.get(idActividad);
			ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

			while (rs.next()) {

				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("usuarios.id"));
				usuario.setNombreApellido(rs.getString("usuarios.nombre_apellido"));
				usuario.setDni(rs.getString("usuarios.dni"));
				usuario.setCodigo(rs.getString("usuarios.codigo"));

				Inscripcion inscripcion = new Inscripcion();
				inscripcion.setUsuario(usuario);
				inscripciones.add(inscripcion);

			}
			actividad.setIscripciones(inscripciones);

			return actividad;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Actividad get(int idActividad) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from actividades where id= ?");
			pst.setInt(1, idActividad);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				return actividad;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void update(Actividad actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE actividades "
					+ "SET nombre=?, dias_semana = ?, fecha_inicio=?, horas=?, max_participantes=?, precio=? "
					+ "WHERE id = ?");
			pst.setString(1, actividad.getNombre());
			pst.setString(2, actividad.getDias());
			pst.setDate(3, new java.sql.Date(actividad.getFecha_inicio().getTime()));
			pst.setInt(4, actividad.getHoras());
			pst.setInt(5, actividad.getMaxParticipantes());
			pst.setDouble(6, actividad.getPrecio());
			pst.setInt(7, actividad.getId());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insert(Actividad actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement(
					"insert into actividades (nombre, fecha_inicio, dias_semana, horas, max_participantes, precio) values (?, ?, ?, ?, ?, ?)");
			pst.setString(1, actividad.getNombre());
			pst.setDate(2, new java.sql.Date(actividad.getFecha_inicio().getTime()));
			pst.setString(3, actividad.getDias());
			pst.setInt(4, actividad.getHoras());
			pst.setInt(5, actividad.getMaxParticipantes());
			pst.setDouble(6, actividad.getPrecio());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Actividad actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM actividades WHERE id=?");
			pst.setInt(1, actividad.getId());
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM actividades WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public double sumaDePrecios() {
//		select sum(precio) from actividades
//		
//		ArrayList<Actividad> actividades = selectAll();
		return 0;
		
		
	}

}
