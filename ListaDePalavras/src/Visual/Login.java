/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;


import java.sql.*;
import javax.swing.JOptionPane;
import listadepalavras.Conexao;

/**
 *
 * @author Baby
 */
public class Login extends javax.swing.JFrame {

    private PreparedStatement psTm;

    private ResultSet rSet;
    private Conexao conetando;

    public Login() {
        initComponents();
        conetando = new Conexao();

    }

    private void fazerLogin() {
        if (user.getText().equals("") || senha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhum campo pode estar vazio", "Aviso!", JOptionPane.ERROR_MESSAGE);
        } else {

            try {
                psTm = conetando.conn.prepareStatement("SELECT * FROM utilizadores WHERE nom_user=? AND senha=?");
                psTm.setString(1, user.getText());
                psTm.setString(2, senha.getText());
                rSet = psTm.executeQuery();
                if (rSet.next()) {
                    TelaPrincipal abrir = new TelaPrincipal();
                    abrir.setVisible(true);
                    this.dispose();
                    conetando.desconectar();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario ou senha invalida");

                }
            } catch (Exception e) {
                e.printStackTrace();

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("FAZER O LOGIN");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 20, 260, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/if_user_male2_172626_1.png"))); // NOI18N
        jLabel3.setText("NOME DE USUARIO");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 230, 170, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/if_revisi_02_2191544.png"))); // NOI18N
        jLabel4.setText("PALAVRA PASSE");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 270, 170, 40);

        user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(user);
        user.setBounds(180, 230, 200, 40);

        senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        senha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(senha);
        senha.setBounds(180, 270, 200, 40);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 310, 170, 60);

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("ENTRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(180, 310, 200, 60);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/login_1.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(190, 100, 130, 128);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/FB_IMG_15280766494938653.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -40, 670, 571);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(487, 409));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "tens a certeza que desejas cancelar?", "FECHANDO!!", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == n) {
            conetando.desconectar();
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fazerLogin();

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     *
     * /*
     * public static void main(String args[]) {
     *
     * try { for (javax.swing.UIManager.LookAndFeelInfo info :
     * javax.swing.UIManager.getInstalledLookAndFeels()) { if
     * ("Nimbus".equals(info.getName())) {
     * javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } }
     * catch (ClassNotFoundException ex) {
     * java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
     * null, ex); } catch (InstantiationException ex) {
     * java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
     * null, ex); } catch (IllegalAccessException ex) {
     * java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
     * null, ex); } catch (javax.swing.UnsupportedLookAndFeelException ex) {
     * java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
     * null, ex); } //</editor-fold>
     *
     *
        java.awt.EventQueue.invokeLater(new Runnable() { public void run() { new
     * Login().setVisible(true); } });
    }
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField senha;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
