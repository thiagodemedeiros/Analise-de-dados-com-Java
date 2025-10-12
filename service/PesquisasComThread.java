package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PesquisasComThread {
    public void executarPesquisas() throws InterruptedException, ExecutionException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<?>> futures = new ArrayList<>();

            futures.add(executor.submit(() -> new PesquisaTimeQueMaisVenceu()));
            futures.add(executor.submit(() -> new PesquisaEstadoComMenosJogos()));
            futures.add(executor.submit(() -> new PesquisaDeGols("Gol")));
            futures.add(executor.submit(() -> new PesquisaDeGols("Penalti")));
            futures.add(executor.submit(() -> new PesquisaDeGols("Gol Contra")));
            futures.add(executor.submit(() -> new PesquisaDeCartoes("Cartão Amarelo")));
            futures.add(executor.submit(() -> new PesquisaDeCartoes("Cartão Vermelho")));
            futures.add(executor.submit(() -> new PesquisaJogoComMaisGols()));

            for (Future<?> f : futures) {
                f.get();
            }
        }
    }
}
