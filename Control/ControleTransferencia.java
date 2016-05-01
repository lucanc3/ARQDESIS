package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class ControleTransferencia
extends ViewTransferencia {
    protected Conta conta;

    public ControleTransferencia(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addVoltarListener(new VoltarListener());
        this.addTransferirListener(new TransferirListener());
    }

    class TransferirListener
    extends MouseAdapter
    implements MouseListener {
        TransferirListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JOptionPane.showMessageDialog(null, ControleTransferencia.this.bn.getString("transferenciaControle.message.transferido"));
        }
    }

    class VoltarListener
    extends MouseAdapter
    implements MouseListener {
        VoltarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleTransferencia.this.dispose();
            ControleMenuCliente app = new ControleMenuCliente(ControleTransferencia.this.bn, ControleTransferencia.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

