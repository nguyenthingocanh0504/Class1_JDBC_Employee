package dao;

import connection.MyConnection;
import model.ChucVu;
import model.Employee;
import model.NhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChucVuDAO {
    public List<ChucVu> getAll() {
        List<ChucVu> chucVuList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM ChucVu";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ChucVu e = new ChucVu();
                e.setMaCV(rs.getInt("MaCV"));
                e.setTenCV(rs.getString("TenCV"));

                chucVuList.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVuList;
    }
    public ChucVu getById(long id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM ChucVu WHERE MaCV = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            ChucVu e = null;
            if (rs.next()) {
                e = new ChucVu();
                e.setMaCV(rs.getInt("MaCV"));
                e.setTenCV(rs.getString("TenCV"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
