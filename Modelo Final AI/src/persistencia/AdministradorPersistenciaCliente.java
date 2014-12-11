package persistencia;

import implementacion.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorPersistenciaCliente extends AdministradorPersistencia {
	private static AdministradorPersistenciaCliente instancia;
	
	private AdministradorPersistenciaCliente() {
		
	}
	
	public static AdministradorPersistenciaCliente getInstance() {
		if (instancia == null)
			instancia = new AdministradorPersistenciaCliente();
		return instancia;
	}
	
	public List<Cliente> buscarClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
			
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Clientes WHERE activo = 1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Cliente cliente = new Cliente(rs.getString("dni"), rs.getString("nombre"));
				clientes.add(cliente);
			}		
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return clientes;
	}
}
