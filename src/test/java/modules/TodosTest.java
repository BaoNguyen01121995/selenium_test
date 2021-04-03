package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TodosPage;

public class TodosTest extends BaseTest{
    @Test
    public void createNew(){
        TodosPage Page = new TodosPage(driver);
        Page.open();

        int itemLeftBefore = Page.getItemsLeft();
        Page.addNew("task 1");

        int itemLeftAfter = Page.getItemsLeft();
        Assert.assertEquals(itemLeftAfter - itemLeftBefore, 1);
    }
    @Test
    void removeTodo()  {
        TodosPage toDoPage = new TodosPage(driver);
        toDoPage.open();

        toDoPage.addNew("task 1");
        int itemLeftBefore = toDoPage.getItemsLeft();

        toDoPage.removeTodo("task 1");
        int itemLeftAfter = toDoPage.getItemsLeft();
        Assert.assertEquals(itemLeftAfter - itemLeftBefore, -1);

    }

    @Test
    void markTodoComplete()  {
        TodosPage toDoPage = new TodosPage(driver);
        toDoPage.open();


        toDoPage.addNew("task 1");
        int itemLeftBefore = toDoPage.getItemsLeft();

        toDoPage.markDoneTodo("task 1");
        int itemLeftAfter = toDoPage.getItemsLeft();
        Assert.assertEquals(itemLeftAfter - itemLeftBefore, 0);

    }
}
