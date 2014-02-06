package com.minisig.businesslayer.sqlmap;

public class MapPoi {

	public String mapAddPoi(){
		return "INSERT INTO tb_poi(Libelle_POI, Description_POI, X_POI, Y_POI, NombreClic_POI, ID_Lieu) VALUES(?, ?, ?, ?, ?, ?)";
	}
	public String mapRemovePoi(){
		return "DELETE FROM tb_poi WHERE Libelle_POI = ? AND Description_POI = ? AND X_POI = ? AND Y_POI = ?, NombreClic_POI = ?, ID_Lieu = ?";
	}
	public String mapUpdatePoi(){
		return "UPDATE tb_poi SET Libelle_POI = ? AND Description_POI = ? AND X_POI = ? AND Y_POI = ?, NombreClic_POI = ?, ID_Lieu = ? WHERE Libelle_POI = ? AND Description_POI = ? AND X_POI = ? AND Y_POI = ?, NombreClic_POI = ?, ID_Lieu = ?";
	}
	public String mapSelectPoi(){
		return "SELECT * FROM tb_poi WHERE ID_POI = ?";
	}
	public String mapListAllPoiOfLieu(){
		return "SELECT * FROM tb_poi WHERE ID_Lieu = ?";
	}
	public String mapGetExistencePoiInParcours(){
		return "SELECT * FROM fait_partie WHERE ID_Parcours = ? AND ID_POI = ?";
	}
}
