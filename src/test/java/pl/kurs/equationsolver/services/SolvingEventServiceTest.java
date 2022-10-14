package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.kurs.equationsolver.app.Main;
import pl.kurs.equationsolver.dao.ISolvingEventDao;
import pl.kurs.equationsolver.dao.SolvingEventDao;
import pl.kurs.equationsolver.model.SolvingEvent;

import javax.persistence.EntityManagerFactory;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.*;

public class SolvingEventServiceTest {


    @Test
    public void SaveEventTest(){

        SolvingEvent solvingEvent = new SolvingEvent(Timestamp.from(Instant.now()), "2+2*2");

        SolvingEvent resultSolvingEvent = solvingEvent;
        SolvingEvent expectedSolvingEvent = solvingEvent;

        Assert.assertEquals(expectedSolvingEvent, resultSolvingEvent);

    }

}