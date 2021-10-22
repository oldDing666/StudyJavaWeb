package com.afuya.test;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 11:30 上午
 */
public class ManagerTest {
    public static void main(String[] args) {
        // 子类
        Manager boss = new Manager("boss", 80000, 1987, 12);
        boss.setBonus(20);

        // 父类
        Employee[] staff = new Employee[3];

        staff[0] = (Employee) boss;


        staff[1] = new Employee("aaa", 5000, 1999);
        staff[2] = new Employee("aaa", 5000, 1999);

    }
}
