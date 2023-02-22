package book.fujava;

public class Flying {

    public static void main(String[] args) {
        SeaPlane sp = new SeaPlane(0);
        sp.takeOff();
        sp.turn();
        sp.cruise();
        sp.land();
        SeaPlane sp1 = new SeaPlane(1);
        sp1.takeOff();
        sp1.turn();
        sp1.cruise();
        sp1.land();
    }
}

interface Fly {
    default void takeOff() {
        System.out.println("FLy::takeOff");
    }

    default void land() {
        System.out.println("Fly::land");
    }

    default void turn() {
        System.out.println("Fly::turn");
    }

    default void cruise() {
        System.out.println("Fly::cruise");
    }
}

interface FastFly extends Fly {
    default void takeOff() {
        System.out.println("FastFly::takeOff");
    }
}

interface Sail {
    default void cruise() {
        System.out.println("Sail::cruise");
    }

    default void turn() {
        System.out.println("Sail::turn");
    }
}

class Vehicle {
    public void turn() {
        System.out.println("Vehicle::turn");
    }
}

class SeaPlane extends Vehicle implements FastFly, Sail {
    private int altitude = 1;

    public SeaPlane(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public void cruise() {
        System.out.println("SeaPlane::cruise is currently:");
        if (altitude > 0)
            FastFly.super.cruise();
        else
            Sail.super.cruise();
    }
}

