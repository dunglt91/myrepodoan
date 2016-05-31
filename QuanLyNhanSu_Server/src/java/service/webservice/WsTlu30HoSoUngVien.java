/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.webservice;

import java.text.ParseException;
import java.util.*;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.dao.*;
import model.pojos.*;
import server.util.Convert;

/**
 *
 * @author dunglt
 */
@WebService(serviceName = "WsTlu30HoSoUngVien")
public class WsTlu30HoSoUngVien {

    @WebMethod(operationName = "DisplayAll")
    public List<Tlu30hoSoUngVien> Displayall() {
        DaoTLU30HoSoUngVien hsuvdao = new DaoTLU30HoSoUngVien();
        return hsuvdao.Tlu30hsuvDisplayAll();
    }

    @WebMethod(operationName = "FindById")
    public Tlu30hoSoUngVien FindById(@WebParam(name = "id") int id) {
        DaoTLU30HoSoUngVien hsuvdao = new DaoTLU30HoSoUngVien();
        return hsuvdao.Tlu30hsuvFindById(id);
    }

    @WebMethod(operationName = "FindbyMaHoSo")
    public List<Tlu30hoSoUngVien> FindbyMaHoSo(@WebParam(name = "mhs") String mhs) {
        DaoTLU30HoSoUngVien hsuvdao = new DaoTLU30HoSoUngVien();
        return hsuvdao.Tlu30hsuvFindMaHoSo(mhs);
    }

