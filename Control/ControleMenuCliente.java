package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

public class ControleMenuCliente
extends ViewMenuCliente {
    protected Conta conta;

    public ControleMenuCliente(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addTransferenciaListener(new TransferenciaListener());
        this.addExtratoListener(new ExtratoListener());
        this.addCadastrarDebListener(new CadastrarDebListener());
        this.addConsultarSaldoListener(new ConsultarSaldoListener());
        this.addRealizarSaqueListener(new RealizarSaqueListener());
        this.addEncerrarListener(new EncerrarListener());
    }

    class CadastrarDebListener
    extends MouseAdapter
    implements MouseListener {
        CadastrarDebListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleMenuCliente.this.setVisible(false);
            ControleCadastrarDebito app = new ControleCadastrarDebito(ControleMenuCliente.this.bn, ControleMenuCliente.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

    class ConsultarSaldoListener
    extends MouseAdapter
    implements MouseListener {
        ConsultarSaldoListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleMenuCliente.this.setVisible(false);
            ControleSaldo app = new ControleSaldo(ControleMenuCliente.this.bn, ControleMenuCliente.this.conta);
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
            System.exit(0);
        }
    }

    class ExtratoListener
    extends MouseAdapter
    implements MouseListener {
        ExtratoListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleMenuCliente.this.setVisible(false);
            ControleExtrato app = new ControleExtrato(ControleMenuCliente.this.bn, ControleMenuCliente.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

    class RealizarSaqueListener
    extends MouseAdapter
    implements MouseListener {
        RealizarSaqueListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleMenuCliente.this.setVisible(false);
            ControleSacar app = new ControleSacar(ControleMenuCliente.this.bn, ControleMenuCliente.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

    class TransferenciaListener
    extends MouseAdapter
    implements MouseListener {
        TransferenciaListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleMenuCliente.this.setVisible(false);
            ControleTransferencia app = new ControleTransferencia(ControleMenuCliente.this.bn, ControleMenuCliente.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

