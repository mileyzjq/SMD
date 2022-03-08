package Deque;

public class People {
    private int index;
    private int age;
    private String name;

    // count how many times being jumped
    private int counter;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
        counter = 0;
    }

    public void inQueue() {
        System.out.println(String.format("%s aged %d is in queue", name, age));
    }

    public void outQueue() {
        System.out.println(String.format("%s aged %d is moving out queue", name, age));
    }

    public int getAge() {
        return age;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int cnt) {
        this.counter = cnt;
    }
}
