package book.fujava;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * uses polygon instead:
 * url = https://api.polygon.io/v2/last/nbbo/AAPL?apiKey=*
 * apiKey = _DuE9MNh06l5Z7gpvAOaA_aJditqlZlw
 */
public class YahooFinance {
    public static final String apiKey = "_DuE9MNh06l5Z7gpvAOaA_aJditqlZlw";
    public static final String urlPattern = "https://api.polygon.io/v2/aggs/ticker/%s/prev?apiKey=%s";

    public static BigDecimal getPrice(final String sticker) {
        ObjectMapper om = new ObjectMapper();
        try {
            final URL url = getUrl(sticker);
            double closed = om.readTree(getUrl(sticker)).get("results").get(0).get("c").asDouble();
            return new BigDecimal(closed);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static URL getUrl(final String symbol) throws MalformedURLException {
        return new URL(String.format(urlPattern, symbol.toUpperCase(), apiKey));
    }
}
