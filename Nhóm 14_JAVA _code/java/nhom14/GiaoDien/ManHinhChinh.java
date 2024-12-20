package GiaoDien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManHinhChinh extends JFrame {

    public ManHinhChinh(){
        // Cài đặt JFrame
        setTitle("Nhóm 14");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon originalIcon = new ImageIcon("java\\nhom14\\anh\\anh.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        
        JLabel backgroundLabel = new JLabel(resizedIcon);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLabel);
        
        
        ImageIcon haui = new ImageIcon("java\\nhom14\\anh\\hauiicon.png");
        Image hauiIcon = haui.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedHauiIcon = new ImageIcon(hauiIcon);
        JLabel backgroundLabel1 = new JLabel(resizedHauiIcon);
        backgroundLabel1.setBounds(500, 80, 50, 50);
        
        // Thêm JLabel vào JFrame
        getContentPane().add(backgroundLabel1);
        getContentPane().add(backgroundLabel);
        
        ((JPanel) getContentPane()).setComponentZOrder(backgroundLabel1, 0); 
        ((JPanel) getContentPane()).setComponentZOrder(backgroundLabel, 1); 
   
        JLabel title = new JLabel("Đại Học Công Nghiệp Hà Nội x FPT");
        title.setBounds(200, 70, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        getContentPane().add(title);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(280, 250, 100, 30);
        loginButton.setBackground(new Color(0, 0, 0, 0));
        loginButton.setOpaque(false); 
        loginButton.setForeground(Color.BLACK);  
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        loginButton.setFocusPainted(false);    
        loginButton.setPreferredSize(new Dimension(100, 30)); 
        getContentPane().add(loginButton);
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                loginButton.setOpaque(true);
                loginButton.setBackground(Color.WHITE);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                loginButton.setOpaque(false);
                loginButton.setBackground(new Color(0, 0, 0, 0));
            }
        });
    
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(280, 300, 100, 30);
        registerButton.setBackground(new Color(0, 0, 0, 0));  
        registerButton.setOpaque(false);
        registerButton.setForeground(Color.BLACK); 
        registerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        registerButton.setFocusPainted(false);
        registerButton.setPreferredSize(new Dimension(100, 30)); 
        getContentPane().add(registerButton);
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                registerButton.setOpaque(true);
                registerButton.setBackground(Color.WHITE);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                registerButton.setOpaque(false);
                registerButton.setBackground(new Color(0, 0, 0, 0));
            }
        });
        
        ((JPanel) getContentPane()).setComponentZOrder(backgroundLabel, getContentPane().getComponentCount() - 1);

        loginButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở cửa sổ Login
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
        
                // Ẩn hoặc đóng cửa sổ hiện tại nếu cần
                setVisible(false);
                dispose();
            }
        });
        registerButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở cửa sổ Login
                Register registerFrame = new Register();
                registerFrame.setVisible(true);
        
                // Ẩn hoặc đóng cửa sổ hiện tại nếu cần
                setVisible(false);
                dispose();
            }
        });
        
        setVisible(true);
    }
}
