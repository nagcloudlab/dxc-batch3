package org.example;

interface MyInterface {
    static final int LEVEL1 = 10;
    static final int LEVEL2 = 20;
    static final int LEVEL3 = 30;
}

enum MyEnum {
    LEVEL1(10),
    LEVEL2(20),
    LEVEL3(30);
    int i = 0;
    MyEnum(int i) {
        this.i = i;
    }
}

enum  HttpMethod{
    GET,
    POST,
    PUT,
    DELETE
}

enum Weekdays{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
}
enum Gender{
    MALE,
    FEMALE
}

public class Enum_vs_Final {
    public static void main(String[] args) {

        System.out.println(MyEnum.LEVEL1.i);
        System.out.println(MyEnum.LEVEL2.ordinal());
        System.out.println(MyEnum.LEVEL3.ordinal());

    }
}
