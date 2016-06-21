/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dunglt.qlns.client.constant.Constant;
import dunglt.qlns.client.util.ClientUtil;
import dunglt.qlns.client.util.DateTimeUtil;
import dunglt.qlns.client.util.DictItem;
import dunglt.qlns.client.util.ValidateUtil;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import service.webservice.ParseException_Exception;
import service.webservice.Tlu30HoSoUngVien;
import service.webservice.Tlu30LichPhongVan;

/**
 *
 * @author dunglt
 */
public class updateLPV extends javax.swing.JFrame {
    public static int stIdLpv = 0;
    /**
     * Creates new form updateLPV
     */
    public updateLPV() {
        this.setResizable(false);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        DictItem.setTenAndMaHs(_cbbUngVienhsuv);
        DictItem.setKhs(_cbbKeHoachTuyenDungLPV);
    }
    
    public updateLPV(boolean isUpdateLpv, int idLpv) {
        stIdLpv = idLpv;
        this.setResizable(false);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        DictItem.setTenAndMaHs(_cbbUngVienhsuv);
        DictItem.setKhs(_cbbKeHoachTuyenDungLPV);
        
        if(idLpv > 0) {
            Tlu30LichPhongVan lpv = tlu30LpvFindById(idLpv);
            if(ValidateUtil.isNotNull(lpv)) {
                _cbDangLaNhanVienCongTyLPV
                        .setSelectedItem(ClientUtil.getStringFromIsActive(lpv.isIsActive()));
                ClientUtil.checkIsPass(_cbDatYeuCauLPV, lpv.isDatYeuCau());
                _cbbKeHoachTuyenDungLPV.setSelectedItem(lpv.getKeHoachSo());
                _cbbUngVienhsuv.setSelectedItem(lpv.getUngVien());
                _clLichhen.setCalendar(lpv.getLichHen().toGregorianCalendar());
                _clNgayThem.setCalendar(lpv.getCreatedAt().toGregorianCalendar());
                _textariaNhanXetLPV.setText(lpv.getNhanXet());
                _tfNguoiNhapLPV.setText(lpv.getCreatedBy());
                _tfNguoiPhuTrachPhongVanLPV.setText(lpv.getPhuTrachPhongVan());
                _tfPhongVanSoLPV.setText(ClientUtil.convertIntoString(lpv.getSoLichPhongVan()));
                _tfTinhTrangPhongVan.setText(lpv.getTinhTrangPhongVan());
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

        jPanel14 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        _tfNguoiNhapLPV = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        _clNgayThem = new com.toedter.calendar.JDateChooser();
        jLabel44 = new javax.swing.JLabel();
        _cbDangLaNhanVienCongTyLPV = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        _tfPhongVanSoLPV = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        _tfNguoiPhuTrachPhongVanLPV = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        _tfTinhTrangPhongVan = new javax.swing.JTextField();
        lpvChiTiet = new javax.swing.JButton();
        _cbDatYeuCauLPV = new javax.swing.JCheckBox();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        _textariaNhanXetLPV = new javax.swing.JTextArea();
        jLabel51 = new javax.swing.JLabel();
        _clLichhen = new com.toedter.calendar.JDateChooser();
        _cbbUngVienhsuv = new javax.swing.JComboBox();
        _cbbKeHoachTuyenDungLPV = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel14.setBackground(new java.awt.Color(224, 230, 237));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel42.setText("Người thêm");

        _tfNguoiNhapLPV.setBackground(java.awt.Color.white);

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel43.setText("Ngày thêm");

        _clNgayThem.setBackground(java.awt.Color.white);
        _clNgayThem.setDateFormatString("dd-MM-yyyy");

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel44.setText("Đang là nhân viên công ty");

        _cbDangLaNhanVienCongTyLPV.setBackground(java.awt.Color.white);
        _cbDangLaNhanVienCongTyLPV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Có", "Không" }));
        _cbDangLaNhanVienCongTyLPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _cbDangLaNhanVienCongTyLPVActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel45.setText("Ứng viên");

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel46.setText("Kế hoạch số");

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel47.setText("Số lịch phỏng vấn");

        jLabel48.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel48.setText("Người phụ trách phỏng vấn");

        _tfNguoiPhuTrachPhongVanLPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tfNguoiPhuTrachPhongVanLPVActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel49.setText("Tình trạng phỏng vấn");

        lpvChiTiet.setBackground(new java.awt.Color(88, 111, 129));
        lpvChiTiet.setForeground(java.awt.Color.white);
        lpvChiTiet.setText("Chi tiết");
        lpvChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpvChiTietActionPerformed(evt);
            }
        });

        _cbDatYeuCauLPV.setBackground(java.awt.Color.white);
        _cbDatYeuCauLPV.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        _cbDatYeuCauLPV.setText("Đạt");

        jLabel50.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel50.setText("Nhận xét");

        _textariaNhanXetLPV.setColumns(20);
        _textariaNhanXetLPV.setRows(5);
        jScrollPane7.setViewportView(_textariaNhanXetLPV);

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel51.setText("Lịch hẹn");

