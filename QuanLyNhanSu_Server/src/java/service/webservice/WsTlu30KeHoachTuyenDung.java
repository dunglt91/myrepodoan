/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.webservice;

import java.sql.Date;
import java.text.ParseException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.*;
import javax.jws.WebParam;
import model.dao.*;
import model.pojos.*;
import server.util.Convert;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WsTLU30KeHoachTuyenDung")
public class WsTlu30KeHoachTuyenDung {

    @WebMethod(operationName = "Tlu30khtdDisplayAll")
    public List<Tlu30keHoachTuyenDung> Tlu30khtdDisplayAll() {
        DaoTLU30KeHoachTuyenDung daokdtd = new DaoTLU30KeHoachTuyenDung();
        return daokdtd.Tlu30khtdDisplayAll();
    }

    @WebMethod(operationName = "Tlu20khtdFindById")
    public Tlu30keHoachTuyenDung Tlu20khtdFindById(@WebParam(name = "id") int id) {
        DaoTLU30KeHoachTuyenDung daokdtd = new DaoTLU30KeHoachTuyenDung();
        return daokdtd.Tlu30khtdFindById(id);
    }

    @WebMethod(operationName = "Tlu30khtdFindByKeHoachSo")
    public List<Tlu30keHoachTuyenDung> Tlu30khtdFindByKeHoachSo(@WebParam(name = "kehoachso") String kehoachso) {
        DaoTLU30KeHoachTuyenDung daokdtd = new DaoTLU30KeHoachTuyenDung();
        return daokdtd.Tlu30khtdFindByKeHoachSo(kehoachso);
    }

    @WebMethod(operationName = "Tlu30khtdInsert")
    public String Tlu30khtdInsert(@WebParam(name = "createdby") String createdby, @WebParam(name = "createdat") String createdat,
            @WebParam(name = "isactive") boolean isactive, @WebParam(name = "kehoachso") String kehoachso,
            @WebParam(name = "ngaykehoach") String ngaykehoach, @WebParam(name = "bophan") String bophan,
            @WebParam(name = "chucvu") String chucvu, @WebParam(name = "trinhdovanhoa") String trinhdovanhoa,
            @WebParam(name = "soluong") int soluong, @WebParam(name = "gioitinh") String gioitinh,
            @WebParam(name = "tuoimin") int tuoimin, @WebParam(name = "tuoimax") int tuoimax,
            @WebParam(name = "noilamviec") String noilamviec, @WebParam(name = "kinhnghiem") String kinhnghiem,
            @WebParam(name = "ghichu") String ghichu) throws ParseException {
        
        DaoTLU30KeHoachTuyenDung daokhtd = new DaoTLU30KeHoachTuyenDung();
        Convert conv = new Convert();
        Date datecreatedat = (Date) conv.ConvertStringToDateSql(createdat);
        Date datengaykehoach = (Date) conv.ConvertStringToDateSql(ngaykehoach);
        
        if (daokhtd.Tlu30khtdFindByKeHoachSo(kehoachso).isEmpty()) {
            Tlu30keHoachTuyenDung instlu30khtd = new Tlu30keHoachTuyenDung(
                    createdby, datecreatedat, isactive, kehoachso,
                    datengaykehoach, bophan, chucvu, trinhdovanhoa, soluong, gioitinh,
                    tuoimin, tuoimax, noilamviec, kinhnghiem, ghichu);
            daokhtd.Tlu30khtdInsert(instlu30khtd);
            return "inserted";
        } else {
            return "ton tai ke hoach so " + kehoachso;
        }

    }
    
    @WebMethod(operationName = "Tlu30khtdUpdateById") 
    public String Tlu30khtdUpdateById(
            @WebParam(name = "idkhtd") int idkhtd,
            @WebParam(name = "createdby") String createdby, @WebParam(name = "createdat") String createdat,
            @WebParam(name = "isactive") boolean isactive, @WebParam(name = "kehoachso") String kehoachso,
            @WebParam(name = "ngaykehoach") String ngaykehoach, @WebParam(name = "bophan") String bophan,
            @WebParam(name = "chucvu") String chucvu, @WebParam(name = "trinhdovanhoa") String trinhdovanhoa,
            @WebParam(name = "soluong") int soluong, @WebParam(name = "gioitinh") String gioitinh,
            @WebParam(name = "tuoimin") int tuoimin, @WebParam(name = "tuoimax") int tuoimax,
            @WebParam(name = "noilamviec") String noilamviec, @WebParam(name = "kinhnghiem") String kinhnghiem,
            @WebParam(name = "ghichu") String ghichu) throws ParseException {
        
        DaoTLU30KeHoachTuyenDung daokhtd = new DaoTLU30KeHoachTuyenDung();
        Convert conv = new Convert();
        Date datecreatedat = (Date) conv.ConvertStringToDateSql(createdat);
        Date datengaykehoach = (Date) conv.ConvertStringToDateSql(ngaykehoach);
        
        if (daokhtd.Tlu30khtdFindByKeHoachSo(kehoachso).isEmpty() || 
                (daokhtd.Tlu30khtdFindByKeHoachSo(kehoachso).size() == 1 
                && daokhtd.Tlu30khtdFindByKeHoachSo(kehoachso).get(0).getIdKhtd() == idkhtd)) {
            daokhtd.Tlu30khtdUpdateById(idkhtd,createdby, datecreatedat, isactive, kehoachso,
                    datengaykehoach, bophan, chucvu, trinhdovanhoa, soluong, gioitinh,
                    tuoimin, tuoimax, noilamviec, kinhnghiem, ghichu);
            return "updated";
        } else {
            return "ton tai ke hoach so " + kehoachso;
        }

    }
    

    @WebMethod(operationName = "Tlu30dktdDeletebyId")
    public String Tlu30khtdDeleteById(@WebParam(name = "iddktd") int iddktd) {
        DaoTLU30KeHoachTuyenDung daokhtd = new DaoTLU30KeHoachTuyenDung();
        daokhtd.Tlu30khtdDeleteById(iddktd);
        return "deleted";
    }
    
    @WebMethod(operationName = "Tlu30keHoachTuyenDungFindCommon")
    public List<Tlu30keHoachTuyenDung> Tlu30keHoachTuyenDungFindCommon(
        @WebParam(name = "keHoachSo") String keHoachSo,
            @WebParam(name = "chucVu") String chucVu,
            @WebParam(name = "boPhan") String boPhan) {
        return new DaoTLU30KeHoachTuyenDung().Tlu30keHoachTuyenDungFindCommon(keHoachSo, chucVu, boPhan);
    }

}
