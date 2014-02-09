package com.minisig.businesslayer.processus;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.*;
import com.minisig.businesslayer.dao.*;

public class ParcoursProcessus {

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
        public int getIdForNameParcours(String libelleParcours){
        	System.out.println("DANS PPROC");
                int tempInt;
                DAO<Parcours> dao = null;
                dao = new ParcoursDAO();
                try {
                	System.out.println("DANS TRY");
                        tempInt = dao.getIdForNameObject(libelleParcours);
                        return tempInt;
                } catch (SQLException e) {
                        e.printStackTrace();
                        return 0;
                }
        }
        public Parcours selectParcours(int idParcours){
                DAO<Parcours> dao = null;
                dao = new ParcoursDAO();
                try {
                        Parcours p = dao.selectObject(idParcours);
                        System.out.println(p.getLibelleParcours());
                        return p;
                } catch (SQLException e) {
                        return null;
                }
        }
        public void addParcours(String nameParcours, String descriptionLieu, int idLieu, List<String> pois){
                Parcours p = new Parcours(nameParcours, descriptionLieu, idLieu);
                DAO<Parcours> dao = null;
                DAO<FaitPartie> daoFp = null;
                PoiProcessus poisIdPoiProcessus = new PoiProcessus();
                int idParcours = 0;
                dao = new ParcoursDAO();
                daoFp = new FaitPartieDAO();
                try{
                        dao.addObject(p);
                }
                catch(SQLException e){
                        e.printStackTrace();
                }
                try {
                        idParcours = dao.getIdForNameObject(nameParcours);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                
                for (String s: pois){
                        try {
                                daoFp.addObject(new FaitPartie(poisIdPoiProcessus.getIdForNamePoi(s), idParcours));
                        } catch (SQLException e) {

                                e.printStackTrace();
                        }
                }

        }
        public void removeParcours(String nameParcours){
                List<FaitPartie> faitPartis = new ArrayList<>();
                Parcours parcoursToDelete = selectParcours(getIdForNameParcours(nameParcours));
                FaitPartieTest FpObtentionList = null;
                DAO<Parcours> dao = null;
                DAO<FaitPartie> daoFp = null;
                FpObtentionList = new FaitPartieDAO();
                daoFp = new FaitPartieDAO();
                dao = new ParcoursDAO();        
                try {
                        faitPartis = FpObtentionList.listAllFaitPartieForParcours(getIdForNameParcours(nameParcours));
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                }
               
                try {
                        for(FaitPartie p: faitPartis){
                        	daoFp.removeObject(p);
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }        
                try {
                	dao.removeObject(parcoursToDelete);
                } catch (SQLException e) {
                        e.printStackTrace();
                }

        }
        public void updateParcours(String InputnameParcours, String libelleParcours, String descriptionParcours, int idLieu, List<String> pois){
                Parcours parcoursToUpdate = selectParcours(getIdForNameParcours(InputnameParcours));
                Parcours parcoursToFill = new Parcours(libelleParcours, descriptionParcours, idLieu);
                List<FaitPartie> faitParties = new ArrayList<>();
                
                DAO<Parcours> dao = null;
                FaitPartieTest fpObtentionList = null;
                DAO<FaitPartie> daofp = null;
                
                PoiProcessus poisIdPoiProcessus = new PoiProcessus();
                dao = new ParcoursDAO();
                fpObtentionList = new FaitPartieDAO();
                daofp = new FaitPartieDAO();
                try {
                        dao.updateObject(parcoursToUpdate, parcoursToFill);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                try {
                        faitParties = fpObtentionList.listAllFaitPartieForParcours(getIdForNameParcours(libelleParcours));
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                try {
                        for(FaitPartie faitPartieToRemove : faitParties){
                                daofp.removeObject(faitPartieToRemove);
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                try {
                        for(String s: pois){
                                daofp.addObject(new FaitPartie(poisIdPoiProcessus.getIdForNamePoi(s), getIdForNameParcours(libelleParcours)));
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                
        }
        
}
