package business.modele;

public class Lieu {
	private int idLieu;
	private String nameLieu;
	public Lieu(String nameLieu, String descriptionLieu, String imageUrlLieu) {
		this.nameLieu = nameLieu;
		this.descriptionLieu = descriptionLieu;
		this.imageUrlLieu = imageUrlLieu;
	}
	private String descriptionLieu;
	private String imageUrlLieu;
	public int getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}
	public String getNameLieu() {
		return nameLieu;
	}
	public void setNameLieu(String nameLieu) {
		this.nameLieu = nameLieu;
	}
	public String getDescriptionLieu() {
		return descriptionLieu;
	}
	public void setDescriptionLieu(String descriptionLieu) {
		this.descriptionLieu = descriptionLieu;
	}
	public String getImageUrlLieu() {
		return imageUrlLieu;
	}
	public void setImageUrlLieu(String imageUrlLieu) {
		this.imageUrlLieu = imageUrlLieu;
	}
	public String toString(){
		return "ville :"+nameLieu+" description:" +descriptionLieu+ "";
	}
}
