package dao;

import connection.MyConnection;
import model.Employee;
import model.NhanVien;

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
            final String sql = "SELECT * FROM NhanVien";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                NhanVien e = new NhanVien();
                e.setMaNV(rs.getInt("MaNV"));
                e.setHoTen(rs.getString("HoTen"));
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
}
