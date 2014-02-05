package com.minisig.businesslayer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.minisig.dataaccesslayer.*;
import com.minisig.businesslayer.sqlmap.MapLieu;
import com.minisig.businesslayer.table.Lieu;

public class LieuDAO implements DAO<Lieu>, LieuTest {

	public void addObject(Lieu o) throws SQLException {

		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapAddLieu());
		
		prepare.setString(1, ((Lieu) o).getNameLieu());
		prepare.setString(2, ((Lieu) o).getDescriptionLieu());
		prepare.setString(3, ((Lieu) o).getImageUrlLieu());
		prepare.execute();
		prepare.close();
		state.close();
	}

	public void removeObject(Lieu o) throws SQLException {
		
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapRemoveLieu());
		
		prepare.setString(1, ((Lieu) o).getNameLieu());
		prepare.setString(2, ((Lieu) o).getDescriptionLieu());
		prepare.setString(3, ((Lieu) o).getImageUrlLieu());
		prepare.execute();
		prepare.close();
		state.close();
	}
	
	public void updateObject(Lieu input, Lieu output) throws SQLException{
		
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapUpdateLieu());
		
		prepare.setString(1, ((Lieu) output).getNameLieu());
		prepare.setString(2, ((Lieu) output).getDescriptionLieu());
		prepare.setString(3, ((Lieu) output).getImageUrlLieu());
		
		prepare.setString(4, ((Lieu) input).getNameLieu());
		prepare.setString(5, ((Lieu) input).getDescriptionLieu());
		prepare.setString(6, ((Lieu) input).getImageUrlLieu());
		
		prepare.execute();
		prepare.close();
		state.close();
		
	}

	public List<Lieu> listAllObject() throws SQLException{
		
		List<Lieu> lieus = new ArrayList<>();
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(new MapLieu().mapListAllLieu());
		while (rs.next()){
			Lieu tempObject = new Lieu(rs.getString(2), rs.getString(3), rs.getString(4));
			lieus.add(tempObject);
		}
		return lieus;
	}
	public String getImageForObject(int idOjbect) throws SQLException {
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapSelectImageLieu());
		
		prepare.setInt(1, idOjbect);

		ResultSet rs = prepare.executeQuery();
		prepare.close();
		state.close();
		
		return rs.getString(1);
	}
	
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lieu selectObject() throws SQLException {
		
		int x = 0;
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapAddLieu());
		
		prepare.setInt(1, x);
		ResultSet rs = prepare.executeQuery();
		prepare.close();
		state.close();
		return new Lieu(rs.getString(1), rs.getString(2), rs.getString(3));
	}

	@Override
	public String getImageForLieu(String nameObject) throws SQLException {
		Connection con = new DataAccess().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapSelectImageLieu());
		
		prepare.setString(1, nameObject);

		ResultSet rs = prepare.executeQuery();
		prepare.close();
		state.close();
		
		return rs.getString(1);
	}
}
