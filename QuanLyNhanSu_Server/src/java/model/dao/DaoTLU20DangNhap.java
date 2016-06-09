/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojos.Tlu20dangNhap;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author dunglt
 */
public class DaoTLU20DangNhap {

    public void Tlu20DangNhapInsert(Tlu20dangNhap instlu20dangnhap) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            ss.save(instlu20dangnhap);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            ss.close();
        }
    }

    public Tlu20dangNhap TLu20DangNhapFindUser(String user) {
        SessionFactory sf = null;
        Session ss = null;
        Tlu20dangNhap tlu20dn = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tlu20dn = (Tlu20dangNhap) ss.get(Tlu20dangNhap.class, user);
        } catch (Exception e) {
        } finally {
            ss.close();
        }
        return tlu20dn;
    }
    
    public boolean TLu20Delete (String user) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20dangNhap tlu20dn = this.TLu20DangNhapFindUser(user);
            ss.delete(tlu20dn);
            tx.commit();
            return true;
        } catch (Exception e) {
            if(tx!=null)
                tx.rollback();
            return false;
        } finally {
            if(ss!=null)
                ss.close();
        }
    }

    public boolean Tlu20DangNhapUpdate(String user, String pass, String repass, String role) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tx = ss.beginTransaction();
            Tlu20dangNhap tlu20dn = this.TLu20DangNhapFindUser(user);
            tlu20dn.setPasswords(pass);
            tlu20dn.setPasswords(repass);
            tlu20dn.setRole(role);
            ss.update(tlu20dn);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            ss.close();
        }
    }

    public boolean TestLogin(String user, String pass) {
        SessionFactory sf = null;
        Session ss = null;
        Tlu20dangNhap tlu20dn = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            tlu20dn = this.TLu20DangNhapFindUser(user);

        } catch (Exception e) {
        } finally {
            ss.close();
        }
        if (tlu20dn != null) {
            if (tlu20dn.getPasswords().equals(pass)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public List<Tlu20dangNhap> Tlu20dangNhapFindCommon(String uname) {

        String [] param = {uname};
        String [] namecolum = {"username"};
        List<Object> listReult =  FinderUtil.find(param, "Tlu20dangNhap", namecolum);
        List<Tlu20dangNhap> listCurOb = new ArrayList<>();
        for(Object obj : listReult) {
            Tlu20dangNhap tlu20dangNhap = (Tlu20dangNhap) obj;
            listCurOb.add(tlu20dangNhap);
        }
        return listCurOb;

    }
    
}
