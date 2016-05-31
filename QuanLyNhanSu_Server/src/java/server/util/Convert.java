/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.util;

/**
 *
 * @author dunglt
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dunglt
 */
public class Convert {

    public Date ConvertStringToDateSql(String date) throws ParseException {
        java.sql.Date sql = java.sql.Date.valueOf(date);
        return sql;
    }
    
    public String ConvertStringToDateTimeSql(Date date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
    }
}