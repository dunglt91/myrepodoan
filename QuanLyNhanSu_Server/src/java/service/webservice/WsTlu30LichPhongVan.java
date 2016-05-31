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
import model.dao.DaoTLU30LichPhongVan;
import model.pojos.Tlu30lichPhongVan;
import server.util.Convert;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WsTlu30LichPhongVan")
public class WsTlu30LichPhongVan {

    @WebMethod(operationName = "Initobj")
    public DaoTLU30LichPhongVan Initobj() {
        DaoTLU30LichPhongVan daotlu30lpv = new DaoTLU30LichPhongVan();
        return daotlu30lpv;

    }

    @WebMethod(operationName = "Tlu30LpvDisplayAll")
    public List<Tlu30lichPhongVan> Tlu30LpvDisplayAll() {
        return Initobj().Tlu30LpvDisplayAll();
    }

    @WebMethod(operationName = "Tlu30LpvFindById")
    public Tlu30lichPhongVan Tlu30LpvFindById(int id) {
        return Initobj().Tlu30LpvFindById(id);
    }

    @WebMethod(operationName = "Tlu30LpvFindbySoLPV")
    public List<Tlu30lichPhongVan> Tlu30LpvFindbySoLPV(int id) {
        return Initobj().Tlu30LpvFindbySoLPV(id);
    }

    @WebMethod(operationName = "Tlu30LpvFindByUngVien")
    public List<Tlu30lichPhongVan> Tlu30LpvFindByUngVien(String tenungvien) {
        return Initobj().Tlu30LpvFindByUngVien(tenungvien);
    } 

    @WebMethod(operationName = "Tlu30LpvInsert")
    public String Tlu30LpvInsert(@WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt, @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "ungVien") String ungVien, @WebParam(name = "keHoachSo") String keHoachSo,
            @WebParam(name = "soLichPhongVan") int soLichPhongVan, @WebParam(name = "lichHen") String lichHen,
            @WebParam(name = "phuTrachPhongVan") String phuTrachPhongVan, @WebParam(name = "tinhTrangPhongVan") String tinhTrangPhongVan,
            @WebParam(name = "datYeuCau") boolean datYeuCau, @WebParam(name = "nhanXet") String nhanXet) throws ParseException {
        Convert conv = new Convert();
        Date datecreatedAt = (Date) conv.ConvertStringToDateSql(createdAt);
        Date datelichHen = (Date) conv.ConvertStringToDateSql(lichHen);
        if (Initobj().Tlu30LpvFindbySoLPV(soLichPhongVan).isEmpty()) {
            Tlu30lichPhongVan insertlichphongvan = new Tlu30lichPhongVan(createdBy, datecreatedAt, isActive, ungVien, keHoachSo, soLichPhongVan, datelichHen, phuTrachPhongVan, tinhTrangPhongVan, datYeuCau, nhanXet);
            Initobj().Tlu30LpvInsert(insertlichphongvan);
            return "inserted";
        } else {
            return "so lich phong van " + soLichPhongVan + " is existed";
        }

    }

    @WebMethod(operationName = "Tlu30LpvUpdate")
    public String Tlu30LpvUpdate(@WebParam(name = "idLpv") int idLpv, @WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt, @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "ungVien") String ungVien, @WebParam(name = "keHoachSo") String keHoachSo,
            @WebParam(name = "soLichPhongVan") int soLichPhongVan, @WebParam(name = "lichHen") String lichHen,
            @WebParam(name = "phuTrachPhongVan") String phuTrachPhongVan, @WebParam(name = "tinhTrangPhongVan") String tinhTrangPhongVan,
            @WebParam(name = "datYeuCau") boolean datYeuCau, @WebParam(name = "nhanXet") String nhanXet) throws ParseException {
        Convert conv = new Convert();
        Date datecreatedAt = (Date) conv.ConvertStringToDateSql(createdAt);
        Date datelichHen = (Date) conv.ConvertStringToDateSql(lichHen);
        if (Initobj().Tlu30LpvFindById(idLpv) != null) {
            if (Initobj().Tlu30LpvFindbySoLPV(soLichPhongVan).isEmpty() ||
                    (Initobj().Tlu30LpvFindbySoLPV(soLichPhongVan).size() == 1
                    && Initobj().Tlu30LpvFindbySoLPV(soLichPhongVan).get(0).getIdLpv() == idLpv)) {
                return "updated";
            } else {
                return "so lich phong van " + soLichPhongVan + " is existed";
            }
        } else {
            return "can find id + " + idLpv;
        }
    }

    @WebMethod(operationName = "Tlu30LpvDelete")
    public String Tlu30LpvDelete(@WebParam(name = "idLpv") int idLpv) {
        if (Initobj().Tlu30LpvFindById(idLpv) != null) {
            Initobj().Tlu30LpvDelete(idLpv);
            return "Deleted";
        } else {
            return "Can't find the id " + idLpv;
        }
    }
    
    @WebMethod(operationName = "tlu30LpvFindCommon")
    public List<Tlu30lichPhongVan> tlu30LpvFindCommon(
        @WebParam(name = "maHs") String maHs,
            @WebParam(name = "Khs") String Khs,
            @WebParam(name = "tenUngVien") String tenUngVien,
            @WebParam(name = "DatYeuCau") String DatYeuCau) {
        return new DaoTLU30LichPhongVan().tlu30LpvFindCommon(maHs, Khs, tenUngVien, maHs);
    }
    
}
