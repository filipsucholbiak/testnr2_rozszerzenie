package pl.kurs.equationsolver.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.kurs.equationsolver.config.JpaConfig;
import pl.kurs.equationsolver.dao.ISolvingEventDao;
import pl.kurs.equationsolver.services.ISolvingEventService;

import java.util.List;

@Component
@Repository
public interface SolvingEventRepository extends JpaRepository<SolvingEvent, String> {


     SolvingEvent save(SolvingEvent solvingEvent);


    List<SolvingEvent> getByExpression(String expression);

}
