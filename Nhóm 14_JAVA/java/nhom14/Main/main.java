package Main;

import GiaoDien.ManHinhChinh;

public class main {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhChinh().setVisible(true);
            }
        });
    }
}
