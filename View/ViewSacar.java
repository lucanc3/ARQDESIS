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

public class ViewSacar
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid4;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JPanel painelGrid3;
    private JLabel lblNotas;
    private JLabel lblDisponiveis;
    private JLabel lblLogo;
    private JLabel lblSaqueRapido;
    private JLabel lbl10;
    private JLabel lbl20;
    private JLabel lbl50;
    private JLabel lbl100;
    private JLabel lbl200;
    private JLabel lbl500;
    private JLabel lblDigite;
    private JLabel lblSaque;
    private JLabel lblVoltar;
    private ImageIcon saque;
    private ImageIcon voltar;
    private ImageIcon logo;
    private ImageIcon nota10;
    private ImageIcon nota20;
    private ImageIcon nota50;
    private ImageIcon nota100;
    private ImageIcon nota200;
    private ImageIcon nota500;
    public JLabel LblTitulo;
    private JTextField TxtValor;
    protected ResourceBundle bn = null;

    public ViewSacar(ResourceBundle bnn) {
        this.bn = bnn;
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.setTitle(Util.getBnu().getString("sacar.label.tituloJanela"));
        this.LblTitulo = new JLabel();
        this.lblDisponiveis = new JLabel(Util.getBnu().getString("dispenser.label.notasDisponiveis"));
        this.lblNotas = new JLabel(Util.getBnu().getString("dispenser.label.notas"));
        this.lblSaqueRapido = new JLabel(Util.getBnu().getString("sacar.label.saqueRapido"));
        this.nota10 = new ImageIcon(Util.getBnu().getString("sacar.botao.nota10"));
        this.lbl10 = new JLabel(this.nota10);
        this.nota20 = new ImageIcon(Util.getBnu().getString("sacar.botao.nota20"));
        this.lbl20 = new JLabel(this.nota20);
        this.nota50 = new ImageIcon(Util.getBnu().getString("sacar.botao.nota50"));
        this.lbl50 = new JLabel(this.nota50);
        this.nota100 = new ImageIcon(Util.getBnu().getString("sacar.botao.nota100"));
        this.lbl100 = new JLabel(this.nota100);
        this.nota200 = new ImageIcon(Util.getBnu().getString("sacar.botao.nota200"));
        this.lbl200 = new JLabel(this.nota200);
        this.nota500 = new ImageIcon(Util.getBnu().getString("sacar.botao.nota500"));
        this.lbl500 = new JLabel(this.nota500);
        this.lblDigite = new JLabel(Util.getBnu().getString("sacar.label.digite"));
        this.TxtValor = new JTextField();
        this.saque = new ImageIcon(Util.getBnu().getString("sacar.botao.realizarSaque"));
        this.lblSaque = new JLabel(this.saque);
        this.voltar = new ImageIcon(Util.getBnu().getString("transferencia.botao.voltar"));
        this.lblVoltar = new JLabel(this.voltar);
        this.logo = new ImageIcon(Util.getBnu().getString("login.botao.logo"));
        this.lblLogo = new JLabel(this.logo);
        this.painelGrid3 = new JPanel();
        this.painelGrid3.setLayout(new GridLayout(1, 3, 0, 0));
        this.painelGrid3.add(this.lbl10);
        this.painelGrid3.add(this.lbl20);
        this.painelGrid3.add(this.lbl50);
        this.painelGrid4 = new JPanel();
        this.painelGrid4.setLayout(new GridLayout(1, 3, 0, 0));
        this.painelGrid4.add(this.lbl100);
        this.painelGrid4.add(this.lbl200);
        this.painelGrid4.add(this.lbl500);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(6, 1, 0, 0));
        this.painelGrid1.add(this.lblDisponiveis);
        this.painelGrid1.add(this.lblNotas);
        this.painelGrid1.add(this.lblSaqueRapido);
        this.painelGrid1.add(this.painelGrid3);
        this.painelGrid1.add(this.lblDigite);
        this.painelGrid1.add(this.lblSaque);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(6, 1, 0, 0));
        this.painelGrid2.add(this.lblLogo);
        this.painelGrid2.add(new JLabel(""));
        this.painelGrid2.add(new JLabel(""));
        this.painelGrid2.add(this.painelGrid4);
        this.painelGrid2.add(this.TxtValor);
        this.painelGrid2.add(this.lblVoltar);
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
        this.setSize(800, 460);
        this.setVisible(true);
    }

    public void setValor(double transferencia) {
        this.TxtValor.setText(String.valueOf(transferencia));
    }

    public Double getValor() {
        return Double.valueOf(this.TxtValor.getText());
    }

    public void addSacarListener(MouseListener a) {
        this.lblSaque.addMouseListener(a);
    }

    public void addVoltarListener(MouseListener a) {
        this.lblVoltar.addMouseListener(a);
    }

    public void addNota10Listener(MouseListener a) {
        this.lbl10.addMouseListener(a);
    }

    public void addNota20Listener(MouseListener a) {
        this.lbl20.addMouseListener(a);
    }

    public void addNota50Listener(MouseListener a) {
        this.lbl50.addMouseListener(a);
    }

    public void addNota100Listener(MouseListener a) {
        this.lbl100.addMouseListener(a);
    }

    public void addNota200Listener(MouseListener a) {
        this.lbl200.addMouseListener(a);
    }

    public void addNota500Listener(MouseListener a) {
        this.lbl500.addMouseListener(a);
    }
}

