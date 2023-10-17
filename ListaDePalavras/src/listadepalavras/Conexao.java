/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadepalavras;

import java.sql.*;
/**
 *
 * @author Baby
 */
public class Conexao {
   private PreparedStatement pst; 
    public Connection conn;
  private ResultSet rest;
   
   public Conexao(){
       conectar();
   }
   
   public void conectar(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost/projecto","root","");
           System.out.println("Conectou");
       }catch(SQLException e){
         e.printStackTrace();
       } catch (ClassNotFoundException ex) {
          
       }
   }
   public void desconectar(){
       try {
           if(conn!=null&&!conn.isClosed())
                  
           conn.close();
            System.out.println("Desconectou");
       } catch (SQLException ex) {
          
       }
   }
    
}
