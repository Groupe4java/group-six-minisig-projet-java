package com.minisig.businesslayer.table;

public class Poi {

	private int idPOI;
	private String libellePOI;
	private String descriptionPOI;
	private String imagePOI;
	private int xPOI;
	private int yPOI;
	private int nombreclicPOI;
	private int idLieu;
	public int getIdPOI() {
		return idPOI;
	}
	public void setIdPOI(int idPOI) {
		this.idPOI = idPOI;
	}
	public String getLibellePOI() {
		return libellePOI;
	}
	public void setLibellePOI(String libellePOI) {
		this.libellePOI = libellePOI;
	}
	public String getDescriptionPOI() {
		return descriptionPOI;
	}
	public void setDescriptionPOI(String descriptionPOI) {
		this.descriptionPOI = descriptionPOI;
	}
	
	public String getImagePOI() {
		return imagePOI;
	}
	public void setImagePOI(String imagePOI) {
		this.imagePOI = imagePOI;
	}
	
	public int getXPOI() {
		return xPOI;
	}
	public void setXPOI(int xPOI) {
		this.xPOI = xPOI;
	}
	public int getYPOI() {
		return yPOI;
	}
	public void setYPOI(int yPOI) {
		this.yPOI = yPOI;
	}
	public int getNombreclicPOI() {
		return nombreclicPOI;
	}
	public void setNombreclicPOI(int nombreclicPOI) {
		this.nombreclicPOI = nombreclicPOI;
	}
	public int getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}
	public Poi(int idPoi, String libellePOI, String descriptionPOI, String imagePOI, int xPOI, int yPOI,
			int nombreclicPOI, int idLieu) {
		this.idPOI = idPoi;
		this.libellePOI = libellePOI;
		this.descriptionPOI = descriptionPOI;
		this.imagePOI = imagePOI;
		this.xPOI = xPOI;
		this.yPOI = yPOI;
		this.nombreclicPOI = nombreclicPOI;
		this.idLieu = idLieu;
	}
	public Poi(String libellePOI, String descriptionPOI, String imagePOI, int xPOI, int yPOI,
			int nombreclicPOI, int idLieu) {
	
		this.libellePOI = libellePOI;
		this.descriptionPOI = descriptionPOI;
		this.imagePOI = imagePOI;
		this.xPOI = xPOI;
		this.yPOI = yPOI;
		this.nombreclicPOI = nombreclicPOI;
		this.idLieu = idLieu;
	}
}
