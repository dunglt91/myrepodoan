/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu20danhmucvongpv;
import java.util.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class DAOTLU20DANHMUCVPV {

    public void Tlu20danhmucvongpvInsert(Tlu20danhmucvongpv tlu20danhmucvongpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            ss.save(tlu20danhmucvongpv);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu20danhmucvongpv> Tlu20danhmucvongpvDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        ss.setCacheMode(CacheMode.IGNORE);
        List<Tlu20danhmucvongpv> Tlu20danhmucvongpv = ss.createCriteria(Tlu20danhmucvongpv.class).list();
        ss.close();
        return Tlu20danhmucvongpv;

    }
    /*
     Find Row by Id (Primary key)
     */

    public Tlu20danhmucvongpv Tlu20danhmucvongpvFindbyId(int idTlu20danhmucvongpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu20danhmucvongpv tlu20danhmucvongpv = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            tlu20danhmucvongpv = (Tlu20danhmucvongpv) ss.get(Tlu20danhmucvongpv.class, idTlu20danhmucvongpv);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu20danhmucvongpv != null) {
            return tlu20danhmucvongpv;
        } else {
            return null;
        }
    }
    /*
     Delete Rows
     */

    public void Tlu20danhmucvongpvDeletebyId(int idTlu20danhmucvongpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20danhmucvongpv tlu30ctdktd = this.Tlu20danhmucvongpvFindbyId(idTlu20danhmucvongpv);
            ss.delete(tlu30ctdktd);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu20danhmucvongpvUpdatebyID(int idTlu20danhmucvongpv, String Madmvpv, String Tendmvpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20danhmucvongpv tlu20danhmucvongpv = this.Tlu20danhmucvongpvFindbyId(idTlu20danhmucvongpv);
            tlu20danhmucvongpv.setMadmvpv(Madmvpv);
            tlu20danhmucvongpv.setTendmvpv(Tendmvpv);
            ss.update(tlu20danhmucvongpv);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close();
        }
    }

    public List<Tlu20danhmucvongpv> Tlu20danhmucvongpvFindCommon(String Madmvpv, String Tendmvpv) {

        SessionFactory sf = null;
        Session ss = null;
        List<Tlu20danhmucvongpv> listcrit = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            Criteria crit = ss.createCriteria(Tlu20danhmucvongpv.class);
            listcrit = crit.add(Restrictions.like("madmvpv", ((Madmvpv.trim().length() == 0 && Madmvpv.equals("")) ? " " : Madmvpv), MatchMode.ANYWHERE))
                    .add(Restrictions.like("tendmvpv", ((Tendmvpv.trim().length() == 0 && Tendmvpv.equals("")) ? " " : Tendmvpv), MatchMode.ANYWHERE)).list();
        } catch (Exception e) {

        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return listcrit;

    }
}
