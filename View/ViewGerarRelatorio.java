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
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ViewGerarRelatorio
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JLabel lblTitulo;
    private JLabel lblVoltar;
    private JLabel lblLogo;
    private JLabel lblTotal;
    private JLabel lblMostraTotal;
    private JLabel lblPercentual;
    private JLabel lblMostraPercentual;
    private ImageIcon voltar;
    private ImageIcon logo;
    private JRadioButton transf;
    private JRadioButton extrato;
    private JRadioButton debAuto;
    private JRadioButton consSaldo;
    private JRadioButton saque;
    private ButtonGroup radioGrupoRelatorio;
    protected ResourceBundle bn = null;

    public ViewGerarRelatorio(ResourceBundle bnn) {
        this.bn = bnn;
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.setTitle(Util.getBnu().getString("gerarRelatorio.label.tituloJanela"));
        this.lblTitulo = new JLabel(Util.getBnu().getString("gerarRelatorio.label.titulo"));
        this.voltar = new ImageIcon(Util.getBnu().getString("transferencia.botao.voltar"));
        this.lblVoltar = new JLabel(this.voltar);
        this.logo = new ImageIcon(Util.getBnu().getString("login.botao.logo"));
        this.lblLogo = new JLabel(this.logo);
        this.lblTotal = new JLabel(Util.getBnu().getString("gerarRelatorio.label.total"));
        this.lblMostraTotal = new JLabel("9999");
        this.lblPercentual = new JLabel(Util.getBnu().getString("gerarRelatorio.label.percentual"));
        this.lblMostraPercentual = new JLabel("9999%");
        this.transf = new JRadioButton(Util.getBnu().getString("gerarRelatorio.radioB.transf"), false);
        this.extrato = new JRadioButton(Util.getBnu().getString("gerarRelatorio.radioB.extrato"), false);
        this.debAuto = new JRadioButton(Util.getBnu().getString("gerarRelatorio.radioB.debAuto"), false);
        this.consSaldo = new JRadioButton(Util.getBnu().getString("gerarRelatorio.radioB.consSaldo"), false);
        this.saque = new JRadioButton(Util.getBnu().getString("gerarRelatorio.radioB.saque"), false);
        this.radioGrupoRelatorio = new ButtonGroup();
        this.radioGrupoRelatorio.add(this.transf);
        this.radioGrupoRelatorio.add(this.extrato);
        this.radioGrupoRelatorio.add(this.debAuto);
        this.radioGrupoRelatorio.add(this.consSaldo);
        this.radioGrupoRelatorio.add(this.saque);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(2, 3, 0, 0));
        this.painelGrid2.add(this.lblTotal);
        this.painelGrid2.add(this.lblMostraTotal);
        this.painelGrid2.add(this.lblPercentual);
        this.painelGrid2.add(this.lblMostraPercentual);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(7, 1, 0, 0));
        this.painelGrid1.add(this.lblTitulo);
        this.painelGrid1.add(this.transf);
        this.painelGrid1.add(this.extrato);
        this.painelGrid1.add(this.debAuto);
        this.painelGrid1.add(this.consSaldo);
        this.painelGrid1.add(this.saque);
        this.painelGrid1.add(this.painelGrid2);
        this.painelGridPrincipal = new JPanel();
        this.painelGridPrincipal.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGridPrincipal.add(this.lblLogo);
        this.painelGridPrincipal.add(new JLabel(""));
        this.painelGridPrincipal.add(this.lblVoltar);
        tela.add((Component)this.painelGrid1, "Center");
        tela.add((Component)this.painelGridPrincipal, "East");
        Color corBorda = new Color(45, 95, 143);
        tela.setBackground(corBorda);
        Color corFundo = new Color(192, 192, 192);
        this.painelGrid1.setBackground(corFundo);
        this.painelGrid2.setBackground(corFundo);
        this.painelGridPrincipal.setBackground(corFundo);
        this.transf.setBackground(corFundo);
        this.extrato.setBackground(corFundo);
        this.debAuto.setBackground(corFundo);
        this.consSaldo.setBackground(corFundo);
        this.saque.setBackground(corFundo);
        this.setSize(500, 460);
        this.setVisible(true);
    }

    public void addVoltarListener(MouseListener a) {
        this.lblVoltar.addMouseListener(a);
    }
}

