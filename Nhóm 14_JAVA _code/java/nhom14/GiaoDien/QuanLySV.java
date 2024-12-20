package GiaoDien;

import Lop.Xe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Lop.Student;

public class QuanLySV extends JDialog {
    JTextField idField;
    private ArrayList<Xe> listXe = Xe.loadDataFromFile();
    private JTextField nameField;
    private JTextField sdtField;
    private JTextField lopField;
    private JTextField addressField;
    private JTextField gioitinhField;
    private JTextField soxeField;
    private JButton confirmButton;
    private Student student;
    private QuanLySinhVien parent;
    private ArrayList<Student> studentds = Student.getDStudents();

    public QuanLySV(QuanLySinhVien parent, Student student) {
        this.parent = parent;
        this.student = student;
        setTitle(student == null ? "Thêm Sinh Viên" : "Sửa Sinh Viên");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 7, 7)); 
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30 ,30));

        panel.add(new JLabel("ID:"));
        idField = new JTextField(student == null ? "" : student.getId());
        idField.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField(student == null ? "" : student.getName());
        nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(nameField);

        panel.add(new JLabel("SĐT:"));
        sdtField = new JTextField(student == null ? "" : student.getSdt());
        sdtField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(sdtField);

        panel.add(new JLabel("Lớp:"));
        lopField = new JTextField(student == null ? "" : student.getLop());
        lopField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(lopField);

        panel.add(new JLabel("Địa chỉ:"));
        addressField = new JTextField(student == null ? "" : student.getAddress());
        addressField.setBorder(BorderFactory.createLineBorder(Color.BLACK));    
        panel.add(addressField);

        panel.add(new JLabel("Mã số xe:"));
        soxeField = new JTextField(student == null ? "" : student.getSoXe());
        soxeField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(soxeField);

        panel.add(new JLabel("Giới tính:"));
        gioitinhField = new JTextField(student == null ? "" : student.getGioiTinh());
        gioitinhField.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        panel.add(gioitinhField);

        confirmButton = new JButton("Xác nhận");
        confirmButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Student newStudent = new Student(
                            idField.getText(),
                            nameField.getText(),
                            sdtField.getText(),
                            lopField.getText(),
                            addressField.getText(),
                            soxeField.getText(),
                            gioitinhField.getText()
                    );

                    if (student == null) {
                        parent.addSinhVien(newStudent);
                    } else {
                        int rowIndex = parent.table.getSelectedRow();
                        parent.updateSinhVien(rowIndex, newStudent);
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
    public String getidField(){
        return idField.getText();
    }

    private boolean validateFields() {
        boolean xeExists = false;
        for (Xe xe : listXe) {
            if (soxeField.getText().equals(xe.getMaSoXe())) {
                xeExists = true;
                break;
            }
        }
    
        if (idField.getText().isEmpty() || nameField.getText().isEmpty() ||
            sdtField.getText().isEmpty() || lopField.getText().isEmpty() ||
            addressField.getText().isEmpty() || gioitinhField.getText().isEmpty() ||
            soxeField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return false;
        }

        if (student != null) {
            for (Student studentt : studentds) {
                if (!studentt.getId().equals(student.getId()) && idField.getText().equals(studentt.getId())) {
                    JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại");
                    return false;
                }
                if (!studentt.getSdt().equals(student.getSdt()) && sdtField.getText().equals(studentt.getSdt())) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                    return false;
                }
            }
        }
    
        if (student == null) {
            for (Student studentt : studentds) {
                if (idField.getText().equals(studentt.getId())) {
                    JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại");
                    return false;
                }
                if (sdtField.getText().equals(studentt.getSdt())) {
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
