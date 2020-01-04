package com.javalearning.demo.test.hoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Powder(), new Crusty(), new Slush()
        );
        List<Snow> snow2 = Arrays.asList(
                new Heavy(), new Light()
        );
        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3, new Heavy(), new Light());
        List<Snow> snow4 = Arrays.<Snow>asList(new Heavy(), new Light());
    }
}
