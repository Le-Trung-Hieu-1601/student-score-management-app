package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_TimKIem;
	public JTable table;
	public JTable table_1;
	public JTable table_2;
	public JTable table_4;
	public JTable table_3;
	public JTextField textField_mssv;
	public JTextField textField_hoTen;
	public JTextField textField_ngaySinh;
	public JTextField textField_diem1;
	public JTextField textField_diem2;
	public JTextField textField_diem3;
	public JComboBox comboBox_queQuan2;
	public ButtonGroup buttonGroup;
	public JButton btnLuu;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
	public  JComboBox combo_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 574);
		QLSVController ac = new QLSVController(this);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu MenuFile = new JMenu("File");
		MenuFile.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		menuBar.add(MenuFile);

		JMenuItem MenuOpen = new JMenuItem("Open");
		MenuOpen.addActionListener(ac);
		MenuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		MenuFile.add(MenuOpen);

		JMenuItem MenuSave = new JMenuItem("Save");
		MenuSave.addActionListener(ac);
		MenuSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		MenuFile.add(MenuSave);

		JSeparator separator = new JSeparator();
		MenuFile.add(separator);

		JMenuItem MenuExit = new JMenuItem("Exit");
		MenuExit.addActionListener(ac);
		MenuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		MenuFile.add(MenuExit);

		JMenu MenuAbout = new JMenu("About");
		MenuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(MenuAbout);

		JMenuItem MenuAboutMe = new JMenuItem("About Me");
		 MenuAboutMe.addActionListener(ac);
		MenuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		MenuAbout.add(MenuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQuQun = new JLabel("Quê quán ");
		lblQuQun.setBounds(0, 15, 92, 29);
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblQuQun);

		JLabel Label_MSSV = new JLabel("MSSV ");
		Label_MSSV.setBounds(204, 10, 52, 38);
		Label_MSSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(Label_MSSV);

		textField_TimKIem = new JTextField();
		textField_TimKIem.setBounds(254, 15, 116, 29);
		contentPane.add(textField_TimKIem);
		textField_TimKIem.setColumns(10);

		JButton btnTim = new JButton("Tìm");
		btnTim.setBounds(380, 15, 85, 29);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTim.addActionListener(ac);
		contentPane.add(btnTim);

		 combo_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDsTinh();
		combo_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			combo_timKiem.addItem(tinh.getTenTinh());
		}
		combo_timKiem.setBounds(85, 15, 109, 28);
		contentPane.add(combo_timKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 68, 502, 2);
		contentPane.add(separator_1);

		JLabel lblDanhSchSv = new JLabel("Danh sách sinh viên");
		lblDanhSchSv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDanhSchSv.setBounds(0, 85, 171, 29);

		table_3 = new JTable();
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_3.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "MSSV", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ngày Sinh", "Gi\u1EDBi t\u00EDnh",
						"\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));
		table_3.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table_3);
		scrollPane.setBounds(0, 107, 552, 124);

		contentPane.add(scrollPane);

		JLabel lblDanhSchSinh = new JLabel("Danh sách sinh viên");
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDanhSchSinh.setBounds(0, 68, 169, 29);
		contentPane.add(lblDanhSchSinh);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 241, 502, 2);
		contentPane.add(separator_1_1);

		JLabel lblThngTinSinh = new JLabel("Thông tin sinh viên ");
		lblThngTinSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThngTinSinh.setBounds(0, 241, 169, 29);
		
		contentPane.add(lblThngTinSinh);

		JLabel Label_MSSV_1 = new JLabel("MSSV ");
		Label_MSSV_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_MSSV_1.setBounds(0, 280, 52, 22);
		contentPane.add(Label_MSSV_1);

		textField_mssv = new JTextField();
		textField_mssv.setColumns(10);
		textField_mssv.setBounds(85, 285, 154, 26);
		contentPane.add(textField_mssv);

		JLabel Label_HoTen = new JLabel("Họ và tên");
		Label_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_HoTen.setBounds(0, 324, 78, 22);
		contentPane.add(Label_HoTen);

		textField_hoTen = new JTextField();
		textField_hoTen.setColumns(10);
		textField_hoTen.setBounds(85, 321, 154, 36);
		contentPane.add(textField_hoTen);

		JLabel Label_queQuan = new JLabel("Quê quán");
		Label_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_queQuan.setBounds(0, 366, 79, 22);
		contentPane.add(Label_queQuan);

		JLabel Label_ngaySinh = new JLabel("Ngày Sinh");
		Label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_ngaySinh.setBounds(0, 410, 82, 22);
		contentPane.add(Label_ngaySinh);

		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(85, 410, 154, 29);
		contentPane.add(textField_ngaySinh);

		comboBox_queQuan2 = new JComboBox();
		comboBox_queQuan2.setBounds(85, 370, 154, 29);

		comboBox_queQuan2.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan2.addItem(tinh.getTenTinh());
		}
		contentPane.add(comboBox_queQuan2);

		JLabel Label_gioiTinh = new JLabel("Giới Tính");
		Label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_gioiTinh.setBounds(254, 280, 71, 22);
		contentPane.add(Label_gioiTinh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNam.setBounds(338, 281, 78, 21);
		contentPane.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNu.setBounds(418, 281, 78, 21);
		contentPane.add(rdbtnNu);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNam);
		buttonGroup.add(rdbtnNu);

		textField_diem1 = new JTextField();
		textField_diem1.setColumns(10);
		textField_diem1.setBounds(354, 329, 96, 19);
		contentPane.add(textField_diem1);

		JLabel Label_diem1 = new JLabel("Điểm 1");
		Label_diem1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_diem1.setBounds(254, 324, 58, 22);
		contentPane.add(Label_diem1);

		textField_diem2 = new JTextField();
		textField_diem2.setColumns(10);
		textField_diem2.setBounds(354, 371, 96, 19);
		contentPane.add(textField_diem2);

		textField_diem3 = new JTextField();
		textField_diem3.setColumns(10);
		textField_diem3.setBounds(354, 415, 96, 19);
		contentPane.add(textField_diem3);

		JLabel Label_diem2 = new JLabel("Điểm 2");
		Label_diem2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_diem2.setBounds(254, 366, 58, 22);
		contentPane.add(Label_diem2);

		JLabel Label_diem3 = new JLabel("Điểm 3");
		Label_diem3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_diem3.setBounds(254, 410, 58, 22);
		contentPane.add(Label_diem3);

		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(ac);

		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm.setBounds(0, 466, 85, 29);
		contentPane.add(btnThm);

		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(ac);
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXa.setBounds(121, 466, 85, 29);
		contentPane.add(btnXa);

		JButton btnSa = new JButton("Cập Nhật");
		btnSa.addActionListener(ac);
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSa.setBounds(226, 466, 109, 29);
		contentPane.add(btnSa);

		btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(ac);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(353, 466, 85, 29);
		contentPane.add(btnLuu);

		JButton btnThot = new JButton("Hủy");
		btnThot.addActionListener(ac);
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThot.setBounds(467, 466, 85, 29);
		contentPane.add(btnThot);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(-8, 454, 512, 2);
		contentPane.add(separator_1_1_1);

		JButton btnHyTm = new JButton("Hủy tìm");
		btnHyTm.addActionListener(ac);

		btnHyTm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHyTm.setBounds(475, 16, 85, 29);
		contentPane.add(btnHyTm);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_mssv.setText("");
		textField_hoTen.setText("");
		textField_ngaySinh.setText("");
		textField_TimKIem.setText("");
		textField_diem1.setText("");
		textField_diem2.setText("");
		textField_diem3.setText("");
		comboBox_queQuan2.setSelectedIndex(-1);
		buttonGroup.clearSelection();

	}
