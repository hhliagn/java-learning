package com.javalearning.demo.test.generics.decorator;

import java.sql.Time;
import java.util.Date;

class Basic{
    private String value;
    public void set(String value){
        this.value = value;
    }
    public String get(){
        return value;
    }
}
class Decorator extends Basic{
    private Basic basic;
    public Decorator(Basic basic){
        this.basic = basic;
    }
    public void set(String value){
        basic.set(value);
    }
    public String get(){
        return basic.get();
    }
}
class TimeStamp extends Decorator{

    public TimeStamp(Basic basic) {
        super(basic);
        timestamp = new Date().getTime();
    }
    private final long timestamp;
    public Long getTimeStamp(){
        return timestamp;
    }

}
class SerialNumbered extends Decorator{

    public SerialNumbered(Basic basic) {
        super(basic);
    }
    private static long counter = 0;
    private final long serialNumber = counter ++;
    public Long getSerialNumber(){
        return serialNumber;
    }
}
public class Decoration {
    public static void main(String[] args) {
        TimeStamp t = new TimeStamp(new Basic());
        TimeStamp t2 = new TimeStamp(new SerialNumbered(new Basic()));
        Long timeStamp = t2.getTimeStamp();
//        t2.getSerialNumber(); //error

        SerialNumbered s = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamp(new Basic()));
        Long serialNumber = s2.getSerialNumber();
//        s2.getTimeStamp(); //error

    }
}
