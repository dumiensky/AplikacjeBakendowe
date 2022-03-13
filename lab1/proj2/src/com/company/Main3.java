package com.company;

public class Main3 {

    public static void main(String[] args) {
        var array = new int[] { 4, 5, 7, 11, 12, 15, 15, 21, 40, 45 };
        var index = searchIndex(array, 11); // we want to find index for 11

        System.out.println(index);
    }

    public static int searchIndex(int[] array, int value) {
        var index = 0;
        var limit = array.length - 1;
        while (index <= limit) {
            var point = (int)Math.ceil((index + limit) >> 1);
            var entry = array[point];
            if (value > entry) {
                index = point + 1;
                continue;
            }
            if (value < entry) {
                limit = point - 1;
                continue;
            }
            return point; // value == entry
        }
        return -1;
    }
}
