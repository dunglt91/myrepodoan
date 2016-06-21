package hrm.client.util;

/**
 * Created by dunglt on 6/19/16.
 */
public class ClientUtil {

    public static String convertIsPassToString(boolean isPass) {
        String res = StringPool.BLANK;
        if(isPass) {
            res = StringPool.PASS;
        } else {
            res = StringPool.FAIL;
        }

        return res;
    }

    public static String isPass(boolean isPass) {
        String pass = StringPool.BLANK;
        if(isPass) {
            pass = StringPool.PASS;
        } else {
            pass = StringPool.FAIL;
        }

        return pass;
    }
}
