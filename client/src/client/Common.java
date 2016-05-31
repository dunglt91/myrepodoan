/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dunglt.qlns.client.util.ClientUtil;
import dunglt.qlns.client.util.DateTimeUtil;
import dunglt.qlns.client.util.ValidateUtil;
import java.awt.*;
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
        viewKqpv();
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
        viewKqpv();
        viewLpv();
        viewDangNhap();
        if(!checkIsAdmin(stUserName)) {
            jTabbedPane3.removeTabAt(6);
        }
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
                        _tfMaDktd.getText(), _tfTenDktd.getText())) {
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
            model.addRow(new Object[]{khtd.getKeHoachSo(), khtd.getChucVu(), khtd.getBoPhan()});
        }
        model.fireTableDataChanged();
    }

    private void viewallHSUV() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblxemKHTD.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblxemKHTD.getModel();
        for (Tlu30HoSoUngVien hsuv : displayAll()) {
            model.addRow(new Object[]{hsuv.getMaHoSo(), hsuv.getKeHoachSo(), hsuv.getBoPhanDuTuyen()});
        }
        model.fireTableDataChanged();
    }

    private void viewKhtd() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblxemKHTD.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblxemKHTD.getModel();
        for (Tlu30KeHoachTuyenDung khtd : tlu30KeHoachTuyenDungFindCommon(
                _tfxemDKTD_KHS.getText(),
                _tfXemChucVu.getText(),
                _tfxemBoPhan.getText())) {
            model.addRow(new Object[]{khtd.getIdKhtd(), khtd.getKeHoachSo(), khtd.getChucVu(), khtd.getBoPhan()});
        }
        model.fireTableDataChanged();
    }

    public void viewHsuv() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblxemHsuv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblxemHsuv.getModel();
        for (Tlu30HoSoUngVien hsuv : tlu30HsuvFindCommon(_tfxemHsuvMahs.getText(), _tfxemHsuvKhs.getText(), _tfxemHsuvBoPhan.getText())) {
            model.addRow(new Object[]{hsuv.getIdHsuv(), hsuv.getKeHoachSo(), hsuv.getMaHoSo(), hsuv.getBoPhanDuTuyen()});
        }
        model.fireTableDataChanged();
    }

    public void viewKqpv() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblKqpv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblKqpv.getModel();
        for (Tlu30LichPhongVan lpv : tlu30LpvFindCommon(_tfLpvMahs.getText(),
                _tfLpvkhs.getText(), _tfLpvTenUngVien.getText(), null)) {
            model.addRow(new Object[]{lpv.getSoLichPhongVan(),
                lpv.getKeHoachSo(), lpv.getUngVien()});
        }
        model.fireTableDataChanged();
    }
    
    public void viewLpv() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblLpv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblLpv.getModel();
        for (Tlu30LichPhongVan lpv : tlu30LpvFindCommon(lpvSolpv.getText(),
                lpvKhs.getText(), lpvTenUv.getText(), null)) {
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
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/hrmbg.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        danhMucLon = new javax.swing.JPanel();
        danhMucChon = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/bann.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        danhMuc = new javax.swing.JPanel();
        tdvh = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
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
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        khtd = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
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
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        boPhan = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
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
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        chucVu = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel11 = new javax.swing.JPanel();
        _tfTenChucVu = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        _tfMaChucVu = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        _calChucVu = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        _tfCreatedbyChucVu = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        _cbbIsActiveCv = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        _tblViewChucVu = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel1 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel36 = new javax.swing.JLabel();
        _tfxemDKTD_KHS = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        _tfxemBoPhan = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        _tfXemChucVu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        _tblxemKHTD = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel13 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel39 = new javax.swing.JLabel();
        _tfxemHsuvKhs = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        _tfxemHsuvMahs = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        _tfxemHsuvBoPhan = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        _tblxemHsuv = new javax.swing.JTable();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jScrollPane7 = new javax.swing.JScrollPane();
        _tblLpv = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel3 = new javax.swing.JLabel();
        lpvTenUv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lpvSolpv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lpvKhs = new javax.swing.JTextField();
        jButton35 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel16 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel52 = new javax.swing.JLabel();
        _tfLpvkhs = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        _tfLpvMahs = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        _tfLpvTenUngVien = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        _tblKqpv = new javax.swing.JTable();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        }
        ;
        jPanel8 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel6 = new javax.swing.JLabel();
        _tfTenDn = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        _tblDn = new javax.swing.JTable();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane3.setBackground(java.awt.Color.white);

        jPanel4.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1262, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
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

        danhMucChon.setBackground(java.awt.Color.white);
        danhMucChon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        jButton3.setText("Kế hoạch tuyển dụng");
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

        javax.swing.GroupLayout danhMucChonLayout = new javax.swing.GroupLayout(danhMucChon);
        danhMucChon.setLayout(danhMucChonLayout);
        danhMucChonLayout.setHorizontalGroup(
            danhMucChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton3)
        );

        danhMucChonLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton3, jButton4, jButton5});

        danhMucChonLayout.setVerticalGroup(
            danhMucChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhMucChonLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        danhMucChonLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton3, jButton4, jButton5});

        danhMuc.setBackground(java.awt.Color.white);
        danhMuc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        danhMuc.setLayout(new java.awt.CardLayout());

        tdvh.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tdvhLaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(116, 116, 116)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTdvh, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(tdvhMa))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdvhTen, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(tdvhNguoiThem))
                        .addGap(121, 121, 121))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel7});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tdvhTen)
                    .addComponent(jLabel2)
                    .addComponent(tdvhMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTdvh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdvhNguoiThem)))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tdvhLaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel7});

        _tblViewTdvh.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
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

        jButton6.setBackground(new java.awt.Color(52, 79, 223));
        jButton6.setForeground(java.awt.Color.white);
        jButton6.setText("Thêm mới");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(52, 79, 223));
        jButton7.setForeground(java.awt.Color.white);
        jButton7.setText("Cập nhật");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(52, 79, 223));
        jButton8.setForeground(java.awt.Color.white);
        jButton8.setText("Xóa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(52, 79, 223));
        jButton9.setForeground(java.awt.Color.white);
        jButton9.setText("Tìm kiếm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

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
                        .addGap(18, 18, 18)
                        .addGroup(tdvhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );

        tdvhLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton6, jButton7, jButton8, jButton9});

        tdvhLayout.setVerticalGroup(
            tdvhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tdvhLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(tdvhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tdvhLayout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        danhMuc.add(tdvh, "card2");

        khtd.setBackground(java.awt.Color.white);

        jPanel9.setBackground(java.awt.Color.white);
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(_cbbDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(116, 116, 116)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(_tfMaDktd)
                            .addComponent(_calDktd, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfTenDktd, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(_tfCreatedbyDktd))
                        .addGap(121, 121, 121))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_tfTenDktd)
                            .addComponent(_tfMaDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_calDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(_tfCreatedbyDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(_cbbDktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        _tblViewDktd.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
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

        jButton10.setBackground(new java.awt.Color(52, 79, 223));
        jButton10.setForeground(java.awt.Color.white);
        jButton10.setText("Thêm mới");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(52, 79, 223));
        jButton11.setForeground(java.awt.Color.white);
        jButton11.setText("Cập nhật");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(52, 79, 223));
        jButton12.setForeground(java.awt.Color.white);
        jButton12.setText("Xóa");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(52, 79, 223));
        jButton13.setForeground(java.awt.Color.white);
        jButton13.setText("Tìm kiếm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout khtdLayout = new javax.swing.GroupLayout(khtd);
        khtd.setLayout(khtdLayout);
        khtdLayout.setHorizontalGroup(
            khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khtdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(khtdLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );

        khtdLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton10, jButton11, jButton12, jButton13});

        khtdLayout.setVerticalGroup(
            khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khtdLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(khtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(khtdLayout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        khtdLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton10, jButton11, jButton12, jButton13});

        danhMuc.add(khtd, "card2");

        boPhan.setBackground(java.awt.Color.white);

        jPanel10.setBackground(java.awt.Color.white);
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(_cbbBpIsActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(116, 116, 116)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(_calBoPhan, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(_tfMaBoPhan))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfTenBoPhan, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(_tfCreatedbyBoPhan))
                        .addGap(121, 121, 121))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_tfTenBoPhan)
                            .addComponent(_tfMaBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_calBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_tfCreatedbyBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(_cbbBpIsActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        _tblViewBoPhan.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
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

        jButton14.setBackground(new java.awt.Color(52, 79, 223));
        jButton14.setForeground(java.awt.Color.white);
        jButton14.setText("Thêm mới");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(52, 79, 223));
        jButton15.setForeground(java.awt.Color.white);
        jButton15.setText("Cập nhật");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(52, 79, 223));
        jButton16.setForeground(java.awt.Color.white);
        jButton16.setText("Xóa");

        jButton17.setBackground(new java.awt.Color(52, 79, 223));
        jButton17.setForeground(java.awt.Color.white);
        jButton17.setText("Tìm kiếm");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout boPhanLayout = new javax.swing.GroupLayout(boPhan);
        boPhan.setLayout(boPhanLayout);
        boPhanLayout.setHorizontalGroup(
            boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boPhanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(boPhanLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );

        boPhanLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton14, jButton15, jButton16, jButton17});

        boPhanLayout.setVerticalGroup(
            boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boPhanLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(boPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(boPhanLayout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        boPhanLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton14, jButton15, jButton16, jButton17});

        danhMuc.add(boPhan, "card2");

        chucVu.setBackground(java.awt.Color.white);

        jPanel11.setBackground(java.awt.Color.white);
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        _tfTenChucVu.setBackground(java.awt.Color.white);
        _tfTenChucVu.setBorder(null);
        _tfTenChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tfTenChucVuActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(_cbbIsActiveCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(116, 116, 116)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(_tfMaChucVu)
                            .addComponent(_calChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                        .addGap(94, 94, 94)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfTenChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(_tfCreatedbyChucVu))
                        .addGap(121, 121, 121))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(_tfMaChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32)
                                .addComponent(jLabel31))
                            .addComponent(_tfTenChucVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_calChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_tfCreatedbyChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(89, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(_cbbIsActiveCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        _tblViewChucVu.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
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

        jButton18.setBackground(new java.awt.Color(52, 79, 223));
        jButton18.setForeground(java.awt.Color.white);
        jButton18.setText("Thêm mới");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(52, 79, 223));
        jButton19.setForeground(java.awt.Color.white);
        jButton19.setText("Cập nhật");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(52, 79, 223));
        jButton20.setForeground(java.awt.Color.white);
        jButton20.setText("Xóa");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(52, 79, 223));
        jButton21.setForeground(java.awt.Color.white);
        jButton21.setText("Tìm kiếm");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chucVuLayout = new javax.swing.GroupLayout(chucVu);
        chucVu.setLayout(chucVuLayout);
        chucVuLayout.setHorizontalGroup(
            chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chucVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(chucVuLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                        .addGap(41, 41, 41))))
        );

        chucVuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton18, jButton19, jButton20, jButton21});

        chucVuLayout.setVerticalGroup(
            chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chucVuLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chucVuLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(chucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chucVuLayout.createSequentialGroup()
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(chucVuLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
        );

        chucVuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton18, jButton19, jButton20, jButton21});

        danhMuc.add(chucVu, "card2");

        javax.swing.GroupLayout danhMucLonLayout = new javax.swing.GroupLayout(danhMucLon);
        danhMucLon.setLayout(danhMucLonLayout);
        danhMucLonLayout.setHorizontalGroup(
            danhMucLonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhMucLonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(danhMucChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(danhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        danhMucLonLayout.setVerticalGroup(
            danhMucLonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(danhMucChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(danhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("danh muc", danhMucLon);

        jPanel5.setBackground(java.awt.Color.white);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(418, 117));

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel36.setText("Kế hoạch số");

        _tfxemDKTD_KHS.setBackground(java.awt.Color.white);

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel37.setText("Bộ phận");

        _tfxemBoPhan.setBackground(java.awt.Color.white);

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel38.setText("Chức vụ");

        _tfXemChucVu.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addComponent(_tfxemDKTD_KHS)
                .addGap(47, 47, 47)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(_tfxemBoPhan)
                .addGap(60, 60, 60)
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addComponent(_tfXemChucVu)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(_tfxemDKTD_KHS)
                    .addComponent(jLabel37)
                    .addComponent(_tfxemBoPhan)
                    .addComponent(jLabel38)
                    .addComponent(_tfXemChucVu))
                .addGap(69, 69, 69))
        );

        _tblxemKHTD.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
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

        jButton22.setBackground(new java.awt.Color(52, 79, 223));
        jButton22.setForeground(java.awt.Color.white);
        jButton22.setText("Thêm");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(52, 79, 223));
        jButton23.setForeground(java.awt.Color.white);
        jButton23.setText("sửa");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(52, 79, 223));
        jButton24.setForeground(java.awt.Color.white);
        jButton24.setText("xóa");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(52, 79, 223));
        jButton25.setForeground(java.awt.Color.white);
        jButton25.setText("tìm kiếm");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                .addGap(146, 146, 146))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(61, 61, 61)
                .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(62, 62, 62)
                .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(62, 62, 62)
                .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addGap(341, 341, 341))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(55, 55, 55))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton22, jButton23, jButton24, jButton25});

        jTabbedPane3.addTab("ke hoach tuyen dung", jPanel5);

        jPanel12.setBackground(java.awt.Color.white);

        jPanel13.setBackground(java.awt.Color.white);
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel39.setText("Kế hoạch số");

        _tfxemHsuvKhs.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(181, 242, 135), null));

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel40.setText("Mã hồ sơ");

        _tfxemHsuvMahs.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(181, 242, 135), null));

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel41.setText("Bộ phận");

        _tfxemHsuvBoPhan.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(181, 242, 135), null));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(_tfxemHsuvKhs, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(113, 113, 113)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addComponent(_tfxemHsuvMahs, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addComponent(_tfxemHsuvBoPhan, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(_tfxemHsuvKhs)
                    .addComponent(jLabel40)
                    .addComponent(_tfxemHsuvMahs)
                    .addComponent(jLabel41)
                    .addComponent(_tfxemHsuvBoPhan))
                .addGap(69, 69, 69))
        );

        _tblxemHsuv.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
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

        jButton26.setBackground(new java.awt.Color(52, 79, 223));
        jButton26.setForeground(java.awt.Color.white);
        jButton26.setText("Thêm");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
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

        jButton28.setBackground(new java.awt.Color(52, 79, 223));
        jButton28.setForeground(java.awt.Color.white);
        jButton28.setText("Xóa");
        jButton28.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(52, 79, 223));
        jButton29.setForeground(java.awt.Color.white);
        jButton29.setText("Tìm kiếm");
        jButton29.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(334, 334, 334))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane6)
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(151, 151, 151))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );

        jTabbedPane3.addTab("ho so ung vien", jPanel12);

        jPanel14.setBackground(java.awt.Color.white);

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

        jPanel7.setBackground(java.awt.Color.white);
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Ứng viên");

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Số lịch phỏng vấn");

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Kế hoạch số");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lpvTenUv, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lpvSolpv, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(lpvKhs, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lpvTenUv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lpvKhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lpvSolpv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jButton35.setBackground(new java.awt.Color(52, 79, 223));
        jButton35.setForeground(java.awt.Color.white);
        jButton35.setText("Thêm");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(52, 79, 223));
        jButton37.setForeground(java.awt.Color.white);
        jButton37.setText("Sửa");
        jButton37.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setBackground(new java.awt.Color(52, 79, 223));
        jButton38.setForeground(java.awt.Color.white);
        jButton38.setText("Xóa");
        jButton38.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(52, 79, 223));
        jButton39.setForeground(java.awt.Color.white);
        jButton39.setText("Tìm kiếm");
        jButton39.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(332, 332, 332))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jScrollPane7)
                .addGap(82, 82, 82))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        jTabbedPane3.addTab("Lịch phong van", jPanel14);

        jPanel16.setBackground(java.awt.Color.white);
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel52.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel52.setText("Kế hoạch số");

        jLabel53.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel53.setText("Mã hồ sơ");

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel54.setText("Tên ứng viên");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(_tfLpvkhs, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(47, 47, 47)
                .addComponent(jLabel53)
                .addGap(53, 53, 53)
                .addComponent(_tfLpvMahs, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addComponent(jLabel54)
                .addGap(53, 53, 53)
                .addComponent(_tfLpvTenUngVien, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(_tfLpvkhs)
                    .addComponent(jLabel53)
                    .addComponent(_tfLpvMahs)
                    .addComponent(jLabel54)
                    .addComponent(_tfLpvTenUngVien))
                .addGap(69, 69, 69))
        );

        _tblKqpv.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        _tblKqpv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hồ sơ", "Kế hoạch số", "Tên ứng viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(_tblKqpv);
        jScrollPane8.getViewport().setBackground(Color.WHITE);

        jButton33.setBackground(new java.awt.Color(52, 79, 223));
        jButton33.setForeground(java.awt.Color.white);
        jButton33.setText("Đạt");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(52, 79, 223));
        jButton34.setForeground(java.awt.Color.white);
        jButton34.setText("Không đạt");
        jButton34.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(52, 79, 223));
        jButton36.setForeground(java.awt.Color.white);
        jButton36.setText("Tìm kiếm");
        jButton36.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80)))
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addGap(402, 402, 402))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        jTabbedPane3.addTab("Ket qua phong van", jPanel15);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("Tên đăng nhập");

        _tfTenDn.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel6)
                .addGap(63, 63, 63)
                .addComponent(_tfTenDn)
                .addGap(453, 453, 453))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_tfTenDn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        _tblDn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên đăng nhập"
            }
        ));
        jScrollPane9.setViewportView(_tblDn);
        jScrollPane9.getViewport().setBackground(Color.WHITE);

        jButton40.setBackground(new java.awt.Color(52, 79, 223));
        jButton40.setForeground(java.awt.Color.white);
        jButton40.setText("Thêm");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(52, 79, 223));
        jButton41.setForeground(java.awt.Color.white);
        jButton41.setText("Sửa");
        jButton41.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(52, 79, 223));
        jButton42.setForeground(java.awt.Color.white);
        jButton42.setText("Xóa");
        jButton42.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setBackground(new java.awt.Color(52, 79, 223));
        jButton43.setForeground(java.awt.Color.white);
        jButton43.setText("Tìm kiếm");
        jButton43.setPreferredSize(new java.awt.Dimension(49, 28));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jScrollPane9)
                .addGap(155, 155, 155))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jButton40, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(322, 322, 322))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        jTabbedPane3.addTab("Quan ly tai khoan", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        ImageIcon imageIconHome = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/homeicon_48.png");
        ImageIcon imageIconplan = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/digg_48.png");
        ImageIcon imageIconFile = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/user_48.png");
        ImageIcon imageIconClock = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/clock_48.png");
        ImageIcon imageIconResult = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/database_48.png");
        ImageIcon imageIconList = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/navigate_48.png");
        ImageIcon imageIconAcc = new ImageIcon("/home/dunglt/NetBeansProjects/client/src/dunglt/qlns/client/icon/user-male-edit-icon.png");

        jTabbedPane3.addTab("",imageIconHome, jPanel3);
        jTabbedPane3.addTab("",imageIconList, danhMucLon);
        jTabbedPane3.addTab("", imageIconplan ,jPanel5);
        jTabbedPane3.addTab("",imageIconFile, jPanel12);
        jTabbedPane3.addTab("",imageIconClock, jPanel14);
        jTabbedPane3.addTab("",imageIconResult, jPanel15);
        jTabbedPane3.addTab("",imageIconAcc, jPanel6);
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
                } else {
                    setTitle("Trang chủ");
                }
            }
        };

        jTabbedPane3.addChangeListener(changeListener);

        setBounds(0, 0, 1292, 771);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfCreatedbyChucVu.getText())
                    && ValidateUtil.isNotNull(_tfTenChucVu.getText())
                    && ValidateUtil.isNotNull(_tfMaChucVu.getText())) {
                if (tlu20ChucVuFindCommon(_tfMaChucVu.getText(), null).isEmpty()) {
                    tlu20ChucVuInsert(_tfCreatedbyChucVu.getText(),
                            DateTimeUtil.convertCalendarToString(_calChucVu.getCalendar().getTime()),
                            ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbIsActiveCv)),
                            _tfTenChucVu.getText(), _tfMaChucVu.getText());
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
    }//GEN-LAST:event_jButton18ActionPerformed

    private void _tfTenChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfTenChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tfTenChucVuActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfMaBoPhan.getText())) {

                tlu20BophanUpdatebyID(idBoPhan, _tfCreatedbyBoPhan.getText(),
                        DateTimeUtil.convertCalendarToString(_calBoPhan.getCalendar().getTime()),
                        ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbBpIsActive)),
                        _tfTenBoPhan.getText(), _tfMaBoPhan.getText());
                System.out.println(_tfMaBoPhan.getText());
                System.out.println(idBoPhan);
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
                //
                //refresh();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần nhập", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }

        viewBoPhan();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfCreatedbyBoPhan.getText())
                    && ValidateUtil.isNotNull(_tfTenBoPhan.getText())
                    && ValidateUtil.isNotNull(_tfMaBoPhan)) {
                if (tlu20BophanFindCommon(null, _tfMaBoPhan.getText()).isEmpty()) {
                    tlu20BoPhanInsert(_tfCreatedbyBoPhan.getText(),
                            DateTimeUtil.convertCalendarToString(_calBoPhan.getCalendar().getTime()),
                            ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbBpIsActive)),
                            _tfTenBoPhan.getText(), _tfMaBoPhan.getText());
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
    }//GEN-LAST:event_jButton14ActionPerformed

    private void _tfTenBoPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfTenBoPhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tfTenBoPhanActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
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
    }//GEN-LAST:event_jButton10ActionPerformed

    private void _tfTenDktdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfTenDktdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tfTenDktdActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            if (ValidateUtil.isNotNull(tdvhMa.getText())) {
                tlu20TrinhDoVanHoaUpdatebyID(idTdvh, tdvhNguoiThem.getText(),
                        DateTimeUtil.convertCalendarToString(dateTdvh.getCalendar().getTime()),
                        ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(tdvhLaNv)),
                        tdvhTen.getText(), tdvhMa.getText());
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
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

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        new updateKHTD().setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        new updateHSUV().setVisible(true);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        isUpdateHsuv = true;
        if (idHsuv == 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Hồ sơ ứng viên trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            new updateHSUV(isUpdateHsuv, idHsuv).setVisible(true);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if (idKhtd == 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Kế hoạch tuyển dụng trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            isUpdateKhtd = true;
            new updateKHTD(idKhtd, isUpdateKhtd).setVisible(true);
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        new updateLPV().setVisible(true);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        isUpdateLpv = true;
        if (idLpv == 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Lịch phỏng vấn trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            new updateLPV(isUpdateLpv, idLpv).setVisible(true);
        }
    }//GEN-LAST:event_jButton37ActionPerformed

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

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfMaDktd.getText())) {

                tlu20DktdUpdatebyID(idDktd, _tfCreatedbyDktd.getText(),
                        DateTimeUtil.convertCalendarToString(_calDktd.getCalendar().getTime()),
                        ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbDktd)),
                        _tfMaDktd.getText(), _tfTenDktd.getText());
                System.out.println(_tfMaDktd.getText());
                System.out.println(idDktd);
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
                //
                //refresh();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần nhập", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }

        viewDKTD();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (ValidateUtil.isNotNull(_tfMaDktd.getText())) {
            if (tlu20DktdFindCommon(_tfMaDktd.getText(), null).size() > 0) {
                int id = tlu20DktdFindCommon(_tfMaDktd.getText(),
                        null).get(0).getIdDktd();
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
    }//GEN-LAST:event_jButton12ActionPerformed

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

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        viewDKTD();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void _tblViewBoPhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblViewBoPhanMouseClicked
        int row = _tblViewBoPhan.getSelectedRow();
        String maBoPhan = (_tblViewBoPhan.getModel().getValueAt(row, 0).toString());
        String tenBoPhan = (_tblViewBoPhan.getModel().getValueAt(row, 1).toString());
        System.out.println("");
        java.util.List<Tlu20Bophan> lstBoPhan = tlu20BophanFindCommon(tenBoPhan, maBoPhan);

        _tfCreatedbyBoPhan.setText(lstBoPhan.get(0).getCreatedBy());
        _tfTenBoPhan.setText(lstBoPhan.get(0).getTenbophan());
        _tfMaBoPhan.setText(lstBoPhan.get(0).getMabophan());
        Calendar calendar = lstBoPhan.get(0).getCreatedAt().toGregorianCalendar();
        _calBoPhan.setCalendar(calendar);

        ClientUtil.getValueIsActiveFromWS(_cbbBpIsActive,
                ClientUtil.getStringFromIsActive(lstBoPhan.get(0).isIsActive()));

        idBoPhan = lstBoPhan.get(0).getId();
    }//GEN-LAST:event__tblViewBoPhanMouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        viewBoPhan();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        try {
            if (ValidateUtil.isNotNull(_tfMaChucVu.getText())) {
                tlu20ChucVuUpdatebyID(idChucVu, _tfCreatedbyChucVu.getText(),
                        DateTimeUtil.convertCalendarToString(_calChucVu.getCalendar().getTime()),
                        ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbIsActiveCv)),
                        _tfTenChucVu.getText(), _tfMaChucVu.getText());
                System.out.println(_tfMaChucVu.getText());
                System.out.println(idChucVu);
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần nhập", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }

        viewChucVu();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if (!_tfMaChucVu.getText().equals("")) {
            if (tlu20ChucVuFindCommon(_tfMaChucVu.getText(), null).size() > 0) {
                int id = tlu20ChucVuFindCommon(_tfMaChucVu.getText(), null).get(0).getIdCv();
                tlu20ChucVuDeletebyId(id);
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, _tfMaChucVu.getText());

            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn danh mục cần xóa", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        viewChucVu();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        viewChucVu();
    }//GEN-LAST:event_jButton21ActionPerformed

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

    private void _tblxemKHTDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblxemKHTDMouseClicked
        int row = _tblxemKHTD.getSelectedRow();
        int id = (int) _tblxemKHTD.getModel().getValueAt(row, 0);
        String khs = (_tblxemKHTD.getModel().getValueAt(row, 1).toString());
        String bophan = (_tblxemKHTD.getModel().getValueAt(row, 3).toString());
        String chucvu = (_tblxemKHTD.getModel().getValueAt(row, 2).toString());

        _tfxemDKTD_KHS.setText(khs);
        _tfxemBoPhan.setText(bophan);
        _tfXemChucVu.setText(chucvu);

        idKhtd = id;

    }//GEN-LAST:event__tblxemKHTDMouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        viewKhtd();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void _tblxemHsuvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblxemHsuvMouseClicked
        int row = _tblxemHsuv.getSelectedRow();
        int id = (int) _tblxemHsuv.getModel().getValueAt(row, 0);
        String mhs = (_tblxemHsuv.getModel().getValueAt(row, 2).toString());
        String khs = (_tblxemHsuv.getModel().getValueAt(row, 1).toString());
        String bophan = (_tblxemHsuv.getModel().getValueAt(row, 3).toString());
        _tfxemHsuvMahs.setText(mhs);
        _tfxemHsuvKhs.setText(khs);
        _tfxemHsuvBoPhan.setText(bophan);

        idHsuv = id;
    }//GEN-LAST:event__tblxemHsuvMouseClicked

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        viewHsuv();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblKqpv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblKqpv.getModel();
        for (Tlu30LichPhongVan lpv : tlu30LpvFindCommon(null, null, null, "1")) {
            model.addRow(new Object[]{lpv.getSoLichPhongVan(), lpv.getKeHoachSo(), lpv.getUngVien()});
        }
        model.fireTableDataChanged();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblKqpv.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblKqpv.getModel();
        for (Tlu30LichPhongVan lpv : tlu30LpvFindCommon(null, null, null, "0")) {
            model.addRow(new Object[]{lpv.getSoLichPhongVan(), lpv.getKeHoachSo(), lpv.getUngVien()});
        }
        model.fireTableDataChanged();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        viewKqpv();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        if (idKhtd > 0) {
            tlu20DktdDeletebyId(idKhtd);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Kế hoạch tuyển dụng trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void _tblxemHsuvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblxemHsuvMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event__tblxemHsuvMouseEntered

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
         if(idLpv > 0) {
             tlu30LpvDelete(idLpv);
         } else {
             JOptionPane.showMessageDialog(rootPane, "Chưa chọn Lịch phỏng vấn trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
         }
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        if (idHsuv > 0) {
            tlu30HsuvDelete(idHsuv);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn Hồ sơ ứng viên trong danh sách", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void _tblLpvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblLpvMouseClicked
        int row = _tblLpv.getSelectedRow();
        int id = (int) _tblLpv.getModel().getValueAt(row, 0);
        String ungVien = (_tblLpv.getModel().getValueAt(row, 3).toString());
        String lpvSo = (_tblLpv.getModel().getValueAt(row, 1).toString());
        String khs = (_tblLpv.getModel().getValueAt(row, 2).toString());
        lpvTenUv.setText(ungVien);
        lpvSolpv.setText(lpvSo);
        lpvKhs.setText(khs);
        idLpv = id;
    }//GEN-LAST:event__tblLpvMouseClicked

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        viewLpv();
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton43ActionPerformed

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
    private javax.swing.JTextField _tfLpvMahs;
    private javax.swing.JTextField _tfLpvTenUngVien;
    private javax.swing.JTextField _tfLpvkhs;
    private javax.swing.JTextField _tfMaBoPhan;
    private javax.swing.JTextField _tfMaChucVu;
    private javax.swing.JTextField _tfMaDktd;
    private javax.swing.JTextField _tfTenBoPhan;
    private javax.swing.JTextField _tfTenChucVu;
    private javax.swing.JTextField _tfTenDktd;
    private javax.swing.JTextField _tfTenDn;
    private javax.swing.JTextField _tfXemChucVu;
    private javax.swing.JTextField _tfxemBoPhan;
    private javax.swing.JTextField _tfxemDKTD_KHS;
    private javax.swing.JTextField _tfxemHsuvBoPhan;
    private javax.swing.JTextField _tfxemHsuvKhs;
    private javax.swing.JTextField _tfxemHsuvMahs;
    private javax.swing.JPanel boPhan;
    private javax.swing.JPanel chucVu;
    private javax.swing.JPanel danhMuc;
    private javax.swing.JPanel danhMucChon;
    private javax.swing.JPanel danhMucLon;
    private com.toedter.calendar.JDateChooser dateTdvh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
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
    private javax.swing.JTextField lpvKhs;
    private javax.swing.JTextField lpvSolpv;
    private javax.swing.JTextField lpvTenUv;
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

    private static java.util.List<service.webservice.Tlu20DieuKienTuyenDung> tlu20DktdFindCommon(java.lang.String tendmdktd, java.lang.String madmdktd) {
        service.webservice.WsTlu20DieuKienTuyenDung_Service service = new service.webservice.WsTlu20DieuKienTuyenDung_Service();
        service.webservice.WsTlu20DieuKienTuyenDung port = service.getWsTlu20DieuKienTuyenDungPort();
        return port.tlu20DktdFindCommon(tendmdktd, madmdktd);
    }
    
    
}
