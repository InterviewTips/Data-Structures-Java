package com.ronething;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        array.addLast(new Student("panda", 80));
        array.addLast(new Student("panda1", 90));
        array.addLast(new Student("panda2", 100));
        array.remove(1);
        System.out.println(array); // [Student(name: panda, score: 80), Student(name: panda2, score: 100)]
    }
}
