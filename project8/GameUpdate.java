package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GameUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField txtGameTitle;
	private JTextField txtPublisher;
	private JTextField txtDesigner;
	private JTextField txtCategories;
	private static Game game = new Game(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameUpdate frame = new GameUpdate(game);
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
	public GameUpdate(Game passGame) {
		game = passGame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameTitle = new JLabel("Game Title:");
		lblGameTitle.setBounds(10, 11, 71, 14);
		contentPane.add(lblGameTitle);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setBounds(10, 52, 71, 14);
		contentPane.add(lblPublisher);
		
		JLabel lblCategories = new JLabel("Categories:");
		lblCategories.setBounds(10, 133, 71, 14);
		contentPane.add(lblCategories);
		
		JLabel lblDesigner = new JLabel("Designer");
		lblDesigner.setBounds(10, 92, 71, 14);
		contentPane.add(lblDesigner);
		
		txtGameTitle = new JTextField();
		txtGameTitle.setBounds(82, 8, 342, 20);
		contentPane.add(txtGameTitle);
		txtGameTitle.setColumns(10);
		txtGameTitle.setText(game.getTitle());
		
		txtPublisher = new JTextField();
		txtPublisher.setBounds(82, 49, 342, 20);
		contentPane.add(txtPublisher);
		txtPublisher.setColumns(10);
		txtPublisher.setText(game.getPublisher());
		
		txtDesigner = new JTextField();
		txtDesigner.setBounds(82, 89, 342, 20);
		contentPane.add(txtDesigner);
		txtDesigner.setColumns(10);
		txtDesigner.setText(game.getDesigner());
		
		txtCategories = new JTextField();
		txtCategories.setBounds(82, 130, 342, 20);
		contentPane.add(txtCategories);
		txtCategories.setColumns(10);
		txtCategories.setText(game.getCategory());
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new BtnUpdateActionListener());
		btnUpdate.setBounds(10, 227, 87, 23);
		contentPane.add(btnUpdate);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(204, 227, 96, 23);
		contentPane.add(btnMainMenu);
		
		JButton btnNewSearch = new JButton("New Search");
		btnNewSearch.addActionListener(new BtnNewSearchActionListener());
		btnNewSearch.setBounds(310, 227, 114, 23);
		contentPane.add(btnNewSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new BtnDeleteActionListener());
		btnDelete.setBounds(107, 227, 87, 23);
		contentPane.add(btnDelete);
	}
	private class BtnNewSearchActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GameSearch gSearch = new GameSearch();
			
		    // set the visibility of the ConfirmPage to true.
		 	gSearch.setVisible(true);			
		 			
		 	//Dispose the current frame
		 	GameUpdate.this.dispose();
		}
	}
	private class BtnUpdateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//sql biz
			final String DB_URL = "jdbc:mysql://localhost:3306/gamesDB";
		    final String USER_NAME = "root";
		    final String PASSWORD = "";
		    Connection conn;
			try {
				conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				Statement stmt = conn.createStatement();
				//set game object fields to contents of text fields
				game.setTitle(txtGameTitle.getText());
				game.setPublisher(txtPublisher.getText());
				game.setDesigner(txtDesigner.getText());
				game.setCategory(txtCategories.getText());
				//update the db
				String sqlStatement = "UPDATE game Set Title = '" + game.getTitle() + 
						"', Publisher = '" + game.getPublisher() + 
						"', Designer = '" + game.getDesigner() +
						"', Category = '" + game.getCategory() + 
						"' WHERE Product_No = " + game.getProdNum();
				
				stmt.execute(sqlStatement);
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	private class BtnDeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//sql biz
			final String DB_URL = "jdbc:mysql://localhost:3306/gamesDB";
		    final String USER_NAME = "root";
		    final String PASSWORD = "";
		    Connection conn;
			try {
				conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				Statement stmt = conn.createStatement();
				
				//SQL Statement to delete the copies of the game.
				String sqlStatement = "DELETE FROM game_copy WHERE Product_Num = "
						+ game.getProdNum();
				
				stmt.execute(sqlStatement);
				
				//update the db
				sqlStatement = "DELETE FROM game " + 
						"WHERE Product_No = " + game.getProdNum();
				
				stmt.execute(sqlStatement);
				
				sqlStatement = "DELETE FROM game_copy " + 
						"WHERE Product_Num = " + game.getProdNum();
				
				stmt.execute(sqlStatement);
				
				txtGameTitle.setText("");
				txtPublisher.setText("");
				txtDesigner.setText("");
				txtCategories.setText("");
				
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class BtnMainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			MainMenu main = new MainMenu();
			main.setVisible(true);
			GameUpdate.this.dispose();
		}
	}
}
