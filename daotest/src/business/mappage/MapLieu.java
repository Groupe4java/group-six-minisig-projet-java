package business.mappage;

public class MapLieu {
	public String mapAddLieu(){
		return "INSERT INTO tb_lieu(Libelle_Lieu, Description_Lieu, Image_Lieu) VALUES(?, ?, ?)";
	}
	public String mapRemoveLieu(){
		return "DELETE FROM tb_lieu WHERE Libelle_Lieu = ? AND Description_Lieu = ? AND Image_Lieu = ?";
	}
	public String mapUpdateLieu(){
		return "UPDATE tb_lieu SET Libelle_Lieu = ?, Description_Lieu = ?, Image_Lieu = ? WHERE Libelle_Lieu = ? AND Description_Lieu = ? AND Image_Lieu = ?";
	}
	public String mapSelectLieu(){
		return "";
	}
	public String mapSelectImageLieu(){
		return "SELECT Image_Lieu FROM tb_lieu WHERE ID_Lieu = ?";
	}
	public String mapListAllLieu(){
		return "SELECT * FROM tb_lieu";
	}
}



