package Control;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControleEscolheIdioma
extends ViewEscolheIdioma {
    private ResourceBundle bn = null;

    public ControleEscolheIdioma() {
        this.addIdiomaPTListener(new PTListener());
        this.addIdiomaENListener(new ENListener());
    }

    static /* synthetic */ void access$0(ControleEscolheIdioma controleEscolheIdioma, ResourceBundle resourceBundle) {
        controleEscolheIdioma.bn = resourceBundle;
    }

    class ENListener
    extends MouseAdapter
    implements MouseListener {
        ENListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleEscolheIdioma.this.setVisible(false);
            ControleEscolheIdioma.access$0(ControleEscolheIdioma.this, ResourceBundle.getBundle("NOPRANT", Locale.US));
            Util.setBnu(ControleEscolheIdioma.this.bn);
            ControleLogin app = new ControleLogin(ControleEscolheIdioma.this.bn);
            app.setDefaultCloseOperation(3);
        }
    }

    class PTListener
    extends MouseAdapter
    implements MouseListener {
        PTListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            ControleEscolheIdioma.this.setVisible(false);
            ControleEscolheIdioma.access$0(ControleEscolheIdioma.this, ResourceBundle.getBundle("NOPRANT", new Locale("pt", "BR")));
            ControleLogin app = new ControleLogin(ControleEscolheIdioma.this.bn);
            app.setDefaultCloseOperation(3);
        }
    }

}

