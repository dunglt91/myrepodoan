/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dunglt.qlns.client.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import service.webservice.Tlu20Bophan;
import service.webservice.Tlu20ChucVu;
import service.webservice.Tlu20TrinhDoVanHoa;
import service.webservice.Tlu30Chitietdktd;
import service.webservice.Tlu30Chitietketquavpv;
import service.webservice.Tlu30HoSoUngVien;
import service.webservice.Tlu30KeHoachTuyenDung;
import service.webservice.Tlu30LichPhongVan;

/**
 *
 * @author dunglt
 */
public class DictItem {
    public static void setKhs(JComboBox _cbbKHS) {
        for (Tlu30KeHoachTuyenDung khtd : tlu30KhtdDisplayAll()) {
            _cbbKHS.addItem(khtd.getKeHoachSo());
        }
    }
    
    public static void setKhsChiTiet(JComboBox _cbbKHS) {
        for (Tlu30Chitietdktd chitietdktd : tlu30ChitietdktddDisplayAll()) {
                _cbbKHS.addItem(chitietdktd.getKehoachtuyendung());
        }
    }

    public static void setChucVu(JComboBox _cbbKHS) {
        for (Tlu20ChucVu cv : tlu20ChucVuDisplayAll()) {

            _cbbKHS.addItem(cv.getTenChucVu());
        }
    }

    public static void setBoPhan(JComboBox _cbbKHS) {
        for (Tlu20Bophan bp : tlu20BophanDisplayAll()) {

            _cbbKHS.addItem(bp.getTenbophan());
        }
    }

    public static void setTDVH(JComboBox _cbbKHS) {
        for (Tlu20TrinhDoVanHoa vh : tlu20TrinhDoVanHoaDisplayAll()) {

            _cbbKHS.addItem(vh.getTenTdvh());
        }
    }
    
    public static void setMHS(JComboBox _cbbKHS) {
        for (Tlu30HoSoUngVien hs : displayAll()) {

            _cbbKHS.addItem(hs.getMaHoSo());
        }
    }
    
     public static void setTenAndMaHs(JComboBox _cbbKHS) {
        List<String> lstStr = new ArrayList<>();
        for(Tlu30LichPhongVan lpv : tlu30LpvDisplayAll()) {
            lstStr.add(lpv.getUngVien());
        }
        
        for (Tlu30Chitietketquavpv hs : tlu30ChitietketquavpvDisplayAll()) {
             if(!lstStr.contains(hs.getMachitietdmkqpv())) {
                 lstStr.add(hs.getMachitietdmkqpv());
                 _cbbKHS.addItem(hs.getMachitietdmkqpv());
             }    
        }
    }

    private static java.util.List<service.webservice.Tlu30KeHoachTuyenDung> tlu30KhtdDisplayAll() {
        service.webservice.WsTLU30KeHoachTuyenDung service = new service.webservice.WsTLU30KeHoachTuyenDung();
        service.webservice.WsTlu30KeHoachTuyenDung port = service.getWsTlu30KeHoachTuyenDungPort();
        return port.tlu30KhtdDisplayAll();
    }

    private static java.util.List<service.webservice.Tlu30Chitietdktd> tlu30ChitietdktddDisplayAll() {
        service.webservice.WSTLU30CHITIETDKTD_Service service = new service.webservice.WSTLU30CHITIETDKTD_Service();
        service.webservice.WSTLU30CHITIETDKTD port = service.getWSTLU30CHITIETDKTDPort();
        return port.tlu30ChitietdktddDisplayAll();
    }


    private static java.util.List<service.webservice.Tlu20Bophan> tlu20BophanDisplayAll() {
        service.webservice.WSBOPHAN_Service service = new service.webservice.WSBOPHAN_Service();
        service.webservice.WSBOPHAN port = service.getWSBOPHANPort();
        return port.tlu20BophanDisplayAll();
    }

    private static java.util.List<service.webservice.Tlu20TrinhDoVanHoa> tlu20TrinhDoVanHoaDisplayAll() {
        service.webservice.WSTLU20TRINHDOVH_Service service = new service.webservice.WSTLU20TRINHDOVH_Service();
        service.webservice.WSTLU20TRINHDOVH port = service.getWSTLU20TRINHDOVHPort();
        return port.tlu20TrinhDoVanHoaDisplayAll();
    }

    private static java.util.List<service.webservice.Tlu30Chitietketquavpv> tlu30ChitietketquavpvDisplayAll() {
        service.webservice.WSTLU30CHITIETKQVPV_Service service = new service.webservice.WSTLU30CHITIETKQVPV_Service();
        service.webservice.WSTLU30CHITIETKQVPV port = service.getWSTLU30CHITIETKQVPVPort();
        return port.tlu30ChitietketquavpvDisplayAll();
    }

    private static java.util.List<service.webservice.Tlu30HoSoUngVien> displayAll() {
        service.webservice.WsTlu30HoSoUngVien_Service service = new service.webservice.WsTlu30HoSoUngVien_Service();
        service.webservice.WsTlu30HoSoUngVien port = service.getWsTlu30HoSoUngVienPort();
        return port.displayAll();
    }

    private static java.util.List<service.webservice.Tlu20ChucVu> tlu20ChucVuDisplayAll() {
        service.webservice.WSChucVu service = new service.webservice.WSChucVu();
        service.webservice.WSTLU20CHUCVU port = service.getWSTLU20CHUCVUPort();
        return port.tlu20ChucVuDisplayAll();
    }

    private static java.util.List<service.webservice.Tlu30LichPhongVan> tlu30LpvDisplayAll() {
        service.webservice.WsTlu30LichPhongVan_Service service = new service.webservice.WsTlu30LichPhongVan_Service();
        service.webservice.WsTlu30LichPhongVan port = service.getWsTlu30LichPhongVanPort();
        return port.tlu30LpvDisplayAll();
    }
    
    
   
}
