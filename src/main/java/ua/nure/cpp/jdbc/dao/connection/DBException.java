package ua.nure.cpp.jdbc.dao.connection;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class DBException extends SQLException {

	public DBException() {
		super();
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBException(String message) {
		super(message);
	}

	public DBException(Throwable cause) {
		super(cause);
	}

}
