package pl.kurs.equationsolver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.kurs.equationsolver.dao.ISolvingEventDao;
import pl.kurs.equationsolver.dao.SolvingEventDao;
import pl.kurs.equationsolver.model.SolvingEvent;
import pl.kurs.equationsolver.model.SolvingEventRepository;

import java.util.Objects;
import java.util.Optional;

@Component
@Service
public class SolvingEventService implements ISolvingEventService {

    private ISolvingEventDao solvingEventDao;

    public SolvingEventService(ISolvingEventDao solvingEventDao) {
        this.solvingEventDao = solvingEventDao;
    }

    public SolvingEventService() {

    }

    @Override
    public void saveEvent(SolvingEvent solvingEvent) {

        solvingEventDao.save(
                Optional.ofNullable(solvingEvent)
                        .filter(x -> Objects.isNull(x.getId()))
                        .orElseThrow(() -> new RuntimeException("Bad entity!"))
        );

}

}
