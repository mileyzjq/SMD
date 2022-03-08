package MileyMonopoly;

import org.junit.Test;
import org.junit.Assert;

public class HelloWorldTest {
    HelloWorld hw = new HelloWorld();

    @Test
    public void testAddition() {
        int res = hw.addtion(12,3);
        Assert.assertEquals(15, res);
    }
}