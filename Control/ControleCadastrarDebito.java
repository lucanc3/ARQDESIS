package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

public class ControleCadastrarDebito
extends ViewCadastrarDebito {
    protected Conta conta;

    public ControleCadastrarDebito(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addVoltarListener(new VoltarListener());
        this.addCadastrarListener(new CadastrarListener());
    }

    class CadastrarListener
    extends MouseAdapter
    implements MouseListener {
        CadastrarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleCadastrarDebito.this.setVisible(false);
            ControleTransferencia app = new ControleTransferencia(ControleCadastrarDebito.this.bn, ControleCadastrarDebito.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

    class VoltarListener
    extends MouseAdapter
    implements MouseListener {
        VoltarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleCadastrarDebito.this.dispose();
            ControleMenuCliente app = new ControleMenuCliente(ControleCadastrarDebito.this.bn, ControleCadastrarDebito.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

