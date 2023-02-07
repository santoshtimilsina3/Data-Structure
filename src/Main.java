import jdk.nashorn.internal.runtime.arrays.TypedArrayData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 7, 9, 2};
        int total = 11;
        int size = array.length;
        ArrayList<Integer> bruteForce = bruteForce(array, total);
        System.out.println(bruteForce);
        ArrayList<Integer> optimalWay = optimalWay(array, total);
        System.out.println(optimalWay);
    }

    //        most time-consuming and not optimal way
    private static ArrayList<Integer> bruteForce(int[] array, int total) {
        ArrayList<Integer> answer = new ArrayList<>();
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (array[i] + array[j] == total) {
                    answer.add(i);
                    answer.add(j);
                    break;
                }
            }
        }
        return answer;
    }

    private static ArrayList<Integer> optimalWay(int[] array, int total) {
        if (array.length == 0) {
            return null;
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int size = array.length;
//        int[] array = {1, 3, 7, 9, 2};
        Hashtable<Integer, Integer> set = new Hashtable();
        for (int i = 0; i < size; i++) {
            int sum = total - array[i];
            set.put(sum, i);
            if (set.containsValue(array[i])) {
                answer.add(set.get(array[i]));
                answer.add(i);
                break;
            }
        }
        return answer;
    }
}