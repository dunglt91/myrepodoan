package model.pojos;
// Generated May 31, 2016 12:16:37 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tlu20chucVu generated by hbm2java
 */
public class Tlu20chucVu  implements java.io.Serializable {


     private Integer idCv;
     private String createdBy;
     private Date createdAt;
     private boolean isActive;
     private String tenChucVu;
     private String maChucVu;

    public Tlu20chucVu() {
    }

    public Tlu20chucVu(String createdBy, Date createdAt, boolean isActive, String tenChucVu, String maChucVu) {
       this.createdBy = createdBy;
       this.createdAt = createdAt;
       this.isActive = isActive;
       this.tenChucVu = tenChucVu;
       this.maChucVu = maChucVu;
    }
   
    public Integer getIdCv() {
        return this.idCv;
    }
    
    public void setIdCv(Integer idCv) {
        this.idCv = idCv;
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
    public String getTenChucVu() {
        return this.tenChucVu;
    }
    
    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
    public String getMaChucVu() {
        return this.maChucVu;
    }
    
    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }




}


