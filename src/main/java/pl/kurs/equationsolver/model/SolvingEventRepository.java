package pl.kurs.equationsolver.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;


@Repository
public interface SolvingEventRepository extends CrudRepository<Timestamp, String> {

    SolvingEvent findByExpression(String expression);

    SolvingEvent save(SolvingEvent solvingEvent);


}
