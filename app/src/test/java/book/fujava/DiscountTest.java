package book.fujava;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {
    private final List<BigDecimal> prices = Arrays.asList(
         new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
         new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
         new BigDecimal("45"), new BigDecimal("12")
    );

    @Test
    void testImperativeSum(){
        assertEquals(BigDecimal.valueOf(67.5), Discount.by10(prices));
    }
    @Test
    void testfuncSum(){
        assertEquals(Discount.by10(prices), Discount.by102(prices));
    }


}
