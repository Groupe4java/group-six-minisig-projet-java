package com.minisig.businesslayer.dao;

import java.sql.SQLException;
import java.util.List;

import com.minisig.businesslayer.table.Parcours;

public interface ParcoursTest {

	abstract public List<Parcours> ListAllParcoursOfLieu(String nameObject) throws SQLException;
	abstract public int getIdForNameParcours(String nameObject) throws SQLException;
}
