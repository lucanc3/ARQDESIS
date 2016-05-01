package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

public class ControleGerarRelatorio
extends ViewGerarRelatorio {
    protected Conta conta;

    public ControleGerarRelatorio(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.addVoltarListener(new VoltarListener());
    }

    class VoltarListener
    extends MouseAdapter
    implements MouseListener {
        VoltarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleGerarRelatorio.this.dispose();
            ControleMenuAdm appCli = new ControleMenuAdm(ControleGerarRelatorio.this.bn, ControleGerarRelatorio.this.conta);
            appCli.setDefaultCloseOperation(3);
        }
    }

}

