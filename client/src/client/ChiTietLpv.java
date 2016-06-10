/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import dunglt.qlns.client.constant.Constant;
import dunglt.qlns.client.util.ClientUtil;
import dunglt.qlns.client.util.DictItem;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import service.webservice.Tlu30Chitietdktd;
import service.webservice.Tlu30Chitietketquavpv;
/**
 *
 * @author dunglt
 */
public class ChiTietLpv extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietLpv
     */
    int idChiTietDktd;
    public ChiTietLpv() {
        this.setResizable(false);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        _cbbHSUV.addItem(Constant.BLANK);
        DictItem.setMHS(_cbbHSUV);
        viewChiTietKqpv();
        viewChiTietDKTD();
    }
    
     public void viewChiTietKqpv() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblketqua.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblketqua.getModel();
        for (Tlu30Chitietketquavpv chitietdktd 
                : tlu30ChitietketquavpvFindCommon(
                        ClientUtil.setValueofCombobox(_cbbHSUV),
                        _tfMa.getText(), 
                         _tfTen.getText(),
                        _tfDiemCanDat.getText(), 
                        _tfDiemDatDuoc.getText())) {
            model.addRow(new Object[]{chitietdktd.getMadkpv(), chitietdktd.getTendkpv(), chitietdktd.getMachitietdmkqpv(), chitietdktd.getDiemcandat(), chitietdktd.getDiemdatduoc()});
        }
        model.fireTableDataChanged();
    }
     
     public void viewChiTietDKTD() {
        DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblChiTietdktd.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblChiTietdktd.getModel();
        for (Tlu30Chitietdktd chitietdktd : tlu30ChitietdktddDisplayAll()) {
            model.addRow(new Object[]{chitietdktd.getMachitietdktd(), chitietdktd.getTenchitietdktd(), chitietdktd.getKehoachtuyendung(), chitietdktd.getDiemcandat()});
        }
        model.fireTableDataChanged();
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
        jLabel3 = new javax.swing.JLabel();
        _tfMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        _tfTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        _tfDiemCanDat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        _tfDiemDatDuoc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        _cbbHSUV = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        _tblChiTietdktd = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        _tblketqua = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 230, 237));

        jPanel2.setBackground(new java.awt.Color(224, 230, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Mã điều kiện tuyển dụng");

        _tfMa.setBackground(java.awt.Color.white);
        _tfMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tfMaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Tên điều kiện tuyển dụng");

        _tfTen.setBackground(java.awt.Color.white);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Điểm cần đạt");

        _tfDiemCanDat.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setText("Điểm đạt được");

        _tfDiemDatDuoc.setBackground(java.awt.Color.white);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Mã hồ sơ");

        _cbbHSUV.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addGap(126, 126, 126))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(_tfDiemDatDuoc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfDiemCanDat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfTen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tfMa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_cbbHSUV, javax.swing.GroupLayout.Alignment.LEADING, 0, 219, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_cbbHSUV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tfMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tfDiemCanDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tfDiemDatDuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(224, 230, 237));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), null));

        jButton25.setBackground(new java.awt.Color(52, 79, 223));
        jButton25.setForeground(java.awt.Color.white);
        jButton25.setText("tìm kiếm");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
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

        jButton23.setBackground(new java.awt.Color(52, 79, 223));
        jButton23.setForeground(java.awt.Color.white);
        jButton23.setText("sửa");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(52, 79, 223));
        jButton22.setForeground(java.awt.Color.white);
        jButton22.setText("Thêm");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(224, 230, 237));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách chi tiết kế hoạch tuyển dụng"), null));

        _tblChiTietdktd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã điều kiện tuyển dụng", "Tên điều kiện tuyển dụng", "Kế hoạch số", "Điểm cẩn đạt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblChiTietdktd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblChiTietdktdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(_tblChiTietdktd);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        JTableHeader anHeader = _tblChiTietdktd.getTableHeader();
        anHeader.setBackground(new Color(0).cyan);
        anHeader.setForeground(new Color(0).red);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(224, 230, 237));
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách chi tiết lịch phỏng vấn"), null));

        _tblketqua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã điều kiện tuyển dụng", "Tên điều kiện tuyển dung", "Mã hồ sơ", "Điểm cần đạt", "Điểm đạt được"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _tblketqua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _tblketquaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(_tblketqua);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        JTableHeader anHeader1 = _tblketqua.getTableHeader();
        anHeader1.setBackground(new Color(0).cyan);
        anHeader1.setForeground(new Color(0).red);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)))
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 998, 664);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if (!_tfDiemCanDat.getText().equals(Constant.BLANK)) {
            tlu30ChitietketquavpvInsert(
                    _tfTen.getText(), 
                    _tfMa.getText(), 
                    ClientUtil.setValueofCombobox(_cbbHSUV), 
                    Float.parseFloat(_tfDiemCanDat.getText()), 
                    Float.parseFloat(_tfDiemDatDuoc.getText()));
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa nhập điểm đạt được", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void _tblketquaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblketquaMouseClicked
         int row = _tblketqua.getSelectedRow();
        String machitietvpv = (_tblketqua.getModel().getValueAt(row, 0).toString());
        String mahoso = (_tblketqua.getModel().getValueAt(row, 2).toString());
        java.util.List<Tlu30Chitietketquavpv> lstchitiet = tlu30ChitietketquavpvFindCommon(mahoso, machitietvpv, null, null, null);

        _tfTen.setText(lstchitiet.get(0).getTendkpv());
        _tfMa.setText(lstchitiet.get(0).getMadkpv());

        _tfDiemCanDat.setText(lstchitiet.get(0).getDiemcandat() + Constant.BLANK);
        _tfDiemDatDuoc.setText(lstchitiet.get(0).getDiemdatduoc() + Constant.BLANK);
        _cbbHSUV.setSelectedItem(lstchitiet.get(0).getMachitietdmkqpv());
       
    }//GEN-LAST:event__tblketquaMouseClicked

    private void _tblChiTietdktdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__tblChiTietdktdMouseClicked
        int row = _tblChiTietdktd.getSelectedRow();
        String maDktd = (_tblChiTietdktd.getModel().getValueAt(row, 0).toString());
        String KHS = (_tblChiTietdktd.getModel().getValueAt(row, 2).toString());
        java.util.List<Tlu30Chitietdktd> lstchitiet = tlu30ChitietdktdFindCommon(KHS, maDktd, null);

        _tfTen.setText(lstchitiet.get(0).getTenchitietdktd());
        _tfMa.setText(lstchitiet.get(0).getMachitietdktd());
        idChiTietDktd = lstchitiet.get(0).getId();
        _tfDiemCanDat.setText(lstchitiet.get(0).getDiemcandat() + Constant.BLANK);
        _tfDiemDatDuoc.setText("");
        _cbbHSUV.setSelectedItem(null);
    }//GEN-LAST:event__tblChiTietdktdMouseClicked

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        viewChiTietKqpv();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void _tfMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tfMaActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietLpv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietLpv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietLpv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietLpv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietLpv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox _cbbHSUV;
    private javax.swing.JTable _tblChiTietdktd;
    private javax.swing.JTable _tblketqua;
    private javax.swing.JTextField _tfDiemCanDat;
    private javax.swing.JTextField _tfDiemDatDuoc;
    private javax.swing.JTextField _tfMa;
    private javax.swing.JTextField _tfTen;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private static String tlu30ChitietketquavpvInsert(java.lang.String tendkpv, java.lang.String madkpv, java.lang.String machitietdmkqpv, float diemcandat, float diemdatduoc) {
        service.webservice.WSTLU30CHITIETKQVPV_Service service = new service.webservice.WSTLU30CHITIETKQVPV_Service();
        service.webservice.WSTLU30CHITIETKQVPV port = service.getWSTLU30CHITIETKQVPVPort();
        return port.tlu30ChitietketquavpvInsert(tendkpv, madkpv, machitietdmkqpv, diemcandat, diemdatduoc);
    }

    private static java.util.List<service.webservice.Tlu30Chitietketquavpv> tlu30ChitietketquavpvFindCommon(java.lang.String machitietdmkqpv, java.lang.String madkpv, java.lang.String tendkpv, java.lang.String diemcandat, java.lang.String diemdatduoc) {
        service.webservice.WSTLU30CHITIETKQVPV_Service service = new service.webservice.WSTLU30CHITIETKQVPV_Service();
        service.webservice.WSTLU30CHITIETKQVPV port = service.getWSTLU30CHITIETKQVPVPort();
        return port.tlu30ChitietketquavpvFindCommon(machitietdmkqpv, madkpv, tendkpv, diemcandat, diemdatduoc);
    }

    private static java.util.List<service.webservice.Tlu30Chitietdktd> tlu30ChitietdktddDisplayAll() {
        service.webservice.WSTLU30CHITIETDKTD_Service service = new service.webservice.WSTLU30CHITIETDKTD_Service();
        service.webservice.WSTLU30CHITIETDKTD port = service.getWSTLU30CHITIETDKTDPort();
        return port.tlu30ChitietdktddDisplayAll();
    }

    private static java.util.List<service.webservice.Tlu30Chitietdktd> tlu30ChitietdktdFindCommon(java.lang.String kehoachtuyendung, java.lang.String machitietdktd, java.lang.String tenchitietdktd) {
        service.webservice.WSTLU30CHITIETDKTD_Service service = new service.webservice.WSTLU30CHITIETDKTD_Service();
        service.webservice.WSTLU30CHITIETDKTD port = service.getWSTLU30CHITIETDKTDPort();
        return port.tlu30ChitietdktdFindCommon(kehoachtuyendung, machitietdktd, tenchitietdktd);
    }
}
