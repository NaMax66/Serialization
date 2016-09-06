package ru.namax.profile;

import java.io.Serializable;

/**
 * Created by Naidovich on 02.09.2016.
 */
public class Profile implements Serializable {
    private String name;
    private String surname;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {
        return surname;
    }
}
