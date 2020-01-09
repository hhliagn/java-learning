package com.javalearning.demo.test.typeinfo.toys.RegisteredFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    private static List<Factory<? extends Part>> factories = new ArrayList<>();

    static {
        factories.add(new FuelFilter.factory());
        factories.add(new AirFilter.factory());
        factories.add(new CanbinAirFilter.factory());
        factories.add(new OliFilter.factory());
        factories.add(new FanBelt.factory());
        factories.add(new GeneratorBelt.factory());
        factories.add(new PowerSteeringBelt.factory());
    }

    private static Random random = new Random(47);
    public static Part randomPart(){
        int i = random.nextInt(factories.size());
        Part part = factories.get(i).create();
        return part;
    }
}
