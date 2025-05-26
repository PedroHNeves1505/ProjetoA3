// Destinatários com conta recente e sem histórico de movimentação.

import java.util.ArrayList;

public class VerificacaoHistorico {
    
    // verificar tempo desde da criação das contas
    int tempoDeConta;

    // verificar histórico de movimentação
    boolean verificarHistorico, acusarHistorico;
    ArrayList<Integer> H = new ArrayList<>();        


    public void acusar(){
        int historico = H.size();

        if (historico <= 10 && tempoDeConta <= 180) {
            System.out.println("Conta recente e sem hisotrico de movimentação");
        }else {
            System.out.println("Tudo certo");
        }
    }

    // conectar o array historico e o tempoDeConta com o banco de dados
}
