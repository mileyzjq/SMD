package Deque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

public class WaitInQueue {
    private Deque<People> queue;
    private static final int SENIOR_AGE = 60;
    private static final int MAX_COUNT = 3;

    public WaitInQueue() {
        queue = new LinkedList<>();
    }

    public void addPeople(String name, int age) {
        //People p = new People(name, age);
        if (age >= SENIOR_AGE) {
            ElderlyPeople ep = new ElderlyPeople(name, age);
            if (queue.peekFirst().getCounter() < MAX_COUNT) {
                ep.setJumpTimes(1);
                int cnt;
                for(People p : queue){
                    cnt = p.getCounter();
                    p.setCounter(cnt+1);
                }
                cnt = queue.peekFirst().getCounter()+1;
                ep.setCounter(cnt);
                queue.offerFirst(ep);
            } else {
                queue.offerLast(ep);
            }
            ep.inQueue();
        } else {
            YoungPeople yp = new YoungPeople(name, age);
            queue.offerLast(yp);
            yp.inQueue();
        }
    }

    public void removePeople() {
        People p = queue.poll();
        p.outQueue();
    }

    public static void main(String[] args) {
        WaitInQueue queue = new WaitInQueue();
        queue.addPeople("asas", 42);
        queue.addPeople("tom", 11);
        queue.addPeople("kevin", 51);
        queue.addPeople("windy", 68);
        queue.addPeople("hello", 22);
        queue.addPeople("bbb", 91);
        queue.addPeople("ccc", 7);
        queue.addPeople("ddd", 34);
        queue.addPeople("eee", 55);

        queue.removePeople();
        queue.removePeople();
        queue.removePeople();
        queue.removePeople();

        queue.addPeople("fff", 80);
        queue.addPeople("ggg", 61);
        queue.addPeople("hhh", 32);
        queue.addPeople("lll", 55);

        queue.removePeople();
        queue.removePeople();
    }
}
