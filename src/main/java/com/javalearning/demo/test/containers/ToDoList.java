package com.javalearning.demo.test.containers;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem>{

        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(String item, char primary, int secondary){
            this.item = item;
            this.primary = primary;
            this.secondary = secondary;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary){
                return 1;
            }
            if (primary == o.primary){
                if (secondary > o.secondary){
                    return 1;
                }
                if (secondary == o.secondary){
                    return 0;
                }
                return -1;
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": " + item;
        }
    }

    public void add(String item, char primary, int secondary){
        super.add(new ToDoItem(item, primary, secondary));
    }

    public static void main(String[] args) {
        ToDoList toDoItems = new ToDoList();
        toDoItems.add("Empty trash", 'C', 4);
        toDoItems.add("Free dog", 'A', 2);
        toDoItems.add("Free bird", 'B', 7);
        toDoItems.add("Mow lawn", 'C', 3);
        toDoItems.add("Water lawn", 'A', 1);
        toDoItems.add("Feed cat", 'B', 1);
        while (!toDoItems.isEmpty()){
            System.out.println(toDoItems.remove());
        }
    }
}