public void themSinhVienVaoTable(ThiSinh ts) {
	DefaultTableModel model_table = (DefaultTableModel) table_3.getModel();
	model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
			"", (ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
			ts.getDiemMon3() + "",

	});

}
	public void themHoacCapNhatSinhVien(ThiSinh ts) {

		DefaultTableModel model_table = (DefaultTableModel) table_3.getModel();
		boolean n = this.model.kiemTraTonTai(ts);
		if (!n) {

			// TODO Auto-generated method stub
			this.model.insert(ts);
			this.themSinhVienVaoTable(ts);

		} else {
			this.model.update(ts);

			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);

					model_table.setValueAt(ts.isGioiTinh() ? "Nam" : "Nữ" + "", i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);

					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);

				}

			}

		}
	}

	public ThiSinh getThiSinh() {
		DefaultTableModel model_table = (DefaultTableModel) table_3.getModel();
		int i_row = table_3.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";

		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		// Chuỗi ngày tháng
		boolean gioiTinh = textGioiTinh.equals("Nam");

		float diemMon1, diemMon2, diemMon3;
		diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, null, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhChon() {
		// TODO Auto-generated method stub
		ThiSinh ts = getThiSinh();

		this.textField_mssv.setText(ts.getMaThiSinh() + "");
		this.textField_hoTen.setText(ts.getTenThiSinh());
		this.comboBox_queQuan2.setSelectedItem(ts.getQueQuan().getTenTinh());
		this.buttonGroup.setSelected(null, ts.isGioiTinh());
		this.textField_diem1.setText(ts.getDiemMon1() + "");
		this.textField_diem2.setText(ts.getDiemMon2() + "");
		this.textField_diem3.setText(ts.getDiemMon3() + "");

	}

	public void thucHienXoa() {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel) table_3.getModel();
		int i_row = table_3.getSelectedRow();
		ThiSinh ts = getThiSinh();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn Xóa");
		if (luaChon == JOptionPane.YES_OPTION) {
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienTim() {
		// TODO Auto-generated method stub
		//Goi ham huy tim Kiem
		this.huyTim();
		
		
		//Thuc Hien Tim Kiem
		int queQuan = this.combo_timKiem.getSelectedIndex() - 1;
		String tenTs = this.textField_TimKIem.getText();
		String maThiSinhtimKiem = this.textField_TimKIem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table_3.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> cacIDcuaThiSinhcanxoa = new TreeSet<Integer>();
		if (queQuan >= 0) {

			Tinh tinhdachon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String maThiSinh = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhdachon.getTenTinh())) {
					cacIDcuaThiSinhcanxoa.add(Integer.valueOf(maThiSinh));

				}

			}
		}
		if (tenTs.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {

				String maThiSinh = model_table.getValueAt(i, 0) + "";
				if (!maThiSinh.equals(maThiSinhtimKiem)) {
					cacIDcuaThiSinhcanxoa.add(Integer.valueOf(maThiSinh));

				}
			}
		}
		for (Integer idCanXoa : cacIDcuaThiSinhcanxoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " + idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienThem() {
		// TODO Auto-generated method stub
		int maThiSinh = Integer.valueOf(this.textField_mssv.getText());
		String tenThiSinh = this.textField_hoTen.getText();
		int queQuan = this.comboBox_queQuan2.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		// Chuỗi ngày tháng
		boolean gioiTinh = true;

		if (this.rdbtnNam.isSelected()) {
			gioiTinh = true;
		} else if (this.rdbtnNu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1, diemMon2, diemMon3;
		diemMon1 = Float.valueOf(this.textField_diem1.getText());
		diemMon2 = Float.valueOf(this.textField_diem2.getText());
		diemMon3 = Float.valueOf(this.textField_diem3.getText());
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, null, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatSinhVien(ts);
	}

	public void huyTim() {
		while(true) {
		DefaultTableModel model_table = (DefaultTableModel) table_3.getModel();
		// TODO Auto-generated method stub
		int soLuongDong = model_table.getRowCount();
		if(soLuongDong==0)
		break;
		else
			
		try {
			model_table.removeRow(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themSinhVienVaoTable(ts);
		}
		
	
	}

	public void hienThiAbout() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "Phần mềm quản lí Sinh viên của nhóm 16" );
	}
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn Thoát ?","Exit",JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList ds = new ArrayList();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table_3.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themSinhVienVaoTable(ts);
		}
	}
}
