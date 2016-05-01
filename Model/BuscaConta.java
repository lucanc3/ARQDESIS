package Model;
/*
 * Decompiled with CFR 0_114.
 */
import java.util.ArrayList;


public class BuscaConta {
    public static Conta achaConta(ArrayList<Conta> contas, Conta conta) {
        Conta contaValidada = null;
        int userConta = Integer.parseInt(conta.getConta());
        int userAgencia = Integer.parseInt(conta.getAgencia());
        int userSenha = Integer.parseInt(conta.getAgencia());
        boolean respAgenciaConta = false;
        boolean respSenha = false;
        boolean respCodigo = false;
        int i = 0;
        while (i < contas.size()) {
            int puraConta = Integer.parseInt(contas.get(i).getConta());
            int puraAgencia = Integer.parseInt(contas.get(i).getAgencia());
            int puraSenha = Integer.parseInt(contas.get(i).getAgencia());
            if (userAgencia == puraAgencia && userConta == puraConta) {
                respAgenciaConta = true;
                if (userSenha == puraSenha) {
                    if (conta.getCodigo().equals(null)) {
                        respCodigo = true;
                        contaValidada = contas.get(i);
                    } else {
                        int puraCodigo;
                        int userCod = Integer.parseInt(conta.getCodigo());
                        if (userCod == (puraCodigo = Integer.parseInt(contas.get(i).getAgencia()))) {
                            contaValidada = contas.get(i);
                        }
                    }
                } else {
                    respSenha = true;
                }
            }
            ++i;
        }
        return contaValidada;
    }
}

