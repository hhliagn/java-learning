package com.javalearning.demo.test.DrawingSys;

public class TestDrawAndSwap {
    public static void main(String[] args) {
        CADSystem cadSystem = new CADSystem(1);
        try {
            //catch something exception..
        }finally {
            //dispose：消失
            cadSystem.dispose();
        }
    }
}
