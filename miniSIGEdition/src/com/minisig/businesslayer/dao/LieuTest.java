package com.minisig.businesslayer.dao;

import java.sql.SQLException;

public interface LieuTest {

	abstract public String getImageForLieu(String nameObject) throws SQLException;
	abstract public int getIdForNameLieu(String nameObject) throws SQLException;
}
