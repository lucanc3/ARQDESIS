package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControleLogin
extends ViewLogin {
    public ControleLogin(ResourceBundle bnn) {
        super(bnn);
        this.addEntrarListener(new EntrarListener());
    }

    class EntrarListener
    extends MouseAdapter
    implements MouseListener {
        EntrarListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ManipulaArray controle = new ManipulaArray();
            Conta conta = new Conta();
            conta.setAgencia(ControleLogin.this.getAgencia());
            conta.setConta(ControleLogin.this.getConta());
            conta.setSenha(ControleLogin.this.getSenha());
            Conta contaValidada = null;
            try {
                contaValidada = controle.achaConta(conta);
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
            if (controle.respAgenciaConta) {
                if (controle.respSenha) {
                    JFrame app;
                    if (controle.respCodigo) {
                        ControleLogin.this.setVisible(false);
                        app = new ControleCadastrarCodigoAcesso(ControleLogin.this.bn, contaValidada);
                        app.setDefaultCloseOperation(3);
                    }
                    if (!controle.respCodigo) {
                        ControleLogin.this.setVisible(false);
                        app = new ControleCodigoAcesso(ControleLogin.this.bn, contaValidada);
                        app.setDefaultCloseOperation(3);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha Incorreta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Agencia ou Conta Incorreta");
            }
        }
    }

}

