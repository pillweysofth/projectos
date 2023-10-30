/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

/**
 *
 * @author MR-STUDIOS
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static int fact(int nu) {
        
            if (nu == 0) {
                return 1;
            }
  
            return fact(nu - 1) * nu;
        
    }
    public static void main(String[] args) {
        String valor="9+(10)+sin(6)+cos(8+56+9)+mod(56)+√(563+8)*944";
        String[] ver=valor.split("si|co|mo|√");
       
        for(int i=0;i<ver.length;i++){
           System.out.println(" se tipo valor "+ver[i]);
               System.out.println("_______________________________________________\n");
      
        }
    }
    
}
