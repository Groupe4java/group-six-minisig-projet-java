package com.minisig.businesslayer.processus;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.*;
import com.minisig.businesslayer.dao.*;

public class ParcoursProcessus {

	public List<Parcours> ListAllParcoursOfLieu(String nameLieu){
		
		ParcoursTest daoParcours =null;
		List<Parcours> parcours = new ArrayList<>();
		daoParcours = new ParcoursDAO();
		try {
			parcours = daoParcours.ListAllParcoursOfLieu(nameLieu);
			return parcours;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Parcours selectParcours(){
		return null;
	}
	public int getIdForNameParcours(String libelleParcours){
		int tempInt;
		ParcoursTest daop = null;
		daop = new ParcoursDAO();
		try {
			
			tempInt = daop.getIdForNameParcours(libelleParcours);
			return tempInt;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public void addParcours(String nameParcours, String descriptionLieu, int idLieu){
		Parcours p = new Parcours(nameParcours, descriptionLieu, idLieu);
		DAO dao = null;
		dao = new ParcoursDAO();
		try{
			dao.addObject(p);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		dao = new FaitPartieDAO();
		FaitPartie faitPartie;
		for(int i =0; i<10; i++){
			faitPartie = new FaitPartie(getIdForNameParcours(nameParcours), idLieu);
			try {
				dao.addObject(faitPartie);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void removeParcours(){
		
	}
	public void updateParcours(){
		
	}
	
}