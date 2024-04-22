package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки по id ===");
        int enterId = input.askInt("Введите id: ");
        Item item = tracker.findById(enterId);
        System.out.println(item != null ? item : "Заявка с введенным id: " + enterId + " не найдена.");
        return true;
    }
}
