/*
 * Decompiled with CFR 0_114.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ViewTransferencia
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JLabel LblTitulo;
    private JLabel LblAgencia;
    private JLabel LblVoltar;
    private JLabel LblLogo;
    private JLabel LblConta;
    private JLabel LblTransferir;
    private JLabel LblValorTransferencia;
    private ImageIcon transferir;
    private ImageIcon voltar;
    private ImageIcon logo;
    private JTextField TxtAgencia;
    private JTextField TxtConta;
    private JTextField TxtValorTransferencia;
    protected ResourceBundle bn = null;

    public ViewTransferencia(ResourceBundle bnn) {
        this.bn = bnn;
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.setTitle(Util.getBnu().getString("transferencia.label.tituloJanela"));
        this.LblTitulo = new JLabel(Util.getBnu().getString("transferencia.label.titulo"));
        this.LblAgencia = new JLabel(Util.getBnu().getString("transferencia.label.agencia"));
        this.TxtAgencia = new JTextField();
        this.LblConta = new JLabel(Util.getBnu().getString("transferencia.label.conta"));
        this.TxtConta = new JTextField();
        this.LblValorTransferencia = new JLabel(Util.getBnu().getString("transferencia.label.valorTransferencia"));
        this.TxtValorTransferencia = new JTextField();
        this.voltar = new ImageIcon(Util.getBnu().getString("transferencia.botao.voltar"));
        this.LblVoltar = new JLabel(this.voltar);
        this.logo = new ImageIcon(Util.getBnu().getString("login.botao.logo"));
        this.LblLogo = new JLabel(this.logo);
        this.transferir = new ImageIcon(Util.getBnu().getString("transferencia.botao.transferir"));
        this.LblTransferir = new JLabel(this.transferir);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(6, 1, 0, 0));
        this.painelGrid1.add(this.LblAgencia);
        this.painelGrid1.add(this.TxtAgencia);
        this.painelGrid1.add(this.LblConta);
        this.painelGrid1.add(this.TxtConta);
        this.painelGrid1.add(this.LblValorTransferencia);
        this.painelGrid1.add(this.TxtValorTransferencia);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGrid2.add(this.LblLogo);
        this.painelGrid2.add(this.LblVoltar);
        this.painelGrid2.add(this.LblTransferir);
        this.painelGridPrincipal = new JPanel();
        this.painelGridPrincipal.setLayout(new GridLayout(1, 2, 0, 0));
        this.painelGridPrincipal.add(this.painelGrid1);
        this.painelGridPrincipal.add(this.painelGrid2);
        tela.add((Component)this.LblTitulo, "North");
        tela.add((Component)this.painelGridPrincipal, "Center");
        Color corBorda = new Color(45, 95, 143);
        this.painelGridPrincipal.setBorder(BorderFactory.createLineBorder(corBorda, 7));
        tela.setBackground(corBorda);
        Color corFundo = new Color(192, 192, 192);
        this.painelGrid1.setBackground(corFundo);
        this.painelGrid2.setBackground(corFundo);
        this.setSize(500, 460);
        this.setVisible(true);
    }

    public void setConta(int conta) {
        this.TxtConta.setText(String.valueOf(conta));
    }

    public void setAgencia(int agencia) {
        this.TxtAgencia.setText(String.valueOf(agencia));
    }

    public void setValorTransferencia(int transferencia) {
        this.TxtValorTransferencia.setText(String.valueOf(transferencia));
    }

    public int getConta() {
        return Integer.valueOf(this.TxtConta.getText());
    }

    public int getAgencia() {
        return Integer.valueOf(this.TxtAgencia.getText());
    }

    public int getValorTransferencia() {
        return Integer.valueOf(this.TxtValorTransferencia.getText());
    }

    public void addVoltarListener(MouseListener a) {
        this.LblVoltar.addMouseListener(a);
    }

    public void addTransferirListener(MouseListener a) {
        this.LblTransferir.addMouseListener(a);
    }
}

