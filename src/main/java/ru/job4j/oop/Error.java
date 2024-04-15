package ru.job4j.oop;

public class Error {

    private boolean active;
    private String message;
    private int status;

    public Error() {
    }

    public Error(boolean active, String message, int status) {
        this.active = active;
        this.message = message;
        this.status = status;
    }

    public void printInfo() {
        System.out.println("Ошибка активна: " + active);
        System.out.println("Сообщение ошибки: " + message);
        System.out.println("Статус ошибки: " + status);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error2 = new Error(true, "not enough space", 0);
        error2.printInfo();
    }
}
