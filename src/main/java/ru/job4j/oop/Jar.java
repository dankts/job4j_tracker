package ru.job4j.oop;

public class Jar {

    private int value;

    public Jar(int value) {
        this.value = value;
    }

    public void pour(Jar jar) {
        this.value = this.value + jar.value;
        jar.value = 0;
    }

    public static void main(String[] args) {
        Jar firstJar = new Jar(10);
        Jar secondJar = new Jar(20);
        System.out.println(firstJar.value + " " + secondJar.value);
        firstJar.pour(secondJar);
        System.out.println(firstJar.value + " " + secondJar.value);
    }
}
