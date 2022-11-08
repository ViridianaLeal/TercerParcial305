package dao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import modelo.Usuario;

public class daoUsuario {
	conexion cx = null;

	public daoUsuario() {
		cx=new conexion();

	}
	public boolean insertarUsuario(Usuario user) {
		PreparedStatement ps=null;
		try {
			ps=cx.conectar().prepareStatement("INSERT INTO usuario VALUES(null,?,?,?)");
			ps.setString(1,  user.getMunicipio());
			ps.setString(2,  user.getNombre());
			ps.setString(3,  user.getCarrera());
			ps.setInt(4,  user.getGrupo());
			ps.setInt(5,  user.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
		
	}
	public ArrayList<Usuario>fetchUsuarios(){
		ArrayList<Usuario>lista = new ArrayList<Usuario>();
		PreparedStatement ps = null;
		ResultSet rs= null;
        try {
			ps= cx.conectar().prepareStatement("SELECT *FROM usuario");
            rs = ps.executeQuery();
            while(rs.next()) {
            	Usuario u = new Usuario();
            	u.setId(rs.getInt("id"));
            	u.setCarrera(rs.getString("carrera"));
            	u.setNombre(rs.getString("nombre"));
            	u.setGrupo(rs.getInt("grupo"));
            	u.setMunicipio(rs.getString("nombre"));
            	lista.add(u);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public boolean EliminarUsuario(int Id) {
		PreparedStatement ps=null;
		try {
			ps=cx.conectar().prepareStatement("DELETE FROM usuario WHERE id=?");
			ps.setInt(1, Id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean editarUsuario(Usuario user) {
		PreparedStatement ps=null;
		try {
			ps=cx.conectar().prepareStatement("UPDATE usuario SET user=?,password=?,nombre=? WHERE id=?");
			ps.setString(1,  user.getMunicipio());
			ps.setString(2,  user.getNombre());
			ps.setInt(3,user.getId());
			ps.setString(4,  user.getCarrera());
			ps.setInt(5,  user.getGrupo());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}
