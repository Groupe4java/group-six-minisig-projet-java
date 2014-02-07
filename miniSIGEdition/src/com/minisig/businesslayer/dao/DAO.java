package com.minisig.businesslayer.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{

	public abstract T selectObject(int idObject) throws SQLException;
	//
	public abstract void addObject(T o) throws SQLException;
	//
	public abstract void removeObject(T o) throws SQLException;
	//
	public abstract void updateObject(T o, T i) throws SQLException;
	//
	public abstract List<T> listAllObject() throws SQLException;
	//
	public abstract void closeConnection() throws SQLException;
}
