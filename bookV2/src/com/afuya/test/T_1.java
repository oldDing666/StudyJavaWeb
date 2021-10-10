package com.afuya.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/9 7:15 下午
 */
public class T_1 {
    public static void main(String[] args) {
        String s = "100001000101";
        String t = "ABC";
        System.out.println(fun(s, t));
    }

    public static int fun(String s, String t) {
        int res = 0;
        Map<String, String> map = new HashMap<>();
        map.put("1000", "A");
        map.put("0100", "B");
        map.put("0010", "C");
        map.put("0001", "D");
        for (int i = 0; i < t.length(); i++) {
            String s1 = s.substring(4 * i, 4 * i + 4);
            if (!map.containsKey(s1)) {
                continue;
            }
            if (map.get(s1).equals(t.charAt(i) + "")) {
                res++;
            }
        }
        return res;
    }
}
