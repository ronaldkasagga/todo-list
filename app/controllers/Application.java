package controllers;

import models.Task;
import models.TaskManager;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static TaskManager ourTaskManager = new TaskManager();
    static Form<Task> taskForm = Form.form(Task.class);

    public static Result index() {
        return ok(index.render("Roleen's application is ready."));
    }

    public static Result getTasks() {
        return ok(task.render(Task.all(), taskForm));
    }

    public static Result newTask(){
        Form<Task> filledForm = taskForm.bindFromRequest();
        if(filledForm.hasErrors())
            return badRequest(
                    views.html.task.render(Task.all(), filledForm)
            );
        else{
            Task.createTask(filledForm.get());
            return redirect(routes.Application.getTasks());
        }
    }

    public static Result deleteTask(Long id){
        Task.delete(id);
        return redirect(routes.Application.getTasks());
    }

}
