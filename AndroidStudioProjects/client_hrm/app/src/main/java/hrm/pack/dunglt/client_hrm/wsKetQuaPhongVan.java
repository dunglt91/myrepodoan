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
import java.util.List;
import java.util.Vector;

import hrm.client.util.ClientUtil;
import ws.model.Tlu30lichPhongVan;

/**
 * Created by dunglt on 6/18/16.
 */
public class wsKetQuaPhongVan {

    public static String NAMESPACE = "http://webservice.service/";
    public static String METHOD_NAME = "Tlu30LpvDisplayAll";
    public static String URL = "http://10.0.2.2:8181/NetBeansProjects/WsTlu30LichPhongVan?wsdl";
    public static String ACTION = "Tlu30LpvDisplayAll";

    public wsKetQuaPhongVan() {

    }

    public ArrayList<Tlu30lichPhongVan> displayAllData() throws XmlPullParserException, IOException {
            ArrayList<Tlu30lichPhongVan> tlu30lichPhongVans = new ArrayList<Tlu30lichPhongVan>();
            SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(soapObject);
            HttpTransportSE transportSE = new HttpTransportSE(URL);

            transportSE.call(ACTION, envelope);


            SoapObject object = (SoapObject) envelope.bodyIn;
            for (int i = 0; i< object.getPropertyCount() ; i++) {
                Tlu30lichPhongVan tlu30lichPhongVan = new Tlu30lichPhongVan();
                SoapObject obj = (SoapObject) object.getProperty(i);

                tlu30lichPhongVan.setUngVien(String.valueOf(obj.getProperty("ungVien")));
                tlu30lichPhongVan.setKeHoachSo(String.valueOf(obj.getProperty("keHoachSo")));
                tlu30lichPhongVan.setDatYeuCau(Boolean.parseBoolean(String.valueOf(obj.getProperty("datYeuCau"))));
                PropertyInfo pi = new PropertyInfo();
                obj.getPropertyInfo(i, pi);
                Log.d("key", pi.name + " : " + object.getProperty(i).toString());
                tlu30lichPhongVans.add(tlu30lichPhongVan);
            }
            return tlu30lichPhongVans;
    }
}
