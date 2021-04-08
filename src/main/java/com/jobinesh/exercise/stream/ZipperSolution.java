package com.jobinesh.exercise.stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.*;
import java.util.function.Consumer;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *
 * For the sake of this exercise, Zip is an operation over two or more ordered
 * collections that combines the elements at a common position into a n-tuple,
 * where n is the number of collections, and creates an iterator over those n-tuples.
 *
 * inputs:
 * listA := {1, 3, 5}
 * listB := {2, 4, 6}
 *
 * output:
 * iteratorAB := zip(listA, listB) // {(1, 2), (3, 4), (5, 6)}
 * iteratorAB.next() //(1,2)
 * iteratorAB.next() //(3,4)
 * iteratorAB.next() //(5,6)
 * iteratorAB.hasNext() // false
 *
 * Implement zip and unzip for lists over the Tuple class how you see fit.  One possibility is outlined below.
 * The Zipper class takes in two lists in its constructor, and its zip method
 * should return a new iterator over those lists each time its called.
 * The Unzipper class takes a Zipper and returns two iterables.
 */

class Zipper<A, B> implements Iterable<Tuple<A, B>> {
    private List<A> list1;
    private List<B> list2;

    public Zipper(List<A> list1, List<B> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    @Override
    public Iterator<Tuple<A, B>> iterator() {

        return zip();
    }


    public Iterator zip() {
        Iterator<A> iteratorList1 = list1.iterator();
        Iterator<B> iteratorList2 = list2.iterator();
        Iterator<Tuple> iter = new Iterator<Tuple>() {
            @Override
            public boolean hasNext() {
                return iteratorList1.hasNext() && iteratorList2.hasNext();
            }

            @Override
            public Tuple<A, B> next() {
                Tuple<A, B> tuple = new Tuple<A, B>(iteratorList1.next(), iteratorList2.next());
                return tuple;
            }
        };
        return iter;
    }

}

class SimpleIterable<T> implements Iterable<T>{
    private Iterator iterator;

    public SimpleIterable(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }

}
class UnZipper<A, B> {
    private Iterable<Tuple<A, B>> iterable;

    public UnZipper(Iterable<Tuple<A, B>> iterable) {
        this.iterable = iterable;
    }

    public Tuple<Iterable<A>,Iterable<B>> unzip(){
        Iterator<Tuple<A,B>> iterable1 = iterable.iterator();
        Iterator<Tuple<A,B>> iterable2 = iterable.iterator();

        Iterator<A> iterItem1 = new Iterator<A>() {
            @Override
            public boolean hasNext() {
                return iterable1.hasNext();
            }

            @Override
            public A next() {
                return iterable1.next().getItem1();
            }
        };

        Iterator<B> iterItem2 = new Iterator<B>(){
            @Override
            public B next(){
                return iterable2.next().getItem2();
            }
            @Override
            public boolean hasNext(){
                return iterable2.hasNext();
            }
        };
        Tuple<Iterable<A>,Iterable<B>> iter = new Tuple( new SimpleIterable<A>(iterItem1),
                new SimpleIterable<B>(iterItem2));
        return iter;
    }

}

class Tuple<A, B> {
    private A item1;
    private B item2;

    public Tuple(A item1, B item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public A getItem1() {
        return item1;
    }

    public void setItem1(A item1) {
        this.item1 = item1;
    }

    public B getItem2() {
        return item2;
    }

    public void setItem2(B item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "value1=" + item1 +
                ", value2=" + item2 +
                '}';
    }
}

public class ZipperSolution {

    @Test
    public void testZipWithTwoIntListsIterator() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        Zipper<Integer, Integer> zipper = new Zipper<Integer, Integer>(list1, list2);
        Iterator<Tuple<Integer, Integer>> iterator = zipper.zip();
        int count = 0;
        while (iterator.hasNext()) {
            Tuple tuple = iterator.next();
            System.out.println(tuple);
            count++;
        }
        Assert.assertEquals(list1.size(), count);
    }
    @Test
    public void testUnZipWithTwoIntListsIterator() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        Zipper<Integer, Integer> zipper = new Zipper<Integer, Integer>(list1, list2);
        UnZipper<Integer, Integer> unzipper = new UnZipper<Integer, Integer>(zipper);
        Tuple<Iterable<Integer>,Iterable<Integer>> tuple = unzipper.unzip();
        Iterator<Integer>  iter1 = tuple.getItem1().iterator();
        Iterator<Integer>  iter2 = tuple.getItem2().iterator();
        int cnt1 = 0;
        int cnt2 = 0;
        while(iter1.hasNext()){
            iter1.next();
            cnt1++;
        }
        while(iter2.hasNext()){
            iter2.next();
            cnt2++;
        }
        Assert.assertArrayEquals(new int[]{3,3}, new int[]{cnt1,cnt2});
    }

    public static void main(String[] args) {

        JUnitCore.main(ZipperSolution.class.getName());
    }
}