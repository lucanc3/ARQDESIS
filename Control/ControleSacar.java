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

public class ControleSacar
extends ViewSacar {
    Conta conta = new Conta();

    public ControleSacar(ResourceBundle bnn, Conta conta) {
        super(bnn);
        this.conta = conta;
        this.addVoltarListener(new VoltarListener());
        this.addSacarListener(new TransferirListener());
        this.addNota10Listener(new Nota10Listener());
        this.addNota20Listener(new Nota20Listener());
        this.addNota50Listener(new Nota50Listener());
        this.addNota100Listener(new Nota100Listener());
        this.addNota200Listener(new Nota200Listener());
        this.addNota500Listener(new Nota500Listener());
    }

    class Nota100Listener
    extends MouseAdapter
    implements MouseListener {
        Nota100Listener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleSacar.this.setValor(100.0);
        }
    }

    class Nota10Listener
    extends MouseAdapter
    implements MouseListener {
        Nota10Listener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleSacar.this.setValor(10.0);
        }
    }

    class Nota200Listener
    extends MouseAdapter
    implements MouseListener {
        Nota200Listener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleSacar.this.setValor(200.0);
        }
    }

    class Nota20Listener
    extends MouseAdapter
    implements MouseListener {
        Nota20Listener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleSacar.this.setValor(20.0);
        }
    }

    class Nota500Listener
    extends MouseAdapter
    implements MouseListener {
        Nota500Listener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleSacar.this.setValor(500.0);
        }
    }

    class Nota50Listener
    extends MouseAdapter
    implements MouseListener {
        Nota50Listener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleSacar.this.setValor(50.0);
        }
    }

    class TransferirListener
    extends MouseAdapter
    implements MouseListener {
        TransferirListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            DAOSacar daoSacar = new DAOSacar(ControleSacar.this.conta);
            String dados = daoSacar.consultaPorCodigo();
            ControleSacar.this.LblTitulo.setText(String.valueOf(dados));
            if (ControleSacar.this.getValor() < ControleSacar.this.conta.getSaldo()) {
                double resultado = ControleSacar.this.conta.getSaldo() - ControleSacar.this.getValor();
                daoSacar.sacar(resultado);
                JOptionPane.showMessageDialog(null, ControleSacar.this.bn.getString("sacar.mensagem.realizarSaque"));
            } else {
                JOptionPane.showMessageDialog(null, ControleSacar.this.bn.getString("sacar.mensagem.saldoInsuficiente"));
            }
        }
    }

    class VoltarListener
    extends MouseAdapter
    implements MouseListener {
        VoltarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleSacar.this.dispose();
            ControleMenuCliente app = new ControleMenuCliente(ControleSacar.this.bn, ControleSacar.this.conta);
            app.setDefaultCloseOperation(3);
        }
    }

}

