import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        PesquisasComThread pesquisasComThread = new PesquisasComThread();
        PesquisasSemThread pesquisasSemThread = new PesquisasSemThread();
        try {
            pesquisasComThread.executarPesquisas();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        pesquisasSemThread.executarPesquisas();
    }
}
