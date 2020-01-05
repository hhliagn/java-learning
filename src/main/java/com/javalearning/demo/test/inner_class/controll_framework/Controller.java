package com.javalearning.demo.test.inner_class.controll_framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event event){
        eventList.add(event);
    }
    public void run(){
        while (eventList.size() > 0){
//            Iterator<Event> iterator = eventList.iterator();
            int size = eventList.size();
            for (int i = 0; i < size; i++) {
                Event event = eventList.get(i);
                if (event.ready()){
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                    i --;
                }
            }
        }
    }
}
