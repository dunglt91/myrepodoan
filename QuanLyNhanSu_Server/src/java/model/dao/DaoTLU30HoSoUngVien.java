/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.pojos.Tlu30hoSoUngVien;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dunglt
 */
public class DaoTLU30HoSoUngVien {

    public List<Tlu30hoSoUngVien> Tlu30hsuvDisplayAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        List<Tlu30hoSoUngVien> hsuvdisplayall = ss.createCriteria(Tlu30hoSoUngVien.class).list();
        if (ss != null) {
            ss.close();
        } else {
            return null;
        }

        return hsuvdisplayall;
    }

    public Tlu30hoSoUngVien Tlu30hsuvFindById(int idhsuv) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Tlu30hoSoUngVien tlu30hsuv = null;
        try {
            tlu30hsuv = (Tlu30hoSoUngVien) ss.get(Tlu30hoSoUngVien.class, idhsuv);
            return tlu30hsuv;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (ss != null) {
                    ss.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public List<Tlu30hoSoUngVien> Tlu30hsuvFindMaHoSo(String mhs) {
        SessionFactory sf = null;
        Session ss = null;
        List<Tlu30hoSoUngVien> hsuvkhs;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            Criteria crit = ss.createCriteria(Tlu30hoSoUngVien.class);
            hsuvkhs = crit.add(Restrictions.like("maHoSo", mhs, MatchMode.ANYWHERE)).list();
            return hsuvkhs;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (ss != null) {
                    ss.close();
                }
            } catch (Exception e) {
            }
        }
        
    }

    public boolean Tlu30hsuvInsert(Tlu30hoSoUngVien tlu30hsuv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            tx = ss.beginTransaction();
            ss.save(tlu30hsuv);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } //finally {
//            try {
//                ss.close();
//            } catch (Exception e) {
//                //safe
//            }
//        }
    }

    public void Tlu30hsuvUpdate(int idHsuv, String createdBy, Date createdAt, boolean isActive,
            String maHoSo, Date ngayNhanHoSo, String keHoachSo, String boPhanDuTuyen, String trinhDoVanHoa, String hoTen,
            String gioiTinh, int cmdn, int dienThoai, String email, String kinhNghiem, String ghiChu, String kemSoYeuLyLich, String kemDonXinViec,
            String kemGiayKhamSucKhoe, String kemCmd, String kemHoKhau, String kemBangCap, String giayToKhac) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30hoSoUngVien tlu30hsuv = this.Tlu30hsuvFindById(idHsuv);
            if (tlu30hsuv != null) {
                tlu30hsuv.setCreatedBy(createdBy);
                tlu30hsuv.setCreatedAt(createdAt);
                tlu30hsuv.setIsActive(isActive);
                tlu30hsuv.setMaHoSo(maHoSo);
                tlu30hsuv.setNgayNhanHoSo(ngayNhanHoSo);
                tlu30hsuv.setKeHoachSo(keHoachSo);
                tlu30hsuv.setBoPhanDuTuyen(boPhanDuTuyen);
                tlu30hsuv.setTrinhDoVanHoa(trinhDoVanHoa);
                tlu30hsuv.setHoTen(hoTen);
                tlu30hsuv.setGioiTinh(gioiTinh);
                tlu30hsuv.setCmdn(cmdn);
                tlu30hsuv.setDienThoai(dienThoai);
                tlu30hsuv.setEmail(email);
                tlu30hsuv.setKinhNghiem(kinhNghiem);
                tlu30hsuv.setGhiChu(ghiChu);
                tlu30hsuv.setKemSoYeuLyLich(kemSoYeuLyLich);
                tlu30hsuv.setKemDonXinViec(kemDonXinViec);
                tlu30hsuv.setKemGiayKhamSucKhoe(kemGiayKhamSucKhoe);
                tlu30hsuv.setKemCmdn(kemCmd);
                tlu30hsuv.setKemHoKhau(kemHoKhau);
                tlu30hsuv.setKemBangCap(kemBangCap);
                tlu30hsuv.setGiayToKhac(giayToKhac);
                ss.update(tlu30hsuv);
                tx.commit();
                ss.close();
            } else {
                if (tx != null) {
                    tx.rollback();
                    if (ss != null) {
                        ss.close();
                    }
                }
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                if (ss != null) {
                    ss.close();
                }
            }
        } finally {
            try {
                ss.close();
            } catch (Exception e) {
                //safe
            }
        }
    }

    public void Tlu30hsuvDelete(int idHsuv) {
        SessionFactory sf = null;
        Session ss = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            tx = ss.beginTransaction();
            Tlu30hoSoUngVien tlu30hsuv = this.Tlu30hsuvFindById(idHsuv);
            if (tlu30hsuv != null) {
                ss.delete(tlu30hsuv);
                tx.commit();
                ss.close();
            } else {
                tx.rollback();
                ss.close();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                if (ss != null) {
                    ss.close();
                }
            }
        } finally {
            try {
                ss.close();
            } catch (Exception e) {
                //safe
            }
        }
    }
    
    public List<Tlu30hoSoUngVien> tlu30HsuvFindCommon(String maHs, String Khs,
            String boPhan) {

        String[] param = {maHs, Khs, boPhan};
        String[] namecolum = {"maHoSo","keHoachSo","boPhanDuTuyen"};
        List<Object> listReult = FinderUtil.find(param, "Tlu30hoSoUngVien", namecolum);
        List<Tlu30hoSoUngVien> listCurOb = new ArrayList<>();
        for (Object obj : listReult) {
            Tlu30hoSoUngVien tlu30chitietketquavpv = (Tlu30hoSoUngVien) obj;
            listCurOb.add(tlu30chitietketquavpv);
        }
        return listCurOb;

    }
    
}
