package com.minisig.businesslayer.sqlmap;

public class MapFaitPartie {

	public String mapAddFaitPartie(){
		return "INSERT INTO fait_partie (ID_POI, ID_Parcours) VALUES (?,?)";
	}
	public String mapRemoveFaitPartie(){
		return "DELETE FROM `fait_partie` WHERE ID_Parcours = ?";
	}
	
}
