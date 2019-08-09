import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * This class connect to Mysql DB, creates Result Set object and writes result set object into json file
 * @author bmunegow
 *
 */
public class Java2Json {

	public static void main(String[] args){
		System.out.println("---started execution---");
		String sql = "select * from customerinfo where location = 'Asia';";		
		runSQLQuery(sql);
//		testDB();
	}
	
	/**
	 * Executes SQL query and get the result set object
	 * @param sqlQuery
	 */
	public static void runSQLQuery(String sqlQuery) {
		ArrayList<CustomerInfo> cust = new ArrayList<CustomerInfo>();
		ResultSet rs;
		Statement stmt;
		CustomerInfo c;
		try {
			stmt = connectToMysqlDB("business", "root", "root");
			rs = stmt.executeQuery(sqlQuery);
			while(rs.next()){
				c = new CustomerInfo();
				c.setCourseName(rs.getString(1));
				c.setPurchaseDate(rs.getString(2));
				c.setAmount(rs.getInt(3));
				c.setLocation(rs.getString(4));
				cust.add(c);				
				System.out.println(c.getCourseName()+", "+c.getPurchaseDate()+", "+c.getAmount()+", "+c.getPurchaseDate());	
//				System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4));	
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		writeJsonForResultSet(cust);
		System.out.println("---data retrive done---");
	}
	
	/**
	 * Creates CustomerInfo.json file for the object 'obj'
	 * @param obj
	 */
	public static void writeJsonForResultSet(Object obj){
	
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("D:\\AutomationWorkspace\\Java2Json\\JsonFiles\\CustomerInfo.json"), obj);
		} catch (JsonGenerationException e) {
			 e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Connects to Mysql DB
	 * @param dbName
	 * @param username
	 * @param pwd
	 * @return
	 */
	public static Statement connectToMysqlDB(String dbName, String username, String pwd){
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, username, pwd);
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} return stmt;
	}

	/**
	 * testing purpose
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void testDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "root");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customerinfo where location = 'Asia' and purchasedate = current_date();");
		
		while(rs.next()){
			System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4));	
		}
	}
	
}
