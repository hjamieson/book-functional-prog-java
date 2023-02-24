package book.fujava.heavy;

import java.util.function.Supplier;

public class Holder {
    private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

    public Holder() {
        System.out.println("holder created");
    }

    public Heavy getHeavy(){
        return heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy(){
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();

            public Heavy get(){
                return heavyInstance;
            }
        }

        if (!HeavyFactory.class.isInstance(heavy)){
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }
}
