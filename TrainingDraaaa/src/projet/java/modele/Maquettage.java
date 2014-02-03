package projet.java.modele;

import java.sql.ResultSet;

import projet.java.cad.ConnexionBDD;

public class Maquettage {

	ConnexionBDD oCBDD;
	
	public ResultSet m_SelectTable()
	{
		oCBDD = new ConnexionBDD();
		
		String requete = "SELECT * FROM TrainingTable";
		oCBDD.m_Connexion();
		return oCBDD.m_ExecuteSelect(requete, oCBDD.m_Connexion());
	}
}
