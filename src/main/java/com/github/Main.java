package com.github;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<A> sl = new ArrayList<>();
        A a = new A("nameA", 1);
        A a2 = new A("nameA2", 2);
        A a3 = new A("nameA", 3);

        sl.add(a);
        sl.add(a2);
        sl.add(a3);

        long start = System.currentTimeMillis();
        List<String> rs = sl.stream().map(A::getName).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println("2nd method");
        List<String> rs2 = generateUniqFromList(sl);

        rs.forEach(e -> {
            System.out.println(e);
        });
    }


    public static List<String> generateUniqFromList(List<A> list) {
        long start = System.currentTimeMillis();
        Set<String> set = new HashSet<>();
        for (A a : list) {
            set.add(a.getName());
        }
        List<String> res = new ArrayList<>(set);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return res;

    }
}
