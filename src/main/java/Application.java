import dao.EmployeeDAO;
import dao.NhanVienDAO;
import dao.PhongBanDAO;
import model.Employee;
import model.NhanVien;
import model.PhongBan;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import service.AuthenService;
public class Application {
    private static boolean isLoginSuccess = false;
    private static AuthenService authenService = new AuthenService();
    private static void showMenu(){
        System.out.println("---QUAN LY NHAN SU---");
    }

    private static PhongBanDAO phongBanDAO = new PhongBanDAO();
    private static NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ NHÂN SỰ ---");
        System.out.println("1. Hiển thị danh sách các phòng ban");
        System.out.println("2. Hiển thị danh sách toàn bộ nhân viên");
        System.out.println("3. Thêm mới thông tin 1 phòng ban");
        System.out.println("4. Cập nhật thông tin phòng ban (theo mã phòng ban)");
        System.out.println("5. Thêm mới thông tin 1 chức vụ");
        System.out.println("6. Cập nhật thông tin chức vụ");
        System.out.println("7. Xóa thông tin phòng ban (theo mã PB)");
        System.out.println("8. Thêm mới thông tin 1 Nhân Viên");
        System.out.println("9. Cập nhật thông tin 1 nhân viên (theo mã NV)");
        System.out.println("10. Xóa thông tin 1 nhân viên (theo mã NV)");
        System.out.println("11. Tìm kiếm thông tin 1 nhân viên ( theo mã, theo tên,...)");
        System.out.println("12. Thêm thông tin nhân viên vào 1 phòng ban");
        System.out.println("13. Xóa thông tin nhân viên ra khỏi phòng ban");
        System.out.println("14. Chuyển vị trí phòng ban cho 1 nhân viên");
        System.out.println("15. Tính thuế thu nhập cá nhân cho 1 nhân viên (theo mã NV)");
        System.out.println("16. Sắp xếp danh sách nhân viên theo mức lương thực lĩnh");
        System.out.println("17. Lấy ra những nhân viên có quê quán ở Hà Nội");
        System.out.println("18. Lấy ra 5 nhân viên có bậc lương cao nhất.");
        System.out.println("19. Thoát");
    }
    private static void option1() {
        List<PhongBan> phongBanList = phongBanDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã phòng ban", "Tên sản phẩm", "Số điện thoại", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < phongBanList.size(); i++) {
            PhongBan p = phongBanList.get(i);
            System.out.printf("%-20d %-20s %-20s %-20s\n", p.getMaPB(), p.getTenPB(), p.getSdtPB(), p.getDiaChi());
        };
    }
    private static void option2() {
        List<NhanVien> nhanVienList = nhanVienDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Họ tên", "Số điện thoại", "Giới tính", "Ngày sinh", "Dân tộc", "Quê quán");
        System.out.println();
        for (int i = 0; i < nhanVienList.size(); i++) {
            NhanVien n = nhanVienList.get(i);
            System.out.printf("%-20d %-20s %-20s %-20s %-20s %-20s %-20s\n", n.getMaNV(), n.getHoTen(), n.getSdt(), n.getGioiTinh(),n.getNgaySinh(),n.getDanToc(),n.getQueQuan());
        };
    }
    private static void option3(Scanner in){
        PhongBan p = new PhongBan();
        System.out.print("\tNhập tên phòng ban: ");
        p.setTenPB(in.nextLine());
        System.out.print("\tNhập số điện thoại: ");
        p.setSdtPB(in.nextLine());
        System.out.print("\tNhập địa chỉ: ");
        p.setDiaChi(in.nextLine());
        p.setTrangThai(1);

        phongBanDAO.insert(p);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(isLoginSuccess== false){
            // Dang nhap truoc
            System.out.print("Nhap username: ");
            String username = in.nextLine();
            System.out.print("Nhap password: ");
            String password = in.nextLine();

            // Kiem tra xem dang nhap dc ko?
            AuthenService authenService = new AuthenService();
            isLoginSuccess = authenService.login(username, password);
        }

        if(isLoginSuccess == false){
            System.out.println("Dang nhap that bai");
            System.exit(0);
        }

        // Dang nhap thanh cong
        showMenu();

        in.close();
        int option = -1;

        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());
            // Làm thêm phàn try-catch khi người dùng nhập lỗi
            if (option < 1 || option > 19) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3(in);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:
                    break;
            }

        }
        while (option != 0);
        in.close();
    }
}
