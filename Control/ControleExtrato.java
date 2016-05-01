package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

public class ControleExtrato
extends ViewExtrato {
    protected Conta conta;

    public ControleExtrato(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addVoltarListener(new VoltarListener());
        this.addConsultarListener(new ConsultarListener());
    }

    class ConsultarListener
    extends MouseAdapter
    implements MouseListener {
        ConsultarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }
    }

    class VoltarListener
    extends MouseAdapter
    implements MouseListener {
        VoltarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleExtrato.this.dispose();
            ControleMenuCliente app = new ControleMenuCliente(ControleExtrato.this.bn, ControleExtrato.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

