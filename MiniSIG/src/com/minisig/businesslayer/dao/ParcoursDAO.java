package com.minisig.businesslayer.dao;

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.Parcours;
import com.minisig.businesslayer.sqlmap.MapParcours;
import com.minisig.dataaccesslayer.*;

public class ParcoursDAO implements DAO<Parcours>, ParcoursTest{

	public void addObject(Parcours o) throws SQLException {
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapParcours().mapAddParcours());
		
		prepare.setString(1, ((Parcours) o).getLibelleParcours());
		prepare.setString(2, ((Parcours) o).getDescriptionParcours());
		prepare.setInt(3, ((Parcours) o).getIdLieu());
		prepare.execute();
		prepare.close();
		state.close();
		
	}

	public void removeObject(Parcours o) throws SQLException {
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapParcours().mapRemoveParcours());
		
		prepare.setString(1, ((Parcours) o).getLibelleParcours());
		prepare.setString(2, ((Parcours) o).getDescriptionParcours());
		prepare.setInt(3, ((Parcours) o).getIdLieu());
		prepare.execute();
		prepare.close();
		state.close();
		
	}

	public void updateObject(Parcours input, Parcours output) throws SQLException {
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapParcours().mapUpdateParcours());
		
		prepare.setString(1, ((Parcours) output).getLibelleParcours());
		prepare.setString(2, ((Parcours) output).getDescriptionParcours());
		prepare.setInt(3, ((Parcours) output).getIdLieu());
		
		prepare.setString(4, ((Parcours) input).getLibelleParcours());
		prepare.setString(5, ((Parcours) input).getDescriptionParcours());
		prepare.setInt(6, ((Parcours) input).getIdLieu());
		
		prepare.execute();
		prepare.close();
		state.close();
		
	}

	public List<Parcours> listAllObject() throws SQLException {
		List<Parcours> parcours = new ArrayList<>();
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(new MapParcours().mapListAllParcours());
		while (rs.next()){
			Parcours tempObject = new Parcours(rs.getString(2), rs.getString(3), rs.getInt(4));
			parcours.add(tempObject);
		}
		
		return parcours;
	}

	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public Parcours selectObject() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Parcours> ListAllParcoursOfLieu(int idObject) throws SQLException {
		List<Parcours> parcours = new ArrayList<>();
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement();
		PreparedStatement prepare = con.prepareStatement(new MapParcours().mapListAllParcoursOfLieu());
		prepare.setInt(1, idObject);
		ResultSet rs = prepare.executeQuery();
		while(rs.next()){
			Parcours tempParcours = new Parcours(rs.getString(2), rs.getString(3), rs.getInt(4));
			parcours.add(tempParcours);
		}
		
		return parcours;
	}
}
