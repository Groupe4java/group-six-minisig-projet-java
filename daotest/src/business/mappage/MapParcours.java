package business.mappage;

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
}
