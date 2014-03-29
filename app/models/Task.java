package models;

import play.db.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Task extends Model {
    @Id
    private long id;
    private String name;
    private String description;
    public static Model.Finder<Long, Task> find = new Model.Finder(Long.class, Task.class);
    
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

    public static List<Task> all() {
        return find.all();
    }

    public static Task findbyId(long l) {
        return find.byId(l);
    }



}
