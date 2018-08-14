package hu.miskolc.uni.iit.arduinodisplayserver.DAO;

import java.util.Calendar;

public class ResultData {
    private Calendar date;
    private int value;

    public ResultData(final Calendar date, final int value) {
        this.date = date;
        this.value = value;
    }

    public ResultData(final Calendar date, final boolean value) {
        this.date = date;
        this.value = value ? 1 : 0;
    }


    public Calendar getDate() {
        return date;
    }

    public void setDate(final Calendar date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "date=" + date.getTime() +
                ", value=" + value +
                '}';
    }
}
