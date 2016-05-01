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

public class ViewMenuAdm
extends JFrame {
    private JPanel painelGrid1;
    private JLabel lblTitulo;
    private JLabel lblGerarRelatorios;
    private JLabel lblConsultarDispenser;
    private JLabel lblEncerrar;
    private JLabel lblLogo;
    private ImageIcon relatorios;
    private ImageIcon dispenser;
    private ImageIcon encerrar;
    private ImageIcon logo;
    protected ResourceBundle bn = null;

    public ViewMenuAdm(ResourceBundle bnn) {
        this.bn = bnn;
        this.setTitle(Util.getBnu().getString("menuAdm.label.tituloJanela"));
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.lblTitulo = new JLabel(Util.getBnu().getString("menuAdm.label.titulo"));
        this.relatorios = new ImageIcon(Util.getBnu().getString("menuAdm.botao.gerarRelatorios"));
        this.lblGerarRelatorios = new JLabel(this.relatorios);
        this.dispenser = new ImageIcon(Util.getBnu().getString("menuAdm.botao.consultarDispenser"));
        this.lblConsultarDispenser = new JLabel(this.dispenser);
        this.encerrar = new ImageIcon(Util.getBnu().getString("menuAdm.botao.encerrar"));
        this.lblEncerrar = new JLabel(this.encerrar);
        this.logo = new ImageIcon("Logo.png");
        this.lblLogo = new JLabel(this.logo);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(3, 2, 0, 0));
        this.painelGrid1.add(this.lblGerarRelatorios);
        this.painelGrid1.add(this.lblLogo);
        this.painelGrid1.add(this.lblEncerrar);
        this.painelGrid1.add(this.lblConsultarDispenser);
        tela.add((Component)this.lblTitulo, "North");
        tela.add((Component)this.painelGrid1, "Center");
        Color corBorda = new Color(45, 95, 143);
        this.painelGrid1.setBorder(BorderFactory.createLineBorder(corBorda, 7));
        tela.setBackground(corBorda);
        Color corFundo = new Color(192, 192, 192);
        this.painelGrid1.setBackground(corFundo);
        this.setSize(500, 460);
        this.setVisible(true);
    }

    public void addGerarRelatoriosListener(MouseListener a) {
        this.lblGerarRelatorios.addMouseListener(a);
    }

    public void addConsultarDispenserListener(MouseListener a) {
        this.lblConsultarDispenser.addMouseListener(a);
    }

    public void addEncerrarListener(MouseListener a) {
        this.lblEncerrar.addMouseListener(a);
    }
}

