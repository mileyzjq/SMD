package Test;

import java.util.Random;

public class Die {
    private int faceValue;

    public void roll() {
        Random random = new Random();
        faceValue = (int)(random.nextInt(6) + 1);
    }

    public int getFaceValue() {
        return faceValue;
    }
}
