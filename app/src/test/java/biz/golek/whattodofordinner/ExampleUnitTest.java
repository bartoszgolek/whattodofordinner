package biz.golek.whattodofordinner;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        long miliseconds = new Date().getTime();
        //assertEquals(0, miliseconds);
        long seconds = miliseconds / 1000;
        //assertEquals(0, seconds);
        long minutes = seconds / 60;
        //assertEquals(0, minutes);
        long hours = minutes / 60;
        //assertEquals(0, hours);
        long days = hours / 24;
        assertEquals(0, days);

        //zupa = 1 lub 0

    }
}