/*
 * Decompiled with CFR 0_114.
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ViewLogin
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JLabel lblLogo;
    private JLabel lblEntrar;
    private JLabel lblTitulo;
    private JLabel lblConta;
    private JLabel lblAgencia;
    private JLabel LblSenha;
    private JTextField txtConta;
    private JTextField txtAgencia;
    private JPasswordField txtPSenha;
    private ImageIcon logo;
    private ImageIcon entrar;
    protected ResourceBundle bn = null;

    public ViewLogin(ResourceBundle bnn) {
        super("Login - NOPRANT");
        this.bn = bnn;
        this.setLayout(new GridLayout(1, 1));
        Container tela = this.getContentPane();
        this.entrar = new ImageIcon(Util.getBnu().getString("login.botao.entrar"));
        this.lblEntrar = new JLabel(this.entrar);
        this.logo = new ImageIcon(Util.getBnu().getString("login.botao.logo"));
        this.lblLogo = new JLabel(this.logo);
        this.lblTitulo = new JLabel(Util.getBnu().getString("login.label.titulo"));
        this.lblTitulo.setForeground(Color.WHITE);
        this.lblTitulo.setFont(new Font("Dialog", 0, 17));
        this.lblConta = new JLabel(Util.getBnu().getString("login.label.conta"));
        this.lblConta.setForeground(Color.WHITE);
        this.lblConta.setFont(new Font("Dialog", 0, 17));
        this.lblAgencia = new JLabel(Util.getBnu().getString("login.label.agencia"));
        this.lblAgencia.setForeground(Color.WHITE);
        this.lblAgencia.setFont(new Font("Dialog", 0, 17));
        this.LblSenha = new JLabel(Util.getBnu().getString("login.label.senha"));
        this.LblSenha.setForeground(Color.WHITE);
        this.LblSenha.setFont(new Font("Dialog", 0, 17));
        this.txtConta = new JTextField();
        this.txtConta.setFont(new Font("Dialog", 0, 30));
        this.txtAgencia = new JTextField();
        this.txtAgencia.setFont(new Font("Dialog", 0, 30));
        this.txtPSenha = new JPasswordField();
        this.txtPSenha.setFont(new Font("Dialog", 0, 30));
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(7, 1));
        this.painelGrid1.add(this.lblTitulo);
        this.painelGrid1.add(this.lblAgencia);
        this.painelGrid1.add(this.txtAgencia);
        this.painelGrid1.add(this.lblConta);
        this.painelGrid1.add(this.txtConta);
        this.painelGrid1.add(this.LblSenha);
        this.painelGrid1.add(this.txtPSenha);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(4, 1));
        this.painelGrid2.add(this.lblLogo);
        this.painelGrid2.add(new JLabel(""));
        this.painelGrid2.add(new JLabel(""));
        this.painelGrid2.add(this.lblEntrar);
        this.painelGridPrincipal = new JPanel();
        this.painelGridPrincipal.setLayout(new GridLayout(1, 2));
        this.painelGridPrincipal.add(this.painelGrid1);
        this.painelGridPrincipal.add(this.painelGrid2);
        tela.add(this.painelGridPrincipal);
        this.painelGridPrincipal.setBorder(BorderFactory.createLineBorder(Color.WHITE, 7));
        Color corFundo = new Color(45, 95, 143);
        this.painelGrid1.setBackground(corFundo);
        this.painelGrid2.setBackground(corFundo);
        this.painelGridPrincipal.setBackground(corFundo);
        this.setSize(500, 460);
        this.setVisible(true);
    }

    public void setConta(String conta) {
        this.lblConta.setText(String.valueOf(conta));
    }

    public void setAgencia(String agencia) {
        this.lblAgencia.setText(String.valueOf(agencia));
    }

    public void setSenha(String senha) {
        this.txtPSenha.setText(String.valueOf(senha));
    }

    public String getConta() {
        return this.txtConta.getText();
    }

    public String getAgencia() {
        return this.txtAgencia.getText();
    }

    public String getSenha() {
        return new String(this.txtPSenha.getPassword());
    }

    public void addEntrarListener(MouseListener a) {
        this.lblEntrar.addMouseListener(a);
    }
}

