package pl.kurs.equationsolver.services;

import pl.kurs.equationsolver.model.SolvingEvent;

public class SolvingEventSaverRunnable implements Runnable{

    private ISolvingEventService solvingEventService;
    private SolvingEvent solvingEvent;

    public SolvingEventSaverRunnable(ISolvingEventService solvingEventService, SolvingEvent solvingEvent) {
        this.solvingEventService = solvingEventService;
        this.solvingEvent = solvingEvent;
    }

    @Override
    public void run() {
        solvingEventService.saveEvent(solvingEvent);
    }
}
