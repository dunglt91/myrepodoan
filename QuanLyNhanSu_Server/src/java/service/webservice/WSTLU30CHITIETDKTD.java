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
import model.dao.DAOTLU30CHITIETDKTD;
import model.pojos.Tlu30chitietdktd;
import server.util.Convert;
import server.util.ValidateUtil;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WSTLU30CHITIETDKTD")
public class WSTLU30CHITIETDKTD {

    public DAOTLU30CHITIETDKTD init() {
        return new DAOTLU30CHITIETDKTD();
    }
    
    public Convert initConv() {
        return new Convert();
    }
    @WebMethod(operationName = "Tlu30chitietdktdInsert")
    public String Tlu30chitietdktdInsert(
            @WebParam(name = "Kehoachtuyendung") String Kehoachtuyendung,
            @WebParam(name = "Machitietdktd") String Machitietdktd,
            @WebParam(name = "Tenchitietdktd") String Tenchitietdktd,
            @WebParam(name = "DiemcandatDiemcandat") float Diemcandat) {
        Tlu30chitietdktd tlu30chitietdktd = new Tlu30chitietdktd(Tenchitietdktd, 
                Machitietdktd, Kehoachtuyendung, Diemcandat);
        if(init().Tlu30chitietdktdFindCommon(null, Machitietdktd, null).isEmpty()) {
            init().Tlu30chitietdktdInsert(tlu30chitietdktd);
            return "succ";
        } 
        return "fail";
    }
    
    @WebMethod(operationName = "Tlu30chitietdktddDisplayAll")
    public List<Tlu30chitietdktd> Tlu30chitietdktddDisplayAll() {
        return init().Tlu30chitietdktddDisplayAll();
    }
    
    @WebMethod(operationName = "Tlu30chitietdktdFindCommon")
    public List<Tlu30chitietdktd> Tlu30chitietdktdFindCommon(
       @WebParam(name = "Kehoachtuyendung") String Kehoachtuyendung,
       @WebParam(name = "Machitietdktd") String Machitietdktd,
       @WebParam(name = "Tenchitietdktd") String Tenchitietdktd) {
        return init().Tlu30chitietdktdFindCommon(Kehoachtuyendung, 
                Machitietdktd, Tenchitietdktd);
    }
   
    @WebMethod(operationName = "Tlu30chitietdktdFindbyId")
    public Tlu30chitietdktd Tlu30chitietdktdFindbyId(
        @WebParam(name = "iddktd") int iddktd) {
        return init().Tlu30chitietdktdFindbyId(iddktd);
    }
    
    @WebMethod(operationName = "Tlu30chitietdktdUpdatebyID")
    public String Tlu30chitietdktdUpdatebyID(
            @WebParam(name = "iddktd") int iddktd,
            @WebParam(name = "Kehoachtuyendung") String Kehoachtuyendung,
            @WebParam(name = "Machitietdktd") String Machitietdktd,
            @WebParam(name = "Tenchitietdktd") String Tenchitietdktd,
            @WebParam(name = "DiemcandatDiemcandat") float Diemcandat) {
        Tlu30chitietdktd tlu30chitietdktd = init().Tlu30chitietdktdFindbyId(iddktd);
        List<Tlu30chitietdktd> tlu30chitietdktds = init().Tlu30chitietdktdFindCommon(
                null, Machitietdktd, null);
        if(ValidateUtil.isNotNull(tlu30chitietdktd)) {
            if((tlu30chitietdktds.size()== 1 
                    && tlu30chitietdktds.get(0).getId() == tlu30chitietdktd.getId())
                    || tlu30chitietdktds.isEmpty()) {
                init().Tlu30chitietdktdUpdatebyID(iddktd, Kehoachtuyendung, 
                        Machitietdktd, Tenchitietdktd, Diemcandat);
                return "succ";
            }
        }
        return "fail";
    }
    
    @WebMethod(operationName = "Tlu30chitietdktdDeletebyId")
    public String Tlu30chitietdktdDeletebyId(
        @WebParam(name = "iddktd") int iddktd) {
        Tlu30chitietdktd tlu30chitietdktd = init().Tlu30chitietdktdFindbyId(iddktd);
        if(ValidateUtil.isNotNull(tlu30chitietdktd)) {
            init().Tlu30chitietdktdDeletebyId(iddktd);
            return "succ";
        } else {
            return "fail";
        }
    }
            
}
