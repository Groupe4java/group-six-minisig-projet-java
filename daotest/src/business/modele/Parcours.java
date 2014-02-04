package business.modele;

public class Parcours {

	private int idParcours;
	private String libelleParcours;
	private String descriptionParcours;
	private int idLieu;
	public Parcours(String libelleParcours, String descriptionParcours,
			int idLieu) {

		this.libelleParcours = libelleParcours;
		this.descriptionParcours = descriptionParcours;
		this.idLieu = idLieu;
	}
	public int getIdParcours() {
		return idParcours;
	}
	public void setIdParcours(int idParcours) {
		this.idParcours = idParcours;
	}
	public String getLibelleParcours() {
		return libelleParcours;
	}
	public void setLibelleParcours(String libelleParcours) {
		this.libelleParcours = libelleParcours;
	}
	public String getDescriptionParcours() {
		return descriptionParcours;
	}
	public void setDescriptionParcours(String descriptionParcours) {
		this.descriptionParcours = descriptionParcours;
	}
	public int getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}
	
}
