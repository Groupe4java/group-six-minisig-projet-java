package com.minisig.businesslayer.dao;
import com.minisig.businesslayer.table.*;
import java.sql.*;
import java.util.List;

public interface PoiTest {
	abstract public List<Poi> ListAllPoiOfLieu(String lieu) throws SQLException;
	abstract public List<Poi> ListAllPoiOfParcours(String Parcours) throws SQLException;
}
