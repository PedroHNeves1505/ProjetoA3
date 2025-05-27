import java.util.*;

public class VerificacaoHistorico {

    private final Timer timer = new Timer();
    private final ArrayList<String> historicoMovimentacoes = new ArrayList<>();
    private final Date dataCriacaoConta;
    private boolean acusarHistorico;

    private static final long TempoContaRecente = 180L * 24 * 60 * 60 * 1000;

    public VerificacaoHistorico(Date dataCriacaoConta) {
        this.dataCriacaoConta = dataCriacaoConta;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                verificarHistorico();
                historicoMovimentacoes.clear(); 
            }
        }, 0, 60_000);
    }

    public void novaMovimentacao(String descricao) {
        historicoMovimentacoes.add(descricao);
    }
    
    private void verificarHistorico() {
        long idadeConta = System.currentTimeMillis() - dataCriacaoConta.getTime();

        if (idadeConta <= TempoContaRecente && historicoMovimentacoes.size() <= 10) {
            acusarHistorico = true;
            System.out.println("Conta recente e com pouco histórico de movimentação.");
        } else {
            acusarHistorico = false;
            System.out.println("Conta com movimentação aceitável ou já tem mais de 180 dias.");
        }
    }
}
