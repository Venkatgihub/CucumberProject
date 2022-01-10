package pageFiles;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SQL {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://localhost:3306/sakila";



		//Database Username
		String username = "root";

		//Database Password
		String password = "root";



		//Query to Execute
		String query = "SELECT * FROM city limit 10;";
		//String query = "SELECT * FROM movies;";

		//Load mysql jdbc driver
		//Class.forName("com.mysql.jdbc.Driver");

		//Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs= stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()){
		String City = rs.getString(1);
		String fullName = rs.getString(2);
		//String DOB = rs.getString(4);
		//String Address = rs.getString(5);
		System. out.println(City+" ---------- "+fullName);
		System.out.println("*********************");
		//System.out.println(Address);
		}
		// closing DB Connection




		con.close();
		}
		}

