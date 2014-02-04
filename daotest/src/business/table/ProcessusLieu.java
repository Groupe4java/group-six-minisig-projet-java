package business.table;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.*;
import business.modele.Lieu;
import business.processus.DAO;
import business.processus.LieuDAO;

public class ProcessusLieu {

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
			return null;
		}
	}
}
