package br.com.prog2.projf.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        String driver = "org.postgresql.Driver";
        String user = "postgres"; // Coloque o usuário criado para acesso ao banco
        String senha = "pc2"; // Coloque a senha para acesso ao banco
        String url = "jdbc:postgresql://localhost:5432/TrabFinalPc2"; // Coloque o servidor onde está instalado o banco
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver not found: " + ex.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return con;
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}
