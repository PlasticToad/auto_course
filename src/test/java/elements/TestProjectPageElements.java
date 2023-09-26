package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestProjectPageElements {
    public static SelenideElement quantity = $x("//div[@class='showing']/descendant::span").as("Поле количества задач");
    public static SelenideElement status = $x("//span[@id='status-val']/descendant::span").as("Статус");
    public static SelenideElement version = $x("//span[@id='fixfor-val']/descendant::a").as("Версия");
    public static SelenideElement quickSearch = $x("//input[@id='quickSearchInput']").as("Поле поиска");
    public static SelenideElement selenTask = $x("//span[@class='quick-search-item-title' and contains(text(),'TestSelenium')]").as("Задача в выпадающем списке поиска");
    public static SelenideElement create = $x("//a[@id='create_link']").as("Кнопка создать");
    public static SelenideElement taskType = $x("//input[@id='issuetype-field']").as("Тип задачи");
    public static SelenideElement subject = $x("//input[@id='summary']").as("Тема");
    public static SelenideElement description = $x("//textarea[@name='description']").as("Описание");
    public static SelenideElement versionFix = $x("//select[@id='fixVersions']/descendant::option[3]").as("Исправить в версиях");
    public static SelenideElement priorityDrop = $x("//input[@id='priority-field']").as("Приоритет");
    public static SelenideElement environment = $x("//textarea[@name='environment']").as("Окружение");
    public static SelenideElement versionRelate = $x("//select[@id='versions']/descendant::option[3]").as("Исправить в версиях");
    public static SelenideElement tags = $x("//textarea[@id='labels-textarea']").as("Метки");
    public static SelenideElement relatedTasks = $x("//select[@name='issuelinks-linktype']/descendant::option[1]").as("Связанные задачи");
    public static SelenideElement task = $x("//textarea[@id='issuelinks-issues-textarea']").as("Задача");
    public static SelenideElement assign = $x("//button[@id='assign-to-me-trigger']").as("Назаначить на меня");
    public static SelenideElement createSaveBtn = $x("//input[@id='create-issue-submit']").as("Кнопка создать");
    public static SelenideElement lastTask = $x("//table//tr[last()]//td[2]").as("Последняя(новая) задача в таблице");
    public static SelenideElement workBtn = $x("//span[contains(.,'В работе')]").as("Кнопка в работе");
    public static SelenideElement bsDrop = $x("//span[contains(.,'Бизнес-процесс')]").as("Дропдаун бизнес процесс");
    public static SelenideElement doneBtn = $x("//span[contains(.,'Выполнено')]").as("Выполнено");
}
