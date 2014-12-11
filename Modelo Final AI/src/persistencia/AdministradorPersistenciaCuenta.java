package persistencia;

import implementacion.Banco;
import implementacion.CajaAhorro;
import implementacion.Cuenta;
import implementacion.CuentaCorriente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorPersistenciaCuenta extends AdministradorPersistencia {
	private static AdministradorPersistenciaCuenta instancia;
	
	private AdministradorPersistenciaCuenta() {
		
	}
	
	public static AdministradorPersistenciaCuenta getInstance() {
		if (instancia == null)
			instancia = new AdministradorPersistenciaCuenta();
		return instancia;
	}
	
	public List<Cuenta> buscarCuentas(){
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		try{
			Connection con = Conexion.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+super.getDatabase()+".dbo.Cuentas WHERE activo = 1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Cuenta cuenta = null;
				if (rs.getInt("tipo") == 1) {
					cuenta = new CajaAhorro(rs.getInt("numero"), rs.getFloat("saldo"), rs.getFloat("intereses"), Banco.getInstancia().buscarCliente(rs.getString("dni")));
				} else if (rs.getInt("tipo") == 2) {
					cuenta = new CuentaCorriente(rs.getInt("numero"), rs.getFloat("saldo"), rs.getFloat("descubierto"), Banco.getInstancia().buscarCliente(rs.getString("dni")));
				}
				cuentas.add(cuenta);
			}
			
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return cuentas;
	}
}
