package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener {
	public QLSVView view;

	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String c = e.getActionCommand();
		// JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: " + c);
		if (c.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if (c.equals("Lưu")) {

			try {
				// Get du lieu
				this.view.thucHienThem();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} else if (c.equals("Cập Nhật")) {
			this.view.hienThiThongTinThiSinhChon();

		} else if (c.equals("Xóa")) {
			this.view.thucHienXoa();
		} else if (c.equals("Hủy")) {
			this.view.xoaForm();
		} else if (c.equals("Tìm")) {
			JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: " + c);
			this.view.thucHienTim();

		} else if (c.equals("Hủy tìm")) {
			this.view.huyTim();

		} else if (c.equals("About Me")) {
			this.view.hienThiAbout();

		} else if (c.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();

		}
		else if(c.equals("Save")) {
			
			this.view.thucHienSaveFile();
	}
		else if(c.equals("Open")) {
			this.view.thucHienOpenFile();
	}

}}
