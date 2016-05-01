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

public class ViewMenuCliente
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JLabel lblTitulo;
    private JLabel lblTransferencia;
    private JLabel lblExtrato;
    private JLabel lblCadastrarDeb;
    private JLabel lblConsultarSaldo;
    private JLabel LblLogo;
    private JLabel lblRealizarSaque;
    private JLabel lblEncerrar;
    private ImageIcon transferencia;
    private ImageIcon extrato;
    private ImageIcon cadastrarDeb;
    private ImageIcon cnsultarSaldo;
    private ImageIcon logo;
    private ImageIcon realizarSaque;
    private ImageIcon encerrar;
    protected ResourceBundle bn = null;

    public ViewMenuCliente(ResourceBundle bnn) {
        this.bn = bnn;
        this.setTitle(Util.getBnu().getString("menuCli.label.tituloJanela"));
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.lblTitulo = new JLabel(Util.getBnu().getString("menuCli.label.titulo"));
        this.transferencia = new ImageIcon(Util.getBnu().getString("menuCli.botao.tranferencia"));
        this.lblTransferencia = new JLabel(this.transferencia);
        this.extrato = new ImageIcon(Util.getBnu().getString("menuCli.botao.extrato"));
        this.lblExtrato = new JLabel(this.extrato);
        this.cadastrarDeb = new ImageIcon(Util.getBnu().getString("menuCli.botao.cadastrarDeb"));
        this.lblCadastrarDeb = new JLabel(this.cadastrarDeb);
        this.cnsultarSaldo = new ImageIcon(Util.getBnu().getString("menuCli.botao.consultarSaldo"));
        this.lblConsultarSaldo = new JLabel(this.cnsultarSaldo);
        this.logo = new ImageIcon("Logo.png");
        this.LblLogo = new JLabel(this.logo);
        this.realizarSaque = new ImageIcon(Util.getBnu().getString("menuCli.botao.realizarSaque"));
        this.lblRealizarSaque = new JLabel(this.realizarSaque);
        this.encerrar = new ImageIcon(Util.getBnu().getString("menuAdm.botao.encerrar"));
        this.lblEncerrar = new JLabel(this.encerrar);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(4, 1, 0, 0));
        this.painelGrid1.add(this.lblTransferencia);
        this.painelGrid1.add(this.lblExtrato);
        this.painelGrid1.add(this.lblCadastrarDeb);
        this.painelGrid1.add(this.lblConsultarSaldo);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGrid2.add(this.LblLogo);
        this.painelGrid2.add(this.lblRealizarSaque);
        this.painelGrid2.add(this.lblEncerrar);
        this.painelGridPrincipal = new JPanel();
        this.painelGridPrincipal.setLayout(new GridLayout(1, 2, 0, 0));
        this.painelGridPrincipal.add(this.painelGrid1);
        this.painelGridPrincipal.add(this.painelGrid2);
        tela.add((Component)this.lblTitulo, "North");
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

    public void addTransferenciaListener(MouseListener a) {
        this.lblTransferencia.addMouseListener(a);
    }

    public void addExtratoListener(MouseListener a) {
        this.lblExtrato.addMouseListener(a);
    }

    public void addCadastrarDebListener(MouseListener a) {
        this.lblCadastrarDeb.addMouseListener(a);
    }

    public void addConsultarSaldoListener(MouseListener a) {
        this.lblConsultarSaldo.addMouseListener(a);
    }

    public void addRealizarSaqueListener(MouseListener a) {
        this.lblRealizarSaque.addMouseListener(a);
    }

    public void addEncerrarListener(MouseListener a) {
        this.lblEncerrar.addMouseListener(a);
    }
}

