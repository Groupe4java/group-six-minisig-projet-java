package business.processus;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dataAcess.connection.CL_ConnexionBDD;
import business.mappage.MapParcours;
import business.modele.Parcours;

public class ParcoursDAO extends DAO{


	public void addObject(Object o) throws SQLException {
		Connection con = new CL_ConnexionBDD().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapParcours().mapAddParcours());
		
		prepare.setString(1, ((Parcours) o).getLibelleParcours());
		prepare.setString(2, ((Parcours) o).getDescriptionParcours());
		prepare.setInt(3, ((Parcours) o).getIdLieu());
		prepare.execute();
		prepare.close();
		state.close();
		
	}

	public void removeObject(Object o) throws SQLException {
		Connection con = new CL_ConnexionBDD().createConnection();
		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement prepare = con.prepareStatement(new MapParcours().mapRemoveParcours());
		
		prepare.setString(1, ((Parcours) o).getLibelleParcours());
		prepare.setString(2, ((Parcours) o).getDescriptionParcours());
		prepare.setInt(3, ((Parcours) o).getIdLieu());
		prepare.execute();
		prepare.close();
		state.close();
		
	}

	public void updateObject(Object input, Object output) throws SQLException {
		Connection con = new CL_ConnexionBDD().createConnection();
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

	public List<Object> listAllObject() throws SQLException {
		List<Object> parcours = new ArrayList<>();
		Connection con = new CL_ConnexionBDD().createConnection();
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(new MapParcours().mapListAllParcours());
		while (rs.next()){
			Parcours tempObject = new Parcours(rs.getString(2), rs.getString(3), rs.getInt(4));
			parcours.add((Object) tempObject);
		}
		
		return parcours;
	}

	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
