package model;

public class NhanVien {
    private String maNV;
    private String hoTen;
    private String sdt;
    private String gioiTinh;
    private String ngaySinh;
    private String danToc;
    private String queQuan;
    private long maPB;
    private long maTDHV;
    private int bacLuong;
    private int maCV;

    private int trangThaiNV = 1;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String sdt, String gioiTinh, String ngaySinh, String danToc, String queQuan, long maPB, long maTDHV, int bacLuong, int maCV, int trangThaiNV) {
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
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

    public long getMaPB() {
        return maPB;
    }

    public void setMaPB(long maPB) {
        this.maPB = maPB;
    }

    public long getMaTDHV() {
        return maTDHV;
    }

    public void setMaTDHV(long maTDHV) {
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
