package dao;

import connection.MyConnection;
import model.NhanVien;
import model.PhongBan;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommonSql {
    public static final String INSERT_NHANVIEN = "INSERT INTO NhanVien (`MaNV`,`HoTen`,`SoDienThoai`,`GioiTinh`,`NgaySinh`,`DanToc`,`QueQuan`,`MaPB`,`MaTrinhDoHocVan`,`BacLuong`,`MaCV`,`TrangThai`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%d','%d','%d','%d','%d')";
    public static final String INSERT_PB = "INSERT INTO PhongBan VALUES (NULL,'%s','%s','%s','%d')";

    public static void common_insert(Object o, String sql){
        String excute_sql = null;
        if(o instanceof NhanVien){
            NhanVien nhanVien = new NhanVien();
            nhanVien = (NhanVien) o;
            excute_sql = String.format(sql,nhanVien.getMaNV(), nhanVien.getHoTen(), nhanVien.getSdt(), nhanVien.getGioiTinh(), nhanVien.getNgaySinh(), nhanVien.getDanToc(),nhanVien.getQueQuan(),
                    nhanVien.getMaPB(),nhanVien.getMaTDHV(),nhanVien.getBacLuong(),nhanVien.getMaCV(),nhanVien.getTrangThaiNV());
        }else if(o instanceof PhongBan) {
            PhongBan phongBan = new PhongBan();
            phongBan = (PhongBan) o ;
            excute_sql =  String.format(sql, phongBan.getTenPB(), phongBan.getSdtPB(), phongBan.getDiaChi(), 1);
        }
        Connection connection = null;
        try {
            connection = MyConnection.getConnection();
            Statement stmt = connection.createStatement();
            System.out.println("Chua dong connection");
            int rs = stmt.executeUpdate(excute_sql);
            if (rs == 0) {
                System.out.println("Thêm thất bại!");
            }
            stmt.close();
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.getMessage();
            }
        }
    }
}
