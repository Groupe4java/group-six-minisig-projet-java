package com.minisig.dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataAccess {

	private static Connection connect;
	private static String DriverName = "com.mysql.jdbc.Driver";
	private static String bddUrl = "jdbc:mysql://localhost/minisig";
	private static String user = "root";
	private static String psswd = "";

	private DataAccess() throws SQLException{
		try{
			Class.forName(DriverName);	
		}
		catch(ClassNotFoundException cnfe){
		    System.out.println("La classe "+DriverName+" n'a pas �t� trouv�e");
		    cnfe.printStackTrace();	
		}
		connect = DriverManager.getConnection(bddUrl, user, psswd);
	}
	public static Connection getInstance(){
		if(connect == null){
			try{
				new DataAccess();
			} 
			catch(SQLException e){
				System.out.println("Erreur dans l'obtention de la connexion � la base de donn�es");
				e.printStackTrace();
			}
		}
		return connect;
	}
}
