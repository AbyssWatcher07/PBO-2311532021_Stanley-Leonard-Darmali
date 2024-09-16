package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laundry App");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(32, 24, 195, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Laporan");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(150, 141, 111, 57);
		contentPane.add(btnNewButton);
		
		JButton btnPengguna = new JButton("Pengguna");
		btnPengguna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPengguna.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPengguna.setBounds(29, 141, 111, 57);
		contentPane.add(btnPengguna);
		
		JButton btnPesanan = new JButton("Pesanan");
		btnPesanan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPesanan.setBounds(29, 72, 111, 57);
		contentPane.add(btnPesanan);
		
		JButton btnLayanan = new JButton("Layanan");
		btnLayanan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLayanan.setBounds(150, 72, 111, 57);
		contentPane.add(btnLayanan);
		
		JButton btnPelanggan = new JButton("Pelanggan");
		btnPelanggan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPelanggan.setBounds(271, 72, 111, 57);
		contentPane.add(btnPelanggan);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnProfile.setBounds(271, 141, 111, 57);
		contentPane.add(btnProfile);
		
		JButton btnNewButton_1 = new JButton("Keluar");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(30, 209, 353, 43);
		contentPane.add(btnNewButton_1);
	}

}
