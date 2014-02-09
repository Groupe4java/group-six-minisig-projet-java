package com.minisig.businesslayer.processus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.*;
import com.minisig.businesslayer.dao.*;
public class LieuProcessus {

        public List<Lieu> ListAllLieu(){
                DAO<Lieu> dao = null;
                List<Lieu> lieus = new ArrayList<>();
                dao = new LieuDAO();
                try {
                        lieus = dao.listAllObject();
                        return lieus;
                } 
                catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                }
        }
        public Lieu getObject(int idLieu){
                DAO<Lieu> dao = null;
                Lieu lieu = null;
                dao = new LieuDAO();
                try {
                        lieu = dao.selectObject(idLieu);
                        return lieu;
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                }
        }
        public List<Parcours> ListAllParcoursOfLieu(int idLieu){
                
                ParcoursTest daoParcours =null;
                List<Parcours> parcours = new ArrayList<>();
                daoParcours = new ParcoursDAO();
                try {
                        parcours = daoParcours.ListAllParcoursOfLieu(idLieu);
                        return parcours;
                } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                }
        }
        public String getImageForLieu(String libelleVille){
                LieuTest dao = null;
                dao = new LieuDAO();
                try {
                        return dao.getImageForLieu(libelleVille);
                } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                }

        
        }
        public int getIdForNameLieu(String libelleVille){
                int tempInt;
                DAO<Lieu> dao = null;
                dao = new LieuDAO();
                try {
                        tempInt = dao.getIdForNameObject(libelleVille);
                        return tempInt;
                } catch (SQLException e) {
                        e.printStackTrace();
                        return 0;
                }

        }
        public void addLieu(String nameLieu, String descriptionLieu, String imageUrlLieu){
                Lieu lieuToAdd = new Lieu(nameLieu, descriptionLieu, imageUrlLieu);
                DAO<Lieu> dao = null;
                dao = new LieuDAO();
                try {
                        dao.addObject(lieuToAdd);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        public void removeLieu(String nameLieu, int idLieu){
            List<Parcours> parcoursToDelete = new ArrayList<>();
            List<Poi> poisToDelete = new ArrayList<>();
            List<FaitPartie> faitPartieToDelete = new ArrayList<>();
            DAO<Lieu> dao = null;
            DAO<FaitPartie> daoFP = null;
            FaitPartieTest FPObtentionList = null;
            FPObtentionList = new FaitPartieDAO();
            daoFP = new FaitPartieDAO();
            dao = new LieuDAO();
            ParcoursProcessus parcoursProc = new ParcoursProcessus();
            PoiProcessus poisProc = new PoiProcessus();
            
            parcoursToDelete = parcoursProc.ListAllParcoursOfLieu(idLieu);
            for(Parcours p: parcoursToDelete){
            	parcoursProc.removeParcours(p.getLibelleParcours());
            }            
            //Remove POI NEED ID_LIEU
            poisToDelete = poisProc.listAllPoiForLieu(getIdForNameLieu(nameLieu));
            for(Poi pois: poisToDelete){
                    poisProc.removePoi(pois.getIdPOI());
            }
            
            //Remove Lieu
                   
            try {
                    dao.removeObject(getObject(getIdForNameLieu(nameLieu)));
            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }

        
        public void updateLieu(int InputIdLieu, String outputLibelleLieu, String outputDescriptionLieu, String outputImageLieu){
                Lieu lieuToUpdate = getObject(InputIdLieu);
                Lieu lieuToFill = new Lieu(outputLibelleLieu, outputDescriptionLieu, outputImageLieu);
                DAO<Lieu> dao = null;
                dao = new LieuDAO();
                try {
                        dao.updateObject(lieuToUpdate, lieuToFill);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

}
