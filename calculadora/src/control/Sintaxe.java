/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;

/**
 *
 * @author MR-STUDIOS
 */
public class Sintaxe {

    private ArrayList<Double> numeros;
    private ArrayList<Character> listaO;
    private ArrayList<Funcao> funcao;

    public Sintaxe() {

    }

    public boolean verSin(String equac) {
        int contP1 = 0, contP2 = 0;
        char[] verif = equac.toCharArray();
        for (int i = 0; i < verif.length; i++) {
            if (verif[i] == '(') {
                contP1++;
            }
            if (verif[i] == ')') {
                contP2++;
            }

        }
        int ult = verif.length - 1;
        if (!isOperador(verif[ult])
                && (Character.isDigit(verif[ult]) || verif[ult] == ')')
                || isSimb(verif[ult])) {
            if ((isOperador(verif[0]) && verif[0] == '-') || Character.isDigit(verif[0])
                    || verif[0] == '(' || isFunc(equac.substring(0, 4))
                    || isFunc(equac.substring(0, 2))) {
                return true;

            }
        }
        if (contP1 != 0) {
            return (contP1 == contP2);
        }
        return false;
    }

    public String extrair(String equac) {
        String pa = equac;
        String[] repartir;
        if (pa.contains("sin(") || pa.contains("cos(")
                || pa.contains("mod(") || pa.contains("√(")) {
            repartir = equac.split("si|co|mo|√");
            for (int i = 0; i < repartir.length; i++) {

            }
        } else {
            numeros = new ArrayList();
            repartir = equac.split("\\+|\\-|\\*|\\/");
            for (int i = 0; i < repartir.length; i++) {
                numeros.add(Double.parseDouble(repartir[i]));
            }
            listaO = new ArrayList();
            for (int i = 0; i < equac.length(); i++) {
                if (isOperador(equac.charAt(i))) {
                    listaO.add(equac.charAt(i));
                }
            }
        }
        System.out.println("equacao " + numeros.toString());
        System.out.println("Op " + listaO.toString());
        String n = calcular();

        System.out.println("resultado " + n);
        return n;
    }

    private String calcular() {
        String resultado = "";
        double tem = 0;
        if (listaO.contains('*') || listaO.contains('/')) {

            for (int i = 0; i < listaO.size();) {
                if (listaO.get(i) == '*' || listaO.get(i) == '/') {
                    if (listaO.get(i) == '*') {

                        tem = Operacao.multiplicacao(numeros.get(i), numeros.get(i + 1));
                        listaO.remove(i);
                        numeros.remove(i + 1);
                        numeros.set(i, tem);
                    } else if (listaO.get(i) == '/') {
                        tem = Operacao.subtracao(numeros.get(i), numeros.get(i + 1));
                        listaO.remove(i);
                        numeros.remove(i + 1);
                        numeros.set(i, tem);
                    }
                }
                if (!listaO.contains('*') || !listaO.contains('/')) {

                    break;
                }
            }
            if (listaO.contains('+') || listaO.contains('-')) {

                for (int i = 0; i < listaO.size();) {
                    if (listaO.get(i) == '+') {
                        tem = Operacao.adicao(numeros.get(i), numeros.get(i + 1));
                        listaO.remove(i);
                        numeros.remove(i + 1);
                        numeros.set(i, tem);
                    } else if (listaO.get(i) == '-') {
                        tem = Operacao.subtracao(numeros.get(i), numeros.get(i + 1));
                        listaO.remove(i);
                        numeros.remove(i + 1);
                        numeros.set(i, tem);
                    }
                    if (!listaO.contains('+') || !listaO.contains('-')) {
                        break;
                    }
                }
            }

        } else {

            for (int i = 0; i < listaO.size();) {
                if (listaO.get(i) == '+') {
                    tem = Operacao.adicao(numeros.get(i), numeros.get(i + 1));

                    listaO.remove(i);
                    numeros.remove(i + 1);
                    numeros.set(i, tem);
                } else if (listaO.get(i) == '-') {
                    tem = Operacao.subtracao(numeros.get(i), numeros.get(i + 1));
                    listaO.remove(i);
                    numeros.remove(i + 1);
                    numeros.set(i, tem);
                }
            }
        }
        return resultado
                + numeros.get(
                        0);
    }

    public boolean isOperador(char operador) {
        return operador == '+'
                || operador == '*'
                || operador == '/'
                || operador == '-';
    }

    private boolean isSimb(char simbolo) {
        return simbolo == '!'
                || simbolo == 'e'
                || simbolo == 'π'
                || simbolo == '%';
    }

    private boolean isFunc(String funcao) {
        return funcao.equals("sin(")
                || funcao.equals("cos(")
                || funcao.equals("mod(")
                || funcao.equals("√(");
    }
}
