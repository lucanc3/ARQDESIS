/*
 * Decompiled with CFR 0_114.
 */
public class Conta {
    private String conta;
    private String agencia;
    private String senha;
    private String codigo;
    private String nome;
    private double saldo;

    public Conta() {
        this.setConta(null);
        this.setAgencia(null);
        this.setSenha(null);
        this.setCodigo("00");
        this.setSaldo(0.0);
        this.setNome(null);
    }

    public Conta(String cAgencia, String cConta, String cSenha, String cCodigo) {
        this.setAgencia(cAgencia);
        this.setConta(cConta);
        this.setSenha(cSenha);
        this.setCodigo(cCodigo);
    }

    public void setConta(String sConta) {
        this.conta = sConta;
    }

    public void setNome(String sNome) {
        this.nome = sNome;
    }

    public void setAgencia(String sAgencia) {
        this.agencia = sAgencia;
    }

    public void setSenha(String sSenha) {
        this.senha = sSenha;
    }

    public void setCodigo(String sCodigo) {
        this.codigo = sCodigo;
    }

    public void setSaldo(double sSaldo) {
        this.saldo = sSaldo;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public String getConta() {
        return this.conta;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNome() {
        return this.nome;
    }
}

