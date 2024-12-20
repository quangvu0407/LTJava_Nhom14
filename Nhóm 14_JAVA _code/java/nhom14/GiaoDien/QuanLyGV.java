package GiaoDien;

import Lop.GiangVien;
import Lop.Xe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QuanLyGV extends JDialog {
    JTextField maGVField;
    private ArrayList<Xe> listXe = Xe.loadDataFromFile();
    private JTextField tenField;
    private JTextField sdtField;
    private JTextField diaChiField;
    private JTextField gioitinhField;
    private JTextField soxeField;
    private JButton confirmButton;
    private GiangVien giangVien;
    private QuanLyGiangVien parent;
    private ArrayList<GiangVien> giangViens = GiangVien.getDSGiangVien();

    public QuanLyGV(QuanLyGiangVien parent, GiangVien giangVien) {
        this.parent = parent;
        this.giangVien = giangVien;
        setTitle(giangVien == null ? "Thêm Giảng Viên" : "Sửa Giảng Viên");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 7, 7)); 
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30 ,30));

        panel.add(new JLabel("Mã Giảng Viên:"));
        maGVField = new JTextField(giangVien == null ? "" : giangVien.getMaGiangVien());
        maGVField.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
        panel.add(maGVField);

        panel.add(new JLabel("Tên:"));
        tenField = new JTextField(giangVien == null ? "" : giangVien.getTen());
        tenField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(tenField);

        panel.add(new JLabel("SĐT:"));
        sdtField = new JTextField(giangVien == null ? "" : giangVien.getSdt());
        sdtField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(sdtField);

        panel.add(new JLabel("Địa Chỉ:"));
        diaChiField = new JTextField(giangVien == null ? "" : giangVien.getDiaChi());
        diaChiField.setBorder(BorderFactory.createLineBorder(Color.BLACK));    
        panel.add(diaChiField);

        panel.add(new JLabel("Mã Số Xe:"));
        soxeField = new JTextField(giangVien == null ? "" : giangVien.getSoxe());
        soxeField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(soxeField);

        panel.add(new JLabel("Giới Tính:"));
        gioitinhField = new JTextField(giangVien == null ? "" : giangVien.getGioitinh());
        gioitinhField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(gioitinhField);

        confirmButton = new JButton("Xác nhận");
        confirmButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    GiangVien newGiangVien = new GiangVien(
                            maGVField.getText(),
                            tenField.getText(),
                            sdtField.getText(),
                            diaChiField.getText(),
                            soxeField.getText(),
                            gioitinhField.getText()
                    );

                    if (giangVien == null) {
                        parent.addGiangVien(newGiangVien);
                    } else {
                        int rowIndex = parent.table.getSelectedRow();
                        parent.updateGiangVien(rowIndex, newGiangVien);
                    }
                    dispose();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getMaGVField(){
        return maGVField.getText();
    }

    private boolean validateFields() {
        boolean xeExists = false;
        for (Xe xe : listXe) {
            if (soxeField.getText().equals(xe.getMaSoXe())) {
                xeExists = true;
                break;
            }
        }

        if (maGVField.getText().isEmpty() || tenField.getText().isEmpty() ||
            sdtField.getText().isEmpty() || diaChiField.getText().isEmpty() ||
            gioitinhField.getText().isEmpty() || soxeField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return false;
        }

        if (giangVien != null) {
            for (GiangVien gv : giangViens) {
                if (!gv.getMaGiangVien().equals(giangVien.getMaGiangVien()) && maGVField.getText().equals(gv.getMaGiangVien())) {
                    JOptionPane.showMessageDialog(this, "Mã giảng viên đã tồn tại");
                    return false;
                }
                if (!gv.getSdt().equals(giangVien.getSdt()) && sdtField.getText().equals(gv.getSdt())) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                    return false;
                }
            }
        }

        if (giangVien == null) {
            for (GiangVien gv : giangViens) {
                if (maGVField.getText().equals(gv.getMaGiangVien())) {
                    JOptionPane.showMessageDialog(this, "Mã giảng viên đã tồn tại");
                    return false;
                }
                if (sdtField.getText().equals(gv.getSdt())) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                    return false;
                }
            }
        }

        if (sdtField.getText().length() != 9 && sdtField.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là 9 hoặc 10 số");
            return false;
        }

        if (!xeExists) {
            JOptionPane.showMessageDialog(this, "Mã xe không tồn tại!");
            return false;
        }

        if (!gioitinhField.getText().equalsIgnoreCase("Nam") && !gioitinhField.getText().equalsIgnoreCase("Nữ") && !gioitinhField.getText().equalsIgnoreCase("Nu")) {
            JOptionPane.showMessageDialog(this, "Giới tính phải là 'Nam' hoặc 'Nữ'");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        for(Xe xe: Xe.loadDataFromFile()){
            System.out.println(xe);
        }
    }
}
