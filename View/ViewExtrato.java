/*
 * Decompiled with CFR 0_114.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ViewExtrato
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JPanel panelDataIni;
    private JPanel panelDataFini;
    private JLabel lblTitulo;
    private JLabel lblVoltar;
    private JLabel lblDataInicial;
    private JLabel lblDataFinal;
    private JLabel lblLogo;
    private JLabel lblConsultar;
    private ImageIcon consultar;
    private ImageIcon voltar;
    private ImageIcon logo;
    private final JTextField txtDataInicial;
    private final JTextField txtDataFinal;
    private JRadioButton dias7;
    private JRadioButton dias15;
    private ButtonGroup radioGrupoDias;
    private JButton btnDataInicial;
    private JButton btnDataFinal;
    private DatePicker dataInicial;
    private DatePicker dataFinal;
    protected ResourceBundle bn = null;

    public ViewExtrato(ResourceBundle bnn) {
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.bn = bnn;
        this.setTitle(Util.getBnu().getString("extrato.label.tituloJanela"));
        this.lblTitulo = new JLabel(Util.getBnu().getString("extrato.label.titulo"));
        this.lblDataInicial = new JLabel(Util.getBnu().getString("extrato.label.dataInicial"));
        this.lblDataFinal = new JLabel(Util.getBnu().getString("extrato.label.dataFinal"));
        this.voltar = new ImageIcon(Util.getBnu().getString("extrato.botao.voltar"));
        this.lblVoltar = new JLabel(this.voltar);
        this.logo = new ImageIcon("Logo.png");
        this.lblLogo = new JLabel(this.logo);
        this.consultar = new ImageIcon(Util.getBnu().getString("extrato.botao.extrato"));
        this.lblConsultar = new JLabel(this.consultar);
        this.dias7 = new JRadioButton("7 Dias", false);
        this.dias15 = new JRadioButton("15 Dias", false);
        this.radioGrupoDias = new ButtonGroup();
        this.radioGrupoDias.add(this.dias7);
        this.radioGrupoDias.add(this.dias15);
        this.txtDataInicial = new JTextField(10);
        this.dataInicial = new DatePicker();
        ImageIcon iconeIni = this.dataInicial.getImage();
        this.btnDataInicial = new JButton(iconeIni);
        this.btnDataInicial.setPreferredSize(new Dimension(30, 24));
        this.btnDataInicial.setMargin(new Insets(0, 0, 0, 0));
        this.btnDataInicial.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ViewExtrato.this.dataInicial.setDate(ViewExtrato.this.txtDataInicial.getText());
                ViewExtrato.this.dataInicial.popupShow(ViewExtrato.this.btnDataInicial);
            }
        });
        this.dataInicial.addPopupListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ViewExtrato.this.txtDataInicial.setText(ViewExtrato.this.dataInicial.getFormattedDate());
                ViewExtrato.this.dataInicial.popupHide();
            }
        });
        this.panelDataIni = new JPanel();
        this.panelDataIni.setLayout(new FlowLayout());
        this.panelDataIni.add(this.txtDataInicial);
        this.panelDataIni.add(this.btnDataInicial);
        this.txtDataFinal = new JTextField(10);
        this.dataFinal = new DatePicker();
        ImageIcon iconeFini = this.dataFinal.getImage();
        this.btnDataFinal = new JButton(iconeFini);
        this.btnDataFinal.setPreferredSize(new Dimension(30, 24));
        this.btnDataFinal.setMargin(new Insets(0, 0, 0, 0));
        this.btnDataFinal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ViewExtrato.this.dataFinal.setDate(ViewExtrato.this.txtDataFinal.getText());
                ViewExtrato.this.dataFinal.popupShow(ViewExtrato.this.btnDataFinal);
            }
        });
        this.dataFinal.addPopupListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ViewExtrato.this.txtDataFinal.setText(ViewExtrato.this.dataFinal.getFormattedDate());
                ViewExtrato.this.dataFinal.popupHide();
            }
        });
        this.panelDataFini = new JPanel();
        this.panelDataFini.setLayout(new FlowLayout());
        this.panelDataFini.add(this.txtDataFinal);
        this.panelDataFini.add(this.btnDataFinal);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(8, 1, 0, 0));
        this.painelGrid1.add(this.lblTitulo);
        this.painelGrid1.add(this.dias7);
        this.painelGrid1.add(this.dias15);
        this.painelGrid1.add(this.lblDataInicial);
        this.painelGrid1.add(this.panelDataIni);
        this.painelGrid1.add(this.lblDataFinal);
        this.painelGrid1.add(this.panelDataFini);
        this.painelGrid1.add(this.lblConsultar);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGrid2.add(this.lblLogo);
        this.painelGrid2.add(new Label(""));
        this.painelGrid2.add(this.lblVoltar);
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

    public void addVoltarListener(MouseListener a) {
        this.lblVoltar.addMouseListener(a);
    }

    public void addConsultarListener(MouseListener a) {
        this.lblConsultar.addMouseListener(a);
    }

}

