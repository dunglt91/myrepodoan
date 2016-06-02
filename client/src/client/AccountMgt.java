/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dunglt.qlns.client.constant.Constant;
import dunglt.qlns.client.util.ClientUtil;
import dunglt.qlns.client.util.ValidateUtil;
import javax.swing.*;
import java.awt.*;
import service.webservice.Tlu20DangNhap;

/**
 *
 * @author dunglt
 */
public class AccountMgt extends javax.swing.JFrame {
    public static String uName;
    public static boolean stUpdate = false;
    /**
     * Creates new form AccountMgt
     */
    public AccountMgt() {
        initComponents();
    }
    
    public AccountMgt(boolean isUpdateUser, String Uname) {
        initComponents();
        stUpdate = isUpdateUser;
        uName = Uname;
        Tlu20DangNhap dangNhap = tLu20DangNhapFindUser(uName);
        _tfUserName.setText(Uname);
        _tfUserName.disable();
        _cbRole.setSelectedItem(dangNhap.getRole());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("/home/dunglt/NetBeansProjects/client/trong.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        _tfUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        _pfRePass = new javax.swing.JPasswordField();
        _pfPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        _cbRole = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setText("Tên đăng nhập");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Mật khẩu");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Nhập lại mật khẩu");

        jButton1.setBackground(new java.awt.Color(67, 66, 213));
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Đồng ý");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(67, 66, 213));
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("Hủy bỏ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Quyền");

        _cbRole.setBackground(java.awt.Color.white);
        _cbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "user" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(_tfUserName)
                            .addComponent(_pfRePass)
                            .addComponent(_pfPass)
                            .addComponent(_cbRole, 0, 363, Short.MAX_VALUE))))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_pfRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(22, 22, 22))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("stupdate" + stUpdate);
        if(stUpdate) {
            if(ValidateUtil.isNotNull(_pfPass.getText()) || ValidateUtil.isNotNull(_pfRePass.getText())) {
                if(!_pfRePass.getText().equals(_pfPass.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Nhập lại mật khẩu và mật khẩu phải trùng nhau", "warning", JOptionPane.ERROR_MESSAGE);
                }

                else {
                    
                    String mess = Constant.BLANK;
                    mess = tlu20DangNhapUpdate(uName, _pfPass.getText() , _pfRePass.getText(), ClientUtil.setValueofCombobox(_cbRole));
                    System.out.println("messs " + mess);
                    if(mess.equals(Constant.SUCCESS)) {
                        JOptionPane.showConfirmDialog(rootPane, "cập nhật thành công");
                    }
                }
            } else {
                String mess = Constant.BLANK;
                Tlu20DangNhap dangNhap = tLu20DangNhapFindUser(uName);
                mess = tlu20DangNhapUpdate(uName, dangNhap.getPasswords() , dangNhap.getPasswords(), ClientUtil.setValueofCombobox(_cbRole));
                    System.out.println("messs " + mess);
                    if(mess.equals(Constant.SUCCESS)) {
                        JOptionPane.showConfirmDialog(rootPane, "cập nhật thành công");
                    }
            }
        } else {
            if(!_tfUserName.getText().equals(Constant.BLANK)) {
                Tlu20DangNhap dangNhap = tLu20DangNhapFindUser(_tfUserName.getText());
                if(ValidateUtil.isNull(dangNhap)) {
                    if(ValidateUtil.isNotNull(_pfPass.getText())) {
                        if(_pfRePass.getText().equals(_pfPass.getText())) {
                            
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Nhập lại mật khẩu và mật khẩu phải trùng nhau", "warning", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Mật khẩu không được để trống", "warning", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập không đã tồn tại", "warning", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                
                JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập không được để trống", "warning", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox _cbRole;
    private javax.swing.JPasswordField _pfPass;
    private javax.swing.JPasswordField _pfRePass;
    private javax.swing.JTextField _tfUserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton uhsuvDongY;
    // End of variables declaration//GEN-END:variables

    private static Tlu20DangNhap tLu20DangNhapFindUser(java.lang.String user) {
        service.webservice.WsDangNhap_Service service = new service.webservice.WsDangNhap_Service();
        service.webservice.WsDangNhap port = service.getWsDangNhapPort();
        return port.tLu20DangNhapFindUser(user);
    }

    private static String tlu20DangNhapInsert(java.lang.String username, java.lang.String pass, java.lang.String repass, java.lang.String role) {
        service.webservice.WsDangNhap_Service service = new service.webservice.WsDangNhap_Service();
        service.webservice.WsDangNhap port = service.getWsDangNhapPort();
        return port.tlu20DangNhapInsert(username, pass, repass, role);
    }

    private static String tlu20DangNhapUpdate(java.lang.String username, java.lang.String pass, java.lang.String repass, java.lang.String role) {
        service.webservice.WsDangNhap_Service service = new service.webservice.WsDangNhap_Service();
        service.webservice.WsDangNhap port = service.getWsDangNhapPort();
        return port.tlu20DangNhapUpdate(username, pass, repass, role);
    }
    
}
