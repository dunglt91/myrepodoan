
package service.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Tlu30HsuvDelete_QNAME = new QName("http://webservice.service/", "Tlu30hsuvDelete");
    private final static QName _FindByIdResponse_QNAME = new QName("http://webservice.service/", "FindByIdResponse");
    private final static QName _FindbyMaHoSoResponse_QNAME = new QName("http://webservice.service/", "FindbyMaHoSoResponse");
    private final static QName _Tlu30HsuvUpdateResponse_QNAME = new QName("http://webservice.service/", "Tlu30hsuvUpdateResponse");
    private final static QName _FindById_QNAME = new QName("http://webservice.service/", "FindById");
    private final static QName _FindbyMaHoSo_QNAME = new QName("http://webservice.service/", "FindbyMaHoSo");
    private final static QName _Tlu30HsuvFindCommon_QNAME = new QName("http://webservice.service/", "tlu30HsuvFindCommon");
    private final static QName _ParseException_QNAME = new QName("http://webservice.service/", "ParseException");
    private final static QName _Tlu30HsuvInsertResponse_QNAME = new QName("http://webservice.service/", "Tlu30hsuvInsertResponse");
    private final static QName _Tlu30HsuvInsert_QNAME = new QName("http://webservice.service/", "Tlu30hsuvInsert");
    private final static QName _DisplayAll_QNAME = new QName("http://webservice.service/", "DisplayAll");
    private final static QName _DisplayAllResponse_QNAME = new QName("http://webservice.service/", "DisplayAllResponse");
    private final static QName _Tlu30HsuvUpdate_QNAME = new QName("http://webservice.service/", "Tlu30hsuvUpdate");
    private final static QName _Tlu30HsuvFindCommonResponse_QNAME = new QName("http://webservice.service/", "tlu30HsuvFindCommonResponse");
    private final static QName _Tlu30HsuvDeleteResponse_QNAME = new QName("http://webservice.service/", "Tlu30hsuvDeleteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Tlu30HsuvDeleteResponse }
     * 
     */
    public Tlu30HsuvDeleteResponse createTlu30HsuvDeleteResponse() {
        return new Tlu30HsuvDeleteResponse();
    }

    /**
     * Create an instance of {@link Tlu30HsuvUpdate }
     * 
     */
    public Tlu30HsuvUpdate createTlu30HsuvUpdate() {
        return new Tlu30HsuvUpdate();
    }

    /**
     * Create an instance of {@link Tlu30HsuvFindCommonResponse }
     * 
     */
    public Tlu30HsuvFindCommonResponse createTlu30HsuvFindCommonResponse() {
        return new Tlu30HsuvFindCommonResponse();
    }

    /**
     * Create an instance of {@link Tlu30HsuvInsert }
     * 
     */
    public Tlu30HsuvInsert createTlu30HsuvInsert() {
        return new Tlu30HsuvInsert();
    }

    /**
     * Create an instance of {@link DisplayAll }
     * 
     */
    public DisplayAll createDisplayAll() {
        return new DisplayAll();
    }

    /**
     * Create an instance of {@link DisplayAllResponse }
     * 
     */
    public DisplayAllResponse createDisplayAllResponse() {
        return new DisplayAllResponse();
    }

    /**
     * Create an instance of {@link Tlu30HsuvInsertResponse }
     * 
     */
    public Tlu30HsuvInsertResponse createTlu30HsuvInsertResponse() {
        return new Tlu30HsuvInsertResponse();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link Tlu30HsuvFindCommon }
     * 
     */
    public Tlu30HsuvFindCommon createTlu30HsuvFindCommon() {
        return new Tlu30HsuvFindCommon();
    }

    /**
     * Create an instance of {@link Tlu30HsuvUpdateResponse }
     * 
     */
    public Tlu30HsuvUpdateResponse createTlu30HsuvUpdateResponse() {
        return new Tlu30HsuvUpdateResponse();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link FindbyMaHoSo }
     * 
     */
    public FindbyMaHoSo createFindbyMaHoSo() {
        return new FindbyMaHoSo();
    }

    /**
     * Create an instance of {@link FindbyMaHoSoResponse }
     * 
     */
    public FindbyMaHoSoResponse createFindbyMaHoSoResponse() {
        return new FindbyMaHoSoResponse();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link Tlu30HsuvDelete }
     * 
     */
    public Tlu30HsuvDelete createTlu30HsuvDelete() {
        return new Tlu30HsuvDelete();
    }

    /**
     * Create an instance of {@link Tlu30HoSoUngVien }
     * 
     */
    public Tlu30HoSoUngVien createTlu30HoSoUngVien() {
        return new Tlu30HoSoUngVien();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu30HsuvDelete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu30hsuvDelete")
    public JAXBElement<Tlu30HsuvDelete> createTlu30HsuvDelete(Tlu30HsuvDelete value) {
        return new JAXBElement<Tlu30HsuvDelete>(_Tlu30HsuvDelete_QNAME, Tlu30HsuvDelete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "FindByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindbyMaHoSoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "FindbyMaHoSoResponse")
    public JAXBElement<FindbyMaHoSoResponse> createFindbyMaHoSoResponse(FindbyMaHoSoResponse value) {
        return new JAXBElement<FindbyMaHoSoResponse>(_FindbyMaHoSoResponse_QNAME, FindbyMaHoSoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu30HsuvUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu30hsuvUpdateResponse")
    public JAXBElement<Tlu30HsuvUpdateResponse> createTlu30HsuvUpdateResponse(Tlu30HsuvUpdateResponse value) {
        return new JAXBElement<Tlu30HsuvUpdateResponse>(_Tlu30HsuvUpdateResponse_QNAME, Tlu30HsuvUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "FindById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindbyMaHoSo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "FindbyMaHoSo")
    public JAXBElement<FindbyMaHoSo> createFindbyMaHoSo(FindbyMaHoSo value) {
        return new JAXBElement<FindbyMaHoSo>(_FindbyMaHoSo_QNAME, FindbyMaHoSo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu30HsuvFindCommon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "tlu30HsuvFindCommon")
    public JAXBElement<Tlu30HsuvFindCommon> createTlu30HsuvFindCommon(Tlu30HsuvFindCommon value) {
        return new JAXBElement<Tlu30HsuvFindCommon>(_Tlu30HsuvFindCommon_QNAME, Tlu30HsuvFindCommon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu30HsuvInsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu30hsuvInsertResponse")
    public JAXBElement<Tlu30HsuvInsertResponse> createTlu30HsuvInsertResponse(Tlu30HsuvInsertResponse value) {
        return new JAXBElement<Tlu30HsuvInsertResponse>(_Tlu30HsuvInsertResponse_QNAME, Tlu30HsuvInsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu30HsuvInsert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu30hsuvInsert")
    public JAXBElement<Tlu30HsuvInsert> createTlu30HsuvInsert(Tlu30HsuvInsert value) {
        return new JAXBElement<Tlu30HsuvInsert>(_Tlu30HsuvInsert_QNAME, Tlu30HsuvInsert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "DisplayAll")
    public JAXBElement<DisplayAll> createDisplayAll(DisplayAll value) {
        return new JAXBElement<DisplayAll>(_DisplayAll_QNAME, DisplayAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "DisplayAllResponse")
    public JAXBElement<DisplayAllResponse> createDisplayAllResponse(DisplayAllResponse value) {
        return new JAXBElement<DisplayAllResponse>(_DisplayAllResponse_QNAME, DisplayAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu30HsuvUpdate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu30hsuvUpdate")
    public JAXBElement<Tlu30HsuvUpdate> createTlu30HsuvUpdate(Tlu30HsuvUpdate value) {
        return new JAXBElement<Tlu30HsuvUpdate>(_Tlu30HsuvUpdate_QNAME, Tlu30HsuvUpdate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu30HsuvFindCommonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "tlu30HsuvFindCommonResponse")
    public JAXBElement<Tlu30HsuvFindCommonResponse> createTlu30HsuvFindCommonResponse(Tlu30HsuvFindCommonResponse value) {
        return new JAXBElement<Tlu30HsuvFindCommonResponse>(_Tlu30HsuvFindCommonResponse_QNAME, Tlu30HsuvFindCommonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu30HsuvDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu30hsuvDeleteResponse")
    public JAXBElement<Tlu30HsuvDeleteResponse> createTlu30HsuvDeleteResponse(Tlu30HsuvDeleteResponse value) {
        return new JAXBElement<Tlu30HsuvDeleteResponse>(_Tlu30HsuvDeleteResponse_QNAME, Tlu30HsuvDeleteResponse.class, null, value);
    }

}
