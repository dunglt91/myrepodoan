
package service.webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSTLU20CHUCVU", targetNamespace = "http://webservice.service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSTLU20CHUCVU {


    /**
     * 
     * @param tenchucvu
     * @param machucvu
     * @return
     *     returns java.util.List<service.webservice.Tlu20ChucVu>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tlu20ChucVuFindCommon", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20ChucVuFindCommon")
    @ResponseWrapper(localName = "tlu20ChucVuFindCommonResponse", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20ChucVuFindCommonResponse")
    @Action(input = "http://webservice.service/WSTLU20CHUCVU/tlu20ChucVuFindCommonRequest", output = "http://webservice.service/WSTLU20CHUCVU/tlu20ChucVuFindCommonResponse")
    public List<Tlu20ChucVu> tlu20ChucVuFindCommon(
        @WebParam(name = "tenchucvu", targetNamespace = "")
        String tenchucvu,
        @WebParam(name = "machucvu", targetNamespace = "")
        String machucvu);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Tlu20chucVuDeletebyId")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Tlu20chucVuDeletebyId", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20BophanDeletebyId")
    @ResponseWrapper(localName = "Tlu20chucVuDeletebyIdResponse", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20BophanDeletebyIdResponse")
    @Action(input = "http://webservice.service/WSTLU20CHUCVU/Tlu20chucVuDeletebyIdRequest", output = "http://webservice.service/WSTLU20CHUCVU/Tlu20chucVuDeletebyIdResponse")
    public String tlu20ChucVuDeletebyId(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param isActive
     * @param tenchucvu
     * @param createdBy
     * @param createdAt
     * @param idcv
     * @param machucvu
     * @return
     *     returns java.lang.String
     * @throws ParseException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tlu20ChucVuUpdatebyID", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20ChucVuUpdatebyID")
    @ResponseWrapper(localName = "tlu20ChucVuUpdatebyIDResponse", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20ChucVuUpdatebyIDResponse")
    @Action(input = "http://webservice.service/WSTLU20CHUCVU/tlu20ChucVuUpdatebyIDRequest", output = "http://webservice.service/WSTLU20CHUCVU/tlu20ChucVuUpdatebyIDResponse", fault = {
        @FaultAction(className = ParseException_Exception.class, value = "http://webservice.service/WSTLU20CHUCVU/tlu20ChucVuUpdatebyID/Fault/ParseException")
    })
    public String tlu20ChucVuUpdatebyID(
        @WebParam(name = "idcv", targetNamespace = "")
        int idcv,
        @WebParam(name = "createdBy", targetNamespace = "")
        String createdBy,
        @WebParam(name = "createdAt", targetNamespace = "")
        String createdAt,
        @WebParam(name = "isActive", targetNamespace = "")
        boolean isActive,
        @WebParam(name = "tenchucvu", targetNamespace = "")
        String tenchucvu,
        @WebParam(name = "machucvu", targetNamespace = "")
        String machucvu)
        throws ParseException_Exception
    ;

    /**
     * 
     * @param isActive
     * @param tenchucvu
     * @param createdBy
     * @param createdAt
     * @param machucvu
     * @return
     *     returns java.lang.String
     * @throws ParseException_Exception
     */
    @WebMethod(operationName = "Tlu20chucVuInsert")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Tlu20chucVuInsert", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20ChucVuInsert")
    @ResponseWrapper(localName = "Tlu20chucVuInsertResponse", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20ChucVuInsertResponse")
    @Action(input = "http://webservice.service/WSTLU20CHUCVU/Tlu20chucVuInsertRequest", output = "http://webservice.service/WSTLU20CHUCVU/Tlu20chucVuInsertResponse", fault = {
        @FaultAction(className = ParseException_Exception.class, value = "http://webservice.service/WSTLU20CHUCVU/Tlu20chucVuInsert/Fault/ParseException")
    })
    public String tlu20ChucVuInsert(
        @WebParam(name = "createdBy", targetNamespace = "")
        String createdBy,
        @WebParam(name = "createdAt", targetNamespace = "")
        String createdAt,
        @WebParam(name = "isActive", targetNamespace = "")
        boolean isActive,
        @WebParam(name = "tenchucvu", targetNamespace = "")
        String tenchucvu,
        @WebParam(name = "machucvu", targetNamespace = "")
        String machucvu)
        throws ParseException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<service.webservice.Tlu20ChucVu>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tlu20ChucVuDisplayAll", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20ChucVuDisplayAll")
    @ResponseWrapper(localName = "tlu20ChucVuDisplayAllResponse", targetNamespace = "http://webservice.service/", className = "service.webservice.Tlu20ChucVuDisplayAllResponse")
    @Action(input = "http://webservice.service/WSTLU20CHUCVU/tlu20ChucVuDisplayAllRequest", output = "http://webservice.service/WSTLU20CHUCVU/tlu20ChucVuDisplayAllResponse")
    public List<Tlu20ChucVu> tlu20ChucVuDisplayAll();

    /**
     * 
     * @return
     *     returns service.webservice.Convert
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "initConv", targetNamespace = "http://webservice.service/", className = "service.webservice.InitConv")
    @ResponseWrapper(localName = "initConvResponse", targetNamespace = "http://webservice.service/", className = "service.webservice.InitConvResponse")
    @Action(input = "http://webservice.service/WSTLU20CHUCVU/initConvRequest", output = "http://webservice.service/WSTLU20CHUCVU/initConvResponse")
    public Convert initConv();

    /**
     * 
     * @return
     *     returns service.webservice.Daotlu30CHITIETKQVPV
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "init", targetNamespace = "http://webservice.service/", className = "service.webservice.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://webservice.service/", className = "service.webservice.InitResponse")
    @Action(input = "http://webservice.service/WSTLU20CHUCVU/initRequest", output = "http://webservice.service/WSTLU20CHUCVU/initResponse")
    public Daotlu30CHITIETKQVPV init();

}
