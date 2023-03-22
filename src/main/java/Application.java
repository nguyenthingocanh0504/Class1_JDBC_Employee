import Function.IsSoDienThoai;
import dao.*;
import model.*;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import service.AuthenService;
public class Application {
    private static boolean isLoginSuccess = false;
    private static AuthenService authenService = new AuthenService();
    private static LuongDAO luongDAO = new LuongDAO();
    private static TrinhDoHocVanDAO trinhDoHocVanDAO = new TrinhDoHocVanDAO();
    private static ChucVuDAO chucVuDAO = new ChucVuDAO();
    private static PhongBanDAO phongBanDAO = new PhongBanDAO();
    private static NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ NHÂN SỰ ---");
        System.out.println("1. Hiển thị danh sách các phòng ban");
        System.out.println("2. Hiển thị danh sách toàn bộ nhân viên");
        System.out.println("3. Thêm mới thông tin 1 phòng ban");
        System.out.println("4. Cập nhật thông tin phòng ban (theo mã phòng ban)");
        System.out.println("5. Xóa thông tin phòng ban (theo mã PB)");
        System.out.println("6. Thêm mới thông tin 1 Nhân Viên");
        System.out.println("7. Cập nhật thông tin 1 nhân viên (theo mã NV)");
        System.out.println("8. Xóa thông tin 1 nhân viên (theo mã NV)");
        System.out.println("9. Tìm kiếm thông tin 1 nhân viên ( theo mã, theo tên,...)");
        System.out.println("10. Thêm thông tin nhân viên vào 1 phòng ban");
        System.out.println("11. Xóa thông tin nhân viên ra khỏi phòng ban");
        System.out.println("12. Chuyển vị trí phòng ban cho 1 nhân viên");
        System.out.println("13. Tính thuế thu nhập cá nhân cho 1 nhân viên (theo mã NV)");
        System.out.println("14. Sắp xếp danh sách nhân viên theo mức lương thực lĩnh");
        System.out.println("15. Lấy ra những nhân viên có quê quán ở Hà Nội");
        System.out.println("16. Lấy ra 5 nhân viên có bậc lương cao nhất.");
        System.out.println("17. Thoát");
    }
    private static void option1() {
        List<PhongBan> phongBanList = phongBanDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã phòng ban", "Tên phòng ban", "Số điện thoại", "Địa chỉ");
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
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", n.getMaNV(), n.getHoTen(), n.getSdt(), n.getGioiTinh(),n.getNgaySinh(),n.getDanToc(),n.getQueQuan());
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

    private static void option4(Scanner in){
        PhongBan p=new PhongBan();
        System.out.print("\tNhập mã phòng ban: ");
        int MaPB = Integer.parseInt(in.nextLine());
        p.setMaPB(MaPB);
        System.out.print("\tNhập tên phòng ban: ");
        String TenPB = in.nextLine();
        p.setTenPB(TenPB);
        System.out.print("\tNhập số điện thoại: ");
        String sdt=in.nextLine();
        p.setSdtPB(sdt);
        System.out.print("\tNhập địa chỉ: ");
        String diaChi=in.nextLine();
        p.setDiaChi(diaChi);
        p.setTrangThai(1);
        phongBanDAO.update(p,MaPB);
    }
    private static void option5(Scanner in){
        PhongBan p=new PhongBan();
        System.out.print("\tNhập mã phòng ban: ");
        int MaPB = Integer.parseInt(in.nextLine());
        p.setMaPB(MaPB);

        phongBanDAO.update(p,MaPB);
    }

    private static void option6(Scanner in){
        NhanVien n = new NhanVien();
        String MaNV;
        do {
            System.out.print("\tNhập mã nhân viên: ");
            MaNV = in.nextLine();
        }
        while (nhanVienDAO.getById(MaNV)!=null);
        n.setMaNV(MaNV);
        System.out.print("\tNhập tên nhân viên: ");
        n.setHoTen(in.nextLine());
        String sdt;
        IsSoDienThoai isSoDienThoai=new IsSoDienThoai();
        do {
            System.out.print("\tNhập số điện tho: ");
            sdt = in.nextLine();
        }while (isSoDienThoai.isSoDienThoai(sdt)==false);
        n.setSdt(sdt);

        System.out.print("\tNhập giới tính: ");
        n.setGioiTinh(in.nextLine());
        System.out.print("\tNhập ngày sinh: ");
        n.setNgaySinh(in.nextLine());
        System.out.print("\tNhập dân tộc: ");
        n.setDanToc(in.nextLine());
        System.out.print("\tNhập quê quán: ");
        n.setQueQuan(in.nextLine());
        System.out.println("\tChọn phòng ban: ");
        List<PhongBan> phongBanList = phongBanDAO.getAll();
        for (int i = 0; i < phongBanList.size(); i++) {
            System.out.printf("\t\t%-20d %-20s \n", phongBanList.get(i).getMaPB(), phongBanList.get(i).getTenPB());
        }
        // Tam thoi nhap chinh xac
//        long MaPB =  phongBanList.get(Integer.parseInt(in.nextLine())).getMaPB();
        n.setMaPB(Integer.parseInt(in.nextLine()));

        System.out.println("\tChọn trình độ học vấn: ");
        List<TrinhDoHocVan> trinhDoHocVanList = trinhDoHocVanDAO.getAll();
        for (int i = 0; i < trinhDoHocVanList.size(); i++) {
            System.out.printf("\t\t%-20d %-20s \n", trinhDoHocVanList.get(i).getMaTDHV(), trinhDoHocVanList.get(i).getTTDHV());
        }
        // Tam thoi nhap chinh xac
//        long MaTDHV =  trinhDoHocVanList.get(Integer.parseInt(in.nextLine())).getMaTDHV();
        n.setMaTDHV(Integer.parseInt(in.nextLine()));

        System.out.println("Chọn lương:");
        List<Luong> luongList = luongDAO.getAll();
        for (int i = 0; i < luongList.size(); i++) {
            System.out.printf("\t\t%-20d %-20s \n", luongList.get(i).getBacLuong(), luongList.get(i).getLuongCB());
        }
        // Tam thoi nhap chinh xac
//        int BacLuong =  luongList.get(Integer.parseInt(in.nextLine())).getBacLuong();
        n.setBacLuong(Integer.parseInt(in.nextLine()));
//
        List<ChucVu> chucVuList = chucVuDAO.getAll();
        for (int i = 0; i < chucVuList.size(); i++) {
            System.out.printf("\t\t%-20d %-20s \n", chucVuList.get(i).getMaCV(), chucVuList.get(i).getTenCV());
        }
        // Tam thoi nhap chinh xac
//        int ChucVu =  chucVuList.get(Integer.parseInt(in.nextLine())).getMaCV();
        n.setMaCV(Integer.parseInt(in.nextLine()));

        n.setTrangThaiNV(1);

        nhanVienDAO.insert(n);
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
                    option4(in);
                    break;
                case 5:
                    option5(in);
                    break;
                case 6:
                    option6(in);
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
            }

        }
        while (option != 0);
        in.close();
    }
}
