/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import listadepalavras.*;

/**
 *
 * @author Baby
 */
public class Registarus extends javax.swing.JFrame {

   private Conexao conetando;
    private Usuario utilizador;

    public Registarus() {
        initComponents();
        utilizador = new Usuario();
        conetando = new Conexao();
        preencherTabela();
        jButton5.setVisible(false);
    }

    private void registarUsuarios() {

        if (nomCompl.getText().equals("") || idadeUs.getText().equals("") || usuario.getText().equals("")
                || sexo.getSelectedIndex() == 0 || senha1.getText().equals("") || senha2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "verifica os campos de entrada pois nenhum pode estar vazio");
        } else if (senha1.getText().equals(senha2.getText())) {
            utilizador = new Usuario();
            utilizador.setIdade(Integer.parseInt(idadeUs.getText()));
            utilizador.setNome(nomCompl.getText());
            utilizador.setSexo(sexo.getSelectedItem().toString());
            utilizador.setSenha(senha1.getText());
            utilizador.setUser(usuario.getText());
            utilizador.inserir(utilizador);
            preencherTabela();
            nomCompl.setText("");
            idadeUs.setText("");
            usuario.setText("");
            sexo.setSelectedIndex(0);
            senha1.setText("");
            senha2.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "A senha digitada no campo 1 nao é identica ao do campo 2");
        }
    }
    private void registarUsuariosAlterado() {

        if (nomCompl.getText().equals("") || idadeUs.getText().equals("") || usuario.getText().equals("")
                || sexo.getSelectedIndex() == 0 || senha1.getText().equals("") || senha2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "verifica os campos de entrada pois nenhum pode estar vazio");
        } else if (senha1.getText().equals(senha2.getText())) {
            utilizador = new Usuario();
            utilizador.setId((int) tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 0));
            utilizador.setIdade(Integer.parseInt(idadeUs.getText()));
            utilizador.setNome(nomCompl.getText());
            utilizador.setSexo(sexo.getSelectedItem().toString());
            utilizador.setSenha(senha1.getText());
            utilizador.setUser(usuario.getText());
            utilizador.alterar(utilizador);
            preencherTabela();
            nomCompl.setText("");
            idadeUs.setText("");
            usuario.setText("");
            sexo.setSelectedIndex(0);
            senha1.setText("");
            senha2.setText("");
            jButton5.setVisible(false);
            jButton2.setVisible(true);
            jButton1.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "A senha digitada no campo 1 nao é identica ao do campo 2");
        }
    }

    private void preencherTabela() {
        DefaultTableModel novo = new DefaultTableModel() {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        ResultSet reSet;
        Usuario util = new Usuario();
        novo.addColumn("ID");
        novo.addColumn("NOME COMPLETO");
        novo.addColumn("USUARIO");
        novo.addColumn("IDADE");
        novo.addColumn("SEXO");
        reSet = util.buscar();
        try {
            while (reSet.next()) {
                novo.addRow(new Object[]{reSet.getInt("id_usuario"), reSet.getString("nom_compl"),
                    reSet.getString("nom_user"), reSet.getInt("idade"), reSet.getString("sexo")});

            }
        } catch (SQLException ex) {
               }
        tabUsuarios.setModel(novo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        nomCompl = new javax.swing.JTextField();
        idadeUs = new javax.swing.JTextField();
        usuario = new javax.swing.JTextField();
        sexo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        senha1 = new javax.swing.JPasswordField();
        senha2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUsuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        nomCompl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomCompl.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 255, 255)));
        jPanel1.add(nomCompl);
        nomCompl.setBounds(10, 140, 150, 30);

        idadeUs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idadeUs.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 255, 255)));
        jPanel1.add(idadeUs);
        idadeUs.setBounds(170, 140, 90, 30);

        usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 255, 255)));
        jPanel1.add(usuario);
        usuario.setBounds(280, 140, 170, 30);

        sexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleciona o sexo", "Masculino", "Femenino" }));
        sexo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(sexo);
        sexo.setBounds(10, 230, 170, 30);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome completo");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 110, 120, 30);

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Idade");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 110, 70, 30);

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Senha");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(220, 200, 120, 30);

        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Digite a senha Novamente");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 200, 190, 30);

        jLabel5.setBackground(new java.awt.Color(204, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nome de usuario");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 110, 150, 30);

        senha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        senha1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), null));
        jPanel1.add(senha1);
        senha1.setBounds(190, 230, 170, 30);

        senha2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        senha2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), null));
        jPanel1.add(senha2);
        senha2.setBounds(390, 230, 190, 30);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("FECHAR");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(0, 490, 120, 50);

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("SALVAR");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(120, 490, 130, 50);

        tabUsuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabUsuariosMouseClicked(evt);
            }
        });
        tabUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabUsuariosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabUsuarios);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 280, 690, 200);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/if_Survey_rating_rate-23_3790693.png"))); // NOI18N
        jButton3.setText("EDITAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/trash-bin.png"))); // NOI18N
        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(420, 500, 250, 40);

        jButton5.setBackground(new java.awt.Color(153, 255, 153));
        jButton5.setText("SALVAR ALTERADO");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(260, 490, 130, 50);

        jLabel7.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("REGISTAR UTILIZADORES");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 20, 630, 50);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/if_user-group_285648_1.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(510, 70, 140, 130);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/photo-1508896080210-93c377eb4135.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 690, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(694, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 setVisible(false);
        conetando.desconectar();

 

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabUsuariosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabUsuariosKeyTyped

    }//GEN-LAST:event_tabUsuariosKeyTyped

    private void tabUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabUsuariosMouseClicked
        int cont = evt.getClickCount();
        if (cont == 2) {
            Object[] escolha = {"ELIMINAR", "EDITAR"};
            Object menu;

            menu = JOptionPane.showInputDialog(null, "voce selecionou o utilizador "
                    + tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 1), "selecionando", JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
            if (menu == escolha[0]) {
                int resposta = JOptionPane.showConfirmDialog(null, "Tensa a certeza que desejas eliminar o utilizador "
                        + tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 1), "ELIMINANDO!", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_NO_OPTION) {
                    utilizador.excluir((int) tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 0));
                }
            } else if (menu == escolha[1]) {

               
                nomCompl.setText("" + tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 1));
                idadeUs.setText("" + tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 3));
                usuario.setText("" + tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 2));
                if (tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 4).equals("Masculino")) {
                    sexo.setSelectedIndex(1);
                } else {
                    sexo.setSelectedIndex(2);
                }

                senha1.setText("nnnnnn");
                senha2.setText("hhhhhh");
                jButton5.setVisible(true);
                jButton2.setVisible(false);
                jButton1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tabUsuariosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registarUsuarios();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
registarUsuariosAlterado();       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(null, "Para editar seleciona na tabela com  duplo clique o funcionario que desejas eliminar");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          JOptionPane.showMessageDialog(null, "Para eliminar seleciona na tabela com  duplo clique o funcionario que desejas eliminar");
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JTextField idadeUs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomCompl;
    private javax.swing.JPasswordField senha1;
    private javax.swing.JPasswordField senha2;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JTable tabUsuarios;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
