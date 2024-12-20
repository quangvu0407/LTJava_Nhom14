package GiaoDien;

import Lop.Student;
import Lop.Xe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QuanLyXe extends JDialog {
    private JTextField soxeField;
    private JTextField sogheField;
    private JTextField tenField;
    private JTextField sdtField;
    private JTextField biensoField;
    private JButton confirmButton;
    private Xe xe;
    private QuanLyXeC parent;
    private ArrayList<Xe> listXe = Xe.loadDataFromFile();

    public QuanLyXe(QuanLyXeC parent, Xe xe) {
        this.parent = parent;
        this.xe = xe;
        setTitle(xe == null ? "Thêm Xe" : "Sửa Xe");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 7, 7)); 
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30 ,30));

        panel.add(new JLabel("Mã Số Xe:"));
        soxeField = new JTextField(xe == null ? "" : xe.getMaSoXe());
        soxeField.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
        panel.add(soxeField);

        panel.add(new JLabel("Số ghế:"));
        sogheField = new JTextField(xe == null ? "" : xe.getSoGhe());
        sogheField.setBorder(BorderFactory.createLineBorder(Color.BLACK));    
        panel.add(sogheField);

        panel.add(new JLabel("Tên tài xế:"));
        tenField = new JTextField(xe == null ? "" : xe.getTenTaiXe());
        tenField.setBorder(BorderFactory.createLineBorder(Color.BLACK));    
        panel.add(tenField);

        panel.add(new JLabel("SĐT:"));
        sdtField = new JTextField(xe == null ? "" : xe.getSdt());
        sdtField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(sdtField);

        panel.add(new JLabel("Biển Số Xe:"));
        biensoField = new JTextField(xe == null ? "" : xe.getBienSo());
        biensoField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(biensoField);

        confirmButton = new JButton("Xác nhận");
        confirmButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Xe newXe = new Xe(
                            soxeField.getText(),
                            sogheField.getText(),
                            tenField.getText(),
                            sdtField.getText(),
                            biensoField.getText()
                    );

                    if (xe == null) {
                        parent.addXe(newXe);
                    } else {
                        int rowIndex = parent.table.getSelectedRow();
                        parent.updateXe(rowIndex, newXe);
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

    private boolean validateFields() {
        if (soxeField.getText().isEmpty() || sogheField.getText().isEmpty() || 
            tenField.getText().isEmpty() || sdtField.getText().isEmpty() || 
            biensoField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return false;
        }

        if(Integer.parseInt(sogheField.getText()) < 4){
            JOptionPane.showMessageDialog(this, "Số ghế ngồi ít nhất phải là 4!");
            return false;
        }
        if (sdtField.getText().length() != 9 && sdtField.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là 9 hoặc 10 số");
            return false;
        }

        if (xe != null) {
            for (Xe xexe : listXe) {
                if (!xexe.getBienSo().equals(xe.getBienSo()) && biensoField.getText().equals(xexe.getBienSo())) {
                    JOptionPane.showMessageDialog(this, "Biển số xe đã tồn tại");
                    return false;
                }
                if (!xexe.getMaSoXe().equals(xe.getMaSoXe()) && soxeField.getText().equals(xexe.getMaSoXe())) {
                    JOptionPane.showMessageDialog(this, "Mã số xe đã tồn tại");
                    return false;
                }
            }
        }

        if (xe == null) {
            for (Xe xexe : listXe) {
                if (biensoField.getText().equals(xexe.getBienSo())) {
                    JOptionPane.showMessageDialog(this, "Biển số xe đã tồn tại");
                    return false;
                }
                if (soxeField.getText().equals(xexe.getMaSoXe())) {
                    JOptionPane.showMessageDialog(this, "Mã số xe đã tồn tại");
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for(Xe xe: Xe.loadDataFromFile()){
            System.out.println(xe);
        }
    }
}
