package book.fujava.testhelpers;

import book.fujava.testHelpers.RodCutter;
import book.fujava.testHelpers.RodCutterException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RodCutterTest {
    RodCutter rodCutter = new RodCutter();
    List<Integer> prices = Collections.EMPTY_LIST;

    @Test
    void verboseExceptionTest() {
        rodCutter.setPrices(prices);

        try {
            rodCutter.maxProfit(0);
            fail("expected exception!");
        } catch (RodCutterException ex) {
        }
    }

    @Test
    void terseExceptionTest() {
        assertThrows(RodCutterException.class,()->{
            rodCutter.setPrices(prices);
            rodCutter.maxProfit(0);
        });
    }

//    @Test
    void alwaysFail(){
        fail("we should always fail");
    }
}
