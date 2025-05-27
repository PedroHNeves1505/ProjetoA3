import java.util.*;

public class VerificacaoMultiplaDestinatarios {
    
    private final List<String> destinatariosRecentes = new ArrayList<>();
    private final Timer timer = new Timer();
    private boolean acusarCpfCnpj = false;

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
            acusarCpfCnpj = true;
            System.out.println("⚠️ Comportamento suspeito detectado: " + destinatariosRecentes.size() + " destinatários únicos.");
        } else {
            acusarCpfCnpj = false;
            System.out.println("✅ Nenhum comportamento suspeito detectado.");
        }
    }
}
