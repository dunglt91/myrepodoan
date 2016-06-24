package hrm.pack.dunglt.client_hrm;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import ws.model.Tlu30chitietketquavpv;

/**
 * Created by dunglt on 6/24/16. Tlu30chitietketquavpvDisplayAll
 */
public class wsChiTietKqpv {
    public static String NAMESPACE = "http://webservice.service/";
    public static String METHOD_NAME = "Tlu30chitietketquavpvFindCommon";
    public static String URL = "http://10.0.2.2:8181/NetBeansProjects/WSTLU30CHITIETKQVPV?wsdl";
    public static String ACTION = "Tlu30chitietketquavpvFindCommon";


    public static String METHOD_NAME_DA = "Tlu30chitietketquavpvDisplayAll";
    public static String ACTION_DA = "Tlu30chitietketquavpvDisplayAll";


    public ArrayList<Tlu30chitietketquavpv> findCommon(String machitietdmkqpv, String madkpv,
                String tendkpv, String diemcandat, String diemdatduoc) throws IOException, XmlPullParserException {

        ArrayList<Tlu30chitietketquavpv> tlu30chitietketquavpvs = new ArrayList<Tlu30chitietketquavpv>();
        SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapObject.addProperty("machitietdmkqpv", machitietdmkqpv);
        soapObject.addProperty("madkpv", madkpv);
        soapObject.addProperty("tendkpv", tendkpv);
        soapObject.addProperty("diemcandat", diemcandat);
        soapObject.addProperty("diemdatduoc", diemdatduoc);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        HttpTransportSE transportSE = new HttpTransportSE(URL);

        transportSE.call(ACTION, envelope);
        SoapObject object = (SoapObject) envelope.bodyIn;

        for (int i = 0; i < object.getPropertyCount(); i++) {
            SoapObject obj = (SoapObject) object.getProperty(i);
            Tlu30chitietketquavpv chitietketquavpv = new Tlu30chitietketquavpv();

            chitietketquavpv.setMachitietdmkqpv(String.valueOf(obj.getProperty("machitietdmkqpv")));
            chitietketquavpv.setTendkpv(String.valueOf(obj.getProperty("tendkpv")));
            chitietketquavpv.setDiemdatduoc(Float.parseFloat(String.valueOf(obj.getProperty("diemdatduoc"))));
            PropertyInfo pi = new PropertyInfo();
            object.getPropertyInfo(i, pi);
            Log.d("key", pi.name + " : " + obj.toString());
            tlu30chitietketquavpvs.add(chitietketquavpv);
        }

        return  tlu30chitietketquavpvs;
    }

    public ArrayList<Tlu30chitietketquavpv> getAll() throws IOException, XmlPullParserException {

        ArrayList<Tlu30chitietketquavpv> tlu30chitietketquavpvs = new ArrayList<Tlu30chitietketquavpv>();
        SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME_DA);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapObject);
        HttpTransportSE transportSE = new HttpTransportSE(URL);

        transportSE.call(ACTION_DA, envelope);

        SoapObject object = (SoapObject) envelope.bodyIn;

        for (int i = 0; i < object.getPropertyCount(); i++) {
            SoapObject obj = (SoapObject) object.getProperty(i);
            Tlu30chitietketquavpv chitietketquavpv = new Tlu30chitietketquavpv();

            chitietketquavpv.setMachitietdmkqpv(String.valueOf(obj.getProperty("machitietdmkqpv")));
            chitietketquavpv.setTendkpv(String.valueOf(obj.getProperty("tendkpv")));
            chitietketquavpv.setDiemdatduoc(Float.parseFloat(String.valueOf(obj.getProperty("diemdatduoc"))));
            PropertyInfo pi = new PropertyInfo();
            object.getPropertyInfo(i, pi);
            Log.d("key", pi.name + " : " + obj.toString());
            tlu30chitietketquavpvs.add(chitietketquavpv);
        }

        return  tlu30chitietketquavpvs;
    }

}
