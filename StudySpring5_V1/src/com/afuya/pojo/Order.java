package com.afuya.pojo;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/13 5:38 下午
 */
@Component
@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
public class Order {

}
