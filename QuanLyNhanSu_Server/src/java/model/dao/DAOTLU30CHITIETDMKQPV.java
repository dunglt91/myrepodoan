/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu30chitietdanhmucketquaphongvan;
import java.util.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class DAOTLU30CHITIETDMKQPV {

    public void Tlu30chitietdanhmucketquaphongvanInsert(Tlu30chitietdanhmucketquaphongvan tlu30chitietdanhmucketquaphongvan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            ss.save(tlu30chitietdanhmucketquaphongvan);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu30chitietdanhmucketquaphongvan> Tlu30chitietdanhmucketquaphongvanDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu30chitietdanhmucketquaphongvan> tlu30chitietdanhmucketquaphongvan = ss.createCriteria(Tlu30chitietdanhmucketquaphongvan.class).list();
        ss.close();
        return tlu30chitietdanhmucketquaphongvan;

    }
    /*
     Find Row by Id (Primary key)
     */

    public Tlu30chitietdanhmucketquaphongvan Tlu30chitietdanhmucketquaphongvanFindbyId(int idTlu30chitietdanhmucketquaphongvan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu30chitietdanhmucketquaphongvan tlu30chitietdanhmucketquaphongvan = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            tlu30chitietdanhmucketquaphongvan = (Tlu30chitietdanhmucketquaphongvan) ss.get(Tlu30chitietdanhmucketquaphongvan.class, idTlu30chitietdanhmucketquaphongvan);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu30chitietdanhmucketquaphongvan != null) {
            return tlu30chitietdanhmucketquaphongvan;
        } else {
            return null;
        }
    }
    /*
     Delete Rows
     */

    public void Tlu30chitietdanhmucketquaphongvanDeletebyId(int idTlu30chitietdanhmucketquaphongvan) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30chitietdanhmucketquaphongvan tlu30chitietdanhmucketquaphongvan = this.Tlu30chitietdanhmucketquaphongvanFindbyId(idTlu30chitietdanhmucketquaphongvan);
            ss.delete(tlu30chitietdanhmucketquaphongvan);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu30chitietdanhmucketquaphongvanUpdatebyID(int idTlu30chitietdanhmucketquaphongvan, String Machitietdmkqpv, int Idkqpv,
            String Mahsuv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30chitietdanhmucketquaphongvan tlu30chitietdanhmucketquaphongvan = this.Tlu30chitietdanhmucketquaphongvanFindbyId(idTlu30chitietdanhmucketquaphongvan);
            tlu30chitietdanhmucketquaphongvan.setMachitietdmkqpv(Machitietdmkqpv);
            tlu30chitietdanhmucketquaphongvan.setIdkqpv(Idkqpv);
            tlu30chitietdanhmucketquaphongvan.setMahsuv(Mahsuv);
            ss.update(tlu30chitietdanhmucketquaphongvan);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close();
        }
    }
    
    public List<Tlu30chitietdanhmucketquaphongvan> Tlu30chitietdanhmucketquaphongvanFindCommon(
            String Machitietdmkqpv, 
            int Idkqpv,
            String Mahsuv) {

        SessionFactory sf = null;
        Session ss = null;
        List<Tlu30chitietdanhmucketquaphongvan> listcrit = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            Criteria crit = ss.createCriteria(Tlu30chitietdanhmucketquaphongvan.class);
            listcrit = crit.add(Restrictions.like("machitietdmkqpv", ((Machitietdmkqpv.trim().length() == 0 && Machitietdmkqpv.equals("")) ? " " : Machitietdmkqpv), MatchMode.ANYWHERE))
                    .add(Restrictions.like("mahsuv", ((Mahsuv.trim().length() == 0 && Mahsuv.equals("")) ? " " : Mahsuv), MatchMode.ANYWHERE))
                    .add(Restrictions.eq("idkqpv", Idkqpv)).list();
        } catch (Exception e) {

        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return listcrit;

    }
}
