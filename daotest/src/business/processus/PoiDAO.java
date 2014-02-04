package business.processus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.mappage.MapLieu;
import business.mappage.MapPOI;
import business.modele.Lieu;
import business.modele.Poi;
import dataAcess.connection.CL_ConnexionBDD;

public class PoiDAO extends DAO{

	@Override
	public void addObject(Object o) throws SQLException {
		
		Connection con = new CL_ConnexionBDD().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPOI().mapAddPOi());
		
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

	@Override
	public void removeObject(Object o) throws SQLException {
		
		Connection con = new CL_ConnexionBDD().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapPOI().mapRemovePOi());
		
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

	@Override
	public void updateObject(Object o, Object i) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> listAllObject() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
