package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection(); // conecntando
			
			st = conn.prepareStatement( // criando um script
					"DELETE FROM department "
					+ "WHERE "
					+"Id = ?"
					);
			st.setInt(1, 8);
		
			int rows = st.executeUpdate();
			System.out.println("Done! Rows = " + rows);
		}catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.CloseStatement(st);
			DB.closeConnection();
		}

	}

}
