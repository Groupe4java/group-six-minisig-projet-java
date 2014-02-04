package com.minisig.businesslayer.processus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.Lieu;
import com.minisig.businesslayer.dao.DAO;
import com.minisig.businesslayer.dao.LieuDAO;

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
//	public String getImageForLieu(int idVille){
//		InterfaceTest dao = null;
//		dao = new LieuDAO();
//		try {
//				return dao.getImageForObject(idVille);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//
//	
//	}
}
