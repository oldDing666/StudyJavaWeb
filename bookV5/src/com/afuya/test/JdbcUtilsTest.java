package com.afuya.test;

import com.afuya.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 10:39 上午
 */
public class JdbcUtilsTest {

    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}