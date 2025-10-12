package view;

import service.PesquisasComThread;
import service.PesquisasSemThread;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class View {
    public void ExibirPesquisa() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Como você deseja fazer a pesquisa:");
            System.out.println("1 - Usando Threads");
            System.out.println("2 - Sem Threads");
            int selecionarModoDeExecucao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n------------------------------------\n");
            System.out.println("Deseja ver o tempo de execução:");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            int verTempoDeExecucao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n------------------------------------\n");

            if (selecionarModoDeExecucao == 1) {
                Instant inicio = Instant.now();
                PesquisasComThread pesquisasComThread = new PesquisasComThread();
                try {
                    pesquisasComThread.executarPesquisas();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                Instant fim = Instant.now();
                Duration duracao = Duration.between(inicio, fim);
                if (verTempoDeExecucao == 1) {
                    System.out.println("\n------------------------------------\n");
                    System.out.println("Tempo de execução: " + duracao.toMillis() + " ms");
                    System.out.println("\n------------------------------------\n");
                }
            }

            if (selecionarModoDeExecucao == 2) {
                Instant inicio = Instant.now();
                PesquisasSemThread pesquisasSemThread = new PesquisasSemThread();
                pesquisasSemThread.executarPesquisas();
                Instant fim = Instant.now();
                Duration duracao = Duration.between(inicio, fim);
                if (verTempoDeExecucao == 1) {
                    System.out.println("\n------------------------------------\n");
                    System.out.println("Tempo de execução: " + duracao.toMillis() + " ms");
                    System.out.println("\n------------------------------------\n");
                }
            }

            System.out.println("\n------------------------------------\n");
            System.out.println("Deseja encerrar o programa:");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            int encerrarPrograma = scanner.nextInt();
            scanner.nextLine();
            if (encerrarPrograma == 1) {
                scanner.close();
                System.out.println("\n------------------------------------\n");
                System.out.println("PROGRAMA ENCERRADO");
                System.out.println("\n------------------------------------\n");
                break;
            }
        }
    }
}
