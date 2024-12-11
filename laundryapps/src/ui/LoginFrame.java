package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.User;
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
    private JTextField txtUsername;
    private JTextField txtPassword;

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

        txtUsername = new JTextField();
        txtUsername.setBounds(107, 78, 207, 30);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);

        txtPassword = new JTextField();
        txtPassword.setBounds(107, 153, 207, 28);
        contentPane.add(txtPassword);
        txtPassword.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsername.setBounds(107, 44, 187, 23);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(107, 119, 187, 23);
        contentPane.add(lblPassword);

        JLabel lblLoginForm = new JLabel("Login Form");
        lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLoginForm.setBounds(10, 11, 416, 30);
        contentPane.add(lblLoginForm);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLogin.setBounds(157, 214, 110, 30);
        contentPane.add(btnLogin);

        // Action listener for the login button
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(User.login(txtUsername.getText(), txtPassword.getText())) {
                    new MainFrame().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                }
            }
        });
    }
}
