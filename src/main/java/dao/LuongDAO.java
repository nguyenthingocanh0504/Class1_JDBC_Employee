package dao;

import connection.MyConnection;
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
    public Luong getById(long id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM Luong WHERE BacLuong = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Luong e = null;
            if (rs.next()) {
                e = new Luong();
                e.setBacLuong(rs.getInt("BacLuong"));
                e.setLuongCB(rs.getInt("LuongCB"));
                e.setHsLuong(rs.getInt("HSLuong"));
                e.setHsPhuCap(rs.getInt("HSPhuCap"));
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
