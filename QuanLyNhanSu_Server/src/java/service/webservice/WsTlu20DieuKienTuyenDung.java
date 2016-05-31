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
import model.dao.DaoTLU20DieuKienTuyenDung;
import model.pojos.Tlu20dieuKienTuyenDung;
import server.util.ValidateUtil;
import server.util.Convert;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WsTlu20DieuKienTuyenDung")
public class WsTlu20DieuKienTuyenDung {

    /**
     * This is a sample web service operation
     */
    public DaoTLU20DieuKienTuyenDung init() {
       return new DaoTLU20DieuKienTuyenDung();
   }
   
   public Convert initConv() {
       return new Convert();
   }
   
   @WebMethod(operationName = "tlu20DktdInsert")
    public String tlu20DktdInsert(
            @WebParam(name = "createdby") String createdby,
            @WebParam(name = "createdat") String createdat,
            @WebParam(name = "isactive") boolean isactive,
            @WebParam(name = "madmdktd") String madmdktd,
            @WebParam(name = "tendmdktd") String tendmdktd) throws ParseException {
         Date convcreatedAt = (Date) initConv().ConvertStringToDateSql(createdat);
        Tlu20dieuKienTuyenDung tlu20dieuKienTuyenDung = new Tlu20dieuKienTuyenDung(createdby, 
                null, isactive, tendmdktd, madmdktd);
        if(init().Tlu20dieuKienTuyenDungFindCommon(null, madmdktd).isEmpty()) {
            init().Tlu20dieuKienTuyenDungInsert(tlu20dieuKienTuyenDung);
            return "succ";
        }
       return "fail";
    }
    
    @WebMethod(operationName = "tlu20DktdUpdatebyID")
    public String tlu20DktdUpdatebyID(
            @WebParam(name = "id") int id,
            @WebParam(name = "createdby") String createdby,
            @WebParam(name = "createdAt") String createdAt,
            @WebParam(name = "isactive") boolean isactive,
            @WebParam(name = "tendmdktd") String tendmdktd,
            @WebParam(name = "madmdktd") String madmdktd) throws ParseException {
         Date convcreatedAt = (Date) initConv().ConvertStringToDateSql(createdAt);
        Tlu20dieuKienTuyenDung tlu20DieuKienTuyenDung = init().Tlu20dieuKienTuyenDungFindbyId(id);
        List<Tlu20dieuKienTuyenDung> tlu20DieuKienTuyenDungs = init().Tlu20dieuKienTuyenDungFindCommon(null, madmdktd);
        if(ValidateUtil.isNotNull(tlu20DieuKienTuyenDung)) {
            if((tlu20DieuKienTuyenDungs.size() == 1 && tlu20DieuKienTuyenDungs.get(0).getIdDktd() == id)
                    || tlu20DieuKienTuyenDungs.isEmpty()) {
                init().Tlu20dieuKienTuyenDungUpdatebyID(id, 
                        createdby, convcreatedAt, 
                        isactive, tendmdktd, madmdktd);
                return "succ";
            }
        }
        
       return "fail";
    }
    @WebMethod(operationName = "tlu20DktdDisplayAll")
    public List<Tlu20dieuKienTuyenDung> tlu20DktdDisplayAll() {
        return  init().Tlu20dieuKienTuyenDungDisplayAll();
    }
    
    @WebMethod(operationName = "tlu20DktdFindCommon")
    public List<Tlu20dieuKienTuyenDung> tlu20DktdFindCommon(
            @WebParam(name = "tendmdktd") String tendmdktd,
            @WebParam(name = "madmdktd") String madmdktd) {
        return init().Tlu20dieuKienTuyenDungFindCommon(tendmdktd, tendmdktd);
    }
    
    @WebMethod(operationName = "Tlu20dieuKienTuyenDungDeletebyId")
    public String tlu20DktdDelete(
        @WebParam(name = "id") int id) {
        Tlu20dieuKienTuyenDung tlu20DieuKienTuyenDung = init().Tlu20dieuKienTuyenDungFindbyId(id);
        if(ValidateUtil.isNotNull(tlu20DieuKienTuyenDung)) {
            init().Tlu20dieuKienTuyenDungDeletebyId(id);
            return "succ";
        }
        return "fail";
    }
}
