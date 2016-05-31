
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
@WebServiceClient(name = "WSTLU30CHITIETKQVPV", targetNamespace = "http://webservice.service/", wsdlLocation = "http://localhost:8181/NetBeansProjects/WSTLU30CHITIETKQVPV?WSDL")
public class WSTLU30CHITIETKQVPV_Service
    extends Service
{

    private final static URL WSTLU30CHITIETKQVPV_WSDL_LOCATION;
    private final static WebServiceException WSTLU30CHITIETKQVPV_EXCEPTION;
    private final static QName WSTLU30CHITIETKQVPV_QNAME = new QName("http://webservice.service/", "WSTLU30CHITIETKQVPV");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8181/NetBeansProjects/WSTLU30CHITIETKQVPV?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSTLU30CHITIETKQVPV_WSDL_LOCATION = url;
        WSTLU30CHITIETKQVPV_EXCEPTION = e;
    }

    public WSTLU30CHITIETKQVPV_Service() {
        super(__getWsdlLocation(), WSTLU30CHITIETKQVPV_QNAME);
    }

    public WSTLU30CHITIETKQVPV_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSTLU30CHITIETKQVPV_QNAME, features);
    }

    public WSTLU30CHITIETKQVPV_Service(URL wsdlLocation) {
        super(wsdlLocation, WSTLU30CHITIETKQVPV_QNAME);
    }

    public WSTLU30CHITIETKQVPV_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSTLU30CHITIETKQVPV_QNAME, features);
    }

    public WSTLU30CHITIETKQVPV_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSTLU30CHITIETKQVPV_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSTLU30CHITIETKQVPV
     */
    @WebEndpoint(name = "WSTLU30CHITIETKQVPVPort")
    public WSTLU30CHITIETKQVPV getWSTLU30CHITIETKQVPVPort() {
        return super.getPort(new QName("http://webservice.service/", "WSTLU30CHITIETKQVPVPort"), WSTLU30CHITIETKQVPV.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSTLU30CHITIETKQVPV
     */
    @WebEndpoint(name = "WSTLU30CHITIETKQVPVPort")
    public WSTLU30CHITIETKQVPV getWSTLU30CHITIETKQVPVPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.service/", "WSTLU30CHITIETKQVPVPort"), WSTLU30CHITIETKQVPV.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSTLU30CHITIETKQVPV_EXCEPTION!= null) {
            throw WSTLU30CHITIETKQVPV_EXCEPTION;
        }
        return WSTLU30CHITIETKQVPV_WSDL_LOCATION;
    }

}
