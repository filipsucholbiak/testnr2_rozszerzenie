package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import pl.kurs.equationsolver.config.JpaConfig;
import pl.kurs.equationsolver.model.SolvingEvent;
import pl.kurs.equationsolver.model.SolvingEventRepository;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
public class SolvingEventServiceTest {


   ISolvingEventService solvingEventService = new SolvingEventService();


    SolvingEventRepository solvingEventRepository = new SolvingEventRepository() {
        @Override
        public SolvingEvent findByExpression(String expression) {
            SolvingEvent se = new SolvingEvent(Timestamp.from(Instant.now()),"2+2*2");
            se.toString();
            return se;
        }


        @Override
        public <S extends Timestamp> S save(S entity) {
            return entity;
        }


        @Override
        public List<Timestamp> findAll() {
            return null;
        }

        @Override
        public List<Timestamp> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Timestamp> findAllById(Iterable<String> strings) {
            return null;
        }

        @Override
        public <S extends Timestamp> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<Timestamp> findById(String s) {
            return Optional.empty();
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Timestamp> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Timestamp> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Timestamp> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<String> strings) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Timestamp getOne(String s) {
            return null;
        }

        @Override
        public Timestamp getById(String s) {
            return null;
        }

        @Override
        public Timestamp getReferenceById(String s) {
            return null;
        }

        @Override
        public <S extends Timestamp> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Timestamp> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Timestamp> findAll(Pageable pageable) {
            return null;
        }


        @Override
        public boolean existsById(String s) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(String s) {

        }

        @Override
        public void delete(Timestamp entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends String> strings) {

        }

        @Override
        public void deleteAll(Iterable<? extends Timestamp> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Timestamp> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Timestamp> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Timestamp> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Timestamp> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Timestamp, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }


        @Override
        public SolvingEvent save(SolvingEvent solvingEvent) {
            return solvingEvent;
        }
    };


    @Test
    public void SaveEventTest(){

        SolvingEvent solvingEvent1 = new SolvingEvent(Timestamp.from(Instant.now()), "2+2*2");

      solvingEventRepository.save(solvingEvent1);


        SolvingEvent solvingEvent2 = solvingEventRepository.findByExpression("2+2*2");


        Assert.assertEquals(solvingEvent1.getExpression(), solvingEvent2.getExpression());

    }


}