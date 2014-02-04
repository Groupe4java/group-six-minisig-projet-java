package ihm.mainframe;
import java.sql.SQLException;
import java.util.List;


import business.*;
import business.modele.Lieu;
import business.processus.DAO;
import business.processus.LieuDAO;

public class MainFrame {

	public static void main(String[] args) {


		DAO dao = null;
		dao = new LieuDAO();
		try {
			List<Object> Llieu = dao.listAllObject();
			for(Object o : Llieu){
				System.out.println(o); 
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
