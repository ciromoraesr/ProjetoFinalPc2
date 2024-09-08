package br.com.prog2.projf.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.prog2.projf.model.Hospedagem;

public class HospedagemDAOImp implements HospedagemDAO {

    @Override
    public String inserir(Hospedagem hospedagem) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Hospedagem(codHospedagem, codChale, codCliente, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) ");
        sql.append("VALUES(?,?,?,?,?,?,?,?)");

        try {
            
            String sqlCheckOverlap = "SELECT * FROM Hospedagem WHERE codChale = ? AND ((dataInicio <= ? AND dataFim >= ?) OR (dataInicio <= ? AND dataFim >= ?))";
            PreparedStatement pstCheckOverlap = con.prepareStatement(sqlCheckOverlap);
            pstCheckOverlap.setInt(1, hospedagem.getCodChale());
            pstCheckOverlap.setDate(2, hospedagem.getDataFim());
            pstCheckOverlap.setDate(3, hospedagem.getDataInicio());
            pstCheckOverlap.setDate(4, hospedagem.getDataFim());
            pstCheckOverlap.setDate(5, hospedagem.getDataInicio());
            
            ResultSet rsOverlap = pstCheckOverlap.executeQuery();
            if (rsOverlap.next()) {
                return "O chalé escolhido está ocupado nesse período.";
            }

            
            String sqlChale = "SELECT valorAltaEstacao, valorBaixaEstacao, capacidade FROM Chale WHERE codChale = ?";
            PreparedStatement pstChale = con.prepareStatement(sqlChale);
            pstChale.setInt(1, hospedagem.getCodChale());
            ResultSet rs = pstChale.executeQuery();
            
            double valorFinal = 0.0;

            if (rs.next()) {
                if (rs.getInt("capacidade") < hospedagem.getQtdPessoas()) {
                    return "Excedeu a capacidade.";
                }
                double valorAltaEstacao = rs.getDouble("valorAltaEstacao");
                double valorBaixaEstacao = rs.getDouble("valorBaixaEstacao");

                long milliseconds = hospedagem.getDataFim().getTime() - hospedagem.getDataInicio().getTime();
                long days = milliseconds / (1000 * 60 * 60 * 24);

                Calendar calendarIni = Calendar.getInstance();
                calendarIni.setTime(hospedagem.getDataInicio());
                Calendar calendarFim = Calendar.getInstance();
                calendarFim.setTime(hospedagem.getDataFim());

                int startMonth = calendarIni.get(Calendar.MONTH) + 1;
                int endMonth = calendarFim.get(Calendar.MONTH) + 1;
                double rate = valorBaixaEstacao;

                boolean altaEstacaoStart = (startMonth >= 6 && startMonth <= 8) || (startMonth >= 11 || startMonth == 1);
                boolean altaEstacaoEnd = (endMonth >= 6 && endMonth <= 8) || (endMonth == 11 || endMonth == 1);

                if (altaEstacaoStart || altaEstacaoEnd) {
                    rate = valorAltaEstacao;
                }

                valorFinal = days * rate;
                valorFinal -= hospedagem.getDesconto();
                if (valorFinal < 0.0) {
                    valorFinal = 0.0;
                }
            } else {
                return "Chale não encontrado com codChale: " + hospedagem.getCodChale();
            }

            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, hospedagem.getCodHospedagem());
            pst.setInt(2, hospedagem.getCodChale());
            pst.setInt(3, hospedagem.getCodCliente());
            pst.setDate(4, hospedagem.getDataInicio());
            pst.setDate(5, hospedagem.getDataFim());
            pst.setInt(6, hospedagem.getQtdPessoas());
            pst.setDouble(7, hospedagem.getDesconto());
            pst.setDouble(8, valorFinal);

