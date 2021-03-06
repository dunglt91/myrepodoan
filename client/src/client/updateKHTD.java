/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dunglt.qlns.client.util.ClientUtil;
import dunglt.qlns.client.util.DateTimeUtil;
import dunglt.qlns.client.util.DictItem;
import dunglt.qlns.client.util.ValidateUtil;
import java.awt.*;
import javax.swing.*;
import service.webservice.ParseException_Exception;
import service.webservice.Tlu30KeHoachTuyenDung;

/**
 *
 * @author dunglt
 */
public class updateKHTD extends javax.swing.JFrame {
    /**
     * declare static local variable
     */
        
        private static int stIdKhtd = 0;
    
    /**
     * end declare static local variable
     */
        
        
    /**
     * Creates new form updateKHTD
     */
    public updateKHTD() {
        this.setResizable(false);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        DictItem.setBoPhan(_cbbKhtdBoPhan);
        DictItem.setChucVu(_cbbChucVudktd);
        DictItem.setTDVH(_cbbKhtdTdvh);
    }
    
     public updateKHTD(int idDktd, boolean isUpdateKhtd) {
        stIdKhtd = idDktd;
        this.setResizable(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        DictItem.setBoPhan(_cbbKhtdBoPhan);
        DictItem.setChucVu(_cbbChucVudktd);
        DictItem.setTDVH(_cbbKhtdTdvh);
         if(isUpdateKhtd) {
            Tlu30KeHoachTuyenDung khtd = tlu20KhtdFindById(idDktd);
            if(ValidateUtil.isNotNull(khtd)) {
                _calNgayThem.setCalendar(khtd.getCreatedAt().toGregorianCalendar());
                _calNgayKeHoach.setCalendar(khtd.getNgayKeHoach().toGregorianCalendar());
                _cbbChucVudktd.setSelectedItem(khtd.getChucVu());
                _cbbIsActive.setSelectedItem(ClientUtil.getStringFromIsActive(khtd.isIsActive()));
                _tfKHS.setText(khtd.getKeHoachSo());
                _cbbKhtdBoPhan.setSelectedItem(khtd.getBoPhan());
                _cbbKhtdSex.setSelectedItem(khtd.getGioiTinh());
                _cbbKhtdTdvh.setSelectedItem(khtd.getTrinhDoVanHoa());
                _spSoLuong.setValue(khtd.getSoLuong());
                _spTuoiMax.setValue(khtd.getTuoiMax());
                _spTuoiMin.setValue(khtd.getTuoiMin());
                _taGhiChu.setText(khtd.getGhiChu());
                _tfKhtdCreatedBy.setText(khtd.getCreatedBy());
                _tfKhtdKinhNghiem.setText(khtd.getKinhNghiem());
                _tfKhtdNoiLamViec.setText(khtd.getNoiLamViec());
            } else {
                System.out.println("null");
            }
        }
     }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        _tfKhtdCreatedBy = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        _cbbChucVudktd = new javax.swing.JComboBox();
        _spSoLuong = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        _tfKhtdNoiLamViec = new javax.swing.JTextField();
        _tfKhtdKinhNghiem = new javax.swing.JTextField();
        _tfKHS = new javax.swing.JTextField();
        _calNgayThem = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        _cbbKhtdBoPhan = new javax.swing.JComboBox();
        _cbbKhtdTdvh = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        _spTuoiMax = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        _cbbKhtdSex = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        _spTuoiMin = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        _calNgayKeHoach = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        _cbbIsActive = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        _taGhiChu = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        ukhtdDongY = new javax.swing.JButton();
        ukhtdHuyBo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1150, 741));

        jPanel1.setBackground(new java.awt.Color(224, 230, 237));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(1150, 741));

        jPanel2.setBackground(new java.awt.Color(224, 230, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setText("Người Thêm");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Kê hoạch số");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Chức vụ");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setText("Số lượng");

        _spSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel10.setText("Nơi làm việc");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel13.setText("Kinh nghiệm");

        _calNgayThem.setDateFormatString("dd-MM-yyyy");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Bộ phận");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Ngày thêm");

        jButton1.setBackground(java.awt.Color.gray);
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Cấu hình");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("Trình độ văn hóa");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setText("Đến");

        _spTuoiMax.setModel(new javax.swing.SpinnerNumberModel(18, 18, 65, 1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel12.setText("Giới tính");

        _cbbKhtdSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel11.setText("Đang là nhân viên công ty");

        _spTuoiMin.setModel(new javax.swing.SpinnerNumberModel(18, 18, 65, 1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel8.setText("Tuổi từ");

        _calNgayKeHoach.setDateFormatString("dd-MM-yyyy");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel14.setText("Ngày kế hoạch");

        _cbbIsActive.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Có", "Không" }));
        _cbbIsActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _cbbIsActiveActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel15.setText("Ghi chú");

        _taGhiChu.setColumns(20);
        _taGhiChu.setRows(5);
        _taGhiChu.setPreferredSize(new java.awt.Dimension(240, 300));
        jScrollPane1.setViewportView(_taGhiChu);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setText("Ghi chú");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(217, 217, 217))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)
                                    .addComponent(_tfKhtdCreatedBy)
                                    .addComponent(_tfKHS)
                                    .addComponent(_cbbChucVudktd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(_spSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                                    .addComponent(_tfKhtdNoiLamViec)
                                    .addComponent(_tfKhtdKinhNghiem))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(_cbbKhtdBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                    .addComponent(_calNgayThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(_cbbKhtdTdvh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(_spTuoiMin)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel11)
                                            .addComponent(_cbbIsActive, 0, 304, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(_spTuoiMax)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel12))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(_cbbKhtdSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel14)
                                    .addComponent(_calNgayKeHoach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(_calNgayThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_tfKhtdCreatedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_tfKHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_cbbKhtdBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_cbbChucVudktd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_cbbKhtdTdvh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_spSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_spTuoiMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_spTuoiMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_tfKhtdNoiLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(_cbbIsActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(_cbbKhtdSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_calNgayKeHoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_tfKhtdKinhNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ukhtdDongY.setBackground(new java.awt.Color(52, 79, 223));
        ukhtdDongY.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        ukhtdDongY.setForeground(java.awt.Color.white);
        ukhtdDongY.setText("Đồng Ý");
        ukhtdDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ukhtdDongYActionPerformed(evt);
            }
        });

        ukhtdHuyBo.setBackground(new java.awt.Color(52, 79, 223));
        ukhtdHuyBo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        ukhtdHuyBo.setForeground(java.awt.Color.white);
        ukhtdHuyBo.setText("Hủy Bỏ");
        ukhtdHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ukhtdHuyBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(ukhtdDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(ukhtdHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ukhtdDongY, ukhtdHuyBo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ukhtdDongY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ukhtdHuyBo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1245, 606);
    }// </editor-fold>//GEN-END:initComponents

    private void ukhtdDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukhtdDongYActionPerformed
        int tuoimin, tuoimax;
        tuoimin = ClientUtil.setValueofSpinner(_spTuoiMin);
        tuoimax = ClientUtil.setValueofSpinner(_spTuoiMax);
       
            if (tuoimax > tuoimin) {
                if (ValidateUtil.isNotNull(_tfKhtdCreatedBy.getText())
                        && ValidateUtil.isNotNull(_tfKhtdNoiLamViec) 
                        && ValidateUtil.isNotNull(_tfKhtdKinhNghiem)) {
                    try {

                        if(stIdKhtd == 0) {
                            tlu30KhtdInsert(_tfKhtdCreatedBy.getText(), 
                                DateTimeUtil.convertCalendarToString(_calNgayThem.getCalendar().getTime()),
                                ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbIsActive)),
                                _tfKHS.getText(), 
                                DateTimeUtil.convertCalendarToString(_calNgayKeHoach.getCalendar().getTime()),
                                ClientUtil.setValueofCombobox(_cbbKhtdBoPhan), 
                                ClientUtil.setValueofCombobox(_cbbChucVudktd), 
                                ClientUtil.setValueofCombobox(_cbbKhtdTdvh),
                                ClientUtil.setValueofSpinner(_spSoLuong), 
                                ClientUtil.setValueofCombobox(_cbbKhtdSex), tuoimin, tuoimax,
                                _tfKhtdNoiLamViec.getText(), _tfKhtdKinhNghiem.getText(), 
                                _taGhiChu.getText());
                            JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                        } else {
                            tlu30KhtdUpdateById(stIdKhtd,_tfKhtdCreatedBy.getText(), 
                                DateTimeUtil.convertCalendarToString(_calNgayThem.getCalendar().getTime()),
                                ClientUtil.getBooleanFromIsActiveCbb(ClientUtil.setValueofCombobox(_cbbIsActive)),
                                _tfKHS.getText(),
                                DateTimeUtil.convertCalendarToString(_calNgayKeHoach.getCalendar().getTime()),
                                ClientUtil.setValueofCombobox(_cbbKhtdBoPhan), 
                                ClientUtil.setValueofCombobox(_cbbChucVudktd), 
                                ClientUtil.setValueofCombobox(_cbbKhtdTdvh),
                                ClientUtil.setValueofSpinner(_spSoLuong), 
                                ClientUtil.setValueofCombobox(_cbbKhtdSex), tuoimin, tuoimax,
                                _tfKhtdNoiLamViec.getText(), _tfKhtdKinhNghiem.getText(), 
                                _taGhiChu.getText());
                            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
                        }

                    } catch (Exception ex) {
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Các trường màu đỏ không được bỏ trống");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Tuổi TỪ phải nhỏ hơn tuổi ĐẾN");
            }
    }//GEN-LAST:event_ukhtdDongYActionPerformed

    private void ukhtdHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukhtdHuyBoActionPerformed
       dispose();
    }//GEN-LAST:event_ukhtdHuyBoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TieuChiKHTD().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void _cbbIsActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__cbbIsActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__cbbIsActiveActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser _calNgayKeHoach;
    private com.toedter.calendar.JDateChooser _calNgayThem;
    private javax.swing.JComboBox _cbbChucVudktd;
    private javax.swing.JComboBox _cbbIsActive;
    private javax.swing.JComboBox _cbbKhtdBoPhan;
    private javax.swing.JComboBox _cbbKhtdSex;
    private javax.swing.JComboBox _cbbKhtdTdvh;
    private javax.swing.JSpinner _spSoLuong;
    private javax.swing.JSpinner _spTuoiMax;
    private javax.swing.JSpinner _spTuoiMin;
    private javax.swing.JTextArea _taGhiChu;
    private javax.swing.JTextField _tfKHS;
    private javax.swing.JTextField _tfKhtdCreatedBy;
    private javax.swing.JTextField _tfKhtdKinhNghiem;
    private javax.swing.JTextField _tfKhtdNoiLamViec;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ukhtdDongY;
    private javax.swing.JButton ukhtdHuyBo;
    // End of variables declaration//GEN-END:variables

    private static String tlu30KhtdInsert(java.lang.String createdby, java.lang.String createdat, boolean isactive, java.lang.String kehoachso, java.lang.String ngaykehoach, java.lang.String bophan, java.lang.String chucvu, java.lang.String trinhdovanhoa, int soluong, java.lang.String gioitinh, int tuoimin, int tuoimax, java.lang.String noilamviec, java.lang.String kinhnghiem, java.lang.String ghichu) throws ParseException_Exception {
        service.webservice.WsTLU30KeHoachTuyenDung service = new service.webservice.WsTLU30KeHoachTuyenDung();
        service.webservice.WsTlu30KeHoachTuyenDung port = service.getWsTlu30KeHoachTuyenDungPort();
        return port.tlu30KhtdInsert(createdby, createdat, isactive, kehoachso, ngaykehoach, bophan, chucvu, trinhdovanhoa, soluong, gioitinh, tuoimin, tuoimax, noilamviec, kinhnghiem, ghichu);
    }

    private static Tlu30KeHoachTuyenDung tlu20KhtdFindById(int id) {
        service.webservice.WsTLU30KeHoachTuyenDung service = new service.webservice.WsTLU30KeHoachTuyenDung();
        service.webservice.WsTlu30KeHoachTuyenDung port = service.getWsTlu30KeHoachTuyenDungPort();
        return port.tlu20KhtdFindById(id);
    }

    private static String tlu30KhtdUpdateById(int idkhtd, java.lang.String createdby, java.lang.String createdat, boolean isactive, java.lang.String kehoachso, java.lang.String ngaykehoach, java.lang.String bophan, java.lang.String chucvu, java.lang.String trinhdovanhoa, int soluong, java.lang.String gioitinh, int tuoimin, int tuoimax, java.lang.String noilamviec, java.lang.String kinhnghiem, java.lang.String ghichu) throws ParseException_Exception {
        service.webservice.WsTLU30KeHoachTuyenDung service = new service.webservice.WsTLU30KeHoachTuyenDung();
        service.webservice.WsTlu30KeHoachTuyenDung port = service.getWsTlu30KeHoachTuyenDungPort();
        return port.tlu30KhtdUpdateById(idkhtd, createdby, createdat, isactive, kehoachso, ngaykehoach, bophan, chucvu, trinhdovanhoa, soluong, gioitinh, tuoimin, tuoimax, noilamviec, kinhnghiem, ghichu);
    }
}
