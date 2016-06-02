
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

    private final static QName _Tlu20DangNhapInsertResponse_QNAME = new QName("http://webservice.service/", "Tlu20DangNhapInsertResponse");
    private final static QName _Tlu20DangNhapUpdate_QNAME = new QName("http://webservice.service/", "Tlu20DangNhapUpdate");
    private final static QName _TLu20DangNhapFindUserResponse_QNAME = new QName("http://webservice.service/", "TLu20DangNhapFindUserResponse");
    private final static QName _TLu20DangNhapFindUser_QNAME = new QName("http://webservice.service/", "TLu20DangNhapFindUser");
    private final static QName _TestLoginResponse_QNAME = new QName("http://webservice.service/", "TestLoginResponse");
    private final static QName _Tlu20DangNhapFindCommonResponse_QNAME = new QName("http://webservice.service/", "Tlu20dangNhapFindCommonResponse");
    private final static QName _TestLogin_QNAME = new QName("http://webservice.service/", "TestLogin");
    private final static QName _Tlu20DangNhapInsert_QNAME = new QName("http://webservice.service/", "Tlu20DangNhapInsert");
    private final static QName _TLu20Delete_QNAME = new QName("http://webservice.service/", "TLu20Delete");
    private final static QName _TLu20DeleteResponse_QNAME = new QName("http://webservice.service/", "TLu20DeleteResponse");
    private final static QName _Tlu20DangNhapUpdateResponse_QNAME = new QName("http://webservice.service/", "Tlu20DangNhapUpdateResponse");
    private final static QName _Tlu20DangNhapFindCommon_QNAME = new QName("http://webservice.service/", "Tlu20dangNhapFindCommon");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Tlu20DangNhapFindCommon }
     * 
     */
    public Tlu20DangNhapFindCommon createTlu20DangNhapFindCommon() {
        return new Tlu20DangNhapFindCommon();
    }

    /**
     * Create an instance of {@link Tlu20DangNhapInsert }
     * 
     */
    public Tlu20DangNhapInsert createTlu20DangNhapInsert() {
        return new Tlu20DangNhapInsert();
    }

    /**
     * Create an instance of {@link Tlu20DangNhapUpdateResponse }
     * 
     */
    public Tlu20DangNhapUpdateResponse createTlu20DangNhapUpdateResponse() {
        return new Tlu20DangNhapUpdateResponse();
    }

    /**
     * Create an instance of {@link TLu20DeleteResponse }
     * 
     */
    public TLu20DeleteResponse createTLu20DeleteResponse() {
        return new TLu20DeleteResponse();
    }

    /**
     * Create an instance of {@link TLu20Delete }
     * 
     */
    public TLu20Delete createTLu20Delete() {
        return new TLu20Delete();
    }

    /**
     * Create an instance of {@link TestLogin }
     * 
     */
    public TestLogin createTestLogin() {
        return new TestLogin();
    }

    /**
     * Create an instance of {@link Tlu20DangNhapFindCommonResponse }
     * 
     */
    public Tlu20DangNhapFindCommonResponse createTlu20DangNhapFindCommonResponse() {
        return new Tlu20DangNhapFindCommonResponse();
    }

    /**
     * Create an instance of {@link TestLoginResponse }
     * 
     */
    public TestLoginResponse createTestLoginResponse() {
        return new TestLoginResponse();
    }

    /**
     * Create an instance of {@link TLu20DangNhapFindUser }
     * 
     */
    public TLu20DangNhapFindUser createTLu20DangNhapFindUser() {
        return new TLu20DangNhapFindUser();
    }

    /**
     * Create an instance of {@link TLu20DangNhapFindUserResponse }
     * 
     */
    public TLu20DangNhapFindUserResponse createTLu20DangNhapFindUserResponse() {
        return new TLu20DangNhapFindUserResponse();
    }

    /**
     * Create an instance of {@link Tlu20DangNhapUpdate }
     * 
     */
    public Tlu20DangNhapUpdate createTlu20DangNhapUpdate() {
        return new Tlu20DangNhapUpdate();
    }

    /**
     * Create an instance of {@link Tlu20DangNhapInsertResponse }
     * 
     */
    public Tlu20DangNhapInsertResponse createTlu20DangNhapInsertResponse() {
        return new Tlu20DangNhapInsertResponse();
    }

    /**
     * Create an instance of {@link Tlu20DangNhap }
     * 
     */
    public Tlu20DangNhap createTlu20DangNhap() {
        return new Tlu20DangNhap();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu20DangNhapInsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu20DangNhapInsertResponse")
    public JAXBElement<Tlu20DangNhapInsertResponse> createTlu20DangNhapInsertResponse(Tlu20DangNhapInsertResponse value) {
        return new JAXBElement<Tlu20DangNhapInsertResponse>(_Tlu20DangNhapInsertResponse_QNAME, Tlu20DangNhapInsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu20DangNhapUpdate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu20DangNhapUpdate")
    public JAXBElement<Tlu20DangNhapUpdate> createTlu20DangNhapUpdate(Tlu20DangNhapUpdate value) {
        return new JAXBElement<Tlu20DangNhapUpdate>(_Tlu20DangNhapUpdate_QNAME, Tlu20DangNhapUpdate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLu20DangNhapFindUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "TLu20DangNhapFindUserResponse")
    public JAXBElement<TLu20DangNhapFindUserResponse> createTLu20DangNhapFindUserResponse(TLu20DangNhapFindUserResponse value) {
        return new JAXBElement<TLu20DangNhapFindUserResponse>(_TLu20DangNhapFindUserResponse_QNAME, TLu20DangNhapFindUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLu20DangNhapFindUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "TLu20DangNhapFindUser")
    public JAXBElement<TLu20DangNhapFindUser> createTLu20DangNhapFindUser(TLu20DangNhapFindUser value) {
        return new JAXBElement<TLu20DangNhapFindUser>(_TLu20DangNhapFindUser_QNAME, TLu20DangNhapFindUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "TestLoginResponse")
    public JAXBElement<TestLoginResponse> createTestLoginResponse(TestLoginResponse value) {
        return new JAXBElement<TestLoginResponse>(_TestLoginResponse_QNAME, TestLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu20DangNhapFindCommonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu20dangNhapFindCommonResponse")
    public JAXBElement<Tlu20DangNhapFindCommonResponse> createTlu20DangNhapFindCommonResponse(Tlu20DangNhapFindCommonResponse value) {
        return new JAXBElement<Tlu20DangNhapFindCommonResponse>(_Tlu20DangNhapFindCommonResponse_QNAME, Tlu20DangNhapFindCommonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "TestLogin")
    public JAXBElement<TestLogin> createTestLogin(TestLogin value) {
        return new JAXBElement<TestLogin>(_TestLogin_QNAME, TestLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu20DangNhapInsert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu20DangNhapInsert")
    public JAXBElement<Tlu20DangNhapInsert> createTlu20DangNhapInsert(Tlu20DangNhapInsert value) {
        return new JAXBElement<Tlu20DangNhapInsert>(_Tlu20DangNhapInsert_QNAME, Tlu20DangNhapInsert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLu20Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "TLu20Delete")
    public JAXBElement<TLu20Delete> createTLu20Delete(TLu20Delete value) {
        return new JAXBElement<TLu20Delete>(_TLu20Delete_QNAME, TLu20Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLu20DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "TLu20DeleteResponse")
    public JAXBElement<TLu20DeleteResponse> createTLu20DeleteResponse(TLu20DeleteResponse value) {
        return new JAXBElement<TLu20DeleteResponse>(_TLu20DeleteResponse_QNAME, TLu20DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu20DangNhapUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu20DangNhapUpdateResponse")
    public JAXBElement<Tlu20DangNhapUpdateResponse> createTlu20DangNhapUpdateResponse(Tlu20DangNhapUpdateResponse value) {
        return new JAXBElement<Tlu20DangNhapUpdateResponse>(_Tlu20DangNhapUpdateResponse_QNAME, Tlu20DangNhapUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tlu20DangNhapFindCommon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service/", name = "Tlu20dangNhapFindCommon")
    public JAXBElement<Tlu20DangNhapFindCommon> createTlu20DangNhapFindCommon(Tlu20DangNhapFindCommon value) {
        return new JAXBElement<Tlu20DangNhapFindCommon>(_Tlu20DangNhapFindCommon_QNAME, Tlu20DangNhapFindCommon.class, null, value);
    }

}
