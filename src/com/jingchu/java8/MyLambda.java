package com.jingchu.java8;


import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @description: Lambda表达式测试程序
 * @author: JingChu
 * @createtime :2020-07-26 12:24:42
 **/
public class MyLambda {

    //基础语法
    @Test
    public void test() {
        MyLambda myLambda = new MyLambda();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + myLambda.operate(10, 5, addition));
        System.out.println("10 - 5 = " + myLambda.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + myLambda.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + myLambda.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("World");
        greetService2.sayMessage("java8");

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    //匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(2);
        System.out.println(treeSet);
    }

    //lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(2);
        System.out.println(treeSet);
    }


}
