package dao;

import connection.MyConnection;
import model.Employee;
import model.Luong;
import model.TrinhDoHocVan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrinhDoHocVanDAO {
    public List<TrinhDoHocVan> getAll() {
        List<TrinhDoHocVan> TDHV = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM TrinhDoHocVan";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                TrinhDoHocVan e = new TrinhDoHocVan();
                e.setMaTDHV(rs.getLong("MaTrinhDoHocVan"));
                e.setTTDHV(rs.getString("TTDHV"));
                e.setChuyenNganh(rs.getString("ChuyenNganh"));
                TDHV.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TDHV;
    }
    public TrinhDoHocVan getById(long id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM TrinhDoHocVan WHERE MaTrinhDoHocVan = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            TrinhDoHocVan e = null;
            if (rs.next()) {
                e = new TrinhDoHocVan();
                e.setMaTDHV(rs.getLong("MaTrinhDoHocVan"));
                e.setTTDHV(rs.getString("TTDHV"));
                e.setChuyenNganh(rs.getString("ChuyenNganh"));
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
