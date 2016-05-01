package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ControleCadastrarCodigoAcesso
extends ViewCadastrarCodigoAcesso {
    protected Conta conta;
    protected String codigoAcesso;

    public ControleCadastrarCodigoAcesso(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addEncerrarListener(new EncerrarListener());
        this.addGerarListener(new GerarListener());
    }

    class EncerrarListener
    extends MouseAdapter
    implements MouseListener {
        EncerrarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(1);
        }
    }

    class GerarListener
    extends MouseAdapter
    implements MouseListener {
        GerarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleCadastrarCodigoAcesso.this.codigoAcesso = "" + (int)(Math.random() * 10.0) + (int)(Math.random() * 10.0) + (int)(Math.random() * 10.0);
            ControleCadastrarCodigoAcesso.this.LblResultado.setText(ControleCadastrarCodigoAcesso.this.codigoAcesso);
            JOptionPane.showMessageDialog(null, "O c\u00f3digo de acesso \u00e9: " + ControleCadastrarCodigoAcesso.this.codigoAcesso);
            ManipulaArray controle = new ManipulaArray();
            ControleCadastrarCodigoAcesso.this.conta.setCodigo(ControleCadastrarCodigoAcesso.this.codigoAcesso);
            try {
                controle.salvaCodigoAcesso(ControleCadastrarCodigoAcesso.this.conta);
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
            ControleCadastrarCodigoAcesso.this.setVisible(false);
            ControleCodigoAcesso app = new ControleCodigoAcesso(ControleCadastrarCodigoAcesso.this.bn, ControleCadastrarCodigoAcesso.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

