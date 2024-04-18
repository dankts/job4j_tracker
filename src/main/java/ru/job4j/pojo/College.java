package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Игорь Алексеевич");
        student.setGroup("4-23");
        student.setDateOfEntered(new Date());

        System.out.println(student.getFullName() +
                " " + student.getGroup() +
                " " + student.getDateOfEntered());
    }
}
