package pl.kurs.equationsolver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class SolvingEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private Timestamp date;
    private String expression;

    public SolvingEvent() {

    }


    public SolvingEvent(Timestamp date, String expression) {
        this.date = date;
        this.expression = expression;
    }



    public long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getExpression() {
        return expression;
    }

}
