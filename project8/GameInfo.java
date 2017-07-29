package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GameInfo extends JFrame {

	private JPanel contentPane;
	private DefaultListModel copiesModel;
	private JTextField txtCopyNum;
	private JList lstCopies;
	private Game game = new Game();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game game = new Game();
					GameInfo frame = new GameInfo(game);
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
	public GameInfo(Game passGame) {
		setTitle("Game Information");
		game = passGame;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameTitle = new JLabel(game.getTitle());
		lblGameTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGameTitle.setBounds(10, 11, 414, 27);
		contentPane.add(lblGameTitle);
		
		JLabel lblD = new JLabel("Designer:");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblD.setBounds(10, 49, 74, 17);
		contentPane.add(lblD);
		
		JLabel lblP = new JLabel("Publisher:");
		lblP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblP.setBounds(10, 77, 74, 14);
		contentPane.add(lblP);
		
		JLabel lblC = new JLabel("Categories:");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblC.setBounds(10, 102, 74, 17);
		contentPane.add(lblC);
		
		JLabel lblDesigner = new JLabel(game.getDesigner());
		lblDesigner.setBounds(94, 52, 330, 14);
		contentPane.add(lblDesigner);
		
		JLabel lblPublisher = new JLabel(game.getPublisher());
		lblPublisher.setBounds(94, 79, 330, 14);
		contentPane.add(lblPublisher);
		
		JLabel lblCatagory = new JLabel(game.getCategory());
		lblCatagory.setBounds(94, 101, 330, 22);
		contentPane.add(lblCatagory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 94, 95);
		contentPane.add(scrollPane);
		
		lstCopies = new JList();
		try {
			//Creates the connection and the Statement object.
			Connection conn = DriverManager.getConnection(GameDBConstants.DB_URL, GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
			Statement stmt = conn.createStatement();
			
			//Creates the SQL Statement.
			String sqlStatement = "SELECT copy_num, status FROM game_copy JOIN game "
					+ "on game.Product_No=game_copy.Product_Num WHERE game.Title = '"
					+ game.getTitle() + "'";
			
			//Creates a list model for the copy list.
			copiesModel = new DefaultListModel();
			
			//Assugnes the results of the SQL query to a result set.
			ResultSet rs = stmt.executeQuery(sqlStatement);
			
			//Puts the results of the query into the list model.
			while (rs.next())
			{
		        String copyNum = rs.getString("copy_num");
		        String status = rs.getString("status");
		        copiesModel.addElement(copyNum + ": " + status);
		      }
			
			//Assigns the list model to the copy list.
			lstCopies.setModel(copiesModel);
			
			//Closes the connecction.
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
		}
		
		scrollPane.setViewportView(lstCopies);
		
		JLabel lblCopies = new JLabel("Copies:");
		lblCopies.setBounds(10, 130, 92, 14);
		contentPane.add(lblCopies);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(306, 227, 118, 23);
		contentPane.add(btnMainMenu);
		
		JButton btnNewSearch = new JButton("New Search");
		btnNewSearch.addActionListener(new BtnNewSearchActionListener());
		btnNewSearch.setBounds(306, 193, 118, 23);
		contentPane.add(btnNewSearch);
		
		JButton btnDelete = new JButton("Delete Selected Copy");
		btnDelete.addActionListener(new BtnDeleteActionListener());
		btnDelete.setBounds(114, 227, 182, 23);
		contentPane.add(btnDelete);
		
		txtCopyNum = new JTextField();
		txtCopyNum.setBounds(222, 165, 74, 20);
		contentPane.add(txtCopyNum);
		txtCopyNum.setColumns(10);
		
		JLabel lblNewCopyNumber = new JLabel("New Copy Number:");
		lblNewCopyNumber.setBounds(114, 168, 114, 14);
		contentPane.add(lblNewCopyNumber);
		
		JButton btnAddCopy = new JButton("Add Copy");
		btnAddCopy.addActionListener(new BtnAddCopyActionListener());
		btnAddCopy.setBounds(114, 193, 182, 23);
		contentPane.add(btnAddCopy);
		
		JButton btnUpdateGame = new JButton("Update Game");
		btnUpdateGame.addActionListener(new BtnUpdateGameActionListener());
		btnUpdateGame.setBounds(306, 162, 118, 23);
		contentPane.add(btnUpdateGame);
	}
	private class BtnNewSearchActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Creates the game search window.
			GameSearch gSearch = new GameSearch();
			
		    //Makes it visible.
		 	gSearch.setVisible(true);			
		 			
		 	//Removes the game info window.
		 	GameInfo.this.dispose();
		}
	}
	private class BtnDeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Gets the copy selected from the list.
			int index = lstCopies.getSelectedIndex();
			String copyNum = (String) lstCopies.getSelectedValue();
			
			//Deletes it from the list.
			copiesModel.removeElementAt(index);
			
			//Connects to the database and delete from the game_copy table where
			//copy_num = the copy selected
		    Connection conn;
			try {
				//Creates the DB connection and the Statement object.
				conn = DriverManager.getConnection(GameDBConstants.DB_URL, GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
				Statement stmt = conn.createStatement();
				
				//Creates the SQL statement to delete he copy.
				String sqlStatement = "DELETE FROM game_copy WHERE copy_num = '"+
						copyNum + "'";
				
				//Executes the SQL.
				stmt.execute(sqlStatement);
				
				//Repopulates the list with the model so the deleted copy is gone.
				lstCopies.setModel(copiesModel);
				
				//Closes the connection.
				conn.close();
			}catch (SQLException f) {
				JOptionPane.showMessageDialog(null, "ERROR: " + f.getMessage());
		    }
		}
	}
	private class BtnAddCopyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Gets the copy number for the new copy from the text field.
			String newCopy = txtCopyNum.getText();
			
			try {
				//Creates the DB connection and the Statement object.
				Connection conn = DriverManager.getConnection(GameDBConstants.DB_URL, GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
				Statement stmt = conn.createStatement();
				
				//Creates the SQL statement to add the new game copy.
				String sqlStatement = "INSERT INTO game_copy (copy_num, product_num, status, loan_num) " +
							"VALUES ('" + txtCopyNum.getText() + "','" + game.getProdNum() + "','IN', null)";
				
				//Executes the statement.
				stmt.execute(sqlStatement);
				
				//Creates the SQL Statement.
				sqlStatement = "SELECT copy_num, status FROM game_copy JOIN game "
						+ "on game.Product_No=game_copy.Product_Num WHERE game.Title = '"
						+ game.getTitle() + "'";
				
				//Creates a list model for the copy list.
				copiesModel = new DefaultListModel();
				
				//Assugnes the results of the SQL query to a result set.
				ResultSet rs = stmt.executeQuery(sqlStatement);
				
				//Puts the results of the query into the list model.
				while (rs.next())
				{
			        String copyNum = rs.getString("copy_num");
			        String status = rs.getString("status");
			        copiesModel.addElement(copyNum + ": " + status);
			      }
				
				//Assigns the list model to the copy list.
				lstCopies.setModel(copiesModel);
				
				//Adds the copy number to the list model and repopulates the list with the model.
				//copiesModel.addElement(txtCopyNum.getText());
				//lstCopies.setModel(copiesModel);
				
				//Clears out the new copy number field.
				txtCopyNum.setText("");
				
				//Closes the connection.
				conn.close();
			}catch (SQLException f) {
				JOptionPane.showMessageDialog(null, "ERROR: " + f.getMessage());
		    }
		}
	}
	private class BtnUpdateGameActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Creates the update screen.
			GameUpdate gUpdate = new GameUpdate(game);
			
		    //Makes it visible.
		 	gUpdate.setVisible(true);			
		 			
		 	//Closes the Info screen.
		 	GameInfo.this.dispose();
		}
	}
	private class BtnMainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Creates the main menu screen.
			MainMenu main = new MainMenu();
			
			//Makes it visible.
			main.setVisible(true);
			
			//Closes the info screen.
			GameInfo.this.dispose();
		}
	}
}