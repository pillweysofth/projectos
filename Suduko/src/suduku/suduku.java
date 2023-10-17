/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package suduku;

import control.Tempo;
import java.awt.*;

import java.awt.event.*;
import java.util.Random;
import java.util.regex.*;
import javax.swing.*;

/**
 *
 * @author Pacheco Gomes
 */
public final class suduku extends javax.swing.JFrame {

    /**
     * Matriz #completo que armazena os dados do jogo de forma ja rezolvida para
     * a posterior verificaçao com os dados que seram itroduzidos pelo jogador
     *
     */
    private void tempo(){
        Tempo ini=new Tempo(tempo);
       cron=new Thread(ini);
        cron.start();
        
    }
    private Thread cron;
    private final int[][] completo;

    /**
     * Metodo £iniciar responsavel por gerar numeros aleatoriamente pra nossa
     * matriz do tipo 9x9 de forma sequencial tendo em conta as regras do jogo
     */
    private boolean iniciar(int[][] matriz) {

        for (int linha = 0; linha < 9; linha++) {

            for (int coluna = 0; coluna < 9; coluna++) {
                /**
                 * A condiçao a baixo verifica a posiçao do elemento da matriz
                 * que estiver a ser inserida para que na primeira iteraçao seja
                 * introduzido numeros totalmente aleatorios atravez da classe
                 * randomica Esta primeira iteraçao sera responsavel por
                 * condizir todo o destino do jogo
                 *
                 */
                if (matriz[linha][coluna] == 0) {

                    Random alea = new Random();

                    if (linha == 0) {
                        while (true) {

                            int num = alea.nextInt(9) + 1;
                            /**
                             * a condiçao a baixo faz uma chamada do metodo
                             * verificar numero que recebe parametros 1 a matriz
                             * que esta a ser inserida os dados 2 a linha em
                             * questao 3 a coluna em questao 4 o numero a ser
                             * inserido caso forem validados entao so assim sera
                             * feita a insersao
                             *
                             */
                            if (verificar_num(matriz, linha, coluna, num)) {
                                matriz[linha][coluna] = num;

                                if (iniciar(matriz)) {
                                    return true;

                                } else {
                                    //caso nao passe na verificaçao sera dado o palor padrao de 0
                                    matriz[linha][coluna] = 0;

                                }

                            }
                        }

                    } else {
                        /**
                         * Apos a inserçao da primeira coluna da matriz que sera
                         * introduzidos dados totalmente aleatorio na coluna
                         * posterior sera intro duzino numero sequenciais de 1 a
                         * 9 desde que respeitem a condicionante do jogo
                         *
                         *
                         */
                        for (int num = 1; num < 10; num++) {
                            if (verificar_num(matriz, linha, coluna, num)) {
                                matriz[linha][coluna] = num;

                                if (iniciar(matriz)) {
                                    return true;

                                } else {
                                    matriz[linha][coluna] = 0;

                                }

                            }
                        }
                        return false;
                    }

                }
            }
        }
        return true;
    }

