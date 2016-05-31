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
import model.dao.DAOTLU20CHUCVU;
import model.pojos.Tlu20chucVu;
import server.util.Convert;
import server.util.ValidateUtil;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WSChucVu")
public class WSTLU20CHUCVU {

    /**
     * This is a sample web service operation
     */
   public DAOTLU20CHUCVU init() {
       return new DAOTLU20CHUCVU();
   }
   
   public Convert initConv() {
       return new Convert();
   }
   
    /**
     *
     * @param createdBy
     * @param createdAt
     * @param isActive
     * @param tenchucvu
     * @param machucvu
     * @return
     * @throws ParseException
     */ 
   @WebMethod(operationName = "Tlu20chucVuInsert")
    public String Tlu20chucVuInsert(
            @WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt,
            @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "tenchucvu") String tenchucvu,
            @WebParam(name = "machucvu") String machucvu) throws ParseException {
        Date convcreatedAt = (Date) initConv().ConvertStringToDateSql(createdAt);
        Tlu20chucVu tlu20chucVu = new Tlu20chucVu(createdBy, 
                convcreatedAt, isActive, tenchucvu, machucvu);
        if(init().Tlu20chucVuFindCommon(null, machucvu).isEmpty()) {
            init().Tlu20chucVuInsert(tlu20chucVu);
            return "succ";
        }
       return "fail";
    }
    
    @WebMethod(operationName = "tlu20ChucVuUpdatebyID")
    public String tlu20ChucVuUpdatebyID(
            @WebParam(name = "idcv") int idcv,
            @WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt,
            @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "tenchucvu") String tenchucvu,
            @WebParam(name = "machucvu") String machucvu) throws ParseException {
         Date convcreatedAt = (Date) initConv().ConvertStringToDateSql(createdAt);
        Tlu20chucVu tlu20chucVu = init().Tlu20chucVuFindbyId(idcv);
        List<Tlu20chucVu> tlu20chucVus = init().Tlu20chucVuFindCommon(null, machucvu);
        if(ValidateUtil.isNotNull(tlu20chucVu)) {
            if((tlu20chucVus.size() == 1 && tlu20chucVus.get(0).getIdCv() == idcv)
                    || tlu20chucVus.isEmpty()) {
                init().Tlu20chucVuUpdatebyID(idcv, 
                        createdBy, convcreatedAt, 
                        isActive, tenchucvu, machucvu);
                return "succ";
            }
        }
        
       return "fail";
    }
    @WebMethod(operationName = "tlu20ChucVuDisplayAll")
    public List<Tlu20chucVu> tlu20ChucVuDisplayAll() {
        return  init().Tlu20chucVuDisplayAll();
    }
    
    @WebMethod(operationName = "tlu20ChucVuFindCommon")
    public List<Tlu20chucVu> tlu20ChucVuFindCommon(
            @WebParam(name = "tenchucvu") String tenchucvu,
            @WebParam(name = "machucvu") String machucvu) {
        return init().Tlu20chucVuFindCommon(tenchucvu, machucvu);
    }
    
    @WebMethod(operationName = "Tlu20chucVuDeletebyId")
    public String tlu20ChucVuDelete(
        @WebParam(name = "id") int id) {
        Tlu20chucVu tlu20chucVu = init().Tlu20chucVuFindbyId(id);
        if(ValidateUtil.isNotNull(tlu20chucVu)) {
            init().Tlu20chucVuDeletebyId(id);
            return "succ";
        }
        return "fail";
    }
}
