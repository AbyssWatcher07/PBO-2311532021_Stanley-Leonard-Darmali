package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import model.Customer;
import model.CustomerBuilder;
import table.TableCustomer;
import DAO.CustomerRepo;
import javax.swing.table.DefaultTableModel;

public class CustomerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtCustomerName;
	private JTextField txtCustomerAddress;
	private JTextField txtCustomerPhone;
	private JTextField txtCustomerEmail;
	private JTable tableCustomers;
	private CustomerRepo repo;

	String id;

	List<Customer> ls;

	CustomerRepo customerRepo = new CustomerRepo();

	public CustomerFrame() {
		repo = new CustomerRepo();
		initComponents();
	}

	private void initComponents() {
		setTitle("PELANGGAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(10, 14, 100, 14);
		getContentPane().add(lblNama);

		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setBounds(10, 39, 100, 14);
		getContentPane().add(lblAlamat);

		JLabel lblHp = new JLabel("No HP");
		lblHp.setBounds(10, 64, 100, 14);
		getContentPane().add(lblHp);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 89, 100, 14);
		getContentPane().add(lblEmail);

		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(120, 11, 200, 20);
		getContentPane().add(txtCustomerName);
		txtCustomerName.setColumns(10);

		txtCustomerAddress = new JTextField();
		txtCustomerAddress.setBounds(120, 36, 200, 20);
		getContentPane().add(txtCustomerAddress);
		txtCustomerAddress.setColumns(10);

		txtCustomerPhone = new JTextField();
		txtCustomerPhone.setBounds(120, 61, 200, 20);
		getContentPane().add(txtCustomerPhone);
		txtCustomerPhone.setColumns(10);

		txtCustomerEmail = new JTextField();
		txtCustomerEmail.setBounds(120, 86, 200, 20);
		getContentPane().add(txtCustomerEmail);
		txtCustomerEmail.setColumns(10);

		JButton btnSave = new JButton("Simpan");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new CustomerBuilder().setNama(txtCustomerName.getText())
						.setAlamat(txtCustomerAddress.getText()).setHp(txtCustomerPhone.getText())
						.setEmail(txtCustomerEmail.getText()).build();
				customerRepo.save(customer);
				reset();
				loadTable();
			}
		});

		btnSave.setBounds(10, 114, 89, 23);
		getContentPane().add(btnSave);

		JButton btnCancel = new JButton("Batal");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnCancel.setBounds(109, 114, 89, 23);
		getContentPane().add(btnCancel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 464, 202);
		getContentPane().add(scrollPane);

		tableCustomers = new JTable();
		tableCustomers.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Id", "Nama", "Email", "Alamat", "HP" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableCustomers.getColumnModel().getColumn(0).setPreferredWidth(23);
		scrollPane.setViewportView(tableCustomers);

		JPanel panel = new JPanel();
		panel.setBounds(-46, 181, 576, 357);
		getContentPane().add(panel);
		JScrollPane scrollPaneNew = new JScrollPane();
		scrollPaneNew.setBounds(10, 10, 529, 307);
		panel.add(scrollPaneNew);
		JTable tableCustomersNew = new JTable();
		scrollPaneNew.setViewportView(tableCustomersNew);
		tableCustomersNew.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Add your event handling code here
			}
		});

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadTable() {
		ls = customerRepo.show();
		TableCustomer tc = new TableCustomer(ls);
		tableCustomers.setModel(tc);
		tableCustomers.getTableHeader().setVisible(true);
	}

	public void reset() {
		txtCustomerName.setText("");
		txtCustomerAddress.setText("");
		txtCustomerPhone.setText("");
		txtCustomerEmail.setText("");
	}
}
