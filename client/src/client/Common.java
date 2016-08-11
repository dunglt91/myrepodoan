/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dunglt.qlns.client.constant.Constant;
import dunglt.qlns.client.util.ClientUtil;
import dunglt.qlns.client.util.DateTimeUtil;
import dunglt.qlns.client.util.ValidateUtil;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import service.webservice.ParseException_Exception;
import service.webservice.Tlu20Bophan;
import service.webservice.Tlu20ChucVu;
import service.webservice.Tlu20DangNhap;
import service.webservice.Tlu20DieuKienTuyenDung;
import service.webservice.Tlu20TrinhDoVanHoa;
import service.webservice.Tlu30HoSoUngVien;
import service.webservice.Tlu30KeHoachTuyenDung;
import service.webservice.Tlu30LichPhongVan;

/**
 *
 * @author dunglt
 */
public class Common extends javax.swing.JFrame {
     /**
     * start declare global variable
     */
    public int idTdvh;
    public int idDktd;
    public int idBoPhan;
    public int idChucVu;
    public static int idKhtd;
    public static boolean isUpdateKhtd = false;
    public static int idHsuv;
    public static boolean isUpdateHsuv = false;
    public static int idLpv;
    public static boolean isUpdateLpv = false;
    
    public static boolean isUpdateUser = false;
    public static String stUserName;
    

    /**
     * end declare global variable
     */
    /**
     * Creates new form Common
     */
    public Common() {
        this.setResizable(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        viewKhtd();
        viewHsuv();
        viewTdvh();
        viewDKTD();
        viewChucVu();
        viewBoPhan();
        viewKqpvAll();
        viewLpv();
    }
    
    public Common(String userName) {
        this.stUserName = userName; 
        this.setResizable(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        viewKhtd();
        viewHsuv();
        viewTdvh();
        viewDKTD();
        viewChucVu();
        viewBoPhan();
        viewKqpvAll();
        viewLpv();
        viewDangNhap();
        if(!checkIsAdmin(stUserName)) {
            jTabbedPane3.removeTabAt(6);
        }
        
        _lbWelcome.setText("XIN CHÀO, BẠN ĐANG ĐĂNG NHẬP VỚI TÊN : " + userName);
    }
    
    private void viewKqpvFail() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblKqpv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblKqpv.getModel();
        for (Tlu30LichPhongVan lpv : tlu30LpvFindCommon(null, null, null, "0")) {
            java.util.List<Tlu30HoSoUngVien> soUngVien = new ArrayList<>();
            soUngVien = findbyMaHoSo(lpv.getUngVien());
            model.addRow(new Object[]{lpv.getUngVien(), lpv.getKeHoachSo(), 
                soUngVien.get(0).getHoTen(), ClientUtil.disPlayIsPass(lpv.isDatYeuCau())});
        }
        model.fireTableDataChanged();
    }
    
    private void viewKqpvPass() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblKqpv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblKqpv.getModel();
        for (Tlu30LichPhongVan lpv : tlu30LpvFindCommon(null, null, null, "1")) {
            java.util.List<Tlu30HoSoUngVien> soUngVien = new ArrayList<>();
            soUngVien = findbyMaHoSo(lpv.getUngVien());
            model.addRow(new Object[]{lpv.getUngVien(), lpv.getKeHoachSo(),
                 soUngVien.get(0).getHoTen(), ClientUtil.disPlayIsPass(lpv.isDatYeuCau())});
        }
        model.fireTableDataChanged();
    }
    
