package com.minisig.dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {
	private Connection con;
	private String DriverName = "com.mysql.jdbc.Driver";
	private String bddUrl = "jdbc:mysql://localhost/projet";
	public DataAccess(){		
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
			this.con = DriverManager.getConnection(this.bddUrl, "root", "");
		} 
		catch(SQLException e){
			throw new RuntimeException("erreur dans l'obtention de la connexion --le prog va s'arrêter");
		}
		return con;
	}
}
