package com.minisig.businesslayer.sqlmap;

public class MapParcours {

	public String mapAddParcours(){
		return "INSERT INTO tb_parcours(Libelle_Parcours, Description_Parcours, ID_Lieu) VALUES (?, ?, ?)";
	}
	public String mapRemoveParcours(){
		return "DELETE FROM tb_parcours WHERE Libelle_Parcours = ? AND Description_Parcours = ? AND ID_Lieu = ?";
	}
	public String mapUpdateParcours(){
		return "UPDATE tb_poi SET Libelle_Parcours = ?, Description_Parcours = ? ,ID_Lieu = ? WHERE Libelle_Parcours = ? AND Description_Parcours = ? AND ID_Lieu = ?";
	}
	public String mapListAllParcours(){
		return "SELECT * FROM tb_parcours";
	}
	public String mapListAllParcoursOfLieu(){
		return "SELECT tb_parcours.Libelle_Parcours FROM tb_lieu INNER JOIN tb_parcours ON tb_lieu.ID_Lieu = tb_parcours.ID_Lieu WHERE tb_lieu.ID_Lieu = ?";
	}
}
