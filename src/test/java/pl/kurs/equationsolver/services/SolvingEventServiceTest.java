package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kurs.equationsolver.dao.ISolvingEventDao;
import pl.kurs.equationsolver.dao.SolvingEventDao;
import pl.kurs.equationsolver.model.SolvingEvent;
import pl.kurs.equationsolver.model.SolvingEventRepository;


import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;


public class SolvingEventServiceTest {


    @Resource
    private SolvingEventRepository solvingEventRepository;


    @Test
    public void SaveEventTest() {


        SolvingEvent solvingEvent1 = new SolvingEvent(Timestamp.from(Instant.now()), "2+2*2");
        solvingEventRepository.save(solvingEvent1);

        SolvingEvent savedEvent = solvingEventRepository.findByExpression(solvingEvent1.getExpression());
        Assert.assertEquals("2+2*2", savedEvent);


    }


}