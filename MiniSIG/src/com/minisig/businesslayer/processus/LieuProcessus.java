package com.minisig.businesslayer.processus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.*;
import com.minisig.businesslayer.dao.*;
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
	public Lieu GetObject(int idLieu){
		DAO dao = null;
		Lieu lieu = null;
		dao = new LieuDAO();
		try {
			lieu = (Lieu) dao.selectObject(idLieu);
			return lieu;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
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
	public String getImageForLieu(String libelleVille){
		LieuTest dao = null;
		dao = new LieuDAO();
		try {
			return dao.getImageForLieu(libelleVille);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	
	}
	public int getIdForNameLieu(String libelleVille){
		int tempInt;
		LieuTest dao = null;
		dao = new LieuDAO();
		try {
			tempInt = dao.getIdForNameLieu(libelleVille);
			return tempInt;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}
	public void addLieu(String nameLieu, String descriptionLieu, String imageUrlLieu){
		Lieu lieuToAdd = new Lieu(nameLieu, descriptionLieu, imageUrlLieu);
		DAO dao = null;
		dao = new LieuDAO();
		try {
			dao.addObject(lieuToAdd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void removeLieu(String nameLieu){
		DAO dao = null;
		dao = new LieuDAO();
		try {
			dao.removeObject(GetObject(getIdForNameLieu(nameLieu)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateLieu(String InputNameLieu, String OutputNameLieu, String OutputDescriptionLieu, String OutputimageUrlLieu){
		Lieu lieuToUpdate = GetObject(getIdForNameLieu(InputNameLieu));
		Lieu lieuToFill = new Lieu(OutputNameLieu, OutputDescriptionLieu, OutputimageUrlLieu);
		DAO dao = null;
		dao = new LieuDAO();
		try {
			dao.updateObject(lieuToUpdate, lieuToFill);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void selectLieu(int idLieu){
		
	}
}
