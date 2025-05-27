import java.util.*;

public class VerificacaoMultiplaDestinatarios {
    
    private final List<String> destinatariosRecentes = new ArrayList<>();
    private final Timer timer = new Timer();
    

    public VerificacaoMultiplaDestinatarios() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                verificarDestinatarios();
                destinatariosRecentes.clear();
            }
        }, 0, 1_800_000);
    }

    public void novaTransacao(String cpfCnpjDestinatario) {
        if (!destinatariosRecentes.contains(cpfCnpjDestinatario)) {
            destinatariosRecentes.add(cpfCnpjDestinatario);
        }
    }

    private void verificarDestinatarios() {
        if (destinatariosRecentes.size() >= 5) {
            System.out.println("Comportamento suspeito detectado: " + destinatariosRecentes.size() + " destinatários únicos.");
        } else {
            System.out.println("Nenhum comportamento suspeito detectado.");
        }
    }
}
