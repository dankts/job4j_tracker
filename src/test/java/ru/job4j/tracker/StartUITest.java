package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new Create(output));
        userActions.add(new Exit(output));
        new StartUI(output).init(input, tracker, userActions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item")); /* Добавляется в tracker новая заявка */
        String replacedName = "New item name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new Replace(output));
        userActions.add(new Exit(output));
        new StartUI(output).init(input, tracker, userActions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new Delete(output));
        userActions.add(new Exit(output));
        new StartUI(output).init(input, tracker, userActions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new Exit(output));
        new StartUI(output).init(input, tracker, userActions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        String replaceName = "New Test name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replaceName, "1"}
        );
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new Replace(output));
        userActions.add(new Exit(output));
        new StartUI(output).init(input, tracker, userActions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void findAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", "1"}
        );
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new FindAll(output));
        userActions.add(new Exit(output));
        new StartUI(output).init(input, tracker, userActions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + item + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void findByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", "test1", "1"}
        );
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new FindByName(output));
        userActions.add(new Exit(output));
        new StartUI(output).init(input, tracker, userActions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + item + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void findByIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new FindById(output));
        userActions.add(new Exit(output));
        new StartUI(output).init(input, tracker, userActions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + item + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}