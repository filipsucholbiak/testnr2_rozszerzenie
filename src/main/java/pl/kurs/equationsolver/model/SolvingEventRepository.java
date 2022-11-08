package pl.kurs.equationsolver.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SolvingEventRepository extends JpaRepository<SolvingEvent, String>{

//    SolvingEvent findByExpression(String expression);

     SolvingEvent save(SolvingEvent solvingEvent);


    List<SolvingEvent> getByExpression(String expression);

}
