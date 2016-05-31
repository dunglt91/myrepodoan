package model.pojos;
// Generated May 31, 2016 12:16:37 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tlu30keHoachTuyenDung generated by hbm2java
 */
public class Tlu30keHoachTuyenDung  implements java.io.Serializable {


     private Integer idKhtd;
     private String createdBy;
     private Date createdAt;
     private boolean isActive;
     private String keHoachSo;
     private Date ngayKeHoach;
     private String boPhan;
     private String chucVu;
     private String trinhDoVanHoa;
     private int soLuong;
     private String gioiTinh;
     private int tuoiMin;
     private int tuoiMax;
     private String noiLamViec;
     private String kinhNghiem;
     private String ghiChu;

    public Tlu30keHoachTuyenDung() {
    }

	
    public Tlu30keHoachTuyenDung(String createdBy, Date createdAt, boolean isActive, String keHoachSo, Date ngayKeHoach, String boPhan, String chucVu, String trinhDoVanHoa, int soLuong, String gioiTinh, int tuoiMin, int tuoiMax, String noiLamViec, String kinhNghiem) {
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.isActive = isActive;
        this.keHoachSo = keHoachSo;
        this.ngayKeHoach = ngayKeHoach;
        this.boPhan = boPhan;
        this.chucVu = chucVu;
        this.trinhDoVanHoa = trinhDoVanHoa;
        this.soLuong = soLuong;
        this.gioiTinh = gioiTinh;
        this.tuoiMin = tuoiMin;
        this.tuoiMax = tuoiMax;
        this.noiLamViec = noiLamViec;
        this.kinhNghiem = kinhNghiem;
    }
    public Tlu30keHoachTuyenDung(String createdBy, Date createdAt, boolean isActive, String keHoachSo, Date ngayKeHoach, String boPhan, String chucVu, String trinhDoVanHoa, int soLuong, String gioiTinh, int tuoiMin, int tuoiMax, String noiLamViec, String kinhNghiem, String ghiChu) {
       this.createdBy = createdBy;
       this.createdAt = createdAt;
       this.isActive = isActive;
       this.keHoachSo = keHoachSo;
       this.ngayKeHoach = ngayKeHoach;
       this.boPhan = boPhan;
       this.chucVu = chucVu;
       this.trinhDoVanHoa = trinhDoVanHoa;
       this.soLuong = soLuong;
       this.gioiTinh = gioiTinh;
       this.tuoiMin = tuoiMin;
       this.tuoiMax = tuoiMax;
       this.noiLamViec = noiLamViec;
       this.kinhNghiem = kinhNghiem;
       this.ghiChu = ghiChu;
    }
   
    public Integer getIdKhtd() {
        return this.idKhtd;
    }
    
    public void setIdKhtd(Integer idKhtd) {
        this.idKhtd = idKhtd;
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
    public String getKeHoachSo() {
        return this.keHoachSo;
    }
    
    public void setKeHoachSo(String keHoachSo) {
        this.keHoachSo = keHoachSo;
    }
    public Date getNgayKeHoach() {
        return this.ngayKeHoach;
    }
    
    public void setNgayKeHoach(Date ngayKeHoach) {
        this.ngayKeHoach = ngayKeHoach;
    }
    public String getBoPhan() {
        return this.boPhan;
    }
    
    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }
    public String getChucVu() {
        return this.chucVu;
    }
    
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public String getTrinhDoVanHoa() {
        return this.trinhDoVanHoa;
    }
    
    public void setTrinhDoVanHoa(String trinhDoVanHoa) {
        this.trinhDoVanHoa = trinhDoVanHoa;
    }
    public int getSoLuong() {
        return this.soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public String getGioiTinh() {
        return this.gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public int getTuoiMin() {
        return this.tuoiMin;
    }
    
    public void setTuoiMin(int tuoiMin) {
        this.tuoiMin = tuoiMin;
    }
    public int getTuoiMax() {
        return this.tuoiMax;
    }
    
    public void setTuoiMax(int tuoiMax) {
        this.tuoiMax = tuoiMax;
    }
    public String getNoiLamViec() {
        return this.noiLamViec;
    }
    
    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }
    public String getKinhNghiem() {
        return this.kinhNghiem;
    }
    
    public void setKinhNghiem(String kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }
    public String getGhiChu() {
        return this.ghiChu;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }




}


