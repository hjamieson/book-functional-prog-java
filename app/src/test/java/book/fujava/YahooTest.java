package book.fujava;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.fail;

public class YahooTest {
    @Test
    void getUrlTest(){
        try {
            var url = YahooFinance.getUrl("pg");
            System.out.println(url);
            assert(url.getPath().contains("PG"));
        } catch (MalformedURLException e) {
            fail(e);
        }
    }

    @Test
    void testRealGET(){
        String symbol = "tsla";
        BigDecimal price = YahooFinance.getPrice(symbol);
        System.out.printf("price for %s = %f %n", symbol, price.doubleValue());
        assert(price.doubleValue() != 0.0);
    }
}
