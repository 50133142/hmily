package org.dromara.hmily.common.utils;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        // 传递行为，而不是传递值
        System.out.println(test.comput(1, value -> 2 * value));

        System.out.println(test.comput(2, value -> 5 + value));

        System.out.println(test.comput(3,Integer::intValue));

        System.out.println(test.convert(4,value -> value + "helloworld"));
    }

    public int comput(int a, Function<Integer, Integer> function) {
        //apply ,传递的是行为
        int result = function.apply(a);
        return result;
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    //    对于之前只传递值的写法,几种行为就要定义几种写法。 现在可以使用上面的方式去 传递行为
    public int method1(int a) {
        return a + 1;
    }

    public int method2(int a) {
        return a * 5;
    }

    public int method3(int a) {
        return a * a;
    }
}