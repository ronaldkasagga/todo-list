import models.Task;
import org.junit.Test;
import play.mvc.Content;

import java.util.ArrayList;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

/**
 * Created by sagas on 3/22/14.
 */
public class TaskViewTest {

    @Test
    public void doesTaskTemplateRenderTasks(){
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Task1", "This is the first task"));
        tasks.add(new Task("Task2", "This is the second task"));
        tasks.add(new Task("Task3", "This is the third task"));

        Content html = views.html.task.render(tasks);
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Task1");
        assertThat(contentAsString(html)).contains("Task2");
        assertThat(contentAsString(html)).contains("Task3");

    }
}
