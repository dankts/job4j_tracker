package ru.job4j.pojo;

import java.util.Date;

public class Student {

    private String fullName;
    private String group;
    private Date dateOfEntered;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfEntered() {
        return dateOfEntered;
    }

    public void setDateOfEntered(Date dateOfEntered) {
        this.dateOfEntered = dateOfEntered;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
