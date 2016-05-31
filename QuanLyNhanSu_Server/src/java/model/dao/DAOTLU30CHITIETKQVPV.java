/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu30chitietketquavpv;
import java.util.*;

public class DAOTLU30CHITIETKQVPV {

    public void Tlu30chitietketquavpvInsert(Tlu30chitietketquavpv tlu30chitietketquavpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            ss.save(tlu30chitietketquavpv);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu30chitietketquavpv> Tlu30chitietketquavpvDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu30chitietketquavpv> tlu30chitietketquavpv = ss.createCriteria(Tlu30chitietketquavpv.class).list();
        ss.close();
        return tlu30chitietketquavpv;

    }
    /*
     Find Row by Id (Primary key)
     */

    public Tlu30chitietketquavpv Tlu30chitietketquavpvFindbyId(int idTlu30chitietketquavpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu30chitietketquavpv tlu30chitietketquavpv = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            tlu30chitietketquavpv = (Tlu30chitietketquavpv) ss.get(Tlu30chitietketquavpv.class, idTlu30chitietketquavpv);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu30chitietketquavpv != null) {
            return tlu30chitietketquavpv;
        } else {
            return null;
        }
    }
    /*
     Delete Rows
     */

    public void Tlu30chitietketquavpvDeletebyId(int idTlu30chitietketquavpv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30chitietketquavpv tlu30chitietketquavpv = this.Tlu30chitietketquavpvFindbyId(idTlu30chitietketquavpv);
            ss.delete(tlu30chitietketquavpv);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu30chitietketquavpvUpdatebyID(int idTlu30chitietketquavpv, 
            String Machitietdmkqpv, String Madkpv,
            String Tendkpv, float Diemcandat, float Diemdatduoc) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30chitietketquavpv tlu30chitietketquavpv = this.Tlu30chitietketquavpvFindbyId(idTlu30chitietketquavpv);
            tlu30chitietketquavpv.setMachitietdmkqpv(Machitietdmkqpv);
            tlu30chitietketquavpv.setMadkpv(Madkpv);
            tlu30chitietketquavpv.setTendkpv(Tendkpv);
            tlu30chitietketquavpv.setDiemcandat(Diemcandat);
            tlu30chitietketquavpv.setDiemdatduoc(Diemdatduoc);
            ss.update(tlu30chitietketquavpv);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close();
        }
    }

    public List<Tlu30chitietketquavpv> Tlu30chitietketquavpvFindCommon(String Machitietdmkqpv, String Madkpv,
            String Tendkpv, String Diemcandat, String Diemdatduoc) {

        String[] param = {Machitietdmkqpv, Madkpv, Tendkpv, Diemcandat, Diemdatduoc};
        String[] namecolum = {"Machitietdmkqpv", "Madkpv", "Tendkpv", "Diemcandat", "Diemdatduoc"};
        List<Object> listReult = FinderUtil.find(param, "Tlu30chitietketquavpv", namecolum);
        List<Tlu30chitietketquavpv> listCurOb = new ArrayList<>();
        for (Object obj : listReult) {
            Tlu30chitietketquavpv tlu30chitietketquavpv = (Tlu30chitietketquavpv) obj;
            listCurOb.add(tlu30chitietketquavpv);
        }
        return listCurOb;

    }

}
