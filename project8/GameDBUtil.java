/**
 * Game database utility used to connect.
 * @author Jose Rosario-Lopez
 * @version 1.0
 */
package Project;

import java.sql.Connection;
import java.sql.DriverManager;

public class GameDBUtil {
	static public Connection getDBConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(GameDBConstants.DB_URL,GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return conn;
	}

	static public void closeDBConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}

}
