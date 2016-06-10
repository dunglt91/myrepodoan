/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu20dieuKienTuyenDung;
import java.util.*;

public class DaoTLU20DieuKienTuyenDung {

    public void Tlu20dieuKienTuyenDungInsert(Tlu20dieuKienTuyenDung tlu20dktd) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            ss.save(tlu20dktd);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu20dieuKienTuyenDung> Tlu20dieuKienTuyenDungDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        ss.setCacheMode(CacheMode.IGNORE);
        List<Tlu20dieuKienTuyenDung> tlu20dktd = ss.createCriteria(Tlu20dieuKienTuyenDung.class).list();
        ss.close();
        return tlu20dktd;

    }

    public Tlu20dieuKienTuyenDung Tlu20dieuKienTuyenDungFindbyId(int idTlu20dieuKienTuyenDung) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu20dieuKienTuyenDung tlu20dktd = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            tlu20dktd = (Tlu20dieuKienTuyenDung) ss.get(Tlu20dieuKienTuyenDung.class, idTlu20dieuKienTuyenDung);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu20dktd != null) {
            return tlu20dktd;
        } else {
            return null;
        }
    }

    public void Tlu20dieuKienTuyenDungDeletebyId(int idTlu20dieuKienTuyenDung) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20dieuKienTuyenDung tlu20dktd = this.Tlu20dieuKienTuyenDungFindbyId(idTlu20dieuKienTuyenDung);
            ss.delete(tlu20dktd);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu20dieuKienTuyenDungUpdatebyID(int idtlu20dktd, String CreatedBy, Date CreatedAt, boolean IsActive,
            String tenDmdktd, String maDmdktd) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20dieuKienTuyenDung tlu20dktd = this.Tlu20dieuKienTuyenDungFindbyId(idtlu20dktd);
            tlu20dktd.setCreatedBy(CreatedBy);
            tlu20dktd.setCreatedAt(CreatedAt);
            tlu20dktd.setIsActive(IsActive);
            tlu20dktd.setTendmdktd(tenDmdktd);
            tlu20dktd.setMadmdktd(maDmdktd);
            ss.update(tlu20dktd);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close();
        }
    }
    
     public List<Tlu20dieuKienTuyenDung> Tlu20dieuKienTuyenDungFindCommon(String tenDmdktd, String maDmdktd) {

        String [] param = {tenDmdktd, maDmdktd};
        String [] namecolum = {"tendmdktd", "madmdktd"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu20dieuKienTuyenDung", namecolum);
        List<Tlu20dieuKienTuyenDung> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu20dieuKienTuyenDung dmdktd = (Tlu20dieuKienTuyenDung) obj;
            listCurOb.add(dmdktd);
        }
        return listCurOb;
    }
}
