package model.pojos;
// Generated May 31, 2016 12:16:37 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tlu20loaiHopDongLd generated by hbm2java
 */
public class Tlu20loaiHopDongLd  implements java.io.Serializable {


     private Integer idLhdld;
     private String createdBy;
     private Date createdAt;
     private boolean isActive;
     private String maLoaiDhld;
     private String tenLoaiHdld;
     private int soThang;

    public Tlu20loaiHopDongLd() {
    }

    public Tlu20loaiHopDongLd(String createdBy, Date createdAt, boolean isActive, String maLoaiDhld, String tenLoaiHdld, int soThang) {
       this.createdBy = createdBy;
       this.createdAt = createdAt;
       this.isActive = isActive;
       this.maLoaiDhld = maLoaiDhld;
       this.tenLoaiHdld = tenLoaiHdld;
       this.soThang = soThang;
    }
   
    public Integer getIdLhdld() {
        return this.idLhdld;
    }
    
    public void setIdLhdld(Integer idLhdld) {
        this.idLhdld = idLhdld;
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
    public String getMaLoaiDhld() {
        return this.maLoaiDhld;
    }
    
    public void setMaLoaiDhld(String maLoaiDhld) {
        this.maLoaiDhld = maLoaiDhld;
    }
    public String getTenLoaiHdld() {
        return this.tenLoaiHdld;
    }
    
    public void setTenLoaiHdld(String tenLoaiHdld) {
        this.tenLoaiHdld = tenLoaiHdld;
    }
    public int getSoThang() {
        return this.soThang;
    }
    
    public void setSoThang(int soThang) {
        this.soThang = soThang;
    }




}


