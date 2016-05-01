package Model;
/*
 * Decompiled with CFR 0_114.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ManipulaArray {
    private CryptoDummy cdummy = new CryptoDummy();
    public boolean respAgenciaConta = false;
    public boolean respSenha = false;
    public boolean respCodigo = false;

    public Conta geraContaNova() {
        Conta novaConta = new Conta();
        String dado = JOptionPane.showInputDialog(null, (Object)"Insira a ag\u00eancia");
        novaConta.setAgencia(dado);
        dado = JOptionPane.showInputDialog(null, (Object)"Insira a conta");
        novaConta.setConta(dado);
        dado = JOptionPane.showInputDialog(null, (Object)"Insira a senha");
        novaConta.setSenha(dado);
        return novaConta;
    }

    public ArrayList<Conta> CriptografaArray(ArrayList<Conta> contasLimpas) throws Exception {
        ArrayList<Conta> contasCrip = new ArrayList<Conta>();
        int i = 0;
        while (i < contasLimpas.size()) {
            contasCrip.add(this.criptografaConta(contasLimpas.get(i)));
            ++i;
        }
        return contasCrip;
    }

    public Conta criptografaConta(Conta contaNovaLimpa) throws Exception {
        byte[] bDadoClaro = null;
        byte[] bDadoCifrado = null;
        String sDadoCifrado = null;
        Conta contaCriptografada = new Conta();
        String dado = contaNovaLimpa.getAgencia();
        bDadoClaro = dado.getBytes("ISO-8859-1");
        this.cdummy.geraCifra(bDadoClaro, new File("chave.dummy"));
        bDadoCifrado = this.cdummy.getTextoCifrado();
        sDadoCifrado = new String(bDadoCifrado, "ISO-8859-1");
        System.out.println(sDadoCifrado);
        contaCriptografada.setAgencia(sDadoCifrado);
        bDadoClaro = contaNovaLimpa.getConta().getBytes("ISO-8859-1");
        this.cdummy.geraCifra(bDadoClaro, new File("chave.dummy"));
        bDadoCifrado = this.cdummy.getTextoCifrado();
        sDadoCifrado = new String(bDadoCifrado, "ISO-8859-1");
        System.out.println(sDadoCifrado);
        contaCriptografada.setConta(sDadoCifrado);
        bDadoClaro = contaNovaLimpa.getSenha().getBytes("ISO-8859-1");
        this.cdummy.geraCifra(bDadoClaro, new File("chave.dummy"));
        bDadoCifrado = this.cdummy.getTextoCifrado();
        sDadoCifrado = new String(bDadoCifrado, "ISO-8859-1");
        System.out.println(sDadoCifrado);
        contaCriptografada.setSenha(sDadoCifrado);
        bDadoClaro = contaNovaLimpa.getCodigo().getBytes("ISO-8859-1");
        this.cdummy.geraCifra(bDadoClaro, new File("chave.dummy"));
        bDadoCifrado = this.cdummy.getTextoCifrado();
        sDadoCifrado = new String(bDadoCifrado, "ISO-8859-1");
        System.out.println(sDadoCifrado);
        contaCriptografada.setCodigo(sDadoCifrado);
        return contaCriptografada;
    }

    public void gravaConta(Conta conta) throws Exception {
        File file = new File("contas.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter writer = new PrintWriter(fileWriter);
        String dados = String.valueOf(conta.getAgencia()) + " " + conta.getConta() + " " + conta.getSenha() + " " + conta.getCodigo() + "\n";
        writer.print(dados);
        writer.flush();
        writer.close();
    }

    public ArrayList<Conta> acrecentaConta(ArrayList<Conta> contas) throws Exception {
        ArrayList<Conta> adicionaConta = this.leArquivoCriptografado();
        Conta novaConta = this.geraContaNova();
        int nAgencia = Integer.parseInt(novaConta.getAgencia());
        int nConta = Integer.parseInt(novaConta.getConta());
        boolean add = false;
        if (adicionaConta.isEmpty()) {
            adicionaConta.add(novaConta);
        }
        int i = 0;
        while (i < adicionaConta.size() && !add) {
            int agencia = Integer.parseInt(adicionaConta.get(i).getAgencia());
            int conta = Integer.parseInt(adicionaConta.get(i).getConta());
            if (nAgencia < agencia) {
                adicionaConta.add(i, novaConta);
                add = true;
            }
            if (nAgencia == agencia && nConta < conta) {
                adicionaConta.add(i, novaConta);
                add = true;
            }
            ++i;
        }
        return adicionaConta;
    }

    public void gravaConta(ArrayList<Conta> contas) throws Exception {
        Formatter output = new Formatter("contas.txt");
        String dados = "";
        int i = 0;
        while (i < contas.size()) {
            dados = String.valueOf(dados) + contas.get(i).getAgencia() + " " + contas.get(i).getConta() + " " + contas.get(i).getSenha() + " " + contas.get(i).getCodigo() + "\n";
            ++i;
        }
        output.format(dados, new Object[0]);
        output.close();
    }

    public void limpaArquivo() throws Exception {
        File file = new File("contas.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }

    public ArrayList<Conta> leArquivoCriptografado() throws Exception {
        Scanner input = new Scanner(new File("contas.txt"));
        System.out.println("Metodo le arquivo");
        ArrayList<Conta> arrayDeContaDoArquivo = new ArrayList<Conta>();
        while (input.hasNext()) {
            String dadoDescriptografado = "";
            Conta conta = new Conta();
            dadoDescriptografado = this.decifra(input.next());
            System.out.println(dadoDescriptografado);
            conta.setAgencia(dadoDescriptografado);
            dadoDescriptografado = this.decifra(input.next());
            System.out.println(dadoDescriptografado);
            conta.setConta(dadoDescriptografado);
            dadoDescriptografado = this.decifra(input.next());
            System.out.println(dadoDescriptografado);
            conta.setSenha(dadoDescriptografado);
            dadoDescriptografado = this.decifra(input.next());
            System.out.println(dadoDescriptografado);
            conta.setCodigo(dadoDescriptografado);
            arrayDeContaDoArquivo.add(conta);
        }
        input.close();
        return arrayDeContaDoArquivo;
    }

    public String decifra(String dadoCriptogradafo) throws Exception {
        byte[] bMsgCifrada = null;
        byte[] bMsgDecifrada = null;
        String sMsgDecifrada = "";
        System.out.println("Meotodo decifra/vai decifrar");
        bMsgCifrada = dadoCriptogradafo.getBytes("ISO-8859-1");
        this.cdummy.geraDecifra(bMsgCifrada, new File("chave.dummy"));
        bMsgDecifrada = this.cdummy.getTextoDecifrado();
        sMsgDecifrada = new String(bMsgDecifrada, "ISO-8859-1");
        System.out.println("Mensagem Decifrada (String):");
        System.out.println(sMsgDecifrada);
        System.out.println("");
        return sMsgDecifrada;
    }

    public Conta achaConta(Conta conta) throws Exception {
        ArrayList<Conta> contas = this.leArquivoCriptografado();
        Conta contaValidada = null;
        int userConta = Integer.parseInt(conta.getConta());
        int userAgencia = Integer.parseInt(conta.getAgencia());
        int userSenha = Integer.parseInt(conta.getSenha());
        int i = 0;
        while (i < contas.size()) {
            int puraConta = Integer.parseInt(contas.get(i).getConta());
            int puraAgencia = Integer.parseInt(contas.get(i).getAgencia());
            int puraSenha = Integer.parseInt(contas.get(i).getSenha());
            if (userAgencia == puraAgencia && userConta == puraConta) {
                this.respAgenciaConta = true;
                if (userSenha == puraSenha) {
                    this.respSenha = true;
                    contaValidada = contas.get(i);
                    if (contas.get(i).getCodigo().equals("00")) {
                        this.respCodigo = true;
                    }
                }
            }
            ++i;
        }
        return contaValidada;
    }

    public void salvaCodigoAcesso(Conta conta) throws Exception {
        ArrayList<Conta> contas = this.leArquivoCriptografado();
        int userConta = Integer.parseInt(conta.getConta());
        int userAgencia = Integer.parseInt(conta.getAgencia());
        int userSenha = Integer.parseInt(conta.getSenha());
        int i = 0;
        while (i < contas.size()) {
            int puraConta = Integer.parseInt(contas.get(i).getConta());
            int puraAgencia = Integer.parseInt(contas.get(i).getAgencia());
            int puraSenha = Integer.parseInt(contas.get(i).getSenha());
            if (userAgencia == puraAgencia && userConta == puraConta && userSenha == puraSenha) {
                contas.get(i).setCodigo(conta.getCodigo());
                this.gravaConta(this.CriptografaArray(contas));
            }
            ++i;
        }
    }

    public void insereConta() throws Exception {
        this.gravaConta(this.CriptografaArray(this.acrecentaConta(this.leArquivoCriptografado())));
    }

    public static void main(String[] args) throws Exception {
        ManipulaArray teste = new ManipulaArray();
        teste.insereConta();
        teste.leArquivoCriptografado();
    }
}

