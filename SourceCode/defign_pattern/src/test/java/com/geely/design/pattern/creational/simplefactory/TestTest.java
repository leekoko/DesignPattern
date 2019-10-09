package com.geely.design.pattern.creational.simplefactory;
import com.mysql.jdbc.Driver;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class TestTest {

    @Test
    public void calendarTest() throws ClassNotFoundException, SQLException {
        //1.new Calendar();  》 createCalendar();
        Calendar calendar = new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int field, int amount) {

            }

            @Override
            public void roll(int field, boolean up) {

            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }
        };
        //2.LoggerFactory.getLogger();
        LoggerFactory.getLogger("name");

    }


}
