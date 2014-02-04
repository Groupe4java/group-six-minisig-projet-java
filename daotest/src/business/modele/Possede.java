package business.modele;

public class Possede {

	private int idPoi;
	private int idHistorique;
	
	public Possede(int idPoi, int idHistorique) {

		this.idPoi = idPoi;
		this.idHistorique = idHistorique;
	}
	public int getIdPoi() {
		return idPoi;
	}
	public void setIdPoi(int idPoi) {
		this.idPoi = idPoi;
	}
	public int getIdHistorique() {
		return idHistorique;
	}
	public void setIdHistorique(int idHistorique) {
		this.idHistorique = idHistorique;
	}
}
