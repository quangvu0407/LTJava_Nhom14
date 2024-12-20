package Lop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class account {
        private static FileReader FileReaccounteReader;
        private static Reader fileReader;
        private String accounts;
        private String password;
    
        public account(String accounts, String password){
            this.accounts = accounts;
            this.password = password;
        }
        public account(){
    
        }
        public String getAccounts() {
            return accounts;
        }
        public void setAccounts(String accounts) {
            this.accounts = accounts;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
            @Override
        public String toString() {
            return this.accounts + "," + this.password;
        }
    
        public static ArrayList<account> getTKNVList() {
            ArrayList<account> listTK = new ArrayList<>();
            String fileName = "java\\nhom14\\csdl\\account.txt";
            String line;
        
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] fields = line.split(",");
                    String tenTK = fields[0];
                    String matKhau = fields[1];
                    account tk = new account(tenTK, matKhau);
                    listTK.add(tk);
                }
            } catch (IOException e) {
                System.out.println("Error reading file " + fileName);
            }
            return listTK;
        }
}
