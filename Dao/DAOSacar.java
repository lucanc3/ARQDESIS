/*
 * Decompiled with CFR 0_114.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOSacar {
    private Connection conn;
    private PreparedStatement st;
    private MysqlConnect local;
    private Conta conta;

    public DAOSacar(Conta conta) {
        this.conta = conta;
        this.local = new MysqlConnect();
        this.conn = this.local.getConnection();
    }

    public String consultaPorCodigo() {
        String retorno = "Usu\u00e1rio n\u00e2o Localizado";
        String conteudo = "";
        try {
            String sql = "SELECT * FROM tabContaSaldo WHERE conta = ?";
            this.st = this.conn.prepareStatement(sql);
            this.st.setInt(1, Integer.parseInt(this.conta.getConta()));
            ResultSet resultado = this.st.executeQuery();
            if (resultado.next()) {
                this.conta.setNome(resultado.getString("nome"));
                this.conta.setSaldo(resultado.getDouble("saldo"));
                conteudo = String.valueOf(conteudo) + "Conta: " + this.conta.getConta() + "\n";
                conteudo = String.valueOf(conteudo) + "Ag\u00eancia: " + this.conta.getAgencia() + "\n";
                retorno = conteudo = String.valueOf(conteudo) + "Nome: " + resultado.getString("nome") + "\n";
            }
            this.st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public boolean sacar(double novoSaldo) {
        boolean sucesso = false;
        try {
            String sql = "UPDATE tabContaSaldo SET saldo = ? WHERE agencia = ? and conta = ?";
            this.st = this.conn.prepareStatement(sql);
            this.st.setDouble(1, novoSaldo);
            this.st.setInt(2, Integer.parseInt(this.conta.getAgencia()));
            this.st.setInt(3, Integer.parseInt(this.conta.getConta()));
            this.st.executeUpdate();
            sucesso = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.local.closeConnection();
        return sucesso;
    }
}

