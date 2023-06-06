package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection(); // conecntando
			
			st = conn.prepareStatement( // criando um script
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ?"
					+ "WHERE " 
					+ "(DepartmentId = ?)"
					);
			
			st.setDouble(1, 200);
			st.setInt(2, 2);
			
			int rows = st.executeUpdate();
			System.out.println("Done! Rows = " + rows);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.CloseStatement(st);
			DB.closeConnection();
		}

	}

}
