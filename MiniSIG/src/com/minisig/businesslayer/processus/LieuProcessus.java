package com.minisig.businesslayer.processus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.Lieu;
import com.minisig.businesslayer.table.Parcours;
import com.minisig.businesslayer.dao.DAO;
import com.minisig.businesslayer.dao.LieuDAO;
import com.minisig.businesslayer.dao.LieuTest;
import com.minisig.businesslayer.dao.ParcoursDAO;
import com.minisig.businesslayer.dao.ParcoursTest;

public class LieuProcessus {

	public List<Lieu> ListAllLieu(){
		DAO dao = null;
		List<Lieu> lieus = new ArrayList<>();
		dao = new LieuDAO();
		try {
			List<Object> tempObject = dao.listAllObject();
			
			for(Object e:tempObject){
				 lieus.add(new Lieu(((Lieu) e).getNameLieu(), ((Lieu) e).getDescriptionLieu(), ((Lieu) e).getImageUrlLieu()));
			}
			return lieus;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Parcours> ListAllParcoursOfLieu(int idLieu){
		
		ParcoursTest daoParcours =null;
		List<Parcours> parcours = new ArrayList<>();
		daoParcours = new ParcoursDAO();
		try {
			parcours = daoParcours.ListAllParcoursOfLieu(idLieu);
			return parcours;
		} catch (SQLException e) {
			return null;
		}
	}
	public String getImageForLieu(int idVille){
		LieuTest dao = null;
		dao = new LieuDAO();
		try {
				return dao.getImageForLieu(idVille);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	
	}
}
