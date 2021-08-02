package com.jobinesh.exercise.junk;

public interface Animal<T extends Animal> {
   T match();
}
