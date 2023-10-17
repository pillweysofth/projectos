/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author MR-STUDIOS
 */
public class Tempo implements Runnable {

    private final JLabel passar;
    public Tempo(JLabel passar) {
        this.passar = passar;
      
    }

    @Override
    public void run() {
        int minutos = 0, segundos = 0, hora = 0;
        while (true) {
            
            String hor, min, seg;
            try {
                Thread.sleep(1000);
                segundos++;
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;

                }
                if (minutos == 60) {
                    minutos = 0;
                    hora++;

                }
                if (hora < 10) {
                    hor = "0" + hora;
                } else {
                    hor = "" + hora;
                }
                if (minutos < 10) {
                    min = "0" + minutos;
                } else {
                    min = "" + minutos;
                }
                if (segundos < 10) {
                    seg = "0" + segundos;
                } else {
                    seg = "" + segundos;
                }

                passar.setText(hor + " : " + min + " : " + seg);

            } catch (InterruptedException ex) {
                Logger.getLogger(Tempo.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
    }

}
