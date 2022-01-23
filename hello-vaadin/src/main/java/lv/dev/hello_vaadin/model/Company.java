package lv.dev.hello_vaadin.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Company {

    @Getter
    private String name;
    private List<Contact> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addAll(List<Contact> contacts){
        employees.addAll(contacts);
    }

    public Integer getEmployeeCount() {
       return employees.size();
    }
}
