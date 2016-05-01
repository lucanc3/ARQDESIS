package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

public class ControleMenuAdm
extends ViewMenuAdm {
    protected Conta conta;

    public ControleMenuAdm(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addGerarRelatoriosListener(new GerarRelatoriosListener());
        this.addConsultarDispenserListener(new ConsultarDispenserListener());
        this.addEncerrarListener(new EncerrarListener());
    }

    class ConsultarDispenserListener
    extends MouseAdapter
    implements MouseListener {
        ConsultarDispenserListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleMenuAdm.this.setVisible(false);
            ControleConsultarDispenser app = new ControleConsultarDispenser(ControleMenuAdm.this.bn, ControleMenuAdm.this.conta);
            app.setDefaultCloseOperation(3);
        }
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

    class GerarRelatoriosListener
    extends MouseAdapter
    implements MouseListener {
        GerarRelatoriosListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleMenuAdm.this.setVisible(false);
            ControleGerarRelatorio app = new ControleGerarRelatorio(ControleMenuAdm.this.bn, ControleMenuAdm.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

