package Project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import lab15.ConfirmFrame;
//import lab15.SizeAddressFrame;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class GameSearch extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnGameTitle;
	private JRadioButton rdbtnDesigner;
	private JTextField txtTerms;
	private JRadioButton rdbtnCategory;
	private JRadioButton rdbtnPublisher;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private JList lstGames;
	private JButton btnSelect;
	private JButton btnMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSearch frame = new GameSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameSearch() {
		setTitle("Search Games Database");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnGameTitle = new JRadioButton("Game Title");
		rdbtnGameTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGroup.add(rdbtnGameTitle);
		rdbtnGameTitle.setSelected(true);
		rdbtnGameTitle.setBounds(6, 60, 116, 23);
		contentPane.add(rdbtnGameTitle);
		
		rdbtnDesigner = new JRadioButton("Designer");
		rdbtnDesigner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGroup.add(rdbtnDesigner);
		rdbtnDesigner.setBounds(6, 86, 109, 23);
		contentPane.add(rdbtnDesigner);
		
		rdbtnPublisher = new JRadioButton("Publisher");
		rdbtnPublisher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGroup.add(rdbtnPublisher);
		rdbtnPublisher.setBounds(6, 112, 109, 23);
		contentPane.add(rdbtnPublisher);
		
		rdbtnCategory = new JRadioButton("Category");
		rdbtnCategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGroup.add(rdbtnCategory);
		rdbtnCategory.setBounds(6, 138, 109, 23);
		contentPane.add(rdbtnCategory);
		
		txtTerms = new JTextField();
		txtTerms.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTerms.setBounds(6, 11, 418, 42);
		contentPane.add(txtTerms);
		txtTerms.setColumns(10);
		
		lstGames = new JList();
		lstGames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstGames.setBounds(138, 60, 286, 162);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new BtnSearchActionListener());
		btnSearch.setBounds(10, 227, 89, 23);
		contentPane.add(btnSearch);
		
		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new BtnSelectActionListener());
		btnSelect.setBounds(335, 227, 89, 23);
		contentPane.add(btnSelect);
		
		JScrollPane scrollPaneGames = new JScrollPane();
		scrollPaneGames.setBounds(128, 60, 296, 162);
		scrollPaneGames.setViewportView(lstGames);
		contentPane.add(scrollPaneGames);
		
		JButton btnAddGame = new JButton("Add Game");
		btnAddGame.addActionListener(new BtnAddGameActionListener());
		btnAddGame.setBounds(228, 227, 100, 23);
		contentPane.add(btnAddGame);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(109, 227, 109, 23);
		contentPane.add(btnMainMenu);
	}
	private class BtnSearchActionListener implements ActionListener {
		//Creates a model to hold a list of games.
		private DefaultListModel gamesModel;
		public void actionPerformed(ActionEvent arg0) {
		    //Connects to the DB and gets a list of games.
		    try {
		    	//Creates the connection to the DB and a statement object to issue SQL statements.
				Connection conn = DriverManager.getConnection(GameDBConstants.DB_URL, GameDBConstants.USER_NAME, 
						GameDBConstants.PASSWORD);
				Statement stmt = conn.createStatement();
				
				//Initializes two variables to hold info for searching.
				String field = "";
				String terms = "";
				//Sets which field of the DB to search by.
				if (rdbtnGameTitle.isSelected()) field = "title";
				if (rdbtnPublisher.isSelected()) field = "publisher";
				if (rdbtnDesigner.isSelected()) field = "designer";
				if (rdbtnCategory.isSelected()) field = "category";
				//Gets the search terms from the text field.
				terms = txtTerms.getText();
				
				gamesModel = new DefaultListModel();
				
				//Creates the SQL statement.
				String sqlStatement = "SELECT title FROM game " +
                        "WHERE " + field + " LIKE '%" + terms + "%'";
				
				//Issues the SQL statement and assigns the results to a Result Set object.
				ResultSet rs = stmt.executeQuery(sqlStatement);
				
				//Assigns the titles of the games in the results to the List Model.
				while (rs.next())
				{
			        String gameTitle = rs.getString("title");
			        gamesModel.addElement(gameTitle);
			        
			      }
				//Assigns the items in the model to an Array and then sorts them.
				String[] gameList = new String[gamesModel.getSize()];
				for(int i=0;i<gameList.length;i++){
			        gameList[i]=gamesModel.getElementAt(i).toString();
			    }
				Arrays.sort(gameList);
				//Assigns the contents of the array to the visible list.
				lstGames.setListData(gameList);
				
				//Closes the connection.
				conn.close();
				
			} catch (SQLException e) {
				//Displays the error message if anything goes wrong.
				JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
			}
			
		}
	}
	private class BtnSelectActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Gets the selected game from the list.
			String game = (String) lstGames.getSelectedValue();
			
			//Creates the select SQL statement based on the game title.
			String sqlStatement = "SELECT product_no, title, publisher, designer, category FROM game " +
                    "WHERE TITLE = '" + game + "'";
			
			//Creates a blank game to store game data.
		    Game gameObj = new Game();
		    
		    //This section tries to get the game data from the database.
		    try {
		    	//Creates the connection to the database and a statement object to issue statements.
				Connection conn = DriverManager.getConnection(GameDBConstants.DB_URL, GameDBConstants.USER_NAME,
						GameDBConstants.PASSWORD);
				Statement stmt = conn.createStatement();
			
				//Sends the SQL statement to the DB and assigns the results to a Result Set.
				ResultSet rs = stmt.executeQuery(sqlStatement);
				rs.next();
				//Assigns the information from the DB to the game object.
				gameObj.setProdNum(rs.getInt("product_no"));
				gameObj.setTitle(rs.getString("title"));
				gameObj.setDesigner(rs.getString("designer"));
				gameObj.setPublisher(rs.getString("publisher"));
				gameObj.setCategory(rs.getString("category"));
				
				//Closes the DB connection.
				conn.close();
				
				//Call the game info screen.
			    GameInfo infoFrame = new GameInfo(gameObj);
				
			   	//Make it visible.
			 	infoFrame.setVisible(true);			
			 			
			 	//Remove the game search window.
			 	GameSearch.this.dispose();
				
		    	}catch (SQLException e) {
		    		//Displays the error message if there are any problems.
		    		if(lstGames.isSelectionEmpty()){
		    			JOptionPane.showMessageDialog(null, "No game is selected.");
		    		}
		    		else{
		    			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
		    		}
		    	}
		}
	}
	private class BtnAddGameActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Call the game add screen.
			GameAdd addGame = new GameAdd();
			
		    //Make it visible.
		 	addGame.setVisible(true);			
		 			
		 	//Remove the game search window.
		 	GameSearch.this.dispose();
		}
	}
	private class BtnMainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Call the main menu.
			MainMenu main = new MainMenu();
			//Make it visible.
			main.setVisible(true);
			//Remove the game search window.
			GameSearch.this.dispose();
		}
	}
}
