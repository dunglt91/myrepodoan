/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu20bophan;
import java.util.*;

public class DAOBOPHAN {

    public void Tlu20bophanInsert(Tlu20bophan tlu20bophan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            ss.save(tlu20bophan);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu20bophan> Tlu20bophanDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        ss.setCacheMode(CacheMode.IGNORE);
        List<Tlu20bophan> tlu20bophan = ss.createCriteria(Tlu20bophan.class).list();
        ss.close();
        return tlu20bophan;

    }

    public Tlu20bophan Tlu20bophanFindbyId(int idTlu20bophan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu20bophan tlu20bophan = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            tlu20bophan = (Tlu20bophan) ss.get(Tlu20bophan.class, idTlu20bophan);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu20bophan != null) {
            return tlu20bophan;
        } else {
            return null;
        }
    }

    public void Tlu20bophanDeletebyId(int idTlu20bophan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20bophan tlu20bophan = this.Tlu20bophanFindbyId(idTlu20bophan);
            ss.delete(tlu20bophan);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu20bophanUpdatebyID(int idTlu20bophan, String CreatedBy, Date CreatedAt, boolean IsActive,
            String Tenbophan, String Mabophan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            ss.setCacheMode(CacheMode.IGNORE);
            Tlu20bophan tlu20bophan = this.Tlu20bophanFindbyId(idTlu20bophan);
            tlu20bophan.setCreatedBy(CreatedBy);
            tlu20bophan.setCreatedAt(CreatedAt);
            tlu20bophan.setIsActive(IsActive);
            tlu20bophan.setTenbophan(Tenbophan);
            tlu20bophan.setMabophan(Mabophan);
            ss.update(tlu20bophan);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close();
        }
    }
    
     public List<Tlu20bophan> Tlu20bophanFindCommon(String Tenbophan, String Mabophan) {

        String [] param = {Tenbophan, Mabophan};
        String [] namecolum = {"Tenbophan", "Mabophan"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu20bophan", namecolum);
        List<Tlu20bophan> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu20bophan bophan = (Tlu20bophan) obj;
            listCurOb.add(bophan);
        }
        return listCurOb;

    }
}
