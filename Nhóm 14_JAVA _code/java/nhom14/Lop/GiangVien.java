package Lop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ha Vu
 */
public class GiangVien {
    private String maGiangVien;
    private String ten;
    private String sdt;
    private String diaChi;
    private String soxe;    
    private String gioitinh;

    public GiangVien() {
        
    }

    public GiangVien(String maGiangVien, String ten, String sdt, String diaChi, String soxe, String gioitinh) {
        this.maGiangVien = maGiangVien;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.gioitinh = gioitinh;
        this.soxe = soxe;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSoxe() {
        return soxe;
    }

    public void setSoxe(String soxe) {
        this.soxe = soxe;
    }

    @Override
    public String toString() {
        return maGiangVien + "," + ten + "," + sdt + "," + diaChi + "," + soxe + "," + gioitinh;
    }

    public static ArrayList<GiangVien> getDSGiangVien() {
        ArrayList<GiangVien> listTK = new ArrayList<>();
           String fileName = "java\\nhom14\\csdl\\giangvien.txt";
        String line;
    
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String maGiangVien = fields[0];
                String ten = fields[1];
                String sdt = fields[2];
                String diaChi = fields[3];
                String soxe = fields[4];
                String gioitinh = fields[5];
                GiangVien tk = new GiangVien(maGiangVien, ten, sdt, diaChi, soxe, gioitinh);
                listTK.add(tk);
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listTK;
    }
    
}
