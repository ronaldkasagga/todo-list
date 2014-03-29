import models.Task;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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


}
