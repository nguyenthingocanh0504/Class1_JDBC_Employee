import DTO.LuongNhanVienDTO;
import Function.IncomeTax;
import Function.IsSoDienThoai;
import dao.*;
import model.*;

import java.util.*;
import java.util.stream.Collectors;

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
        System.out.println("9. Tìm kiếm thông tin 1 nhân viên theo mã");
        System.out.println("10. Thêm thông tin nhân viên vào 1 phòng ban");
        System.out.println("11. Xóa thông tin nhân viên ra khỏi phòng ban");
        System.out.println("12. Chuyển vị trí phòng ban cho 1 nhân viên");
        System.out.println("13. Tính thuế thu nhập cá nhân cho 1 nhân viên (theo mã NV)");
        System.out.println("14. Sắp xếp danh sách nhân viên theo mức lương");
        System.out.println("15. Lấy ra những nhân viên có quê quán ở Hà Nội");
        System.out.println("16. Thoát");
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
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Họ tên", "Số điện thoại", "Giới tính", "Ngày sinh", "Dân tộc", "Quê quán","Mã chức vụ");
        System.out.println();
        for (int i = 0; i < nhanVienList.size(); i++) {
            NhanVien n = nhanVienList.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", n.getMaNV(), n.getHoTen(), n.getSdt(), n.getGioiTinh(),n.getNgaySinh(),n.getDanToc(),n.getQueQuan(),n.getMaCV());
        };
    }
    private static void option3(Scanner in){
        PhongBan p = new PhongBan();
        System.out.print("\tNhập tên phòng ban: ");
        p.setTenPB(in.nextLine());

        System.out.print("\tNhập số điện thoại: ");
        String sdt = in.nextLine();
        IsSoDienThoai isSoDienThoai=new IsSoDienThoai();
        while (isSoDienThoai.isSoDienThoai(sdt)==false||sdt==null||sdt.length()==0) {
            System.out.print("\t\tNhập số điện thoại không đúng định dạng, vui lòng nhập lại sdt: ");
            sdt = in.nextLine();
        }
        p.setSdtPB(sdt);

        System.out.print("\tNhập địa chỉ: ");
        p.setDiaChi(in.nextLine());
        p.setTrangThai(1);

        phongBanDAO.insert(p);
    }

    private static void option4(Scanner in){
        PhongBan p=new PhongBan();
        System.out.print("\tNhập mã phòng ban: ");
        int MaPB=Integer.parseInt(in.nextLine());
        while(phongBanDAO.getById(MaPB)==null) {
            System.out.print("\tMã phòng ban chưa tồn tại, vui lòng nhập lại mã phòng ban: ");
            MaPB =Integer.parseInt(in.nextLine());
        }
        p.setMaPB(MaPB);

        System.out.print("\tNhập tên phòng ban: ");
        String TenPB = in.nextLine();
        p.setTenPB(TenPB);

        System.out.print("\tNhập số điện thoại: ");
        String sdt = in.nextLine();
        IsSoDienThoai isSoDienThoai=new IsSoDienThoai();
        while (isSoDienThoai.isSoDienThoai(sdt)==false) {
            System.out.print("\t\tNhập số điện thoại không đúng định dạng, vui lòng nhập lại sdt: ");
            sdt = in.nextLine();
        }
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
        int MaPB=Integer.parseInt(in.nextLine());
        while(phongBanDAO.getById(MaPB)==null) {
            System.out.print("\tMã phòng ban chưa tồn tại, vui lòng nhập lại mã phòng ban: ");
            MaPB =Integer.parseInt(in.nextLine());
        }
        p.setMaPB(MaPB);

        phongBanDAO.delete(p,MaPB);
    }

    private static void option6(Scanner in){
        NhanVien n = new NhanVien();
        System.out.print("\tNhập mã nhân viên: ");
        String maNV=in.nextLine();
        while(nhanVienDAO.getById(maNV)!=null) {
            System.out.print("\tMã nhân viên đã tồn tại, vui lòng nhập lại mã NV: ");
            maNV =in.nextLine();
        }
        n.setMaNV(maNV);
        System.out.print("\tNhập tên nhân viên: ");
        String HoTen = in.nextLine();
        while (HoTen==null|| HoTen.length() == 0){
            System.out.println("Tên nhân viên không được bỏ trống, vui lòng nhập lại tên nhân viên: ");
            HoTen = in.nextLine();
        }
        n.setHoTen(HoTen);

        System.out.print("\tNhập số điện thoại: ");
        String sdt = in.nextLine();
        IsSoDienThoai isSoDienThoai=new IsSoDienThoai();
        while (isSoDienThoai.isSoDienThoai(sdt)==false||sdt==null||sdt.length()==0) {
            System.out.print("\t\tNhập số điện thoại không đúng định dạng, vui lòng nhập lại sdt: ");
            sdt = in.nextLine();
        }
        n.setSdt(sdt);

        System.out.print("\tNhập giới tính: ");
        String GioiTinh = in.nextLine();
        while (GioiTinh==null|| GioiTinh.length() == 0){
            System.out.println("Giới tính không được bỏ trống, vui lòng nhập lại giới tính: ");
            GioiTinh = in.nextLine();
        }
        n.setGioiTinh(GioiTinh);

        System.out.print("\tNhập ngày sinh: ");
        String NgaySinh = in.nextLine();
        while (NgaySinh==null|| NgaySinh.length() == 0){
            System.out.println("Ngày sinh không được bỏ trống, vui lòng nhập lại ngày sinh: ");
            NgaySinh = in.nextLine();
        }
        n.setNgaySinh(NgaySinh);

        System.out.print("\tNhập dân tộc: ");
        String DanToc = in.nextLine();
        while (DanToc==null|| DanToc.length() == 0){
            System.out.println("Dân tộc không được bỏ trống, vui lòng nhập lại dân tộc: ");
            DanToc = in.nextLine();
        }
        n.setDanToc(DanToc);

        System.out.print("\tNhập quê quán: ");
        String QueQuan = in.nextLine();
        while (QueQuan==null|| QueQuan.length() == 0){
            System.out.println("Quê quán không được bỏ trống, vui lòng nhập lại quê quán: ");
            QueQuan = in.nextLine();
        }
        n.setQueQuan(QueQuan);
//        System.out.println("Chọn phòng ban: ");
//        List<PhongBan> phongBanList = phongBanDAO.getAll();
//        System.out.printf("\t\t%-20s %-20s \n","Mã phòng ban","Tên phòng ban");
//        for (int i = 0; i < phongBanList.size(); i++) {
//            System.out.printf("\t\t%-20d %-20s \n", phongBanList.get(i).getMaPB(), phongBanList.get(i).getTenPB());
//        }
//        System.out.println("\tNhập mã phòng ban: ");
//        int MaPB=Integer.parseInt(in.nextLine());
//        while (phongBanDAO.getById(MaPB)==null){
//            System.out.println("Mã phòng ban không hợp lệ, vui lòng nhập lại mã phòng ban: ");
//            MaPB=Integer.parseInt(in.nextLine());
//        }
//        n.setMaPB(MaPB);

        System.out.println("Chọn trình độ học vấn: ");
        List<TrinhDoHocVan> trinhDoHocVanList = trinhDoHocVanDAO.getAll();
        System.out.printf("\t\t%-20s %-20s %-20s\n","Mã trình độ học vấn","Tên trình độ học vấn","Chuyên ngành");
        for (int i = 0; i < trinhDoHocVanList.size(); i++) {
            System.out.printf("\t\t%-20d %-20s %-20s\n", trinhDoHocVanList.get(i).getMaTDHV(), trinhDoHocVanList.get(i).getTTDHV(), trinhDoHocVanList.get(i).getChuyenNganh());
        }
        System.out.println("Nhập mã trình độ học vấn: ");
        int maTDHV=Integer.parseInt(in.nextLine());
        while(trinhDoHocVanDAO.getById(maTDHV)==null){
            System.out.println("Mã trình độ học vấn không hợp lệ, vui lòng nhập lại: ");
            maTDHV=Integer.parseInt(in.nextLine());
        }
        n.setMaTDHV(maTDHV);

        System.out.println("Chọn lương:");
        List<Luong> luongList = luongDAO.getAll();
        System.out.printf("\t\t%-20s %-20s %-20s %-20s\n","Bậc lương","Lương cơ bản","Hệ số lương","Hệ số phụ cấp");
        for (int i = 0; i < luongList.size(); i++) {
            System.out.printf("\t\t%-20d %-20d %-20f %-20f\n", luongList.get(i).getBacLuong(), luongList.get(i).getLuongCB(),luongList.get(i).getHsLuong(),luongList.get(i).getHsPhuCap());
        }
        System.out.println("Nhập bậc lương: ");
        int bacLuong=Integer.parseInt(in.nextLine());
        while(luongDAO.getById(bacLuong)==null){
            System.out.println("Bậc lương không hợp lệ, vui lòng nhập lại: ");
            bacLuong=Integer.parseInt(in.nextLine());
        }
        n.setBacLuong(bacLuong);

        List<ChucVu> chucVuList = chucVuDAO.getAll();
        System.out.printf("\t\t%-20s %-20s\n","Mã chức vụ","Tên chức vụ");
        for (int i = 0; i < chucVuList.size(); i++) {
            System.out.printf("\t\t%-20d %-20s \n", chucVuList.get(i).getMaCV(), chucVuList.get(i).getTenCV());
        }
        System.out.println("Nhập mã chức vụ: ");
        int maCV=Integer.parseInt(in.nextLine());
        while(chucVuDAO.getById(maCV)==null){
            System.out.println("Mã chức vụ không hợp lệ, vui lòng nhập lại: ");
            maCV=Integer.parseInt(in.nextLine());
        }
        n.setBacLuong(maCV);

        n.setTrangThaiNV(1);

        nhanVienDAO.insert(n);
    }

    private static void option7(Scanner in){
        NhanVien n=new NhanVien();
        System.out.print("\tNhập mã nhân viên: ");
        String maNV=in.nextLine();
        while(nhanVienDAO.getById(maNV)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            maNV =in.nextLine();
        }
        n.setMaNV(maNV);

        System.out.print("\tNhập tên nhân viên: ");
        String HoTen = in.nextLine();
        while (HoTen==null|| HoTen.length() == 0){
            System.out.println("Tên nhân viên không được bỏ trống, vui lòng nhập lại tên nhân viên: ");
            HoTen = in.nextLine();
        }
        n.setHoTen(HoTen);

        System.out.print("\tNhập số điện thoại: ");
        String sdt = in.nextLine();
        IsSoDienThoai isSoDienThoai=new IsSoDienThoai();
        while (isSoDienThoai.isSoDienThoai(sdt)==false) {
            System.out.print("\t\tNhập số điện thoại không đúng định dạng, vui lòng nhập lại sdt: ");
            sdt = in.nextLine();
        }
        n.setSdt(sdt);

        System.out.print("\tNhập giới tính: ");
        String GioiTinh = in.nextLine();
        while (GioiTinh==null|| GioiTinh.length() == 0){
            System.out.println("Giới tính không được bỏ trống, vui lòng nhập lại giới tính: ");
            GioiTinh = in.nextLine();
        }
        n.setGioiTinh(GioiTinh);

        System.out.print("\tNhập ngày sinh: ");
        String NgaySinh = in.nextLine();
        while (NgaySinh==null|| NgaySinh.length() == 0){
            System.out.println("Ngày sinh không được bỏ trống, vui lòng nhập lại ngày sinh: ");
            NgaySinh = in.nextLine();
        }
        n.setNgaySinh(NgaySinh);

        System.out.print("\tNhập dân tộc: ");
        String DanToc = in.nextLine();
        while (DanToc==null|| DanToc.length() == 0){
            System.out.println("Dân tộc không được bỏ trống, vui lòng nhập lại dân tộc: ");
            DanToc = in.nextLine();
        }
        n.setDanToc(DanToc);

        System.out.print("\tNhập quê quán: ");
        String QueQuan = in.nextLine();
        while (QueQuan==null|| QueQuan.length() == 0){
            System.out.println("Quê quán không được bỏ trống, vui lòng nhập lại quê quán: ");
            QueQuan = in.nextLine();
        }
        n.setQueQuan(QueQuan);

        nhanVienDAO.update(n,maNV);
    }
    private static void option8(Scanner in){
        NhanVien n=new NhanVien();
        System.out.print("\tNhập mã nhân viên muốn tìm: ");
        String maNV=in.nextLine();
        while(nhanVienDAO.getById(maNV)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            maNV =in.nextLine();
        }
        n.setMaNV(maNV);

        nhanVienDAO.delete(n,maNV);
    }
    private static void option9(Scanner in){
        NhanVien n=new NhanVien();
        System.out.print("\tNhập mã nhân viên muốn tìm: ");
        String maNV=in.nextLine();
        while(nhanVienDAO.getById(maNV)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            maNV =in.nextLine();
        }
        n.setMaNV(maNV);

        System.out.println(nhanVienDAO.getById(maNV));
    }
    private static void option10(Scanner in){
        NhanVien n=new NhanVien();
        System.out.print("\tNhập mã nhân viên: ");
        String maNV=in.nextLine();
        while(nhanVienDAO.getById(maNV)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            maNV =in.nextLine();
        }
        n.setMaNV(maNV);

        System.out.println("Chọn phòng ban: ");
        List<PhongBan> phongBanList = phongBanDAO.getAll();
        System.out.printf("\t\t%-20s %-20s \n","Mã phòng ban","Tên phòng ban");
        for (int i = 0; i < phongBanList.size(); i++) {
            System.out.printf("\t\t%-20d %-20s \n", phongBanList.get(i).getMaPB(), phongBanList.get(i).getTenPB());
        }

        System.out.println("\tNhập mã phòng ban: ");
        int MaPB=Integer.parseInt(in.nextLine());
        while (phongBanDAO.getById(MaPB)==null){
            System.out.println("Mã phòng ban không hợp lệ, vui lòng nhập lại mã phòng ban: ");
            MaPB=Integer.parseInt(in.nextLine());
        }
        n.setMaPB(MaPB);

        nhanVienDAO.update_employee_department(n,maNV);
    }
    private static void option11(Scanner in){
        NhanVien n=new NhanVien();
        System.out.print("\tNhập mã nhân viên muốn tìm: ");
        String maNV=in.nextLine();
        while(nhanVienDAO.getById(maNV)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            maNV =in.nextLine();
        }
        n.setMaNV(maNV);

        nhanVienDAO.delete_employee_from_department(n,maNV);
    }
    private static void option12(Scanner in){
        NhanVien n=new NhanVien();
        System.out.print("\tNhập mã nhân viên: ");
        String maNV=in.nextLine();
        while(nhanVienDAO.getById(maNV)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            maNV =in.nextLine();
        }
        n.setMaNV(maNV);

        System.out.println("Chọn phòng ban: ");
        List<PhongBan> phongBanList = phongBanDAO.getAll();
        System.out.printf("\t\t%-20s %-20s \n","Mã phòng ban","Tên phòng ban");
        for (int i = 0; i < phongBanList.size(); i++) {
            System.out.printf("\t\t%-20d %-20s \n", phongBanList.get(i).getMaPB(), phongBanList.get(i).getTenPB());
        }

        System.out.println("\tNhập mã phòng ban: ");
        int MaPB=Integer.parseInt(in.nextLine());
        while (phongBanDAO.getById(MaPB)==null){
            System.out.println("Mã phòng ban không hợp lệ, vui lòng nhập lại mã phòng ban: ");
            MaPB=Integer.parseInt(in.nextLine());
        }
        n.setMaPB(MaPB);

        nhanVienDAO.update_employee_department(n,maNV);
    }
    private static void option15(){
        List<NhanVien> nhanVienList = nhanVienDAO.getAll();
        nhanVienList.stream().filter(s->s.getQueQuan().equals("Ha Noi"))
                .forEach(p-> System.out.println(p));
    }
    private static void option13(Scanner in){
        NhanVien n=new NhanVien();
        System.out.print("\tNhập mã nhân viên: ");
        String maNV=in.nextLine();
        while(nhanVienDAO.getById(maNV)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            maNV =in.nextLine();
        }
        n.setMaNV(maNV);
        System.out.println("\tNhập số người phụ thuộc: ");
        int number=Integer.parseInt(in.nextLine());
        System.out.println("Thuế của nhân viên là: "+ IncomeTax.getIncomeTax(maNV,number));
    }
    private static void option14(){
//        List<NhanVien> nhanVienList = nhanVienDAO.getAll();
//        List<Luong> luongList = luongDAO.getAll();
//        List<LuongNhanVienDTO> luongNhanVienDTOS = new ArrayList<>();
//        nhanVienList.forEach(nhanVien -> {
//            LuongNhanVienDTO luongNhanVienDTO = new LuongNhanVienDTO();
//            luongNhanVienDTO.setMaNV(nhanVien.getMaNV());
//            luongNhanVienDTO.setTenNV(nhanVien.getHoTen());
//            int bacLuong = nhanVien.getBacLuong();
//            luongList.forEach(luong -> {
//                if(luong.getBacLuong() == bacLuong){
//                    double luongThucLinh = luong.getLuongCB() * luong.getHsLuong() + luong.getLuongCB()* luong.getHsPhuCap();
//                    luongNhanVienDTO.setLuongThucLinh(luongThucLinh);
//                }
//            });
//            luongNhanVienDTOS.add(luongNhanVienDTO);
//        });
//        List<LuongNhanVienDTO> listSorted =  luongNhanVienDTOS.stream().sorted((a,b) -> (int) (a.getLuongThucLinh() - b.getLuongThucLinh())).collect(Collectors.toList());
        System.out.printf("%-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Lương");
        List<LuongNhanVienDTO> luongNhanVienDTOS = nhanVienDAO.getSalaryEmployee();
        luongNhanVienDTOS.forEach(luongNhanVienDTO -> {
            System.out.printf("\n%-20s %-20s %-20s",luongNhanVienDTO.getMaNV(),luongNhanVienDTO.getTenNV(),String.format("%,.1f", luongNhanVienDTO.getLuongThucLinh()));
        });
        System.out.println();
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
            try {
                option = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Không có chức năng!");
            }
            if (option < 1 || option > 16) {
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
                    option7(in);
                    break;
                case 8:
                    option8(in);
                    break;
                case 9:
                    option9(in);
                    break;
                case 10:
                    option10(in);
                    break;
                case 11:
                    option11(in);
                    break;
                case 12:
                    option12(in);
                    break;
                case 13:
                    option13(in);
                    break;
                case 14:
                    option14();
                    break;
                case 15:
                    option15();
                    break;
                case 16:
                    break;
            }

        }
        while (option != 0);
        in.close();
    }
}
