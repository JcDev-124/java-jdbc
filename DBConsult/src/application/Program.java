package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null; // conexao com bd
		ResultSet rs = null; // resultado de consultas
		// criando conexao com o bd
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement(); 
			rs = st.executeQuery("select * from department"); // executando script no bd
			
			while(rs.next()) { // looping até q chegue ao fim dos dados
				
				System.out.println(rs.getInt("Id") + "," + rs.getString("Name")); //
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			DB.CloseResultSet(rs);;
			DB.CloseStatement(st);
			DB.closeConnection();
		}
		
		
		
		
		
		
	}

}
