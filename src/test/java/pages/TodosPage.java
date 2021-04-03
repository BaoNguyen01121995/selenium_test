package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TodosPage extends BasePage{
    By todoList = By.cssSelector("ul.todo-list >li");
    By newTodoTxt = By.className("new-todo");
    public TodosPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("http://todomvc.com/examples/vanillajs");
    }
    public int getItemsLeft() {
        return driver.findElements(todoList).size();
    }
    public void addNew(String todoList){
        driver.findElement(newTodoTxt).sendKeys(todoList + "\n");
    }
    public By getTodo(String todoList){
        return By.xpath(String.format("//label[.='%s']",todoList));
    }
    public void removeTodo(String todoList){
        new Actions(driver).moveToElement(driver.findElement(getTodo(todoList))).perform();
        By destroyBtn = By.xpath(String.format("//label[.='%s']/following-sibling::button",todoList));
        driver.findElement(destroyBtn).click();
    }

    public void markDoneTodo(String todoList){
        new Actions(driver).moveToElement(driver.findElement(getTodo(todoList))).perform();
        By markBtn = By.xpath(String.format("//label[.='%s']/preceding-sibling::input",todoList));
        driver.findElement(markBtn).click();
    }


}
