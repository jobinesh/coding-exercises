package com.jobinesh.exercise.array;

/**
 * You are given given a list of rectangles represented by min and max x- and y-coordinates.
 * Compute whether or not a pair of rectangles overlap each other.
 * If one rectangle completely covers another, it is considered overlapping.
 * For example, given the following rectangles:
 * <p>
 * {
 * "top_left": (1, 4),
 * "dimensions": (3, 3) # width, height
 * },
 * {
 * "top_left": (-1, 3),
 * "dimensions": (2, 1)
 * },
 * {
 * "top_left": (0, 5),
 * "dimensions": (4, 3)
 * }
 * return true as the first and third rectangle overlap each other.
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1topleft, int[] rec1dim, int[] rec2topleft, int[] rec2dim) {
        return isOverlapping(rec1topleft[0], rec1topleft[1], rec1dim[0], rec1dim[1],
                rec2topleft[0], rec2topleft[1], rec2dim[0], rec2dim[1]);
    }

    private boolean isOverlapping(int rect1x1, int rect1y1, int rect1width, int rect1ht1,
                                  int rect2x1, int rect2y1, int rect2width, int rect2ht1) {
        if (rect1x1 < rect2x1 && rect1x1 + rect1width <= rect2x1) {
            return false;
        }
        if (rect1y1 < rect2y1 && rect1y1 + rect1ht1 <= rect2y1) {
            return false;
        }

        if (rect2x1 < rect1x1 && rect2x1 + rect2width <= rect1x1) {
            return false;
        }
        if (rect2y1 < rect1y1 && rect2y1 + rect2ht1 <= rect1y1) {
            return false;
        }
        return true;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec2[0] == rec2[2] || rec1[1] == rec1[3] || rec2[1] == rec2[3]) {
            return false;
        }

        if (rec1[0] < rec2[0] && rec1[2] <= rec2[0]) {
            return false;
        }
        if (rec1[1] < rec2[1] && rec1[3] <= rec2[1]) {
            return false;
        }

        if (rec2[0] < rec1[0] && rec2[2] <= rec1[0]) {
            return false;
        }
        if (rec2[1] < rec1[1] && rec2[3] <= rec1[1]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(new RectangleOverlap().isRectangleOverlap(new int[]{1, 4}, new int[]{3, 3}, new int[]{3, 6}, new int[]{4, 3}));
        boolean overlap = new RectangleOverlap().isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3});
        System.out.println(overlap);
    }
}
