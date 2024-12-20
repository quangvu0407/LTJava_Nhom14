package GiaoDien;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

import Lop.Xe; 

import java.util.ArrayList;

public class QuanLyXeC extends JFrame {
    JTable table;
    private DefaultTableModel model;
    private ArrayList<Xe> xeList;

    public QuanLyXeC() {
        xeList = Xe.loadDataFromFile(); 
        setTitle("Quản lý Xe");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(new Color(224, 238, 238));

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Quản lý Xe", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // back button
        JButton back = new JButton("Quay lại");
        back.setBounds(10, 10, 80, 20);
        back.setBackground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(39, 231, 186), 1));
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
        model.setColumnIdentifiers(new String[] { "Mã Số Xe", "Số Ghế", "Tên Tài Xế", "SĐT", "Biển Số Xe" });
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
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
                    Xe selectedXe = xeList.get(selectedRow); 
                    openAddOrEditDialog(selectedXe);
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn xe để sửa");
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
                deleteXe(); 
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
                showXeDetail();
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

        for (Xe xe : xeList) { 
            model.addRow(new Object[] {
                xe.getMaSoXe(),
                xe.getSoGhe(),  
                xe.getTenTaiXe(), 
                xe.getSdt(),
                xe.getBienSo()  
            });
        }
    }

    private void deleteXe() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            xeList.remove(selectedRow);
            model.removeRow(selectedRow);
        }
    }

    private void openAddOrEditDialog(Xe xe) {
        QuanLyXe dialog = new QuanLyXe(this, xe);
        dialog.setVisible(true);
    }

    public void addXe(Xe xe) {
        xeList.add(xe);
        model.addRow(new Object[] {
            xe.getMaSoXe(),
            xe.getSoGhe(),
            xe.getTenTaiXe(),
            xe.getSdt(),
            xe.getBienSo()
        });
    }

    public void updateXe(int rowIndex, Xe xe) {
        xeList.set(rowIndex, xe);
        model.setValueAt(xe.getMaSoXe(), rowIndex, 0);
        model.setValueAt(xe.getSoGhe(), rowIndex, 1);
        model.setValueAt(xe.getTenTaiXe(), rowIndex, 2);
        model.setValueAt(xe.getSdt(), rowIndex, 3);
        model.setValueAt(xe.getBienSo(), rowIndex, 4);
    }

    private void showXeDetail() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Xe selectedXe = xeList.get(selectedRow); // Chọn xe thay vì giảng viên
            String detailMessage = String.format(
                "Mã Xe: %s\nSố Ghế: %s\nTên Tài Xế: %s\nSĐT: %s\nBiển Số Xe: %s",
                selectedXe.getMaSoXe(),
                selectedXe.getSoGhe(),
                selectedXe.getTenTaiXe(),
                selectedXe.getSdt(),
                selectedXe.getBienSo()
            );
            JOptionPane.showMessageDialog(this, detailMessage, "Thông tin chi tiết xe", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một Xe để xem chi tiết", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuanLyXeC().setVisible(true);
            }
        });
    }
}
