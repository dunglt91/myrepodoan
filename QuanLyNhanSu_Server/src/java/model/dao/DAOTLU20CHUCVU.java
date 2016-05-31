/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu20chucVu;
import java.util.*;

public class DAOTLU20CHUCVU {
    public void Tlu20chucVuInsert(Tlu20chucVu tlu20chucVu) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            ss.save(tlu20chucVu);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu20chucVu> Tlu20chucVuDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu20chucVu> tlu20chucVu = ss.createCriteria(Tlu20chucVu.class).list();
        ss.close();
        return tlu20chucVu;

    }

    public Tlu20chucVu Tlu20chucVuFindbyId(int idTlu20chucVu) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu20chucVu tlu20chucVu = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            tlu20chucVu = (Tlu20chucVu) ss.get(Tlu20chucVu.class, idTlu20chucVu);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu20chucVu != null) {
            return tlu20chucVu;
        } else {
            return null;
        }
    }

    public void Tlu20chucVuDeletebyId(int idTlu20chucVu) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu20chucVu tlu20chucVu = this.Tlu20chucVuFindbyId(idTlu20chucVu);
            ss.delete(tlu20chucVu);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu20chucVuUpdatebyID(int idtlu20chucVu, String CreatedBy, Date CreatedAt, boolean IsActive,
            String Tenchucvu, String Machucvu) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu20chucVu tlu20chucVu = this.Tlu20chucVuFindbyId(idtlu20chucVu);
            tlu20chucVu.setCreatedBy(CreatedBy);
            tlu20chucVu.setCreatedAt(CreatedAt);
            tlu20chucVu.setIsActive(IsActive);
            tlu20chucVu.setTenChucVu(Tenchucvu);
            tlu20chucVu.setMaChucVu(Machucvu);
            ss.update(tlu20chucVu);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close();
        }
    }
    
     public List<Tlu20chucVu> Tlu20chucVuFindCommon(String Tenchucvu, String Machucvu) {

        String [] param = {Tenchucvu, Machucvu};
        String [] namecolum = {"Tenchucvu", "Machucvu"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu20chucVu", namecolum);
        List<Tlu20chucVu> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu20chucVu dmdktd = (Tlu20chucVu) obj;
            listCurOb.add(dmdktd);
        }
        return listCurOb;

    }
}