    /**
     * Metodo #verificar_num serve para determinar se o numero que
     * aleartoriamento foi gerado pelo nossa variavel randomico servira e
     * respeitara a regra do jogo em caso de verdade retorna como verdadeiro *
     */
    private boolean verificar_num(int[][] matriz, int linha, int coluna, int num) {
        /**
         * Nesse primeiro ciclo sera feita a verificaçao de todas as linas e
         * colunas que fazem o ponto de intercensao com a posiçao na matriz do
         * valor a ser inserido
         *
         */
        for (int i = 0; i < 9; i++) {
            if (matriz[linha][i] == num || matriz[i][coluna] == num) {
                return false;
            }
        }
        /**
         * nesse ponto sera repartido as poziçoes do elemento que esteja a ser
         * inserido na matriz e sera repartita a matriz para que fique apenas
         * 3x3 para verificaçao dos quadranqtes necessessarios
         *
         */
        int cLinha = linha - linha % 3;
        int cColuna = coluna - coluna % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[cLinha + i][cColuna + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
//metodo que verifica se os valor introduzidos pelo usuario considem
    //com os valores na matriz se sim vitoria para o ususario

    private void testar() {
        int numero;
        for (int i = 1; i < 10; i++) {
            numero = 0;
            for (Component ax : painel1.getComponents()) {
                JPanel ad = (JPanel) ax;
                for (Component adic : ad.getComponents()) {
                    JTextField pa = (JTextField) adic;
                    if (pa.getText().equals("" + i)) {
                        numero++;
                    }

                }
            }
             if (numero == 9) {
                for (Component ax : painel2.getComponents()) {

                    JButton pa = (JButton) ax;
                    if (pa.getText().equals("" + i)) {
                        pa.setBackground(Color.GREEN);
                        pa.setEnabled(false);

                    }
                }

            }
        }

    }

    private boolean ganhou() {
        boolean val = true;
        for (int i = 0; i < painel1.getComponents().length; i++) {
            JPanel var = (JPanel) painel1.getComponent(i);
            for (int j = 0; j < var.getComponents().length; j++) {
                JTextField test = (JTextField) var.getComponent(j);
                if (test.isEditable()) {
                    if (test.getText().equals("" + completo[i][j])) {

                        test.setForeground(new java.awt.Color(0, 51, 255));

                    } else {

                        test.setForeground(new java.awt.Color(255, 0, 51));

                        val = false;
                    }
                }
            }

        }
        if (val) {
            cron.interrupt();
            vitoria();
        }
        return val;
    }
//metodo que sera chamado pelo metodo ganhou para fim de efeitos de animaçao

    private void vitoria() {
        for (Component ax : painel1.getComponents()) {
            JPanel ad = (JPanel) ax;
            for (Component adic : ad.getComponents()) {
                JTextField pa = (JTextField) adic;
                pa.setEditable(false);
                pa.setBackground(new java.awt.Color(0, 102, 102));
                pa.setForeground(new java.awt.Color(0, 0, 0));
                pa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            }
        }
        JOptionPane.showMessageDialog(null, "PARABENS!! \n VOCÊ GANHOU!!!", "JOGO TERMINADO!", JOptionPane.INFORMATION_MESSAGE);
        Ganhou p = new Ganhou(this,true,tempo.getText(),3456);
        p.setVisible(true);
        dispose();
           }
//metodo que conta quantos quadrantes tem o valor zero e determina que nivel o usuario escolheu

    private int contar() {
        int cont = 0;
        for (int i = 0; i < painel1.getComponents().length; i++) {
            JPanel var = (JPanel) painel1.getComponent(i);
            for (int j = 0; j < var.getComponents().length; j++) {
                JTextField test = (JTextField) var.getComponent(j);
                if (test.getText().equals("0")) {
                    cont++;
                }
            }
        }
        if (cont <= 30) {
            label.setText("NÍVEL SUPER FÁCIL ");
        } else if (cont > 30 && cont <= 40) {
            label.setText("NÍVEL FÁCIL ");
        } else if (cont > 40 && cont <= 55) {
            label.setText("NÍVEL DIFÍCIL ");
        } else if (cont > 55) {
            label.setText("NÍVEL SUPER DIFÍCIL ");
        }
        return cont;
    }

    /**
     * Metodo pra passar para o jogo os dados recebendo da matriz
     *
     * @param matriz
     */
    private void preencher(int[][] matriz) {
        int i = 0;

        for (Component com : painel1.getComponents()) {

            JPanel val = (JPanel) com;
            int j = 0;
            for (Component pas : val.getComponents()) {

                JTextField passar = (JTextField) pas;
                passar.setText("" + matriz[i][j]);
                passar.setBackground(new java.awt.Color(204, 204, 204));
                passar.setEditable(false);
                //passar.setFocusable(false);
                passar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                j++;

            }

            i++;
        }

    }

    /**
     * *
     * metodo que recebe um inteiro que define o nivel de difilcudades tendo em
     * conta o nivel remove os dados
     *
     * @param num
     */
    private void removerP(int num) {
        Random remo = new Random();

        for (int i = num; i > 0; i--) {
            int linha = remo.nextInt(9);
            int coluna = remo.nextInt(9);
            JPanel rem = (JPanel) painel1.getComponent(linha);
            JTextField tex = (JTextField) rem.getComponent(coluna);
            if (!tex.getText().equals("0")) {
                tex.setText("0");
                tex.setEditable(true);
                //tex.setFocusable(true);
                tex.setBackground(new java.awt.Color(255, 255, 255));
                tex.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

            } else {
                i++;
            }
        }
    }

    private void imprimir(int matriz[][]) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
            if ((i + 1) % 3 == 0 && i != 0) {
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
            }

        }

    }

