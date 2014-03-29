package models;

import java.util.ArrayList;

/**
 * Created by sagas on 3/22/14.
 */
public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public Task getTask(int taskId){
        return this.tasks.get(taskId);
    }

    public ArrayList<Task> getAllTasks(){
        return tasks;
    }
}
