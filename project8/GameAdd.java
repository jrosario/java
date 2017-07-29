package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GameAdd extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtDesigner;
	private JTextField txtPublisher;
	private JTextField txtCategories;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameAdd frame = new GameAdd();
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
	public GameAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameTitle = new JLabel("Game Title:");
		lblGameTitle.setBounds(10, 11, 76, 14);
		contentPane.add(lblGameTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(10, 36, 414, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblDesigner = new JLabel("Designer:");
		lblDesigner.setBounds(10, 67, 76, 14);
		contentPane.add(lblDesigner);
		
		txtDesigner = new JTextField();
		txtDesigner.setBounds(10, 92, 414, 20);
		contentPane.add(txtDesigner);
		txtDesigner.setColumns(10);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setBounds(10, 123, 76, 14);
		contentPane.add(lblPublisher);
		
		txtPublisher = new JTextField();
		txtPublisher.setBounds(10, 148, 414, 20);
		contentPane.add(txtPublisher);
		txtPublisher.setColumns(10);
		
		JLabel lblCategories = new JLabel("Categories:");
		lblCategories.setBounds(10, 179, 76, 14);
		contentPane.add(lblCategories);
		
		txtCategories = new JTextField();
		txtCategories.setBounds(10, 204, 414, 20);
		contentPane.add(txtCategories);
		txtCategories.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new BtnAddActionListener());
		btnAdd.setBounds(335, 235, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new BtnCancelActionListener());
		btnCancel.setBounds(236, 235, 89, 23);
		contentPane.add(btnCancel);
	}
	private class BtnCancelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MainMenu main = new MainMenu();
			
		    // set the visibility of the ConfirmPage to true.
		 	main.setVisible(true);			
		 			
		 	//Dispose the current frame
		 	GameAdd.this.dispose();
		}
	}
	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Create the connection
		    Connection conn;
			try {
				//Connect to the database.
				conn = DriverManager.getConnection(GameDBConstants.DB_URL, GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
				Statement stmt = conn.createStatement();
				
				//Create a blank game to hold the data.
				Game game = new Game();
				
				//Set game object fields to contents of text fields.
				game.setTitle(txtTitle.getText());
				game.setPublisher(txtPublisher.getText());
				game.setDesigner(txtDesigner.getText());
				game.setCategory(txtCategories.getText());
				
				//get the number of records in the game table and add one to make the new Product_No
				String sqlStatement = "SELECT MAX(product_no) FROM game";				
				ResultSet rs = stmt.executeQuery(sqlStatement);
				rs.next();
				int prodNum = rs.getInt(1);
				//int prodNum = stmt.executeQuery(sqlStatement);
				prodNum++;
				
				//update the db
				sqlStatement = "INSERT INTO game (Product_No, Title, Publisher, Designer, Category) VALUES ("
						+ prodNum + ",'" + game.getTitle() + "','" + game.getPublisher()
						+ "','" + game.getDesigner() + "','" + game.getCategory() + "')";
				
				stmt.execute(sqlStatement);
				
				txtTitle.setText("");
				txtPublisher.setText("");
				txtDesigner.setText("");
				txtCategories.setText("");
				
				conn.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
}
