package com.afuya.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/13 3:53 下午
 */
@Component
@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
public class User {
    @Value(value = "abc")
    private String name;
    @Autowired
    private Dog dog;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
