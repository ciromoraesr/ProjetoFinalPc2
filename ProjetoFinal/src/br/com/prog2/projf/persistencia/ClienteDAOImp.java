package br.com.prog2.projf.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.projf.model.Cliente;

public class ClienteDAOImp implements ClienteDAO {

    @Override
    public String inserir(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Cliente(codCliente, nomeCliente, rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, CEPCliente, nascimentoCliente) ");
        sql.append("VALUES(?,?,?,?,?,?,?,?,?)");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getCodCliente());
            pst.setString(2, cliente.getNomeCliente());
            pst.setString(3, cliente.getRgCliente());
            pst.setString(4, cliente.getEnderecoCliente());
            pst.setString(5, cliente.getBairroCliente());
            pst.setString(6, cliente.getCidadeCliente());
            pst.setString(7, cliente.getEstadoCliente());
            pst.setString(8, cliente.getCEPCliente());
            pst.setDate(9, cliente.getNascimentoCliente());

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
    public String alterar(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Cliente SET nomeCliente=?, rgCliente=?, enderecoCliente=?, ");
        sql.append("bairroCliente=?, cidadeCliente=?, estadoCliente=?, CEPCliente=?, nascimentoCliente=? ");
        sql.append("WHERE codCliente=?");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, cliente.getNomeCliente());
            pst.setString(2, cliente.getRgCliente());
            pst.setString(3, cliente.getEnderecoCliente());
            pst.setString(4, cliente.getBairroCliente());
            pst.setString(5, cliente.getCidadeCliente());
            pst.setString(6, cliente.getEstadoCliente());
            pst.setString(7, cliente.getCEPCliente());
            pst.setDate(8, cliente.getNascimentoCliente());
            pst.setInt(9, cliente.getCodCliente());

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
    public String excluir(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Cliente WHERE codCliente=?");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getCodCliente());

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
    public List<Cliente> listarTodos() {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Cliente");
        List<Cliente> lista = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodCliente(res.getInt("codCliente"));
                cliente.setNomeCliente(res.getString("nomeCliente"));
                cliente.setRgCliente(res.getString("rgCliente"));
                cliente.setEnderecoCliente(res.getString("enderecoCliente"));
                cliente.setBairroCliente(res.getString("bairroCliente"));
                cliente.setCidadeCliente(res.getString("cidadeCliente"));
                cliente.setEstadoCliente(res.getString("estadoCliente"));
                cliente.setCEPCliente(res.getString("CEPCliente"));
                cliente.setNascimentoCliente(res.getDate("nascimentoCliente"));
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } finally {
            ConnectionFactory.close(con);
        }
    }

    @Override
    public Cliente pesquisarPorId(Integer codCliente) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Cliente WHERE codCliente=?");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, codCliente);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodCliente(res.getInt("codCliente"));
                cliente.setNomeCliente(res.getString("nomeCliente"));
                cliente.setRgCliente(res.getString("rgCliente"));
                cliente.setEnderecoCliente(res.getString("enderecoCliente"));
                cliente.setBairroCliente(res.getString("bairroCliente"));
                cliente.setCidadeCliente(res.getString("cidadeCliente"));
                cliente.setEstadoCliente(res.getString("estadoCliente"));
                cliente.setCEPCliente(res.getString("CEPCliente"));
                cliente.setNascimentoCliente(res.getDate("nascimentoCliente"));
                return cliente;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.close(con);
        }

        return null;
    }
}
