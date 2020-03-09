package com.ronething;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Integer(42).hashCode());
        System.out.println(new Integer(-42).hashCode());
        System.out.println(new Double(42.0).hashCode());
        System.out.println("hello".hashCode());

    }
}
