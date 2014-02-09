package com.minisig.businesslayer.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.minisig.businesslayer.table.FaitPartie;
import com.minisig.businesslayer.table.Lieu;
import com.minisig.businesslayer.sqlmap.MapFaitPartie;
import com.minisig.businesslayer.sqlmap.MapLieu;
import com.minisig.dataaccesslayer.DataAccess;

public class FaitPartieDAO implements DAO<FaitPartie>, FaitPartieTest{

        public FaitPartie selectObject(int faitPartie) throws SQLException {
                // TODO Auto-generated method stub
                return null;
        }

        public List<FaitPartie> listAllFaitPartieForPoi(int idPoi) throws SQLException{
            List<FaitPartie> listFaitParties = new ArrayList<>();
            Connection con = DataAccess.getInstance();
            PreparedStatement prepare = con.prepareStatement(new MapFaitPartie().mapSelectFaitPartieForPoi());
            prepare.setInt(1, idPoi);
            ResultSet rs = prepare.executeQuery();
            while(rs.next()){
                    FaitPartie tempObject = new FaitPartie(rs.getInt(2), rs.getInt(1));
                    listFaitParties.add(tempObject);
            }
            prepare.close();
            return listFaitParties;
        }
        
        public void addObject(FaitPartie f) throws SQLException {
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapFaitPartie().mapAddFaitPartie());
                prepare.setInt(1, f.getIdPoi());
                prepare.setInt(2, f.getIdParcours());
                prepare.executeUpdate();
                prepare.close();        
        }

        public void removeObject(FaitPartie f) throws SQLException {
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapFaitPartie().mapRemoveFaitPartie());
                prepare.setInt(1, f.getIdParcours());
                prepare.setInt(2, f.getIdPoi());
                System.out.println(prepare.toString());
                prepare.executeUpdate();
                prepare.close();                
        }

        public void updateObject(FaitPartie o, FaitPartie i) throws SQLException {
                // TODO Auto-generated method stub
                
        }

        public List<FaitPartie> listAllObject() throws SQLException {
                // TODO Auto-generated method stub
                return null;
        }

        public void closeConnection() throws SQLException {
                // TODO Auto-generated method stub
                
        }

        public int getIdForNameObject(String nameObject) throws SQLException {
                // TODO Auto-generated method stub
                return 0;
        }
        public List<FaitPartie> listAllFaitPartieForParcours (int idParcours) throws SQLException{
                List<FaitPartie> listFaitParties = new ArrayList<>();
                Connection con = DataAccess.getInstance();
                PreparedStatement prepare = con.prepareStatement(new MapFaitPartie().mapSelectFaitPartieForParcours());
                prepare.setInt(1, idParcours);
                ResultSet rs = prepare.executeQuery();
                while(rs.next()){
                        FaitPartie tempObject = new FaitPartie(rs.getInt(2), rs.getInt(1));
                        listFaitParties.add(tempObject);      
                }
                return listFaitParties;
        }

}
