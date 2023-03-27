package Function;

import DTO.LuongNhanVienDTO;
import dao.NhanVienDAO;
import model.NhanVien;

public class IncomeTax {
    public static Double getIncomeTax(String id, int number){
        NhanVienDAO nhanVienDAO=new NhanVienDAO();
        LuongNhanVienDTO e = nhanVienDAO.getSalaryEmployeeByID(id);
        Double salaryVND = e.getLuongThucLinh();
        Double TNTT = salaryVND - 11000000 - 4400000 * number; //Thu nhập tính thuế
        Double incomeTax = 0.00;
        if (salaryVND < 11000000) {
            incomeTax = 0.00;
        }
        if (TNTT > 0 && TNTT <= 5000000) {
            incomeTax = TNTT * 5 / 100.00;
        }
        if (TNTT > 5000000 && TNTT <= 10000000) {
            incomeTax = TNTT * 10 / 100.00;
        }
        if (TNTT > 10000000 && TNTT <= 18000000) {
            incomeTax = TNTT * 15 / 100.00;
        }
        if (TNTT > 18000000 && TNTT <= 32000000) {
            incomeTax = TNTT * 20 / 100.00;
        }
        if (TNTT > 32000000 && TNTT <= 52000000) {
            incomeTax = TNTT * 25 / 100.00;
        }
        if (TNTT > 52000000 && TNTT <= 80000000) {
            incomeTax = TNTT * 30 / 100.00;
        }
        if (TNTT > 80000000) {
            incomeTax = TNTT * 35 / 100.00;
        }
        return incomeTax;
    }
}
