package com.javalearning.demo.test.inner_class.test5;

public class World {
    private Living findLivingCreature(boolean b){
        if (b){
            class Character implements Living{

                @Override
                public void live() {
                    System.out.println("Character live");
                }

                @Override
                public String toString() {
                    return "Character";
                }
            }
            return new Character();
        }
//        return new Character(); //不在作用域内，不能再创建。
        return null;
    }

    public Living find(boolean b){
        return findLivingCreature(b);
    }

    public static void main(String[] args) {
        World world = new World();
        Living livingCreature = world.find(true);
        System.out.println(livingCreature);
    }
}
