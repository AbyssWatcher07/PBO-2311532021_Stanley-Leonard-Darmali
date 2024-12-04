package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import error.ValidationException;
import model.User;
import service.LoginService;
import util.ValidationUtil;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Username;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userValue = Username.getText();
				String passValue = Password.getText();
				
				// Create user object
				User user = new User(userValue, passValue);
				
	    	try {
				ValidationUtil.validate(user);
				LoginService loginService = new LoginService();
				if(loginService.authenticate(user)) {
					System.out.println("Login successful!");
					new MainFrame().setVisible(true);
				dispose();
				}
				else {
					System.out.println("Invalid username or passwor.d");
					JOptionPane.showMessageDialog(null, "Login Gagal, Invalid username or password.");
				}
	    	}catch(ValidationException | NullPointerException exception) {
				System.out.println("Data tidak valid : " + exception.getMessage());
				JOptionPane. showMessageDialog(null, "Login Gagal: "+ exception.getMessage());
	    	}finally {			
	    		System.out.println("Selalu di eksekusi");
	    	}
			}
	    	});
			
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(157, 214, 110, 30);
		contentPane.add(btnNewButton);
		
		Username = new JTextField();
		Username.setBounds(107, 78, 207, 30);
		contentPane.add(Username);
		Username.setColumns(10);
		
		Password = new JTextField();
		Password.setBounds(107, 153, 207, 28);
		contentPane.add(Password);
		Password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(107, 119, 187, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(107, 44, 187, 23);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Login Form");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 416, 30);
		contentPane.add(lblNewLabel_1);
	}
}
