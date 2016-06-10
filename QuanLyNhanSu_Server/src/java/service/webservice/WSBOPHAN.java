/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.webservice;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.dao.DAOBOPHAN;
import model.pojos.Tlu20bophan;
import server.util.Convert;
import server.util.ValidateUtil;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WSBOPHAN")
public class WSBOPHAN {

    /**
     * This is a sample web service operation
     * @return 
     */
     public DAOBOPHAN init() {
       return new DAOBOPHAN();
   }
   
   public Convert initConv() {
       return new Convert();
   }
   
    /**
     *
     * @param createdBy
     * @param createdAt
     * @param isActive
     * @param Tenbophan
     * @param Mabophan
     * @return
     * @throws ParseException
     */ 
   @WebMethod(operationName = "Tlu20BoPhanInsert")
    public String Tlu20BoPhanInsert(
            @WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt,
            @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "Tenbophan") String Tenbophan,
            @WebParam(name = "Mabophan") String Mabophan) throws ParseException {
         Date convcreatedAt = (Date) initConv().ConvertStringToDateSql(createdAt);
        Tlu20bophan tlu20bophan = new Tlu20bophan(createdBy, 
                convcreatedAt, isActive, Tenbophan, Mabophan);
        if(init().Tlu20bophanFindCommon(null, Mabophan).isEmpty()) {
            init().Tlu20bophanInsert(tlu20bophan);
            return "succ";
        }
       return "fail";
    }
    
    @WebMethod(operationName = "Tlu20bophanUpdatebyID")
    public String Tlu20bophanUpdatebyID(
            @WebParam(name = "id") int id,
            @WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt,
            @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "Tenbophan") String Tenbophan,
            @WebParam(name = "Mabophan") String Mabophan) throws ParseException {
         Date convcreatedAt = (Date) initConv().ConvertStringToDateSql(createdAt);
        Tlu20bophan tlu20BoPhan = init().Tlu20bophanFindbyId(id);
        List<Tlu20bophan> tlu20boPhans = init().Tlu20bophanFindCommon(null, Mabophan);
   
        if(ValidateUtil.isNotNull(tlu20BoPhan)) {
            if((tlu20boPhans.size() == 1 && tlu20boPhans.get(0).getId() == id)
                    || tlu20boPhans.isEmpty()) {
                init().Tlu20bophanUpdatebyID(id, 
                        createdBy, convcreatedAt, 
                        isActive, Tenbophan, Mabophan);
                return "succ";
            }
        }
        
       return "fail";
    }
    @WebMethod(operationName = "Tlu20bophanDisplayAll")
    public List<Tlu20bophan> Tlu20bophanDisplayAll() {
        return  init().Tlu20bophanDisplayAll();
    }
    
    @WebMethod(operationName = "Tlu20bophanFindCommon")
    public List<Tlu20bophan> Tlu20bophanFindCommon(
            @WebParam(name = "Tenbophan") String Tenbophan,
            @WebParam(name = "Mabophan") String Mabophan) {
        return init().Tlu20bophanFindCommon(Tenbophan, Mabophan);
    }
    
    @WebMethod(operationName = "Tlu20bophanDeletebyId")
    public String tlu20ChucVuDelete(
        @WebParam(name = "id") int id) {
        Tlu20bophan tlu20boPhan = init().Tlu20bophanFindbyId(id);
        if(ValidateUtil.isNotNull(tlu20boPhan)) {
            init().Tlu20bophanDeletebyId(id);
            return "succ";
        }
        return "fail";
    }


}
