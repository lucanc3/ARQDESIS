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
import javax.swing.border.Border;

public class ViewSaldo
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JLabel LblImprimir;
    private JLabel LblVoltar;
    private JLabel LblLogo;
    private JLabel LblRealizarSaque;
    private JLabel LblSaldo;
    protected JLabel LblResultado;
    protected JLabel LblTitulo;
    private ImageIcon imprimir;
    private ImageIcon voltar;
    private ImageIcon logo;
    protected ResourceBundle bn = null;

    public ViewSaldo(ResourceBundle bnn) {
        this.bn = bnn;
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.setTitle(Util.getBnu().getString("saldo.label.tituloJanela"));
        this.LblTitulo = new JLabel();
        this.imprimir = new ImageIcon(Util.getBnu().getString("saldo.botao.imprimir"));
        this.LblImprimir = new JLabel(this.imprimir);
        this.voltar = new ImageIcon(Util.getBnu().getString("transferencia.botao.voltar"));
        this.LblVoltar = new JLabel(this.voltar);
        this.logo = new ImageIcon(Util.getBnu().getString("login.botao.logo"));
        this.LblLogo = new JLabel(this.logo);
        this.LblSaldo = new JLabel(Util.getBnu().getString("saldo.label.saldo"));
        this.LblResultado = new JLabel();
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(2, 1, 0, 0));
        this.painelGrid1.add(this.LblSaldo);
        this.painelGrid1.add(this.LblResultado);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGrid2.add(this.LblLogo);
        this.painelGrid2.add(this.LblVoltar);
        this.painelGrid2.add(this.LblImprimir);
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

    public void addVoltarListener(MouseListener a) {
        this.LblVoltar.addMouseListener(a);
    }

    public void addTransferirListener(MouseListener a) {
        this.LblImprimir.addMouseListener(a);
    }
}

