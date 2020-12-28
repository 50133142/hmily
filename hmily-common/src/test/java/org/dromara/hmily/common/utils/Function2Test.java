package org.dromara.hmily.common.utils;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *  compose , andThen 方法的使用
 */
class Function2Test {

    public static void main(String[] args) {
        Function2Test test2 = new Function2Test();
        int compute = test2.compute(2, v -> v * 3, v -> v * v);//12
        int compute2 = test2.compute2(2, v -> v * 3, v -> v * v);//36
        System.out.println(compute);
        System.out.println(compute2);

        System.out.println("123456789=================");
        //使用BiFunction来完成
        System.out.println(test2.compute3(1,2,(value1,value2)-> value1 + value2));
        System.out.println(test2.compute3(1,2,(value1,value2)-> value1 - value2));
        System.out.println(test2.compute3(1, 2, (value1, value2) -> value1 * value2));
        System.out.println(test2.compute3(1, 2, (value1, value2) -> value1 / value2));

        //使用BiFunction中的andThen.
        System.out.println(test2.compute4(2,3,(value1,value2)->value1+value2,value->value*value));
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }
    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }


    //BiFunction类的使用。 有两个输入参数
    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int compute4(int a,int b,BiFunction<Integer, Integer, Integer> biFunction,Function<Integer,Integer> function) {
        return biFunction.andThen(function).apply(a,b);
    }


}