package dao;

import connection.MyConnection;
import model.ChucVu;
import model.Luong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LuongDAO {
    public List<Luong> getAll() {
        List<Luong> luongList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM Luong";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Luong e = new Luong();
                e.setBacLuong(rs.getInt("BacLuong"));
                e.setLuongCB(rs.getInt("LuongCB"));
                e.setHsLuong(rs.getInt("HSLuong"));
                e.setHsPhuCap(rs.getInt("HSPhuCap"));
                luongList.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return luongList;
    }
}
