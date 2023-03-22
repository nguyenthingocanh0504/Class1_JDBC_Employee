package model;

public class TrinhDoHocVan {
    private long maTDHV;
    private String TTDHV;
    private String chuyenNganh;

    public TrinhDoHocVan() {
    }

    public TrinhDoHocVan(long maTDHV, String TTDHV, String chuyenNganh) {
        this.maTDHV = maTDHV;
        this.TTDHV = TTDHV;
        this.chuyenNganh = chuyenNganh;
    }

    public long getMaTDHV() {
        return maTDHV;
    }

    public void setMaTDHV(long maTDHV) {
        this.maTDHV = maTDHV;
    }

    public String getTTDHV() {
        return TTDHV;
    }

    public void setTTDHV(String TTDHV) {
        this.TTDHV = TTDHV;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    @Override
    public String toString() {
        return "TrinhDoHocVan{" +
                "maTDHV=" + maTDHV +
                ", TTDHV='" + TTDHV + '\'' +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                '}';
    }
}
