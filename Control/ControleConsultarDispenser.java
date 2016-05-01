package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

public class ControleConsultarDispenser
extends ViewConsultarDispenser {
    protected Conta conta;

    public ControleConsultarDispenser(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addVoltarListener(new VoltarListener());
    }

    class VoltarListener
    extends MouseAdapter
    implements MouseListener {
        VoltarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleConsultarDispenser.this.dispose();
            ControleMenuAdm app = new ControleMenuAdm(ControleConsultarDispenser.this.bn, ControleConsultarDispenser.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

