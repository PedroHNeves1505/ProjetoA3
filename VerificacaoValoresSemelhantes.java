import java.util.*;

public class VerificacaoValoresSemelhantes {

    private final Timer timer = new Timer();
    private final List<Double> valoresTransacoes = new ArrayList<>();
    private final Date dataCriacaoConta;

    // 180 dias em milissegundos
    private static final long TempoContaRecente = 180L * 24 * 60 * 60 * 1000;

    public VerificacaoValoresSemelhantes(Date dataCriacaoConta) {
        this.dataCriacaoConta = dataCriacaoConta;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                verificarValoresHistorico();
                valoresTransacoes.clear();
            }
        }, 0, 60_000);
    }

    public void novaTransacao(double valor) {
        valoresTransacoes.add(valor);
    }


    private void verificarValoresHistorico() {
        long idadeConta = System.currentTimeMillis() - dataCriacaoConta.getTime();

        if (idadeConta < TempoContaRecente) {
                int repeticoes = 0;
            for (int i = 0; i < valoresTransacoes.size(); i++) {
                for (int j = i + 1; j < valoresTransacoes.size(); j++) {
                    if (Math.abs(valoresTransacoes.get(i) - valoresTransacoes.get(j)) < 1.0) {
                        repeticoes++;
                    }
                }
            }

            if (repeticoes >= 3) {
                System.out.println("Padrão suspeito: várias transações com valores muito semelhantes.");
            } else {
                System.out.println("Nenhum padrão suspeito encontrado.");
            }
        }
    }
}
