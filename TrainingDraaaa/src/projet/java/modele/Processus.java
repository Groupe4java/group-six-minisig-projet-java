package projet.java.modele;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Processus {

	Maquettage oMaq;
	
	public void m_AffichageResultQuery()
	{
		oMaq = new Maquettage();
		ResultSet oResultSet = oMaq.m_SelectTable();
		
		try{
		ResultSetMetaData oRSMetaData = oResultSet.getMetaData();
		System.out.println("\nWESH");
			while(oResultSet.next())
			{
				for (int i = 1; i <= oRSMetaData.getColumnCount(); i++)
				{
					System.out.print(oResultSet.getString(i) + " ");
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Bug Dans Processus");
		}
	}
}
