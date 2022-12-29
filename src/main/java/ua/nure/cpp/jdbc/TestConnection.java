package ua.nure.cpp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/Polyclinics"
		           + "?sslMode=DISABLED&serverTimzone=UTC&user=root&password=ilona2004";
		try (Connection con = DriverManager.getConnection(url)) {
			System.out.println("Ok.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
