package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import edu.unlv.is380.labwork15.ConfirmFrame;
//import edu.unlv.is380.labwork15.SizeAddressFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import Project.UserAdd;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import java.awt.Choice;
import javax.swing.JTree;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnAddLoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("FormattedTextField.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearchGames = new JButton("Search");
		btnSearchGames.addActionListener(new BtnSearchGamesActionListener());
		btnSearchGames.setBounds(99, 16, 117, 29);
		contentPane.add(btnSearchGames);
		
		JButton btnAddGame = new JButton("Add");
		btnAddGame.addActionListener(new BtnAddGameActionListener());
		btnAddGame.setBounds(228, 16, 117, 29);
		contentPane.add(btnAddGame);
		
		JLabel lblGames = new JLabel("Games:");
		lblGames.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblGames.setBounds(34, 21, 61, 16);
		contentPane.add(lblGames);
		
		JLabel lblUsers = new JLabel("Users:");
		lblUsers.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUsers.setBounds(34, 99, 61, 16);
		contentPane.add(lblUsers);
		
		JButton btnSearchUser = new JButton("Search");
		btnSearchUser.addActionListener(new BtnSearchUserActionListener());
		btnSearchUser.setBounds(99, 94, 117, 29);
		contentPane.add(btnSearchUser);
		
		JButton btnAddUser = new JButton("Add");
		btnAddUser.addActionListener(new BtnAddUserActionListener());
		btnAddUser.setBounds(228, 94, 117, 29);
		contentPane.add(btnAddUser);
		
		JLabel lblLoans = new JLabel("Loans:");
		lblLoans.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblLoans.setBounds(34, 179, 61, 16);
		contentPane.add(lblLoans);
		
		JButton btnViewLoans = new JButton("View");
		btnViewLoans.addActionListener(new BtnViewLoansActionListener());
		btnViewLoans.setBounds(99, 174, 117, 29);
		contentPane.add(btnViewLoans);
		
		btnAddLoan = new JButton("Add");
		btnAddLoan.addActionListener(new BtnAddLoanActionListener());
		btnAddLoan.setBounds(228, 174, 117, 29);
		contentPane.add(btnAddLoan);
	}
	
	/**
	 * The ActionListener of btnClearAllFields, as an inner class
	 */
	private class BtnSearchGamesActionListener implements ActionListener {/**
		 * The actionPerformed method will load the GameSearch window
		 */
		public void actionPerformed(ActionEvent e) {
			// Instantiate a GameSearch object
			GameSearch gameSearch = new GameSearch();
			
			// set the visibility of the GameSearch to true.
			gameSearch.setVisible(true);			
			
			//Dispose the current frame
			MainMenu.this.dispose();
		}
	}
	
	/**
	 * The ActionListener of btnClearAllFields, as an inner class
	 */
	private class BtnAddGameActionListener implements ActionListener {
		/**
		 * The actionPerformed method will load the GameAdd window
		 */
		public void actionPerformed(ActionEvent e) {
			// Instantiate a GameAdd object
			GameAdd gameAdd = new GameAdd();
			
			// set the visibility of the GameAdd to true.
			gameAdd.setVisible(true);			
			
			//Dispose the current frame
			MainMenu.this.dispose();
		}
	}
	
	/**
	 * The ActionListener of btnAddUser, as an inner class
	 */
	private class BtnAddUserActionListener implements ActionListener {
		/**
		 * The actionPerformed method will load the UserAdd window
		 */
		public void actionPerformed(ActionEvent e) {
			// Instantiate a UserAdd object
			UserAdd userAdd = new UserAdd();
			
			// set the visibility of the UserAdd to true.
			userAdd.setVisible(true);			
			
			//Dispose the current frame
			MainMenu.this.dispose();
		}
	}
	
	/**
	 * The ActionListener of btnSearchUser, as an inner class
	 */
	private class BtnSearchUserActionListener implements ActionListener {
		/**
		 * The actionPerformed method will load the UserSearch window
		 */
		public void actionPerformed(ActionEvent e) {
			// Instantiate a UserSearch object
			UserSearch UserSearch = new UserSearch();
			
			// set the visibility of the UserSearch to true.
			UserSearch.setVisible(true);			
			
			//Dispose the current frame
			MainMenu.this.dispose();
		}
	}
	
	/**
	 * The ActionListener of btnViewLoans, as an inner class
	 */
	private class BtnViewLoansActionListener implements ActionListener {
		/**
		 * The actionPerformed method will load the LoanRetrieval window
		 */
		public void actionPerformed(ActionEvent e) {
			// Instantiate a LoanRetrieval object
			LoanRetrieval loanRetrieval = new LoanRetrieval();
			
			// set the visibility of the LoanRetrieval to true.
			loanRetrieval.setVisible(true);			
			
			//Dispose the current frame
			MainMenu.this.dispose();
		}
	}
	
	/**
	 * The ActionListener of btnAddLoan, as an inner class
	 */
	private class BtnAddLoanActionListener implements ActionListener {
		/**
		 * The actionPerformed method will load the LoanAdd window
		 */
		public void actionPerformed(ActionEvent e) {
			User user = new User();
			// Instantiate a LoanRetrieval object
			LoanAdd loanAdd = new LoanAdd(user);
			
			// set the visibility of the LoanRetrieval to true.
			loanAdd.setVisible(true);			
			
			//Dispose the current frame
			MainMenu.this.dispose();
		}
	}
}
