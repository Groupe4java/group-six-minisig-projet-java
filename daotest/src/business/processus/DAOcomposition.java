package business.processus;
import java.sql.*;
import java.util.List;

import business.modele.*;
public interface DAOcomposition {

	public List<Poi> ListAllPoiOfParcours() throws SQLException;
	public List<Poi> listAllPoiOfLieu() throws SQLException;
}
