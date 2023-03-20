package model;

public class ChucVu {
    private int maCV;
    private String tenCV;

    public ChucVu() {
    }

    public ChucVu(int maCV, String tenCV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public int getMaCV() {
        return maCV;
    }

    public void setMaCV(int maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    @Override
    public String toString() {
        return "ChucVu{" +
                "maCV=" + maCV +
                ", tenCV='" + tenCV + '\'' +
                '}';
    }
}
