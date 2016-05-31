/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu30chitietvpv;
import java.util.*;

public class DAOTLU30CHITIETVPV {

    public void Tlu30chitietvpvInsert(Tlu30chitietvpv tlu30chitietvpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            ss.save(tlu30chitietvpv);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu30chitietvpv> Tlu30chitietvpvDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu30chitietvpv> tlu30chitietvpv = ss.createCriteria(Tlu30chitietvpv.class).list();
        ss.close();
        return tlu30chitietvpv;

    }
    /*
     Find Row by Id (Primary key)
     */

    public Tlu30chitietvpv Tlu30chitietvpvFindbyId(int idTlu30chitietvpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu30chitietvpv tlu30chitietvpv = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            tlu30chitietvpv = (Tlu30chitietvpv) ss.get(Tlu30chitietvpv.class, idTlu30chitietvpv);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu30chitietvpv != null) {
            return tlu30chitietvpv;
        } else {
            return null;
        }
    }
    /*
     Delete Rows
     */

    public void Tlu30chitietvpvDeletebyId(int idTlu30chitietvpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30chitietvpv tlu30ctdktd = this.Tlu30chitietvpvFindbyId(idTlu30chitietvpv);
            ss.delete(tlu30ctdktd);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu30chitietvpvUpdatebyID(int idTlu30chitietvpv, String Machitietvpv,
            String Madmvpv, int SoLichPhongVan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30chitietvpv tlu30chitietvpv = this.Tlu30chitietvpvFindbyId(idTlu30chitietvpv);
            tlu30chitietvpv.setMachitietvpv(Machitietvpv);
            tlu30chitietvpv.setMadmvpv(Madmvpv);
            tlu30chitietvpv.setSoLichPhongVan(SoLichPhongVan);
            ss.update(tlu30chitietvpv);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close();
        }
    }

    public static List<Tlu30chitietvpv> Tlu30chitietvpvFindCommon( String Machitietvpv,
            String Madmvpv, String SoLichPhongVan) {

        String [] param = {Machitietvpv, Madmvpv, SoLichPhongVan};
        String [] namecolum = {"Machitietvpv", "Madmvpv", "SoLichPhongVan"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu30chitietvpv", namecolum);
        List<Tlu30chitietvpv> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu30chitietvpv dmdktd = (Tlu30chitietvpv) obj;
            listCurOb.add(dmdktd);
        }
        return listCurOb;
    }
    
}
