package business.mappage;

public class MapPOI {
	
	public String mapAddPOI(){
		return "INSERT INTO tb_poi(Libelle_POI, Description_POI, X_POI, Y_POI, NombreClic_POI, ID_Lieu) VALUES(?, ?, ?, ?, ?, ?)";
	}
	public String mapRemovePOI(){
		return "DELETE FROM tb_poi WHERE Libelle_POI = ? AND Description_POI = ? AND X_POI = ? AND Y_POI = ?, NombreClic_POI = ?, ID_Lieu = ?";
	}
	public String mapUpdatePOI(){
		return "UPDATE tb_poi SET Libelle_POI = ? AND Description_POI = ? AND X_POI = ? AND Y_POI = ?, NombreClic_POI = ?, ID_Lieu = ? WHERE Libelle_POI = ? AND Description_POI = ? AND X_POI = ? AND Y_POI = ?, NombreClic_POI = ?, ID_Lieu = ?";
	}
	public String mapSelectLieu(){
		return "";
	}
	public String mapListAllPOI(){
		return "SELECT * FROM tb_poi";
	}

}
