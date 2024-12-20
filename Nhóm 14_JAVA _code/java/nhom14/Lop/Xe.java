package Lop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Xe {
    private String MaSoXe;
    private String SoGhe;
    private String TenTaiXe;
    private String BienSo;
    private String sdt;
    
    // Constructor và các phương thức getter/setter giữ nguyên

    public Xe(String MaSoXe, String SoGhe, String TenTaiXe, String sdt, String BienSo) {
        this.MaSoXe = MaSoXe;
        this.SoGhe = SoGhe;
        this.TenTaiXe = TenTaiXe;
        this.BienSo = BienSo;
        this.sdt = sdt;
    }

    public Xe(Xe xe) {
        this(xe.MaSoXe, xe.SoGhe, xe.TenTaiXe, xe.sdt, xe.BienSo);
    }

    public String getMaSoXe() {
        return MaSoXe;
    }

    public void setMaSoXe(String maSoXe) {
        MaSoXe = maSoXe;
    }

    public String getSoGhe() {
        return SoGhe;
    }

    public void setSoGhe(String soGhe) {
        SoGhe = soGhe;
    }

    public String getTenTaiXe() {
        return TenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        TenTaiXe = tenTaiXe;
    }

    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String bienSo) {
        BienSo = bienSo;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return this.MaSoXe + "," + this.SoGhe +"," + this.TenTaiXe + "," + this.BienSo + "," + this.sdt;
    }
    // Sửa đổi phương thức static để đọc dữ liệu từ file với đường dẫn cố định
    public static ArrayList<Xe> loadDataFromFile() {
        String filePath = "java\\nhom14\\csdl\\danhsachxe.txt";
        ArrayList<Xe> DSXe = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String maSoXe = data[0];
                    String soGhe = data[1];
                    String tenTaiXe = data[2];
                    String sdt = data[3];
                    String bienSoXe = data[4];
                    Xe xe = new Xe(maSoXe, soGhe, tenTaiXe, sdt, bienSoXe);
                    DSXe.add(xe);
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }
        return DSXe;
    }
    
    public static void main(String[] args) {
        for(Xe xe: Xe.loadDataFromFile()){
            System.out.println(xe);
        }
    }
}