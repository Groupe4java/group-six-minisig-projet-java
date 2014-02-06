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
	public void addListPoiForParcours(String lieu){
		
	}
	public Poi selectPoi(){
		return null;
	}
	public void addPoi(String namePoi, String descriptionPoi, int xPos, int yPos, int nbClic, int idLieu){
		DAO dao=null;
		dao = new PoiDAO();
		Poi p = new Poi(namePoi, descriptionPoi, xPos, yPos, nbClic, idLieu);
		try{
			dao.addObject(p);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void removePoi(int idPoi, String namePoi, String descriptionPoi, int xPos, int yPos, int nbClic, int idLieu){
		DAO dao=null;
		dao = new PoiDAO();
		
		Poi p = new Poi(idPoi, namePoi, descriptionPoi, xPos, yPos, nbClic, idLieu);
		try{
			dao.removeObject(p);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updatePoi(){
		
	}
	
}