        _clLichhen.setBackground(java.awt.Color.white);
        _clLichhen.setDateFormatString("dd-MM-yyyy");

        _cbbUngVienhsuv.setBackground(java.awt.Color.white);

        _cbbKeHoachTuyenDungLPV.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(392, 392, 392)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(729, 729, 729))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(_clNgayThem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(_cbDangLaNhanVienCongTyLPV, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(_tfNguoiPhuTrachPhongVanLPV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                        .addComponent(_tfPhongVanSoLPV, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel46)
                                        .addComponent(jLabel49)
                                        .addComponent(_cbbKeHoachTuyenDungLPV, 0, 427, Short.MAX_VALUE)
                                        .addComponent(_cbbUngVienhsuv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(_tfNguoiNhapLPV)
                                        .addComponent(_tfTinhTrangPhongVan))
                                    .addComponent(jLabel50))
                                .addGap(30, 30, 30)
                                .addComponent(_clLichhen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(_cbDatYeuCauLPV, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lpvChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel42)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addGap(2, 2, 2)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_tfNguoiNhapLPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_clNgayThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_cbDangLaNhanVienCongTyLPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_cbbUngVienhsuv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_tfPhongVanSoLPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(_tfNguoiPhuTrachPhongVanLPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel48))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel51)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_clLichhen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lpvChiTiet)
                                .addComponent(_cbDatYeuCauLPV))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(2, 2, 2)
                        .addComponent(_cbbKeHoachTuyenDungLPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel49)
                        .addGap(2, 2, 2)
                        .addComponent(_tfTinhTrangPhongVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(73, 101, 195));
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Đồng ý");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(73, 101, 195));
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("Hủy bỏ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(jButton2)
                .addGap(386, 386, 386))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(301, 301, 301))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        setBounds(0, 0, 935, 506);
    }// </editor-fold>//GEN-END:initComponents

    private void lpvChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpvChiTietActionPerformed
        new ChiTietLpv().setVisible(true);
    }//GEN-LAST:event_lpvChiTietActionPerformed

    private void _tfNguoiPhuTrachPhongVanLPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfNguoiPhuTrachPhongVanLPVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tfNguoiPhuTrachPhongVanLPVActionPerformed

    public boolean isNullMaHoSo(String mahs) {
        boolean isNullMhs = false;
        int count = 0;
        if(displayAll().size() > 0) {
            for(Tlu30HoSoUngVien hsuv : displayAll()) {
                if(mahs.equalsIgnoreCase(hsuv.getHoTen())) {
                    count ++;
                }
            }
            
            if(count == 0) {
                isNullMhs = true;
            }
        }
        return isNullMhs;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (ValidateUtil.isNotNull(_tfNguoiNhapLPV.getText())
                && ValidateUtil.isNotNull(_tfPhongVanSoLPV.getText())
                && ValidateUtil.isNotNull(_tfNguoiPhuTrachPhongVanLPV.getText())
                && ValidateUtil.isNotNull(_tfNguoiPhuTrachPhongVanLPV.getText())) {
                int solichphongvan = Integer.parseInt(_tfPhongVanSoLPV.getText());
                if(stIdLpv == 0) {
                    if (tlu30LpvFindbySoLPV(solichphongvan).isEmpty()) {
                        if(isNullMaHoSo(ClientUtil.setValueofCombobox(_cbbUngVienhsuv))) {
                            try {
                                String res = Constant.BLANK;
                                res = tlu30LpvInsert(_tfNguoiNhapLPV.getText(), 
                                        DateTimeUtil.convertCalendarToString(_clNgayThem.getCalendar().getTime()),
                                        ClientUtil.getBooleanFromIsActiveCbb(
                                        ClientUtil.setValueofCombobox(_cbDangLaNhanVienCongTyLPV)), 
                                        ClientUtil.setValueofCombobox(_cbbUngVienhsuv),
                                        ClientUtil.setValueofCombobox(_cbbKeHoachTuyenDungLPV), 
                                        solichphongvan, 
                                        DateTimeUtil.convertCalendarToString(_clLichhen.getCalendar().getTime()),
                                        _tfNguoiPhuTrachPhongVanLPV.getText(), 
                                        _tfTinhTrangPhongVan.getText(), 
                                        ClientUtil.isactiveCheckBox(_cbDatYeuCauLPV), 
                                        _textariaNhanXetLPV.getText());
                               if(res.equalsIgnoreCase("inserted")) {
                                   JOptionPane.showMessageDialog(rootPane, "Thêm mới thành công");
                               }
                        
                            } catch (Exception e) {}
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Đã tồn mã hồ sơ ứng viên");
                        }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Đã tồn tại số lịch phỏng vấn");
                }
             } else {
                    try {
                        String res = Constant.BLANK;
                        res = tlu30LpvUpdate(stIdLpv, _tfNguoiNhapLPV.getText(),
                                DateTimeUtil.convertCalendarToString(_clNgayThem.getCalendar().getTime()),
                                ClientUtil.getBooleanFromIsActiveCbb(
                                ClientUtil.setValueofCombobox(_cbDangLaNhanVienCongTyLPV)), 
                                ClientUtil.setValueofCombobox(_cbbUngVienhsuv),
                                ClientUtil.setValueofCombobox(_cbbKeHoachTuyenDungLPV),
                                solichphongvan, 
                                DateTimeUtil.convertCalendarToString(_clLichhen.getCalendar().getTime()),
                                _tfNguoiPhuTrachPhongVanLPV.getText(),
                                _tfTinhTrangPhongVan.getText(),
                                ClientUtil.isactiveCheckBox(_cbDatYeuCauLPV), 
                                _textariaNhanXetLPV.getText());
                        if(res.equalsIgnoreCase("updated")) {
                            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công" );
                        }
                                
                    } catch (ParseException_Exception ex) {
                        Logger.getLogger(updateLPV.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

        } else {
            JOptionPane.showMessageDialog(rootPane, "chưa điền đủ thông tin");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void _cbDangLaNhanVienCongTyLPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__cbDangLaNhanVienCongTyLPVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__cbDangLaNhanVienCongTyLPVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updateLPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateLPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateLPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateLPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateLPV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox _cbDangLaNhanVienCongTyLPV;
    private javax.swing.JCheckBox _cbDatYeuCauLPV;
    private javax.swing.JComboBox _cbbKeHoachTuyenDungLPV;
    private javax.swing.JComboBox _cbbUngVienhsuv;
    private com.toedter.calendar.JDateChooser _clLichhen;
    private com.toedter.calendar.JDateChooser _clNgayThem;
    private javax.swing.JTextArea _textariaNhanXetLPV;
    private javax.swing.JTextField _tfNguoiNhapLPV;
    private javax.swing.JTextField _tfNguoiPhuTrachPhongVanLPV;
    private javax.swing.JTextField _tfPhongVanSoLPV;
    private javax.swing.JTextField _tfTinhTrangPhongVan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton lpvChiTiet;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<service.webservice.Tlu30LichPhongVan> tlu30LpvFindbySoLPV(int soLpv) {
        service.webservice.WsTlu30LichPhongVan_Service service = new service.webservice.WsTlu30LichPhongVan_Service();
        service.webservice.WsTlu30LichPhongVan port = service.getWsTlu30LichPhongVanPort();
        return port.tlu30LpvFindbySoLPV(soLpv);
    }

    private static String tlu30LpvInsert(java.lang.String createdBy, java.lang.String createdAt, boolean isActive, java.lang.String ungVien, java.lang.String keHoachSo, int soLichPhongVan, java.lang.String lichHen, java.lang.String phuTrachPhongVan, java.lang.String tinhTrangPhongVan, boolean datYeuCau, java.lang.String nhanXet) throws ParseException_Exception {
        service.webservice.WsTlu30LichPhongVan_Service service = new service.webservice.WsTlu30LichPhongVan_Service();
        service.webservice.WsTlu30LichPhongVan port = service.getWsTlu30LichPhongVanPort();
        return port.tlu30LpvInsert(createdBy, createdAt, isActive, ungVien, keHoachSo, soLichPhongVan, lichHen, phuTrachPhongVan, tinhTrangPhongVan, datYeuCau, nhanXet);
    }

    private static Tlu30LichPhongVan tlu30LpvFindById(int id) {
        service.webservice.WsTlu30LichPhongVan_Service service = new service.webservice.WsTlu30LichPhongVan_Service();
        service.webservice.WsTlu30LichPhongVan port = service.getWsTlu30LichPhongVanPort();
        return port.tlu30LpvFindById(id);
    }

    private static String tlu30LpvUpdate(int idLpv, java.lang.String createdBy, java.lang.String createdAt, boolean isActive, java.lang.String ungVien, java.lang.String keHoachSo, int soLichPhongVan, java.lang.String lichHen, java.lang.String phuTrachPhongVan, java.lang.String tinhTrangPhongVan, boolean datYeuCau, java.lang.String nhanXet) throws ParseException_Exception {
        service.webservice.WsTlu30LichPhongVan_Service service = new service.webservice.WsTlu30LichPhongVan_Service();
        service.webservice.WsTlu30LichPhongVan port = service.getWsTlu30LichPhongVanPort();
        return port.tlu30LpvUpdate(idLpv, createdBy, createdAt, isActive, ungVien, keHoachSo, soLichPhongVan, lichHen, phuTrachPhongVan, tinhTrangPhongVan, datYeuCau, nhanXet);
    }

    private static java.util.List<service.webservice.Tlu30HoSoUngVien> displayAll() {
        service.webservice.WsTlu30HoSoUngVien_Service service = new service.webservice.WsTlu30HoSoUngVien_Service();
        service.webservice.WsTlu30HoSoUngVien port = service.getWsTlu30HoSoUngVienPort();
        return port.displayAll();
    }
}
