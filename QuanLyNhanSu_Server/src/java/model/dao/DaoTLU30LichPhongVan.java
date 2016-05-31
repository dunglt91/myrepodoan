/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.pojos.Tlu30lichPhongVan;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dunglt
 */
public class DaoTLU30LichPhongVan {

    public List<Tlu30lichPhongVan> Tlu30LpvDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu30lichPhongVan> displayall = ss.createCriteria(Tlu30lichPhongVan.class).list();
        ss.close();
        return displayall;
    }

    public Tlu30lichPhongVan Tlu30LpvFindById(int idLpv) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Tlu30lichPhongVan display = (Tlu30lichPhongVan) ss.get(Tlu30lichPhongVan.class, idLpv);
        if (ss != null) {
            ss.close();
        } else {
            return null;
        }
        return display;
    }

    public List<Tlu30lichPhongVan> Tlu30LpvFindbySoLPV(int solpv) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu30lichPhongVan> findsolpv = null;
        try {
            Criteria crit = ss.createCriteria(Tlu30lichPhongVan.class);
            findsolpv = (List<Tlu30lichPhongVan>) crit.add(Restrictions.eq("soLichPhongVan", solpv)).list();
        } catch (Exception e) {
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return findsolpv;
    }

    public List<Tlu30lichPhongVan> Tlu30LpvFindByUngVien(String tenuv) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu30lichPhongVan> findtenuv = null;
        try {
            Criteria crit = ss.createCriteria(Tlu30lichPhongVan.class);
            findtenuv = (List<Tlu30lichPhongVan>) crit.add(Restrictions.like("ungVien", tenuv, MatchMode.ANYWHERE)).list();
        } catch (Exception e) {
        }finally {
            if (ss != null) {
                ss.close();
            }
        }
        return findtenuv;
    }

    public boolean Tlu30LpvInsert(Tlu30lichPhongVan insertlpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            tx = ss.beginTransaction();
            ss.save(insertlpv);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
    }

    public void Tlu30LpvUpdate(Integer idLpv, String createdBy, Date createdAt,
            boolean isActive, String ungVien,
            String keHoachSo, int soLichPhongVan,
            Date lichHen, String phuTrachPhongVan,
            String tinhTrangPhongVan, boolean datYeuCau,
            String nhanXet) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            tx = ss.beginTransaction();
            Tlu30lichPhongVan updatelpv = this.Tlu30LpvFindById(idLpv);
            if (updatelpv != null) {
                updatelpv.setCreatedBy(createdBy);
                updatelpv.setCreatedAt(createdAt);
                updatelpv.setIsActive(isActive);
                updatelpv.setUngVien(ungVien);
                updatelpv.setKeHoachSo(keHoachSo);
                updatelpv.setSoLichPhongVan(soLichPhongVan);
                updatelpv.setLichHen(lichHen);
                updatelpv.setPhuTrachPhongVan(phuTrachPhongVan);
                updatelpv.setTinhTrangPhongVan(tinhTrangPhongVan);
                updatelpv.setDatYeuCau(datYeuCau);
                updatelpv.setNhanXet(nhanXet);
                ss.update(updatelpv);
                tx.commit();
            }
        } catch (Exception e) {
            //clear
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void Tlu30LpvDelete(int idLpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            tx = ss.beginTransaction();
            Tlu30lichPhongVan deletelpv = this.Tlu30LpvFindById(idLpv);
            if (deletelpv != null) {
                ss.delete(deletelpv);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
    public List<Tlu30lichPhongVan> tlu30LpvFindCommon(String maHs, String Khs,
            String tenUngVien, String DatYeuCau) {

        String[] param = {maHs, Khs, tenUngVien, DatYeuCau};
        String[] namecolum = {"soLichPhongVan","keHoachSo","ungVien","datYeuCau"};
        List<Object> listReult = FinderUtil.find(param, "Tlu30lichPhongVan", namecolum);
        List<Tlu30lichPhongVan> listCurOb = new ArrayList<>();
        for (Object obj : listReult) {
            Tlu30lichPhongVan tlu30chitietketquavpv = (Tlu30lichPhongVan) obj;
            listCurOb.add(tlu30chitietketquavpv);
        }
        return listCurOb;

    }
}
