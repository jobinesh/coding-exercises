package com.jobinesh.exercise.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis.
 * People must adOPT either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 */
class Animal {
    private String name;
    private int order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getOrder() {
        return order;
    }

    void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}

class Dog extends Animal {

}

class Cat extends Animal {

}

public class AnimalShelter {
    LinkedList<Dog> dogLinkedList = new LinkedList<>();
    LinkedList<Cat> catLinkedList = new LinkedList<>();
    int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        if (animal instanceof Dog) {
            dogLinkedList.add((Dog) animal);
        } else if (animal instanceof Cat) {
            catLinkedList.add((Cat) animal);
        } else {
            //throw new InvalidClassException("Not supported");
        }
        order++;
    }

    public Animal dequeueAny() {
        if (dogLinkedList.isEmpty() && catLinkedList.isEmpty()) {
            return null;
        }
        if (dogLinkedList.isEmpty()) {
            return dequeueCat();
        }
        if (catLinkedList.isEmpty()) {
            return dequeueDog();
        }

        Dog dog = dogLinkedList.peek();
        Cat cat = catLinkedList.peek();
        if (dog.getOrder() < cat.getOrder()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        return dogLinkedList.poll();
    }

    public Cat dequeueCat() {
        return catLinkedList.poll();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AnimalShelter as = new AnimalShelter();
        List<Animal> animalList = Arrays.asList(
                new Dog(), new Cat(), new Dog(), new Cat(), new Dog(), new Cat(),
                new Dog(), new Cat(), new Dog(), new Cat()
        );
        for (Animal animal : animalList)
            as.enqueue(animal);
        System.out.println(as.dequeueAny());
        System.out.println(as.dequeueCat());
        System.out.println(as.dequeueDog());


    }
}
