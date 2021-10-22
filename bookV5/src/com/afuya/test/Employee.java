package com.afuya.test;

import java.time.LocalDate;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 11:27 上午
 */
public class Employee {
    private String name;
    private double salary;
    private int hireDay;

    public Employee(String name, double salary, int hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getHireDay() {
        return hireDay;
    }

    public void setHireDay(int hireDay) {
        this.hireDay = hireDay;
    }
}
