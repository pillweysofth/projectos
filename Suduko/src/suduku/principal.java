/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package suduku;

import com.formdev.flatlaf.*;

/**
 *
 * @author Pacheco Gomes
 */
public class principal extends javax.swing.JFrame {

   private int nivel;
    
   public principal() {
        initComponents();
        botao.setVisible(false);
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selc = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        b1 = new javax.swing.JRadioButton();
        b2 = new javax.swing.JRadioButton();
        b3 = new javax.swing.JRadioButton();
        b4 = new javax.swing.JRadioButton();
        botao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUDUKU");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECIONE O NÍVEL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel2.setOpaque(false);

        selc.add(b1);
        b1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        b1.setForeground(new java.awt.Color(102, 102, 102));
        b1.setText("FÁCIL");
        b1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                b1ItemStateChanged(evt);
            }
        });
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        selc.add(b2);
        b2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        b2.setForeground(new java.awt.Color(102, 102, 102));
        b2.setText("MÉDIO");
        b2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                b1ItemStateChanged(evt);
            }
        });

        selc.add(b3);
        b3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        b3.setForeground(new java.awt.Color(102, 102, 102));
        b3.setText("DIFÍICL");
        b3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                b1ItemStateChanged(evt);
            }
        });

        selc.add(b4);
        b4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        b4.setForeground(new java.awt.Color(102, 102, 102));
        b4.setText("SUPER DÍFICIL");
        b4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                b1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(b1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b4))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(230, 170, 161, 145);

        botao.setBackground(new java.awt.Color(0, 102, 102));
        botao.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        botao.setForeground(new java.awt.Color(153, 153, 0));
        botao.setText("JOGAR");
        botao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoActionPerformed(evt);
            }
        });
        jPanel1.add(botao);
        botao.setBounds(110, 130, 113, 44);

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("SUDUKU");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 10, 180, 50);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-330, -120, 1060, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoActionPerformed
        suduku jogar=new suduku(nivel);
        jogar.setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoActionPerformed

    private void b1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_b1ItemStateChanged
       nivel=0;
       if(b1.isSelected()){
           nivel=30;
       }else if(b2.isSelected()){
           nivel=40;
       }else if(b3.isSelected()){
           nivel=55;
       }else if(b4.isSelected()){
           nivel=60;
       }
       botao.setVisible(true);
       
    }//GEN-LAST:event_b1ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton b1;
    private javax.swing.JRadioButton b2;
    private javax.swing.JRadioButton b3;
    private javax.swing.JRadioButton b4;
    private javax.swing.JButton botao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.ButtonGroup selc;
    // End of variables declaration//GEN-END:variables
}
