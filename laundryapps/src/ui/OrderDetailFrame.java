package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAO.OrderDetailRepo;
import DAO.ServiceRepo;
import model.OrderDetail;
import model.Service;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class OrderDetailFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtTrx, txtPelanggan, txtTanggal, txtTanggalPengambilan, txtTotalOrder, txtJumlah, txtTotal, txtHarga;
    private JComboBox<String> cbxStatus, cbxPembayaran;
    private JTable tableService, tableOrderDetail;
    private JButton btnSimpanOrder, btnBatalOrder, btnSimpanDetail, btnUbahDetail, btnHapusDetail, btnBatalDetail;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderDetailFrame frame = new OrderDetailFrame();
                    frame.setVisible(true);
                    frame.loadTableService();
                    frame.loadTableDetail();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void loadTableDetail() {
    	  ls_od = repo_od.show();
    	  tableOrderDetail tu = new tableOrderDetail(ls_od);
    	  tableOrderDetail.setModel(tu);
    	  tableOrderDetail.getTableHeader().setVisible(true);
    	}
    public void loadTableService() {
  	  ls_service = sr.show();
  	 TableService tu = new TableService(ls_service);
  	  tableOrderDetail.setModel(tu);
  	  tableOrderDetail.getTableHeader().setVisible(true);
  	}
    
    
    ServiceRepo sr = new ServiceRepo();
    List<Service> ls_service;
    public String id_service;
    public static String txt_pelanggan="";
    
    OrderDetailRepo repo_od = new OrderDetailRepo();
    List<OrderDetail> ls_od;
    public String id_order_detail;
    

    public OrderDetailFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblOrderId = new JLabel("Order ID");
        lblOrderId.setBounds(10, 10, 100, 25);
        contentPane.add(lblOrderId);

        txtTrx = new JTextField();
        txtTrx.setBounds(120, 10, 200, 25);
        contentPane.add(txtTrx);
        txtTrx.setColumns(10);

        JLabel lblPelanggan = new JLabel("Pelanggan");
        lblPelanggan.setBounds(10, 45, 100, 25);
        contentPane.add(lblPelanggan);

        txtPelanggan = new JTextField();
        txtPelanggan.setBounds(120, 45, 200, 25);
        contentPane.add(txtPelanggan);
        txtPelanggan.setColumns(10);

        JLabel lblTanggal = new JLabel("Tanggal");
        lblTanggal.setBounds(10, 80, 100, 25);
        contentPane.add(lblTanggal);

        txtTanggal = new JTextField();
        txtTanggal.setBounds(120, 80, 200, 25);
        contentPane.add(txtTanggal);
        txtTanggal.setColumns(10);

        JLabel lblTanggalPengambilan = new JLabel("Tanggal Pengambilan");
        lblTanggalPengambilan.setBounds(10, 115, 150, 25);
        contentPane.add(lblTanggalPengambilan);

        txtTanggalPengambilan = new JTextField();
        txtTanggalPengambilan.setBounds(170, 115, 150, 25);
        contentPane.add(txtTanggalPengambilan);
        txtTanggalPengambilan.setColumns(10);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(10, 150, 100, 25);
        contentPane.add(lblStatus);

        cbxStatus = new JComboBox<>(new String[]{"Pending", "Completed"});
        cbxStatus.setBounds(120, 150, 200, 25);
        contentPane.add(cbxStatus);

        JLabel lblTotalOrder = new JLabel("Total Order");
        lblTotalOrder.setBounds(10, 185, 100, 25);
        contentPane.add(lblTotalOrder);

        txtTotalOrder = new JTextField();
        txtTotalOrder.setBounds(120, 185, 200, 25);
        contentPane.add(txtTotalOrder);
        txtTotalOrder.setColumns(10);

        JLabel lblPembayaran = new JLabel("Pembayaran");
        lblPembayaran.setBounds(10, 220, 100, 25);
        contentPane.add(lblPembayaran);

        cbxPembayaran = new JComboBox<>(new String[]{"Cash", "Credit"});
        cbxPembayaran.setBounds(120, 220, 200, 25);
        contentPane.add(cbxPembayaran);

        btnSimpanOrder = new JButton("Simpan");
        btnSimpanOrder.setBounds(10, 255, 100, 25);
        contentPane.add(btnSimpanOrder);

        btnBatalOrder = new JButton("Batal");
        btnBatalOrder.setBounds(120, 255, 100, 25);
        contentPane.add(btnBatalOrder);

        JLabel lblHarga = new JLabel("Harga");
        lblHarga.setBounds(350, 131, 38, 25);
        contentPane.add(lblHarga);

        txtHarga = new JTextField();
        txtHarga.setBounds(398, 131, 150, 25);
        contentPane.add(txtHarga);
        txtHarga.setColumns(10);

        tableService = new JTable();
        tableService.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		id_service = tableService.getValueAt(tableService.getSelectedRow(), 0).toString();
        		txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(), 3).toString());
        		
        		if(!txtJumlah.getText().isEmpty()) {
        			txtTotal.setText(""+total(txtJumlah.getText()));
        		}
        	}
        });
        tableService.setBounds(350, 10, 405, 102);
        contentPane.add(tableService);

        JLabel lblJumlah = new JLabel("Jumlah");
        lblJumlah.setBounds(350, 200, 38, 25);
        contentPane.add(lblJumlah);

        txtJumlah = new JTextField();
        txtJumlah.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		String value_jumlah = txtJumlah. getText().toString();
				txtTotal.setText(""+total(value_jumlah));
        	}
        });
        
        txtJumlah.setBounds(398, 200, 150, 25);
        contentPane.add(txtJumlah);
        txtJumlah.setColumns(10);

        JLabel lblTotal = new JLabel("Total");
        lblTotal.setBounds(558, 200, 38, 25);
        contentPane.add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(608, 200, 150, 25);
        contentPane.add(txtTotal);
        txtTotal.setColumns(10);

        btnSimpanDetail = new JButton("Simpan");
        btnSimpanDetail.setBounds(336, 269, 100, 25);
        contentPane.add(btnSimpanDetail);

        btnUbahDetail = new JButton("Ubah");
        btnUbahDetail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (id_order_detail != null) {
                    OrderDetail od = new OrderDetail();
                    od.setOrder_id(txtTrx.getText());
                    od.setService_id(id_service);
                    od.setHarga(txtHarga.getText());
                    od.setJumlah(txtJumlah.getText());
                    od.setTotal(txtTotal.getText());
                    od.setId(id_order_detail);
                    repo_od.update(od);
                    loadTableDetail();
                    reset();
                    txtTotalOrder.setText("" + repo_od.total(txtTrx.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "silahkan pilih order terlebih dahulu");
                }
        	}
        });
        btnUbahDetail.setBounds(446, 269, 100, 25);
        contentPane.add(btnUbahDetail);

        btnHapusDetail = new JButton("Hapus");
        btnHapusDetail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(id_order_detail != null) {
        			repo_od.delete(id_order_detail);
        			reset();
        			loadTableDetail();
        			txtTotalOrder.setText(""+repo_od.total(txtTrx.getText()));
        			}else {
        			JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
        			}
        	}
        });
        
        btnHapusDetail.setBounds(556, 269, 100, 25);
        contentPane.add(btnHapusDetail);

        btnBatalDetail = new JButton("Batal");
        btnBatalDetail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnBatalDetail.setBounds(663, 270, 100, 25);
        contentPane.add(btnBatalDetail);

        tableOrderDetail = new JTable();
        tableOrderDetail.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		id_order_detail = tableOrderDetail.getValueAt(tableOrderDetail. getSelectedRow(),0).toString();
        		id_service = tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(),2).toString();
        		txtHarga.setText( tableOrderDetail. getValueAt(tableOrderDetail.getSelectedRow(),3).toString());
        		txtTotal.setText(tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(),5).toString());
        		txtJumlah. setText(tableOrderDetail.getValueAt(tableOrderDetail. getSelectedRow(),4).toString());

        		
        	}
        });
        tableOrderDetail.setBounds(23, 302, 740, 250);
        contentPane.add(tableOrderDetail);
    }
    public double total(String jumlah) {
    double result = 0;
    if(jumlah.isEmpty()) {
    result=0;
    result = Double.parseDouble(jumlah) * Double.parseDouble(txtHarga.getText());
    }
    return result;
    
    }
    public void reset() {
    txtHarga.setText("");
    txtJumlah.setText("");
    txtTotal.setText("");
    id_service=null;
    id_order_detail=null;
}
}
