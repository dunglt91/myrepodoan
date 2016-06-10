/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.webservice;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.dao.DaoTLU20DangNhap;
import model.pojos.Tlu20dangNhap;
import server.util.ValidateUtil;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WsDangNhap")
public class WsDangNhap {

    @WebMethod(operationName = "Tlu20DangNhapInsert")
    public String Tlu20DangNhapInsert(
            @WebParam(name = "username") String username,
            @WebParam(name = "pass") String pass,
            @WebParam(name = "repass") String repass,
            @WebParam(name = "role") String role) {
        DaoTLU20DangNhap daotlu20dn = new DaoTLU20DangNhap();
        if (daotlu20dn.TLu20DangNhapFindUser(username) == null) {
            if (pass.equals(repass)) {
                Tlu20dangNhap tlu20dn = new Tlu20dangNhap(username, pass, repass, role);
                daotlu20dn.Tlu20DangNhapInsert(tlu20dn);
                return "succ";
            } else {
                return "pass va repass phai trung nhau";
            }
        } else {
            return "da ton tai username";
        }

    }
    
    @WebMethod(operationName = "Tlu20DangNhapUpdate") 
    public String Tlu20DangNhapUpdate(
            @WebParam(name = "username") String username,
            @WebParam(name = "pass") String pass,
            @WebParam(name = "repass") String repass,
            @WebParam(name = "role") String role) {
        DaoTLU20DangNhap daoTLU20DangNhap = new DaoTLU20DangNhap();
        Tlu20dangNhap tlu20dangNhap = daoTLU20DangNhap.TLu20DangNhapFindUser(username);
        if(ValidateUtil.isNotNull(tlu20dangNhap)) {
            daoTLU20DangNhap.Tlu20DangNhapUpdate(username, pass, repass, role);
            return "succ";
        } else {
            return "fail";
        }
    }

    @WebMethod(operationName = "TestLogin")
    public String TestLogin(@WebParam(name = "username") String username,
            @WebParam(name = "pass") String pass) {
        DaoTLU20DangNhap daotlu20dn = new DaoTLU20DangNhap();
        if (daotlu20dn.TLu20DangNhapFindUser(username) != null) {
            if (daotlu20dn.TestLogin(username, pass) == true) {
                return "dang nhap thanh cong";
            } else {
                return "sai pass";
            }
        } else {
            return "sai username";
        }

    }
    
    @WebMethod (operationName = "TLu20Delete")
    public String TLu20Delete (@WebParam(name = "user") String user) {
        DaoTLU20DangNhap daotludn = new DaoTLU20DangNhap();
        daotludn.TLu20Delete(user);
        return "deleted";
    } 
    
    @WebMethod (operationName = "TLu20DangNhapFindUser")
    public Tlu20dangNhap TLu20DangNhapFindUser (@WebParam(name = "user") String user) {
        DaoTLU20DangNhap daotludn = new DaoTLU20DangNhap();
        return daotludn.TLu20DangNhapFindUser(user);
    } 
    
    @WebMethod(operationName = "Tlu20dangNhapFindCommon")
    public List<Tlu20dangNhap> Tlu20dangNhapFindCommon(
        @WebParam(name = "uname") String uname) {
        DaoTLU20DangNhap dangNhap = new DaoTLU20DangNhap();
        return dangNhap.Tlu20dangNhapFindCommon(uname);
    }
}
