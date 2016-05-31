/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.util;

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 *
 * @author dunglt
 */
public class ValidateUtil {
    
    public static boolean isNotNull(Object obj) {
        if(obj instanceof String) {
            if(obj != null && !obj.equals(Constant.BLANK)) {
                return true;
            }
        } else {
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isNull(Object obj) {
        if(obj instanceof String) {
            if(obj != null && !obj.equals(Constant.BLANK)) {
                return false;
            }
        } else {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNumber(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
    
    public static boolean isNumberic(String str) {
        try {
            double num = Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
