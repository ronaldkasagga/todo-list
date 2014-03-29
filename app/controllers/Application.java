package controllers;

import models.Task;
import models.TaskManager;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static TaskManager ourTaskManager = new TaskManager();

    public static Result index() {
        return ok(index.render("Roleen's application is ready."));
    }

    public static Result getTasks() {
        ourTaskManager.addTask(new Task("Task1", "This is the first task"));
        ourTaskManager.addTask(new Task("Task2", "This is the second task"));
        return ok(task.render(ourTaskManager.getAllTasks()));
    }

}
