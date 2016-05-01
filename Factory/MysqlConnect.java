/*
 * Decompiled with CFR 0_114.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MysqlConnect {
    public Connection conn = null;

    public MysqlConnect() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "dbnoprant_Projeto";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(String.valueOf(url) + dbName, userName, password);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!" + e);
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection() {
        try {
            this.conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

