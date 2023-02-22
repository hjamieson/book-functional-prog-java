package book.fujava;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {

    private Function<String, BigDecimal> priceFinder;

    public BigDecimal computeStockWorth(final String ticker, final int shares){
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public CalculateNAV(Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public static void main(String[] args) {
        final CalculateNAV nav = new CalculateNAV(YahooFinance::getPrice);

        System.out.println(nav.computeStockWorth("lmt",100));
        System.out.println(nav.computeStockWorth("goog",100));
    }
}
