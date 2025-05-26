// Muitas transações para CPFs/CNPJs diferentes em curto período.
import java.util.ArrayList;

public class VerificacaoMultiplaDestinatarios {

    // verificar CPF/CNPJ
    ArrayList<Integer> C = new ArrayList<>();
    int quantidadeAnterior = 0, quantidadeC, temporizador;
    boolean verificarC, acusarC;


    public void acusar(){
        int quantidadeC = C.size();

        // falta adcionar a questão do curto periodo
        // modificar a qntd que a subtração dá 
        // modificar a mensagem para um aviso na tela no NetBeans
        if ((quantidadeC - quantidadeAnterior) >= 5) {
            acusarC = true;
            System.out.println("Comportamento suspeito detectado!");
        } else {
            acusarC = false;
            System.out.println("Tudo certo.");
        }



    }

        

}
