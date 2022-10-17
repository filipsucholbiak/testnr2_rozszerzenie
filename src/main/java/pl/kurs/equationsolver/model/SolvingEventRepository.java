package pl.kurs.equationsolver.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kurs.equationsolver.dao.ISolvingEventDao;

import java.sql.Timestamp;

@Repository
public interface SolvingEventRepository extends JpaRepository<Timestamp, String>, ISolvingEventDao {

    SolvingEvent findByExpression (String expression);

    @Override
    SolvingEvent save(SolvingEvent solvingEvent);

    @Override
    <S extends Timestamp> S save(S entity);

}
