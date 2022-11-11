package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import pl.kurs.equationsolver.config.JpaConfig;
import pl.kurs.equationsolver.model.SolvingEvent;
import pl.kurs.equationsolver.model.SolvingEventRepository;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.persistence.Entity;
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