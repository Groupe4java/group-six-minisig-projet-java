package com.minisig.businesslayer.processus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.*;
import com.minisig.businesslayer.dao.*;

public class PoiProcessus {

        public List<Poi> listAllPoiForLieu(int idLieu){
                List<Poi> pois = new ArrayList<>();
                PoiTest dao = null;
                dao = new PoiDAO();
                try{
                        pois = dao.ListAllPoiOfLieu(idLieu);
                        return pois;
                }
                catch(SQLException e){
                        e.printStackTrace();
                        return null;
                }
        }
        public Poi selectPoi(int id){
                
                DAO<Poi> dao = null;
                dao = new PoiDAO();
                try{
                        Poi pois = (Poi) dao.selectObject(id);
                        return pois;
                }
                catch(SQLException e){
                        e.printStackTrace();
                        return null;
                }
        }
        public void addPoi(String namePoi, String descriptionPoi,String imagePoi, int xPos, int yPos, int nbClic, int idLieu){
                DAO<Poi> dao=null;
                dao = new PoiDAO();
                Poi p = new Poi(namePoi, descriptionPoi, imagePoi, xPos, yPos, nbClic, idLieu);
                try{
                        dao.addObject(p);
                }
                catch(SQLException e){
                        e.printStackTrace();
                }
        }

        public void removePoi(int idPoi){
            DAO<Poi> dao=null;
            FaitPartieTest Fp = null;
            DAO<FaitPartie> daofp = null;
            List<FaitPartie> lfpartie = new ArrayList<>();
            dao = new PoiDAO();
            daofp = new FaitPartieDAO();
            Fp = new FaitPartieDAO();
            try {
                    lfpartie = Fp.listAllFaitPartieForPoi(idPoi);
                    for(FaitPartie f: lfpartie){
                            daofp.removeObject(f);
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            
            Poi p = selectPoi(idPoi);
            try{
                    dao.removeObject(p);
            }
            catch(SQLException e){
                    e.printStackTrace();
            }
            
    }
        
        public void updatePoi(int inputIdPoi, String outputNamePoi, String outputDescriptionPoi, String outputImagePoi, int outputXPos, int outputYPos, int outputNbClic, int outputidLieu){
                DAO<Poi> dao=null;
                dao = new PoiDAO();
                Poi poiToUpdate = selectPoi(inputIdPoi);
                Poi poiToFill = new Poi(outputNamePoi, outputDescriptionPoi, outputImagePoi, outputXPos, outputYPos, outputNbClic, outputidLieu);
                try{
                        dao.updateObject(poiToUpdate, poiToFill);
                }
                catch(SQLException e){
                        e.printStackTrace();
                }
        }
        public boolean checkPoiForParcours(int idParcours, int idPoi){

//                Pour afficher les Poi sur la carte pour un parcours
                PoiTest dao = null;
                dao = new PoiDAO();
                try{
                        return dao.checkPoiIntoParcours(idParcours, idPoi);
                }
                catch(SQLException e){
                        e.printStackTrace();
                        return false;
                }
        }
        public int getIdForNamePoi(String namePoi){
                DAO<Poi> dao = null;
                dao = new PoiDAO();
                try {
                        return dao.getIdForNameObject(namePoi);        
                } catch (SQLException e) {
                        e.printStackTrace();
                        return 0;
                }
        }
}