            int res = pst.executeUpdate();
            if (res > 0) {
                return "Inserido com successo";
            }
        } catch (SQLException e) {
            return "Erro inserindo: " + e.getMessage();
        } finally {
            ConnectionFactory.close(con);
        }

        return "Erro inserindo";
    }




    @Override
    public String alterar(Hospedagem hospedagem) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Hospedagem SET codChale=?, codCliente=?, dataInicio=?, dataFim=?, qtdPessoas=?, desconto=?, valorFinal=? ");
        sql.append("WHERE codHospedagem=?");

        try {
            
            String sqlCheckOverlap = "SELECT * FROM Hospedagem WHERE codChale = ? AND codHospedagem != ? AND ((dataInicio <= ? AND dataFim >= ?) OR (dataInicio <= ? AND dataFim >= ?))";
            PreparedStatement pstCheckOverlap = con.prepareStatement(sqlCheckOverlap);
            pstCheckOverlap.setInt(1, hospedagem.getCodChale());
            pstCheckOverlap.setInt(2, hospedagem.getCodHospedagem());
            pstCheckOverlap.setDate(3, hospedagem.getDataFim());
            pstCheckOverlap.setDate(4, hospedagem.getDataInicio());
            pstCheckOverlap.setDate(5, hospedagem.getDataFim());
            pstCheckOverlap.setDate(6, hospedagem.getDataInicio());
            
            ResultSet rsOverlap = pstCheckOverlap.executeQuery();
            if (rsOverlap.next()) {
                return "Esse chale já está hospedado nesse período";
            }

           
            String sqlChale = "SELECT valorAltaEstacao, valorBaixaEstacao, capacidade FROM Chale WHERE codChale = ?";
            PreparedStatement pstChale = con.prepareStatement(sqlChale);
            pstChale.setInt(1, hospedagem.getCodChale());
            ResultSet rs = pstChale.executeQuery();
            
            double valorFinal = 0.0;

            if (rs.next()) {
                if (rs.getInt("capacidade") < hospedagem.getQtdPessoas()) {
                    return "Excedeu a capacidade.";
                }

                double valorAltaEstacao = rs.getDouble("valorAltaEstacao");
                double valorBaixaEstacao = rs.getDouble("valorBaixaEstacao");

                long milliseconds = hospedagem.getDataFim().getTime() - hospedagem.getDataInicio().getTime();
                long days = milliseconds / (1000 * 60 * 60 * 24);

                Calendar calendarIni = Calendar.getInstance();
                calendarIni.setTime(hospedagem.getDataInicio());
                Calendar calendarFim = Calendar.getInstance();
                calendarFim.setTime(hospedagem.getDataFim());

                int startMonth = calendarIni.get(Calendar.MONTH) + 1;
                int endMonth = calendarFim.get(Calendar.MONTH) + 1;
                double rate = valorBaixaEstacao;

                boolean altaEstacaoStart = (startMonth >= 6 && startMonth <= 8) || (startMonth == 11 || startMonth == 1);
                boolean altaEstacaoEnd = (endMonth >= 6 && endMonth <= 8) || (endMonth == 11 || endMonth == 1);

                if (altaEstacaoStart || altaEstacaoEnd) {
                    rate = valorAltaEstacao;
                }

                valorFinal = days * rate;
                valorFinal -= hospedagem.getDesconto();
            } else {
                return "O chalé com o código a seguir não foi achado: " + hospedagem.getCodChale();
            }

            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, hospedagem.getCodChale());
            pst.setInt(2, hospedagem.getCodCliente());
            pst.setDate(3, hospedagem.getDataInicio());
            pst.setDate(4, hospedagem.getDataFim());
            pst.setInt(5, hospedagem.getQtdPessoas());
            pst.setDouble(6, hospedagem.getDesconto());
            pst.setDouble(7, valorFinal);
            pst.setInt(8, hospedagem.getCodHospedagem());

            int res = pst.executeUpdate();
            if (res > 0) {
                return "Alterado com sucesso";
            }
        } catch (SQLException e) {
            return "Erro alterando: " + e.getMessage();
        } finally {
            ConnectionFactory.close(con);
        }

        return "Erro alterando";
    }



    @Override
    public String excluir(Hospedagem hospedagem) {
    	
    	if (hospedagem == null || hospedagem.getCodHospedagem() == null){
    		return "Erro: Hospedagem ou codHospedagem é nulo";
    	}
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Hospedagem WHERE codHospedagem=?");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, hospedagem.getCodHospedagem());

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
    public List<Hospedagem> listarTodos() {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Hospedagem");
        List<Hospedagem> lista = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setCodHospedagem(res.getInt("codHospedagem"));
                hospedagem.setCodChale(res.getInt("codChale"));
                hospedagem.setCodCliente(res.getInt("codCliente"));
                hospedagem.setDataInicio(res.getDate("dataInicio"));
                hospedagem.setDataFim(res.getDate("dataFim"));
                hospedagem.setQtdPessoas(res.getInt("qtdPessoas"));
                hospedagem.setDesconto(res.getDouble("desconto"));
                hospedagem.setValorFinal(res.getDouble("valorFinal"));
                lista.add(hospedagem);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } finally {
            ConnectionFactory.close(con);
        }
    }

    @Override
    public Hospedagem pesquisarPorId(Integer codHospedagem) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Hospedagem WHERE codHospedagem=?");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, codHospedagem);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setCodHospedagem(res.getInt("codHospedagem"));
                hospedagem.setCodChale(res.getInt("codChale"));
                hospedagem.setCodCliente(res.getInt("codCliente"));
                hospedagem.setDataInicio(res.getDate("dataInicio"));
                hospedagem.setDataFim(res.getDate("dataFim"));
                hospedagem.setQtdPessoas(res.getInt("qtdPessoas"));
                hospedagem.setDesconto(res.getDouble("desconto"));
                hospedagem.setValorFinal(res.getDouble("valorFinal"));
                return hospedagem;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.close(con);
        }

        return null;
    }
}
