/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.*;
import model.pojos.Tlu20trinhDoVanHoa;
import java.util.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class DAOTLU20TRINHDOVH {

    public void Tlu20trinhDoVanHoaInsert(Tlu20trinhDoVanHoa tlu20trinhDoVanHoa) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            ss.save(tlu20trinhDoVanHoa);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }

    }

    public List<Tlu20trinhDoVanHoa> Tlu20trinhDoVanHoaDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        ss.setCacheMode(CacheMode.IGNORE);
        List<Tlu20trinhDoVanHoa> tlu20trinhDoVanHoa = ss.createCriteria(Tlu20trinhDoVanHoa.class).list();
        ss.close();
        return tlu20trinhDoVanHoa;

    }
    /*
     Find Row by Id (Primary key)
     */

    public Tlu20trinhDoVanHoa Tlu20trinhDoVanHoaFindbyId(int idTlu20trinhDoVanHoa) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        Tlu20trinhDoVanHoa tlu20trinhDoVanHoa = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            tlu20trinhDoVanHoa = (Tlu20trinhDoVanHoa) ss.get(Tlu20trinhDoVanHoa.class, idTlu20trinhDoVanHoa);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu20trinhDoVanHoa != null) {
            return tlu20trinhDoVanHoa;
        } else {
            return null;
        }
    }
    /*
     Delete Rows
     */

    public void Tlu20trinhDoVanHoaDeletebyId(int idTlu20trinhDoVanHoa) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20trinhDoVanHoa tlu20trinhDoVanHoa = this.Tlu20trinhDoVanHoaFindbyId(idTlu20trinhDoVanHoa);
            ss.delete(tlu20trinhDoVanHoa);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    public boolean Tlu20trinhDoVanHoaUpdatebyID(int idTlu20trinhDoVanHoa, String CreatedBy, Date CreatedAt, boolean IsActive,
            String TenTDVH, String MaTDVH) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20trinhDoVanHoa tlu20trinhDoVanHoa = this.Tlu20trinhDoVanHoaFindbyId(idTlu20trinhDoVanHoa);
            tlu20trinhDoVanHoa.setCreatedBy(CreatedBy);
            tlu20trinhDoVanHoa.setCreatedAt(CreatedAt);
            tlu20trinhDoVanHoa.setIsActive(IsActive);
            tlu20trinhDoVanHoa.setMaTdvh(MaTDVH);
            tlu20trinhDoVanHoa.setTenTdvh(TenTDVH);
            ss.update(tlu20trinhDoVanHoa);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            ss.close();
        }
    }

    public List<Tlu20trinhDoVanHoa> Tlu20trinhDoVanHoaFindCommon(String TenTDVH, String MaTDVH) {

        String [] param = {TenTDVH, MaTDVH};
        String [] namecolum = {"TenTDVH", "MaTDVH"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu20trinhDoVanHoa", namecolum);
        List<Tlu20trinhDoVanHoa> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu20trinhDoVanHoa tlu20trinhDoVanHoa = (Tlu20trinhDoVanHoa) obj;
            listCurOb.add(tlu20trinhDoVanHoa);
        }
        return listCurOb;

    }
}