    private void viewKqpvAll() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblKqpv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblKqpv.getModel();
        for (Tlu30LichPhongVan lpv : tlu30LpvFindCommon(null, null, null, null)) {
            java.util.List<Tlu30HoSoUngVien> soUngVien = new ArrayList<>();
            soUngVien = findbyMaHoSo(lpv.getUngVien());
            model.addRow(new Object[]{lpv.getUngVien(), lpv.getKeHoachSo(),soUngVien.get(0).getHoTen(),ClientUtil.disPlayIsPass(lpv.isDatYeuCau())});
        }
        model.fireTableDataChanged();
    }
    
    private boolean checkIsAdmin(String uname) {
        boolean isAdmin = false;
        Tlu20DangNhap dangNhap = tLu20DangNhapFindUser(uname); 
        if(dangNhap.getRole().equals("admin")) {
            isAdmin = true;
        }
        return isAdmin;
    }
    
     private void viewDangNhap() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblDn.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblDn.getModel();
        for (Tlu20DangNhap dangNhap : tlu20DangNhapFindCommon(_tfTenDn.getText())) {
            model.addRow(new Object[]{dangNhap.getUsername()});
        }
        model.fireTableDataChanged();
        
    }
   
    public void viewDKTD() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblViewDktd.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblViewDktd.getModel();
        for (Tlu20DieuKienTuyenDung dktd
                : tlu20DktdFindCommon(
                        _tfTenDktd.getText(), _tfMaDktd.getText())) {
            model.addRow(new Object[]{dktd.getMadmdktd(), dktd.getTendmdktd()});
        }
        model.fireTableDataChanged();

    }

    private void viewTdvh() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblViewTdvh.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblViewTdvh.getModel();
        for (Tlu20TrinhDoVanHoa tlu20TrinhDoVanHoa
                : tlu20TrinhDoVanHoaFindCommon(tdvhTen.getText(), tdvhMa.getText())) {
            model.addRow(new Object[]{tlu20TrinhDoVanHoa.getMaTdvh(), tlu20TrinhDoVanHoa.getTenTdvh()});
        }
        model.fireTableDataChanged();

    }

    private void viewBoPhan() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblViewBoPhan.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblViewBoPhan.getModel();
        for (Tlu20Bophan bophan : tlu20BophanFindCommon(
                _tfTenBoPhan.getText(), _tfMaBoPhan.getText())) {
            model.addRow(new Object[]{bophan.getMabophan(), bophan.getTenbophan()});
        }
        model.fireTableDataChanged();

    }

    private void viewChucVu() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblViewChucVu.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblViewChucVu.getModel();
        for (Tlu20ChucVu cv
                : tlu20ChucVuFindCommon(
                        _tfTenChucVu.getText(), _tfMaChucVu.getText())) {
            model.addRow(new Object[]{cv.getMaChucVu(), cv.getTenChucVu()});
        }
        model.fireTableDataChanged();

    }

    private void viewKHTD() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblxemKHTD.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblxemKHTD.getModel();
        for (Tlu30KeHoachTuyenDung khtd : tlu30KhtdDisplayAll()) {
            model.addRow(new Object[]{khtd.getIdKhtd(), khtd.getKeHoachSo(),khtd.getBoPhan(), khtd.getChucVu() });
        }
        model.fireTableDataChanged();
    }

    private void viewKhtd() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblxemKHTD.getModel()).setNumRows(0);
        java.util.List<Tlu30KeHoachTuyenDung> khtds = new ArrayList<Tlu30KeHoachTuyenDung>();
        
        if(!tlu30KeHoachTuyenDungFindCommon(
                _tfSearch.getText(),null,null).isEmpty() ) {
           khtds = tlu30KeHoachTuyenDungFindCommon(
                _tfSearch.getText(),null,null); 
        } else if(!tlu30KeHoachTuyenDungFindCommon(
                null,_tfSearch.getText(),null).isEmpty()) {
           khtds = tlu30KeHoachTuyenDungFindCommon(
                null,_tfSearch.getText(),null);
        } else if(!tlu30KeHoachTuyenDungFindCommon(
                null,null,_tfSearch.getText()).isEmpty()) {
           khtds =  tlu30KeHoachTuyenDungFindCommon(
                null,null,_tfSearch.getText());
        }
        
        model = (DefaultTableModel) this._tblxemKHTD.getModel();
        for (Tlu30KeHoachTuyenDung khtd : khtds) {
            model.addRow(new Object[]{khtd.getIdKhtd(), khtd.getKeHoachSo(),khtd.getBoPhan(), khtd.getChucVu() });
        }
        model.fireTableDataChanged();
    }

    public void viewHsuv() {
        DefaultTableModel model = new DefaultTableModel();
        java.util.List<Tlu30HoSoUngVien> hoSoUngViens = new ArrayList<Tlu30HoSoUngVien>();
        
        if(!tlu30HsuvFindCommon(_tfSearchHsuv.getText(), null, null).isEmpty()) {
            hoSoUngViens = tlu30HsuvFindCommon(_tfSearchHsuv.getText(), null, null);
        } else if(!tlu30HsuvFindCommon(null, _tfSearchHsuv.getText(), null).isEmpty()) {
            hoSoUngViens = tlu30HsuvFindCommon(null, _tfSearchHsuv.getText(), null);
        } else if(!tlu30HsuvFindCommon(null, null, _tfSearchHsuv.getText()).isEmpty()) {
            hoSoUngViens = tlu30HsuvFindCommon(null, null, _tfSearchHsuv.getText());
        }
        
        ((DefaultTableModel) _tblxemHsuv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblxemHsuv.getModel();
        for (Tlu30HoSoUngVien hsuv : hoSoUngViens) {
            model.addRow(new Object[]{hsuv.getIdHsuv(), hsuv.getKeHoachSo(), hsuv.getMaHoSo(), hsuv.getBoPhanDuTuyen()});
        }
        model.fireTableDataChanged();
    }
    
    public void viewLpv() {
        DefaultTableModel model = new DefaultTableModel();
        java.util.List<Tlu30LichPhongVan> lichPhongVans = new ArrayList<Tlu30LichPhongVan>();
        if(!tlu30LpvFindCommon(_tfSearchLpv.getText(),
                null, null, null).isEmpty()) {
            lichPhongVans = tlu30LpvFindCommon(_tfSearchLpv.getText(),
                null, null, null);
        } else if(!tlu30LpvFindCommon(null,
                _tfSearchLpv.getText(), null, null).isEmpty()) {
            lichPhongVans = tlu30LpvFindCommon(null,
                _tfSearchLpv.getText(), null, null);
        } else if(!tlu30LpvFindCommon(null,
                null, _tfSearchLpv.getText(), null).isEmpty()) {
            lichPhongVans = tlu30LpvFindCommon(null,
                null, _tfSearchLpv.getText(), null);
        }
        
        
        ((DefaultTableModel) _tblLpv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblLpv.getModel();
        for (Tlu30LichPhongVan lpv : lichPhongVans) {
            model.addRow(new Object[]{lpv.getIdLpv() ,lpv.getSoLichPhongVan(),
                lpv.getKeHoachSo(), lpv.getUngVien()});
        }
        model.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/welcome.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        _lbWelcome = new javax.swing.JLabel();
        danhMucLon = new javax.swing.JPanel();
        danhMucChon = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel32 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        danhMuc = new javax.swing.JPanel();
        tdvh = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tdvhTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tdvhMa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dateTdvh = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tdvhNguoiThem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tdvhLaNv = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        _tblViewTdvh = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        khtd = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        _tfTenDktd = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        _tfMaDktd = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        _calDktd = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        _tfCreatedbyDktd = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        _cbbDktd = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        _tblViewDktd = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        boPhan = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        _tfTenBoPhan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        _tfMaBoPhan = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        _calBoPhan = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        _tfCreatedbyBoPhan = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        _cbbBpIsActive = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        _tblViewBoPhan = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        chucVu = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        _tfMaChucVu = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        _calChucVu = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        _tfCreatedbyChucVu = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        _cbbIsActiveCv = new javax.swing.JComboBox();
        _tfTenChucVu = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        _tblViewChucVu = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        _tblxemHsuv = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        _tfSearchHsuv = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jButton28 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/myrepodoan/client/search.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        _tblLpv = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        _tfSearchLpv = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/myrepodoan/client/search.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel6 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        _tblDn = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        _tfTenDn = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/myrepodoan/client/search.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel6 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        _pfPass = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        _pfNewPass = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        _pfReNewPass = new javax.swing.JPasswordField();
        jButton31 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        _tblxemKHTD = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        _tfSearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/myrepodoan/client/search.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel15 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        _tblKqpv = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/myrepodoan/client/search.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        _cbbSearchKqpv = new javax.swing.JComboBox();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane3.setBackground(java.awt.Color.white);

        jPanel4.setBackground(java.awt.Color.white);

        _lbWelcome.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        _lbWelcome.setForeground(java.awt.Color.white);
        _lbWelcome.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(_lbWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addGap(270, 270, 270))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(_lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(487, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Trang Chủ", jPanel3);

        danhMucChon.setBackground(new java.awt.Color(224, 230, 237));
        danhMucChon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCalendar1.setBackground(java.awt.Color.white);
        jCalendar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jCalendar1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        jPanel32.setBackground(new java.awt.Color(224, 230, 237));
        jPanel32.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Chọn Danh Mục"), null));
        jPanel32.setForeground(new java.awt.Color(224, 230, 237));

        jButton1.setBackground(java.awt.Color.white);
        jButton1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton1.setText("Trình độ văn hóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(java.awt.Color.white);
        jButton3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton3.setText("Điều kiện tuyển dụng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(java.awt.Color.white);
        jButton4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton4.setText("Danh mục chức vụ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(java.awt.Color.white);
        jButton5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton5.setText("Danh mục bộ phận");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(12, 12, 12)
                .addComponent(jButton4)
                .addGap(12, 12, 12)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout danhMucChonLayout = new javax.swing.GroupLayout(danhMucChon);
        danhMucChon.setLayout(danhMucChonLayout);
        danhMucChonLayout.setHorizontalGroup(
            danhMucChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhMucChonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(danhMucChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addContainerGap())
        );
        danhMucChonLayout.setVerticalGroup(
            danhMucChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhMucChonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        danhMuc.setBackground(java.awt.Color.white);
        danhMuc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        danhMuc.setLayout(new java.awt.CardLayout());

        tdvh.setBackground(new java.awt.Color(224, 230, 237));
        tdvh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(224, 230, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tdvhTen.setBackground(java.awt.Color.white);
        tdvhTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdvhTenActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Tên");

        tdvhMa.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setText("Mã");

        dateTdvh.setBackground(java.awt.Color.white);
        dateTdvh.setDateFormatString("dd-MM-yyyy");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setText("Ngày thêm");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel8.setText("Người thêm");

        tdvhNguoiThem.setBackground(java.awt.Color.white);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setText("Đang là nhân viên công ty");

        tdvhLaNv.setBackground(java.awt.Color.white);
        tdvhLaNv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Có", "Không" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tdvhLaNv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(130, 130, 130)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTdvh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tdvhMa))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdvhTen)
                            .addComponent(tdvhNguoiThem))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel7});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tdvhTen)
                        .addComponent(jLabel2)
                        .addComponent(tdvhMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateTdvh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdvhNguoiThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tdvhLaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel7});

        _tblViewTdvh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        _tblViewTdvh.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblViewTdvh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã trình độ văn hóa", "Tên trình độ văn hóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblViewTdvh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblViewTdvhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(_tblViewTdvh);
        jScrollPane2.getViewport().setBackground(Color.WHITE);

        jPanel16.setBackground(new java.awt.Color(224, 230, 237));
        jPanel16.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));

        jButton6.setBackground(new java.awt.Color(73, 101, 195));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setForeground(java.awt.Color.white);
        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(73, 101, 195));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton7.setForeground(java.awt.Color.white);
        jButton7.setText("Cập nhật");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(73, 101, 195));
        jButton8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton8.setForeground(java.awt.Color.white);
        jButton8.setText("Xóa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(73, 101, 195));
        jButton9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton9.setForeground(java.awt.Color.white);
        jButton9.setText("Tìm kiếm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton6, jButton7, jButton8, jButton9});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton6, jButton7, jButton8, jButton9});

        javax.swing.GroupLayout tdvhLayout = new javax.swing.GroupLayout(tdvh);
        tdvh.setLayout(tdvhLayout);
        tdvhLayout.setHorizontalGroup(
            tdvhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tdvhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tdvhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tdvhLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tdvhLayout.setVerticalGroup(
            tdvhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tdvhLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tdvhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        danhMuc.add(tdvh, "card2");

        khtd.setBackground(new java.awt.Color(224, 230, 237));
        khtd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel9.setBackground(new java.awt.Color(224, 230, 237));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tfTenDktd.setBackground(java.awt.Color.white);
        _tfTenDktd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tfTenDktdActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel21.setText("Tên");

        _tfMaDktd.setBackground(java.awt.Color.white);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel22.setText("Mã");

        _calDktd.setBackground(java.awt.Color.white);
        _calDktd.setDateFormatString("dd-MM-yyyy");

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel23.setText("Ngày thêm");

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel24.setText("Người thêm");

        _tfCreatedbyDktd.setBackground(java.awt.Color.white);

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel25.setText("Đang là nhân viên công ty");

        _cbbDktd.setBackground(java.awt.Color.white);
        _cbbDktd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Có", "Không" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(_tfMaDktd)
                            .addComponent(_calDktd, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(_tfTenDktd, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(_tfCreatedbyDktd)))
                    .addComponent(_cbbDktd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(_tfTenDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(_tfMaDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(_calDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(_tfCreatedbyDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(_cbbDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        _tblViewDktd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        _tblViewDktd.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblViewDktd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã điều kiện tuyển dụng", "Tên điều kiện tuyển dụng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblViewDktd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblViewDktdMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(_tblViewDktd);
        jScrollPane3.getViewport().setBackground(Color.WHITE);

        jPanel33.setBackground(new java.awt.Color(224, 230, 237));
        jPanel33.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));

        jButton32.setBackground(new java.awt.Color(73, 101, 195));
        jButton32.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton32.setForeground(java.awt.Color.white);
        jButton32.setText("Thêm");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(73, 101, 195));
        jButton33.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton33.setForeground(java.awt.Color.white);
        jButton33.setText("Cập nhật");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(73, 101, 195));
        jButton34.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton34.setForeground(java.awt.Color.white);
        jButton34.setText("Xóa");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(73, 101, 195));
        jButton35.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton35.setForeground(java.awt.Color.white);
        jButton35.setText("Tìm kiếm");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton35)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout khtdLayout = new javax.swing.GroupLayout(khtd);
        khtd.setLayout(khtdLayout);
        khtdLayout.setHorizontalGroup(
            khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khtdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(khtdLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        khtdLayout.setVerticalGroup(
            khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khtdLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        danhMuc.add(khtd, "card2");

        boPhan.setBackground(new java.awt.Color(224, 230, 237));
        boPhan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel10.setBackground(new java.awt.Color(224, 230, 237));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tfTenBoPhan.setBackground(java.awt.Color.white);
        _tfTenBoPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tfTenBoPhanActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel26.setText("Tên");

        _tfMaBoPhan.setBackground(java.awt.Color.white);

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel27.setText("Mã");

        _calBoPhan.setBackground(java.awt.Color.white);
        _calBoPhan.setDateFormatString("dd-MM-yyyy");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel28.setText("Ngày thêm");

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel29.setText("Người thêm");

        _tfCreatedbyBoPhan.setBackground(java.awt.Color.white);

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel30.setText("Đang là nhân viên công ty");

        _cbbBpIsActive.setBackground(java.awt.Color.white);
        _cbbBpIsActive.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Có", "Không" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(_calBoPhan, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(_tfMaBoPhan))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfCreatedbyBoPhan, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(_tfTenBoPhan)))
                    .addComponent(_cbbBpIsActive, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_tfMaBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_calBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(_tfTenBoPhan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(_tfCreatedbyBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(_cbbBpIsActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        _tblViewBoPhan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        _tblViewBoPhan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblViewBoPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã bộ phận", "Tên bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblViewBoPhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblViewBoPhanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(_tblViewBoPhan);
        jScrollPane4.getViewport().setBackground(Color.WHITE);

        jPanel34.setBackground(new java.awt.Color(224, 230, 237));
        jPanel34.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));

        jButton36.setBackground(new java.awt.Color(73, 101, 195));
        jButton36.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton36.setForeground(java.awt.Color.white);
        jButton36.setText("Thêm");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(73, 101, 195));
        jButton37.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton37.setForeground(java.awt.Color.white);
        jButton37.setText("Cập nhật");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setBackground(new java.awt.Color(73, 101, 195));
        jButton38.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton38.setForeground(java.awt.Color.white);
        jButton38.setText("Xóa");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(73, 101, 195));
        jButton39.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton39.setForeground(java.awt.Color.white);
        jButton39.setText("Tìm kiếm");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton39)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout boPhanLayout = new javax.swing.GroupLayout(boPhan);
        boPhan.setLayout(boPhanLayout);
        boPhanLayout.setHorizontalGroup(
            boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boPhanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(boPhanLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        boPhanLayout.setVerticalGroup(
            boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boPhanLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        danhMuc.add(boPhan, "card2");

        chucVu.setBackground(new java.awt.Color(224, 230, 237));
        chucVu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel11.setBackground(new java.awt.Color(224, 230, 237));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel31.setText("Tên");

        _tfMaChucVu.setBackground(java.awt.Color.white);

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel32.setText("Mã");

        _calChucVu.setBackground(java.awt.Color.white);
        _calChucVu.setDateFormatString("dd-MM-yyyy");

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel33.setText("Ngày thêm");

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel34.setText("Người thêm");

        _tfCreatedbyChucVu.setBackground(java.awt.Color.white);

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel35.setText("Đang là nhân viên công ty");

        _cbbIsActiveCv.setBackground(java.awt.Color.white);
        _cbbIsActiveCv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Có", "Không" }));

        _tfTenChucVu.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfMaChucVu)
                            .addComponent(_calChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfCreatedbyChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(_tfTenChucVu)))
                    .addComponent(_cbbIsActiveCv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_tfMaChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_calChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(_tfTenChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfCreatedbyChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_cbbIsActiveCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        _tblViewChucVu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        _tblViewChucVu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblViewChucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chức vụ", "Tên chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblViewChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblViewChucVuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(_tblViewChucVu);
        jScrollPane5.getViewport().setBackground(Color.WHITE);

        jPanel35.setBackground(new java.awt.Color(224, 230, 237));
        jPanel35.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));

        jButton44.setBackground(new java.awt.Color(73, 101, 195));
        jButton44.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton44.setForeground(java.awt.Color.white);
        jButton44.setText("Thêm");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setBackground(new java.awt.Color(73, 101, 195));
        jButton45.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton45.setForeground(java.awt.Color.white);
        jButton45.setText("Cập nhật");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setBackground(new java.awt.Color(73, 101, 195));
        jButton46.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton46.setForeground(java.awt.Color.white);
        jButton46.setText("Xóa");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(73, 101, 195));
        jButton47.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton47.setForeground(java.awt.Color.white);
        jButton47.setText("Tìm kiếm");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton45, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jButton44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton47)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout chucVuLayout = new javax.swing.GroupLayout(chucVu);
        chucVu.setLayout(chucVuLayout);
        chucVuLayout.setHorizontalGroup(
            chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chucVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(chucVuLayout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        chucVuLayout.setVerticalGroup(
            chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chucVuLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        danhMuc.add(chucVu, "card2");

        javax.swing.GroupLayout danhMucLonLayout = new javax.swing.GroupLayout(danhMucLon);
        danhMucLon.setLayout(danhMucLonLayout);
        danhMucLonLayout.setHorizontalGroup(
            danhMucLonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhMucLonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(danhMucChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(danhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        danhMucLonLayout.setVerticalGroup(
            danhMucLonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(danhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(danhMucLonLayout.createSequentialGroup()
                .addComponent(danhMucChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("danh muc", danhMucLon);

        jPanel12.setBackground(new java.awt.Color(224, 230, 237));

        jPanel23.setBackground(new java.awt.Color(224, 230, 237));
        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tblxemHsuv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        _tblxemHsuv.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblxemHsuv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Kế hoạch số", "Mã hồ sơ", "Bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblxemHsuv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblxemHsuvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _tblxemHsuvMouseEntered(evt);
            }
        });
        jScrollPane6.setViewportView(_tblxemHsuv);
        jScrollPane6.getViewport().setBackground(Color.WHITE);

        jPanel25.setBackground(new java.awt.Color(224, 230, 237));
        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tfSearchHsuv.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        _tfSearchHsuv.setToolTipText("Ô tìm kiếm kế hoạch tuyển dụng");

        jPanel26.setBackground(new java.awt.Color(224, 230, 237));
        jPanel26.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));
        jPanel26.setPreferredSize(new java.awt.Dimension(418, 117));

        jButton28.setBackground(new java.awt.Color(52, 79, 223));
        jButton28.setForeground(java.awt.Color.white);
        jButton28.setText("Xóa");
        jButton28.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(52, 79, 223));
        jButton27.setForeground(java.awt.Color.white);
        jButton27.setText("Sửa");
        jButton27.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(52, 79, 223));
        jButton26.setForeground(java.awt.Color.white);
        jButton26.setText("Thêm");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel26Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton27, jButton28});

        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27MouseClicked(evt);
            }
        });
        jPanel22.setToolTipText("Tìm kiếm kế hoạch tuyển dụng");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_tfSearchHsuv)
                .addGap(0, 0, 0)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_tfSearchHsuv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1231, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("ho so ung vien", jPanel12);

        jPanel14.setBackground(new java.awt.Color(224, 230, 237));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel13.setBackground(new java.awt.Color(224, 230, 237));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tblLpv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        _tblLpv.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblLpv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Số lịch phỏng vấn", "Kế hoạch số", "Ứng viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblLpv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblLpvMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(_tblLpv);
        jScrollPane7.getViewport().setBackground(Color.WHITE);

        jPanel24.setBackground(new java.awt.Color(224, 230, 237));
        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tfSearchLpv.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        _tfSearchLpv.setToolTipText("Ô tìm kiếm kế hoạch tuyển dụng");

        jPanel7.setBackground(new java.awt.Color(224, 230, 237));
        jPanel7.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));
        jPanel7.setPreferredSize(new java.awt.Dimension(418, 117));

        jButton24.setBackground(new java.awt.Color(73, 101, 195));
        jButton24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton24.setForeground(java.awt.Color.white);
        jButton24.setText("Thêm");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(73, 101, 195));
        jButton29.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton29.setForeground(java.awt.Color.white);
        jButton29.setText("Sửa");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(73, 101, 195));
        jButton30.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton30.setForeground(java.awt.Color.white);
        jButton30.setText("Xóa");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel28MouseClicked(evt);
            }
        });
        jPanel22.setToolTipText("Tìm kiếm kế hoạch tuyển dụng");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_tfSearchLpv, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_tfSearchLpv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Lịch phong van", jPanel14);

        jPanel6.setBackground(new java.awt.Color(224, 230, 237));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPanel36.setBackground(new java.awt.Color(224, 230, 237));
        jPanel36.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tblDn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        _tblDn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblDn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên đăng nhập"
            }
        ));
        _tblDn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblDnMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(_tblDn);
        jScrollPane9.getViewport().setBackground(Color.WHITE);

        jPanel37.setBackground(new java.awt.Color(224, 230, 237));
        jPanel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tfTenDn.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        _tfTenDn.setToolTipText("Ô tìm kiếm kế hoạch tuyển dụng");

        jPanel38.setBackground(new java.awt.Color(224, 230, 237));
        jPanel38.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));
        jPanel38.setPreferredSize(new java.awt.Dimension(418, 117));

        jButton48.setBackground(new java.awt.Color(73, 101, 195));
        jButton48.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton48.setForeground(java.awt.Color.white);
        jButton48.setText("Thêm");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton49.setBackground(new java.awt.Color(73, 101, 195));
        jButton49.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton49.setForeground(java.awt.Color.white);
        jButton49.setText("Sửa");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton50.setBackground(new java.awt.Color(73, 101, 195));
        jButton50.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton50.setForeground(java.awt.Color.white);
        jButton50.setText("Xóa");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton48, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton50)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel39MouseClicked(evt);
            }
        });
        jPanel22.setToolTipText("Tìm kiếm kế hoạch tuyển dụng");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("Tên đăng nhập");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(_tfTenDn)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_tfTenDn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Quan ly tai khoan", jPanel6);

        jPanel19.setBackground(new java.awt.Color(224, 230, 237));
        jPanel19.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));
        jPanel19.setForeground(java.awt.Color.red);

        jLabel10.setBackground(java.awt.Color.white);
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel10.setForeground(java.awt.Color.black);
        jLabel10.setText("Mật khẩu cũ");

        jLabel11.setBackground(java.awt.Color.white);
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel11.setForeground(java.awt.Color.black);
        jLabel11.setText("Mật khẩu mới");

        jLabel12.setBackground(java.awt.Color.white);
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel12.setForeground(java.awt.Color.black);
        jLabel12.setText("Gõ lại mật khẩu mới");

        jButton31.setBackground(new java.awt.Color(73, 101, 195));
        jButton31.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton31.setForeground(java.awt.Color.white);
        jButton31.setText("Đổi mật khẩu");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_pfPass)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 994, Short.MAX_VALUE))
                    .addComponent(_pfNewPass)
                    .addComponent(_pfReNewPass, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_pfNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_pfReNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton31)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("doi mat khau", jPanel17);

        jPanel5.setBackground(new java.awt.Color(224, 230, 237));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel21.setBackground(new java.awt.Color(224, 230, 237));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tblxemKHTD.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));
        _tblxemKHTD.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblxemKHTD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Kế hoạch số", "Bộ phận", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblxemKHTD.setName(""); // NOI18N
        _tblxemKHTD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblxemKHTDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(_tblxemKHTD);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        jPanel20.setBackground(new java.awt.Color(224, 230, 237));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tfSearch.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        _tfSearch.setToolTipText("Ô tìm kiếm kế hoạch tuyển dụng");

        jPanel1.setBackground(new java.awt.Color(224, 230, 237));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));
        jPanel1.setPreferredSize(new java.awt.Dimension(418, 117));

        jButton22.setBackground(new java.awt.Color(73, 101, 195));
        jButton22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton22.setForeground(java.awt.Color.white);
        jButton22.setText("Thêm");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(73, 101, 195));
        jButton23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton23.setForeground(java.awt.Color.white);
        jButton23.setText("Sửa");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(73, 101, 195));
        jButton25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton25.setForeground(java.awt.Color.white);
        jButton25.setText("Xóa");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton22, jButton23});

        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22MouseClicked(evt);
            }
        });
        jPanel22.setToolTipText("Tìm kiếm kế hoạch tuyển dụng");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_tfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("ke hoach tuyen dung", jPanel5);

        jPanel29.setBackground(new java.awt.Color(224, 230, 237));
        jPanel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        _tblKqpv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        _tblKqpv.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        _tblKqpv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hồ sơ", "Kế hoạch số", "Tên ứng viên", "Kết quả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblKqpv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblKqpvMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(_tblKqpv);
        jScrollPane8.getViewport().setBackground(Color.WHITE);

        jPanel30.setBackground(new java.awt.Color(224, 230, 237));
        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel31MouseClicked(evt);
            }
        });
        jPanel22.setToolTipText("Tìm kiếm kế hoạch tuyển dụng");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        _cbbSearchKqpv.setBackground(java.awt.Color.white);
        _cbbSearchKqpv.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        _cbbSearchKqpv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Đạt", "Không đạt" }));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(_cbbSearchKqpv, 0, 934, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_cbbSearchKqpv, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Ket qua phong van", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 741, Short.MAX_VALUE)
        );

        ImageIcon imageIconHome = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/homeicon_48.png");
        ImageIcon imageIconplan = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/digg_48.png");
        ImageIcon imageIconFile = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/user_48.png");
        ImageIcon imageIconClock = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/clock_48.png");
        ImageIcon imageIconResult = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/database_48.png");
        ImageIcon imageIconList = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/navigate_48.png");
        ImageIcon imageIconAcc = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/user-male-edit-icon.png");
        ImageIcon imageIconChangePas = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/lock_48.png");

        jTabbedPane3.addTab("",imageIconHome, jPanel3);
        jTabbedPane3.addTab("",imageIconList, danhMucLon);
        jTabbedPane3.addTab("", imageIconplan ,jPanel5);
        jTabbedPane3.addTab("",imageIconFile, jPanel12);
        jTabbedPane3.addTab("",imageIconClock, jPanel14);
        jTabbedPane3.addTab("",imageIconResult, jPanel15);
        jTabbedPane3.addTab("",imageIconAcc, jPanel6);
        jTabbedPane3.addTab("",imageIconChangePas, jPanel17);

        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                if(index == 1) {
                    setTitle("Danh Mục");
                } else if(index == 2) {
                    setTitle("Kế hoạch tuyển dụng");
                } else if(index == 3) {
                    setTitle("Hồ sơ ứng viên");
                } else if(index == 4) {
                    setTitle("Lịch phỏng vấn");
                } else if(index == 5) {
                    setTitle("Kết quả phỏng vấn");
                } else if(index == 6) {
                    setTitle("Quản lý tài khoản");
                }else if(index == 7) {
                    setTitle("Đổi mật khẩu");
                } else {
                    setTitle("Trang chủ");
                }
            }
        };

        jTabbedPane3.addChangeListener(changeListener);
        jTabbedPane3.setToolTipTextAt(0, "Trang chủ");
        jTabbedPane3.setToolTipTextAt(1, "Quản lý danh mục");
        jTabbedPane3.setToolTipTextAt(2, "Kế hoạch tuyển dụng");
        jTabbedPane3.setToolTipTextAt(3, "Hồ sơ ứng viên");
        jTabbedPane3.setToolTipTextAt(4, "Lịch phỏng vấn");
        jTabbedPane3.setToolTipTextAt(5, "Kết quả phỏng vấn");
        jTabbedPane3.setToolTipTextAt(6, "Quản lý tài khoản");
        jTabbedPane3.setToolTipTextAt(7, "Quản lý tài Đổi mật khẩu");

        setBounds(0, 0, 1313, 771);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseClicked
        viewKhtd();
    }//GEN-LAST:event_jPanel22MouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        if (idKhtd > 0) {
            System.out.println("****idKhtd*** " + idKhtd );
            tlu30KhtdDeletebyId(idKhtd);
            JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            viewKHTD();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Kế hoạch tuyển dụng trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if (idKhtd == 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Kế hoạch tuyển dụng trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            isUpdateKhtd = true;
            new updateKHTD(idKhtd, isUpdateKhtd).setVisible(true);
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        new updateKHTD().setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void _tblxemKHTDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblxemKHTDMouseClicked
        int row = _tblxemKHTD.getSelectedRow();
        int id = (int) _tblxemKHTD.getModel().getValueAt(row, 0);
        String khs = (_tblxemKHTD.getModel().getValueAt(row, 1).toString());
        String bophan = (_tblxemKHTD.getModel().getValueAt(row, 3).toString());
        String chucvu = (_tblxemKHTD.getModel().getValueAt(row, 2).toString());
        idKhtd = id;
    }//GEN-LAST:event__tblxemKHTDMouseClicked

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        if(ValidateUtil.isNotNull(_pfPass.getText())) {
            Tlu20DangNhap dangNhap = tLu20DangNhapFindUser(stUserName);
            if(ValidateUtil.isNotNull(_pfNewPass.getText())) {
                if(_pfPass.getText().equals(dangNhap.getPasswords())) {
                    if(!_pfNewPass.getText().equals(_pfPass.getText())) {
                        if(_pfNewPass.getText().equals(_pfReNewPass.getText())) {
                            String mess = Constant.BLANK;
                            mess = tlu20DangNhapUpdate(stUserName, _pfNewPass.getText(), _pfReNewPass.getText(), dangNhap.getRole());
                            if(mess.equals(Constant.SUCCESS)) {
                                JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công");
                                dispose();
                                new DangNhap().setVisible(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Mật khẩu mới và gõ lại mật khẩu mới phải giống nhau", "cảnh báo", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Mật khẩu mới và mật khẩu cũ không được trùng nhau  ", "cảnh báo", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Mật khẩu cũ không đúng", "cảnh báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButton31ActionPerformed

    private void _tblDnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblDnMouseClicked
        int row = _tblDn.getSelectedRow();
        _tfTenDn.setText(_tblDn.getModel().getValueAt(row, 0).toString());
    }//GEN-LAST:event__tblDnMouseClicked

    private void _tblLpvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblLpvMouseClicked
        int row = _tblLpv.getSelectedRow();
        int id = (int) _tblLpv.getModel().getValueAt(row, 0);
        String ungVien = (_tblLpv.getModel().getValueAt(row, 3).toString());
        String lpvSo = (_tblLpv.getModel().getValueAt(row, 1).toString());
        String khs = (_tblLpv.getModel().getValueAt(row, 2).toString());
        idLpv = id;
    }//GEN-LAST:event__tblLpvMouseClicked

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        if (idHsuv > 0) {
            tlu30HsuvDelete(idHsuv);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Hồ sơ ứng viên trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        isUpdateHsuv = true;
        if (idHsuv == 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Hồ sơ ứng viên trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            new updateHSUV(isUpdateHsuv, idHsuv).setVisible(true);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        new updateHSUV().setVisible(true);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void _tblxemHsuvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblxemHsuvMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event__tblxemHsuvMouseEntered

    private void _tblxemHsuvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblxemHsuvMouseClicked
        int row = _tblxemHsuv.getSelectedRow();
        int id = (int) _tblxemHsuv.getModel().getValueAt(row, 0);
        String mhs = (_tblxemHsuv.getModel().getValueAt(row, 2).toString());
        String khs = (_tblxemHsuv.getModel().getValueAt(row, 1).toString());
        String bophan = (_tblxemHsuv.getModel().getValueAt(row, 3).toString());
        idHsuv = id;
    }//GEN-LAST:event__tblxemHsuvMouseClicked

    private void _tblViewChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblViewChucVuMouseClicked
        int row = _tblViewChucVu.getSelectedRow();
        String maChucVu = (_tblViewChucVu.getModel().getValueAt(row, 0).toString());
        String tenChucVu = (_tblViewChucVu.getModel().getValueAt(row, 1).toString());
        java.util.List<Tlu20ChucVu> lstChucVu = tlu20ChucVuFindCommon(tenChucVu, maChucVu);
        if (!lstChucVu.isEmpty()) {
            _tfCreatedbyChucVu.setText(lstChucVu.get(0).getCreatedBy());
            _tfTenChucVu.setText(lstChucVu.get(0).getTenChucVu());
            _tfMaChucVu.setText(lstChucVu.get(0).getMaChucVu());
            Calendar calendar = lstChucVu.get(0).getCreatedAt().toGregorianCalendar();
            _calChucVu.setCalendar(calendar);
            idChucVu = lstChucVu.get(0).getIdCv();
            ClientUtil.getValueIsActiveFromWS(_cbbIsActiveCv,
                ClientUtil.getStringFromIsActive(lstChucVu.get(0).isIsActive()));
        }
    }//GEN-LAST:event__tblViewChucVuMouseClicked

    private void _tblViewBoPhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblViewBoPhanMouseClicked
        int row = _tblViewBoPhan.getSelectedRow();
        String maBoPhan = (_tblViewBoPhan.getModel().getValueAt(row, 0).toString());
        String tenBoPhan = (_tblViewBoPhan.getModel().getValueAt(row, 1).toString());
        System.out.println("");
        java.util.List<Tlu20Bophan> lstBoPhan = tlu20BophanFindCommon(tenBoPhan, maBoPhan);

        if(!lstBoPhan.isEmpty()) {
            _tfCreatedbyBoPhan.setText(lstBoPhan.get(0).getCreatedBy());
        _tfTenBoPhan.setText(lstBoPhan.get(0).getTenbophan());
        _tfMaBoPhan.setText(lstBoPhan.get(0).getMabophan());
        Calendar calendar = lstBoPhan.get(0).getCreatedAt().toGregorianCalendar();
        _calBoPhan.setCalendar(calendar);
        }

        ClientUtil.getValueIsActiveFromWS(_cbbBpIsActive,
            ClientUtil.getStringFromIsActive(lstBoPhan.get(0).isIsActive()));

        idBoPhan = lstBoPhan.get(0).getId();
    }//GEN-LAST:event__tblViewBoPhanMouseClicked

    private void _tfTenBoPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfTenBoPhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tfTenBoPhanActionPerformed

    private void _tblViewDktdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblViewDktdMouseClicked
        int row = _tblViewDktd.getSelectedRow();
        String maDktd = (_tblViewDktd.getModel().getValueAt(row, 0).toString());
        String tenDktd = (_tblViewDktd.getModel().getValueAt(row, 1).toString());
        java.util.List<Tlu20DieuKienTuyenDung> lstDktd = tlu20DktdFindCommon(tenDktd,maDktd);
        if(!lstDktd.isEmpty()) {
            _tfCreatedbyDktd.setText(lstDktd.get(0).getCreatedBy());
            _tfTenDktd.setText(lstDktd.get(0).getTendmdktd());
            _tfMaDktd.setText(lstDktd.get(0).getMadmdktd());
            Calendar calendar = lstDktd.get(0).getCreatedAt().toGregorianCalendar();
            _calDktd.setCalendar(calendar);
            idDktd = lstDktd.get(0).getIdDktd();

            ClientUtil.getValueIsActiveFromWS(_cbbDktd,
                ClientUtil.getStringFromIsActive(lstDktd.get(0).isIsActive()));
        }
    }//GEN-LAST:event__tblViewDktdMouseClicked

    private void _tfTenDktdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfTenDktdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tfTenDktdActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        viewTdvh();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (ValidateUtil.isNotNull(tdvhMa.getText())) {
            if (tlu20TrinhDoVanHoaFindCommon(null, tdvhMa.getText()).size() > 0) {
                int id = tlu20TrinhDoVanHoaFindCommon(null, tdvhMa.getText()).get(0).getIdTdvh();
                tlu20TrinhDoVanHoaDelete(id);
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, tdvhMa.getText());

            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần xóa", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        viewTdvh();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            if (ValidateUtil.isNotNull(tdvhMa.getText())) {
                String result = Constant.BLANK;
                result = tlu20TrinhDoVanHoaUpdatebyID(idTdvh, tdvhNguoiThem.getText(),
                    DateTimeUtil.convertCalendarToString(dateTdvh.getCalendar().getTime()),
                    ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(tdvhLaNv)),
                    tdvhTen.getText(), tdvhMa.getText());
                if(result.equalsIgnoreCase(Constant.SUCCESS)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần nhập", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }

        viewTdvh();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if (ValidateUtil.isNotNull(tdvhNguoiThem.getText())
                && ValidateUtil.isNotNull(tdvhTen.getText())
                && ValidateUtil.isNotNull(tdvhMa.getText())) {
                if (tlu20TrinhDoVanHoaFindCommon(null, tdvhMa.getText()).isEmpty()) {
                    tlu20TrinhDoVanHoaInsert(tdvhNguoiThem.getText(),
                        DateTimeUtil.convertCalendarToString(dateTdvh.getCalendar().getTime()),
                        ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(tdvhLaNv)),
                        tdvhTen.getText(), tdvhMa.getText());
                    //viewDKTD();
                    tdvhNguoiThem.setText(Constant.BLANK);
                    tdvhMa.setText(Constant.BLANK);
                    tdvhTen.setText(Constant.BLANK);
                    dateTdvh.setCalendar(null);
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Mã : " + tdvhMa.getText() + " đã tồn tại ");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập đủ thông tin");
            }
        } catch (Exception e) {

        }
        viewTdvh();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void _tblViewTdvhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblViewTdvhMouseClicked
        int row = _tblViewTdvh.getSelectedRow();
        String maTdvh = (_tblViewTdvh.getModel().getValueAt(row, 0).toString());
        String tenTdvh = (_tblViewTdvh.getModel().getValueAt(row, 1).toString());
        java.util.List<Tlu20TrinhDoVanHoa> lstTrinhDoVanHoa
        = tlu20TrinhDoVanHoaFindCommon(tenTdvh, maTdvh);

        tdvhNguoiThem.setText(lstTrinhDoVanHoa.get(0).getCreatedBy());
        tdvhTen.setText(lstTrinhDoVanHoa.get(0).getTenTdvh());
        tdvhMa.setText(lstTrinhDoVanHoa.get(0).getMaTdvh());

        ClientUtil.getValueIsActiveFromWS(tdvhLaNv,
            ClientUtil.getStringFromIsActive(lstTrinhDoVanHoa.get(0).isIsActive()));

        Calendar calendar = lstTrinhDoVanHoa.get(0).getCreatedAt().toGregorianCalendar();

        dateTdvh.setCalendar(calendar);
        idTdvh = lstTrinhDoVanHoa.get(0).getIdTdvh();
    }//GEN-LAST:event__tblViewTdvhMouseClicked

    private void tdvhTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdvhTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdvhTenActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        danhMuc.removeAll();
        danhMuc.repaint();
        danhMuc.revalidate();
        //adding
        danhMuc.add(boPhan);
        danhMuc.repaint();
        danhMuc.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        danhMuc.removeAll();
        danhMuc.repaint();
        danhMuc.revalidate();
        //adding
        danhMuc.add(chucVu);
        danhMuc.repaint();
        danhMuc.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        danhMuc.removeAll();
        danhMuc.repaint();
        danhMuc.revalidate();
        //adding
        danhMuc.add(khtd);
        danhMuc.repaint();
        danhMuc.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //removing
        danhMuc.removeAll();
        danhMuc.repaint();
        danhMuc.revalidate();
        //adding
        danhMuc.add(tdvh);
        danhMuc.repaint();
        danhMuc.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
        viewHsuv();
    }//GEN-LAST:event_jPanel27MouseClicked

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        new updateLPV().setVisible(true);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        isUpdateLpv = true;
        if (idLpv == 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Lịch phỏng vấn trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            new updateLPV(isUpdateLpv, idLpv).setVisible(true);
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        if(idLpv > 0) {
            tlu30LpvDelete(idLpv);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Lịch phỏng vấn trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jPanel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseClicked
        viewLpv();
    }//GEN-LAST:event_jPanel28MouseClicked

    private void jPanel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MouseClicked
        if(ClientUtil.setValueofCombobox(_cbbSearchKqpv).equalsIgnoreCase(Constant.KQ_All)) {
            viewKqpvAll();
        } else if(ClientUtil.setValueofCombobox(_cbbSearchKqpv).equalsIgnoreCase(Constant.KQ_FAIL)) {
            viewKqpvFail();
        } else if(ClientUtil.setValueofCombobox(_cbbSearchKqpv).equalsIgnoreCase(Constant.KQ_PASS)) {
            viewKqpvPass();
        }
    }//GEN-LAST:event_jPanel31MouseClicked

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
         try {
            if (ValidateUtil.isNotNull(_tfCreatedbyDktd.getText())
                && ValidateUtil.isNotNull(_tfTenDktd.getText())
                && ValidateUtil.isNotNull(_tfTenDktd.getText())) {
                if (tlu20DktdFindCommon(_tfMaDktd.getText(), null).isEmpty()) {
                    tlu20DktdInsert(_tfCreatedbyDktd.getText(),
                        DateTimeUtil.convertCalendarToString(_calDktd.getCalendar().getTime()),
                        ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbDktd)),
                        _tfTenDktd.getText(), _tfMaDktd.getText());
                    //viewDKTD();
                     _tfCreatedbyDktd.setText(Constant.BLANK);
                    _tfMaDktd.setText(Constant.BLANK);
                    _tfTenDktd.setText(Constant.BLANK);
                    _calDktd.setCalendar(null);
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Mã : " + _tfMaDktd.getText() + " đã tồn tại ");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập đủ thông tin");
            }
        } catch (Exception e) {
            System.out.println("catch DKTD");
        }
        viewDKTD();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfMaDktd.getText())) {
                String result = Constant.BLANK;
                result = tlu20DktdUpdatebyID(idDktd, _tfCreatedbyDktd.getText(),
                    DateTimeUtil.convertCalendarToString(_calDktd.getCalendar().getTime()),
                    ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbDktd)),
                    _tfTenDktd.getText(),_tfMaDktd.getText() );
                if(result.equalsIgnoreCase(Constant.SUCCESS)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
                }
               

            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần nhập", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }

        viewDKTD();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        if (ValidateUtil.isNotNull(_tfMaDktd.getText())) {
            if (!tlu20DktdFindCommon(_tfTenDktd.getText(), _tfMaDktd.getText()).isEmpty()) {
                int id = tlu20DktdFindCommon(_tfTenDktd.getText(),
                    _tfMaDktd.getText()).get(0).getIdDktd();
                tlu20DktdDeletebyId(id);
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, _tfMaDktd.getText());

            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần xóa",
                "Warning", JOptionPane.WARNING_MESSAGE);
        }
        viewDKTD();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        viewDKTD();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfCreatedbyBoPhan.getText())
                && ValidateUtil.isNotNull(_tfTenBoPhan.getText())
                && ValidateUtil.isNotNull(_tfMaBoPhan)) {
                if (tlu20BophanFindCommon(null, _tfMaBoPhan.getText()).isEmpty()) {
                    tlu20BoPhanInsert(_tfCreatedbyBoPhan.getText(),
                        DateTimeUtil.convertCalendarToString(_calBoPhan.getCalendar().getTime()),
                        ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbBpIsActive)),
                        _tfTenBoPhan.getText(), _tfMaBoPhan.getText());
                    _tfCreatedbyBoPhan.setText(Constant.BLANK);
                    _tfMaBoPhan.setText(Constant.BLANK);
                    _tfTenBoPhan.setText(Constant.BLANK);
                    _calBoPhan.setCalendar(null);
                    //viewDKTD();
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Mã : " + _tfMaBoPhan.getText() + " đã tồn tại ");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập đủ thông tin");
            }
        } catch (Exception e) {
            System.out.println("catch DKTD");
        }
        viewBoPhan();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
       try {
            if (ValidateUtil.isNotNull(_tfMaBoPhan.getText())) {
                String result = Constant.BLANK;
                result = tlu20BophanUpdatebyID(idBoPhan, _tfCreatedbyBoPhan.getText(),
                    DateTimeUtil.convertCalendarToString(_calBoPhan.getCalendar().getTime()),
                    ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbBpIsActive)),
                    _tfTenBoPhan.getText(), _tfMaBoPhan.getText());
                if(result.equalsIgnoreCase(Constant.SUCCESS)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần nhập", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }

        viewBoPhan();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        if (ValidateUtil.isNotNull(_tfMaBoPhan.getText())) {
            if (tlu20BophanFindCommon(null, _tfMaBoPhan.getText()).size() > 0) {
                int id = tlu20BophanFindCommon(null,
                    _tfMaBoPhan.getText()).get(0).getId();
                tlu20BophanDeletebyId(id);
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, _tfMaBoPhan.getText());

            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần xóa",
                "Warning", JOptionPane.WARNING_MESSAGE);
        }
        viewBoPhan();
                  
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
       viewBoPhan();
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfCreatedbyChucVu.getText())
                && ValidateUtil.isNotNull(_tfTenChucVu.getText())
                && ValidateUtil.isNotNull(_tfMaChucVu.getText())) {
                if (tlu20ChucVuFindCommon(_tfMaChucVu.getText(), null).isEmpty()) {
                    tlu20ChucVuInsert(_tfCreatedbyChucVu.getText(),
                        DateTimeUtil.convertCalendarToString(_calChucVu.getCalendar().getTime()),
                        ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbIsActiveCv)),
                        _tfTenChucVu.getText(), _tfMaChucVu.getText());
                    
                    _tfCreatedbyChucVu.setText(Constant.BLANK);
                    _tfMaChucVu.setText(Constant.BLANK);
                    _tfTenChucVu.setText(Constant.BLANK);
                    _calChucVu.setCalendar(null);
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Mã : " + _tfMaChucVu.getText() + " đã tồn tại ");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập đủ thông tin");
            }
        } catch (Exception e) {
        }
        viewChucVu();
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfMaChucVu.getText())) {
                String resutl = Constant.BLANK;
               resutl = tlu20ChucVuUpdatebyID(idChucVu, _tfCreatedbyChucVu.getText(),
                    DateTimeUtil.convertCalendarToString(_calChucVu.getCalendar().getTime()),
                    ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbIsActiveCv)),
                    _tfTenChucVu.getText(), _tfMaChucVu.getText());
               if(resutl.equalsIgnoreCase(Constant.SUCCESS)) {
                   JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
               } 
               

            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần nhập", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }

        viewChucVu();
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        if (!_tfMaChucVu.getText().equals("")) {
            if (tlu20ChucVuFindCommon(null, _tfMaChucVu.getText()).size() > 0) {
                int id = tlu20ChucVuFindCommon(null, _tfMaChucVu.getText()).get(0).getIdCv();
                tlu20ChucVuDeletebyId(id);
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, _tfMaChucVu.getText());

            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần xóa", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        viewChucVu();
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        viewChucVu();
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        new AccountMgt().setVisible(true);
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        isUpdateUser = true;
        new AccountMgt(isUpdateUser, _tfTenDn.getText()).setVisible(true);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        Tlu20DangNhap dangNhap = tLu20DangNhapFindUser(_tfTenDn.getText());
        if(ValidateUtil.isNotNull(dangNhap)) {
            if(!_tfTenDn.getText().equals(dangNhap.getUsername())) {
                tLu20Delete(_tfTenDn.getText());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không thể tự xóa chính mình", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jPanel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel39MouseClicked
        viewDangNhap();
    }//GEN-LAST:event_jPanel39MouseClicked

    private void _tblKqpvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblKqpvMouseClicked
        int row = _tblKqpv.getSelectedRow();
        String maHS = _tblKqpv.getModel().getValueAt(row, 0).toString();
        new ChiTietKqpv(maHS).setVisible(true);
    }//GEN-LAST:event__tblKqpvMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser _calBoPhan;
    private com.toedter.calendar.JDateChooser _calChucVu;
    private com.toedter.calendar.JDateChooser _calDktd;
    private javax.swing.JComboBox _cbbBpIsActive;
    private javax.swing.JComboBox _cbbDktd;
    private javax.swing.JComboBox _cbbIsActiveCv;
    private javax.swing.JComboBox _cbbSearchKqpv;
    private javax.swing.JLabel _lbWelcome;
    private javax.swing.JPasswordField _pfNewPass;
    private javax.swing.JPasswordField _pfPass;
    private javax.swing.JPasswordField _pfReNewPass;
    private javax.swing.JTable _tblDn;
    private javax.swing.JTable _tblKqpv;
    private javax.swing.JTable _tblLpv;
    private javax.swing.JTable _tblViewBoPhan;
    private javax.swing.JTable _tblViewChucVu;
    private javax.swing.JTable _tblViewDktd;
    private javax.swing.JTable _tblViewTdvh;
    private javax.swing.JTable _tblxemHsuv;
    private javax.swing.JTable _tblxemKHTD;
    private javax.swing.JTextField _tfCreatedbyBoPhan;
    private javax.swing.JTextField _tfCreatedbyChucVu;
    private javax.swing.JTextField _tfCreatedbyDktd;
    private javax.swing.JTextField _tfMaBoPhan;
    private javax.swing.JTextField _tfMaChucVu;
    private javax.swing.JTextField _tfMaDktd;
    private javax.swing.JTextField _tfSearch;
    private javax.swing.JTextField _tfSearchHsuv;
    private javax.swing.JTextField _tfSearchLpv;
    private javax.swing.JTextField _tfTenBoPhan;
    private javax.swing.JTextField _tfTenChucVu;
    private javax.swing.JTextField _tfTenDktd;
    private javax.swing.JTextField _tfTenDn;
    private javax.swing.JPanel boPhan;
    private javax.swing.JPanel chucVu;
    private javax.swing.JPanel danhMuc;
    private javax.swing.JPanel danhMucChon;
    private javax.swing.JPanel danhMucLon;
    private com.toedter.calendar.JDateChooser dateTdvh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JPanel khtd;
    private javax.swing.JPanel tdvh;
    private javax.swing.JComboBox tdvhLaNv;
    private javax.swing.JTextField tdvhMa;
    private javax.swing.JTextField tdvhNguoiThem;
    private javax.swing.JTextField tdvhTen;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<service.webservice.Tlu30KeHoachTuyenDung> tlu30KhtdDisplayAll() {
        service.webservice.WsTLU30KeHoachTuyenDung service = new service.webservice.WsTLU30KeHoachTuyenDung();
        service.webservice.WsTlu30KeHoachTuyenDung port = service.getWsTlu30KeHoachTuyenDungPort();
        return port.tlu30KhtdDisplayAll();
    }

    

    private static String tlu20TrinhDoVanHoaInsert(java.lang.String createdBy, java.lang.String createdAt, boolean isActive, java.lang.String tenTDVH, java.lang.String maTDVH) throws ParseException_Exception {
        service.webservice.WSTLU20TRINHDOVH_Service service = new service.webservice.WSTLU20TRINHDOVH_Service();
        service.webservice.WSTLU20TRINHDOVH port = service.getWSTLU20TRINHDOVHPort();
        return port.tlu20TrinhDoVanHoaInsert(createdBy, createdAt, isActive, tenTDVH, maTDVH);
    }

    private static String tlu20TrinhDoVanHoaUpdatebyID(int id, java.lang.String createdBy, java.lang.String createdAt, boolean isActive, java.lang.String tenTDVH, java.lang.String maTDVH) throws ParseException_Exception {
        service.webservice.WSTLU20TRINHDOVH_Service service = new service.webservice.WSTLU20TRINHDOVH_Service();
        service.webservice.WSTLU20TRINHDOVH port = service.getWSTLU20TRINHDOVHPort();
        return port.tlu20TrinhDoVanHoaUpdatebyID(id, createdBy, createdAt, isActive, tenTDVH, maTDVH);
    }

    private static String tlu20TrinhDoVanHoaDelete(int id) {
        service.webservice.WSTLU20TRINHDOVH_Service service = new service.webservice.WSTLU20TRINHDOVH_Service();
        service.webservice.WSTLU20TRINHDOVH port = service.getWSTLU20TRINHDOVHPort();
        return port.tlu20TrinhDoVanHoaDelete(id);
    }

    private static String tlu20DktdInsert(java.lang.String createdby, java.lang.String createdat, boolean isactive, java.lang.String madmdktd, java.lang.String tendmdktd) throws ParseException_Exception {
        service.webservice.WsTlu20DieuKienTuyenDung_Service service = new service.webservice.WsTlu20DieuKienTuyenDung_Service();
        service.webservice.WsTlu20DieuKienTuyenDung port = service.getWsTlu20DieuKienTuyenDungPort();
        return port.tlu20DktdInsert(createdby, createdat, isactive, madmdktd, tendmdktd);
    }

    private static String tlu20DktdUpdatebyID(int iddktd, java.lang.String createdby, java.lang.String createdat, boolean isactive, java.lang.String madmdktd, java.lang.String tendmdktd) throws ParseException_Exception {
        service.webservice.WsTlu20DieuKienTuyenDung_Service service = new service.webservice.WsTlu20DieuKienTuyenDung_Service();
        service.webservice.WsTlu20DieuKienTuyenDung port = service.getWsTlu20DieuKienTuyenDungPort();
        return port.tlu20DktdUpdatebyID(iddktd, createdby, createdat, isactive, madmdktd, tendmdktd);
    }
    
    


    private static java.util.List<service.webservice.Tlu20Bophan> tlu20BophanDisplayAll() {
        service.webservice.WSBOPHAN_Service service = new service.webservice.WSBOPHAN_Service();
        service.webservice.WSBOPHAN port = service.getWSBOPHANPort();
        return port.tlu20BophanDisplayAll();
    }

    private static java.util.List<service.webservice.Tlu20Bophan> tlu20BophanFindCommon(java.lang.String tenbophan, java.lang.String mabophan) {
        service.webservice.WSBOPHAN_Service service = new service.webservice.WSBOPHAN_Service();
        service.webservice.WSBOPHAN port = service.getWSBOPHANPort();
        return port.tlu20BophanFindCommon(tenbophan, mabophan);
    }


    private static String tlu20BophanUpdatebyID(int id, java.lang.String createdBy, java.lang.String createdAt, boolean isActive, java.lang.String tenbophan, java.lang.String mabophan) throws ParseException_Exception {
        service.webservice.WSBOPHAN_Service service = new service.webservice.WSBOPHAN_Service();
        service.webservice.WSBOPHAN port = service.getWSBOPHANPort();
        return port.tlu20BophanUpdatebyID(id, createdBy, createdAt, isActive, tenbophan, mabophan);
    }

    private static java.util.List<service.webservice.Tlu30KeHoachTuyenDung> tlu30KeHoachTuyenDungFindCommon(java.lang.String keHoachSo, java.lang.String chucVu, java.lang.String boPhan) {
        service.webservice.WsTLU30KeHoachTuyenDung service = new service.webservice.WsTLU30KeHoachTuyenDung();
        service.webservice.WsTlu30KeHoachTuyenDung port = service.getWsTlu30KeHoachTuyenDungPort();
        return port.tlu30KeHoachTuyenDungFindCommon(keHoachSo, chucVu, boPhan);
    }

    private static java.util.List<service.webservice.Tlu30LichPhongVan> tlu30LpvFindCommon(java.lang.String soLichPhongVan, java.lang.String keHoachSo, java.lang.String ungVien, java.lang.String datYeuCau) {
        service.webservice.WsTlu30LichPhongVan_Service service = new service.webservice.WsTlu30LichPhongVan_Service();
        service.webservice.WsTlu30LichPhongVan port = service.getWsTlu30LichPhongVanPort();
        return port.tlu30LpvFindCommon(soLichPhongVan, keHoachSo, ungVien, datYeuCau);
    }

    private static String tlu30HsuvDelete(int id) {
        service.webservice.WsTlu30HoSoUngVien_Service service = new service.webservice.WsTlu30HoSoUngVien_Service();
        service.webservice.WsTlu30HoSoUngVien port = service.getWsTlu30HoSoUngVienPort();
        return port.tlu30HsuvDelete(id);
    }

    private static String tlu30LpvDelete(int idLpv) {
        service.webservice.WsTlu30LichPhongVan_Service service = new service.webservice.WsTlu30LichPhongVan_Service();
        service.webservice.WsTlu30LichPhongVan port = service.getWsTlu30LichPhongVanPort();
        return port.tlu30LpvDelete(idLpv);
    }

    private static Tlu20DangNhap tLu20DangNhapFindUser(java.lang.String user) {
        service.webservice.WsDangNhap_Service service = new service.webservice.WsDangNhap_Service();
        service.webservice.WsDangNhap port = service.getWsDangNhapPort();
        return port.tLu20DangNhapFindUser(user);
    }

    private static java.util.List<service.webservice.Tlu30HoSoUngVien> displayAll() {
        service.webservice.WsTlu30HoSoUngVien_Service service = new service.webservice.WsTlu30HoSoUngVien_Service();
        service.webservice.WsTlu30HoSoUngVien port = service.getWsTlu30HoSoUngVienPort();
        return port.displayAll();
    }

    private static java.util.List<service.webservice.Tlu20TrinhDoVanHoa> tlu20TrinhDoVanHoaFindCommon(java.lang.String tenTDVH, java.lang.String maTDVH) {
        service.webservice.WSTLU20TRINHDOVH_Service service = new service.webservice.WSTLU20TRINHDOVH_Service();
        service.webservice.WSTLU20TRINHDOVH port = service.getWSTLU20TRINHDOVHPort();
        return port.tlu20TrinhDoVanHoaFindCommon(tenTDVH, maTDVH);
    }

    private static String tlu20BoPhanInsert(java.lang.String createdBy, java.lang.String createdAt, boolean isActive, java.lang.String tenbophan, java.lang.String mabophan) throws ParseException_Exception {
        service.webservice.WSBOPHAN_Service service = new service.webservice.WSBOPHAN_Service();
        service.webservice.WSBOPHAN port = service.getWSBOPHANPort();
        return port.tlu20BoPhanInsert(createdBy, createdAt, isActive, tenbophan, mabophan);
    }

    private static String tlu20DktdDeletebyId(int iddktd) {
        service.webservice.WsTlu20DieuKienTuyenDung_Service service = new service.webservice.WsTlu20DieuKienTuyenDung_Service();
        service.webservice.WsTlu20DieuKienTuyenDung port = service.getWsTlu20DieuKienTuyenDungPort();
        return port.tlu20DieuKienTuyenDungDeletebyId(iddktd);
    }

    private static java.util.List<service.webservice.Tlu30HoSoUngVien> tlu30HsuvFindCommon(java.lang.String maHs, java.lang.String khs, java.lang.String bophan) {
        service.webservice.WsTlu30HoSoUngVien_Service service = new service.webservice.WsTlu30HoSoUngVien_Service();
        service.webservice.WsTlu30HoSoUngVien port = service.getWsTlu30HoSoUngVienPort();
        return port.tlu30HsuvFindCommon(maHs, khs, bophan);
    }

    private static java.util.List<service.webservice.Tlu20ChucVu> tlu20ChucVuFindCommon(java.lang.String tenchucvu, java.lang.String machucvu) {
        service.webservice.WSChucVu service = new service.webservice.WSChucVu();
        service.webservice.WSTLU20CHUCVU port = service.getWSTLU20CHUCVUPort();
        return port.tlu20ChucVuFindCommon(tenchucvu, machucvu);
    }

    private static String tlu20ChucVuDeletebyId(int id) {
        service.webservice.WSChucVu service = new service.webservice.WSChucVu();
        service.webservice.WSTLU20CHUCVU port = service.getWSTLU20CHUCVUPort();
        return port.tlu20ChucVuDeletebyId(id);
    }

    private static String tlu20ChucVuUpdatebyID(int idcv, java.lang.String createdBy, java.lang.String createdAt, boolean isActive, java.lang.String tenchucvu, java.lang.String machucvu) throws ParseException_Exception {
        service.webservice.WSChucVu service = new service.webservice.WSChucVu();
        service.webservice.WSTLU20CHUCVU port = service.getWSTLU20CHUCVUPort();
        return port.tlu20ChucVuUpdatebyID(idcv, createdBy, createdAt, isActive, tenchucvu, machucvu);
    }

    private static String tlu20ChucVuInsert(java.lang.String createdBy, java.lang.String createdAt, boolean isActive, java.lang.String tenchucvu, java.lang.String machucvu) throws ParseException_Exception {
        service.webservice.WSChucVu service = new service.webservice.WSChucVu();
        service.webservice.WSTLU20CHUCVU port = service.getWSTLU20CHUCVUPort();
        return port.tlu20ChucVuInsert(createdBy, createdAt, isActive, tenchucvu, machucvu);
    }

    private static java.util.List<service.webservice.Tlu20DangNhap> tlu20DangNhapFindCommon(java.lang.String uname) {
        service.webservice.WsDangNhap_Service service = new service.webservice.WsDangNhap_Service();
        service.webservice.WsDangNhap port = service.getWsDangNhapPort();
        return port.tlu20DangNhapFindCommon(uname);
    }

    private static String tlu20DangNhapUpdate(java.lang.String username, java.lang.String pass, java.lang.String repass, java.lang.String role) {
        service.webservice.WsDangNhap_Service service = new service.webservice.WsDangNhap_Service();
        service.webservice.WsDangNhap port = service.getWsDangNhapPort();
        return port.tlu20DangNhapUpdate(username, pass, repass, role);
    }

    private static String tLu20Delete(java.lang.String user) {
        service.webservice.WsDangNhap_Service service = new service.webservice.WsDangNhap_Service();
        service.webservice.WsDangNhap port = service.getWsDangNhapPort();
        return port.tLu20Delete(user);
    }

    private static String tlu20BophanDeletebyId(int id) {
        service.webservice.WSBOPHAN_Service service = new service.webservice.WSBOPHAN_Service();
        service.webservice.WSBOPHAN port = service.getWSBOPHANPort();
        return port.tlu20BophanDeletebyId(id);
    }

    private static java.util.List<service.webservice.Tlu20DieuKienTuyenDung> tlu20DktdFindCommon(java.lang.String tendmdktd, java.lang.String madmdktd) {
        service.webservice.WsTlu20DieuKienTuyenDung_Service service = new service.webservice.WsTlu20DieuKienTuyenDung_Service();
        service.webservice.WsTlu20DieuKienTuyenDung port = service.getWsTlu20DieuKienTuyenDungPort();
        return port.tlu20DktdFindCommon(tendmdktd, madmdktd);
    }

    private static java.util.List<service.webservice.Tlu30HoSoUngVien> findbyMaHoSo(java.lang.String mhs) {
        service.webservice.WsTlu30HoSoUngVien_Service service = new service.webservice.WsTlu30HoSoUngVien_Service();
        service.webservice.WsTlu30HoSoUngVien port = service.getWsTlu30HoSoUngVienPort();
        return port.findbyMaHoSo(mhs);
    }

    private static String tlu30KhtdDeletebyId(int iddktd) {
        service.webservice.WsTLU30KeHoachTuyenDung service = new service.webservice.WsTLU30KeHoachTuyenDung();
        service.webservice.WsTlu30KeHoachTuyenDung port = service.getWsTlu30KeHoachTuyenDungPort();
        return port.tlu30KhtdDeletebyId(iddktd);
    }
    
    
}
