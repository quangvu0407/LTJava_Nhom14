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
 * @author trant
 */
public class Student{
    private String id;
    private String name;
    private String sdt;
    private String lop;
    private String address;
    private String SoXe;
    private String GioiTinh;
    public Student(String id, String name, String sdt, String lop, String address, String SoXe, String GioiTinh){
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.lop = lop;
        this.address = address;
        this.SoXe = SoXe;
        this.GioiTinh = GioiTinh;
    }
    public Student(){
        
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getLop() {
        return lop;
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSoXe() {
        return SoXe;
    }
    public void setSoXe(String soXe) {
        SoXe = soXe;
    }
    public String getGioiTinh() {
        return GioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }
    @Override
    public String toString() {
        return this.id + "," + this.name + "," + this.sdt + "," + this.lop + "," + this.address + "," + this.SoXe + "," +this.GioiTinh;
    }
    public static ArrayList<Student> getDStudents() {
        ArrayList<Student> listTK = new ArrayList<>();
           String fileName = "java\\nhom14\\csdl\\SinhVien.txt";
        String line;
    
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String id = fields[0];
                String name = fields[1];
                String Sdt = fields[2];
                String Lop = fields[3];
                String address = fields[4];
                String soxe = fields[5];
                String gioiTinh = fields[6];
                Student tk = new Student(id, name, Sdt, Lop, address, soxe, gioiTinh);
                listTK.add(tk);
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listTK;
    }
    public static void main(String[] args) {
        for(Student student: Student.getDStudents()){
            System.out.println(student);
        }
    }
}
