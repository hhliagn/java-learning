package com.javalearning.demo.test.hoding.ListIteration;

import com.javalearning.demo.test.hoding.ListFeatures.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet());
        pets.add(new Pet());
        pets.add(new Pet());
        pets.add(new Pet());
        pets.add(new Pet());

        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()){
            System.out.print(it.next() + "," + it.nextIndex() + "," + it.previousIndex() + "   ");
        }
        System.out.println();
        while (it.hasPrevious()){
            System.out.print(it.previous() + " ");
        }
        System.out.println();
        System.out.println(pets);

        ListIterator<Pet> itIndex = pets.listIterator(2); //获得一个从索引2开始迭代的迭代器
        while (itIndex.hasNext()){
            itIndex.next();
            itIndex.set(null); //random pet
        }
        System.out.println(pets);
    }
}
