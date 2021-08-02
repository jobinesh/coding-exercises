package com.jobinesh.exercise.junk;

import java.util.ArrayList;
import java.util.List;

public class Dog<T  extends Animal> extends  AbstractDog {
    public Dog(String name) {
        super(name);
    }

    @Override
    public T match() {
        return null;
    }
    public static <U extends Object> void printList(List<U> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }
    public List<T> getAllMatches(){
        return null;
    }
   static void foo(List<?> i) {
        //i.set(0,"");
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        printList(list);
    }
}
