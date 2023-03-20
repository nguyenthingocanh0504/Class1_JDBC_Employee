package model;

public class Luong {
    private int bacLuong;
    private int luongCB;
    private double hsLuong;
    private double hsPhuCap;

    public Luong() {
    }

    public Luong(int bacLuong, int luongCB, double hsLuong, double hsPhuCap) {
        this.bacLuong = bacLuong;
        this.luongCB = luongCB;
        this.hsLuong = hsLuong;
        this.hsPhuCap = hsPhuCap;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
    }

    public int getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(int luongCB) {
        this.luongCB = luongCB;
    }

    public double getHsLuong() {
        return hsLuong;
    }

    public void setHsLuong(double hsLuong) {
        this.hsLuong = hsLuong;
    }

    public double getHsPhuCap() {
        return hsPhuCap;
    }

    public void setHsPhuCap(double hsPhuCap) {
        this.hsPhuCap = hsPhuCap;
    }

    @Override
    public String toString() {
        return "Luong{" +
                "bacLuong=" + bacLuong +
                ", luongCB=" + luongCB +
                ", hsLuong=" + hsLuong +
                ", hsPhuCap=" + hsPhuCap +
                '}';
    }
}
