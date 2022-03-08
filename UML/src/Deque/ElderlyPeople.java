package Deque;

public class ElderlyPeople extends People {

    private int jumpTimes;

    public ElderlyPeople(String name, int age) {
        super(name, age);
        jumpTimes = 0;
    }

    public void setJumpTimes(int jumpTimes) {
        this.jumpTimes = jumpTimes;
    }

    public int getJumpTimes() {
        return jumpTimes;
    }
}
