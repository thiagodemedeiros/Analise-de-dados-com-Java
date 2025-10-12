package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PesquisasSemThread {
    public void executarPesquisas() {
        new PesquisaTimeQueMaisVenceu();
        new PesquisaEstadoComMenosJogos();
        new PesquisaDeGols("Gol");
        new PesquisaDeGols("Penalti");
        new PesquisaDeGols("Gol Contra");
        new PesquisaDeCartoes("Cartão Amarelo");
        new PesquisaDeCartoes("Cartão Vermelho");
        new PesquisaJogoComMaisGols();
    }
}
