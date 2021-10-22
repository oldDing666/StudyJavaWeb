package com.afuya.test;

import java.time.LocalDate;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 11:29 上午
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int hireDay, double bonus) {
        super(name, salary, hireDay);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
