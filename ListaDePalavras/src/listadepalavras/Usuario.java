/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadepalavras;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author Baby
 */
public class Usuario {

    private int idade;
    private String nome;
    private String user;
    private String senha;
    private String sexo;
private int id;

    private ResultSet rSet;
    private PreparedStatement prSt;
    private Conexao control;
    
    public Usuario(){
        control=new Conexao();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
   

    /**
     * @return the idade
     */

    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void inserir(Usuario utilizador) {
        try {
            prSt = control.conn.prepareStatement("INSERT INTO utilizadores (nom_user,nom_compl,senha,idade,sexo) VALUES (?,?,?,?,?)");
            prSt.setString(1, utilizador.getUser());
            prSt.setString(2, utilizador.getNome());
            prSt.setString(3, utilizador.getSenha());
            prSt.setInt(4, utilizador.getIdade());
            prSt.setString(5, utilizador.getSexo());

            prSt.execute();
             JOptionPane.showMessageDialog(null, "Conta de utilizador registada com sucesso", "ALTERADO!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void alterar(Usuario utilizador) {

        try {

            prSt = control.conn.prepareStatement("UPDATE utilizadores SET nom_user=?,nom_compl=?,senha=?,idade=?,sexo=? WHERE id_usuario = ?");

            prSt.setString(1, utilizador.getUser());
            prSt.setString(2, utilizador.getNome());
            prSt.setString(3, utilizador.getSenha());
            prSt.setInt(4, utilizador.getIdade());
            prSt.setString(5, utilizador.getSexo());
             prSt.setInt(6, utilizador.getId());
            prSt.execute();
            JOptionPane.showMessageDialog(null, "Conta de utilizador alterada com sucesso", "ALTERADO!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void excluir(int idUsuario) {
        try {

            prSt = control.conn.prepareStatement("DELETE FROM utilizadores WHERE id_usuario=?");
            prSt.setInt(1, idUsuario);
            prSt.execute();
            JOptionPane.showMessageDialog(null, "Conta de utilizador eliminada com sucesso", "ELIMINADO!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public ResultSet buscar() {
        try {
//           

            prSt = control.conn.prepareStatement("SELECT * FROM utilizadores ORDER BY id_usuario");
            rSet = prSt.executeQuery();
            return rSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
