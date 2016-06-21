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
import model.dao.DAOTLU30CHITIETKQVPV;
import model.pojos.Tlu30chitietketquavpv;
import server.util.Convert;
import server.util.ValidateUtil;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WSTLU30CHITIETKQVPV")
public class WSTLU30CHITIETKQVPV {

    /**
     * This is a sample web service operation
     * @return 
     */
    public DAOTLU30CHITIETKQVPV init() {
        return new DAOTLU30CHITIETKQVPV();
    }
    
     public Convert initConv() {
       return new Convert();
   }
     
   @WebMethod(operationName = "Tlu30chitietketquavpvInsert")
   public String Tlu30chitietketquavpvInsert(
           @WebParam(name = "Machitietdmkqpv") String Machitietdmkqpv,
           @WebParam(name = "Madkpv") String Madkpv,
           @WebParam(name = "Tendkpv") String Tendkpv,
           @WebParam(name = "Diemcandat") float Diemcandat,
           @WebParam(name = "Diemdatduoc") float Diemdatduoc) {
       Tlu30chitietketquavpv tlu30chitietketquavpv = new Tlu30chitietketquavpv(Tendkpv,
               Madkpv, Machitietdmkqpv, Diemcandat, Diemdatduoc);
       List<Tlu30chitietketquavpv> tlu30chitietketquavpvs = init()
                .Tlu30chitietketquavpvFindCommon(Machitietdmkqpv, Madkpv, null, null, null);
       if(tlu30chitietketquavpvs.isEmpty()) {
           init().Tlu30chitietketquavpvInsert(tlu30chitietketquavpv);
           return "succ";
       }
       
       return "fail";
   }
   
   @WebMethod(operationName = "Tlu30chitietketquavpvFindCommon") 
   public List<Tlu30chitietketquavpv> Tlu30chitietketquavpvFindCommon(
           @WebParam(name = "Machitietdmkqpv") String Machitietdmkqpv,
           @WebParam(name = "Madkpv") String Madkpv,
           @WebParam(name = "Tendkpv") String Tendkpv,
           @WebParam(name = "Diemcandat") String Diemcandat,
           @WebParam(name = "Diemdatduoc") String Diemdatduoc ) {
       return init().Tlu30chitietketquavpvFindCommon(Machitietdmkqpv, Madkpv, 
               Tendkpv, Diemcandat, Diemdatduoc);
       
   }
   
   @WebMethod(operationName = "Tlu30chitietketquavpvDisplayAll") 
   public List<Tlu30chitietketquavpv> Tlu30chitietketquavpvDisplayAll() {
       return init().Tlu30chitietketquavpvDisplayAll();
   }
   
   @WebMethod(operationName = "Tlu30chitietketquavpvFindbyId")
   public Tlu30chitietketquavpv Tlu30chitietketquavpvFindbyId(
        @WebParam(name = "idTlu30chitietketquavpv") int idTlu30chitietketquavpv) {
       return init().Tlu30chitietketquavpvFindbyId(idTlu30chitietketquavpv);
   }
   
   @WebMethod(operationName = "Tlu30chitietketquavpvUpdatebyID")
   public String Tlu30chitietketquavpvUpdatebyID(
           @WebParam(name = "idTlu30chitietketquavpv") int idTlu30chitietketquavpv,
           @WebParam(name = "Machitietdmkqpv") String Machitietdmkqpv,
           @WebParam(name = "Madkpv") String Madkpv,
           @WebParam(name = "Tendkpv") String Tendkpv,
           @WebParam(name = "Diemcandat") float Diemcandat,
           @WebParam(name = "Diemdatduoc") float Diemdatduoc) {
       Tlu30chitietketquavpv tlu30chitietketquavpv= this.Tlu30chitietketquavpvFindbyId(idTlu30chitietketquavpv);
       if(ValidateUtil.isNotNull(tlu30chitietketquavpv)) {
            init().Tlu30chitietketquavpvUpdatebyID(idTlu30chitietketquavpv,
             Machitietdmkqpv, Madkpv, Tendkpv, Diemcandat, Diemdatduoc);
            return "succ";          
       }
       return "fail";
   }
   
   @WebMethod(operationName = "Tlu30chitietketquavpvDeletebyId")
   public String Tlu30chitietketquavpvDeletebyId(
        @WebParam(name = "idTlu30chitietketquavpv") int idTlu30chitietketquavpv ) {
      Tlu30chitietketquavpv tlu30chitietketquavpv= this.Tlu30chitietketquavpvFindbyId(idTlu30chitietketquavpv);
       if(ValidateUtil.isNotNull(tlu30chitietketquavpv)) {
           init().Tlu30chitietketquavpvDeletebyId(idTlu30chitietketquavpv);
           return "succ";
       }
       
       return "fail";
   }
   
}
