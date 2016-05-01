package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class ControleCodigoAcesso
extends ViewCodigoAcesso {
    protected Conta conta;

    public ControleCodigoAcesso(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addEntrarListener(new EntrarListener());
        this.addEncerrarListener(new EncerrarListener());
    }

    class EncerrarListener
    extends MouseAdapter
    implements MouseListener {
        EncerrarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(128);
        }
    }

    class EntrarListener
    extends MouseAdapter
    implements MouseListener {
        EntrarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (ControleCodigoAcesso.this.getCodigo().equals(ControleCodigoAcesso.this.conta.getCodigo())) {
                if (ControleCodigoAcesso.this.conta.getAgencia().equals("101") && ControleCodigoAcesso.this.conta.getConta().equals("101")) {
                    ControleCodigoAcesso.this.setVisible(false);
                    ControleMenuAdm app = new ControleMenuAdm(ControleCodigoAcesso.this.bn, ControleCodigoAcesso.this.conta);
                    app.setDefaultCloseOperation(3);
                } else {
                    ControleCodigoAcesso.this.setVisible(false);
                    ControleMenuCliente appCli = new ControleMenuCliente(ControleCodigoAcesso.this.bn, ControleCodigoAcesso.this.conta);
                    appCli.setDefaultCloseOperation(3);
                }
            } else {
                JOptionPane.showMessageDialog(null, "C\u00f3digo incorreto");
            }
        }
    }

}

