package com.javalearning.demo.test.enumerated;

enum Search{
    HITHER, YON
}
public class UpcastEnum {

    public static void main(String[] args) {
        Search yon = Search.YON;
        for (Search value : Search.values()) {
            System.out.println(value);
        }

        System.out.println("------------------");

        Enum enu = yon;
        for (Enum enumConstant : enu.getClass().getEnumConstants()) {
            System.out.println(enumConstant);
        }
    }
}
