package pl.kurs.equationsolver.services;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SolvingEventSaveExecutorService {

    private ExecutorService executorService;

    public SolvingEventSaveExecutorService() {
        executorService = Executors.newFixedThreadPool(100);
    }


    public void submitAndExecute(Runnable runnable){
        executorService.submit(runnable);
    }
}
