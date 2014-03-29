import models.Task;
import org.junit.Test;
import play.data.Form;
import play.mvc.Content;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

/**
 * Created by sagas on 3/22/14.
 */
public class TaskViewTest {

    @Test
    public void doesTaskTemplateRenderTasks(){
        running(fakeApplication(),
            new Runnable(){
                public void run(){

                    List<Task> tasks = new ArrayList<>();
                    Task task1 = new Task("Task1", "This is the first task");
                    task1.save();
                    Task task2 = new Task("Task2", "This is the second task");
                    task2.save();
                    Task task3 = new Task("Task3", "This is the third task");
                    task3.save();
                    tasks.add(task1);
                    tasks.add(task2);
                    tasks.add(task3);

                    Content html = views.html.task.render(Task.all(), Form.form(Task.class));
                    assertThat(contentType(html)).isEqualTo("text/html");
                    assertThat(contentAsString(html)).contains("Task1");
                    assertThat(contentAsString(html)).contains("Task2");
                    assertThat(contentAsString(html)).contains("Task3");
                }
            });
    }
}
