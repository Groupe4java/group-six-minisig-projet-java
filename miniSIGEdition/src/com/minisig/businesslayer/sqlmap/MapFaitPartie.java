package com.minisig.businesslayer.sqlmap;

public class MapFaitPartie {

        public String mapAddFaitPartie(){
                return "INSERT INTO fait_partie (ID_POI, ID_Parcours) VALUES (?,?)";
        }
        public String mapRemoveFaitPartie(){
                return "DELETE FROM `fait_partie` WHERE ID_Parcours = ? AND ID_POI = ?";
        }
        public String mapUpdateFaitPartie(){
                return "UPDATE fait_partie SET ID_POI = ?, ID_Parcours = ? WHERE ID_POI= ? and ID_Parcours = ?";
        }
        public String mapSelectFaitPartieForParcours(){
                return "SELECT * FROM fait_partie WHERE ID_Parcours = ? ";
        }
        public String mapSelectFaitPartieForPoi(){
    		return "SELECT * FROM fait_partie WHERE ID_POI = ?";
    	}
        
}
