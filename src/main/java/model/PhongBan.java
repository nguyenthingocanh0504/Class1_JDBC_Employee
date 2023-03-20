package model;

public class PhongBan {
    private int maPB;
    private String tenPB;
    private String sdtPB;
    private String diaChi;
    private int trangThai;

    public PhongBan() {
    }

    public PhongBan(int maPB, String tenPB, String sdtPB, String diaChi, int trangThai) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.sdtPB = sdtPB;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public int getMaPB() {
        return maPB;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getSdtPB() {
        return sdtPB;
    }

    public void setSdtPB(String sdtPB) {
        this.sdtPB = sdtPB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhongBan{" +
                "maPB=" + maPB +
                ", tenPB='" + tenPB + '\'' +
                ", sdtPB='" + sdtPB + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
