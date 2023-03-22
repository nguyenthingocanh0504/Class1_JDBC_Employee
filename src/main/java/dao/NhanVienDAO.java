package dao;

import connection.MyConnection;
import model.Employee;
import model.NhanVien;
import model.PhongBan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    public List<NhanVien> getAll() {
        List<NhanVien> nhanVienList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM NhanVien WHERE `TrangThai`=1";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                NhanVien e = new NhanVien();
                e.setMaNV(rs.getString("MaNV"));
                e.setHoTen(rs.getString("HoTen"));
                e.setSdt(rs.getString("SoDienThoai"));
                e.setGioiTinh(rs.getString("GioiTinh"));
                e.setNgaySinh(rs.getString("NgaySinh"));
                e.setDanToc(rs.getString("DanToc"));
                e.setQueQuan(rs.getString("QueQuan"));
                e.setMaPB(rs.getInt("MaPB"));
                e.setMaTDHV(rs.getInt("MaTrinhDoHocVan"));
                e.setBacLuong(rs.getInt("BacLuong"));
                e.setMaCV(rs.getInt("MaCV"));
                e.setTrangThaiNV(rs.getInt("TrangThai"));

                nhanVienList.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVienList;
    }
    public void insert(NhanVien e) {
        final String sql = String.format("INSERT INTO NhanVien (`MaNV`,`HoTen`,`SoDienThoai`,`GioiTinh`,`NgaySinh`,`DanToc`,`QueQuan`,`MaPB`,`MaTrinhDoHocVan`,`BacLuong`,`MaCV`,`TrangThai`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%d','%d','%d','%d','%d')",
                e.getMaNV(), e.getHoTen(), e.getSdt(), e.getGioiTinh(), e.getNgaySinh(), e.getDanToc(),e.getQueQuan(),
                e.getMaPB(),e.getMaTDHV(),e.getBacLuong(),e.getMaCV(),e.getTrangThaiNV()
        );

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            int rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Thêm thất bại!");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public NhanVien getById(String id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM NhanVien WHERE MaNV = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            NhanVien e = null;
            if (rs.next()) {
                e = new NhanVien();
                e.setMaNV(rs.getString("MaNV"));
                e.setHoTen(rs.getString("HoTen"));
                e.setSdt(rs.getString("SoDienThoai"));
                e.setGioiTinh(rs.getString("GioiTinh"));
                e.setNgaySinh(rs.getString("NgaySinh"));
                e.setDanToc(rs.getString("DanToc"));
                e.setQueQuan(rs.getString("QueQuan"));
                e.setMaPB(rs.getInt("MaPB"));
                e.setMaTDHV(rs.getInt("MaTrinhDoHocVan"));
                e.setBacLuong(rs.getInt("BacLuong"));
                e.setMaCV(rs.getInt("MaCV"));
                e.setTrangThaiNV(rs.getInt("TrangThai"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }public void update(NhanVien e, String id) {
        NhanVien tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE NhanVien SET `HoTen`='%s',`SoDienThoai`='%s',`GioiTinh`='%s',`NgaySinh`='%s',`DanToc`='%s',`QueQuan`='%s' WHERE `MaNV`='%s' " ,
                e.getHoTen(), e.getSdt(), e.getGioiTinh(), e.getNgaySinh(), e.getDanToc(), e.getQueQuan(), id
        );

        System.out.println(sql);
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void delete(NhanVien e, String id) {
        NhanVien tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE NhanVien SET `TrangThai`='0' WHERE `MaNV`='%s' " , id);

//        System.out.println(sql);
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xóa thất bại");
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
