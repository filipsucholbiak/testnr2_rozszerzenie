package pl.kurs.equationsolver.dao;

import pl.kurs.equationsolver.model.SolvingEvent;

public interface ISolvingEventDao {

    SolvingEvent save(SolvingEvent solvingEvent);
}
