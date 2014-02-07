package com.minisig.businesslayer.processus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.*;
import com.minisig.businesslayer.dao.*;

public class PoiProcessus {

	public List<Poi> listAllPoiForLieu(int idLieu){
		List<Poi> pois = new ArrayList<>();
		PoiTest dao = null;
		dao = new PoiDAO();
		try{
			pois = dao.ListAllPoiOfLieu(idLieu);
			return pois;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean checkPoiForParcours(int idParcours, int idPoi){
		boolean exist;
		PoiTest dao = null;
		dao = new PoiDAO();
		try{
			exist = dao.checkPoiIntoParcours(idParcours, idPoi);
			return exist;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	public Poi selectPoi(int id){
		
		DAO dao = null;
		dao = new PoiDAO();
		try{
			Poi pois = (Poi) dao.selectObject(id);
			return pois;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	public void addPoi(String namePoi, String descriptionPoi, String imagePoi, int xPos, int yPos, int nbClic, int idLieu){
		DAO dao=null;
		dao = new PoiDAO();
		Poi p = new Poi(namePoi, descriptionPoi, imagePoi, xPos, yPos, nbClic, idLieu);
		try{
			dao.addObject(p);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void removePoi(int idPoi, String namePoi, String descriptionPoi, String imagePoi, int xPos, int yPos, int nbClic, int idLieu){
		DAO dao=null;
		dao = new PoiDAO();
		
		Poi p = new Poi(idPoi, namePoi, descriptionPoi, imagePoi, xPos, yPos, nbClic, idLieu);
		try{
			dao.removeObject(p);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updatePoi(int inputIdPoi, String inputNamePoi, String inputDescriptionPoi, String inputImagePoi, int inputXPos, int inputYPos, int InputNbClic, int InputidLieu,
			int outputIdPoi, String outputNamePoi, String outputDescriptionPoi,  String outputImagePoi, int outputXPos, int outputYPos, int outputNbClic, int outputidLieu){
		DAO dao=null;
		dao = new PoiDAO();
		Poi poiToUpdate = new Poi(inputIdPoi, inputNamePoi, inputDescriptionPoi, inputImagePoi, inputXPos, inputYPos, InputNbClic, InputidLieu);
		Poi poiToFill = new Poi(outputIdPoi, outputNamePoi, outputDescriptionPoi, outputImagePoi, outputXPos, outputYPos, outputNbClic, outputidLieu);
		try{
			dao.updateObject(poiToUpdate, poiToFill);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
