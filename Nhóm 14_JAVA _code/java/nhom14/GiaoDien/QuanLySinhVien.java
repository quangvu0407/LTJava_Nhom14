package GiaoDien;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import Lop.Student;
import java.util.ArrayList;

public class QuanLySinhVien extends JFrame {
    JTable table;
    private DefaultTableModel model;
    private ArrayList<Student> sinhVienList;

    public QuanLySinhVien() {
        sinhVienList = Student.getDStudents();
        setTitle("Quản lý Sinh Viên");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(new Color(224, 238, 238));

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Quản lý Sinh Viên", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // back
        JButton back = new JButton("Quay lại");
        back.setBounds(10, 10, 80, 20);
        back.setBackground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(255, 231, 186), 1));
        back.setFocusPainted(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new TrangChu().setVisible(true); 
            }
        });
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back.setBackground(Color.LIGHT_GRAY); 
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back.setBackground(Color.WHITE); 
            }
        });
        mainPanel.add(back);
        // Table
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] { "ID", "Name", "SĐT", "Lớp", "Địa chỉ", "Mã Số Xe", "Giới tính" });
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            scrollPane.getBorder(),
            BorderFactory.createEmptyBorder(10, 10, 10, 10) 
        ));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Thêm");
        addButton.setFocusPainted(false);
        addButton.setBackground(new Color(240, 255, 255));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddOrEditDialog(null);
            }
        });

        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButton.setBackground(new Color(255, 48, 48));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButton.setBackground(new Color(240, 255, 255)); 
            }
        });
        JButton editButton = new JButton("Sửa");
        editButton.setFocusPainted(false);
        editButton.setBackground(new Color(224, 238, 238));
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Student selectedStudent = sinhVienList.get(selectedRow);
                    openAddOrEditDialog(selectedStudent); // open dialog to edit selected student
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên để sửa");
                }
            }
        });
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButton.setBackground(new Color(151, 255, 255));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButton.setBackground(new Color(224, 238, 238)); 
            }
        });

        JButton deleteButton = new JButton("Xóa");
        deleteButton.setFocusPainted(false);
        deleteButton.setBackground(new Color(193, 205, 205));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteSinhVien();
            }
        });
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButton.setBackground(new Color(255, 20, 147));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButton.setBackground(new Color(193, 205, 205)); 
            }
        });

        JButton detailButton = new JButton("Chi Tiết");
        detailButton.setFocusPainted(false);
        detailButton.setBackground(new Color(131, 139, 139));
        detailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStudentDetail();
            }
        });
        detailButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                detailButton.setBackground(new Color(255, 231, 186));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                detailButton.setBackground(new Color(131, 139, 139)); 
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(detailButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
        loadDataToTable();
    }

    private void loadDataToTable() {
        model.setRowCount(0);

        for (Student student : sinhVienList) {
            model.addRow(new Object[] {
                student.getId(),
                student.getName(),
                student.getSdt(),
                student.getLop(),
                student.getAddress(),
                student.getSoXe(),
                student.getGioiTinh()
            });
        }
    }

    private void deleteSinhVien() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            sinhVienList.remove(selectedRow);
            model.removeRow(selectedRow);
        }
    }

    private void openAddOrEditDialog(Student student) {
        QuanLySV dialog = new QuanLySV(this, student);
        dialog.setVisible(true);
    }

    public void addSinhVien(Student student) {
        sinhVienList.add(student);
        model.addRow(new Object[] {
            student.getId(),
            student.getName(),
            student.getSdt(),
            student.getLop(),
            student.getAddress(),
            student.getSoXe(),
            student.getGioiTinh()
        });
        // cập nhật số ghế ngồi nếu có.
    }

    public void updateSinhVien(int rowIndex, Student student) {
        sinhVienList.set(rowIndex, student);
        model.setValueAt(student.getId(), rowIndex, 0);
        model.setValueAt(student.getName(), rowIndex, 1);
        model.setValueAt(student.getSdt(), rowIndex, 2);
        model.setValueAt(student.getLop(), rowIndex, 3);
        model.setValueAt(student.getAddress(), rowIndex, 4);
        model.setValueAt(student.getSoXe(), rowIndex, 5);
        model.setValueAt(student.getGioiTinh(), rowIndex, 6);
    }

    private void showStudentDetail() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Student selectedStudent = sinhVienList.get(selectedRow);
            String detailMessage = String.format(
                "ID: %s\nName: %s\nSĐT: %s\nLớp: %s\nĐịa chỉ: %s\nSố xe: %s\nGiới tính: %s",
                selectedStudent.getId(),
                selectedStudent.getName(),
                selectedStudent.getSdt(),
                selectedStudent.getLop(),
                selectedStudent.getAddress(),
                selectedStudent.getSoXe(),
                selectedStudent.getGioiTinh()
            );
            JOptionPane.showMessageDialog(this, detailMessage, "Thông tin chi tiết sinh viên", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sinh viên để xem chi tiết", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVien().setVisible(true);
            }
        });
    }
}
