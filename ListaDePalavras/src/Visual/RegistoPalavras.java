/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import listadepalavras.Conexao;
import listadepalavras.Palavras;

/**
 *
 * @author Baby
 */
public class RegistoPalavras extends javax.swing.JFrame {

    private Conexao conetando;
    private Palavras gerir;

    public RegistoPalavras() {
        initComponents();
        conetando = new Conexao();
        gerir = new Palavras();
        preenchendoTabela();
    }

    private void PersonalizarTabela() {

        tCasamento.getColumnModel().getColumn(0).setMinWidth(15);
        tCasamento.getColumnModel().getColumn(0).setPreferredWidth(29);
        tCasamento.getColumnModel().getColumn(0).setMaxWidth(25);
        tCasamento.getColumnModel().getColumn(0).setHeaderValue("ID");
        tCasamento.getColumnModel().getColumn(1).setHeaderValue("CASAMENTO");
         tAmor.getColumnModel().getColumn(0).setMinWidth(15);
        tAmor.getColumnModel().getColumn(0).setPreferredWidth(29);
        tAmor.getColumnModel().getColumn(0).setMaxWidth(25);
        tAmor.getColumnModel().getColumn(0).setHeaderValue("ID");
        tAmor.getColumnModel().getColumn(1).setHeaderValue("AMOR");

    }

    private void preenchendoTabela() {
        DefaultTableModel novoC= new DefaultTableModel() {
            boolean[] canEdit = new boolean[]{false,false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        DefaultTableModel novoA= new DefaultTableModel() {
            boolean[] canEdit = new boolean[]{false,false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        ResultSet reSet;
        PreparedStatement prSt;

        novoC.addColumn("ID");
        novoC.addColumn("CASAMENTO");
        novoA.addColumn("ID");
        novoA.addColumn("AMOR");

        try {
            prSt = conetando.conn.prepareStatement("SELECT * FROM casamento ORDER BY id_casa");
            reSet = prSt.executeQuery();
            while (reSet.next()) {
                novoC.addRow(new Object[]{reSet.getInt("id_casa"), reSet.getString("pal_cas")});

            }
            prSt = conetando.conn.prepareStatement("SELECT * FROM amor ORDER BY id_amor");
            reSet = prSt.executeQuery();
            while (reSet.next()) {
                novoA.addRow(new Object[]{reSet.getInt("id_amor"), reSet.getString("pal_amor")});

            }

            tAmor.setModel(novoA);
            tCasamento.setModel(novoC);
            PersonalizarTabela();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    private void registarPalavras() {
        if (palavras.getText().equals("")||txAutor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo de texto nao pode estar vazio", "Aviso!", JOptionPane.ERROR_MESSAGE);
        } else if (grupo.isSelected(null)) {
            JOptionPane.showMessageDialog(null, "Seleciona o Tipo de Palavra que deseja inserir", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Palavras inserir = new Palavras();
            if (casamento.isSelected()) {
                inserir.inserirCas(palavras.getText(),txAutor.getText());
            } else {
                inserir.inserirAmor(palavras.getText(),txAutor.getText());
            }
            preenchendoTabela();
            palavras.setText("");
            grupo.clearSelection();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        casamento = new javax.swing.JRadioButton();
        amor = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCasamento = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tAmor = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        palavras = new javax.swing.JTextPane();
        txAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(null);

        grupo.add(casamento);
        casamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        casamento.setText("CASAMENTO");
        jPanel1.add(casamento);
        casamento.setBounds(20, 140, 130, 23);

        grupo.add(amor);
        amor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        amor.setText("AMOR");
        jPanel1.add(amor);
        amor.setBounds(160, 140, 90, 23);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("FECHAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(0, 300, 120, 60);

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("SALVAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(130, 300, 110, 60);

        tCasamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tCasamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tCasamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tCasamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tCasamento);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 170, 270, 120);

        jLabel2.setBackground(new java.awt.Color(101, 10, 10));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INSERIR PALAVRAS");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 0, 320, 40);

        tAmor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tAmor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tAmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tAmorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tAmor);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(270, 170, 280, 120);

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/if_Survey_rating_rate-23_3790693.png"))); // NOI18N
        jButton3.setText("EDITAR");

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/trash-bin.png"))); // NOI18N
        jButton4.setText("ELIMINAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(330, 300, 210, 30);

        palavras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        palavras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane4.setViewportView(palavras);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(10, 50, 360, 90);
        jPanel1.add(txAutor);
        txAutor.setBounds(370, 90, 180, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("AUTOR");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(400, 40, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Lotus Flower.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-40, -80, 640, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(551, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       setVisible(false);
       
        conetando.desconectar();
      
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registarPalavras();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tCasamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCasamentoMouseClicked
        int cont = evt.getClickCount();
        if (cont == 2) {
            System.out.println("nm " + tAmor.getRowCount());
            Object[] escolha = {"ELIMINAR", "EDITAR"};
            Object menu;

            menu = JOptionPane.showInputDialog(null, "voce selecionou o utilizador "
                    + tCasamento.getValueAt(tCasamento.getSelectedRow(), 1), "selecionando", JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
            if (menu == escolha[0]) {
                int resposta = JOptionPane.showConfirmDialog(null, "Tensa a certeza que desejas eliminar o texto: "
                        + tCasamento.getValueAt(tCasamento.getSelectedRow(), 1) + "?", "ELIMINANDO!", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_NO_OPTION) {
                    gerir.excluirCas((int) tCasamento.getValueAt(tCasamento.getSelectedRow(), 0));
                    preenchendoTabela();
                }
            } else if (menu == escolha[1]) {

                palavras.setText("" + tCasamento.getValueAt(tCasamento.getSelectedRow(), 0));
                // jButton5.setVisible(true);
                //jButton2.setVisible(false);
                //jButton1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tCasamentoMouseClicked

    private void tAmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tAmorMouseClicked
        int cont = evt.getClickCount();
        if (cont == 2) {
            Object[] escolha = {"ELIMINAR", "EDITAR"};
            Object menu;

            menu = JOptionPane.showInputDialog(null, "voce selecionou o utilizador "
                    + tAmor.getValueAt(tAmor.getSelectedRow(), 1), "selecionando", JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
            if (menu == escolha[0]) {
                int resposta = JOptionPane.showConfirmDialog(null, "Tensa a certeza que desejas eliminar o texto: "
                        + tAmor.getValueAt(tAmor.getSelectedRow(), 1) + "?", "ELIMINANDO!", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_NO_OPTION) {
                    gerir.excluirAmor((int) tAmor.getValueAt(tAmor.getSelectedRow(), 0));
                    preenchendoTabela();
                }
            } else if (menu == escolha[1]) {

                palavras.setText("" + tAmor.getValueAt(tAmor.getSelectedRow(), 0));
                // jButton5.setVisible(true);
                jButton2.setVisible(false);
                jButton1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tAmorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton amor;
    private javax.swing.JRadioButton casamento;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane palavras;
    private javax.swing.JTable tAmor;
    private javax.swing.JTable tCasamento;
    private javax.swing.JTextField txAutor;
    // End of variables declaration//GEN-END:variables
}
