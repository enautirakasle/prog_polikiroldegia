package modelo.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Conector;
import modelo.bean.Usuario;

public class ModeloUsuario extends Conector{
	
	public ArrayList<Usuario> selectAll(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios");
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				usuarios.add(usuario);
			}
			return usuarios;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	

	public boolean existCodigo(String codigo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where codigo = ?");
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean existDni(String dni) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where dni = ?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean exist(Usuario usuario) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where dni = ?");
			pst.setString(1, usuario.getDni());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean existId(int id) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Usuario getPorCodigo(String codigo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where codigo = ?");
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				return usuario;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public Usuario getPorDni(String dni) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where dni = ?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				return usuario;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	public Usuario get(int id) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				return usuario;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

	
	public void insert(Usuario usuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into usuarios (nombre_apellido, dni, codigo) values (?, ?, ?)");
			pst.setString(1, usuario.getNombreApellido());
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getCodigo());
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void insert(String nombreApellido, String dni, String codigo) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into usuarios (nombre_apellido, dni, codigo) values (?, ?, ?)");
			pst.setString(1, nombreApellido);
			pst.setString(2, dni);
			pst.setString(3, codigo);
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public ArrayList<Usuario> usuariosConInscripciones(){
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		
		ArrayList<Usuario> usuarios = this.selectAll();
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			usuario.setInscripciones(mInscripcion.getActividadesDeUsuario(usuario.getId()));
		}
		return usuarios;
	}
	
	
	public Usuario usuarioConInscripciones(int idUsuario){
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		
		Usuario usuario = this.get(idUsuario);
		usuario.setInscripciones(mInscripcion.getActividadesDeUsuario(idUsuario));
		
		return usuario;
	}

	
	public void updateNombreApellido(int id, String nombre_apellido) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set nombre_apellido=? where id=?");
			
			pst.setString(1, nombre_apellido);
			pst.setInt(2, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateDni(int id, String dni) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set dni=? where id=?");
			
			pst.setString(1, dni);
			pst.setInt(2, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateCodigo(int id, String codigo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set codigo=? where id=?");
			
			pst.setString(1, codigo);
			pst.setInt(2, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(Usuario usuario) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set nombre_apellido=?, dni=?, codigo=? where id=?");
			
			pst.setString(1, usuario.getNombreApellido());
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getCodigo());
			pst.setInt(4, usuario.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Usuario usuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM usuarios WHERE id=?");
			pst.setInt(1, usuario.getId());
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int idUsuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM usuarios WHERE id=?");
			pst.setInt(1, idUsuario);
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
