package br.com.prog2.projf.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.projf.model.Chale;

public class ChaleDAOImp implements ChaleDAO {

    @Override
    public String inserir(Chale chale) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Chale(codChale, localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao) ");
        sql.append("VALUES(?,?,?,?,?)");

        try {
        	if (chale.getCapacidade() <= 0) {
                return "A capacidade tem que ser maior que 0";
            } else if (chale.getValorAltaEstacao() < 0 || chale.getValorBaixaEstacao() < 0) {
                return "As diárias não podem ser negativas";
            }
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, chale.getCodChale());
            pst.setString(2, chale.getLocalizacao());
            pst.setInt(3, chale.getCapacidade());
            pst.setDouble(4, chale.getValorAltaEstacao());
            pst.setDouble(5, chale.getValorBaixaEstacao());
            
            
            
            int res = pst.executeUpdate();
            if (res > 0) {
                return "Inserido com sucesso";
            }
        } catch (SQLException e) {
            return "Erro ao inserir dados " + e.getMessage();
        } finally {
            ConnectionFactory.close(con);
        }

        return "Erro ao inserir";
    }

    @Override
    public String alterar(Chale chale) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Chale SET localizacao=?, capacidade=?, valorAltaEstacao=?, valorBaixaEstacao=? ");
        sql.append("WHERE codChale=?");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, chale.getLocalizacao());
            pst.setInt(2, chale.getCapacidade());
            pst.setDouble(3, chale.getValorAltaEstacao());
            pst.setDouble(4, chale.getValorBaixaEstacao());
            pst.setInt(5, chale.getCodChale());

            int res = pst.executeUpdate();
            if (res > 0) {
                return "Alterado com sucesso";
            }
        } catch (SQLException e) {
            return "Erro ao alterar dados " + e.getMessage();
        } finally {
            ConnectionFactory.close(con);
        }

        return "Erro ao alterar os dados";
    }

    @Override
    public String excluir(Chale chale) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Chale WHERE codChale=?");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, chale.getCodChale());

            int res = pst.executeUpdate();
            if (res > 0) {
                return "Excluído com sucesso";
            }
        } catch (SQLException e) {
            return "Erro ao excluir: " + e.getMessage();
        } finally {
            ConnectionFactory.close(con);
        }

        return "Erro ao excluir";
    }

    @Override
    public List<Chale> listarTodos() {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Chale");
        List<Chale> lista = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Chale chale = new Chale();
                chale.setCodChale(res.getInt("codChale"));
                chale.setLocalizacao(res.getString("localizacao"));
                chale.setCapacidade(res.getInt("capacidade"));
                chale.setValorAltaEstacao(res.getDouble("valorAltaEstacao"));
                chale.setValorBaixaEstacao(res.getDouble("valorBaixaEstacao"));
                lista.add(chale);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } finally {
            ConnectionFactory.close(con);
        }
    }

    @Override
    public Chale pesquisarPorId(Integer codChale) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Chale WHERE codChale=?");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, codChale);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                Chale chale = new Chale();
                chale.setCodChale(res.getInt("codChale"));
                chale.setLocalizacao(res.getString("localizacao"));
                chale.setCapacidade(res.getInt("capacidade"));
                chale.setValorAltaEstacao(res.getDouble("valorAltaEstacao"));
                chale.setValorBaixaEstacao(res.getDouble("valorBaixaEstacao"));
                return chale;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.close(con);
        }

        return null;
    }
}
