package com.minisig.businesslayer.dao;
import com.minisig.businesslayer.table.*;
import java.sql.*;
import java.util.List;

public interface PoiTest {
	abstract public List<Poi> ListAllPoiOfLieu(int lieu) throws SQLException;
	abstract public boolean checkPoiIntoParcours(int Parcours, int Poi) throws SQLException;
}