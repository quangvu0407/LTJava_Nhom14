package GiaoDien;

import Lop.account;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {
    private ArrayList<account> listTK;

    public Register() {
        initComponents();
        setTitle("Nhóm 14");
        setLocationRelativeTo(null);
        setResizable(false);
        listTK = Lop.account.getTKNVList(); 
    }

    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jRadioButton1 = new javax.swing.JRadioButton();
        login = new javax.swing.JButton();
        account = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JPasswordField();  
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel(); 
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");
        account.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        confirmPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jRadioButton1.setText("jRadioButton1");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        login.setBackground(new java.awt.Color(255, 153, 153));
        login.setText("Login");
        login.setFocusPainted(false);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 204, 204));
        back.setText("Back");
        back.setFocusPainted(false);

        jLabel1.setText("Nhập tài khoản: ");
        jLabel2.setText("Mật Khẩu: ");
        jLabel4.setText("Nhập lại mật khẩu: ");  

        jCheckBox1.setText("Show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); 
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Đăng Kí");

        back.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ManHinhChinh manHinhChinh = new ManHinhChinh();
                manHinhChinh.setVisible(true);
                setVisible(false);
                dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox1)
                            .addComponent(account, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(password)
                            .addComponent(confirmPassword))) 
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(login)
                            .addGap(27, 27, 27)
                            .addComponent(back))))
                            .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(account))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(back))
                .addGap(22, 22, 22))
        );

        password.getAccessibleContext().setAccessibleName("");
        password.getAccessibleContext().setAccessibleDescription("");

        pack();
    }

    private void accountActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {
        String enteredUsername = account.getText().trim();
        String enteredPassword = new String(password.getPassword()).trim();
        String enteredConfirmPassword = new String(confirmPassword.getPassword()).trim();
    
        if (enteredUsername.isEmpty() || enteredPassword.isEmpty() || enteredConfirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!enteredUsername.isEmpty()){
            for(account acc: listTK){
                if(acc.getAccounts().equals(enteredUsername)){
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    
        if (enteredUsername.length() < 5) {
            JOptionPane.showMessageDialog(this, "Tài khoản phải có ít nhất 5 ký tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        if (enteredPassword.length() < 5) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 5 ký tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        if (!enteredPassword.equals(enteredConfirmPassword)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu và mật khẩu nhập lại không khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        if (!enteredPassword.matches(".*[A-Z].*") || !enteredPassword.matches(".*[a-z].*") ||
            !enteredPassword.matches(".*[0-9].*") || !enteredPassword.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải chứa ít nhất một chữ hoa, chữ thường, một số và một ký tự đặc biệt!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        for (account acc : listTK) {
            if (acc.getAccounts().equals(enteredUsername) && acc.getPassword().equals(enteredPassword)) {
                break;
            }
        }
    
        for (account acc : listTK) {
            if (acc.getAccounts().equals(enteredUsername)) {
                JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    
        account newAccount = new account(enteredUsername, enteredPassword);
        listTK.add(newAccount);
    
        JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
    
        Login loginScreen = new Login();
        loginScreen.setAccountsList(listTK);
        loginScreen.setVisible(true);
        this.setVisible(false);
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBox1.isSelected()) {
            password.setEchoChar((char) 0); 
            confirmPassword.setEchoChar((char) 0); 
        } else {
            password.setEchoChar('*'); 
            confirmPassword.setEchoChar('*'); 
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

                        
    private javax.swing.JTextField account;
    private javax.swing.JButton back;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;  
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField confirmPassword; 
                       
}
