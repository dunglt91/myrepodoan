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
import model.dao.DAOTLU20TRINHDOVH;
import model.pojos.Tlu20trinhDoVanHoa;
import server.util.Convert;
import server.util.ValidateUtil;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WSTLU20TRINHDOVH")
public class WSTLU20TRINHDOVH {

    /**
     * This is a sample web service operation
     */
    public DAOTLU20TRINHDOVH init() {
       return new DAOTLU20TRINHDOVH();
   }
   
   public Convert initConv() {
       return new Convert();
   }
   
   @WebMethod(operationName = "Tlu20trinhDoVanHoaInsert")
    public String Tlu20trinhDoVanHoaInsert(
            @WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt,
            @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "tenchucvu") String tenTDVH,
            @WebParam(name = "machucvu") String maTDVH) throws ParseException {
         Date convcreatedAt = (Date) initConv().ConvertStringToDateSql(createdAt);
        Tlu20trinhDoVanHoa tlu20trinhDoVanHoa = new Tlu20trinhDoVanHoa(createdBy, 
                convcreatedAt, isActive, tenTDVH, maTDVH);
        if(init().Tlu20trinhDoVanHoaFindCommon(null, maTDVH).isEmpty()) {
            init().Tlu20trinhDoVanHoaInsert(tlu20trinhDoVanHoa);
            return "succ";
        }
       return "fail";
    }
    
    @WebMethod(operationName = "tlu20TrinhDoVanHoaUpdatebyID")
    public String tlu20TrinhDoVanHoaUpdatebyID(
            @WebParam(name = "id") int id,
            @WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt,
            @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "tenchucvu") String tenTDVH,
            @WebParam(name = "machucvu") String maTDVH) throws ParseException {
         Date convcreatedAt = (Date) initConv().ConvertStringToDateSql(createdAt);
            Tlu20trinhDoVanHoa tlu20trinhDoVanHoa  = init().Tlu20trinhDoVanHoaFindbyId(id);
            List<Tlu20trinhDoVanHoa> tlu20trinhDoVanHoas = init().Tlu20trinhDoVanHoaFindCommon(null, maTDVH);
            if(ValidateUtil.isNotNull(tlu20trinhDoVanHoa)) {
                if((tlu20trinhDoVanHoas.size() == 1 && tlu20trinhDoVanHoas.get(0).getIdTdvh() == id)
                        || tlu20trinhDoVanHoas.isEmpty()) {
                    init().Tlu20trinhDoVanHoaUpdatebyID(id, 
                            createdBy, convcreatedAt, 
                            isActive, tenTDVH, maTDVH);
                    return "succ";
                }
        }
        return "fail";
    }
    
    @WebMethod(operationName = "tlu20TrinhDoVanHoaDelete") 
    public String tlu20TrinhDoVanHoaDelete(
    @WebParam(name = "id") int id) {
         Tlu20trinhDoVanHoa tlu20trinhDoVanHoa = init().Tlu20trinhDoVanHoaFindbyId(id);
        if(ValidateUtil.isNotNull(tlu20trinhDoVanHoa)) {
            init().Tlu20trinhDoVanHoaDeletebyId(id);
            return "succ";
        }
        return "fail";
    }
    
    @WebMethod(operationName = "tlu20TrinhDoVanHoaDisplayAll")
    public List<Tlu20trinhDoVanHoa> tlu20TrinhDoVanHoaDisplayAll() {
        return  init().Tlu20trinhDoVanHoaDisplayAll();
    }
    
    @WebMethod(operationName = "tlu20TrinhDoVanHoaFindCommon")
    public List<Tlu20trinhDoVanHoa> tlu20TrinhDoVanHoaFindCommon(
            @WebParam(name = "tenTDVH") String tenTDVH,
            @WebParam(name = "maTDVH") String maTDVH) {
        return init().Tlu20trinhDoVanHoaFindCommon(tenTDVH, maTDVH);
    }
}
