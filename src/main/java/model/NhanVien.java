package model;

public class NhanVien {
    private int maNV;
    private String hoTen;
    private String sdt;
    private String gioiTinh;
    private String ngaySinh;
    private String danToc;
    private String queQuan;
    private int maPB;
    private int maTDHV;
    private int bacLuong;
    private int maCV;
    private int trangThaiNV;

    public NhanVien() {
    }

    public NhanVien(int maNV, String hoTen, String sdt, String gioiTinh, String ngaySinh, String danToc, String queQuan, int maPB, int maTDHV, int bacLuong, int maCV, int trangThaiNV) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.danToc = danToc;
        this.queQuan = queQuan;
        this.maPB = maPB;
        this.maTDHV = maTDHV;
        this.bacLuong = bacLuong;
        this.maCV = maCV;
        this.trangThaiNV = trangThaiNV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public int getMaPB() {
        return maPB;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }

    public int getMaTDHV() {
        return maTDHV;
    }

    public void setMaTDHV(int maTDHV) {
        this.maTDHV = maTDHV;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
    }

    public int getMaCV() {
        return maCV;
    }

    public void setMaCV(int maCV) {
        this.maCV = maCV;
    }

    public int getTrangThaiNV() {
        return trangThaiNV;
    }

    public void setTrangThaiNV(int trangThaiNV) {
        this.trangThaiNV = trangThaiNV;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", hoTen='" + hoTen + '\'' +
                ", sdt='" + sdt + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", danToc='" + danToc + '\'' +
                ", queQuan='" + queQuan + '\'' +
                ", maPB=" + maPB +
                ", maTDHV=" + maTDHV +
                ", bacLuong=" + bacLuong +
                ", maCV=" + maCV +
                ", trangThaiNV=" + trangThaiNV +
                '}';
    }
}
