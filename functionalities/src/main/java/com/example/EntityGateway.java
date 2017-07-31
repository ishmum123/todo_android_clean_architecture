package com.example;

import java.util.Date;

public interface EntityGateway {
    int createTask(String name, String description, Date date);
}
