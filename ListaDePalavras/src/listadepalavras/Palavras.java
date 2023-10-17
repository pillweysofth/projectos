package listadepalavras;

import java.sql.*;
import javax.swing.JOptionPane;

public class Palavras {

    private ResultSet rSet;
    private PreparedStatement prSt;
    private Conexao conetando;

    public Palavras() {
        conetando = new Conexao();
    }

    public void inserirCas(String palavra,String autor) {
        try {
            prSt = conetando.conn.prepareStatement("INSERT INTO casamento (pal_cas,autor_txto) VALUES (?,?)");
            prSt.setString(1, palavra);
 prSt.setString(2, autor);
            prSt.execute();
            JOptionPane.showMessageDialog(null, "PaLavra registada com sucesso", "ALTERADO!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void inserirAmor(String palavra,String autor) {
        try {
            prSt = conetando.conn.prepareStatement("INSERT INTO Amor (pal_Amor,autor_txto) VALUES (?,?)");
            prSt.setString(1, palavra);
            prSt.setString(2, autor);
            prSt.execute();
            JOptionPane.showMessageDialog(null, "PaLavra registada com sucesso", "ALTERADO!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void alterarCas(String palavra, int id) {

        try {

            prSt = conetando.conn.prepareStatement("UPDATE casamento SET pal_cas=? WHERE id_casa = ?");

            prSt.setString(5, palavra);
            prSt.setInt(5, id);
            prSt.execute();
            JOptionPane.showMessageDialog(null, "PaLavra alterada com sucesso", "ALTERADO!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void excluirCas(int palavra) {
        try {

            prSt = conetando.conn.prepareStatement("DELETE FROM casamento WHERE id_casa=?");
            prSt.setInt(1, palavra);
            prSt.execute();
            JOptionPane.showMessageDialog(null, "Palavra eliminada com sucesso", "ELIMINADO!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void alterarAmor(String palavra, int id) {

        try {

            prSt = conetando.conn.prepareStatement("UPDATE amor SET pal_amor=? WHERE id_amor = ?");

            prSt.setString(5, palavra);
            prSt.setInt(5, id);
            prSt.execute();
            JOptionPane.showMessageDialog(null, "PaLavra alterada com sucesso", "ALTERADO!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void excluirAmor(int palavra) {
        try {

            prSt = conetando.conn.prepareStatement("DELETE FROM amor WHERE id_amor=?");
            prSt.setInt(1, palavra);
            prSt.execute();
            JOptionPane.showMessageDialog(null, "Palavra eliminada com sucesso", "ELIMINADO!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
