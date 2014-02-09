package com.minisig.businesslayer.sqlmap;

public class MapParcours {

	public String mapAddParcours(){
		return "INSERT INTO tb_parcours(Libelle_Parcours, Description_Parcours, ID_Lieu) VALUES (?, ?, ?)";
	}
	public String mapRemoveParcours(){
		return "DELETE FROM tb_parcours WHERE Libelle_Parcours = ? AND Description_Parcours = ? AND ID_Lieu = ?";
	}
	public String mapUpdateParcours(){
		return "UPDATE tb_parcours SET Libelle_Parcours = ?, Description_Parcours = ? ,ID_Lieu = ? WHERE Libelle_Parcours = ? AND Description_Parcours = ? AND ID_Lieu = ?";
	}
	public String mapListAllParcours(){
		return "SELECT * FROM tb_parcours";
	}
	public String mapListAllParcoursOfLieu(){
		//New Requete (Gaetan):
		return "SELECT * FROM tb_parcours WHERE ID_Lieu = ?";
		//Ancienne requete:
		//return "SELECT tb_parcours.Libelle_Parcours, tb_parcours.Description_Parcours, tb_parcours.ID_Lieu FROM tb_lieu INNER JOIN tb_parcours ON tb_lieu.ID_Lieu = tb_parcours.ID_Lieu WHERE tb_lieu.id_Lieu = ?";
	}
	public String mapGetIdForNameParcours(){
		return "SELECT ID_Parcours FROM tb_parcours WHERE Libelle_Parcours = ?";
	}
	public String mapSelectParcours(){
		return "SELECT * FROM tb_parcours WHERE ID_Parcours = ?";
	}
}
