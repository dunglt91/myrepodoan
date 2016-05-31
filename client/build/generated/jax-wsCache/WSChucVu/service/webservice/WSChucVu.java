
package service.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSChucVu", targetNamespace = "http://webservice.service/", wsdlLocation = "http://localhost:8181/NetBeansProjects/WSChucVu?WSDL")
public class WSChucVu
    extends Service
{

    private final static URL WSCHUCVU_WSDL_LOCATION;
    private final static WebServiceException WSCHUCVU_EXCEPTION;
    private final static QName WSCHUCVU_QNAME = new QName("http://webservice.service/", "WSChucVu");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8181/NetBeansProjects/WSChucVu?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSCHUCVU_WSDL_LOCATION = url;
        WSCHUCVU_EXCEPTION = e;
    }

    public WSChucVu() {
        super(__getWsdlLocation(), WSCHUCVU_QNAME);
    }

    public WSChucVu(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSCHUCVU_QNAME, features);
    }

    public WSChucVu(URL wsdlLocation) {
        super(wsdlLocation, WSCHUCVU_QNAME);
    }

    public WSChucVu(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSCHUCVU_QNAME, features);
    }

    public WSChucVu(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSChucVu(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSTLU20CHUCVU
     */
    @WebEndpoint(name = "WSTLU20CHUCVUPort")
    public WSTLU20CHUCVU getWSTLU20CHUCVUPort() {
        return super.getPort(new QName("http://webservice.service/", "WSTLU20CHUCVUPort"), WSTLU20CHUCVU.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSTLU20CHUCVU
     */
    @WebEndpoint(name = "WSTLU20CHUCVUPort")
    public WSTLU20CHUCVU getWSTLU20CHUCVUPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.service/", "WSTLU20CHUCVUPort"), WSTLU20CHUCVU.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSCHUCVU_EXCEPTION!= null) {
            throw WSCHUCVU_EXCEPTION;
        }
        return WSCHUCVU_WSDL_LOCATION;
    }

}
