package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.JLabel;

public class ControleSaldo
extends ViewSaldo {
    Conta conta = new Conta();

    public ControleSaldo(ResourceBundle bnn, Conta conta) {
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
            DAOSaldo saldo = new DAOSaldo(ControleSaldo.this.conta);
            String resultado = saldo.Saldo();
            ControleSaldo.this.LblResultado.setText(String.valueOf(resultado));
            String dados = saldo.consultaPorCodigo();
            ControleSaldo.this.LblTitulo.setText(String.valueOf(dados));
        }
    }

    class VoltarListener
    extends MouseAdapter
    implements MouseListener {
        VoltarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleSaldo.this.dispose();
            ControleMenuCliente app = new ControleMenuCliente(ControleSaldo.this.bn, ControleSaldo.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

