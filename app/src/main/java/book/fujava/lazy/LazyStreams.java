package book.fujava.lazy;

import java.util.Arrays;
import java.util.List;

public class LazyStreams {

    private static int length(final String name){
        System.out.println("getting length for " + name);
        return name.length();
    }

    private static String toUpper(final String name){
        System.out.println("converting to uppercase: " + name);
        return name.toUpperCase();
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Brad","Kate","kim","Jack","Joe","Mike","Susan","Gearge","Robert","Julia","Parker","Benson");

        final String firstNameWith3Letters =
                names.stream()
                        .map(name -> toUpper(name))
                        .filter(name -> length(name) == 3)
                        .findFirst()
                        .get();
        System.out.println(firstNameWith3Letters);
    }
}
