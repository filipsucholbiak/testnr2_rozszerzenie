package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kurs.equationsolver.model.SolvingEvent;
import pl.kurs.equationsolver.model.SolvingEventRepository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;




public class SolvingEventServiceTest {


    @Autowired
    private SolvingEventRepository solvingEventRepository;



    @Test
    public void SaveEventTest() {

        solvingEventRepository.save(new SolvingEvent(Timestamp.from(Instant.now()), "2+2*2"));


        List<SolvingEvent> solvingEventList = solvingEventRepository.getByExpression("2+2*2");
        Assert.assertEquals("2+2*2", solvingEventList.get(0).getExpression());


    }


}