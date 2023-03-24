package Function;

import dao.NhanVienDAO;
import model.NhanVien;

public class IncomeTax {
//    public static Double getIncomeTax(int id, int number){
//        NhanVienDAO nhanVienDAO=new NhanVienDAO();
//        NhanVien e = nhanVienDAO.getSalaryOfEmployeeByID(id);
//        long salaryVND = e.getBacLuong();
//        long TNTT = salaryVND - 11000 - 4400 * number; //Thu nhập tính thuế
//        Double incomeTax = 0.00;
//        if (salaryVND < 11000) {
//            incomeTax = 0.00;
//        }
//        if (TNTT > 0 && TNTT <= 5000) {
//            incomeTax = TNTT * 5 / 100.00;
//        }
//        if (TNTT > 5000 && TNTT <= 10000) {
//            incomeTax = TNTT * 10 / 100.00;
//        }
//        if (TNTT > 10000 && TNTT <= 18000) {
//            incomeTax = TNTT * 15 / 100.00;
//        }
//        if (TNTT > 18000 && TNTT <= 32000) {
//            incomeTax = TNTT * 20 / 100.00;
//        }
//        if (TNTT > 32000 && TNTT <= 52000) {
//            incomeTax = TNTT * 25 / 100.00;
//        }
//        if (TNTT > 52000 && TNTT <= 80000) {
//            incomeTax = TNTT * 30 / 100.00;
//        }
//        if (TNTT > 80000) {
//            incomeTax = TNTT * 35 / 100.00;
//        }
//
//        return incomeTax;
//    }
//    }
}
