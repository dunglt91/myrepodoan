/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dunglt.qlns.client.util;

import dunglt.qlns.client.constant.Constant;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author dunglt
 */
public class DateTimeUtil {
    public static String convertCalendarToString(Date dateInput) {
        String date = Constant.BLANK;
            SimpleDateFormat sdf = new SimpleDateFormat(Constant.STRING_DATE);
            date = sdf.format(dateInput); 
        return  date;
    }
    
    public static String convertTimeWsToString(Calendar calendar) {
        String date = Constant.BLANK;
        SimpleDateFormat formatter = new SimpleDateFormat(Constant.STRING_DATE);
        formatter.setTimeZone(calendar.getTimeZone());
        date = formatter.format(calendar.getTime());
        return date;
    }
}
