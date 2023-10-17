/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package suduku;

import javax.swing.JFrame;

/**
 *
 * @author MR-STUDIOS
 */
public class Ganhou extends javax.swing.JDialog {

    private int nivel;
    private JFrame rec;

    /**
     * Creates new form Ganhou
     */
    public Ganhou(java.awt.Frame parent, boolean modal,String tempo,int pontos) {
        super(parent, modal);
        initComponents();
        painelR.setVisible(false);
        rec = (JFrame) parent;
        this.tempo.setText(tempo);
        this.pontos.setText(""+pontos);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tempo = new javax.swing.JLabel();
        pontos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bNovo = new javax.swing.JButton();
        painelR = new javax.swing.JPanel();
        b1 = new javax.swing.JRadioButton();
        b2 = new javax.swing.JRadioButton();
        b3 = new javax.swing.JRadioButton();
        b4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Victoria");
        setModal(true);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("JOGO TERMINADO!!");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(80, 0, 110, 30);

        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("PONTOS");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(110, 50, 50, 30);

        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("TEMPO FEITO:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 30, 80, 30);

        tempo.setForeground(new java.awt.Color(255, 102, 102));
        tempo.setText("00:00:00");
        jPanel2.add(tempo);
        tempo.setBounds(80, 30, 80, 30);

        pontos.setForeground(new java.awt.Color(255, 102, 102));
        pontos.setText("00");
        jPanel2.add(pontos);
        pontos.setBounds(70, 50, 30, 30);

        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("OBTEVE:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 50, 80, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 270, 90);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus_math_25px.png"))); // NOI18N
        bNovo.setToolTipText("Novo jogo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });
        jPanel3.add(bNovo);
        bNovo.setBounds(10, 10, 40, 40);

        painelR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECIONE O NÍVEL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 8), new java.awt.Color(0, 153, 153))); // NOI18N
        painelR.setOpaque(false);

        buttonGroup1.add(b1);
        b1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        b1.setForeground(new java.awt.Color(225, 102, 102));
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

        buttonGroup1.add(b2);
        b2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        b2.setForeground(new java.awt.Color(225, 102, 102));
        b2.setText("MÉDIO");
        b2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                b1ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(b3);
        b3.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        b3.setForeground(new java.awt.Color(225, 102, 102));
        b3.setText("DIFÍICL");
        b3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                b1ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(b4);
        b4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        b4.setForeground(new java.awt.Color(225, 102, 102));
        b4.setText("SUPER DÍFICIL");
        b4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                b1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelRLayout = new javax.swing.GroupLayout(painelR);
        painelR.setLayout(painelRLayout);
        painelRLayout.setHorizontalGroup(
            painelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        painelRLayout.setVerticalGroup(
            painelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRLayout.createSequentialGroup()
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(painelR);
        painelR.setBounds(130, 10, 130, 110);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(-10, 90, 270, 130);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/photo-1508896080210-93c377eb4135.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-26, -16, 320, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_b1ItemStateChanged
        nivel = 0;
        if (b1.isSelected()) {
            nivel = 30;
            bNovo.setEnabled(true);
            bNovo.setToolTipText("Jogar");
        } else if (b2.isSelected()) {
            nivel = 40;
            bNovo.setEnabled(true);
            bNovo.setToolTipText("Jogar");
        } else if (b3.isSelected()) {
            nivel = 55;
            bNovo.setEnabled(true);
            bNovo.setToolTipText("Jogar");
        } else if (b4.isSelected()) {
            nivel = 60;
            bNovo.setEnabled(true);
            bNovo.setToolTipText("Jogar");
        }


    }//GEN-LAST:event_b1ItemStateChanged

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        //TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed

        if (bNovo.getToolTipText().equals("Jogar")) {
            suduku outro = new suduku(nivel);
            outro.setVisible(true);
            dispose();
            rec.dispose();
        } else {
            painelR.setVisible(true);
            bNovo.setEnabled(false);
        }
    }//GEN-LAST:event_bNovoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton b1;
    private javax.swing.JRadioButton b2;
    private javax.swing.JRadioButton b3;
    private javax.swing.JRadioButton b4;
    private javax.swing.JButton bNovo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel painelR;
    private javax.swing.JLabel pontos;
    private javax.swing.JLabel tempo;
    // End of variables declaration//GEN-END:variables
}