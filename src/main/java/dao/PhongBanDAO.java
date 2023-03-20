package dao;

import connection.MyConnection;
import model.Employee;
import model.PhongBan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhongBanDAO {
    public List<PhongBan> getAll() {
        List<PhongBan> phongBanList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM PhongBan";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                PhongBan e = new PhongBan();
                e.setMaPB(rs.getInt("MaPB"));
                e.setTenPB(rs.getString("TenPB"));
                e.setSdtPB(rs.getString("SDTPB"));
                e.setDiaChi(rs.getString("DiaChi"));
                e.setTrangThai(rs.getInt("TrangThai"));

                phongBanList.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return phongBanList;
    }
    public void insert(PhongBan e) {
        final String sql = String.format("INSERT INTO PhongBan VALUES (NULL,'%s','%s','%s','%d')",
                 e.getTenPB(), e.getSdtPB(), e.getDiaChi(), e.getTrangThai()
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
}
