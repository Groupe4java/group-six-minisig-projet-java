package com.minisig.businesslayer.processus;
import com.minisig.businesslayer.dao.*;
import com.minisig.businesslayer.table.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
	}
	public void removeParcours(){
		
	}
	public void updateParcours(){
		
	}
	
}
