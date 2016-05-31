/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dunglt.qlns.client.util;

import dunglt.qlns.client.constant.Constant;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

/**
 *
 * @author dunglt
 */
public class ClientUtil {
    public static String getStringFromIsActive(boolean isActive) {
        String strIsActive = Constant.BLANK;
        if(isActive) {
            return Constant.ISACTIVE_YES;
        } else {
            return Constant.ISACTIVE_NO;
        }
    }
    
    public static boolean getBooleanFromIsActiveCbb(String isActive) {
        boolean boolIsActive = false;
        if(isActive.equals(Constant.ISACTIVE_YES)) {
            boolIsActive = true;
        } 
            return boolIsActive;
    }
    
    public static String setValueofCombobox(JComboBox cb1) {
        String variable = "";
        variable = (String) cb1.getSelectedItem();
        return variable;
    }
    
        public static void getValueIsActiveFromWS(JComboBox cb1, String isActive) {
        cb1.removeAllItems();
        cb1.addItem(isActive);
        
        if(isActive.equals(Constant.ISACTIVE_YES)) {
            cb1.addItem(Constant.ISACTIVE_NO);
        } else {
            cb1.addItem(Constant.ISACTIVE_YES);
        }
    }
        
     public static int setValueofSpinner(JSpinner sp) {
        int variable;
        variable = (int) sp.getValue();
        return variable;
    }
     
    public static String setvalueofCheckbox(JCheckBox checkbox) {
        String value = "";
        if (checkbox.isSelected()) {
            return value = checkbox.getText();
        } else {
            return value = "Không kèm " + checkbox.getText();
        }
    }
    
    public static void checkSelected(JCheckBox checkbox, String str) {
        if(str.equals(Constant.CMND) || str.equals(Constant.DON_XIN_VIEC)
        || str.equals(Constant.GIAY_KHAM_SK)  || str.equals(Constant.HO_KHAU)
        || str.equals(Constant.SO_YEU_LL)) {
           checkbox.setSelected(true);
        }
    }
    
    public static void checkIsPass(JCheckBox checkbox, boolean b) {
        if(b) {
           checkbox.setSelected(true);
        }
    }
    
    public static String convertIntoString(Integer numb) {
        String result = Constant.BLANK;
        result = numb.toString();
        return result;
    }
    
    public static boolean isactiveCheckBox(JCheckBox jcheckbox) {
        String isactive = "";
        if (jcheckbox.isSelected()) {
            return true;
        } else {
            return false;
        }

    }
}
