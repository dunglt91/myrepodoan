package hrm.pack.dunglt.client_hrm;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by dunglt on 6/13/16.
 */
public class wsDangNhap {

    public static String NAMESPACE = "http://webservice.service/";
    public static String METHOD_NAME = "TestLogin";
    public static String URL = "http://10.0.2.2:8181/NetBeansProjects/WsDangNhap?WSDL";
    /*
    * co the call qua ip inet cua may vi du http://192.168.122.1:8181/NetBeansProjects/WsDangNhap?wsdl
    */
    public static String ACTION = "TestLogin";

    public wsDangNhap() {

    }

    public String TestLogin(String userName, String pass) throws XmlPullParserException, IOException {
        SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapObject.addProperty("username", userName);
        soapObject.addProperty("pass", pass);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        HttpTransportSE transportSE = new HttpTransportSE(URL);

        transportSE.call(ACTION, envelope);
        Object result  = (Object) envelope.getResponse();

        return String.valueOf(result.toString());

    }
}

