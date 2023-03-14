package dao;

import connection.MyConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    /**
     * Lấy ra toàn bộ nhân viên
     *
     * @return
     */
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM employees";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setCity(rs.getString("city"));
                e.setEmail(rs.getString("email"));
                e.setGender(rs.getInt("gender"));
                e.setSalary(rs.getInt("salary"));
                e.setFullName(rs.getString("full_name"));
                e.setPhone(rs.getString("phone"));

                employeeList.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    /**
     * Thêm 1 nhân viên vào database
     *
     * @param e
     */
    public void insert(Employee e) {
        final String sql = String.format("INSERT INTO employees VALUES (NULL,'%s','%s','%s','%s','%d','%d')",
                e.getFullName(), e.getCity(), e.getEmail(), e.getPhone(), e.getGender(), e.getSalary()
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

    /**
     * Lấy nhân viên theo ID
     *
     * @param id
     * @return nếu không tìm thấy trả về null
     */
    public Employee getById(long id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM employees WHERE id = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Employee e = null;
            if (rs.next()) {
                e = new Employee();
                e.setId(rs.getLong("id"));
                e.setCity(rs.getString("city"));
                e.setEmail(rs.getString("email"));
                e.setGender(rs.getInt("gender"));
                e.setSalary(rs.getInt("salary"));
                e.setFullName(rs.getString("full_name"));
                e.setPhone(rs.getString("phone"));
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

    public void update(Employee e, long id) {
        Employee tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE employees SET `full_name`='%s',`city`='%s',`email`='%s',`phone`='%s',`gender`='%d',`salary`='%d' WHERE `id`='%d' " ,
                e.getFullName(), e.getCity(), e.getEmail(), e.getPhone(), e.getGender(), e.getSalary(), id
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

    public void delete(long id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "DELETE FROM employees WHERE id = " + id;

            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
