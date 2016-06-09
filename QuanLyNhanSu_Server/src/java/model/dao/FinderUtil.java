/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.CacheMode;
import org.hibernate.Query;

/**
 *
 * @author dunglt
 */
public class FinderUtil {

    public static boolean checkInt(String str) {
        try {

            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean checkFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean checkBoolean(String str) {
        return str.equals("true") || str.equals("false");

    }

    public static List<Object> find(String[] param, String nametable, String[] namecolum) {
        SessionFactory sf = null;
        Session ss = null;
        //Map map = new HashMap<>();
        List<Object> listcrit = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            ss.setCacheMode(CacheMode.IGNORE);
            StringBuilder query = new StringBuilder();
            query.append("from " + nametable + " where 1=1");
            for (int index = 0; index < namecolum.length; index++) {
                if (param[index] != null && !param[index].equals("")) {
                    if(param[index].endsWith(".0")) {
                       param[index]= param[index].substring(0, param[index].length() - 2);
                    }
                    if (checkInt(param[index]) == false || checkFloat(param[index]) == false ) {
                        query.append(" and " + namecolum[index] + " like '%" + param[index] + "%'");
                    } else {
                        if(checkInt(param[index])) {
                            query.append(" and " + namecolum[index] + " = " + Integer.parseInt(param[index]));
                        } else if(checkFloat(param[index])) {
                            query.append(" and " + namecolum[index] + " = " + Float.parseFloat(param[index]));
                        }
                    }

                }
            }
            Query quer = ss.createQuery(query.toString());
            quer.setCacheable(false);
            listcrit = quer.list();

        } catch (Exception e) {

        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return listcrit;
    }

}
