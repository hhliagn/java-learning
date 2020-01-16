package com.javalearning.demo.test.generics;

import java.util.Date;

interface Basic{
    void set(String value);
    String get();
}
class BasicImpl implements Basic {
    private String value;
    public void set(String value){
        this.value = value;
    }
    public String get(){
        return value;
    }
}
interface TimeStamp{
    Long getTimeStamp();
}
class TimeStampImpl implements TimeStamp{
    private final long timestamp;
    public TimeStampImpl(){
        timestamp = new Date().getTime();
    }
    public Long getTimeStamp(){
        return timestamp;
    }
}
interface SerialNumbered{
    Long getSerialNumber();
}
class SerialNumberedImpl implements SerialNumbered{
    private static long counter = 0;
    private final long serialNumber = counter ++;
    public Long getSerialNumber(){
        return serialNumber;
    }
}
class Mixin extends BasicImpl implements TimeStamp, SerialNumbered{
    private SerialNumbered serialNumbered = new SerialNumberedImpl();
    private TimeStamp timeStamp = new TimeStampImpl();

    @Override
    public Long getTimeStamp() {
        return timeStamp.getTimeStamp();
    }

    @Override
    public Long getSerialNumber() {
        return serialNumbered.getSerialNumber();
    }
}
public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " + mixin1.getTimeStamp() + " " + mixin1.getSerialNumber());
        System.out.println(mixin2.get() + " " + mixin2.getTimeStamp() + " " + mixin2.getSerialNumber());
    }
}
