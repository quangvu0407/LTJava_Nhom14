package GiaoDien;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URI;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TrangChu extends javax.swing.JFrame {
    private JLabel backgroundLabel;

    public TrangChu() {
        initComponents();
        setBackgroundImage();
        setSize(700, 500); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void setBackgroundImage() {
        
        backgroundLabel = new JLabel();
        backgroundLabel.setLayout(null);
        getContentPane().add(backgroundLabel, javax.swing.JLayeredPane.DEFAULT_LAYER); 

        
        updateBackgroundImage();

        
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                updateBackgroundImage();
            }
        });
    }

    private void updateBackgroundImage() {
        
        ImageIcon originalIcon = new ImageIcon("F:\\Downloads\\hauiicon1.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        
        backgroundLabel.setIcon(resizedIcon);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight()); // Đặt hình nền phủ đầy cửa sổ
    }

    @SuppressWarnings("")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextPane1.setBackground(new java.awt.Color(255, 153, 153));
        jTextPane1.setText("Nhóm 14");
        jTextPane1.setForeground(Color.black);
        jScrollPane1.setViewportView(jTextPane1);
        jTextPane1.setEditable(false);
        jTextPane1.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(51, 255, 255));
        jButton1.setText("Log Out");
        jButton1.setSize(700, 500);
        jButton1.setBackground(new Color(0, 0, 0, 0));  
        jButton1.setForeground(Color.BLACK);   
        jButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton1.setFocusPainted(false);   
        jButton1.setOpaque(false);   
        jButton1.setPreferredSize(new Dimension(100, 30));  
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent ent){
                jButton1.setOpaque(true); 
                jButton1.setBackground(Color.WHITE);
            }
            public void mouseExited(java.awt.event.MouseEvent ent){
                jButton1.setOpaque(false);  
                jButton1.setBackground(new Color(0, 0,0, 0));
            }
        });

        jButton2.setText("Quản Lý Sinh Viên");
        jButton2.setBackground(new Color(0, 0, 0, 0));  
        jButton2.setForeground(Color.RED);   
        jButton2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton2.setFocusPainted(false);   
        jButton2.setPreferredSize(new Dimension(100, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2.setOpaque(true);
                jButton2.setBackground(Color.LIGHT_GRAY); 
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2.setOpaque(false);  
                jButton2.setBackground(new Color(0, 0, 0, 0)); 
            }
        });

        jButton3.setText("Quản Lý Xe");
        jButton3.setBackground(new Color(0, 0, 0, 0));  
        jButton3.setForeground(Color.BLACK);   
        jButton3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton3.setFocusPainted(false);   
        jButton3.setPreferredSize(new Dimension(100, 30));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3.setOpaque(true);
                jButton3.setBackground(Color.LIGHT_GRAY); 
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3.setOpaque(false);  
                jButton3.setBackground(new Color(0, 0,0 ,0 )); 
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Giảng Viên");
        jButton4.setForeground(Color.WHITE);
        jButton4.setBackground(new Color(0, 0, 0, 0));  
        jButton4.setForeground(Color.BLACK);   
        jButton4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton4.setFocusPainted(false);   
        jButton4.setPreferredSize(new Dimension(100, 30));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4.setOpaque(true);
                jButton4.setBackground(Color.LIGHT_GRAY); 
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4.setOpaque(false);  
                jButton4.setBackground(Color.WHITE); 
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        
        jButton5.setText("Liên Hệ");
        jButton5.setBackground(new Color(0, 0, 0, 0));  
        jButton5.setForeground(Color.BLACK);   
        jButton5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton5.setFocusPainted(false);     
        jButton5.setPreferredSize(new Dimension(100, 30));  
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent ent){
                jButton5.setOpaque(true); 
                jButton5.setBackground(Color.WHITE);
            }
            public void mouseExited(java.awt.event.MouseEvent ent){
                jButton5.setOpaque(false);  
                jButton5.setBackground(new Color(0, 0,0, 0));
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE,150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE,150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE,150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE,150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 106, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt){
        QuanLySinhVien qlsv = new QuanLySinhVien();
        qlsv.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt){
        QuanLyGiangVien qlgv = new QuanLyGiangVien();
        qlgv.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt){
        QuanLyXeC qlxe = new QuanLyXeC();
        qlxe.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
        Login loginScreen = new Login();
        loginScreen.setVisible(true);
        this.setVisible(false);
        this.dispose(); 
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            URI uri = new URI("https://www.haui.edu.vn/vn");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5; 
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration
}
