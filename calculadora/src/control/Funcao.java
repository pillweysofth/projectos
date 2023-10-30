/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import static java.lang.Math.*;
import java.util.ArrayList;

/**
 *
 * @author MR-STUDIOS
 */
public class Funcao {

    private final ArrayList<Double> numeros;
    private String funcao;
    private final ArrayList<Character> operadores;

    public Funcao() {
        numeros = new ArrayList();
        operadores = new ArrayList();
    }

    public ArrayList<Double> getNumeros() {
        return numeros;
    }

    public void setNumeros(Double numeros) {
        this.numeros.add(numeros);
    }

    public ArrayList<Character> getOperadores() {
        return operadores;
    }

    public void setOperadores(char operadores) {
        this.operadores.add(operadores);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {

        this.funcao = funcao;
    }

    public int fact(int nu) {
        if (nu < 0) {
            return 0;
        }
        if (nu == 0) {
            return 1;
        }

        return fact(nu - 1) * nu;

    }

    public double cosx(double nu) {
        return cos(nu);
    }

    public double senx(double nu) {
        return sin(nu);
    }

    public double raiz(double nu) {
        return sqrt(nu);
    }

    public double eule(double nu) {

        return E * nu;
    }

    public double poten(double nu, int x) {
        return pow(nu, x);
    }

    public double pi(double nu) {
        return PI * nu;
    }

}
