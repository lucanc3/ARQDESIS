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

public class ViewCadastrarCodigoAcesso
extends JFrame {
    private JPanel painelGrid1;
    private JPanel painelGrid2;
    private JPanel painelGridPrincipal;
    private JPanel painelGrid3;
    protected JLabel LblTitulo;
    protected JLabel LblOperadora;
    protected JLabel LblLogo;
    protected JLabel LblGerar;
    protected JLabel LblEncerrar;
    protected JLabel LblResultado;
    private ImageIcon gerar;
    private ImageIcon voltar;
    private ImageIcon logo;
    private ImageIcon encerrar;
    protected ResourceBundle bn = null;

    public ViewCadastrarCodigoAcesso(ResourceBundle bnn) {
        this.bn = bnn;
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.setTitle(Util.getBnu().getString("gerarCodigoAcesso.label.tituloJanela"));
        this.LblTitulo = new JLabel(Util.getBnu().getString("gerarCodigoAcesso.label.titulo"));
        this.LblOperadora = new JLabel(Util.getBnu().getString("gerarCodigoAcesso.label.cadastrar"));
        this.LblResultado = new JLabel(Util.getBnu().getString("gerarCodigoAcesso.label.codigo"));
        this.logo = new ImageIcon(Util.getBnu().getString("login.botao.logo"));
        this.LblLogo = new JLabel(this.logo);
        this.gerar = new ImageIcon(Util.getBnu().getString("gerarCodigoAcesso.botao.gerar"));
        this.LblGerar = new JLabel(this.gerar);
        this.encerrar = new ImageIcon(Util.getBnu().getString("gerarCodigoAcesso.botao.encerrar"));
        this.LblEncerrar = new JLabel(this.encerrar);
        this.painelGrid3 = new JPanel();
        this.painelGrid3.setLayout(new GridLayout(1, 2, 0, 0));
        this.painelGrid3.add(this.LblGerar);
        this.painelGrid3.add(this.LblEncerrar);
        this.painelGrid1 = new JPanel();
        this.painelGrid1.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGrid1.add(this.LblOperadora);
        this.painelGrid1.add(this.LblResultado);
        this.painelGrid1.add(this.painelGrid3);
        this.painelGrid2 = new JPanel();
        this.painelGrid2.setLayout(new GridLayout(1, 1, 0, 0));
        this.painelGrid2.add(this.LblLogo);
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
        this.painelGrid3.setBackground(corFundo);
        this.setSize(500, 460);
        this.setVisible(true);
    }

    public void setResultado(int resultado) {
        this.LblResultado.setText(String.valueOf(resultado));
    }

    public int getResultado() {
        return Integer.valueOf(this.LblResultado.getText());
    }

    public void addEncerrarListener(MouseListener a) {
        this.LblEncerrar.addMouseListener(a);
    }

    public void addGerarListener(MouseListener a) {
        this.LblGerar.addMouseListener(a);
    }
}

