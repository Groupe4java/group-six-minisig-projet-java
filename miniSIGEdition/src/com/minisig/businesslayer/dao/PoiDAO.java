package com.minisig.businesslayer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.Poi;
import com.minisig.businesslayer.sqlmap.MapPoi;
import com.minisig.dataaccesslayer.*;

public class PoiDAO implements DAO<Poi>, PoiTest{

        public Poi selectObject(int idPoi) throws SQLException {
        	System.out.println(idPoi);
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapPoi().mapSelectPoi());
                prepare.setInt(1, idPoi);
                ResultSet rs = prepare.executeQuery();
                rs.next();
                Poi poi = new Poi(idPoi, rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
               prepare.close();
                return poi;
        }
        public void addObject(Poi o) throws SQLException {
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapPoi().mapAddPoi());
                prepare.setString(1, o.getLibellePOI());
                prepare.setString(2, o.getDescriptionPOI());
                prepare.setInt(3, o.getXPOI());
                prepare.setInt(4, o.getYPOI());
                prepare.setInt(5, o.getNombreclicPOI());
                prepare.setInt(6, o.getIdLieu());
                prepare.execute();
                prepare.close();
        }
        public void removeObject(Poi o) throws SQLException {
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapPoi().mapRemovePoi());
                prepare.setString(1, o.getLibellePOI());
                prepare.setString(2, o.getDescriptionPOI());
                prepare.setInt(3, o.getXPOI());
                prepare.setInt(4, o.getYPOI());
                prepare.setInt(5, o.getNombreclicPOI());
                prepare.setInt(6, o.getIdLieu());
                prepare.execute();
                prepare.close();
        }
        public void updateObject(Poi input, Poi output) throws SQLException {
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapPoi().mapUpdatePoi());
                prepare.setString(1, output.getLibellePOI());
                prepare.setString(2, output.getDescriptionPOI());
                prepare.setString(3, output.getImagePOI());
                prepare.setInt(4, output.getXPOI());
                prepare.setInt(5, output.getYPOI());
                prepare.setInt(6, output.getNombreclicPOI());
                prepare.setInt(7, output.getIdLieu());
                prepare.setString(8, input.getLibellePOI());
                prepare.setString(9, input.getDescriptionPOI());
                prepare.setString(10, input.getImagePOI());
                prepare.setInt(11, input.getXPOI());
                prepare.setInt(12, input.getYPOI());
                prepare.setInt(13, input.getNombreclicPOI());
                prepare.setInt(14, input.getIdLieu());
                prepare.executeUpdate();
                prepare.close();        
        }
        public List<Poi> listAllObject() throws SQLException {
                List<Poi> poi = new ArrayList<>();
                Connection con = DataAccess.getInstance();
                Statement state = con.createStatement();
                ResultSet rs = state.executeQuery(new MapPoi().mapListAllPoiOfLieu());
                while (rs.next()){
                        Poi tempObject = new Poi(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                        poi.add(tempObject);
                }
                state.close();
                return poi;
        }
        public void closeConnection() throws SQLException {        
        
        }
        public List<Poi> ListAllPoiOfLieu(int idLieu) throws SQLException {
                List<Poi> poi = new ArrayList<>();
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapPoi().mapListAllPoiOfLieu());
                prepare.setInt(1, idLieu);        
                ResultSet rs = prepare.executeQuery();        
                while (rs.next()){
                        Poi tempObject = new Poi(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4),rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                        poi.add(tempObject);
                }
                prepare.close();
                return poi;
        }
        public boolean checkPoiIntoParcours(int idParcours, int idPoi) throws SQLException {
                boolean hasRows = false;
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapPoi().mapGetExistencePoiInParcours());
                prepare.setInt(1, idParcours);        
                prepare.setInt(2, idPoi);
                ResultSet rs = prepare.executeQuery();        
                while(rs.next()){
                        hasRows = true;
                }
                prepare.close();
                return hasRows;
        }
        public int getIdForNameObject(String nameObject) throws SQLException {
            Connection con = DataAccess.getInstance();    
            PreparedStatement prepare = con.prepareStatement(new MapPoi().mapGetIdForNamePoi());
            prepare.setString(1, nameObject);
            ResultSet rs = prepare.executeQuery();
            rs.next();
            int id = rs.getInt(1);
        	return id;
        }
}
