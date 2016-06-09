/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import org.hibernate.*;
import model.pojos.Tlu30chitietdktd;
import java.util.*;
public class DAOTLU30CHITIETDKTD {
     public void Tlu30chitietdktdInsert(Tlu30chitietdktd tlu30ctDktd) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            ss.save(tlu30ctDktd);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    
    public List<Tlu30chitietdktd> Tlu30chitietdktddDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        ss.setCacheMode(CacheMode.IGNORE);
        List<Tlu30chitietdktd> ctdktd = ss.createCriteria(Tlu30chitietdktd.class).list();
        ss.close();
        return ctdktd;
        
    }
    /*
     Find Row by Id (Primary key)
     */
    public Tlu30chitietdktd Tlu30chitietdktdFindbyId(int idctdktd) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu30chitietdktd tlu30ctDktd = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            tlu30ctDktd = (Tlu30chitietdktd) ss.get(Tlu30chitietdktd.class, idctdktd);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu30ctDktd != null) {
            return tlu30ctDktd;
        } else {
            return null;
        }
    }
    /*
     Delete Rows
     */

    public void Tlu30chitietdktdDeletebyId(int idctdktd) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu30chitietdktd tlu30ctdktd = this.Tlu30chitietdktdFindbyId(idctdktd);
            ss.delete(tlu30ctdktd);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu30chitietdktdUpdatebyID(int iddktd, String Kehoachtuyendung, 
            String Machitietdktd, String Tenchitietdktd,
            float Diemcandat) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu30chitietdktd tlu30ctdktd = this.Tlu30chitietdktdFindbyId(iddktd);
            tlu30ctdktd.setKehoachtuyendung(Kehoachtuyendung);
            tlu30ctdktd.setMachitietdktd(Machitietdktd);
            tlu30ctdktd.setTenchitietdktd(Tenchitietdktd);
            tlu30ctdktd.setDiemcandat(Diemcandat);
            ss.update(tlu30ctdktd);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close(); 
       }
    }
    
    public List<Tlu30chitietdktd> Tlu30chitietdktdFindCommon(String Kehoachtuyendung,
            String Machitietdktd, String Tenchitietdktd) {
       String [] param = {Kehoachtuyendung, Machitietdktd, Tenchitietdktd};
        String [] namecolum = {"Kehoachtuyendung" ,"Machitietdktd", "Tenchitietdktd"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu30chitietdktd", namecolum);
        List<Tlu30chitietdktd> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu30chitietdktd bophan = (Tlu30chitietdktd) obj;
            listCurOb.add(bophan);
        }
        return listCurOb;

    }
}
