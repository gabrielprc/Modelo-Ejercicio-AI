package persistencia;


public abstract class AdministradorPersistencia {
	private static String database = "";
	
	public String getDatabase() {
		return AdministradorPersistencia.database;
	}
}
