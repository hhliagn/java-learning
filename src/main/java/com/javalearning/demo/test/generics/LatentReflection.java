package com.javalearning.demo.test.generics;

import java.lang.reflect.Method;

class Mime{
    public void walkAgainstTheWind(){

    }
    public void sit(){

    }
    public void pushInvisibleWalls(){

    }

    @Override
    public String toString() {
        return "Mime";
    }
}
class SmartDog{
    public void speak(){
        System.out.println("Woof!");
    }
    public void sit(){
        System.out.println("sitting");
    }
    public void reproduce(){

    }
}
class CommunicateReflectively{
    public static void perform(Object speaker){
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " can not speak");
            }

            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " can not sit");
            }
        }catch (Exception e){
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}
public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new Mime());
        CommunicateReflectively.perform(new SmartDog());
    }
}
