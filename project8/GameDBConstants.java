/**
 * This class represents a constants used for Games database connection.
 * @author Jose Rosario-Lopez
 * @version 1.0
 */

package Project;

public class GameDBConstants {
	
	//Constants
	static public final String DB_URL = "jdbc:mysql://localhost:3306/gamesdb";
	static public final String USER_NAME = "root";
	static public final String PASSWORD = "";
	
	//Customer table constants
	static public final String CUSTOMER_TABLE_NAME  = "customer";
	static public final String CUSTOMER_PK_NAME = "Cust_Phone_Num";
	
	//Loan Table constants
	static public final String LOAN_TABLE_NAME  = "loan";
	static public final String LOAN_PK_NAME = "Loan_Num";
	
	//Game table constants
	static public final String GAME_TABLE_NAME  = "game";
	static public final String GAME_PK_NAME = "Product_No";
	
	//Copies of game table constants
	static public final String GAME_COPY_TABLE_NAME  = "game_copy";
	static public final String GAME_COPY_PK_NAME = "Copy_Num";
	
}
