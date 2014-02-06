package com.minisig.businesslayer.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.minisig.businesslayer.table.FaitPartie;
import com.minisig.businesslayer.table.Lieu;
import com.minisig.businesslayer.sqlmap.MapFaitPartie;
import com.minisig.businesslayer.sqlmap.MapLieu;
import com.minisig.dataaccesslayer.DataAccess;

public class FaitPartieDAO implements DAO<FaitPartie>{

	public FaitPartie selectObject() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void addObject(FaitPartie f) throws SQLException {
		Connection con = DataAccess.getInstance();
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapAddLieu());
		prepare.execute();
		prepare.close();	
	}

	public void removeObject(FaitPartie f) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void updateObject(FaitPartie o, FaitPartie i) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<FaitPartie> listAllObject() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
