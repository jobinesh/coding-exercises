package com.jobinesh.exercise.string;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class UrlifierTest extends TestCase {
    @Test
    public void testReplaceSpace() {
        Urlifier urlifier = new Urlifier();
        char[] srcUrl = null;
        char[] trgetUrl = null;
        srcUrl = "Mr John Smith".toCharArray();
        trgetUrl = Arrays.copyOf(srcUrl,  srcUrl.length + 4);
        urlifier.replaceSpace(trgetUrl, 13);
    }
}