    /**
     * *
     * metodo string que remove todo caracter indroduzido pelo usuario e que
     * acita apenas digitos, ou seja, numero
     *
     * @param entrada
     * @return
     */
    private String removeCaracters(String entrada) {
        Pattern numericos = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher encaixe = numericos.matcher(entrada);
        StringBuffer saida = new StringBuffer();
        while (encaixe.find()) {
            saida.append(encaixe.group());
        }
        return saida.toString();
    }

    private String limite(String entrada) {
        StringBuffer saida = new StringBuffer();
        char[] caracteres = removeCaracters(entrada).toCharArray();
        try {
            if (caracteres[caracteres.length - 1] != '0') {
                return "" + caracteres[caracteres.length - 1];

            } else {

                return "" + caracteres[0];
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "0";
        }
    }

    private void normal() {
        for (Component ax : painel1.getComponents()) {
            JPanel ad = (JPanel) ax;
            for (Component adic : ad.getComponents()) {
                JTextField pa = (JTextField) adic;
                if (!pa.getText().equals("0") && !pa.isEditable()) {
                    pa.setBackground(new java.awt.Color(204, 204, 204));
                    pa.setForeground(new java.awt.Color(0, 0, 0));

                } else {
                    pa.setBackground(new java.awt.Color(255, 255, 255));
                    pa.setForeground(new java.awt.Color(0, 0, 0));

                }
            }
        }
    }

    private void per_Co(JTextField um) {
        normal();

        for (int i = 0; i < painel1.getComponents().length; i++) {

            JPanel ad = (JPanel) painel1.getComponent(i);
            for (int j = 0; j < ad.getComponents().length; j++) {

                JTextField pa = (JTextField) ad.getComponent(j);

                if (um == pa) {
                    int lina = i, coluna = j;
                    for (int p = 0; p < 9; p++) {
                        JPanel ado = (JPanel) painel1.getComponent(lina);
                        JTextField pao = (JTextField) ado.getComponent(p);
                        pao.setBackground(new java.awt.Color(120, 131, 141));

                        ado = (JPanel) painel1.getComponent(p);
                        pao = (JTextField) ado.getComponent(coluna);
                        pao.setBackground(new java.awt.Color(120, 131, 141));
                    }
                    int cLinha = lina - lina % 3;
                    int cColuna = coluna - coluna % 3;
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {

                            JPanel ado = (JPanel) painel1.getComponent(cLinha + a);
                            JTextField pao = (JTextField) ado.getComponent(cColuna + b
                            );
                            pao.setBackground(new java.awt.Color(120, 131, 141));
                        }
                    }
                }
                if (!um.isEditable()) {

                    if (pa.getText().equals(um.getText())) {
                        pa.setBackground(new java.awt.Color(0, 153, 153));
                        pa.setForeground(new java.awt.Color(0, 51, 255));

                    }
                }
            }
        }
    }

