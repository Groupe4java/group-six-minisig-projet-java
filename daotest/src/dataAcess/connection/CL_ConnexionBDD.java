package dataAcess.connection;

import java.sql.*;

public class CL_ConnexionBDD {
	private Connection con;
	private String DriverName = "com.mysql.jdbc.Driver";
	private String bddUrl = "jdbc:mysql://localhost/dbprojet";
	public CL_ConnexionBDD(){
		

		
	}
	public Connection createConnection(){

		try{
			Class.forName(this.DriverName);	
		}
		catch(ClassNotFoundException cnfe){
		    System.out.println("La classe "+this.DriverName+" n'a pas été trouvée");
		    cnfe.printStackTrace();	
		}

		try{
			this.con = DriverManager.getConnection(this.bddUrl, "root", "root");
		} 
		catch(SQLException e){
			throw new RuntimeException("erreur dans l'obtention de la connexion --le prog va s'arrêter");
		}
		return con;
	}

}
