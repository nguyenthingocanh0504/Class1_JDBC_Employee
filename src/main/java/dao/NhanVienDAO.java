package dao;

import DTO.LuongNhanVienDTO;
import connection.MyConnection;
import model.Luong;
import model.NhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO implements GenerateClass{
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
    public static List<LuongNhanVienDTO> getSalaryEmployee() {
        List<LuongNhanVienDTO> luongNhanVienDTOS = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "select MaNV, HoTen, LuongCB*HSLuong+LuongCB*HSPhuCap as LuongThucLinh from Luong l inner join nhanvien n on n.BacLuong=l.BacLuong order by luongThucLinh";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                LuongNhanVienDTO e = new LuongNhanVienDTO();
                e.setMaNV(rs.getString("MaNV"));
                e.setTenNV(rs.getString("HoTen"));
                e.setLuongThucLinh(rs.getDouble("LuongThucLinh"));
                luongNhanVienDTOS.add(e);

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return luongNhanVienDTOS;
    }
    public LuongNhanVienDTO getSalaryEmployeeByID(String id) {
        LuongNhanVienDTO luongNhanVienDTO = new LuongNhanVienDTO();
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "select MaNV, HoTen, LuongCB*HSLuong+LuongCB*HSPhuCap as LuongThucLinh from Luong l inner join nhanvien n on n.BacLuong=l.BacLuong where `MaNV` LIKE '%" + id + "%'";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                luongNhanVienDTO.setMaNV(rs.getString("MaNV"));
                luongNhanVienDTO.setTenNV(rs.getString("HoTen"));
                luongNhanVienDTO.setLuongThucLinh(rs.getDouble("LuongThucLinh"));

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return luongNhanVienDTO;
    }
    public NhanVien getById(String id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM NhanVien WHERE MaNV LIKE '%" + id + "%'";

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
    }
    public void update(NhanVien e, String id) {
        NhanVien tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE NhanVien SET `HoTen`='%s',`SoDienThoai`='%s',`GioiTinh`='%s',`NgaySinh`='%s',`DanToc`='%s',`QueQuan`='%s' WHERE `MaNV` LIKE '%s' " ,
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
    public void update_employee_department(NhanVien e, String id) {
        NhanVien tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE NhanVien SET `MaPB`='%s' WHERE `MaNV` LIKE ='%s' " ,
                e.getMaPB(), id
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
        final String sql = String.format("UPDATE NhanVien SET `TrangThai`='0' WHERE `MaNV` LIKE '%s' " , id);

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

    public void delete_employee_from_department(NhanVien e, String id) {
        NhanVien tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE NhanVien SET `MaPB`='0' WHERE `MaNV` LIKE '%s' " , id);

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
        CommonSql.common_insert(o, CommonSql.INSERT_NHANVIEN);
    }


}
