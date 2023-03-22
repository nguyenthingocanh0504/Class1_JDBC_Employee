package dao;

import connection.MyConnection;
import model.ChucVu;
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
}
