/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.webservice.Tlu30Chitietketquavpv;
import service.webservice.Tlu30HoSoUngVien;

/**
 *
 * @author dunglt
 */
public class ChiTietKqpv extends javax.swing.JFrame {
    public static String stHsuv;
    /**
     * Creates new form ChiTietKqpv
     */
    public ChiTietKqpv() {
        initComponents();
    }
    
     public ChiTietKqpv(String mhs) {
        stHsuv = mhs;
        this.setResizable(false);
        initComponents();
        viewChiTietDKTD();
    }
    
    public void viewChiTietDKTD() {
         DefaultTableModel model = new DefaultTableModel();
        ((DefaultTableModel) _tblChiTietKq.getModel()).setNumRows(0);
        model = (DefaultTableModel) this._tblChiTietKq.getModel();
        for (Tlu30Chitietketquavpv chitietdktd  : tlu30ChitietketquavpvFindCommon( stHsuv, null, null, null, null) ) {
            List<Tlu30HoSoUngVien> hoSoUngViens = new ArrayList<>();
            hoSoUngViens = findbyMaHoSo(stHsuv);
            model.addRow(new Object[]{hoSoUngViens.get(0).getHoTen(),chitietdktd.getTendkpv(), chitietdktd.getDiemcandat(), chitietdktd.getDiemdatduoc()});
        }
        model.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        _tblChiTietKq = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        _tblChiTietKq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên ứng viên", "Tên điều kiện tuyển dụng", "Điểm cần đạt", "Điểm đạt được"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(_tblChiTietKq);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ChiTietKqpv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietKqpv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietKqpv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietKqpv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietKqpv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable _tblChiTietKq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<service.webservice.Tlu30Chitietketquavpv> tlu30ChitietketquavpvFindCommon(java.lang.String machitietdmkqpv, java.lang.String madkpv, java.lang.String tendkpv, java.lang.String diemcandat, java.lang.String diemdatduoc) {
        service.webservice.WSTLU30CHITIETKQVPV_Service service = new service.webservice.WSTLU30CHITIETKQVPV_Service();
        service.webservice.WSTLU30CHITIETKQVPV port = service.getWSTLU30CHITIETKQVPVPort();
        return port.tlu30ChitietketquavpvFindCommon(machitietdmkqpv, madkpv, tendkpv, diemcandat, diemdatduoc);
    }

    private static java.util.List<service.webservice.Tlu30HoSoUngVien> findbyMaHoSo(java.lang.String mhs) {
        service.webservice.WsTlu30HoSoUngVien_Service service = new service.webservice.WsTlu30HoSoUngVien_Service();
        service.webservice.WsTlu30HoSoUngVien port = service.getWsTlu30HoSoUngVienPort();
        return port.findbyMaHoSo(mhs);
    }
}
