package com.minisig.businesslayer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.Poi;
import com.minisig.businesslayer.sqlmap.MapPoi;
import com.minisig.dataaccesslayer.*;

public class PoiDAO implements DAO{

public Object selectObject() throws SQLException {
		
		return null;
	}
	
	public void addObject(Object o) throws SQLException {
		
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPoi().mapAddPoi());
		
		prepare.setString(1, ((Poi) o).getLibellePOI());
		prepare.setString(2, ((Poi) o).getDescriptionPOI());
		prepare.setInt(3, ((Poi) o).getXPOI());
		prepare.setInt(4, ((Poi) o).getYPOI());
		prepare.setInt(5, ((Poi) o).getNombreclicPOI());
		prepare.setInt(6, ((Poi) o).getIdLieu());
		prepare.execute();
		prepare.close();
		state.close();
		
	}


	public void removeObject(Object o) throws SQLException {
		
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPoi().mapRemovePoi());
		
		prepare.setString(1, ((Poi) o).getLibellePOI());
		prepare.setString(2, ((Poi) o).getDescriptionPOI());
		prepare.setInt(3, ((Poi) o).getXPOI());
		prepare.setInt(4, ((Poi) o).getYPOI());
		prepare.setInt(5, ((Poi) o).getNombreclicPOI());
		prepare.setInt(6, ((Poi) o).getIdLieu());
		prepare.execute();
		prepare.close();
		state.close();
	}


	public void updateObject(Object input, Object output) throws SQLException {
		
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPoi().mapUpdatePoi());
		
		prepare.setString(1, ((Poi) output).getLibellePOI());
		prepare.setString(2, ((Poi) output).getDescriptionPOI());
		prepare.setInt(3, ((Poi) output).getXPOI());
		prepare.setInt(4, ((Poi) output).getYPOI());
		prepare.setInt(5, ((Poi) output).getNombreclicPOI());
		prepare.setInt(6, ((Poi) output).getIdLieu());
		
		prepare.setString(7, ((Poi) input).getLibellePOI());
		prepare.setString(8, ((Poi) input).getDescriptionPOI());
		prepare.setInt(9, ((Poi) input).getXPOI());
		prepare.setInt(10, ((Poi) input).getYPOI());
		prepare.setInt(11, ((Poi) input).getNombreclicPOI());
		prepare.setInt(12, ((Poi) input).getIdLieu());
		
		prepare.execute();
		prepare.close();
		state.close();
		
	}

	public List<Object> listAllObject() throws SQLException {
		
		List<Object> poi = new ArrayList<>();
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(new MapPoi().mapListAllPoi());
		while (rs.next()){
			Poi tempObject = new Poi(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
			poi.add((Object)tempObject);
		}
		state.close();
		return poi;
	}


	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
