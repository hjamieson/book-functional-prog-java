package book.fujava;

import java.math.BigDecimal;
import java.util.List;

public class Discount {
    public static BigDecimal by10(final List<BigDecimal> prices){
        BigDecimal totalDiscountedPrices = BigDecimal.ZERO;

        for (BigDecimal price: prices){
            if (price.compareTo(BigDecimal.valueOf(20))> 0){
                totalDiscountedPrices = totalDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        return totalDiscountedPrices;
    }

    public static BigDecimal by102(final List<BigDecimal> prices){
        return prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20))>0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
