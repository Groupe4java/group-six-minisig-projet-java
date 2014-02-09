package com.minisig.businesslayer.dao;

import java.sql.SQLException;
import java.util.List;
import com.minisig.businesslayer.table.FaitPartie;

public interface FaitPartieTest {

        abstract public List<FaitPartie> listAllFaitPartieForParcours (int idParcours) throws SQLException;
        abstract public List<FaitPartie> listAllFaitPartieForPoi(int idPoi) throws SQLException;
}
