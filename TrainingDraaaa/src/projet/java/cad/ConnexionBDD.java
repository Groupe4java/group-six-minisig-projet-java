package projet.java.cad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBDD {
	
	public Connection m_Connexion()
	{
		String oUrl = "jdbc:mysql://localhost/TrainingBDD";
		String oLogin = "root";
		String oPassword = "";
		Connection oConnection = null;
		
		try{
		oConnection = DriverManager.getConnection(oUrl,oLogin,oPassword);
		System.out.println("Connexion Done.");
		
		}
		catch (Exception e)
		{
			System.out.println("Connexion Erreur.");
		}
		
		return oConnection;
	}
	
	public ResultSet m_ExecuteSelect(String oRequete, Connection oConnection)
	{
		ResultSet oResultSet = null;
		Statement oStatement;
		
		try{
		oStatement = oConnection.createStatement();
		oResultSet = oStatement.executeQuery(oRequete);
		}
		catch (SQLException e) {
			
		}
		return oResultSet;
	}
}