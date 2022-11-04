package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			ps.setString(1,  user.getUser());
			ps.setString(2,  user.getPassword());
			ps.setString(3,  user.getNombre());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
		
	}
}
