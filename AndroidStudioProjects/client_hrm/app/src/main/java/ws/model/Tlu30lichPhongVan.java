package ws.model;

import java.util.Date;

/**
 * Created by dunglt on 6/18/16.
 */
public class Tlu30lichPhongVan {

    private Integer idLpv;
    private String createdBy;
    private Date createdAt;
    private boolean isActive;
    private String ungVien;
    private String keHoachSo;
    private int soLichPhongVan;
    private Date lichHen;
    private String phuTrachPhongVan;
    private String tinhTrangPhongVan;
    private boolean datYeuCau;
    private String nhanXet;

    public Tlu30lichPhongVan() {
    }

    public Tlu30lichPhongVan(String createdBy, Date createdAt, boolean isActive, String ungVien, String keHoachSo, int soLichPhongVan, Date lichHen, String phuTrachPhongVan, String tinhTrangPhongVan, boolean datYeuCau, String nhanXet) {
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.isActive = isActive;
        this.ungVien = ungVien;
        this.keHoachSo = keHoachSo;
        this.soLichPhongVan = soLichPhongVan;
        this.lichHen = lichHen;
        this.phuTrachPhongVan = phuTrachPhongVan;
        this.tinhTrangPhongVan = tinhTrangPhongVan;
        this.datYeuCau = datYeuCau;
        this.nhanXet = nhanXet;
    }

    public Integer getIdLpv() {
        return this.idLpv;
    }

    public void setIdLpv(Integer idLpv) {
        this.idLpv = idLpv;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public boolean isIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getUngVien() {
        return this.ungVien;
    }

    public void setUngVien(String ungVien) {
        this.ungVien = ungVien;
    }
    public String getKeHoachSo() {
        return this.keHoachSo;
    }

    public void setKeHoachSo(String keHoachSo) {
        this.keHoachSo = keHoachSo;
    }
    public int getSoLichPhongVan() {
        return this.soLichPhongVan;
    }

    public void setSoLichPhongVan(int soLichPhongVan) {
        this.soLichPhongVan = soLichPhongVan;
    }
    public Date getLichHen() {
        return this.lichHen;
    }

    public void setLichHen(Date lichHen) {
        this.lichHen = lichHen;
    }
    public String getPhuTrachPhongVan() {
        return this.phuTrachPhongVan;
    }

    public void setPhuTrachPhongVan(String phuTrachPhongVan) {
        this.phuTrachPhongVan = phuTrachPhongVan;
    }
    public String getTinhTrangPhongVan() {
        return this.tinhTrangPhongVan;
    }

    public void setTinhTrangPhongVan(String tinhTrangPhongVan) {
        this.tinhTrangPhongVan = tinhTrangPhongVan;
    }
    public boolean isDatYeuCau() {
        return this.datYeuCau;
    }

    public void setDatYeuCau(boolean datYeuCau) {
        this.datYeuCau = datYeuCau;
    }
    public String getNhanXet() {
        return this.nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }

}
