/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.controllers;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import biblioteca.helpers.Conexion;
import biblioteca.models.Usuario;



/**
 *
 * @author Marco
 */
public class UserManager {
   
	private Usuario usuario = null;
	private ArrayList<Usuario> listaUsuario;
	private static UserManager instancia;
	
	private UserManager() {
		listaUsuario = new ArrayList<Usuario>();
	}
	
	public static UserManager getInstancia() {
		if (instancia == null) {
			instancia = new UserManager();
		}
		return instancia;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
        
        public ArrayList<Usuario> getArrayList() {
            return listaUsuario;
        
        }
        
        public int buscarEspacioUsuario(String var0) {
		int variableRetorno = -1;
		if (1 == listaUsuario.size()) {
			int var1 = Integer.parseInt(var0);
				if (listaUsuario.get(0).getIdUsuario() == var1) {
				variableRetorno = 0;
				} else {
				//No hay ninguna coincidencia
				}
		} else if (1 < listaUsuario.size()) {
			int var1 = Integer.parseInt(var0);
			for(int numerillo=0; numerillo < listaUsuario.size(); numerillo++) {
				if (listaUsuario.get(numerillo).getIdUsuario() == var1) {
					variableRetorno = numerillo;
				
                } else {
					//No hay ninguna coincidencia;
				}
			}
		} else {
			//No hay nada ingresado;
		}
		return variableRetorno;
	}
        
        public boolean login(String var0, String var1) {
		boolean variableRetorno = false;
		if (0 < listaUsuario.size()) {
			for(int numerillo=0; numerillo < listaUsuario.size(); numerillo++) {
				if (listaUsuario.get(numerillo).getNombreUsuario().equalsIgnoreCase(var0) && listaUsuario.get(numerillo).getClaveUsuario().equalsIgnoreCase(var1)) {
					variableRetorno = true;
				
                }	//No hay nada ingresado;
		}
                }
		return variableRetorno;
	
        }
        
        public int loginRango(String var0, String var1) {
		int variableRetorno = 1; //1 visualizador, 2 editor, 3 admin
		if (1 < listaUsuario.size()) {
			for(int numerillo=0; numerillo < listaUsuario.size(); numerillo++) {
				if (listaUsuario.get(numerillo).getNombreUsuario().equals(var0) && listaUsuario.get(numerillo).getClaveUsuario().equals(var1)) {
                                    if(listaUsuario.get(numerillo).getRangoUsuario().equalsIgnoreCase("Editor")) {
                                    variableRetorno = 2;
                                    } else if(listaUsuario.get(numerillo).getRangoUsuario().equalsIgnoreCase("Administrador")) {
                                    variableRetorno = 3;
                                    }
                                    
                                    
				
                } else {
					//No hay ninguna coincidencia;
				}
			}
		} else {
			//No hay nada ingresado;
		}
		return variableRetorno;
	}
        
        
        
        
        
        
        
        
        
	public ArrayList<Usuario> getListaUsuario() {
		listaUsuario.clear();
		ResultSet resultadoUsuarios = Conexion.getInstancia().hacerConsulta("SELECT * FROM Usuario");
		if (resultadoUsuarios != null) {
			try {
				while (resultadoUsuarios.next()) {
					int idUsuario = resultadoUsuarios.getInt("idUsuario");
					String rango = resultadoUsuarios.getString("rango");
					String nombreUsuario = resultadoUsuarios.getString("nombreUsuario");
					String contrasenaUsuario = resultadoUsuarios.getString("clave");
					Usuario usuario = new Usuario(idUsuario, rango, nombreUsuario, contrasenaUsuario);
					listaUsuario.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuario;
	}
        
        
        public ArrayList<Usuario> getListaIdUsuario(String texto) {
		listaUsuario.clear();
		ResultSet resultadoUsuarios = Conexion.getInstancia().hacerConsulta("SELECT * FROM Usuario WHERE idUsuario = '" + texto + "'");
		if (resultadoUsuarios != null) {
			try {
				while (resultadoUsuarios.next()) {
					int idUsuario = resultadoUsuarios.getInt("idUsuario");
					String rango = resultadoUsuarios.getString("rango");
					String nombreUsuario = resultadoUsuarios.getString("nombreUsuario");
					String contrasenaUsuario = resultadoUsuarios.getString("clave");
					Usuario usuario = new Usuario(idUsuario, rango, nombreUsuario, contrasenaUsuario);
					listaUsuario.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuario;
	}
        
        public ArrayList<Usuario> getListaNombreUsuario(String texto) {
		listaUsuario.clear();
		ResultSet resultadoUsuarios = Conexion.getInstancia().hacerConsulta("SELECT * FROM Usuario WHERE nombreUsuario LIKE '%" + texto + "%'");
		if (resultadoUsuarios != null) {
			try {
				while (resultadoUsuarios.next()) {
					int idUsuario = resultadoUsuarios.getInt("idUsuario");
					String rango = resultadoUsuarios.getString("rango");
					String nombreUsuario = resultadoUsuarios.getString("nombreUsuario");
					String contrasenaUsuario = resultadoUsuarios.getString("clave");
					Usuario usuario = new Usuario(idUsuario, rango, nombreUsuario, contrasenaUsuario);
					listaUsuario.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuario;
	}
        
        
        
        
        
        
        
        
        
        
	public void desautenticarUsuario() {
		this.usuario = null;
	}
	
	public void agregarUsuario(Usuario usuario) {
		String tipoUsuario = usuario.getRangoUsuario();
		String nick = usuario.getNombreUsuario(); 
		String contrasena = usuario.getClaveUsuario();
		Conexion.getInstancia().ejecutarConsulta("EXEC CrearUsuario '" + nick + "', '" + tipoUsuario + "', '" + contrasena + "'");
	}
	
	public void editarUsuario(int id, String idRol, String contrasena, String nickUsuario) {
		Conexion.getInstancia().ejecutarConsulta("EXEC ModificarUsuario '" + nickUsuario + "', '" + idRol + "', '" + contrasena + "', " + id + "");
	}

	public void eliminarUsuario(int id) {
		Conexion.getInstancia().ejecutarConsulta("EXEC EliminarUsuario " + id);
		}
}


    
    
   
