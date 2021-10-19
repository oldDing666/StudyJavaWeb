package com.afuya.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/13 4:52 下午
 */
@Component
public class Dog {
    @Value(value = "xiaoghei")
    private String dogName;

    public Dog() {
    }

    public Dog(String dogName) {
        this.dogName = dogName;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                '}';
    }
}
