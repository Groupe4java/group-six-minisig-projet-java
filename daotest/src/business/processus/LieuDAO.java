package business.processus;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dataAcess.connection.CL_ConnexionBDD;
import business.mappage.MapLieu;
import business.modele.Lieu;

public class LieuDAO extends DAO{


	public void addObject(Object o) throws SQLException {

		Connection con = new CL_ConnexionBDD().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapAddLieu());
		
		prepare.setString(1, ((Lieu) o).getNameLieu());
		prepare.setString(2, ((Lieu) o).getDescriptionLieu());
		prepare.setString(3, ((Lieu) o).getImageUrlLieu());
		prepare.execute();
		prepare.close();
		state.close();
	}

	public void removeObject(Object o) throws SQLException {
		
		Connection con = new CL_ConnexionBDD().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapLieu().mapRemoveLieu());
		
		prepare.setString(1, ((Lieu) o).getNameLieu());
		prepare.setString(2, ((Lieu) o).getDescriptionLieu());
		prepare.setString(3, ((Lieu) o).getImageUrlLieu());
		prepare.execute();
		prepare.close();
	}
	
	public void updateObject(Object input, Object output) throws SQLException{
		
		Connection con = new CL_ConnexionBDD().createConnection();
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
		
	}

	public List<Object> listAllObject() throws SQLException{
		
		List<Object> lieus = new ArrayList<>();
		Connection con = new CL_ConnexionBDD().createConnection();
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(new MapLieu().mapListAllLieu());
		while (rs.next()){
			Lieu tempObject = new Lieu(rs.getString(2), rs.getString(3), rs.getString(4));
			lieus.add((Object)tempObject);
		}
		return lieus;
	}

	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
