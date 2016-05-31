/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu30ketQuaPhongVan;
import java.util.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class DAOTLU30KETQUAPHONGVAN {

    public void Tlu30chitietvpvInsert(Tlu30ketQuaPhongVan tlu30ketQuaPhongVan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            ss.save(tlu30ketQuaPhongVan);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu30ketQuaPhongVan> Tlu30ketQuaPhongVanDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu30ketQuaPhongVan> tlu30chitietvpv = ss.createCriteria(Tlu30ketQuaPhongVan.class).list();
        ss.close();
        return tlu30chitietvpv;

    }
    /*
     Find Row by Id (Primary key)
     */

    public Tlu30ketQuaPhongVan Tlu30ketQuaPhongVanFindbyId(int idTlu30ketQuaPhongVan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu30ketQuaPhongVan tlu30ketQuaPhongVan = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            tlu30ketQuaPhongVan = (Tlu30ketQuaPhongVan) ss.get(Tlu30ketQuaPhongVan.class, idTlu30ketQuaPhongVan);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu30ketQuaPhongVan != null) {
            return tlu30ketQuaPhongVan;
        } else {
            return null;
        }
    }
    /*
     Delete Rows
     */

    public void Tlu30ketQuaPhongVanDeletebyId(int idTlu30ketQuaPhongVan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30ketQuaPhongVan tlu30ketQuaPhongVan = this.Tlu30ketQuaPhongVanFindbyId(idTlu30ketQuaPhongVan);
            ss.delete(tlu30ketQuaPhongVan);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu30ketQuaPhongVanUpdatebyID(int idTlu30ketQuaPhongVan, String CreatedBy, Date CreatedAt, boolean IsActive, String Machitietvpv,
            boolean DatYeuCau, String KeHoachSo, String NguoiPhongVan, String GhiChu, String NhanXet, boolean TinhTrangPhongVan) {
//        SessionFactory sf = null;
//        Session ss = null;
//        Transaction tx = null;
//        try {
//            sf = HibernateUtil.getSessionFactory();
//            ss = sf.openSession();
//            tx = ss.beginTransaction();
//            Tlu30ketQuaPhongVan tlu30ketQuaPhongVan = this.Tlu30ketQuaPhongVanFindbyId(idTlu30ketQuaPhongVan);
//            tlu30ketQuaPhongVan.setCreatedBy(CreatedBy);
//            tlu30ketQuaPhongVan.setCreatedAt(CreatedAt);
//            tlu30ketQuaPhongVan.setIsActive(IsActive);
//            tlu30ketQuaPhongVan.setDatYeuCau(DatYeuCau);
//            tlu30ketQuaPhongVan.setKeHoachSo(KeHoachSo);
//            tlu30ketQuaPhongVan.setMachitietvpv(Machitietvpv);
//            tlu30ketQuaPhongVan.setNguoiPhongVan(NguoiPhongVan);
//            tlu30ketQuaPhongVan.setGhiChu(GhiChu);
//            tlu30ketQuaPhongVan.setNhanXet(NhanXet);
//            tlu30ketQuaPhongVan.setTinhTrangPhongVan(TinhTrangPhongVan);
//            ss.update(tlu30ketQuaPhongVan);
//            tx.commit();
//            return true;
//        } catch (Exception e) {
//            tx.rollback();
//            return false;
//        } finally {
//            ss.close();
//        }
        return true;
    }

    public static List<Tlu30ketQuaPhongVan> Tlu30ketQuaPhongVanFindCommon(String Machitietvpv,
            String KeHoachSo, String NguoiPhongVan) {

        String [] param = {Machitietvpv, KeHoachSo, NguoiPhongVan};
        String [] namecolum = {"Machitietvpv", "KeHoachSo", "NguoiPhongVan"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu30ketQuaPhongVan", namecolum);
        List<Tlu30ketQuaPhongVan> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu30ketQuaPhongVan dmdktd = (Tlu30ketQuaPhongVan) obj;
            listCurOb.add(dmdktd);
        }
        return listCurOb;

    }
    
}
