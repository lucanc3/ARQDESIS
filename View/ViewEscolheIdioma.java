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
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ViewEscolheIdioma
extends JFrame {
    private JLabel lblPT;
    private JLabel lblEN;
    private JLabel lblLogo;
    private ImageIcon PT;
    private ImageIcon EN;
    private ImageIcon logo;
    private JPanel painelGrid;

    public ViewEscolheIdioma() {
        super("Acesso - NOPRANT");
        this.setLayout(new BorderLayout());
        Container tela = this.getContentPane();
        this.logo = new ImageIcon("logo.png");
        this.lblLogo = new JLabel(this.logo);
        this.PT = new ImageIcon("BotaoPortugues.png");
        this.lblPT = new JLabel(this.PT);
        this.EN = new ImageIcon("BotaoEnglish.png");
        this.lblEN = new JLabel(this.EN);
        this.painelGrid = new JPanel();
        this.painelGrid.setLayout(new GridLayout(3, 1, 0, 0));
        this.painelGrid.add(this.lblLogo);
        this.painelGrid.add(this.lblPT);
        this.painelGrid.add(this.lblEN);
        this.painelGrid.setBorder(BorderFactory.createLineBorder(Color.WHITE, 7));
        Color corFundo = new Color(45, 95, 143);
        tela.setBackground(corFundo);
        this.painelGrid.setBackground(corFundo);
        tela.add((Component)this.painelGrid, "Center");
        this.setSize(500, 460);
        this.setVisible(true);
    }

    public void addIdiomaPTListener(MouseListener a) {
        this.lblPT.addMouseListener(a);
    }

    public void addIdiomaENListener(MouseListener a) {
        this.lblEN.addMouseListener(a);
    }

    public static void main(String[] args) {
        ViewEscolheIdioma app = new ViewEscolheIdioma();
        app.setDefaultCloseOperation(3);
    }
}

