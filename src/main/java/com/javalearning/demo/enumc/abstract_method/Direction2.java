package com.javalearning.demo.enumc.abstract_method;

public enum  Direction2 {

    EAST {
        @Override
        public String printDirection() {
            String message = "You're moving in EAST.";
            System.out.println(message);
            return message;
        }
    },

    NORTH {
        @Override
        public String printDirection() {
            String message = "You're moving in NORTH.";
            System.out.println(message);
            return message;
        }
    },

    WEST {
        @Override
        public String printDirection() {
            String message = "You're moving in WEST.";
            System.out.println(message);
            return message;
        }
    },

    SOUTH {
        @Override
        public String printDirection() {
            String message = "You're moving in SOUTH.";
            System.out.println(message);
            return message;
        }
    };

    public abstract String printDirection();
}
