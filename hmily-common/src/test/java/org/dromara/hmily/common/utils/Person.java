package org.dromara.hmily.common.utils;
//定义一个简单的Person类，然后使用lambda表达式解决一些问题

import lombok.Data;

@Data
public class Person {
    private String username;
    private int age;

    public Person(String username,int age){
        this.username=username;
        this.age=age;
    }
}