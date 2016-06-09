/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu30keHoachTuyenDung;
import java.util.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class DaoTLU30KeHoachTuyenDung {

    public List<Tlu30keHoachTuyenDung> Tlu30khtdDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        ss.setCacheMode(CacheMode.IGNORE);
        List<Tlu30keHoachTuyenDung> listtlu30khtd = ss.createCriteria(Tlu30keHoachTuyenDung.class).list();
        ss.close();
        return listtlu30khtd;
    }

    public Tlu30keHoachTuyenDung Tlu30khtdFindById(int idkhtd) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        ss.setCacheMode(CacheMode.IGNORE);
        Transaction tx = ss.beginTransaction();
        Tlu30keHoachTuyenDung tlu30khtd = (Tlu30keHoachTuyenDung) ss.get(Tlu30keHoachTuyenDung.class, idkhtd);
        ss.close();
        if (tlu30khtd != null) {
            return tlu30khtd;
        } else {
            return null;
        }
    }

    public List<Tlu30keHoachTuyenDung> Tlu30khtdFindByKeHoachSo(String khs) {
        SessionFactory sf = null;
        Session ss = null;
        List<Tlu30keHoachTuyenDung> listcrit = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            Criteria crit = ss.createCriteria(Tlu30keHoachTuyenDung.class);
            listcrit = crit.add(Restrictions.like("keHoachSo", khs, MatchMode.ANYWHERE)).list();
        } catch (Exception e) {

        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return listcrit;
    }

    public boolean Tlu30khtdInsert(Tlu30keHoachTuyenDung tlu30khtd) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            ss.save(tlu30khtd);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            try {
                ss.close();
            } catch (Exception e) {
                //safe
            }
        }
    }

    public void Tlu30khtdUpdateById(int idkhtd, String createdby, Date createdat, boolean isactive, String kehoachso, Date ngaykehoach,
            String bophan, String chucvu, String trinhdovanhoa, int soluong, String gioitinh, int tuoimin, int tuoimax,
            String noilamviec, String kinhnghiem, String ghichu) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu30keHoachTuyenDung tlu30khtd = this.Tlu30khtdFindById(idkhtd);
            if (this.Tlu30khtdFindById(idkhtd) != null) {
                tlu30khtd.setCreatedBy(createdby);
                tlu30khtd.setCreatedAt(createdat);
                tlu30khtd.setIsActive(isactive);
                tlu30khtd.setKeHoachSo(kehoachso);
                tlu30khtd.setNgayKeHoach(ngaykehoach);
                tlu30khtd.setBoPhan(bophan);
                tlu30khtd.setChucVu(chucvu);
                tlu30khtd.setTrinhDoVanHoa(trinhdovanhoa);
                tlu30khtd.setSoLuong(soluong);
                tlu30khtd.setGioiTinh(gioitinh);
                tlu30khtd.setTuoiMin(tuoimin);
                tlu30khtd.setTuoiMax(tuoimax);
                tlu30khtd.setNoiLamViec(noilamviec);
                tlu30khtd.setKinhNghiem(kinhnghiem);
                tlu30khtd.setGhiChu(ghichu);
                ss.update(tlu30khtd);
                tx.commit();
                ss.close();
            } else {
                tx.rollback();
                ss.close();
                throw new RuntimeException("Khong Ton Tai Id");
            }

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw new RuntimeException("Update error");
            }
            tx.rollback();
            throw new RuntimeException("Update error");
        } finally {
            try {
                ss.close();
            } catch (Exception e) {
                //safe
            }
        }
    }

    public void Tlu30khtdDeleteById(int idkhtd) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            if (this.Tlu30khtdFindById(idkhtd) != null) {
                ss.delete(this.Tlu30khtdFindById(idkhtd));
                tx.commit();
                ss.close();
            } else {
                tx.rollback();
                throw new RuntimeException("id" + idkhtd + "is not found");
            }
        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException("delete fail");

        } finally {
            try {
                ss.close();
            } catch (Exception e) {
                //safe
            }
        }

    }
    
    public List<Tlu30keHoachTuyenDung> Tlu30keHoachTuyenDungFindCommon(String keHoachSo , String chucVu, String boPhan) {

        String [] param = {keHoachSo, chucVu, boPhan};
        String [] namecolum = {"keHoachSo", "chucVu", "boPhan"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu30keHoachTuyenDung", namecolum);
        List<Tlu30keHoachTuyenDung> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu30keHoachTuyenDung dmdktd = (Tlu30keHoachTuyenDung) obj;
            listCurOb.add(dmdktd);
        }
        return listCurOb;

    }

}
