package com.example.Implementations;

import com.example.EntityGateway;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TaskInteractorTest {

    @Before
    public void setUp() throws Exception {

    }

    private class Values {
        String name;
        String desc;
        Date date;
    }

    private class CreateTaskTestCallGateway extends TestGateway {
        private final Values values;

        CreateTaskTestCallGateway(Values values) {
            this.values = values;
        }

        @Override
        public int createTask(String name, String description, Date date) {
            values.name = name;
            values.desc = description;
            values.date = date;
            return 0;
        }
    }

    private class CreateTaskTestReturnValueGateway extends TestGateway {
        @Override
        public int createTask(String name, String description, Date date) {
            return 5666;
        }
    }

    @Test
    public void createTask_calls_entity_with_name_description_date() throws Exception {
        Values values = new Values();
        ITaskInteractor taskInteractor = new TaskInteractor(
                new CreateTaskTestCallGateway(values)
        );
        String name = "RandomName";
        String desc = "Random Few Word Description";
        Date date = new Date();

        taskInteractor.createTask(name, desc, date);

        assertEquals(values.name, name);
        assertEquals(values.desc, desc);
        assertEquals(values.date, date);
    }

    @Test
    public void createTask_returns_taskID_returned_by_entity() throws Exception {
        ITaskInteractor taskInteractor = new TaskInteractor(
                new CreateTaskTestReturnValueGateway()
        );
        assertEquals(taskInteractor.createTask("", "", new Date()), 5666);
    }

    @Test
    public void setTaskAlarm() throws Exception {

    }

    @Test
    public void deleteTask() throws Exception {

    }

    @Test
    public void getTaskList() throws Exception {

    }

    class TestGateway implements EntityGateway {
        @Override
        public int createTask(String name, String description, Date date) {
            return 0;
        }
    }
}