    @WebMethod(operationName = "Tlu30hsuvInsert")
    public String Tlu30hsuvInsert(@WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt, @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "maHoSo") String maHoSo, @WebParam(name = "ngayNhanHoSo") String ngayNhanHoSo,
            @WebParam(name = "keHoachSo") String keHoachSo, @WebParam(name = "boPhanDuTuyen") String boPhanDuTuyen,
            @WebParam(name = "trinhDoVanHoa") String trinhDoVanHoa, @WebParam(name = "hoTen") String hoTen,
            @WebParam(name = "gioiTinh") String gioiTinh, @WebParam(name = "cmdn") int cmdn,
            @WebParam(name = "dienThoai") int dienThoai, @WebParam(name = "email") String email,
            @WebParam(name = "kinhNghiem") String kinhNghiem, @WebParam(name = "ghiChu") String ghiChu,
            @WebParam(name = "kemSoYeuLyLich") String kemSoYeuLyLich, @WebParam(name = "kemDonXinViec") String kemDonXinViec,
            @WebParam(name = "kemGiayKhamSucKhoe") String kemGiayKhamSucKhoe, @WebParam(name = "kemCmd") String kemCmd,
            @WebParam(name = "kemHoKhau") String kemHoKhau, @WebParam(name = "kemBangCap") String kemBangCap,
            @WebParam(name = "giayToKhac") String giayToKhac) throws ParseException {
        DaoTLU30HoSoUngVien hsuvdao = new DaoTLU30HoSoUngVien();
        Convert conv = new Convert();
        Date convcreatedAt = (Date) conv.ConvertStringToDateSql(createdAt);
        Date convngayNhanHoSo = (Date) conv.ConvertStringToDateSql(ngayNhanHoSo);
        String todatetime = conv.ConvertStringToDateTimeSql(convcreatedAt);
        if (hsuvdao.Tlu30hsuvFindMaHoSo(maHoSo).isEmpty()) {
            Tlu30hoSoUngVien inserthsuv = new Tlu30hoSoUngVien(createdBy, convcreatedAt, isActive, maHoSo, convngayNhanHoSo, keHoachSo, boPhanDuTuyen, trinhDoVanHoa, hoTen, gioiTinh, cmdn, dienThoai, email, kinhNghiem, ghiChu, kemSoYeuLyLich, kemDonXinViec, kemGiayKhamSucKhoe, kemCmd, kemHoKhau, kemBangCap, giayToKhac);
            hsuvdao.Tlu30hsuvInsert(inserthsuv);
            return "inserted";
        } else {
            return "Ma ho so is existed";
        }

    }

    @WebMethod(operationName = "Tlu30hsuvUpdate")
    public String Tlu30hsuvUpDate(@WebParam(name = "id") int id, @WebParam(name = "createdBy") String createdBy,
            @WebParam(name = "createdAt") String createdAt, @WebParam(name = "isActive") boolean isActive,
            @WebParam(name = "maHoSo") String maHoSo, @WebParam(name = "ngayNhanHoSo") String ngayNhanHoSo,
            @WebParam(name = "keHoachSo") String keHoachSo, @WebParam(name = "boPhanDuTuyen") String boPhanDuTuyen,
            @WebParam(name = "trinhDoVanHoa") String trinhDoVanHoa, @WebParam(name = "hoTen") String hoTen,
            @WebParam(name = "gioiTinh") String gioiTinh, @WebParam(name = "cmdn") int cmdn,
            @WebParam(name = "dienThoai") int dienThoai, @WebParam(name = "email") String email,
            @WebParam(name = "kinhNghiem") String kinhNghiem, @WebParam(name = "ghiChu") String ghiChu,
            @WebParam(name = "kemSoYeuLyLich") String kemSoYeuLyLich, @WebParam(name = "kemDonXinViec") String kemDonXinViec,
            @WebParam(name = "kemGiayKhamSucKhoe") String kemGiayKhamSucKhoe, @WebParam(name = "kemCmd") String kemCmd,
            @WebParam(name = "kemHoKhau") String kemHoKhau, @WebParam(name = "kemBangCap") String kemBangCap,
            @WebParam(name = "giayToKhac") String giayToKhac) throws ParseException {
        DaoTLU30HoSoUngVien hsuvdao = new DaoTLU30HoSoUngVien();
        Convert conv = new Convert();
        Date convcreatedAt = (Date) conv.ConvertStringToDateSql(createdAt);
        Date convngayNhanHoSo = (Date) conv.ConvertStringToDateSql(ngayNhanHoSo);
        Tlu30hoSoUngVien updadehsuv = hsuvdao.Tlu30hsuvFindById(id);
        if (hsuvdao.Tlu30hsuvFindMaHoSo(maHoSo).isEmpty() 
                || (hsuvdao.Tlu30hsuvFindMaHoSo(maHoSo).size() ==1 
                        && hsuvdao.Tlu30hsuvFindMaHoSo(maHoSo).get(0).getIdHsuv() == id)) {
            if (updadehsuv != null) {
                hsuvdao.Tlu30hsuvUpdate(id, createdBy, convcreatedAt, isActive, 
                        maHoSo, convngayNhanHoSo, keHoachSo, boPhanDuTuyen, 
                        trinhDoVanHoa, hoTen, gioiTinh, cmdn, dienThoai, email,
                        kinhNghiem, ghiChu, kemSoYeuLyLich, kemDonXinViec,
                        kemGiayKhamSucKhoe, kemCmd, kemHoKhau, kemBangCap, giayToKhac);
                return "updateed";
            } else {
                return "Can't find hsuv " + id;
            }
        } else {
            return "Ma ho so "+ maHoSo +" is existed";
        }

    }
    
    @WebMethod(operationName = "Tlu30hsuvDelete")
    public String Tlu30hsuvDelete(@WebParam(name = "id") int id) {
        DaoTLU30HoSoUngVien hsuvdao = new DaoTLU30HoSoUngVien();
        hsuvdao.Tlu30hsuvDelete(id);
        return "deleted";
    }
    
    @WebMethod(operationName = "tlu30HsuvFindCommon")
    public List<Tlu30hoSoUngVien> tlu30hsuvFindCommon(
        @WebParam(name = "maHs") String maHs,
            @WebParam(name = "Khs") String Khs,
            @WebParam(name = "bophan") String boPhan) { 
        return new DaoTLU30HoSoUngVien().tlu30HsuvFindCommon(maHs, Khs, boPhan);
    }

}