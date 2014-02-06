package com.minisig.businesslayer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.Poi;
import com.minisig.businesslayer.sqlmap.MapPoi;
import com.minisig.dataaccesslayer.*;

public class PoiDAO implements DAO<Poi>, PoiTest{

public Poi selectObject() throws SQLException {
		
		return null;
	}
	
	public void addObject(Poi o) throws SQLException {
		
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPoi().mapAddPoi());
		
		prepare.setString(1, o.getLibellePOI());
		prepare.setString(2, o.getDescriptionPOI());
		prepare.setInt(3, o.getXPOI());
		prepare.setInt(4, o.getYPOI());
		prepare.setInt(5, o.getNombreclicPOI());
		prepare.setInt(6, o.getIdLieu());
		prepare.execute();
		prepare.close();
		state.close();
		
	}


	public void removeObject(Poi o) throws SQLException {
		
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPoi().mapRemovePoi());
		
		prepare.setString(1, o.getLibellePOI());
		prepare.setString(2, o.getDescriptionPOI());
		prepare.setInt(3, o.getXPOI());
		prepare.setInt(4, o.getYPOI());
		prepare.setInt(5, o.getNombreclicPOI());
		prepare.setInt(6, o.getIdLieu());
		prepare.execute();
		prepare.close();
		state.close();
	}


	public void updateObject(Poi input, Poi output) throws SQLException {
		
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPoi().mapUpdatePoi());
		
		prepare.setString(1, output.getLibellePOI());
		prepare.setString(2, output.getDescriptionPOI());
		prepare.setInt(3, output.getXPOI());
		prepare.setInt(4, output.getYPOI());
		prepare.setInt(5, output.getNombreclicPOI());
		prepare.setInt(6, output.getIdLieu());
		
		prepare.setString(7, input.getLibellePOI());
		prepare.setString(8, input.getDescriptionPOI());
		prepare.setInt(9, input.getXPOI());
		prepare.setInt(10, input.getYPOI());
		prepare.setInt(11, input.getNombreclicPOI());
		prepare.setInt(12, input.getIdLieu());
		
		prepare.execute();
		prepare.close();
		state.close();
		
	}

	public List<Poi> listAllObject() throws SQLException {
		
		List<Poi> poi = new ArrayList<>();
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(new MapPoi().mapListAllPoiOfLieu());
		while (rs.next()){
			Poi tempObject = new Poi(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
			poi.add(tempObject);
		}
		state.close();
		return poi;
	}


	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Poi> ListAllPoiOfLieu(int idLieu) throws SQLException {

		List<Poi> poi = new ArrayList<>();
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPoi().mapListAllPoiOfLieu());
		prepare.setInt(1, idLieu);	
		ResultSet rs = prepare.executeQuery();	
		while (rs.next()){
			Poi tempObject = new Poi(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
			poi.add(tempObject);
		}
		state.close();
		return poi;
	}

	@Override
	public List<Poi> ListAllPoiOfParcours(String Parcours) throws SQLException {
		List<Poi> poi = new ArrayList<>();
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPoi().mapListAllPoiOfLieu());
		prepare.setString(1, Parcours);		
		ResultSet rs = prepare.executeQuery();	
		while (rs.next()){
			Poi tempObject = new Poi(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
			poi.add(tempObject);
		}
		state.close();
		return poi;
	}
}
