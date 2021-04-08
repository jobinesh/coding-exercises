package com.jobinesh.exercise.cache;

/**
 * Design an in memory cache
 * It should have APIs to update a key with new value
 * It should have APIs to append value to an existing key
 * It can have multiple implementations
 */

/**
 * 1. set(key: string, value:string): void
 * * Sets a key to a string value
 * 2. listPush(key: string, value: string): void
 * * If there is no value at `key`, this should create a new "list" containing the element `value` and store it at `key`.
 * * If there is an existing "list" located at `key`, push a string value onto the head of the "list".
 * 3. get(key: string): Entry
 * * Gets the value of any type out of the data structure.
 * * Return an `Entry` object that abstracts over the possible return types.
 * * Should return null if no value is found for the key.
 * 4. listRemove(key: string, value: string, count: integer): integer
 * * Removes matching values from a "list".
 * * If count == 0, delete all entries where `value == listEntry` from the list.
 * * If count > 0, delete the first `count` entries where `value == listEntry`.
 * * If count < 0, delete the last `count` entries where `value == listEntry`.
 * 5. expire(key: string, time: integer): bool
 * * Expires a key (value returns as null) after `time` in seconds has elapsed from when expire was called on the key.
 * * Subsequent calls to expire should override previous calls.
 * * Calling with a negative time should cancel any previous expire call.
 * * Mutating a key assignment in any way should cancel any previous expire calls on that key.
 */

interface Cache {
    void set(String key, String vaue);

    void listPush(String key, String value);

    Entry get(String key);

    int listRemove(String key, String value, int count);

    boolean expire(String key, int time);
}

class Entry {

}

public class SimpleCache implements Cache {
    @Override
    public void set(String key, String vaue) {

    }

    @Override
    public void listPush(String key, String value) {

    }

    @Override
    public Entry get(String key) {
        return null;
    }

    @Override
    public int listRemove(String key, String value, int count) {
        return 0;
    }

    @Override
    public boolean expire(String key, int time) {
        return false;
    }
}