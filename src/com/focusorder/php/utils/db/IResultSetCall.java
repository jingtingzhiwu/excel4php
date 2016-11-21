package com.focusorder.php.utils.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResultSetCall<T> {

	public T invoke(ResultSet rs) throws SQLException;

}
