package Model;
/*
 * Decompiled with CFR 0_114.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class CryptoDummy {
    private byte[] textoCifrado = null;
    private byte[] textoDecifrado = null;

    public void geraChave(File fDummy) throws IOException {
        int dk = (int)(Math.random() * 101.0);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fDummy));
        oos.writeObject(dk);
        oos.close();
    }

    public void geraCifra(byte[] texto, File fDummy) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fDummy));
        int iDummy = (Integer)ois.readObject();
        ois.close();
        this.textoCifrado = texto;
        int i = 0;
        while (i < texto.length) {
            this.textoCifrado[i] = (byte)(this.textoCifrado[i] + i + iDummy);
            ++i;
        }
    }

    public byte[] getTextoCifrado() throws Exception {
        return this.textoCifrado;
    }

    public void geraDecifra(byte[] texto, File fDummy) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fDummy));
        int iDummy = (Integer)ois.readObject();
        ois.close();
        this.textoDecifrado = texto;
        int i = 0;
        while (i < texto.length) {
            this.textoDecifrado[i] = (byte)(this.textoDecifrado[i] - i - iDummy);
            ++i;
        }
    }

    public byte[] getTextoDecifrado() throws Exception {
        return this.textoDecifrado;
    }
}

