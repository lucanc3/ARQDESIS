/*
 * Decompiled with CFR 0_114.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.Border;

public class ViewCodigoAcesso
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel gridTop;
    private JPanel gridCenter;
    private JLabel lblTitulo;
    private JLabel lblLogo;
    private JLabel lblEntrar;
    private JLabel lblEncerrar;
    private JLabel lbl0;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private ImageIcon logo;
    private ImageIcon entrar;
    private ImageIcon encerrar;
    private JPasswordField codigo;
    private int[] v = new int[10];
    protected ResourceBundle bn = null;

    public ViewCodigoAcesso(ResourceBundle bnn) {
        this.bn = bnn;
        this.setTitle(Util.getBnu().getString("codigoAcesso.label.tituloJanela"));
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.codigo = new JPasswordField();
        this.codigo.setPreferredSize(new Dimension(230, 30));
        this.lblTitulo = new JLabel(Util.getBnu().getString("codigoAcesso.label.titulo"));
        this.logo = new ImageIcon("Logo.png");
        this.lblLogo = new JLabel(this.logo);
        this.entrar = new ImageIcon(Util.getBnu().getString("codigoAcesso.botao.entrar"));
        this.lblEntrar = new JLabel(this.entrar);
        this.encerrar = new ImageIcon(Util.getBnu().getString("codigoAcesso.botao.encerrar"));
        this.lblEncerrar = new JLabel(this.encerrar);
        int i = 0;
        while (i < this.v.length) {
            this.v[i] = (int)(Math.random() * 10.0);
            int k = i - 1;
            while (k >= 0) {
                if (this.v[k] == this.v[i]) {
                    --i;
                    break;
                }
                --k;
            }
            ++i;
        }
        this.lbl0 = new JLabel("" + this.v[0] + " -  " + this.v[1], 0);
        this.lbl0.setFont(new Font("Dialog", 0, 20));
        this.lbl0.setBackground(Color.WHITE);
        this.lbl0.setPreferredSize(new Dimension(60, 60));
        this.lbl0.setOpaque(true);
        this.lbl0.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.lbl1 = new JLabel("" + this.v[2] + " -  " + this.v[3], 0);
        this.lbl1.setFont(new Font("Dialog", 0, 20));
        this.lbl1.setBackground(Color.WHITE);
        this.lbl1.setOpaque(true);
        this.lbl1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.lbl2 = new JLabel("" + this.v[4] + " -  " + this.v[5], 0);
        this.lbl2.setFont(new Font("Dialog", 0, 20));
        this.lbl2.setBackground(Color.WHITE);
        this.lbl2.setOpaque(true);
        this.lbl2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.lbl3 = new JLabel("" + this.v[6] + " -  " + this.v[7], 0);
        this.lbl3.setFont(new Font("Dialog", 0, 20));
        this.lbl3.setBackground(Color.WHITE);
        this.lbl3.setOpaque(true);
        this.lbl3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.lbl4 = new JLabel("" + this.v[8] + " -  " + this.v[9], 0);
        this.lbl4.setFont(new Font("Dialog", 0, 20));
        this.lbl4.setBackground(Color.WHITE);
        this.lbl4.setOpaque(true);
        this.lbl4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.gridTop = new JPanel();
        this.gridTop.setLayout(new GridLayout(1, 2, 0, 0));
        this.gridTop.add(this.lblTitulo);
        this.gridTop.add(this.lblLogo);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(1, 2, 0, 0));
        this.painelGrid1.add(this.lblEncerrar);
        this.painelGrid1.add(this.lblEntrar);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(1, 5, 0, 0));
        this.painelGrid2.add(this.lbl0);
        this.painelGrid2.add(this.lbl1);
        this.painelGrid2.add(this.lbl2);
        this.painelGrid2.add(this.lbl3);
        this.painelGrid2.add(this.lbl4);
        this.gridCenter = new JPanel();
        this.gridCenter.setLayout(new FlowLayout());
        this.gridCenter.add(this.codigo);
        this.gridCenter.add(this.painelGrid2);
        tela.add((Component)this.gridTop, "North");
        tela.add((Component)this.gridCenter, "Center");
        tela.add((Component)this.painelGrid1, "South");
        Color corBorda = new Color(45, 95, 143);
        this.gridCenter.setBorder(BorderFactory.createLineBorder(corBorda, 7));
        tela.setBackground(corBorda);
        Color corFundo = new Color(192, 192, 192);
        this.painelGrid1.setBackground(corFundo);
        this.painelGrid2.setBackground(corFundo);
        this.gridTop.setBackground(corFundo);
        this.gridCenter.setBackground(corFundo);
        this.setSize(500, 460);
        this.setVisible(true);
    }

    public void setCodigo(int sCodigo) {
        this.codigo.setText(String.valueOf(sCodigo));
    }

    public String getCodigo() {
        return String.valueOf(this.codigo.getText());
    }

    public void addEntrarListener(MouseListener a) {
        this.lblEntrar.addMouseListener(a);
    }

    public void addEncerrarListener(MouseListener a) {
        this.lblEncerrar.addMouseListener(a);
    }
}

