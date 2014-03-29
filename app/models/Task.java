package models;

import java.util.Date;

/**
 * Created by sagas on 3/22/14.
 */
public class Task {
    private int id;
    private String name;
    private String description;
    
    public Task(String name, String description){
        this.name = name;
        this.description = description;

    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
