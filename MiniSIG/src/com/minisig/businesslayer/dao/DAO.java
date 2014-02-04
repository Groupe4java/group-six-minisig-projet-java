package com.minisig.businesslayer.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

	public abstract Object selectObject() throws SQLException;
	//
	public abstract void addObject(Object o) throws SQLException;
	//
	public abstract void removeObject(Object o) throws SQLException;
	//
	public abstract void updateObject(Object o, Object i) throws SQLException;
	//
	public abstract List<Object> listAllObject() throws SQLException;
	//
	public abstract void closeConnection() throws SQLException;
}
