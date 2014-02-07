package com.minisig.businesslayer.table;

public class FaitPartie {

	private int idPoi;
	private int idParcours;
	public FaitPartie(int idPoi, int idParcours) {
		this.idPoi = idPoi;
		this.idParcours = idParcours;
	}
	public int getIdPoi() {
		return idPoi;
	}
	public void setIdPoi(int idPoi) {
		this.idPoi = idPoi;
	}
	public int getIdParcours() {
		return idParcours;
	}
	public void setIdParcours(int idParcours) {
		this.idParcours = idParcours;
	}
	
}