    /**
     * *
     * metodo que passa parar os TextFied os eventos do Teclado e do Mouse
     */
    private void eventosBT() {

        for (int i = 0; i < painel2.getComponents().length; i++) {
            for (Component ax : painel1.getComponents()) {
                JPanel ad = (JPanel) ax;
                for (Component adic : ad.getComponents()) {
                    JTextField pa = (JTextField) adic;
                    JButton adn = (JButton) painel2.getComponent(i);
                    adn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent envt) {
                            
                            if (pa.isFocusOwner() && pa.isEditable()) {
                                pa.setText("" + adn.getText());
                                ganhou();
                                testar();
                            }
                        }
                    });
                }

            }
        }

    }

    private void eventos() {

        for (Component ax : painel1.getComponents()) {
            JPanel ad = (JPanel) ax;
            for (Component adic : ad.getComponents()) {
                JTextField pa = (JTextField) adic;

                pa.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {

                        per_Co(pa);
                    }
                });
                pa.addKeyListener(new KeyListener() {

                    @Override
                    public void keyTyped(KeyEvent e) {
                        pa.setText(limite(pa.getText()));
                        ganhou();
                        testar();
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        pa.setText(limite(pa.getText()));
                        ganhou();
                        testar();
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        pa.setText(limite(pa.getText()));
                        ganhou();
                        testar();
                    }

                });
            }
        }
    }

    public suduku(int nivel) {
        initComponents();
        completo = new int[9][9];
        iniciar(completo);
        preencher(completo);
        removerP(nivel);
        eventos();
        contar();
        eventosBT();
        testar();
        tempo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel1 = new javax.swing.JPanel();
        q00 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        q9 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        q10 = new javax.swing.JPanel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        q11 = new javax.swing.JPanel();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        q12 = new javax.swing.JPanel();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        q13 = new javax.swing.JPanel();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        q14 = new javax.swing.JPanel();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        q15 = new javax.swing.JPanel();
        jTextField64 = new javax.swing.JTextField();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jTextField70 = new javax.swing.JTextField();
        jTextField71 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        q16 = new javax.swing.JPanel();
        jTextField82 = new javax.swing.JTextField();
        jTextField83 = new javax.swing.JTextField();
        jTextField84 = new javax.swing.JTextField();
        jTextField85 = new javax.swing.JTextField();
        jTextField86 = new javax.swing.JTextField();
        jTextField87 = new javax.swing.JTextField();
        jTextField88 = new javax.swing.JTextField();
        jTextField89 = new javax.swing.JTextField();
        jTextField90 = new javax.swing.JTextField();
        painel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        tempo = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUDUKU");
        setResizable(false);

        painel1.setLayout(null);

        q00.setMaximumSize(new java.awt.Dimension(100, 100));
        q00.setMinimumSize(new java.awt.Dimension(100, 100));
        q00.setPreferredSize(new java.awt.Dimension(100, 100));
        q00.setLayout(null);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        q00.add(jTextField1);
        jTextField1.setBounds(0, 0, 30, 30);

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("0");
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        q00.add(jTextField6);
        jTextField6.setBounds(30, 0, 30, 30);

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0");
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q00.add(jTextField8);
        jTextField8.setBounds(60, 0, 30, 30);

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0");
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q00.add(jTextField3);
        jTextField3.setBounds(90, 0, 30, 30);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("0");
        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q00.add(jTextField4);
        jTextField4.setBounds(120, 0, 30, 30);

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("0");
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q00.add(jTextField5);
        jTextField5.setBounds(150, 0, 30, 30);

        jTextField9.setBackground(new java.awt.Color(120, 131, 141));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");
        jTextField9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q00.add(jTextField9);
        jTextField9.setBounds(180, 0, 30, 30);

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0");
        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q00.add(jTextField7);
        jTextField7.setBounds(210, 0, 30, 30);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0");
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q00.add(jTextField2);
        jTextField2.setBounds(240, 0, 30, 30);

        painel1.add(q00);
        q00.setBounds(0, 0, 270, 30);

        q9.setMaximumSize(new java.awt.Dimension(100, 100));
        q9.setMinimumSize(new java.awt.Dimension(100, 100));
        q9.setLayout(null);

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("0");
        jTextField10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });
        q9.add(jTextField10);
        jTextField10.setBounds(0, 0, 30, 30);

        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("0");
        jTextField11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
        });
        q9.add(jTextField11);
        jTextField11.setBounds(30, 0, 30, 30);

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("0");
        jTextField12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField12.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q9.add(jTextField12);
        jTextField12.setBounds(60, 0, 30, 30);

        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("0");
        jTextField13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q9.add(jTextField13);
        jTextField13.setBounds(90, 0, 30, 30);

        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("0");
        jTextField14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField14.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q9.add(jTextField14);
        jTextField14.setBounds(120, 0, 30, 30);

        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("0");
        jTextField15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField15.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q9.add(jTextField15);
        jTextField15.setBounds(150, 0, 30, 30);

        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("0");
        jTextField16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q9.add(jTextField16);
        jTextField16.setBounds(180, 0, 30, 30);

        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("0");
        jTextField17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField17.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q9.add(jTextField17);
        jTextField17.setBounds(210, 0, 30, 30);

        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setText("0");
        jTextField18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField18.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q9.add(jTextField18);
        jTextField18.setBounds(240, 0, 30, 30);

        painel1.add(q9);
        q9.setBounds(0, 30, 270, 30);

        q10.setMaximumSize(new java.awt.Dimension(100, 100));
        q10.setMinimumSize(new java.awt.Dimension(100, 100));
        q10.setLayout(null);

        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setText("0");
        jTextField19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField19.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField19KeyPressed(evt);
            }
        });
        q10.add(jTextField19);
        jTextField19.setBounds(0, 0, 30, 30);

        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setText("0");
        jTextField20.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField20.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField20KeyPressed(evt);
            }
        });
        q10.add(jTextField20);
        jTextField20.setBounds(30, 0, 30, 30);

        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setText("0");
        jTextField21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        jTextField21.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q10.add(jTextField21);
        jTextField21.setBounds(60, 0, 30, 30);

        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setText("0");
        jTextField22.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField22.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q10.add(jTextField22);
        jTextField22.setBounds(90, 0, 30, 30);

        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setText("0");
        jTextField23.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField23.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q10.add(jTextField23);
        jTextField23.setBounds(120, 0, 30, 30);

        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setText("0");
        jTextField24.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        jTextField24.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q10.add(jTextField24);
        jTextField24.setBounds(150, 0, 30, 30);

        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setText("0");
        jTextField25.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField25.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q10.add(jTextField25);
        jTextField25.setBounds(180, 0, 30, 30);

        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setText("0");
        jTextField26.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField26.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q10.add(jTextField26);
        jTextField26.setBounds(210, 0, 30, 30);

        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setText("0");
        jTextField27.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField27.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q10.add(jTextField27);
        jTextField27.setBounds(240, 0, 30, 30);

        painel1.add(q10);
        q10.setBounds(0, 60, 270, 30);

        q11.setMaximumSize(new java.awt.Dimension(100, 100));
        q11.setMinimumSize(new java.awt.Dimension(100, 100));
        q11.setLayout(null);

        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField28.setText("0");
        jTextField28.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField28.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField28KeyPressed(evt);
            }
        });
        q11.add(jTextField28);
        jTextField28.setBounds(0, 0, 30, 30);

        jTextField29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField29.setText("0");
        jTextField29.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField29.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField29KeyPressed(evt);
            }
        });
        q11.add(jTextField29);
        jTextField29.setBounds(30, 0, 30, 30);

        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setText("0");
        jTextField30.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField30.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q11.add(jTextField30);
        jTextField30.setBounds(60, 0, 30, 30);

        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setText("0");
        jTextField31.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField31.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q11.add(jTextField31);
        jTextField31.setBounds(90, 0, 30, 30);

        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setText("0");
        jTextField32.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField32.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q11.add(jTextField32);
        jTextField32.setBounds(120, 0, 30, 30);

        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setText("0");
        jTextField33.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField33.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q11.add(jTextField33);
        jTextField33.setBounds(150, 0, 30, 30);

        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setText("0");
        jTextField34.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField34.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q11.add(jTextField34);
        jTextField34.setBounds(180, 0, 30, 30);

        jTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField35.setText("0");
        jTextField35.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField35.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q11.add(jTextField35);
        jTextField35.setBounds(210, 0, 30, 30);

        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setText("0");
        jTextField36.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField36.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q11.add(jTextField36);
        jTextField36.setBounds(240, 0, 30, 30);

        painel1.add(q11);
        q11.setBounds(0, 90, 270, 30);

        q12.setMaximumSize(new java.awt.Dimension(100, 100));
        q12.setMinimumSize(new java.awt.Dimension(100, 100));
        q12.setLayout(null);

        jTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField37.setText("0");
        jTextField37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField37.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField37.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField37KeyPressed(evt);
            }
        });
        q12.add(jTextField37);
        jTextField37.setBounds(0, 0, 30, 30);

        jTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField38.setText("0");
        jTextField38.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField38.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField38.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField38KeyPressed(evt);
            }
        });
        q12.add(jTextField38);
        jTextField38.setBounds(30, 0, 30, 30);

        jTextField39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField39.setText("0");
        jTextField39.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField39.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q12.add(jTextField39);
        jTextField39.setBounds(60, 0, 30, 30);

        jTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField40.setText("0");
        jTextField40.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField40.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q12.add(jTextField40);
        jTextField40.setBounds(90, 0, 30, 30);

        jTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField41.setText("0");
        jTextField41.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField41.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q12.add(jTextField41);
        jTextField41.setBounds(120, 0, 30, 30);

        jTextField42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField42.setText("0");
        jTextField42.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField42.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q12.add(jTextField42);
        jTextField42.setBounds(150, 0, 30, 30);

        jTextField43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField43.setText("0");
        jTextField43.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField43.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q12.add(jTextField43);
        jTextField43.setBounds(180, 0, 30, 30);

        jTextField44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField44.setText("0");
        jTextField44.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField44.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q12.add(jTextField44);
        jTextField44.setBounds(210, 0, 30, 30);

        jTextField45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField45.setText("0");
        jTextField45.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField45.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q12.add(jTextField45);
        jTextField45.setBounds(240, 0, 30, 30);

        painel1.add(q12);
        q12.setBounds(0, 120, 270, 30);

        q13.setMaximumSize(new java.awt.Dimension(100, 100));
        q13.setMinimumSize(new java.awt.Dimension(100, 100));
        q13.setLayout(null);

        jTextField46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField46.setText("0");
        jTextField46.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField46.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField46.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField46KeyPressed(evt);
            }
        });
        q13.add(jTextField46);
        jTextField46.setBounds(0, 0, 30, 30);

        jTextField47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField47.setText("0");
        jTextField47.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField47.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField47.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField47KeyPressed(evt);
            }
        });
        q13.add(jTextField47);
        jTextField47.setBounds(30, 0, 30, 30);

        jTextField48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField48.setText("0");
        jTextField48.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        jTextField48.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q13.add(jTextField48);
        jTextField48.setBounds(60, 0, 30, 30);

        jTextField49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField49.setText("0");
        jTextField49.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField49.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q13.add(jTextField49);
        jTextField49.setBounds(90, 0, 30, 30);

        jTextField50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField50.setText("0");
        jTextField50.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField50.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q13.add(jTextField50);
        jTextField50.setBounds(120, 0, 30, 30);

        jTextField51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField51.setText("0");
        jTextField51.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        jTextField51.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q13.add(jTextField51);
        jTextField51.setBounds(150, 0, 30, 30);

        jTextField52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField52.setText("0");
        jTextField52.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField52.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q13.add(jTextField52);
        jTextField52.setBounds(180, 0, 30, 30);

        jTextField53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField53.setText("0");
        jTextField53.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField53.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q13.add(jTextField53);
        jTextField53.setBounds(210, 0, 30, 30);

        jTextField54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField54.setText("0");
        jTextField54.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(153, 153, 153)));
        jTextField54.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q13.add(jTextField54);
        jTextField54.setBounds(240, 0, 30, 30);

        painel1.add(q13);
        q13.setBounds(0, 150, 270, 30);

        q14.setMaximumSize(new java.awt.Dimension(100, 100));
        q14.setMinimumSize(new java.awt.Dimension(100, 100));
        q14.setLayout(null);

        jTextField55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField55.setText("0");
        jTextField55.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField55.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField55.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField55KeyPressed(evt);
            }
        });
        q14.add(jTextField55);
        jTextField55.setBounds(0, 0, 30, 30);

        jTextField56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField56.setText("0");
        jTextField56.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField56.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField56.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField56KeyPressed(evt);
            }
        });
        q14.add(jTextField56);
        jTextField56.setBounds(30, 0, 30, 30);

        jTextField57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField57.setText("0");
        jTextField57.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField57.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q14.add(jTextField57);
        jTextField57.setBounds(60, 0, 30, 30);

        jTextField58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField58.setText("0");
        jTextField58.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField58.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q14.add(jTextField58);
        jTextField58.setBounds(90, 0, 30, 30);

        jTextField59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField59.setText("0");
        jTextField59.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField59.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q14.add(jTextField59);
        jTextField59.setBounds(120, 0, 30, 30);

        jTextField60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField60.setText("0");
        jTextField60.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField60.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q14.add(jTextField60);
        jTextField60.setBounds(150, 0, 30, 30);

        jTextField61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField61.setText("0");
        jTextField61.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField61.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q14.add(jTextField61);
        jTextField61.setBounds(180, 0, 30, 30);

        jTextField62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField62.setText("0");
        jTextField62.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField62.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q14.add(jTextField62);
        jTextField62.setBounds(210, 0, 30, 30);

        jTextField63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField63.setText("0");
        jTextField63.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField63.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q14.add(jTextField63);
        jTextField63.setBounds(240, 0, 30, 30);

        painel1.add(q14);
        q14.setBounds(0, 180, 270, 30);

        q15.setMaximumSize(new java.awt.Dimension(100, 100));
        q15.setMinimumSize(new java.awt.Dimension(100, 100));
        q15.setLayout(null);

        jTextField64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField64.setText("0");
        jTextField64.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField64.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField64.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField64KeyPressed(evt);
            }
        });
        q15.add(jTextField64);
        jTextField64.setBounds(0, 0, 30, 30);

        jTextField65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField65.setText("0");
        jTextField65.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField65.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField65.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField65KeyPressed(evt);
            }
        });
        q15.add(jTextField65);
        jTextField65.setBounds(30, 0, 30, 30);

        jTextField66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField66.setText("0");
        jTextField66.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField66.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q15.add(jTextField66);
        jTextField66.setBounds(60, 0, 30, 30);

        jTextField67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField67.setText("0");
        jTextField67.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField67.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q15.add(jTextField67);
        jTextField67.setBounds(90, 0, 30, 30);

        jTextField68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField68.setText("0");
        jTextField68.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField68.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q15.add(jTextField68);
        jTextField68.setBounds(120, 0, 30, 30);

        jTextField69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField69.setText("0");
        jTextField69.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField69.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q15.add(jTextField69);
        jTextField69.setBounds(150, 0, 30, 30);

        jTextField70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField70.setText("0");
        jTextField70.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField70.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q15.add(jTextField70);
        jTextField70.setBounds(180, 0, 30, 30);

        jTextField71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField71.setText("0");
        jTextField71.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField71.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q15.add(jTextField71);
        jTextField71.setBounds(210, 0, 30, 30);

        jTextField72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField72.setText("0");
        jTextField72.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField72.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q15.add(jTextField72);
        jTextField72.setBounds(240, 0, 30, 30);

        painel1.add(q15);
        q15.setBounds(0, 210, 270, 30);

        q16.setMaximumSize(new java.awt.Dimension(100, 100));
        q16.setMinimumSize(new java.awt.Dimension(100, 100));
        q16.setLayout(null);

        jTextField82.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField82.setText("0");
        jTextField82.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField82.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField82.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField82KeyPressed(evt);
            }
        });
        q16.add(jTextField82);
        jTextField82.setBounds(0, 0, 30, 30);

        jTextField83.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField83.setText("0");
        jTextField83.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField83.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField83.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField83KeyPressed(evt);
            }
        });
        q16.add(jTextField83);
        jTextField83.setBounds(30, 0, 30, 30);

        jTextField84.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField84.setText("0");
        jTextField84.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField84.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q16.add(jTextField84);
        jTextField84.setBounds(60, 0, 30, 30);

        jTextField85.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField85.setText("0");
        jTextField85.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField85.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q16.add(jTextField85);
        jTextField85.setBounds(90, 0, 30, 30);

        jTextField86.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField86.setText("0");
        jTextField86.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField86.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q16.add(jTextField86);
        jTextField86.setBounds(120, 0, 30, 30);

        jTextField87.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField87.setText("0");
        jTextField87.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(153, 153, 153)));
        jTextField87.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q16.add(jTextField87);
        jTextField87.setBounds(150, 0, 30, 30);

        jTextField88.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField88.setText("0");
        jTextField88.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField88.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q16.add(jTextField88);
        jTextField88.setBounds(180, 0, 30, 30);

        jTextField89.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField89.setText("0");
        jTextField89.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField89.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q16.add(jTextField89);
        jTextField89.setBounds(210, 0, 30, 30);

        jTextField90.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField90.setText("0");
        jTextField90.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jTextField90.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        q16.add(jTextField90);
        jTextField90.setBounds(240, 0, 30, 30);

        painel1.add(q16);
        q16.setBounds(0, 240, 270, 60);

        painel2.setLayout(null);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 204));
        jButton3.setText("1");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        painel2.add(jButton3);
        jButton3.setBounds(10, 20, 46, 39);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 204));
        jButton4.setText("2");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusable(false);
        painel2.add(jButton4);
        jButton4.setBounds(60, 20, 46, 39);

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 204));
        jButton5.setText("3");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusable(false);
        painel2.add(jButton5);
        jButton5.setBounds(110, 20, 46, 39);

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 204));
        jButton7.setText("4");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        painel2.add(jButton7);
        jButton7.setBounds(10, 70, 46, 39);

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 102, 204));
        jButton8.setText("5");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusable(false);
        painel2.add(jButton8);
        jButton8.setBounds(60, 70, 46, 39);

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 204));
        jButton6.setText("6");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);
        painel2.add(jButton6);
        jButton6.setBounds(110, 70, 46, 39);

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 102, 204));
        jButton10.setText("7");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setFocusable(false);
        painel2.add(jButton10);
        jButton10.setBounds(10, 120, 46, 39);

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 102, 204));
        jButton11.setText("8");
        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setFocusable(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        painel2.add(jButton11);
        jButton11.setBounds(60, 120, 46, 39);

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 102, 204));
        jButton9.setText("9");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusable(false);
        painel2.add(jButton9);
        jButton9.setBounds(110, 120, 46, 39);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("?");
        jButton2.setToolTipText("verificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton2)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jPanel2.setLayout(null);

        label.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Nível difilcil");
        jPanel2.add(label);
        label.setBounds(295, 0, 146, 16);

        tempo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        tempo.setForeground(new java.awt.Color(102, 204, 0));
        tempo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tempo.setText("00:00:00");
        jPanel2.add(tempo);
        tempo.setBounds(90, 6, 75, 20);

        label2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label2.setText("Tempo de jogo :");
        jPanel2.add(label2);
        label2.setBounds(0, 0, 88, 30);

        jMenu1.setText("JOGO");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenuItem1.setText("Novo Jogo");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(120, 31));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("SOBRE");

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenuItem3.setText("Criador");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenuItem4.setText("Jogo");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painel2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        //  acertou(this.jTextField106);
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19KeyPressed

    private void jTextField20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20KeyPressed

    private void jTextField28KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField28KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28KeyPressed

    private void jTextField29KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField29KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29KeyPressed

    private void jTextField37KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField37KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField37KeyPressed

    private void jTextField38KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField38KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField38KeyPressed

    private void jTextField46KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField46KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField46KeyPressed

    private void jTextField47KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField47KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField47KeyPressed

    private void jTextField55KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField55KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField55KeyPressed

    private void jTextField56KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField56KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField56KeyPressed

    private void jTextField64KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField64KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField64KeyPressed

    private void jTextField65KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField65KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField65KeyPressed

    private void jTextField82KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField82KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField82KeyPressed

    private void jTextField83KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField83KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField83KeyPressed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        principal novo = new principal();
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        programador ver = new programador(this, true);
        ver.setVisible(true
        );
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (ganhou()) {
            JOptionPane.showMessageDialog(null, "Parabens!!! \nJogo Ganho!!",
                    "Vitoria", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField83;
    private javax.swing.JTextField jTextField84;
    private javax.swing.JTextField jTextField85;
    private javax.swing.JTextField jTextField86;
    private javax.swing.JTextField jTextField87;
    private javax.swing.JTextField jTextField88;
    private javax.swing.JTextField jTextField89;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField90;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JPanel painel1;
    private javax.swing.JPanel painel2;
    private javax.swing.JPanel q00;
    private javax.swing.JPanel q10;
    private javax.swing.JPanel q11;
    private javax.swing.JPanel q12;
    private javax.swing.JPanel q13;
    private javax.swing.JPanel q14;
    private javax.swing.JPanel q15;
    private javax.swing.JPanel q16;
    private javax.swing.JPanel q9;
    private javax.swing.JLabel tempo;
    // End of variables declaration//GEN-END:variables
}
