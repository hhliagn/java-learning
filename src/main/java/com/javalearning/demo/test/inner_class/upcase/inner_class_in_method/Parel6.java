package com.javalearning.demo.test.inner_class.upcase.inner_class_in_method;

public class Parel6 {
    private String internalTracking(boolean b){
        if (b){
            class TrackingSlip {
                private String id;

                private TrackingSlip(String id) {
                    this.id = id;
                }

                public String get() {
                    return id;
                }
            }
            TrackingSlip trackingSlip = new TrackingSlip("slip");
            return trackingSlip.get();
        }
        return "";
    }
    public String track(boolean b){
        return internalTracking(b);
    }

    public static void main(String[] args) {
        Parel6 parel6 = new Parel6();
        System.out.println(parel6.track(true));
    }
}
