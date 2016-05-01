/*
 * Decompiled with CFR 0_114.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
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

public class ViewCadastrarDebito
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JLabel LblTitulo;
    private JLabel LblOperadora;
    private JLabel LblVoltar;
    private JLabel LblLogo;
    private JLabel LblCadastrar;
    private ImageIcon cadastrar;
    private ImageIcon voltar;
    private ImageIcon logo;
    private JTextField TxtOperadora;
    protected ResourceBundle bn = null;

    public ViewCadastrarDebito(ResourceBundle bnn) {
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.bn = bnn;
        this.setTitle(Util.getBnu().getString("cadastrarDeb.label.tituloJanela"));
        this.LblTitulo = new JLabel(Util.getBnu().getString("cadastrarDeb.label.titulo"));
        this.LblOperadora = new JLabel(Util.getBnu().getString("cadastrarDeb.label.operadora"));
        this.TxtOperadora = new JTextField();
        this.voltar = new ImageIcon(Util.getBnu().getString("cadastrarDeb.botao.voltar"));
        this.LblVoltar = new JLabel(this.voltar);
        this.logo = new ImageIcon("Logo.png");
        this.LblLogo = new JLabel(this.logo);
        this.cadastrar = new ImageIcon(Util.getBnu().getString("cadastrarDeb.botao.cadastrar"));
        this.LblCadastrar = new JLabel(this.cadastrar);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGrid1.add(this.LblOperadora);
        this.painelGrid1.add(this.TxtOperadora);
        this.painelGrid1.add(this.LblCadastrar);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGrid2.add(this.LblLogo);
        this.painelGrid2.add(new Label(""));
        this.painelGrid2.add(this.LblVoltar);
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

    public void setOperadora(int notas) {
        this.TxtOperadora.setText(String.valueOf(notas));
    }

    public int getOperadora() {
        return Integer.valueOf(this.TxtOperadora.getText());
    }

    public void addVoltarListener(MouseListener a) {
        this.LblVoltar.addMouseListener(a);
    }

    public void addCadastrarListener(MouseListener a) {
        this.LblCadastrar.addMouseListener(a);
    }
}

