import models.Task;
import org.fest.assertions.Assertions;
import org.junit.Test;
import play.data.Form;
import play.mvc.Content;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static play.test.Helpers.*;

/**
 * Created by sagas on 3/22/14.
 */
public class TaskTest {

    @Test
    public void testThatTaskIsCreatedWithSuppliedName(){
        //given
        String name = "Go to Church";
        //when
        Task roleenTask = new Task(name, "Watoto service");
        //then
        assertThat(name, is(roleenTask.getName()));
    }

    @Test
    public void testThatTaskIsCreatedWithSuppliedDescription(){
        //given
        String description = "Watoto Saturday service";
        //when
        Task sagasTask = new Task("Go to Church", description);
        //then
        assertThat(description, is(sagasTask.getDescription()));
    }

    public void makeDummyTasks(){
        Task firstTask = new Task("Go to Church","");
        firstTask.save();
        Task secondTask = new Task("Buy Supper","");
        secondTask.save();
    }

    @Test
    public void canTaskBeSavedInDatabase(){
        running(fakeApplication(),
            new Runnable(){
                public void run(){
                    makeDummyTasks();
                    List<Task> allTasks= Task.all();
                    assertThat(allTasks.size(), is(2));
                    Task task = Task.findbyId(1);
                    assertThat(task.getName(), is("Go to Church"));
                }
            }
        );
    }

    @Test
    public void canTaskBeDeletedFromBrowser(){
        running(fakeApplication(),
            new Runnable(){
                public void run(){
                    Task.createTask(new Task("my new task", "so sad she has to go"));
                    long id = 0;
                    for(Task task: Task.all())
                        if(task.getName().equalsIgnoreCase("my new task")){
                            id = task.id;
                            break;
                        }
                    Task.delete(id);
                    Content html = views.html.task.render(Task.all(), Form.form(Task.class));
                    assertFalse(contentAsString(html).contains("my new task"));
                }
            }
        );
    }
}
