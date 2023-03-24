package dao;

import connection.MyConnection;
import model.PhongBan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhongBanDAO implements GenerateClass {
    public List<PhongBan> getAll() {
        List<PhongBan> phongBanList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM PhongBan WHERE `TrangThai`=1";

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
    public PhongBan getById(int id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM PhongBan WHERE MaPB = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            PhongBan e = null;
            if (rs.next()) {
                e = new PhongBan();
                e.setMaPB(rs.getInt("MaPB"));
                e.setTenPB(rs.getString("TenPB"));
                e.setSdtPB(rs.getString("SDTPB"));
                e.setDiaChi(rs.getString("DiaChi"));
                e.setTrangThai(rs.getInt("TrangThai"));
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

    public void update(PhongBan e, int id) {
        PhongBan tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại phòng ban có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE PhongBan SET `TenPB`='%s',`SDTPB`='%s',`DiaChi`='%s',`TrangThai`='%d' WHERE `MaPB`='%d' " ,
                e.getTenPB(), e.getSdtPB(), e.getDiaChi(), e.getTrangThai(), id
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
    public void delete(PhongBan e, int id) {
        PhongBan tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại phòng ban có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE PhongBan SET `TrangThai`='0' WHERE `MaPB`='%d' " , id);

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

    @Override
    public void insert(Object o) {
        CommonSql.common_insert(o, CommonSql.INSERT_PB);
    }
}
